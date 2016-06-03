package logica;

import java.awt.Color;
import java.util.Calendar;

/**
 *
 * @author Jehison
 */
public class Clock {

    private final Color backGroundColor;
    private final Color insideColor;

    public Clock() {        
        backGroundColor = Color.BLACK;
        insideColor = Color.ORANGE;
    }        
    
    public Calendar getTime(){
        return Calendar.getInstance();
    }
    
     public Color getBackGroundColor() {
        return backGroundColor;
    }

    public Color getInsideColor() {
        return insideColor;
    }

}
