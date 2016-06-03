package presentation;

import com.sun.prism.paint.Color;
import java.awt.Canvas;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Calendar;
import logica.AnalogicalClock;
import logica.Clock;
import logica.DigitalClock;
import logica.Point;

/**
 *
 * @author Jehison
 */
public class Model implements Runnable {

    private final Thread clockThread;
    private View view;
    private Clock clock;
    private final BufferedImage doubleBuffer;
    private final Graphics brush;

    private final Canvas lienzo;

    public Model() {
        lienzo = getVentana().getCanvas();
        doubleBuffer = new BufferedImage(lienzo.getWidth(), lienzo.getHeight(), BufferedImage.TYPE_INT_ARGB);
        brush = doubleBuffer.getGraphics();
        clockThread = new Thread(this);
    }

    public void init() {
        getVentana().setVisible(true);
    }

    public View getVentana() {
        if (view == null) {
            view = new View(this);
            view.setSize(700, 500);
        }
        return view;
    }

    public void instantiateAnalogicalClock(Point CenterPoint, int ratio) {
        clock = null;
        clock = new AnalogicalClock(CenterPoint, ratio);
        drawAnalogicalClock();
        if (!clockThread.isAlive()) {
            clockThread.start();
        }
    }

    public void instantiateDigitalClock() {
        clock = null;
        clock = new DigitalClock();
        drawDigitalClock();
        if (!clockThread.isAlive()) {
            clockThread.start();
        }
    }

    @Override
    public void run() {
        while (true) {
            if (clock instanceof AnalogicalClock) {
                drawAnalogicalTime((AnalogicalClock) clock);
            } else if (clock instanceof DigitalClock) {
                drawDigitalTime((DigitalClock)clock);
            }
        }
    }

    public void drawAnalogicalTime(AnalogicalClock clock) {
        Calendar time = clock.getTime();

        int seconds = time.get(Calendar.SECOND);
        int secondsAngle = (seconds * 6) - 90;
        Point secondsPointInClock = calculatePoint(clock.getSecondsRatio(), clock.getCenterPoint().getX(), clock.getCenterPoint().getY(), secondsAngle);
        Point secondsOldPoint = clock.getOldSecondsPoint();
        if (secondsOldPoint != null) {
            if (!secondsPointInClock.equals(secondsOldPoint)) {
                brush.setColor(clock.getBackGroundColor());
                brush.drawLine(clock.getCenterPoint().getX(), clock.getCenterPoint().getY(), secondsOldPoint.getX(), secondsOldPoint.getY());
            }
        }
        brush.setColor(clock.getInsideColor());
        brush.drawLine(clock.getCenterPoint().getX(), clock.getCenterPoint().getY(), secondsPointInClock.getX(), secondsPointInClock.getY());
        clock.setOldSecondsPoint(secondsPointInClock);

        int minutes = time.get(Calendar.MINUTE);
        int minutesAngle = (minutes * 6) - 90;
        Point minutesPointInClock = calculatePoint(clock.getMinutesRatio(), clock.getCenterPoint().getX(), clock.getCenterPoint().getY(), minutesAngle);
        Point minutesOldPoint = clock.getOldminutesPoint();
        if (minutesOldPoint != null) {
            if (!minutesPointInClock.equals(minutesOldPoint)) {
                brush.setColor(clock.getBackGroundColor());
                brush.drawLine(clock.getCenterPoint().getX(), clock.getCenterPoint().getY(), minutesOldPoint.getX(), minutesOldPoint.getY());
            }
        }
        brush.setColor(clock.getInsideColor());
        brush.drawLine(clock.getCenterPoint().getX(), clock.getCenterPoint().getY(), minutesPointInClock.getX(), minutesPointInClock.getY());
        clock.setOldminutesPoint(minutesPointInClock);

        int hours = time.get(Calendar.HOUR);
        int hoursAngle = (hours * 30) - 90;
        Point hoursPointInClock = calculatePoint(clock.getHoursRatio(), clock.getCenterPoint().getX(), clock.getCenterPoint().getY(), hoursAngle);
        Point hoursOldPoint = clock.getOldHoursPoint();
        if (hoursOldPoint != null) {
            if (!hoursPointInClock.equals(hoursOldPoint)) {
                brush.setColor(clock.getBackGroundColor());
                brush.drawLine(clock.getCenterPoint().getX(), clock.getCenterPoint().getY(), hoursOldPoint.getX(), hoursOldPoint.getY());
            }
        }
        brush.setColor(clock.getInsideColor());
        brush.drawLine(clock.getCenterPoint().getX(), clock.getCenterPoint().getY(), hoursPointInClock.getX(), hoursPointInClock.getY());
        clock.setOldHoursPoint(hoursOldPoint);

        draw();
    }

