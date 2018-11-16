import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;



public class ScrollBacking {
    Image backImage;
    public ArrayList<String>  monsterList = new ArrayList<>();

    public ScrollBacking(){

        //This sets the background image for the main menu
        backImage = new Image("Walters-MacBook-Pro:Downloads/SCroll.png⁩");
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
