/**
* Weapon class
*
* @author Katie Spiese
* @version 10-26-18
*/
public enum Armor implements Equipment{

  LEATHER(10, 11, true, 50, 0, false, 10, "light"),
  PADDED(5, 11, true, 50, 0, true, 8, "light"),
  STUDDEDLEATHER(45, 12, true, 50, 0, false, 13, "light"),

  HIDE(10, 12, true, 2, 0, false, 12, "medium"),
  BREASTPLATE(400, 14, true, 2, 0, false, 20, "medium"),
  HALFPLATE(750, 15, true, 2, 0, true, 40, "medium"),
  CHAINSHIRT(50, 13, true, 2, 0, false, 20, "medium"),
  SCALEMAIL(50, 14, true, 2, 0, true, 45, "medium"),

  RINGMAIL(30, 14, false, 0, 0, true, 40, "heavy"),
  PLATE(1500, 18, false, 0, 15, true, 65, "heavy"),
  CHAINMAIL(75, 16, false, 0, 13, true, 55, "heavy"),
  SPLINT(200, 17, false, 0, 15, true, 60, "heavy");

  public int cost;
  public int baseAc;
  public boolean dex;
  public int maxDex;
  public int minStr;
  public boolean stealthDisAdv;
  public int weight;
  public String armorSize;

  public Character thisCharacter;



  //constructs the weapons stuff
  private Armor(int cost, int baseAc, boolean dex, int maxDex, int minStr,
  boolean stealthDisAdv, int weight, String armorSize) {
    this.cost = cost;
    this.baseAc = baseAc;
    this.dex = dex;
    this.maxDex = maxDex;
    this.minStr = minStr;
    this.stealthDisAdv = stealthDisAdv;
    this.weight = weight;
    this.armorSize = armorSize;
  }

  public void assignCharacter(Character character) {
    this.thisCharacter = character;
  }

  public int getCost(){ return this.cost; }
  public int getBaseAc(){ return this.baseAc; }
  public boolean getDex(){ return this.dex; }
  public int getMaxDex(){ return this.maxDex; }
  public int getMinStr(){ return this.minStr; }
  public boolean getStealthDisAdv(){ return this.stealthDisAdv; }
  public int getWeight(){ return this.weight; }
  public String armorSize(){ return this.armorSize; }

  public void equipt(Armor armor) {
    int lowerDex = 0;

    if (thisCharacter.getDexMod > armor.getMaxDex) { lowerDex = armor.getMaxDex; }
    else { lowerDex = thisCharacter.getDexMod; }

    if (thisCharacter.getStrScore() < armor.getMinStr()) {
      System.out.println("You can not equipt this armor. Your strength score is " + thisCharacter.getStrScore() +
      " and the required minimum strength to equipt this armor is " + armor.getMinStr());
    }
    else {
      thisCharacter.setAc(armor.getBaseAc() + lowerDex);
      if (getStealthDisAdv) { thisCharacter.setStealthDisAdv(true); }
    }
  }


}
