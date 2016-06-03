package calculator.model;

import calculator.logic.Calculator;
import calculator.logic.OperationTypeUtils;
import calculator.view.DefaultView;

/**
 *
 * @author Jehison
 */
public class DefaultModel {

    private DefaultView defaultView;

    private Calculator calculator;

    private boolean firstTimeOfOperation = false;

    public void initialize() {
        getDefaultView();
    }

    /**
     * @return the defaultView
     */
    public DefaultView getDefaultView() {
        if (defaultView == null) {
            defaultView = new DefaultView(this);
        }
        return defaultView;
    }

    /**
     * @param defaultView the defaultView to set
     */
    public void setDefaultView(DefaultView defaultView) {
        this.defaultView = defaultView;
    }

    /**
     * @return the calculator
     */
    public Calculator getCalculator() {
        if (calculator == null) {
            calculator = new Calculator();
        }
        return calculator;
    }

    /**
     * @param calculator the calculator to set
     */
    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public void insertNumber(String number) {
        if (getCalculator().isZeroDivisionError()) {
            cleanDisplay();
            getCalculator().setZeroDivisionError(false);
        }
        if (getDefaultView().getDisplay().getText().equals(String.valueOf(getCalculator().getResult()))) {
            cleanDisplay();
            getCalculator().setResult(0);
        }
        getDefaultView().getDisplay().setText(getDefaultView().getDisplay().getText() + number);
    }

    public void setCalculatorOperation(int operation) {
        if (getCalculator().getOperation() != operation) {
            getCalculator().setOperation(operation);
            resetValuesAfterOperationChanges();
            firstTimeOfOperation = true;
        } else {
            getCalculator().setOperation(operation);
            firstTimeOfOperation = false;
        }
        
    }

    public void calculateResult() {
        getCalculator().calculateResult();
        if (!getCalculator().isZeroDivisionError()) {
            getDefaultView().getDisplay().setText(String.valueOf(getCalculator().getResult()));
        }

    }

    public void saveFirstCalculatorValue(String firstValue) {
        getCalculator().setFirstValue(Integer.parseInt(firstValue));
    }

    public void saveSecondCalculatorValue(String secondValue) {
        getCalculator().setSecondValue(Integer.parseInt(secondValue));
    }

    public void saveValueAfterSelectOperation(String value) {
        if (firstTimeOfOperation) {
            saveFirstCalculatorValue(value);
        } else {
            saveSecondCalculatorValue(value);
        }
    }

    public void cleanDisplay() {
        getDefaultView().getDisplay().setText("");
    }

    public void resetValues() {
        getCalculator().setFirstValue(0);
        getCalculator().setSecondValue(0);
        getCalculator().setResult(0);
        getCalculator().setOperation(OperationTypeUtils.OPERATION_NONE);
    }

    public void resetValuesAfterOperationChanges() {
        if(getCalculator().getOperation() == OperationTypeUtils.OPERATION_TIMES 
                || getCalculator().getOperation() == OperationTypeUtils.OPERATION_INTO){
            getCalculator().setSecondValue(1);
        } else {
            getCalculator().setSecondValue(0);
        }
        getCalculator().setResult(0);
    }

    public void validateZeroDivisionError() {
        if (getCalculator().isZeroDivisionError()) {
            getDefaultView().getDisplay().setText("Zero Division Error");
            resetValues();
        }        
    }

}
