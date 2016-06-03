package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jehison
 */
public class Controller implements ActionListener{
    private final View view;
    private final Model model;

    public Controller(View v) {
        view = v;
        model = v.getModelo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(view.getConnectButton())){
            String ip = view.getIpJTField().getText();
            int port = Integer.parseInt(view.getPortJTField().getText());
            model.connect(ip, port);
        }
        if(e.getSource().equals(view.getSendButton())){
            String command = view.getCommandJTField().getText();
            model.sendCommand(command);
        }
    }
    
}
