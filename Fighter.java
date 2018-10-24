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
      thisCharacter.setDexSaveProf();
    }
  }
