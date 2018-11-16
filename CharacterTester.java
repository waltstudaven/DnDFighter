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

    //can the character equip plate armor?
    System.out.println("\nAttempting to equip plate armor:");
    mainCharacter.canEquip(Armor.PLATE);


    //the character's options on their turn
    System.out.println("\nCharacter's actions:");
    mainCharacter.displayActions();

    //the character's options on their turn
    System.out.println("\nCharacter's equipped weapons:");
    System.out.println("Main Hand: " + mainCharacter.getMainHand());
    System.out.println("Off Hand: " + mainCharacter.getOffHand());

    //equiping a flail
    mainCharacter.equip(Weapon.FLAIL);
    System.out.println("\nCharacter's equipped weapons:");
    System.out.println("Main Hand: " + mainCharacter.getMainHand());
    System.out.println("Off Hand: " + mainCharacter.getOffHand());

    //doing a free action: equip a weapon from the inventory
    System.out.println("Number Free Actions Available: " +mainCharacter.numFreeActionAvail);

    mainCharacter.freeAction("equip", mainCharacter.numFreeActionAvail, new Thug());
    System.out.println("\nCharacter's equipped weapons:");
    System.out.println("Main Hand: " + mainCharacter.getMainHand());
    System.out.println("Off Hand: " + mainCharacter.getOffHand());

    //doing a free action: rolling insight
    System.out.println("Number Free Actions Available: " + mainCharacter.numFreeActionAvail);
    System.out.println("\nRolling insight:" + mainCharacter.freeAction("inspect enemy health", mainCharacter.numFreeActionAvail, new Thug()));

    System.out.println("Number Free Actions Available: " + mainCharacter.freeAction("sheath", mainCharacter.numFreeActionAvail, new Thug()));

    System.out.println("\nCharacter's equipped weapons:");
    System.out.println("Main Hand: " + mainCharacter.getMainHand());
    System.out.println("Off Hand: " + mainCharacter.getOffHand());
  }
}
