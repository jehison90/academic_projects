/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.logic;

/**
 *
 * @author Jehison
 */
public class Calculator {

    private int firstValue;    
    private int secondValue;
    private int operation;
    private int result;
    
    private boolean zeroDivisionError;

    /**
     * @return the operation
     */
    public int getOperation() {
        return operation;
    }

    /**
     * @param operation the operation to set
     */
    public void setOperation(int operation) {
        this.operation = operation;
    }

    /**
     * @return the result
     */
    public int getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(int result) {
        this.result = result;
    }
    
    public int getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(int firstValue) {
        this.firstValue = firstValue;
    }

    public int getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(int secondValue) {
        this.secondValue = secondValue;
    }

    public boolean isZeroDivisionError() {
        return zeroDivisionError;
    }

    public void setZeroDivisionError(boolean zeroDivisionError) {
        this.zeroDivisionError = zeroDivisionError;
    }        

    public void calculateResult() {
        if (operation != OperationTypeUtils.OPERATION_NONE) {
            switch (operation) {
                case OperationTypeUtils.OPERATION_ADD:
                    result = firstValue + secondValue;
                    break;
                case OperationTypeUtils.OPERATION_LESS:
                    result = firstValue - secondValue;
                    break;
                case OperationTypeUtils.OPERATION_TIMES:
                    result = firstValue * secondValue;
                    break;
                case OperationTypeUtils.OPERATION_INTO:
                    if(secondValue == 0){
                        zeroDivisionError = true;
                        result = firstValue;
                    } else {
                        result = firstValue / secondValue;
                    }                    
                    break;
            }
            firstValue = result;
            secondValue = 0;
        }
    }
    
    

}
