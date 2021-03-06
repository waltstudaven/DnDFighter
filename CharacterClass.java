
/**
* The abstract character class will be extended by all of the different
* classes such as Fighter, Barbarian, etc.
*/

import java.util.ArrayList;

public abstract class CharacterClass {
  public int level;
  public int profBonus;
  protected Die hitDie;
  public ArrayList<String> allClassActions;
  protected Character thisCharacter;

  public void setProfBonusViaLevel(int level) {
    if (level < 5) setProfBonus(2);
    else if (level < 9 && level >= 5) setProfBonus(3);
    else if (level < 13 && level >= 9) setProfBonus(4);
    else if (level < 17 && level >= 13) setProfBonus(5);
    else if (level < 20 && level >= 17) setProfBonus(6);
    else {
      System.out.println("Not a valid level");
    }
  }
  public void setProfBonus(int profBonus) { this.profBonus = profBonus; }
  public int getProfBonus() { return profBonus; }


  public void setCharacter(Character character) {
    this.thisCharacter = character;
  }

  public void setLevel(int level) { this.level = level; }
  public int getLevel() { return this.level; }

  public abstract void setSaveThrowsProf();

  public abstract void determineHealth();

  public void setLvl(int level){ if(level >= 1) setLvlOne(); }

  public abstract void setLvlOne();

    public abstract void attack(Weapon weapon, Monster enemy);

  public abstract String getSaveThrows();

}
