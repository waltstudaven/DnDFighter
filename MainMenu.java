import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class MainMenu {

    Image backImage;

    public MainMenu(){
        JButton b1, b2;
        JLabel lab;


        //This sets the background image for the main menu
        backImage = new Image("C:\\Users\\Brandon\\Desktop\\School\\Senior\\SoftwareEngineering\\HelloWorld\\data\\Red Dragon vs Blue Dragon.png");
        backImage.setLayout(new GridBagLayout());
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