    public void drawDigitalTime(DigitalClock clock) {
        Calendar time = clock.getTime();

        int seconds = time.get(Calendar.SECOND);
        if (seconds != clock.getOldSeconds()) {
            brush.setColor(clock.getBackGroundColor());
            brush.fillRect(300, 140, 100, 100);
        }
        clock.setOldSeconds(seconds);
        brush.setColor(clock.getInsideColor());
        brush.setFont(new Font("clock", Font.PLAIN, 36));
        brush.drawString(String.valueOf(seconds), 335, 190);
        
        int minutes = time.get(Calendar.MINUTE);
        if (minutes != clock.getOldMinutes()) {
            brush.setColor(clock.getBackGroundColor());
            brush.fillRect(150, 140, 100, 100);
        }
        clock.setOldMinutes(minutes);
        brush.setColor(clock.getInsideColor());
        brush.setFont(new Font("clock", Font.PLAIN, 36));
        brush.drawString(String.valueOf(minutes), 185, 190);
        
        int hours = time.get(Calendar.HOUR);
        if (hours != clock.getOldHours()) {
            brush.setColor(clock.getBackGroundColor());
            brush.fillRect(10, 140, 100, 100);
        }
        clock.setOldHours(hours);
        brush.setColor(clock.getInsideColor());
        brush.setFont(new Font("clock", Font.PLAIN, 36));
        brush.drawString(String.valueOf(hours), 45, 190);                
                        
        draw();        
    }

    public void drawAnalogicalClock() {
        AnalogicalClock clock = (AnalogicalClock) this.clock;
        brush.setColor(java.awt.Color.WHITE);
        brush.fillRect(0, 0, 500, 500);
        draw();
        brush.setColor(clock.getBackGroundColor());
        brush.fillOval(0, 0, 440, 440);
        brush.setColor(clock.getInsideColor());
        brush.setFont(new Font("clock", Font.PLAIN, 12));
        brush.drawString("12", 215, 20);
        brush.drawString("3", 420, 225);
        brush.drawString("6", 217, 420);
        brush.drawString("9", 10, 225);
        draw();
    }

    private void drawDigitalClock() {
        DigitalClock clock = (DigitalClock) this.clock;
        brush.setColor(java.awt.Color.white);
        brush.fillRect(0, 0, 500, 500);
        draw();
        brush.setColor(clock.getBackGroundColor());
        brush.fillRect(10, 140, 100, 100);
        brush.fillRect(150, 140, 100, 100);
        brush.fillRect(300, 140, 100, 100);
        draw();
    }

    public void draw() {
        Graphics lapiz = lienzo.getGraphics();
        lapiz.drawImage(doubleBuffer, 0, 0, lienzo);
    }

    private Point calculatePoint(int ratio, int centerX, int centerY, int angle) {
        int x = (int) Math.round(centerX + (ratio * (Math.cos(angle * Math.PI / 180))));
        int y = (int) Math.round(centerY + (ratio * (Math.sin(angle * Math.PI / 180))));
        return new Point(x, y);
    }
}
