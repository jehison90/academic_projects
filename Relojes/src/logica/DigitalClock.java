package logica;

/**
 *
 * @author Jehison
 */
public class DigitalClock extends Clock{
        
    private int oldSeconds;
    private int oldMinutes;
    private int oldHours;

    public int getOldSeconds() {
        return oldSeconds;
    }

    public void setOldSeconds(int oldSeconds) {
        this.oldSeconds = oldSeconds;
    }

    public int getOldMinutes() {
        return oldMinutes;
    }

    public void setOldMinutes(int oldMinutes) {
        this.oldMinutes = oldMinutes;
    }

    public int getOldHours() {
        return oldHours;
    }

    public void setOldHours(int oldHours) {
        this.oldHours = oldHours;
    }
    
    
    
}
