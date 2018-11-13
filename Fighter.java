import java.util.Scanner;
import java.util.ArrayList;

/**
* Fighter is a character's class that will determine a character's
* skills, attacks, and health.
*/
public class Fighter extends CharacterClass{

  /**
  * The fighting style for Fighter determines specific attributes of a character such as their AC, Weapon Type, and
  * Weapon Damage.
  */
  String fightStyle;

  /*
  * Constructor for a fighter.
  * @param level Level of character
  * @param thisCharacter
  */
  public Fighter() {
    setProfBonusViaLevel(level);
    super.hitDie = new Die(10);
    fightStyle = "";
  }

  /**
  * Determines the strength and other bonuses for level 1 character.
  */
  @Override
  public void setLvlOne() {
    super.thisCharacter.setProfBonus(2);
    super.thisCharacter.setStrSaveProf();
    super.thisCharacter.setConSaveProf();


    //fighting style
    System.out.println("What would you like your fighting style to be from this list:" + "\nArchery" +
    "\nDefense" + "\nDueling" +"\nGreat Weapon Fighting");
    Scanner scan = new Scanner(System.in);
    String fightStyle = scan.nextLine();
    setFightStyle(fightStyle);

    determineHealth();
    addEquipment();
  }

  /**
  * Queries the user for weapons and equipment.
  */
  public void addEquipment() {
    //create the ArrayList to store all the equipment
    ArrayList<Equipment> characterEqupiment = super.thisCharacter.getEquipment();
    //is referenced alot
    Character mainCharacter = super.thisCharacter;
    //the main character automatically gets a longbow
    characterEqupiment.add(Weapon.LONGBOW);
    Scanner scan = new Scanner(System.in);
    //choice 1
    System.out.println("Would you like (a) chainmail or (b) leather armor?");
    String armor = scan.nextLine();
    //makes it easier to say the choice
    if (armor.equals("a")) {
      //if the character can equipt chainmail then give it chainmail
      if (super.thisCharacter.canEquip(Armor.CHAINMAIL)) {
        thisCharacter.equipt(Armor.CHAINMAIL);
        characterEqupiment.add(Armor.CHAINMAIL);
      }
      else {
        //otherwise it has to take leather armor
        System.out.println("Assigning " + mainCharacter.getName() + " Leather Armor");
        characterEqupiment.add(Armor.LEATHER);
        thisCharacter.equipt(Armor.LEATHER);
      }
    }
    else {
      //otherwise it chose to take the leather armor
      System.out.println("Assigning " + mainCharacter.getName() + " Leather Armor");
      characterEqupiment.add(Armor.LEATHER);
      thisCharacter.equipt(Armor.LEATHER);
    }
    //choice 2
    System.out.println("Would you like (a) a martial weapon and a shield or (b) two martial weapons?");
    String weapons1 = scan.nextLine();
    //create an arraylist that holds all the martial weapons
    ArrayList<Weapon> choices = new ArrayList<>();
    for (String w: Weapon.allWeapons.keySet()) {
      if (Weapon.allWeapons.get(w).getWeaponType().contains("martial")){
        System.out.println(w);
        choices.add(Weapon.allWeapons.get(w));
      }
    }
    //if they chose one weapon and one shield
    if (weapons1.equals("a")) {
      System.out.println("What martial weapon would you like?");
      String martialChoice = scan.nextLine();
      //if the weapon they chose was in the list then add it to their equipment
      for (Weapon w: choices) {
        if (martialChoice.equals(w.toString())) {
          characterEqupiment.add(w);
          break;
        }
      }
      //shield
      super.thisCharacter.setAc(super.thisCharacter.getAc() + 2);
    }
    //otherwise they chose two martial weapons
    else {
      //first weapon
      System.out.println("What is the first martial weapon you would like?");
      String martialChoice = scan.nextLine();

      for (Weapon w: choices) {
        if (martialChoice.equals(w.toString())) {
          characterEqupiment.add(w);
          break;
        }
      }
      //second weapon
      System.out.println("What is the second martial weapon you would like?");
      String martialChoice2 = scan.nextLine();
      for (Weapon w: choices) {
        if (martialChoice2.equals(w.toString())) {
          characterEqupiment.add(w);
          break;
        }
      }
    }

    //last choice
    System.out.println("Would you like (a) a light crossbow or (b) two handaxes?");
    String weapons2 = scan.nextLine();

    //they chose a crossbow
    if (weapons2.equals("a")) {
      characterEqupiment.add(Weapon.CROSSBOWLIGHT);
    }
    //they chose two handaxes
    else {
      characterEqupiment.add(Weapon.HANDAXE);
      characterEqupiment.add(Weapon.HANDAXE);
    }
  }

