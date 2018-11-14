public class Arena {
  public static void main(String[] args) {

  }

  public Arena(Monster m1, Monster m2) {

  }

  public Monster rollInitiative(Monster m1, Monster m2) {
    int firstRoll = m1.rollInitiative();
    int secondRoll = m2.rollInitiative();

    if (firstRoll > secondRoll) {
      return m1;
    }
    else if (firstRoll < secondRoll) {
      return m2;
    }
    if (m1.getDexScore() > m2.getDexScore()) {
      
    }
  }
}
