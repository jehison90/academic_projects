
package presentacion;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import logica.Bolita;
import logica.Tablero;

/**
 *
 * @author estudiantes
 */
public class Modelo implements Runnable{

    private VentanaInicial ventana;
    private Tablero tablero;
    private Thread hiloDibujo;
    private Canvas lienzo;
    private BufferedImage dobleBuffer;
    //----------------------
    private boolean tenerEnCuentaClicks;
    private boolean clickPosicion;

    public Modelo() {                
        lienzo = getVentana().getLienzo();
        dobleBuffer = new BufferedImage(lienzo.getWidth(), lienzo.getHeight(), BufferedImage.TYPE_INT_ARGB);
        hiloDibujo = new Thread(this);
    }

    
    public VentanaInicial getVentana() {
        if (ventana == null){
            ventana = new VentanaInicial(this);
            ventana.getBtnPausa().setEnabled(false);
        }
        return ventana;
    }

    public Tablero getTablero() {
        if(tablero == null){
            tablero = new Tablero();
        }
        return tablero;
    }
    
    
    //----------------------
    public void iniciar() {
        getVentana().setSize(750, 550);
        getVentana().setResizable(false);
        getVentana().setVisible(true);
        hiloDibujo.start();
    }

    @Override
    public void run() {
        while(getTablero().isActivado()){
            dibujarConDobleBuffer();
        }
    }

    private void dibujarConDobleBuffer() {
        Graphics lapizDobleBuffer = dobleBuffer.getGraphics();
        Graphics lapizLienzo = lienzo.getGraphics();
        dibujar(lapizDobleBuffer);
        lapizLienzo.drawImage(dobleBuffer, 0, 0, lienzo);
    }

    private void dibujar(Graphics lapiz) {
        // limpiar superficie de dibujo
        lapiz.setColor(Color.BLACK);
        lapiz.fillRect(0, 0, lienzo.getWidth(), lienzo.getHeight());
        // el dibujo del tablero
        dibujarTablero(lapiz);
    }

    public void agregarCoordenadaBolita(int x, int y) {
        // hago click en el canvas
        if(tenerEnCuentaClicks){            
            if(clickPosicion){
                getTablero().crearNuevaBolita(x, y);
                getTablero().getNuevaBolita().setLimiteDerecho(lienzo.getWidth());
                getTablero().getNuevaBolita().setLimiteInferior(lienzo.getHeight());
                clickPosicion = false;
                getVentana().getLblMensaje().setText("Ahora haz click en el área de dibujo para establecer hacia donde se digirirá el movimiento.");
            }else{
                if(x >= getTablero().getNuevaBolita().getPosX()){
                    getTablero().getNuevaBolita().setIncrementoX(1);
                }else{
                    getTablero().getNuevaBolita().setIncrementoX(-1);
                }
                
                if(y >= getTablero().getNuevaBolita().getPosY()){
                    getTablero().getNuevaBolita().setIncrementoY(1);
                }else{
                    getTablero().getNuevaBolita().setIncrementoY(-1);                    
                }
                tenerEnCuentaClicks = false;
                getVentana().getBtnAgregarBolita().setEnabled(true);
                getTablero().getNuevaBolita().iniciarMovimiento();
                getTablero().adicionarBolita();
                getVentana().getLblMensaje().setText("");
                getVentana().getLblNumeroBolas().setText(""+getTablero().getListadoBolitas().size());
                ventana.getBtnPausa().setEnabled(true);
            }            
        }        
    }

    public void agregarBolita() {
        // Hago click en el boton
        tenerEnCuentaClicks = true;
        clickPosicion = true;
        getVentana().getBtnAgregarBolita().setEnabled(false);
        getVentana().getLblMensaje().setText("Haz click en el área de dibujo para establecer la coordenada de inicio...");
    }
    
    
    private void dibujarTablero(Graphics lapiz) {
        int bolas = getTablero().getListadoBolitas().size();
        int iBola;
        for(iBola = 0; iBola < bolas; iBola++){
            Bolita b = (Bolita) getTablero().getListadoBolitas().get(iBola);
            lapiz.setColor(b.getColor());
            lapiz.fillOval(b.getPosX(), b.getPosY(), b.getDiametro(), b.getDiametro());
        }       
        
    }    

    public void controlarMovimiento(String accion) {
        if(accion.equals("Pausar")){
            getTablero().pausarMovimiento();
            getVentana().getBtnPausa().setText("Continuar");
        }else{
            getTablero().activarMovimiento();
            getVentana().getBtnPausa().setText("Pausar");
        }
    }
}
