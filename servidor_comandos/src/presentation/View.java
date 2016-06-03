package presentation;

import java.awt.Canvas;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Jehison
 */
public class View extends JFrame {

    private final Model model;
    private Canvas canvas;
    private JScrollPane responseJSPane;
    private JTextArea responseJTArea;

    /**
     * Creates new form View
     *
     * @param model
     */
    public View(Model model) {
        this.model = model;
        initComponents();
    }

    private void initComponents() {
        getContentPane().setLayout(null);
        getContentPane().add(getCanvas());
        getContentPane().add(getResponseJSPane());
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    public Model getModelo() {
        return model;
    }

    public Canvas getCanvas() {
        if (canvas == null) {
            canvas = new Canvas();
            canvas.setBounds(10, 10, 500, 500);
        }
        return canvas;
    }

    public JScrollPane getResponseJSPane() {
        if (responseJSPane == null) {
            responseJSPane = new JScrollPane(getResponseJTArea());
            responseJSPane.setBounds(520, 10, 150, 500);
        }
        return responseJSPane;
    }

    public JTextArea getResponseJTArea() {
        if (responseJTArea == null) {
            responseJTArea = new JTextArea();
            responseJTArea.setEnabled(false);
        }
        return responseJTArea;
    }
}
