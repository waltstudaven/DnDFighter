import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;



public class ScrollBacking {
    Image backImage;
    public ArrayList<String>  monsterList = new ArrayList<>();

    public ScrollBacking(){

        //This sets the background image for the main menu
        final String dir = System.getProperty("user.dir");

        String osName = System.getProperty("os.name").toLowerCase();
        boolean isMacOs = osName.contains("mac");
        if (isMacOs)
        {
            backImage = new Image(dir + "/data/Scroll Background.png");
        } else {
            backImage = new Image(dir + "\\DnDFighter\\data\\Scroll Background.png");
        }
        backImage.setLayout(new FlowLayout());
    }

    /**
     * Displays this constructor (the Jpanel for the main menu)
     * @return JPanel
     */
    public JPanel gui() {
        return (JPanel)backImage;
        //f.setVisible(true);
    }

}
