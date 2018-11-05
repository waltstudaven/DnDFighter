import java.util.HashMap;

public class Tester{

  public static void main(String[] args){

    Tester tester = new Tester();
    Character myCharacter = new Character("Me", tester.allClasses.get("Fighter"), tester.race.get("Human"), 1, 50, 50, 50, 50, 50, 50);


  }


  
  private HashMap<String, CharacterClass> allClasses;
  public HashMap<String, Race> race;


  public Tester(){
    allClasses = new HashMap<String, CharacterClass>();
    race = new HashMap<String, Race>();
    race.put("Human", new Human());
    allClasses.put("Fighter", new Fighter(1, character));

    character = new Character("Me", allClasses.get("Fighter"), race.get("Human"), 1, 50, 50, 50, 50, 50, 50);
  }

}
