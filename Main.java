import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java. awt.event.*;
import java.util.ArrayList;
import javax.swing.*;



public class Main  {

    public static void main(String[] args) {
        Interface game = new Interface();
        game.addMainMenuButtons();
        game.addSelectMonsterButtons();

        JFrame f = new JFrame("Monster Fighter");
        f.add(game.homeContainer);

        //creates the back most frame
        //and sets it's title to Monster Fighter
        f.setSize( 600, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.pack();
        f.setVisible(true);
        game.startGame();



        System.out.println("Hello World!");
    }
}

