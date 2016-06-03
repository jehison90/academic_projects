package presentation;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Jehison
 */
public class View extends JFrame {
    
    private final Model model;
    private Controller controller;
    private JTextField commandJTField;
    private JTextField ipJTField;
    private JTextField portJTField;
    private JLabel ipJLabel;
    private JLabel portJLabel;
    private JLabel messageJLabel;
    private JScrollPane responseJSPane;
    private JTextArea responseJTArea;
    private JButton sendButton;
    private JButton connectButton; 

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
        getContentPane().add(getSendButton());
        getContentPane().add(getConnectButton());
        getContentPane().add(getCommandJTField());
        getContentPane().add(getIpJTField());
        getContentPane().add(getPortJTField());
        getContentPane().add(getIpJLabel());
        getContentPane().add(getPortJLabel());
        getContentPane().add(getMessageJLabel());
        getContentPane().add(getResponseJSPane());
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);        
        pack();
    }                       

    public Model getModelo() {
        return model;
    }

    public JButton getSendButton() {
        if(sendButton == null){
            sendButton = new JButton("Enviar");
            sendButton.setBounds(220, 110, 100, 25);
            sendButton.setEnabled(false);
        }
        return sendButton;
    }
    
    public JButton getConnectButton() {
        if(connectButton == null){
            connectButton = new JButton("Conectar");
            connectButton.setBounds(220, 40, 100, 25);
        }
        return connectButton;
    }

    public JTextField getIpJTField() {
        if(ipJTField == null){
            ipJTField = new JTextField();
            ipJTField.setBounds(10, 40, 120, 25);
        }
        return ipJTField;
    }

    public JTextField getPortJTField() {
        if(portJTField == null){
            portJTField = new JTextField();
            portJTField.setBounds(140, 40, 70, 25);
        }
        return portJTField;
    }

    public JTextField getCommandJTField() {
        if(commandJTField == null){
            commandJTField = new JTextField();
            commandJTField.setBounds(10, 110, 200, 25);
            commandJTField.setEnabled(false);
        }
        return commandJTField;
    }  

    public JLabel getIpJLabel() {
        if(ipJLabel == null){
            ipJLabel = new JLabel("IP");
            ipJLabel.setBounds(10, 10, 30, 25);
        }
        return ipJLabel;
    }

    public JLabel getPortJLabel() {
        if(portJLabel == null){
            portJLabel = new JLabel("PUERTO");
            portJLabel.setBounds(140, 10, 100, 25);
        }
        return portJLabel;
    }

    public JLabel getMessageJLabel() {
        if(messageJLabel == null){
            messageJLabel = new JLabel("COMANDOS");
            messageJLabel.setBounds(10, 80, 100, 25);
        }
        return messageJLabel;
    }

    public JScrollPane getResponseJSPane() {
        if(responseJSPane == null){
            responseJSPane = new JScrollPane(getResponseJTArea());
            responseJSPane.setBounds(10, 150, 310, 200);
        }
        return responseJSPane;
    }

    public JTextArea getResponseJTArea() {
        if(responseJTArea == null){
            responseJTArea = new JTextArea();
            responseJTArea.setEnabled(false);
        }
        return responseJTArea;
    }

    public Controller getController() {
        if(controller == null){
            controller = new Controller(this);
        }
        return controller;
    }              

    private void capturarEventos() {        
        sendButton.addActionListener(getController()); 
        connectButton.addActionListener(getController()); 
    }
}
