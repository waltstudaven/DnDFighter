import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
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

  protected Character characterCreator() {

    Scanner scan = new Scanner(System.in);

int inputStrScore = 0;
boolean toContinue = false;
  while(toContinue == false){
    try{
      System.out.println("What is your character's strength score?");
      int inputStrScore = scan.nextInt();
      toContinue = true;
    }
    catch(Exception e){
    }
  }

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
    System.out.print("Options: ");

    int i = 1;
    for(String s: allRaces.keySet()){
      System.out.print("(" + i + ") " + s);
    }
    System.out.println();
    int inputRace = scan.nextInt();

    System.out.println("What is your character's class?");
    System.out.print("Options: ");

    i = 1;
    for(String s: allClasses.keySet()){
      System.out.print("(" + i + ") " + s);
    }
    System.out.println();
    int inputClass = scan.nextInt();
    scan.nextLine();

    System.out.println("What is your character's name?");
    String inputName = scan.nextLine();

    System.out.println("What is your character's level?");
    int inputLvl = scan.nextInt();

String actualInputRace = "";
String actualInputClass = "";
    switch(inputRace) {
      case 1: actualInputRace = "Human";

    }
    switch(inputClass) {
      case 1: actualInputClass = "Fighter";

    }
    System.out.println(inputRace + " " + inputClass);



    newCharacter = new Character(inputName, allClasses.get(actualInputClass), allRaces.get(actualInputRace), inputLvl, inputStrScore, inputDexScore,
    inputConScore, inputIntScore, inputWisScore, inputCharScore);

    System.out.println(newCharacter.getCharacterRace());
    newCharacter.getCharacterRace().setCharacter(newCharacter);
    newCharacter.getCharacterRace().editScores();

    newCharacter.getCharacterClass().setCharacter(newCharacter);
    newCharacter.getCharacterClass().setLvl(inputLvl);

    return newCharacter;
  }

  public Race getCharacterRace() { return this.characterRace; }
  public CharacterClass getCharacterClass() {return this.characterClass; }

  public void setCharacterRace(Race newRace) { this.characterRace = newRace; }
  public void setCharacterClass(CharacterClass newClass) { this.characterClass = newClass; }
}
