/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.controller;

import calculator.logic.OperationTypeUtils;
import calculator.view.DefaultView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Jehison
 */
public class DefaultController implements ActionListener {

    DefaultView view;

    public DefaultController(DefaultView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (((JButton) ae.getSource()).equals(view.getButton1())) {
            view.getModel().insertNumber("1");
        }
        if (((JButton) ae.getSource()).equals(view.getButton2())) {
            view.getModel().insertNumber("2");
        }
        if (((JButton) ae.getSource()).equals(view.getButton3())) {
            view.getModel().insertNumber("3");
        }
        if (((JButton) ae.getSource()).equals(view.getButton4())) {
            view.getModel().insertNumber("4");
        }
        if (((JButton) ae.getSource()).equals(view.getButton5())) {
            view.getModel().insertNumber("5");
        }
        if (((JButton) ae.getSource()).equals(view.getButton6())) {
            view.getModel().insertNumber("6");
        }
        if (((JButton) ae.getSource()).equals(view.getButton7())) {
            view.getModel().insertNumber("7");
        }
        if (((JButton) ae.getSource()).equals(view.getButton8())) {
            view.getModel().insertNumber("8");
        }
        if (((JButton) ae.getSource()).equals(view.getButton9())) {
            view.getModel().insertNumber("9");
        }
        if (((JButton) ae.getSource()).equals(view.getButton0())) {
            view.getModel().insertNumber("0");
        }
        if (((JButton) ae.getSource()).equals(view.getButtonPlus())) {            
            view.getModel().setCalculatorOperation(OperationTypeUtils.OPERATION_ADD);
            view.getModel().saveValueAfterSelectOperation(view.getDisplay().getText());
            view.getModel().calculateResult();
        }
        if (((JButton) ae.getSource()).equals(view.getButtonLess())) {            
            view.getModel().setCalculatorOperation(OperationTypeUtils.OPERATION_LESS);
            view.getModel().saveValueAfterSelectOperation(view.getDisplay().getText());
            view.getModel().calculateResult();
        }
        if (((JButton) ae.getSource()).equals(view.getButtonTimes())) {            
            view.getModel().setCalculatorOperation(OperationTypeUtils.OPERATION_TIMES);
            view.getModel().saveValueAfterSelectOperation(view.getDisplay().getText());
            view.getModel().calculateResult();
        }
        if (((JButton) ae.getSource()).equals(view.getButtonInto())) {            
            view.getModel().setCalculatorOperation(OperationTypeUtils.OPERATION_INTO);
            view.getModel().saveValueAfterSelectOperation(view.getDisplay().getText());
            view.getModel().calculateResult();
            view.getModel().validateZeroDivisionError();
        }
        if (((JButton) ae.getSource()).equals(view.getButtonResult())) {            
            view.getModel().saveSecondCalculatorValue(view.getDisplay().getText());
            view.getModel().calculateResult();
            view.getModel().resetValues();
            view.getModel().validateZeroDivisionError();
        }
    }

}
