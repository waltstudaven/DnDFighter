import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;



public class ScrollBacking {
    Image backImage;
    public ArrayList<String>  monsterList = new ArrayList<>();

    public ScrollBacking(){

        //This sets the background image for the main menu
        backImage = new Image("C:\\Users\\Brandon\\Desktop\\School\\Senior\\SoftwareEngineering\\HelloWorld\\data\\Scroll Background.png");
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
