import java.util.Scanner;
import java.util.HashMap;
public class CharacterCreation {
  private Race characterRace;
  private CharacterClass characterClass;
  protected int level;
  protected Character newCharacter;
  private HashMap<String, CharacterClass> allClasses;
  private HashMap<String, Race> allRaces;

  public static void main(String[] args) {
    CharacterCreation test = new CharacterCreation();
    test.characterCreator();
  }

  public CharacterCreation() {
    allClasses = new HashMap<>();
    allRaces = new HashMap<>();

    allClasses.put("Fighter", new Fighter());
    allRaces.put("Human", new Human());
  }

  protected void characterCreator() {
    Scanner scan = new Scanner(System.in);
    System.out.println("What is your character's strength score?");
    int inputStrScore = scan.nextInt();

    System.out.println("What is your character's dexterity score?");
    int inputDexScore = scan.nextInt();

    System.out.println("What is your character's constitution score?");
    int inputConScore = scan.nextInt();

    System.out.println("What is your character's intelligence score?");
    int inputIntScore = scan.nextInt();

    System.out.println("What is your character's wisdom score?");
    int inputWisScore = scan.nextInt();

    System.out.println("What is your character's charisma score?");
    int inputCharScore = scan.nextInt();

    scan.nextLine();
    System.out.println("What is your character's race?");
    String inputRace = scan.nextLine();

    System.out.println("What is your character's class?");
    String inputClass = scan.nextLine();

    System.out.println("What is your character's name?");
    String inputName = scan.nextLine();


    System.out.println("What is your character's level?");
    int inputLvl = scan.nextInt();

    newCharacter = new Character(inputName, allClasses.get(inputClass), allRaces.get(inputRace), inputLvl, inputStrScore, inputDexScore,
    inputConScore, inputIntScore, inputWisScore, inputCharScore);

    //System.out.println(inputClass);
    allClasses.get(inputClass).setCharacter(newCharacter);
    newCharacter.getCharacterClass().setLvl(inputLvl);

    allRaces.get(inputRace).setCharacter(newCharacter);
    newCharacter.getCharacterRace().editScores();
    System.out.println(newCharacter);
  }

  public Race getCharacterRace() { return this.characterRace; }
  public CharacterClass getCharacterClass() {return this.characterClass; }

  public void setCharacterRace(Race newRace) { this.characterRace = newRace; }
  public void setCharacterClass(CharacterClass newClass) { this.characterClass = newClass; }
}
