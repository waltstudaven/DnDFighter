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

    private void setSkills(String skill1, String skill2) {
    }

    private void setFightStyle(String fightStyle) {
        if (fightStyle.equalsIgnoreCase("archery")) {
            if (thisCharacter.Weapon.Ranged()) thisCharacter.Weapon.attackRole = thisCharacter.Weapon.attackRole +2;
        }
        else if (fightStyle.equalsIgnoreCase("defense")) thisCharacter.setAc(thisCharacter.getAc() +1);
        else if (fightStyle.equalsIgnoreCase("dueling")) {
          if (thisCharacter.numEquiptWeapon == 1 && thisCharacter.Weapon.melee()) {
            thisCharacter.Weapon.rollDamage() = thisCharacter.Weapon.rollDamage() + 2;
          }
        }
        else if (fightStyle.equalsIgnoreCase("Great Weapon Fighting")) {
          if (thisCharacter.Weapon.twoHanded() || thisCharacter.Weapon.versatile() && thisCharacter.numEquiptWeapon == 2) {
            if (thisCharacter.Weapon.rollDamage() == 1 || thisCharacter.Weapon.rollDamage() == 2) {
              thisCharacter.Weapon.rollDamage() = thisCharacter.Weapon.rollDamage();
            }
          }
        }

    }
  }
