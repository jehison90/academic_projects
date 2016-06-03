/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author estudiantes
 */
class Controlador implements MouseListener, ActionListener{
    private final VentanaInicial ventana;
    private final Modelo modelo;

    public Controlador(VentanaInicial aThis) {
        ventana = aThis;
        modelo = ventana.getModelo();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        modelo.agregarCoordenadaBolita(me.getX(), me.getY());
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Click en el boton
        JButton boton = (JButton)ae.getSource();
        if(boton.equals(ventana.getBtnAgregarBolita())){
            modelo.agregarBolita();
        }else{
            modelo.controlarMovimiento(boton.getText());
        }
    }
    
}
