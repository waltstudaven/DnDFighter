public class Human implements Race {
    Character character;

    public Human() {

    }

    public void editScores(){
        character.setStrScore(character.getStrScore() +1);
        character.setDexScore(character.getDexScore() +1);
        character.setConScore(character.getConScore() +1);
        character.setIntScore(character.getIntScore() +1);
        character.setWisScore(character.getWisScore() +1);
        character.setCharScore(character.getCharScore() +1);
    }
}
