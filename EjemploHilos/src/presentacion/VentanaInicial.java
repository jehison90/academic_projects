/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.awt.Canvas;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author estudiantes
 */
public class VentanaInicial extends javax.swing.JFrame {
    private final Modelo modelo;
    private Controlador control;
    /**
     * Creates new form VentanaInicial
     */
    public VentanaInicial(Modelo aThis) {
        modelo = aThis;
        initComponents();
        capturarEventos();
    }

    public Modelo getModelo() {
        return modelo;
    }

    public Controlador getControl() {
        if(control == null){
            control = new Controlador(this);
        }
        return control;
    }

    public Canvas getLienzo() {
        return lienzo;
    }

    public JButton getBtnAgregarBolita() {
        return btnAgregarBolita;
    }

    public JLabel getLblMensaje() {
        return lblMensaje;
    }

    public JLabel getLblNumeroBolas() {
        return lblNumeroBolas;
    }

    public JButton getBtnPausa() {
        return btnPausa;
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lienzo = new java.awt.Canvas();
        btnAgregarBolita = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblNumeroBolas = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        btnPausa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(lienzo);
        lienzo.setBounds(10, 60, 710, 400);

        btnAgregarBolita.setText("Agregar");
        getContentPane().add(btnAgregarBolita);
        btnAgregarBolita.setBounds(10, 470, 350, 40);

        jLabel1.setText("Bolas");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(590, 10, 50, 40);

        lblNumeroBolas.setBackground(java.awt.Color.black);
        lblNumeroBolas.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblNumeroBolas.setForeground(java.awt.Color.orange);
        lblNumeroBolas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumeroBolas.setText("0");
        lblNumeroBolas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblNumeroBolas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblNumeroBolas.setOpaque(true);
        getContentPane().add(lblNumeroBolas);
        lblNumeroBolas.setBounds(640, 10, 80, 40);

        lblMensaje.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        getContentPane().add(lblMensaje);
        lblMensaje.setBounds(10, 10, 550, 40);

        btnPausa.setText("Pausar");
        getContentPane().add(btnPausa);
        btnPausa.setBounds(370, 470, 350, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarBolita;
    private javax.swing.JButton btnPausa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblNumeroBolas;
    private java.awt.Canvas lienzo;
    // End of variables declaration//GEN-END:variables

    private void capturarEventos() {
        lienzo.addMouseListener(getControl());
        btnAgregarBolita.addActionListener(getControl());
        btnPausa.addActionListener(getControl());
    }
}