// import junit.framework.TestCase;
public class CharacterTester {
  Character mainCharacter;
  public static void main(String[] args) {

    Human raceHolder = new Human();
    Fighter classHolder = new Fighter();
    Character tester = new Character("Stuart", classHolder, raceHolder, 1,
    12, 12, 20, 10, 5, 18);

    tester.getCharacterRace().setCharacter(tester);
    tester.getCharacterRace().editScores();
    tester.getCharacterClass().setCharacter(tester);
    tester.getCharacterClass().setLvl(1);
    CharacterTester test = new CharacterTester(tester);




  }

  public CharacterTester(Character mainCharacter) {
    this.mainCharacter = mainCharacter;

    //prints out the character
    System.out.println(mainCharacter.toString());

    //change the character's armor
    mainCharacter.equip(Armor.LEATHER);
    System.out.println("\nCharacter's new Armor:\t" + mainCharacter.getArmor());
    System.out.println("Character new AC:\t" + mainCharacter.getAc());


    //the character's options on their turn
    System.out.println("\nCharacter's actions:");
    mainCharacter.displayActions();

    //the character's options on their turn
    System.out.println("\nCharacter's equipped weapons:");
    mainCharacter.displayActions();
  }
}
