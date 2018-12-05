class FighterTest {
  private static Character hero;
  public static void main(String[] args) {
    CharacterCreation tester = new CharacterCreation();
    hero = tester.characterCreator();
    FighterTest test = new FighterTest(hero);
  }

  public FighterTest (Character hero) {
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
