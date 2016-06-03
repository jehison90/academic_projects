package logica;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Jehison
 */
public class Triangle {

    private final Image triangleImage;
    private int x;
    private int y;
    private int oldX;
    private int oldY;
    private final int width;
    private final int height;
    //pixel per iteration
    private final int speed = 10;

    //Attributes to draw
    private boolean paint;
    private Color paintColor;
    private int angle;

    public Triangle(int initialX, int initialY) {
        triangleImage = new ImageIcon(getClass().getResource("/images/Triangle_Icon.png")).getImage();
        width = triangleImage.getWidth(null);
        height = triangleImage.getHeight(null);
        x = initialX - (width / 2);
        y = initialY - (height / 2);
        paintColor = Color.WHITE;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getOldX() {
        return oldX;
    }

    public void setOldX(int oldX) {
        this.oldX = oldX;
    }

    public int getOldY() {
        return oldY;
    }

    public void setOldY(int oldY) {
        this.oldY = oldY;
    }

    public int getSpeed() {
        return speed;
    }

    public Image getTriangleImage() {
        return triangleImage;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle += angle;
        if (this.angle >= 360) {
            this.angle = this.angle - 360;
        }
    }

    public boolean isPaint() {
        return paint;
    }

    public void setPaint(boolean paint) {
        this.paint = paint;
    }

    public Color getPaintColor() {
        return paintColor;
    }

    public void setPaintColor(Color paintColor) {
        this.paintColor = paintColor;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void resetValues() {
        oldX = x;
        oldY = y;
        paint = false;
        paintColor = Color.WHITE;
        angle = 0;
    }
}
