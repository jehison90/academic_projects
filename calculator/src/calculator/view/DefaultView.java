/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.view;

import calculator.controller.DefaultController;
import calculator.model.DefaultModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jehison
 */
public class DefaultView extends JFrame{
    
    private DefaultController controller;
    private JPanel panel;
    private JTextField display;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button0;
    private JButton buttonPlus;
    private JButton buttonLess;
    private JButton buttonTimes;
    private JButton buttonInto;
    private JButton buttonResult;
    
    private DefaultModel model;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public DefaultView(DefaultModel model) {
        this.model = model;
        this.setLayout(null);
        this.add(getPanel());
        this.setSize(getPanel().getSize().width, getPanel().getSize().height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    /**
     * @return the panel
     */
    public JPanel getPanel() {
        if(panel == null){
            panel = new JPanel();
            panel.setLayout(null);
            panel.setBounds(10,5,250,350);
            panel.add(getButton1());            
            panel.add(getButton2());            
            panel.add(getButton3());            
            panel.add(getButton4());            
            panel.add(getButton5());            
            panel.add(getButton6());            
            panel.add(getButton7());            
            panel.add(getButton8());            
            panel.add(getButton9());            
            panel.add(getButton0());            
            panel.add(getButtonPlus());            
            panel.add(getButtonLess());            
            panel.add(getButtonTimes());            
            panel.add(getButtonInto());
            panel.add(getButtonResult());
            panel.add(getDisplay());            
        }
        return panel;
    }

    /**
     * @param panel the panel to set
     */
    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    /**
     * @return the display
     */
    public JTextField getDisplay() {
        if(display == null){
            display = new JTextField();
            display.setBounds(0,10,215,40);   
            display.setEditable(false);
        }
        
        return display;
    }

    /**
     * @param display the display to set
     */
    public void setDisplay(JTextField display) {
        this.display = display;
    }

    /**
     * @return the button1
     */
    public JButton getButton1() {
        if(button1 == null){
            button1 = new JButton();
            button1.setBounds(0,80,50,50);
            button1.setText("1");
            button1.addActionListener(getController());
        }

        return button1;
    }

    /**
     * @param button1 the button1 to set
     */
    public void setButton1(JButton button1) {
        this.button1 = button1;
    }

    /**
     * @return the button2
     */
    public JButton getButton2() {
        if(button2 == null){
            button2 = new JButton();
            button2.setBounds(55,80,50,50);
            button2.setText("2");
            button2.addActionListener(getController());
        }
        return button2;
    }

    /**
     * @param button2 the button2 to set
     */
    public void setButton2(JButton button2) {
        this.button2 = button2;
    }

    /**
     * @return the button3
     */
    public JButton getButton3() {
        if(button3 == null){
            button3 = new JButton();
            button3.setBounds(110,80,50,50);
            button3.setText("3");
            button3.addActionListener(getController());
        }
        return button3;
    }

    /**
     * @param button3 the button3 to set
     */
    public void setButton3(JButton button3) {
        this.button3 = button3;
    }

    /**
     * @return the button4
     */
    public JButton getButton4() {
        if(button4 == null){
            button4 = new JButton();
            button4.setBounds(0,135,50,50);
            button4.setText("4");
            button4.addActionListener(getController());
        }
        return button4;
    }

    /**
     * @param button4 the button4 to set
     */
    public void setButton4(JButton button4) {
        this.button4 = button4;
    }

    /**
     * @return the button5
     */
    public JButton getButton5() {
        if(button5 == null){
            button5 = new JButton();
            button5.setBounds(55,135,50,50);
            button5.setText("5");
            button5.addActionListener(getController());
        }
        return button5;
    }

    /**
     * @param button5 the button5 to set
     */
    public void setButton5(JButton button5) {
        this.button5 = button5;
    }

    /**
     * @return the button6
     */
    public JButton getButton6() {
        if(button6 == null){
            button6 = new JButton();
            button6.setBounds(110,135,50,50);
            button6.setText("6");
            button6.addActionListener(getController());
        }
        return button6;
    }

    /**
     * @param button6 the button6 to set
     */
    public void setButton6(JButton button6) {
        this.button6 = button6;
    }

    /**
     * @return the button7
     */
    public JButton getButton7() {
        if(button7 == null){
            button7 = new JButton();
            button7.setBounds(0,190,50,50);
            button7.setText("7");
            button7.addActionListener(getController());
        }
        return button7;
    }

    /**
     * @param button7 the button7 to set
     */
    public void setButton7(JButton button7) {
        this.button7 = button7;
    }

    /**
     * @return the button8
     */
    public JButton getButton8() {
        if(button8 == null){
            button8 = new JButton();
            button8.setBounds(55,190,50,50);
            button8.setText("8");
            button8.addActionListener(getController());
        }
        return button8;
    }

    /**
     * @param button8 the button8 to set
     */
    public void setButton8(JButton button8) {
        this.button8 = button8;
    }

    /**
     * @return the button9
     */
    public JButton getButton9() {
        if(button9 == null){
            button9 = new JButton();
            button9.setBounds(110,190,50,50);
            button9.setText("9");
            button9.addActionListener(getController());
        }
        return button9;
    }

    /**
     * @param button9 the button9 to set
     */
    public void setButton9(JButton button9) {
        this.button9 = button9;
    }

    /**
     * @return the button0
     */
    public JButton getButton0() {
        if(button0 == null){
            button0 = new JButton();
            button0.setBounds(0,245,105,50);
            button0.setText("0");
            button0.addActionListener(getController());
        }
        return button0;
    }

    /**
     * @param button0 the button0 to set
     */
    public void setButton0(JButton button0) {
        this.button0 = button0;
    }

    /**
     * @return the buttonPlus
     */
    public JButton getButtonPlus() {
        if(buttonPlus == null){
            buttonPlus = new JButton();
            buttonPlus.setBounds(165,80,50,50);
            buttonPlus.setText("+");
            buttonPlus.addActionListener(getController());
        }
        return buttonPlus;
    }

    /**
     * @param buttonPlus the buttonPlus to set
     */
    public void setButtonPlus(JButton buttonPlus) {
        this.buttonPlus = buttonPlus;
    }

    /**
     * @return the buttonLess
     */
    public JButton getButtonLess() {
        if(buttonLess == null){
            buttonLess = new JButton();
            buttonLess.setBounds(165,135,50,50);
            buttonLess.setText("-");
            buttonLess.addActionListener(getController());
        }
        return buttonLess;
    }

    /**
     * @param buttonLess the buttonLess to set
     */
    public void setButtonLess(JButton buttonLess) {
        this.buttonLess = buttonLess;
    }

    /**
     * @return the buttonTimes
     */
    public JButton getButtonTimes() {
        if(buttonTimes == null){
            buttonTimes = new JButton();
            buttonTimes.setBounds(165,190,50,50);
            buttonTimes.setText("X");
            buttonTimes.addActionListener(getController());
        }
        return buttonTimes;
    }

    /**
     * @param buttonTimes the buttonTimes to set
     */
    public void setButtonTimes(JButton buttonTimes) {
        this.buttonTimes = buttonTimes;
    }

    /**
     * @return the buttonInto
     */
    public JButton getButtonInto() {
        if(buttonInto == null){
            buttonInto = new JButton();
            buttonInto.setBounds(165,245,50,50);
            buttonInto.setText("/");
            buttonInto.addActionListener(getController());
        }
        return buttonInto;
    }
    
    /**
     * @param buttonResult the buttonResult to set
     */
    public void setButtonResult(JButton buttonResult) {
        this.buttonResult = buttonResult;
    }
    
        /**
     * @return the buttonResult
     */
    public JButton getButtonResult() {
        if(buttonResult == null){
            buttonResult = new JButton();
            buttonResult.setBounds(110,245,50,50);
            buttonResult.setText("=");
            buttonResult.addActionListener(getController());
        }
        return buttonResult;
    }    

    /**
     * @param buttonInto the buttonInto to set
     */
    public void setButtonInto(JButton buttonInto) {
        this.buttonInto = buttonInto;
    }

    /**
     * @return the controller
     */
    public DefaultController getController() {
        if(controller == null){
            controller = new DefaultController(this);
        }
        return controller;
    }

    /**
     * @param controller the controller to set
     */
    public void setController(DefaultController controller) {
        this.controller = controller;
    }

    /**
     * @return the model
     */
    public DefaultModel getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(DefaultModel model) {
        this.model = model;
    } 
    
}
