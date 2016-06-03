import presentation.Model;

/**
 *
 * @author Jehison
 */
public class Launcher {

    private Model model;
    
    public Launcher() {
        model = new Model();
        model.init();
    }

    
    public static void main(String[] args) {
        new Launcher();
    }
    
}
