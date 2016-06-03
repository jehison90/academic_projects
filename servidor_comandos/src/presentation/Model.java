package presentation;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import logica.CommandTypeUtil;
import logica.ServerSocketManager;
import logica.Triangle;

/**
 *
 * @author Jehison
 */
public class Model implements Runnable {

    private View view;
    private ServerSocketManager socketManager;
    private final Thread drawThread;
    private final Thread messagesThread;
    private final Canvas canvas;
    private final BufferedImage doubleBuffer;
    private BufferedImage triangleDoubleBuffer;
    private Triangle triangle;

    int movedPixels = 0;

    public Model() {
        canvas = getView().getCanvas();
        doubleBuffer = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_ARGB);
        drawThread = new Thread(this);
        messagesThread = new Thread(getSocketManager());
    }

    public void init() {
        getView().setSize(700, 560);
        getView().setResizable(false);
        getView().setVisible(true);
        triangle = new Triangle(canvas.getWidth() / 2, canvas.getHeight() / 2);
        triangleDoubleBuffer = new BufferedImage(triangle.getWidth(), triangle.getHeight(), BufferedImage.TYPE_INT_ARGB);
        drawThread.start();
        messagesThread.start();
    }

    public View getView() {
        if (view == null) {
            view = new View(this);
        }
        return view;
    }

    public ServerSocketManager getSocketManager() {
        if (socketManager == null) {
            socketManager = new ServerSocketManager();
        }
        return socketManager;
    }

    @Override
    public void run() {
        drawInitialCanvas();
        while (true) {
            if (getSocketManager().getCommand() != null && getSocketManager().getCommand().isExecuted() == false) {
                if (getSocketManager().getCommand().isValidCommand()) {
                    switch (getSocketManager().getCommand().getType()) {
                        case CommandTypeUtil.limpiar:
                            drawInitialCanvas();
                            answer();
                            getSocketManager().getCommand().setExecuted(true);
                            break;
                        case CommandTypeUtil.reset:
                            resetCanvas();
                            answer();
                            getSocketManager().getCommand().setExecuted(true);
                            break;
                        case CommandTypeUtil.color:
                            manageColorCommand();
                            answer();
                            getSocketManager().getCommand().setExecuted(true);
                            break;
                        case CommandTypeUtil.girar:
                            manageGirarCommand();
                            answer();
                            getSocketManager().getCommand().setExecuted(true);
                            break;
                        case CommandTypeUtil.pintar:
                            managePintarCommand();
                            answer();
                            getSocketManager().getCommand().setExecuted(true);
                            break;
                        case CommandTypeUtil.avanzar:
                            manageAvanzarCommand();
                            if (getSocketManager().getCommand().isExecuted()) {
                                answer();
                            }
                            break;
                    }
                } else{
                    answerBadCommand();
                    getSocketManager().getCommand().setExecuted(true);
                }
            }
        }
    }

    private void drawInitialCanvas() {
        Graphics brush = doubleBuffer.getGraphics();
        brush.setColor(Color.BLACK);
        brush.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Graphics triangleGraphics = triangleDoubleBuffer.getGraphics();
        triangleGraphics.setColor(Color.BLACK);
        triangleGraphics.fillRect(0, 0, triangle.getWidth(), triangle.getHeight());
        
        //rotate image
        double rAngle = Math.toRadians(triangle.getAngle());
        AffineTransform rotateTr = new AffineTransform();
        rotateTr.rotate(rAngle, triangle.getWidth() / 2, triangle.getHeight() / 2);
        ((Graphics2D) triangleGraphics).setTransform(rotateTr);
        triangleGraphics.drawImage(triangle.getTriangleImage(), 0, 0, canvas);
        
        draw();
    }

    public void draw() {
        Graphics lapiz = canvas.getGraphics();
        lapiz.drawImage(doubleBuffer, 0, 0, canvas);
        lapiz.drawImage(triangleDoubleBuffer, triangle.getX(), triangle.getY(), canvas);
    }

    private void manageColorCommand() {
        int r = Integer.parseInt(getSocketManager().getCommand().getCommandParameters().get(0));
        int g = Integer.parseInt(getSocketManager().getCommand().getCommandParameters().get(1));
        int b = Integer.parseInt(getSocketManager().getCommand().getCommandParameters().get(2));
        triangle.setPaintColor(new Color(r, g, b));
    }

    private void resetCanvas() {
        triangle.setX((canvas.getWidth() / 2) - (triangle.getWidth() / 2));
        triangle.setY((canvas.getWidth() / 2) - (triangle.getWidth() / 2));
        triangle.resetValues();
        drawInitialCanvas();
    }

    private void answer() {
        try {
            getSocketManager().sendResponse("Comando: " + getSocketManager().getCommand().getChainCommand() + " ejecutado correctamente");
        } catch (IOException ex) {
            getView().getResponseJTArea().setText(getView().getResponseJTArea().getText() + "\n" + "Error enviando mensaje");
        }
    }
    
    private void answerBadCommand() {
        try {
            getSocketManager().sendResponse("Comando: " + getSocketManager().getCommand().getChainCommand() + " es errado");
        } catch (IOException ex) {
            getView().getResponseJTArea().setText(getView().getResponseJTArea().getText() + "\n" + "Error enviando mensaje");
        }
    }

    private void manageGirarCommand() {
        //set global angle
        int angle = Integer.parseInt(getSocketManager().getCommand().getCommandParameters().get(0));
        triangle.setAngle(angle);

        //clear last image        
        Graphics triangleGraphics = triangleDoubleBuffer.getGraphics();
        triangleGraphics.setColor(Color.BLACK);
        triangleGraphics.fillRect(0, 0, 50, 50);

        //rotate image
        double rAngle = Math.toRadians(triangle.getAngle());
        AffineTransform rotateTr = new AffineTransform();
        rotateTr.rotate(rAngle, triangle.getWidth() / 2, triangle.getHeight() / 2);
        ((Graphics2D) triangleGraphics).setTransform(rotateTr);
        triangleGraphics.drawImage(triangle.getTriangleImage(), 0, 0, canvas);

        //repaint
        draw();
    }

    private void managePintarCommand() {
        String param = getSocketManager().getCommand().getCommandParameters().get(0);
        switch (param) {
            case "ON":
                triangle.setPaint(true);
                break;
            case "OFF":
                triangle.setPaint(false);
                break;
        }
    }

    private void manageAvanzarCommand() {
        int move = Integer.parseInt(getSocketManager().getCommand().getCommandParameters().get(0));
        //if (movedPixels <= move) {
            triangle.setOldX(triangle.getX());
            triangle.setOldY(triangle.getY());
            
            Point p = calculatePoint(move, triangle.getOldX(), triangle.getOldY(), triangle.getAngle() - 90);
            
            triangle.setX(p.x);            
            triangle.setY(p.y);
            
            System.out.println(p.x);
            System.out.println(p.y);
            
            movedPixels += triangle.getSpeed();
            if (triangle.isPaint()) {
                Graphics brush = doubleBuffer.getGraphics();
                brush.setColor(triangle.getPaintColor());
                brush.drawLine(triangle.getOldX() + 12, triangle.getOldY() + 12, triangle.getX() + 12, triangle.getY() + 12);
            }
            draw();
        //} else {
            getSocketManager().getCommand().setExecuted(true);
            movedPixels = 0;
        //}
    }
    
    private Point calculatePoint(int ratio, int centerX, int centerY, int angle) {
        int x = (int) Math.round(centerX + (ratio * (Math.cos(angle * Math.PI / 180))));
        int y = (int) Math.round(centerY + (ratio * (Math.sin(angle * Math.PI / 180))));
        return new Point(x, y);
    }

}
