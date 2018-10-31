import java.util.ArrayList;
public class Character extends Monster {
  private final String NAME;
  public CharacterClass characterClass;
  public Race characterRace;
  public int level, profBonus;
  public ArrayList<String> allActions;
  public int i = 0;


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
