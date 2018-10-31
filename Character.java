import java.util.ArrayList;
public class Character extends Monster {
  private final String NAME;
  public CharacterClass characterClass;
  public Race characterRace;
  public int level, profBonus;
  public ArrayList<String> allActions;
  public int i = 0;
  public int handsAvailable;
  public Weapon rightHand;
  public Weapon leftHand;


  public Character (String NAME, CharacterClass characterClass, Race characterRace, int level,
  int strScore, int dexScore, int conScore, int intScore, int wisScore, int charScore) {
    super (Sizes.MEDIUM, 0, strScore, dexScore, conScore,
    intScore, wisScore, charScore);

    this.NAME = NAME;
    this.characterClass = characterClass;
    this.characterRace = characterRace;
    this.level = level;
    this.profBonus = profBonus;
  }

  public void addAction(String methodName) {
    allActions.add(methodName);
  }

  public void displayActions(){
    for(String action: allActions){
      System.out.println(action);
    }
  }

  /**
   * Equip a weapon in either one or two hands
   * @param weapon
   */
  public void equipWeapon(Weapon weapon) {
    if (weapon.isTwoHanded() && handsAvailable > 1) {
      handsAvailable -= 2;
      rightHand = weapon;
      leftHand = weapon;
    }
    else if(!weapon.isTwoHanded() && handsAvailable >0){
      if(rightHand == null){
        rightHand = weapon;
        handsAvailable -= 1;
      }else{
        leftHand = weapon;
        handsAvailable -= 1;
      }
      //if no hands are available de-equip and call equipWeapon again
    } else if(handsAvailable == 0) {
      rightHand = null;
      leftHand = null;
      handsAvailable += 2;
      equipWeapon(weapon);
    }

  }

  @Override
  public void action(Monster enemy) {
    System.out.println(characterClass);
  }

  @Override
  public int rollInitiative() {
    return d20.roll() + this.getDexMod();
  }

  @Override
  public boolean isImmune(DamageType damage) {return false;}
  @Override
  public boolean isResistant(DamageType damage) {return false;}
}
