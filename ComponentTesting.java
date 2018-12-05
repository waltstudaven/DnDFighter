import javax.swing.*;
import java.awt.*;

public class ComponentTesting {
    private static Character hero;
    Die die = new Die(20);

    public static void main(String[] args) {
        ComponentTesting ct = new ComponentTesting();



        /**
         * Stu
         */
        CharacterCreation test = new CharacterCreation();
        hero = test.characterCreator();
        FighterTest ft = new FighterTest(hero);

        /**
         * Katie
         */

        ct.DieRaceHumanTest();

        /**
         * Jeremiah
         */
        CharacterCreation tester = new CharacterCreation();
        Character c = tester.characterCreator();
        WeaponEquipmentArmorTest t = new WeaponEquipmentArmorTest(c);

        /**
         * Brandon
         */
        ct.GUItest();

    }



    public void DieRaceHumanTest() {
        System.out.println("This test written by Katie Spiese tests Die, Race, and Human");
        System.out.println("Your " + die.getSides() + " rolled a " + die.roll());
        CharacterCreation tester = new CharacterCreation();
        Character c = tester.characterCreator();
        System.out.println("Printing the stats of your character");
        c.toString();
        System.out.println("Your character is becoming a human ");
        c.setCharacterRace(new Human());
        System.out.println("Here's the new you:");
        c.toString();
    }

    public void GUItest() {
        try {
            System.out.println("This next part is done by Brandon: \n This Runs the interactive interface for the user. \n" +
                    "The main menu presents two buttons, \n 1) Select Monster, which currently only presents a list of buttons which let you print out the monster's name \n" +
                    "and 2)Create Character, which lets the user enter the inputs needed for insantiating a character. \n" +
                    "At the end of the GUI, the last submit button sets the name for the character, and continues the rest of the character creation text based. Everything completes as it should.");
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
        }catch(Exception e){

        }
    }
}