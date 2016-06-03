package logica;

import java.awt.Color;

/**
 *
 * @author Jehison
 */
public class AnalogicalClock extends Clock{
        
    private final Point centerPoint;
    private final int clockRatio;
    private final int secondsRatio;
    private final int minutesRatio;
    private final int hoursRatio;
    private final Color backGroundColor;
    private final Color insideColor;
    private Point oldSecondsPoint;
    private Point oldminutesPoint;
    private Point oldHoursPoint;
    
    public AnalogicalClock(Point centerPoint, int clockRatio) {
        this.centerPoint = centerPoint;
        this.clockRatio = clockRatio;
        secondsRatio = (clockRatio/2) - 30;
        minutesRatio = (clockRatio/2) - 60;
        hoursRatio = (clockRatio/2) - 110;
        backGroundColor = Color.BLACK;
        insideColor = Color.ORANGE;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public int getClockRatio() {
        return clockRatio;
    }

    public int getSecondsRatio() {
        return secondsRatio;
    }

    public int getMinutesRatio() {
        return minutesRatio;
    }

    public int getHoursRatio() {
        return hoursRatio;
    }

    public Color getBackGroundColor() {
        return backGroundColor;
    }

    public Color getInsideColor() {
        return insideColor;
    }

    public Point getOldSecondsPoint() {
        return oldSecondsPoint;
    }

    public void setOldSecondsPoint(Point oldSecondsPoint) {
        this.oldSecondsPoint = oldSecondsPoint;
    }

    public Point getOldminutesPoint() {
        return oldminutesPoint;
    }

    public void setOldminutesPoint(Point oldminutesPoint) {
        this.oldminutesPoint = oldminutesPoint;
    }

    public Point getOldHoursPoint() {
        return oldHoursPoint;
    }

    public void setOldHoursPoint(Point oldHoursPoint) {
        this.oldHoursPoint = oldHoursPoint;
    }
    
    
          
}
