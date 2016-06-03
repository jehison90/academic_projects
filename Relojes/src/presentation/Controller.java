/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import logica.Point;

/**
 *
 * @author Jehison
 */
class Controller implements MouseListener, ActionListener{
    private final View view;
    private Model model;

    public Controller(View v) {
        view = v;
        model = v.getModelo();
    }

    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(view.getAnalogicalButton())){
            model.instantiateAnalogicalClock(new Point(220, 220), 440);
        }    
        if(e.getSource().equals(view.getDigitalButton())){
            model.instantiateDigitalClock();
        } 
    }
    
}
