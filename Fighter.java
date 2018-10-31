public class Fighter extends CharacterClass{
  Character thisCharacter;

  public Fighter(int level, Character thisCharacter) {
    super.level = level;
    super.profBonus = setProfBonusViaLevel(level);
    super.hitDie = new Die(10);
    this.thisCharacter = thisCharacter;
  }

  @Override
  private void setLvlOne() {
    thisCharacter.setStrSaveProf();
    thisCharacter.setConSaveProf();
  }

  @Override
  public void determineHealth() {
    int health = 10 + thisCharacter.getConMod;

    for (int i = 2; i <= level; i++) {
      health += 6 + thisCharacter.getConMod;
    }
    thisCharacter.setMaxHp(health);
  }

  @Override
  public void setSaveThrowsProf() {
    thisCharacter.setStrSaveProf();
    thisCharacter.setConSaveProf();
  }

  private void setSkills(String skill1, String skill2) {
  }

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
  }
}
