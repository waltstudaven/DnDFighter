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

    System.out.println(mainCharacter.toString());
    mainCharacter.equip(Armor.LEATHER);
    System.out.println("Character AC:\t" + mainCharacter.getAc());
  }
}
