/**
* Weapon class
*
* @author Katie Spiese
* @version 10-26-18
*/
enum Weapon{

  CLUB("1d4", DamageType.BLUDGEONING, "light"),
  DAGGER("1d4", DamageType.PIERCING, "finesse, light, thrown (range 20/60)"),
  GREATCLUB("1d8", DamageType.BLUDGEONING, "two-handed"),
  HANDAXE("1d6", DamageType.SLASHING, "light, thrown (range 20/60)"),
  JAVELIN("1d6", DamageType.PIERCING, "thrown (range 30/120)"),
  LIGHTHAMMER("1d4", DamageType.BLUDGEONING, "light, thrown (range 20/60)"),
  MACE("1d6", DamageType.BLUDGEONING, ""),
  QUARTERSTAFF("1d6", DamageType.BLUDGEONING, "versatile (1d8)"),
  SICKLE("1d4", DamageType.SLASHING, "light"),
  SPEAR("1d6", DamageType.PIERCING, "thrown (range 20/60), versatile (1d8)"),
  CROSSBOWLIGHT("1d8", DamageType.PIERCING, "ammunition (range 80/320), loading, two-handed"),
  DART("1d4", DamageType.PIERCING, "finesse, thrown (range 20/60)"),
  SHORTBOW("1d6", DamageType.PIERCING, "ammunition (range 80/320), two-handed"),
  SLING("1d4", DamageType.BLUDGEONING, "ammunition (range 30/120)"),
  BATTLEAXE("1d8", DamageType.SLASHING, "versatile (1d10)"),
  FLAIL("1d8", DamageType.BLUDGEONING, ""),
  GLAIVE("1d10", DamageType.SLASHING, "heavy, reach, two-handed"),
  GREATAXE("1d12", DamageType.SLASHING, "heavy, two-handed"),
  GREATSWORD("2d6", DamageType.SLASHING, "heavy, two-handed"),
  HALBERD("1d10", DamageType.SLASHING, "heavy, reach, two-handed"),
  LANCE("1d12", DamageType.PIERCING, "reach, special"),
  LONGSWORD("1d8", DamageType.SLASHING, "versatile (1d10)"),
  MAUL("2d6", DamageType.BLUDGEONING, "heavy, two-handed"),
  MORNINGSTAR("1d8", DamageType.PIERCING, ""),
  PIKE("1d10", DamageType.PIERCING, "heavy, reach, two-handed"),
  RAPIER("1d8", DamageType.PIERCING, "finesse"),
  SCHIMITAR("1d6", DamageType.SLASHING, "finesse, light"),
  SHORTSWORD("1d6", DamageType.PIERCING, "finesse, light"),
  TRIDENT("1d6", DamageType.PIERCING, "thrown (range 20/60), versatile (1d8)"),
  WARPICK("1d8", DamageType.PIERCING, ""),
  WARHAMMER("1d8", DamageType.BLUDGEONING, "versatile (1d10)"),
  WHIP("1d4", DamageType.SLASHING, "finesse, reach"),
  CROSSBOWHAND("1d6", DamageType.PIERCING, "ammunition (range 30/120), light, loading"),
  CROSSBOWHEAVY("1d10", DamageType.PIERCING, "ammunition (range 100/400), heavy, loading, two-handed"),
  LONGBOW("1d8", DamageType.PIERCING, "ammunition (range 150/600), heavy, two-handed");


  public String die;
  public DamageType type;
  public String properties;
  private Die d;



  //constructs the weapons stuff
  private Weapon(String die, DamageType type, String properties){
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
