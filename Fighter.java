import java.util.Scanner;
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
    System.out.println("What would you like your fighting style to be from this list:" + "\nArchery" +
    "\nDefense" + "\nDueling" +"\nGreat Weapon Fighting");
    Scanner scan = new Scanner(System.in);
    String fightSyle = scan.nextLine();
    setFightStyle(fightStyle);
    determineHealth();
  }

  @Override
  public void determineHealth() {
    int health = 10 + super.thisCharacter.getConMod();

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
    if (fightStyle.equalsIgnoreCase("archery")) fightStyle += "archery";
    else if (fightStyle.equalsIgnoreCase("defense")) {
      super.thisCharacter.setAc(super.thisCharacter.getAc() +1);
      fightStyle += "defense";
    }

    else if (fightStyle.equalsIgnoreCase("dueling")) fightStyle += "dueling";
    else if (fightStyle.equalsIgnoreCase("great weapon fighting"))
    fightStyle += "great weapon fighting";
  }

  public void setLevel(int level) {
    if (level == 1) {
      setLvlOne();
      super.thisCharacter.setProfBonus(2);
    }
  }

  public int rollToAttack(Weapon weapon) {
    int attackRoll = weapon.rollToAttack();
    String weaponProperties = weapon.getProperties();

    if (weaponProperties.contains("finesse") || weaponProperties.contains("ranged")){
      if (fightStyle.contains("archery")) {
        attackRoll += super.thisCharacter.getDexMod() + 2;
      }
      attackRoll += super.thisCharacter.getDexMod() + super.thisCharacter.getProfBonus();
    }
    else {
      attackRoll += super.thisCharacter.getStrMod() + super.thisCharacter.getProfBonus();
    }

    return attackRoll;
  }

  public int rollDamage(Weapon weapon) {
    int damage = weapon.rollDamage();
    String weaponProperties = weapon.getProperties();

    if (weaponProperties.contains("range") || weaponProperties.contains("finesse")) {
      if (fightStyle.contains("dueling") && !weaponProperties.contains("range")) {
        damage += super.thisCharacter.getDexMod() + 2;
      }
      else {
        damage += super.thisCharacter.getDexMod();
      }
    }
    else {
      if (weaponProperties.contains("twoHanded")) {
        if (fightStyle.contains("great weapon fighting")) {
          if (damage == 1 || damage == 2) {
            damage = super.thisCharacter.weapon.rollDamage() + super.thisCharacter.getStrMod();
          }
        }
        damage += super.thisCharacter.getStrMod();
      }
      if (fightStyle.contains("dueling") && !weaponProperties.contains("range")) {
        damage += super.thisCharacter.getStrMod() + 2;
      }
    }
    return damage;
  }


  @Override
  public String toString() {
    return "Fighter";
  }
}
