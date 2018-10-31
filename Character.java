public class Character extends Monster {
  private final String NAME;
  public CharacterClass characterClass;
  public Race characterRace;
  public int level, profBonus;

  public Character (String NAME, CharacterClass characterClass, Race characterRace, int level,
  int strScore, int dexScore, int conScore, int intScore, int wisScore, int charScore) {
    super (hp, Sizes.MEDIUM, ac, 0, strScore, dexScore, conScore,
  	intScore, wisScore, charScore);

    this.NAME = NAME;
    this.characterClass = characterClass;
    this.characterRace = characterRace;
    this.level = level;
    this.profBonus = profBonus;
  }

  @Override
  public void resetHealth() {
    this.setHp(this.getHp());
  }
}
