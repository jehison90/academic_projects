package logica;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jehison
 */
public class Command {

    private boolean validCommand = false;
    private boolean executed;
    private int type;
    private String chainCommand;

    private List<String> commandParameters;

    public Command(String chainCommand) {
        this.chainCommand = chainCommand;
        commandParameters = new LinkedList<>();
        validateCommand();
        executed = true;
    }

    public final void validateCommand() {
        if (chainCommand != null && !chainCommand.equals("")) {
            String[] parameters = chainCommand.split(" ");
            if (parameters.length > 2) {
                validCommand = false;
            } else if (parameters.length == 1) {
                switch (parameters[0]) {
                    case "LIMPIAR":
                        type = CommandTypeUtil.limpiar;
                        validCommand = true;
                        break;
                    case "RESET":
                        type = CommandTypeUtil.reset;
                        validCommand = true;
                        break;
                    default:
                        validCommand = false;
                        break;
                }
            } else if (parameters.length == 2) {
                switch (parameters[0]) {
                    case "AVANZAR":
                        type = CommandTypeUtil.avanzar;
                        commandParameters.add(parameters[1]);
                        validCommand = true;
                        break;
                    case "GIRAR":
                        type = CommandTypeUtil.girar;
                        commandParameters.add(parameters[1]);
                        validCommand = true;
                        break;
                    case "PINTAR":
                        type = CommandTypeUtil.pintar;
                        commandParameters.add(parameters[1]);
                        validCommand = true;
                        break;
                    case "COLOR":
                        type = CommandTypeUtil.color;
                        String[] colorParameters = parameters[1].split(",");
                        if (colorParameters.length == 3) {
                            commandParameters.add(colorParameters[0]);
                            commandParameters.add(colorParameters[1]);
                            commandParameters.add(colorParameters[2]);
                            validCommand = true;
                        } else {
                            validCommand = false;
                        }
                        break;
                    default:
                        validCommand = false;
                        break;
                }
            }
        } else {
            validCommand = false;
        }
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isValidCommand() {
        return validCommand;
    }

    public void setValidCommand(boolean validCommand) {
        this.validCommand = validCommand;
    }

    public boolean isExecuted() {
        return executed;
    }

    public void setExecuted(boolean executed) {
        this.executed = executed;
    }

    public String getChainCommand() {
        return chainCommand;
    }

    public void setChainCommand(String chainCommand) {
        this.chainCommand = chainCommand;
    }

    public List<String> getCommandParameters() {
        return commandParameters;
    }

    public void setCommandParameters(List<String> commandParameters) {
        this.commandParameters = commandParameters;
    }

}
