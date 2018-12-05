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


    System.out.println("");


    int inputStrScore = 0;
    while(true){
      try{
        System.out.println("What is your character's strength score?");
        inputStrScore = scan.nextInt();
        scan.nextLine();
        break;
      }
      catch(Exception e){
        scan.nextLine();
        System.out.println("");
        System.out.println("Error: Please enter a number.");
      }
    }
    System.out.println("");

    int inputDexScore = 0;
    while(true){
      try{
        System.out.println("What is your character's dexterity score?");
        inputDexScore = scan.nextInt();
        scan.nextLine();
        break;
      }
      catch(Exception e){
        scan.nextLine();
        System.out.println("");
        System.out.println("Error: Please enter a number.");
      }
    }

    System.out.println("");

    int inputConScore = 0;
    while(true){
      try{
        System.out.println("What is your character's constitution score?");
        inputConScore = scan.nextInt();
        scan.nextLine();
        break;
      }
      catch(Exception e){
        scan.nextLine();
        System.out.println("");
        System.out.println("Error: Please enter a number.");
      }
    }

    System.out.println("");

    int inputIntScore = 0;
    while(true){
      try{
        System.out.println("What is your character's intelligence score?");
        inputIntScore = scan.nextInt();
        scan.nextLine();
        break;
      }
      catch(Exception e){
        scan.nextLine();
        System.out.println("");
        System.out.println("Error: Please enter a number.");
      }
    }

    System.out.println("");


    int inputWisScore = 0;
    while(true){
      try{
        System.out.println("What is your character's wisdom score?");
        inputWisScore = scan.nextInt();
        scan.nextLine();
        break;
      }
      catch(Exception e){
        scan.nextLine();
        System.out.println("");
        System.out.println("Error: Please enter a number.");
      }
    }

    System.out.println("");

    int inputCharScore = 0;
    while(true){
      try{
        System.out.println("What is your character's charisma score?");
        inputCharScore = scan.nextInt();
        scan.nextLine();
        break;
      }
      catch(Exception e){
        scan.nextLine();
        System.out.println("");
        System.out.println("Error: Please enter a number.");
      }
    }

    System.out.println("");

    int inputRace = 0;
    while(true){

      System.out.println("What is your character's race?");
      System.out.print("Options: ");

      int i = 1;
      for(String s: allRaces.keySet()){
        System.out.print("(" + i + ") " + s);
      }
      System.out.println();
      try{
        inputRace = scan.nextInt();

        if(inputRace != 1){
          scan.nextLine();
          System.out.println("");
          System.out.println("Error: Please enter a valid option from the list.");
        }
        else{
          break;
        }
      }catch(Exception e){
        scan.nextLine();
        System.out.println("");
        System.out.println("Error: Please enter a number.");
      }


    }


    System.out.println("");





    int inputClass = 0;
    while(true){

      System.out.println("What is your character's class?");
      System.out.print("Options: ");

      int j = 1;
      for(String s: allClasses.keySet()){
        System.out.print("(" + j + ") " + s);
      }
      System.out.println();
      try{
        inputClass = scan.nextInt();
        scan.nextLine();
        if(inputClass != 1){
          scan.nextLine();
          System.out.println("");
          System.out.println("Error: Please enter a valid option from the list.");
        }
        else{
          break;
        }
      }catch(Exception e){
        scan.nextLine();
        System.out.println("");
        System.out.println("Error: Please enter a number.");
      }
    }


    System.out.println("");



    System.out.println("What is your character's name?");
    String inputName = scan.nextLine();


    System.out.println("");




    int inputLvl = 0;
    while(true){
      try{
        System.out.println("What is your character's level? \n Options: (1)");
        inputLvl = scan.nextInt();
        if(inputLvl != 1){

        }
        else{
          scan.nextLine();
          break;
        }
      }
      catch(Exception e){
        scan.nextLine();
        System.out.println("");
        System.out.println("Error: Please enter a number.");
      }
    }




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
