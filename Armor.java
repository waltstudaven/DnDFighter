/**
* Weapon class
*
* @author Katie Spiese
* @version 10-26-18
*/
public enum Armor implements Equipment{

  LEATHER(10, 11, true, 50, 0, false, 10, "light", "leather"),
  PADDED(5, 11, true, 50, 0, true, 8, "light", "padded"),
  STUDDEDLEATHER(45, 12, true, 50, 0, false, 13, "light", "studded leather"),

  HIDE(10, 12, true, 2, 0, false, 12, "medium", "hide"),
  BREASTPLATE(400, 14, true, 2, 0, false, 20, "medium", "breastplate"),
  HALFPLATE(750, 15, true, 2, 0, true, 40, "medium", "half plate"),
  CHAINSHIRT(50, 13, true, 2, 0, false, 20, "medium", "chain shirt"),
  SCALEMAIL(50, 14, true, 2, 0, true, 45, "medium", "scale mail"),

  RINGMAIL(30, 14, false, 0, 0, true, 40, "heavy", "ring mail"),
  PLATE(1500, 18, false, 0, 15, true, 65, "heavy", "plate"),
  CHAINMAIL(75, 16, false, 0, 13, true, 55, "heavy", "chainmail"),
  SPLINT(200, 17, false, 0, 15, true, 60, "heavy", "splint");

  public int cost;
  public int baseAc;
  public boolean dex;
  public int maxDex;
  public int minStr;
  public boolean stealthDisAdv;
  public int weight;
  public String armorSize;
  public String name;

  public Character thisCharacter;



  //constructs the weapons stuff
  private Armor(int cost, int baseAc, boolean dex, int maxDex, int minStr,
  boolean stealthDisAdv, int weight, String armorSize, String name) {
    this.cost = cost;
    this.baseAc = baseAc;
    this.dex = dex;
    this.maxDex = maxDex;
    this.minStr = minStr;
    this.stealthDisAdv = stealthDisAdv;
    this.weight = weight;
    this.armorSize = armorSize;
    this.name = name;
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


  @Override
    public boolean isWeapon() { return false; }

    @Override
    public String getName() {
      return name;
    }

}
