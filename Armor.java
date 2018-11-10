/**
* Weapon class
*
* @author Katie Spiese
* @version 10-26-18
*/
public enum Armor implements Equipment{

  CLUB("1d4", DamageType.BLUDGEONING, "light"),

  LEATHER(10, 11, true, null, null, null, 10, "light"),
  PADDED(5, 11, true, null, null, "disadvantage", 8, "light"),
  STUDDEDLEATHER(45, 12, true, null, null, null, 13, "light"),

  HIDE(10, 12, true, 2, null, null, 12, "medium"),
  BREASTPLATE(400, 14, true, 2, null, null, 20, "medium"),
  HALFPLATE(750, 15, true, 2, null, "disadvantage", 40, "medium"),
  CHAINSHIRT(50, 13, true, 2, null, null, 20, "medium"),
  SCALEMAIL(50, 14, true, 2, null, "disadvantage", 45, "medium"),

  RINGMAIL(30, 14, false, 0, null, "disadvantage", 40, "heavy"),
  PLATE(1500, 18, false, 0, 15, "disadvantage", 65, "heavy"),
  CHAINMAIL(75, 16, false, 0, 13, "disadvantage", 55, "heavy"),
  SPLINT(200, 17, false, 0, 15, "disadvantage", 60, "heavy"),


  public String properties;



  //constructs the weapons stuff
  private Weapon(int cost, int baseAc, boolean dex){
    this.die = die;
    this.type = type;
    this.properties = properties;
    d = new Die();
  }


  /**
  * Returns the Die of the Weapon
  */
  public String getDie(){
    return die;
  }

  /**
  * Returns the Die of the Weapon
  */
  public DamageType getType(){
    return type;
  }

  /**
  * Returns the Die of the Weapon
  */
  public String getProperties(){
    return properties;
  }


  /**
  * Rolls a d20 and returns what it rolled
  */
  public int rollToAttack(){
    return d.roll(20);
  }



  /**
  * Rolls the die of the given weapon and returns the roll
  */
  public int rollDamage(){
    String s[] = die.split("d");
    int rollDamage = 0;

    for(int i = 0; i < Integer.parseInt(s[0]); i++){
      rollDamage += d.roll(Integer.parseInt(s[1]));
    }

    return rollDamage;
  }



  /**
  * Returns true if the dagger is ranged
  */
  public boolean isRanged(){
    if(properties.contains("range")){
      return true;
    }
    return false;
  }

  /**
  * Returns true if the dagger is melee
  */
  public boolean isMelee(){
    if(isRanged() == false){
      return true;
    }
    return false;
  }

  /**
  * Returns true if the dagger is two-handed
  */
  public boolean isTwoHanded(){
    if(properties.contains("two-handed")){
      return true;
    }
    return false;
  }


  /**
  * Returns true if the dagger is versatile
  */
  public boolean isVersatile(){
    if(properties.contains("versatile")){
      return true;
    }
    return false;
  }
}
