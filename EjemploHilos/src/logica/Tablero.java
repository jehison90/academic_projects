/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author estudiantes
 */
public class Tablero {
    private boolean activado;
    private ArrayList listadoBolitas;
    private Bolita nuevaBolita;
    private boolean pausado;

    public Tablero() {
        listadoBolitas = new ArrayList();
        activado = true;
        pausado = false;
    }
    
    public boolean isActivado() {
        return activado;
    }    

    public void setActivado(boolean activado) {
        this.activado = activado;
    }
    
    public void adicionarBolita(){
        listadoBolitas.add(nuevaBolita);
        nuevaBolita = null;
    }
    
    public void crearNuevaBolita(int x, int y){
        nuevaBolita = new Bolita();
        nuevaBolita.setPosX(x);
        nuevaBolita.setPosY(y);
    }

    public Bolita getNuevaBolita() {
        return nuevaBolita;
    }

    public ArrayList getListadoBolitas() {
        return listadoBolitas;
    }
    
    public void pausarMovimiento(){
        int bolas = getListadoBolitas().size();
        int iBola;
        for (iBola = 0; iBola < bolas; iBola++) {
            Bolita b = (Bolita) getListadoBolitas().get(iBola);
            b.setPausado(true);
        }
    }
    
    public void activarMovimiento(){
        int bolas = getListadoBolitas().size();
        int iBola;
        for (iBola = 0; iBola < bolas; iBola++) {
            Bolita b = (Bolita) getListadoBolitas().get(iBola);
            b.setPausado(false);
        }
    }
    
}
