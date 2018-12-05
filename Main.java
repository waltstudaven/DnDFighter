import javax.swing.*;
import java.awt.*;
import java.util.HashMap;


public class Main  {
    private static HashMap allMonsters;

    static {
        allMonsters = new HashMap<Integer, Monster>();
        allMonsters.put(1, new Ezmerelda());
        allMonsters.put(2, new Thug());
    }

    public static void main(String[] args) {
        Music music = new Music("rosey.wav");    /////////////////// change !!!!!!!!!!!!!!!!!!!!!!!!!!
        music.playLoop();


        Interface game = new Interface();
        game.addMainMenuButtons();
        game.addSelectMonsterButtons();
        game.addCharCreater1Buttons();

        JFrame f = new JFrame("Monster Fighter");
        f.add(game.homeContainer);

        //creates the back most frame
        //and sets it's title to Monster Fighter
        //f.setPreferredSize(new Dimension( 600, 400));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setMaximumSize(screenSize);
        f.setExtendedState(f.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        f.pack();
        f.setVisible(true);
        game.startGame();




    }

}

