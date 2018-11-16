import java.util.ArrayList;
import java.util.Scanner;
public class Character extends Monster {
  private final String NAME;
  public CharacterClass characterClass;
  public Race characterRace;
  public int level, profBonus;
  public int i = 0;
  public Weapon mainHand;
  public Weapon offHand;
  public int numHandsAvail;
  public Armor currentArmor;

  public int numFreeActionAvail, numBonusActionAvail, numActionAvail;

  public ArrayList<Equipment> allEquipment;


  public ArrayList<String> allActions, allBonusActions, allFreeActions;

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
    numFreeActionAvail = 2;
    numBonusActionAvail = 1;
    numActionAvail = 1;
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
  //public void equipWeapon(Weapon weapon) { this.weapon = weapon; }

  public void unequip(Weapon weapon) {
    if (mainHand.equals(weapon)) {
      numHandsAvail++;
      mainHand = null;
    }
    if (offHand.equals(weapon)) {
      numHandsAvail++;
      offHand = null;
    }
  }

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

  public void equip(Armor armor) {
    int lowerDex = 0;

    if (this.canEquip(armor)){
      this.unequipArmor();
      if (this.getDexMod() > armor.getMaxDex()) { lowerDex = armor.getMaxDex(); }
      else { lowerDex = this.getDexMod(); }
      this.setAc(this.getAc() + armor.getBaseAc() + lowerDex);
      if (armor.getStealthDisAdv()) { this.setStealthDisAdv(true); }
      this.setArmor(armor);
    }
    else System.out.println("armor could not be equipped");
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

  public void turn(Monster enemy) {

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
        this.numFreeActionAvail = freeAction(inputAction, this.numFreeActionAvail, enemy);
      }
      else if (inputAction.equalsIgnoreCase("Bonus Action") && numBonusActionAvail > 0) {
        this.numBonusActionAvail = bonusAction(inputAction, this.numBonusActionAvail, enemy);
      }
      else if (inputAction.equalsIgnoreCase("Action") && numActionAvail > 0) {
        this.numActionAvail = action(inputAction, this.numActionAvail, enemy);
      }
    }
  }


  public void equip(Weapon weapon) {
    if (weapon.numHands() == 1 && this.numHandsAvail >= weapon.numHands()) {
      if (this.mainHand.equals(null)) {
        this.numHandsAvail--;
        this.mainHand = weapon;
      }
      else if (this.offHand.equals(null)) {
        this.numHandsAvail--;
        this.offHand = weapon;
      }
      else System.out.println("for some reason you could not equip this weapon");
    }

    else if (weapon.numHands() == 2 && this.numHandsAvail >= weapon.numHands()) {
      this.mainHand = weapon;
      this.offHand = weapon;
      numHandsAvail -= 2;
    }

    else System.out.println("could not equip this weapon");
  }

  public int freeAction(String inputAction, int numFreeActionAvail, Monster enemy) {
    if (numFreeActionAvail > 0) {
      switch (inputAction){
        case "inspect enemy health": this.rollInsight(); numFreeActionAvail--;
        case "sheath weapon": this.unequip(mainHand); numFreeActionAvail--;
        case "equip":
        if (numHandsAvail > 0) {
          ArrayList<Weapon> choices = new ArrayList<>();
          for (Equipment e: allEquipment) {
            if (e.isWeapon() && this.mainHand.getAllWeapons().get(e.getName()).numHands() <= numHandsAvail) {
              choices.add(this.mainHand.getAllWeapons().get(e.getName()));
            }
          }
          System.out.println("chose a weapon");
          Scanner scan = new Scanner(System.in);
          inputAction = scan.nextLine();
          for (Weapon w: choices) {
            if (w.getName().equalsIgnoreCase(inputAction)) this.equip(w);
          }
          numFreeActionAvail--;
          break;
        }
      }
    }
    return numFreeActionAvail;
  }
  public int bonusAction(String inputAction, int numBonusActionAvail, Monster enemy) {
    if (numBonusActionAvail > 0) {
      freeAction(inputAction, numBonusActionAvail, enemy);
      switch (inputAction) {
        case "attack": if (this.offHand.numHands() < 2) this.characterClass.attack(offHand, enemy);
        if (offHand.isRanged() || offHand.getProperties().contains("finesse")) {
          enemy.setCurrentHp(enemy.getCurrentHp() + this.getDexMod());
        }
        enemy.setCurrentHp(enemy.getCurrentHp() + this.getStrMod());
      }
    }

    return numBonusActionAvail;
  }

  public int action(String inputAction, int numActionAvail, Monster enemy) {
    if (numActionAvail > 0) {
      switch (inputAction) {
        case "attack": this.characterClass.attack(mainHand, enemy);
        numActionAvail--;
        case "dodge": enemy.attackDisAdv = true;
        numActionAvail--;
        case "hide": this.rollStealth();
        numActionAvail--;
        break;
      }
    }

    return numActionAvail--;
  }

  public void setArmor(Armor armor) { currentArmor = armor; }

  public Armor getArmor() { return currentArmor; }

  public void unequipArmor() {
    int lowerDex = 0;

    if (null == this.getArmor()) {
      return;
    }
    if (this.getDexMod() > this.getArmor().getMaxDex()) { lowerDex = this.getArmor().getMaxDex(); }
    else { lowerDex = this.getDexMod(); }
    this.setAc(this.getAc() - this.getArmor().getBaseAc() - lowerDex);
    this.setArmor(null);
  }
}
