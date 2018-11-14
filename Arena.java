public class Arena {
  public static void main(String[] args) {
    Monster thug = new Thug();
    CharacterCreation creatingCharacter = new CharacterCreation();
    Character mainCharacter = creatingCharacter.characterCreator();

    Arena arena = new Arena();
  }

  public Arena(Monster m1, Character m2) {
    if (rollInitiative(m1, m2) == m1) System.out.println("\t" + fight(m1, m2));
    else System.out.println("\t" +fight (m2, m1));

  }

  public Monster fight(Monster first, Monster second) {
    while (true) {
      if (first.getCurrentHp() < 1) return second;
      else if (second.getCurrentHp() < 1) return first;
      first.turn(second);
      if (second.getCurrentHp() > 0) second.turn(first);
    }
  }

  public Monster rollInitiative(Monster m1, Monster m2) {
    int firstRoll = m1.rollInitiative();
    int secondRoll = m2.rollInitiative();

    if (firstRoll > secondRoll) return m1;
    else if (firstRoll < secondRoll) return m2;

    if (m1.getDexScore() > m2.getDexScore()) return m1;
    else if (m1.getDexScore() < m2.getDexScore()) return m2;

    return rollInitiative(m1, m2);
  }
}
