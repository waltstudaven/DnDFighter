import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class MainMenu {
    private JFrame f;
    private JButton b1, b2;
    private Image backImage;
    private Graphics g;
    private JLabel lab;

    public MainMenu(){

        //This sets the background image for the main menu
        backImage = new Image("C:\\Users\\Brandon\\Desktop\\School\\Senior\\SoftwareEngineering\\HelloWorld\\data\\Red Dragon vs Blue Dragon.png");
        backImage.setLayout(new GridBagLayout());


        //makes the button
        b1 = new JButton("Select Character");
        Color button = Color.decode("#ECE392");
        b1.setBackground(button);
        b1.setFont(new Font("Verdana", 0, 30));
        b2 = new JButton("Select Monster");
        b2.setBackground(button);
        b2.setFont(new Font("Verdana", 0, 30));

        //makes the label (not necessary)
        lab = new JLabel("MONSTER FIGHTER");

        //set font/size of label
        lab.setForeground(Color.white);
        lab.setFont(new Font("Monotype Corsiva",0,150));

        //centers buttons in middle of panel
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);

        c.gridx=1;
        c.gridy=0;
        //c.weighty = ;
        c.anchor = GridBagConstraints.PAGE_START;
        backImage.add(lab,c);





        //set axis for first button
        //add first button

        c.gridx = 1;
        c.gridy = 1;
        c.weighty=0;
        c.anchor = GridBagConstraints.CENTER;
        backImage.add(b1,c);

        //add second button in a lower coordinate
        c.gridx = 1;
        c.gridy = 2;
        backImage.add(b2,c);


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
