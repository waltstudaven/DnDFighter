
public class DieRaceHumanTest {
Die die = new Die(20);

public DieRaceHumanTest() {
	System.out.println("This test written by Katie Spiese tests Die, Race, and Human");
	System.out.println("Your " + die.getSides() + "rolled a " + die.roll());
	CharacterCreation tester = new CharacterCreation();
    Character c = tester.characterCreator();
    System.out.println("Printing the stats of your character");
    c.toString();
    System.out.println("Your character is becoming a human ");
    c.setCharacterRace(new Human());
    System.out.println("Here's the new you:");
    c.toString();
}
}
