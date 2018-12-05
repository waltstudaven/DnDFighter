/**
* A race class that determines certain attributes about a character.
*/
public class Human extends Race {

  public Human() {}

    @Override
    public void editScores(){
      super.getCharacter().setStrScore(super.getCharacter().getStrScore() +1);
      super.getCharacter().setDexScore(super.getCharacter().getDexScore() +1);
      super.getCharacter().setConScore(super.getCharacter().getConScore() +1);
      super.getCharacter().setIntScore(super.getCharacter().getIntScore() +1);
      super.getCharacter().setWisScore(super.getCharacter().getWisScore() +1);
      super.getCharacter().setCharScore(super.getCharacter().getCharScore() +1);
    }

    @Override
    public String toString() { return "Human"; }
  }
