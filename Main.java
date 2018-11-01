import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Main  {


    public static void main(String[] args) {
        JFrame f;
        MainMenu mm = new MainMenu();
        JPanel mainMenu = mm.gui();

        //creates the back most frame
        //and sets it's title to Monster Fighter
        f = new JFrame("Monster Fighter");
        f.setSize( 600, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(mainMenu);
        f.setVisible(true);


        System.out.println("Hello World!");
    }


}

