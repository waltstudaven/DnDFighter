import javax.swing.*;



public class Main  {

    public static void main(String[] args) {
        System.out.println("This Runs the interactive interface for the user. \n" +
                "The main menu presents two buttons, \n 1) Select Monster, which currently only presents a list of buttons which let you print out the monster's name \n" +
                "and 2)Create Character, which lets the user enter the inputs needed for insantiating a character. \n" +
                "At the end, the last submit button prints out the toString for the character just Created." +
                "\n this submit button is located on the character naming page");
        Interface game = new Interface();
        game.addMainMenuButtons();
        game.addSelectMonsterButtons();
        game.addCharCreater1Buttons();

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

