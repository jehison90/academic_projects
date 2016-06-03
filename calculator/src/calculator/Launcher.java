/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import calculator.model.DefaultModel;

/**
 *
 * @author Jehison
 */
public class Launcher {

    private DefaultModel model;

    public Launcher() {
        getModel().initialize();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        new Launcher();        
    }

    /**
     * @return the model
     */
    public DefaultModel getModel() {
        if(model == null){
            model = new DefaultModel();
        }
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(DefaultModel model) {
        this.model = model;
    }
    
}