  @Override
  public void determineHealth() {
    //for the first level
    int health = 10 + super.thisCharacter.getConMod();
    //for every level after the first
    for (int i = 2; i <= level; i++) {
      health += 6 + super.thisCharacter.getConMod();
    }
    super.thisCharacter.setMaxHp(health);
  }

  @Override
  public void setSaveThrowsProf() {
    super.thisCharacter.setStrSaveProf();
    super.thisCharacter.setConSaveProf();
  }

  @Override
  public String getSaveThrows() {
    return "Strength: " + super.thisCharacter.getStrSave() + "\t" + "Constitution: " + super.thisCharacter.getConSave();
  }
  /**
  * Sets the skills of the Fighter. A fighter has 2 skills.
  */
  // private void setSkills(String skill1, String skill2) {
  // }

  // private void setSkills(String skill1, String skill2) {
  // }

  private void setFightStyle(String fightStyle) {
    //for later use
    if (fightStyle.equalsIgnoreCase("archery")) this.fightStyle += "archery";
    else if (fightStyle.equalsIgnoreCase("defense")) {
      //the characters ac is equal to it's ac plus 1
      super.thisCharacter.setAc(super.thisCharacter.getAc() +1);
      this.fightStyle += "defense";
    }
    else if (fightStyle.equalsIgnoreCase("dueling")) this.fightStyle += "dueling";
    else if (fightStyle.equalsIgnoreCase("great weapon fighting")) this.fightStyle += "great weapon fighting";
  }
  /**
  * Sets the current level of the fighter.
  * @param level level
  */
  public void setLevel(int level) {
    if (level == 1) {
      setLvlOne();
      super.thisCharacter.setProfBonus(2);
    }
  }
  /**
  * Rolls a dice and determines thes attack type and weighs the
  */
  public int rollToAttack(Weapon weapon) {
    int attackRoll = weapon.rollToAttack();                                           //base roll
    String weaponProperties = weapon.getProperties();                                 //to store the weapon's properties

    if (weaponProperties.contains("finesse") || weaponProperties.contains("ranged")){ //if the weapon property is ranged or finesse
      if (fightStyle.contains("archery")) {                                           //if they chose an archery fighting style
        attackRoll += super.thisCharacter.getDexMod() + 2;                            //they get a plus 2 to attack
      }
      attackRoll += super.thisCharacter.getDexMod() + super.thisCharacter.getProfBonus(); //otherwise it uses their dex (assumes is proficient)
    }
    else {
      attackRoll += super.thisCharacter.getStrMod() + super.thisCharacter.getProfBonus(); //otherwise it is not finesse and is melee so uses strength (assumes is proficient)
    }
    return attackRoll;                                                                    //return the attackrole
  }

  public int rollDamage(Weapon weapon) {
    int damage = weapon.rollDamage();                                                     //base roll
    String weaponProperties = weapon.getProperties();                                     //holds the weapons properties
    if (weaponProperties.contains("range") || weaponProperties.contains("finesse")){      //if the weapon uses dex
      if (fightStyle.contains("dueling") && !weaponProperties.contains("range")) {
        damage += super.thisCharacter.getDexMod() + 2;                                    //if they chose dueling as their fighting style
      }
      else { damage += super.thisCharacter.getDexMod(); }                                 //if they did not chose dueling as their fighting style
    }
    else {
      if (weaponProperties.contains("twoHanded")) {                                       //if the weapon is two handed
        if (fightStyle.contains("great weapon fighting")) {                               //if the fighting style is GWF
          if (damage == 1 || damage == 2) {                                               //if the base rolll was a 1 or 2
            damage = super.thisCharacter.weapon.rollDamage() + super.thisCharacter.getStrMod(); //they get to reroll the base
          }
        }
        damage += super.thisCharacter.getStrMod();                                        //add in the strMod
      }
      if (fightStyle.contains("dueling") && !weaponProperties.contains("range")) {        //dueling also gives bonuses to all melee attacks
        damage += super.thisCharacter.getStrMod() + 2;
      }
    }
    return damage;
  }


  @Override
  public String toString() {
    return "Fighter \t Fighting Style: " + fightStyle;
  }
}
