package presentation;

import java.awt.Canvas;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Jehison
 */
public class View extends JFrame {
    
    private final Model model;
    private Canvas canvas;
    private Controller controller;
    private JButton analogicalButton;
    private JButton digitalButton;

    /**
     * Creates new form View
     * @param model
     */
    public View(Model model) {
        this.model = model;
        initComponents();
        capturarEventos();
    }

    private void initComponents() {       
        getContentPane().setLayout(null);
        getContentPane().add(getCanvas());
        getContentPane().add(getAnalogicalButton());
        getContentPane().add(getDigitalButton());
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);        
        pack();
        setVisible(true);
    }                       

    public Model getModelo() {
        return model;
    }

    public Canvas getCanvas() {
        if(canvas == null){
            canvas = new Canvas();
            canvas.setBounds(0, 0, 500, 500);
        }
        return canvas;
    }

    public JButton getAnalogicalButton() {
        if(analogicalButton == null){
            analogicalButton = new JButton("Reloj analógico");
            analogicalButton.setBounds(520, 20, 120, 25);
        }
        return analogicalButton;
    }
    
    public JButton getDigitalButton() {
        if(digitalButton == null){
            digitalButton = new JButton("Reloj digital");
            digitalButton.setBounds(520, 50, 120, 25);
        }
        return digitalButton;
    }

    public Controller getController() {
        if(controller == null){
            controller = new Controller(this);
        }
        return controller;
    }              

    private void capturarEventos() {
        canvas.addMouseListener(getController());
        analogicalButton.addActionListener(getController());
        digitalButton.addActionListener(getController());
    }
}
