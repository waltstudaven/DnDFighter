public class Fighter extends CharacterClass{
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
