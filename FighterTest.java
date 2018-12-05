class FighterTest {
  private static Character hero;
  public static void main(String[] args) {
    CharacterCreation tester = new CharacterCreation();
    hero = tester.characterCreator();
    FighterTest test = new FighterTest(hero);
  }

  public FighterTest (Character hero) {
    System.out.println("\n\n\n\n\n\n\n\n AHHHHHHH\n\n\n\n\n\n\n");
    System.out.println("This fight test was conducted by Walter Stuart Davenport." +
    " the test starts out with showing that fighter edited the main character's saving throws" +
    " it continues by making the main character's fighting style \"archery\" then attacking a dummie enemy" +
    " with a longbow. It then adds to the main character's fighting style, this time it is \"defense\"." +
    " The test continues to add to the character's fighting style and tests attacks that will be edited by" +
    " that fighting style.");
    Fighter c = (Fighter) hero.characterClass;
    System.out.println(c.getSaveThrows());

    c.setFightStyle("a");
    System.out.println(c.fightStyle);
    Thug dummie = new Thug();

    c.attack(Weapon.LONGBOW, dummie);
    System.out.println("Enemy HP: " + dummie.getCurrentHp());

    dummie.resetHealth();

    System.out.println("AC: " + hero.getAc());
    c.setFightStyle("b");
    System.out.println(c.fightStyle);
    System.out.println("AC: " + hero.getAc());


    c.setFightStyle("c");
    System.out.println(c.fightStyle);
    c.attack(Weapon.SHORTSWORD, dummie);
    System.out.println("Enemy HP: " + dummie.getCurrentHp());


    dummie.resetHealth();

    c.setFightStyle("d");
    System.out.println(c.fightStyle);
    c.attack(Weapon.LONGSWORD, dummie);
    System.out.println("Enemy HP: " + dummie.getCurrentHp());


    dummie.resetHealth();
  }
}
