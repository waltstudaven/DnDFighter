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
    if (null != mainHand && mainHand.equals(weapon)) {
      numHandsAvail++;
      mainHand = null;
    }
    if (null != offHand && offHand.equals(weapon)) {
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
    String toString = "\nName: " + this.getName() + "\n";
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
      System.out.println("Options: \n\t-> (a) Action");
      if (numFreeActionAvail > 0 || numBonusActionAvail>0){
        if(numBonusActionAvail >0){
          System.out.println("\t-> (b) Bonus Action");
        }
        if(numFreeActionAvail>0){
          System.out.println("\t-> (c) Free Action");
        }
      }
      String inputAction = scan.nextLine();

      if (inputAction.equalsIgnoreCase("c") && numFreeActionAvail > 0) {
        this.numFreeActionAvail = freeAction(scan, this.numFreeActionAvail, enemy);
      }
      else if (inputAction.equalsIgnoreCase("b") && numBonusActionAvail > 0) {
        this.numBonusActionAvail = bonusAction(scan, this.numBonusActionAvail, enemy);
      }
      else if (inputAction.equalsIgnoreCase("a") && numActionAvail > 0) {
        this.numActionAvail = action(scan, this.numActionAvail, enemy);
      }
      else if (inputAction.equalsIgnoreCase("exit")) {
        break;
      }
    }
    endTurn();
  }


  public void equip(Weapon weapon) {
    if (weapon.numHands() == 1 && this.numHandsAvail >= weapon.numHands()) {
      if (null == this.mainHand) {
        this.numHandsAvail--;
        this.mainHand = weapon;
      }
      else if (null == this.offHand) {
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

  public int freeAction(Scanner scan, int numFreeActionAvail, Monster enemy) {
    System.out.println("What free action would you like to take");
    System.out.println("(b) Inspect Enemy Health\n(c) Sheath Weapon\n(d) Equip Weapon");
    String inputAction = scan.nextLine();

    if (this.numFreeActionAvail > 0) {
      switch (inputAction){
        case "b":
        int roll = this.rollInsight();
        if (roll >= 15) { System.out.println("Enemy Health: " + enemy.getCurrentHp()); }
        System.out.println("INSIGHT ROLL: " + roll);
        this.numFreeActionAvail--;
        break;

        case "c": this.unequip(mainHand);
        this.numFreeActionAvail--;
        break;

        case "d":
        if (numHandsAvail > 0) {
          ArrayList<Weapon> choices = new ArrayList<>();
          for (Equipment e: allEquipment) {
            if (e.isWeapon() && Weapon.getAllWeapons().get(e.getName()).numHands() <= numHandsAvail) {
              choices.add(this.mainHand.getAllWeapons().get(e.getName()));
            }
          }
          for (Weapon w: choices) {
            System.out.println(w);
          }
          System.out.println("chose a weapon");
          inputAction = scan.nextLine();
          for (Weapon w: choices) {
            if (w.getName().equalsIgnoreCase(inputAction)) {
              this.equip(w);
              break;
            }
          }
          this.numFreeActionAvail--;
          break;
        }
      }
    }
    return this.numFreeActionAvail;
  }


  public int bonusAction(Scanner scan, int numBonusActionAvail, Monster enemy) {
    System.out.println("What bonus action would you like to take");
    System.out.println("(a) Attack\n(b) Inspect Enemy Health\n(c) Sheath Weapon\n(d) Equip Weapon");
    String inputAction = scan.nextLine();
    if (numBonusActionAvail > 0) {
      switch (inputAction) {
        case "a":
        if (null == this.offHand) this.attackUnarmed(enemy);
        else if (this.offHand.numHands() < 2) this.characterClass.attack(offHand, enemy);
        else {
          System.out.println("could use your bonus action to attack");
        }
        break;
        // if (offHand.isRanged() || offHand.getProperties().contains("finesse")) {
        //   enemy.setCurrentHp(enemy.getCurrentHp() + this.getDexMod());
        // }
        // enemy.setCurrentHp(enemy.getCurrentHp() + this.getStrMod());
        default:
        freeAction(scan, numBonusActionAvail, enemy);
        break;
      }
    }

    return numBonusActionAvail;
  }

  public int action(Scanner scan, int numActionAvail, Monster enemy) {
    System.out.println("What action would you like to take");
    System.out.println("(a) Attack\n(b) Dodge\n(c) Hide");
    String inputAction = scan.nextLine();
    if (numActionAvail > 0) {
      switch (inputAction) {
        case "a":
        if (null == this.mainHand) {
          attackUnarmed(enemy);
        }
        else { this.characterClass.attack(mainHand, enemy); }
        numActionAvail--;
        break;
        case "b": enemy.attackDisAdv = true;
        numActionAvail--;
        break;
        case "c": this.rollStealth();
        numActionAvail--;
        break;
      }
    }

    return numActionAvail--;
  }


  public Weapon getMainHand() {
    return mainHand;
  }
  public Weapon getOffHand() {
    return offHand;
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

  private void endTurn() {
    this.numFreeActionAvail = 2;
    this.numBonusActionAvail = 1;
    this.numActionAvail = 1;
  }

  public void attackUnarmed(Monster enemy) {
    System.out.println("Current weapon is: Unarmed");
    Die d20 = new Die(20);
    int attackRole = d20.roll();
    System.out.println("you rolled a " + attackRole + this.getStrMod() + " to hit");
    if (attackRole + this.getStrMod() >= enemy.getAc()) {
      enemy.setCurrentHp(enemy.getCurrentHp() - this.getStrMod());
      System.out.println("you did " +this.getStrMod() + " damage");
    }
  }
}
