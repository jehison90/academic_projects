package logica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Jehison
 */
public class ServerSocketManager implements Runnable {

    private ServerSocket server;
    private DataInputStream receiveData;
    private DataOutputStream sendData;
    private static final int port = 8099;
    private Command command;    
    private boolean isConnected;

    public void connect() {
        try {
            server = new ServerSocket(port);
            Socket client = server.accept();
            receiveData = new DataInputStream(client.getInputStream());
            sendData = new DataOutputStream(client.getOutputStream());
            isConnected = true;
        } catch (IOException ex) {
            isConnected = false;
        }
    }

    public void sendResponse(String command) throws IOException {
        sendData.writeUTF(command);
    }

    public String receiveCommand() throws IOException {
        return receiveData.readUTF();
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public void run() {
        connect();

        while (isConnected) {
            try {
                String commandChain = receiveCommand();                
                commandChain = commandChain.toUpperCase();
                command = new Command(commandChain);
                command.setExecuted(false);
            } catch (IOException ex) {
                isConnected = false;
                connect();
            }
        }

    }

}
