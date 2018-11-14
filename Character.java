import java.util.ArrayList;
import java.util.Scanner;
public class Character extends Monster {
  private final String NAME;
  public CharacterClass characterClass;
  public Race characterRace;
  public int level, profBonus;
  public int i = 0;
  public Weapon weapon;
  public int numHandsAvail;

  public ArrayList<Equipment> allEquipment;


  public ArrayList<String> allActions;
  public ArrayList<String> allBonusActions;
  public ArrayList<String> allFreeActions;

  public Character (String NAME, CharacterClass characterClass, Race characterRace, int level,
  int strScore, int dexScore, int conScore, int intScore, int wisScore, int charScore) {
    super (Sizes.MEDIUM, 0, strScore, dexScore, conScore,
    intScore, wisScore, charScore);

    this.NAME = NAME;
    this.characterClass = characterClass;
    this.characterRace = characterRace;
    this.level = level;
    this.profBonus = profBonus;

    allEquipment = new ArrayList<>();

    allActions = new ArrayList<>();
    allBonusActions = new ArrayList<>();
    allFreeActions = new ArrayList<>();

    allActions.add("Attack");
    allActions.add("Cast a Spell");
    allActions.add("Dash");
    allActions.add("Disengage");
    allActions.add("Dodge");
    allActions.add("Hide");
    allActions.add("Use an Item");
    allActions.add("Skip turn");

    numHandsAvail= 2;
  }

  public void addAction(String methodName) { allActions.add(methodName); }

  public ArrayList getActions() { return allActions; }

  public ArrayList<Equipment> getEquipment() { return allEquipment; }

  public void displayActions(){
    for(String action: allActions) System.out.println(action);
  }

  /**
  * Equip a weapon in either one or two hands
  * @param weapon
  */
  public void equipWeapon(Weapon weapon) { this.weapon = weapon; }

  public void unequipWeapon() { this.weapon = null; }

  public CharacterClass getCharacterClass() { return this.characterClass; }

  public Race getCharacterRace() { return this.characterRace; }

  @Override
  public void action(Monster enemy) { System.out.println(characterClass); }

  @Override
  public int rollInitiative() { return d20.roll() + this.getDexMod(); }

  @Override
  public boolean isImmune(DamageType damage) {return false;}

  @Override
  public boolean isResistant(DamageType damage) {return false;}

  public String toString() {
    String toString = "";
    toString += "Max HP: " + this.getMaxHp() + " \n";

    toString += "AC: " + this.getAc() + " \n";

    toString += "STR: " + this.getStrScore() + " (" + this.getStrMod() + ")" + " \n";
    toString += "DEX: " + this.getDexScore() + " (" + this.getDexMod() + ")" + " \n";
    toString += "CON: " + this.getConScore() + " (" + this.getConMod() + ")" + " \n";
    toString += "INT: " + this.getIntScore() + " (" + this.getIntMod() + ")" + " \n";
    toString += "WIS: " + this.getWisScore() + " (" + this.getWisMod() + ")" + " \n";
    toString += "CHAR: " + this.getCharScore() + " (" + this.getCharMod() + ")" + " \n";

    toString += "Save Throws: " + this.characterClass.getSaveThrows() + "\n";


    toString += "Class: " + this.getCharacterClass() + " \n";

    toString += "Race: " + this.getCharacterRace() + " \n";

    toString += "Equipment: " + this.getEquipment();
    return toString;
  }

  public void equipt(Armor armor) {
    int lowerDex = 0;

    if (this.getDexMod() > armor.getMaxDex()) { lowerDex = armor.getMaxDex(); }
    else { lowerDex = this.getDexMod(); }
    this.setAc(this.getAc() + armor.getBaseAc() + lowerDex);
    if (armor.getStealthDisAdv()) { this.setStealthDisAdv(true); }
  }

  public boolean canEquip(Armor armor) {
    if (this.getStrScore() < armor.getMinStr()) {
      System.out.println("You can not equipt this armor. Your strength score is " + this.getStrScore() +
      " and the required minimum strength to equipt this armor is " + armor.getMinStr());
      return false;
    }
    else {
      return true;
    }
  }

  public String getName() {
    return this.NAME;
  }

  public void turn() {
    int numFreeActionAvail = 2;
    int numBonusActionAvail = 1;
    int numActionAvail = 1;

    Scanner scan = new Scanner(System.in);

    while (numActionAvail > 0) {
      System.out.println("Options: \t-> Action");
      if (numFreeActionAvail > 0 || numBonusActionAvail>0){
        if(numFreeActionAvail>0){
          System.out.println("\t-> Free Action");
        }
        if(numBonusActionAvail >0){
          System.out.println("\t-> Bonus Action");
        }
      }
      String inputAction = scan.nextLine();

      if (inputAction.equalsIgnoreCase("Free Action") && numFreeActionAvail > 0) {
        System.out.println(allFreeActions);
        System.out.println("Which free action would you like to take");
        inputAction = scan.nextLine();
        switch (inputAction){
          case "inspect enemy health": this.rollInsight(); numFreeActionAvail--;
          case "sheath weapon": this.unequipWeapon(); numFreeActionAvail--;
          case "equip":
          if (numHandsAvail > 0) {
            System.out.println("chose a weapon");
            ArrayList<Weapon> choices = new ArrayList<>();
            for (Equipment e: allEquipment) {
              if (e.isWeapon()) {
                if (numHandsAvail >= (Weapon) e.numHands()){
                  choices.add(e);
                  System.out.println(e + "\n");
                }
              }
            }
            inputAction = scan.nextLine();
            this.equipWeapon(inputAction);
            numFreeActionAvail--;
          }
        }
      }
    }
  }

  public Weapon currentWeapon() { return this.weapon; }
}
