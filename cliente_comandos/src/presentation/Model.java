package presentation;

import java.awt.Color;
import java.io.IOException;
import logica.SocketManager;

/**
 *
 * @author Jehison
 */
public class Model {

    private View view;
    private SocketManager socketManager;

    public Model() {
    }

    public void init() {
        getView().setVisible(true);
    }

    public View getView() {
        if (view == null) {
            view = new View(this);
            view.setSize(350, 400);
        }
        return view;
    }

    public SocketManager getSocketManager() {
        if (socketManager == null) {
            socketManager = new SocketManager();
        }
        return socketManager;
    }

    public void connect(String ip, int port) {
        try {
            getSocketManager().connect(ip, port);
            enableCommandSection(true);
        } catch (IOException ex) {
            getView().getResponseJTArea().setText(getView().getResponseJTArea().getText() + "\n" + "La conexión al servidor falló");
            enableCommandSection(false);
        }
    }

    public void sendCommand(String command) {
        try {
            getSocketManager().sendCommand(command);
            String response = getSocketManager().receiveResponse();
            getView().getResponseJTArea().setText(getView().getResponseJTArea().getText() + "\n" + response);
        } catch (IOException ex) {
            getView().getResponseJTArea().setForeground(Color.red);
            getView().getResponseJTArea().setText(getView().getResponseJTArea().getText() + "\n" + "Error al enviar el mensaje");
        }
    }

    public void enableCommandSection(boolean enable) {
        getView().getCommandJTField().setEnabled(enable);
        getView().getSendButton().setEnabled(enable);
    }
}
