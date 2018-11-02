/**
 * Fighter is a character's class that will determine a character's
 * skills, attacks, and health.
 */
public class Fighter extends CharacterClass{
<<<<<<< HEAD
Character thisCharacter;
	/*
	 * Constructor for a fighter.
	 * @param level Level of character
	 * @param thisCharacter 
	 */
    public Fighter(int level, Character thisCharacter) {
      super.level = level;
      super.profBonus = setProfBonusViaLevel(level);
      super.hitDie = new Die(10);
      this.thisCharacter = thisCharacter;
    }
    /**
     * 
     */
    @Override
    private void setLvlOne() {
      thisCharacter.setStrSaveProf();
      thisCharacter.setConSaveProf();
    }
    /**
     * Sets the skills of the Fighter. A fighter has 2 skills.
     */
    private void setSkills(String skill1, String skill2) {
    }
    /**
     * The fighting style for Fighter determines specific attributes of a character such as their AC, Weapon Type, and
     * Weapon Damage.
     */
    private void setFightStyle(String fightStyle) {
        if (fightStyle.equalsIgnoreCase("archery")) {
            if (thisCharacter.Weapon.ranged()) thisCharacter.Weapon.roleToAttack() = thisCharacter.Weapon.roleToAttack() +2;
        }
        else if (fightStyle.equalsIgnoreCase("defense")) thisCharacter.setAc(thisCharacter.getAc() +1);
        else if (fightStyle.equalsIgnoreCase("dueling")) {
          if (thisCharacter.numEquiptWeapon == 1 && thisCharacter.Weapon.melee()) {
            thisCharacter.Weapon.rollDamage() = thisCharacter.Weapon.rollDamage() +2;
          }
        }
        else if (fightStyle.equalsIgnoreCase("great weapon fighting")) {
          if (thisCharacter.Weapon.twoHanded() || thisCharacter.Weapon.versatile() && thisCharacter.numEquiptWeapon == 2) {
            if (thisCharacter.Weapon.rollDamage() == 1 || thisCharacter.Weapon.rollDamage() == 2) {
              thisCharacter.Weapon.rollDamage() = thisCharacter.Weapon.rollDamage();
            }
          }
        }
=======
  Character thisCharacter;
  String fightStyle;

  public Fighter(int level, Character thisCharacter) {
    super.level = level;
    setProfBonusViaLevel(level);
    super.hitDie = new Die(10);
    this.thisCharacter = thisCharacter;
    fightStyle = "";
  }

  @Override
  public void setLvlOne() {
    thisCharacter.setStrSaveProf();
    thisCharacter.setConSaveProf();
  }

  @Override
  public void determineHealth() {
    int health = 10 + thisCharacter.getConMod();

    for (int i = 2; i <= level; i++) {
      health += 6 + thisCharacter.getConMod();
    }
    thisCharacter.setMaxHp(health);
  }

  @Override
  public void setSaveThrowsProf() {
    thisCharacter.setStrSaveProf();
    thisCharacter.setConSaveProf();
  }

  @Override
  public String getSaveThrows() {
    return "Strength: " + thisCharacter.getStrSave() + "\t" + "Constitution: " + thisCharacter.getConSave();
  }
>>>>>>> 5b1079f08d647d799ccaf2222bb86eb2f0298988

  // private void setSkills(String skill1, String skill2) {
  // }

  // private void setSkills(String skill1, String skill2) {
  // }

  private void setFightStyle(String fightStyle) {
    if (fightStyle.equalsIgnoreCase("archery")) fightStyle += "archery";
    else if (fightStyle.equalsIgnoreCase("defense")) {
      thisCharacter.setAc(thisCharacter.getAc() +1);
      fightStyle += "defense";
    }

    else if (fightStyle.equalsIgnoreCase("dueling")) fightStyle += "dueling";
    else if (fightStyle.equalsIgnoreCase("great weapon fighting"))
    fightStyle += "great weapon fighting";
  }


  public int rollToAttack(Weapon weapon) {
    int attackRoll = weapon.rollToAttack();
    String weaponProperties = weapon.getProperties();

    if (weaponProperties.contains("finesse") || weaponProperties.contains("ranged")){
      if (fightStyle.contains("archery")) {
        attackRoll += thisCharacter.getDexMod() + 2;
      }
      attackRoll += thisCharacter.getDexMod() + thisCharacter.getProfBonus();
    }
    else {
      attackRoll += thisCharacter.getStrMod() + thisCharacter.getProfBonus();
    }

    return attackRoll;
  }

  public int rollDamage(Weapon weapon) {
    int damage = weapon.rollDamage();
    String weaponProperties = weapon.getProperties();

    if (weaponProperties.contains("range") || weaponProperties.contains("finesse")) {
      if (fightStyle.contains("dueling") && !weaponProperties.contains("range")) {
        damage += thisCharacter.getDexMod() + 2;
      }
      else {
        damage += thisCharacter.getDexMod();
      }
    }
    else {
      if (weaponProperties.contains("twoHanded")) {
        if (fightStyle.contains("great weapon fighting")) {
          if (damage == 1 || damage == 2) {
            damage = thisCharacter.weapon.rollDamage() + thisCharacter.getStrMod();
          }
        }
        damage += thisCharacter.getStrMod();
      }
      if (fightStyle.contains("dueling") && !weaponProperties.contains("range")) {
        damage += thisCharacter.getStrMod() + 2;
      }
    }
      return damage;
  }

}
