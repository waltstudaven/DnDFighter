import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;



public class SelectMonster {
    Image backImage;
    public ArrayList<String>  monsterList = new ArrayList<>();

    public SelectMonster(){

        //This sets the background image for the main menu
        final String dir = System.getProperty("user.dir");

        backImage = new Image(dir + "\\DnDFighter\\data\\Red Dragon vs Blue Dragon.png");
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
