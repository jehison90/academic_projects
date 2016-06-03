package logica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Jehison
 */
public class SocketManager {
    
    private Socket client;
    private DataInputStream receiveData;
    private DataOutputStream sendData;
    
    
    public void connect(String ip, int port) throws IOException{
        client = new Socket(ip, port);
        receiveData = new DataInputStream(client.getInputStream());
        sendData = new DataOutputStream(client.getOutputStream());
    }
    
    public void sendCommand(String command) throws IOException{
        sendData.writeUTF(command);
    }
    
    public String receiveResponse() throws IOException{
        return receiveData.readUTF();
    }
    
}
