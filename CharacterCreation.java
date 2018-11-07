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

    allClasses.put("Fighter", new Fighter(1));
    allRaces.put("Human", new Human());
  }

  protected void characterCreator() {
    Scanner scan = new Scanner(System.in);
    System.out.println("What is your character's Strength score?");
    int inputStrScore = scan.nextInt();

    System.out.println("What is your character's Dexterity score?");
    int inputDexScore = scan.nextInt();

    System.out.println("What is your character's Constitution score?");
    int inputConScore = scan.nextInt();

    System.out.println("What is your character's Intelligence score?");
    int inputIntScore = scan.nextInt();

    System.out.println("What is your character's Wisdom score?");
    int inputWisScore = scan.nextInt();

    System.out.println("What is your character's Charisma score?");
    int inputCharScore = scan.nextInt();

    scan.nextLine();
    System.out.println("What is your character's Race?");
    String inputRace = scan.nextLine();

    System.out.println("What is your character's Class?");
    String inputClass = scan.nextLine();

    System.out.println("What is your character's Name?");
    String inputName = scan.nextLine();

    newCharacter = new Character(inputName, allClasses.get(inputClass), allRaces.get(inputRace), 1, inputStrScore, inputDexScore,
    inputConScore, inputIntScore, inputWisScore, inputCharScore);
  }

  public Race getCharacterRace() { return this.characterRace; }
  public CharacterClass getCharacterClass() {return this.characterClass; }

  public void setCharacterRace(Race newRace) { this.characterRace = newRace; }
  public void setCharacterClass(CharacterClass newClass) { this.characterClass = newClass; }
}
