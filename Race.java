/**
 * Race is a class that will be implemented by the different race categories.
 * Each Race will determine certain attributes of a character.
 * @version 1.0
 */
public abstract class Race {
  Character thisCharacter;
    public abstract void editScores();
    public void setCharacter(Character character) {
      this.thisCharacter = character;
    }

    public Character getCharacter() {
      return thisCharacter;
    }
}
