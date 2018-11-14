import java.util.HashMap;
/**
* Weapon class
*
* @author Katie Spiese
* @version 10-26-18
*/
public enum Weapon implements Equipment{

  CLUB("1d4", DamageType.BLUDGEONING, "light", "simple melee", "club"),
  DAGGER("1d4", DamageType.PIERCING, "finesse, light, thrown (range 20/60)", "simple melee", "dagger"),
  GREATCLUB("1d8", DamageType.BLUDGEONING, "two-handed", "simple melee", "great club"),
  HANDAXE("1d6", DamageType.SLASHING, "light, thrown (range 20/60)", "simple melee", "handaxe"),
  JAVELIN("1d6", DamageType.PIERCING, "thrown (range 30/120)", "simple melee", "javelin"),
  LIGHTHAMMER("1d4", DamageType.BLUDGEONING, "light, thrown (range 20/60)", "simple melee", "light hammer"),
  MACE("1d6", DamageType.BLUDGEONING, "", "simple melee", "mace"),
  QUARTERSTAFF("1d6", DamageType.BLUDGEONING, "versatile (1d8)", "simple melee", "quarter staff"),
  SICKLE("1d4", DamageType.SLASHING, "light", "simple melee", "sickle"),
  SPEAR("1d6", DamageType.PIERCING, "thrown (range 20/60), versatile (1d8)", "simple melee", "spear"),

  CROSSBOWLIGHT("1d8", DamageType.PIERCING, "ammunition (range 80/320), loading, two-handed", "simple ranged", "light crossbow"),
  DART("1d4", DamageType.PIERCING, "finesse, thrown (range 20/60)", "simple ranged", "dart"),
  SHORTBOW("1d6", DamageType.PIERCING, "ammunition (range 80/320), two-handed", "simple ranged", "shortbow"),
  SLING("1d4", DamageType.BLUDGEONING, "ammunition (range 30/120)", "simple ranged", "sling"),

  BATTLEAXE("1d8", DamageType.SLASHING, "versatile (1d10)", "martial melee", "battleaxe"),
  FLAIL("1d8", DamageType.BLUDGEONING, "", "martial melee", "flail"),
  GLAIVE("1d10", DamageType.SLASHING, "heavy, reach, two-handed", "martial melee", "glaive"),
  GREATAXE("1d12", DamageType.SLASHING, "heavy, two-handed", "martial melee", "great axe"),
  GREATSWORD("2d6", DamageType.SLASHING, "heavy, two-handed", "martial melee", "great sword"),
  HALBERD("1d10", DamageType.SLASHING, "heavy, reach, two-handed", "martial melee", "haberd"),
  //LANCE("1d12", DamageType.PIERCING, "reach, special"),
  LONGSWORD("1d8", DamageType.SLASHING, "versatile (1d10)", "martial melee", "longsword"),
  MAUL("2d6", DamageType.BLUDGEONING, "heavy, two-handed", "martial melee", "maul"),
  MORNINGSTAR("1d8", DamageType.PIERCING, "", "martial melee", "morningstar"),
  PIKE("1d10", DamageType.PIERCING, "heavy, reach, two-handed", "martial melee", "pike"),
  RAPIER("1d8", DamageType.PIERCING, "finesse", "martial melee", "rapier"),
  SCIMITAR("1d6", DamageType.SLASHING, "finesse, light", "martial melee", "scimitar"),
  SHORTSWORD("1d6", DamageType.PIERCING, "finesse, light", "martial melee", "shortsword"),
  TRIDENT("1d6", DamageType.PIERCING, "thrown (range 20/60), versatile (1d8)", "martial melee", "trident"),
  WARPICK("1d8", DamageType.PIERCING, "", "martial melee", "warpick"),
  WARHAMMER("1d8", DamageType.BLUDGEONING, "versatile (1d10)", "martial melee", "warhammer"),
  WHIP("1d4", DamageType.SLASHING, "finesse, reach", "martial melee", "whip"),

  CROSSBOWHAND("1d6", DamageType.PIERCING, "ammunition (range 30/120), light, loading", "martial ranged", "hand crossbow"),
  CROSSBOWHEAVY("1d10", DamageType.PIERCING, "ammunition (range 100/400), heavy, loading, two-handed", "martial ranged", "heavy crossbow"),
  LONGBOW("1d8", DamageType.PIERCING, "ammunition (range 150/600), heavy, two-handed", "martial ranged", "longbow");


  public String die;
  public DamageType type;
  public String properties;

  private Die d;

  public String weaponType;
  public String name;

  public static HashMap<String, Weapon> allWeapons;


  static{
    allWeapons = new HashMap<>();

    allWeapons.put(Weapon.CLUB.getName(), Weapon.CLUB);
    allWeapons.put(Weapon.DAGGER.getName(), Weapon.DAGGER);
    allWeapons.put(Weapon.GREATCLUB.getName(), Weapon.GREATCLUB);
    allWeapons.put(Weapon.HANDAXE.getName(), Weapon.HANDAXE);
    allWeapons.put(Weapon.JAVELIN.getName(), Weapon.JAVELIN);
    allWeapons.put(Weapon.LIGHTHAMMER.getName(), Weapon.LIGHTHAMMER);
    allWeapons.put(Weapon.MACE.getName(), Weapon.MACE);
    allWeapons.put(Weapon.QUARTERSTAFF.getName(), Weapon.QUARTERSTAFF);
    allWeapons.put(Weapon.SICKLE.getName(), Weapon.SICKLE);
    allWeapons.put(Weapon.SPEAR.getName(), Weapon.SPEAR);
    allWeapons.put(Weapon.CROSSBOWLIGHT.getName(), Weapon.CROSSBOWLIGHT);
    allWeapons.put(Weapon.DART.getName(), Weapon.DART);
    allWeapons.put(Weapon.SHORTBOW.getName(), Weapon.SHORTBOW);
    allWeapons.put(Weapon.SLING.getName(), Weapon.SLING);
    allWeapons.put(Weapon.BATTLEAXE.getName(), Weapon.BATTLEAXE);
    allWeapons.put(Weapon.FLAIL.getName(), Weapon.FLAIL);
    allWeapons.put(Weapon.GLAIVE.getName(), Weapon.GLAIVE);
    allWeapons.put(Weapon.GREATAXE.getName(), Weapon.GREATAXE);
    allWeapons.put(Weapon.GREATSWORD.getName(), Weapon.GREATSWORD);
    allWeapons.put(Weapon.HALBERD.getName(), Weapon.HALBERD);
    allWeapons.put(Weapon.LONGSWORD.getName(), Weapon.LONGSWORD);
    allWeapons.put(Weapon.MAUL.getName(), Weapon.MAUL);
    allWeapons.put(Weapon.MORNINGSTAR.getName(), Weapon.MORNINGSTAR);
    allWeapons.put(Weapon.PIKE.getName(), Weapon.PIKE);
    allWeapons.put(Weapon.RAPIER.getName(), Weapon.RAPIER);
    allWeapons.put(Weapon.SCIMITAR.getName(), Weapon.SCIMITAR);
    allWeapons.put(Weapon.SHORTSWORD.getName(), Weapon.SHORTSWORD);
    allWeapons.put(Weapon.TRIDENT.getName(), Weapon.TRIDENT);
    allWeapons.put(Weapon.WARPICK.getName(), Weapon.WARPICK);
    allWeapons.put(Weapon.WARHAMMER.getName(), Weapon.WARHAMMER);
    allWeapons.put(Weapon.WHIP.getName(), Weapon.WHIP);
    allWeapons.put(Weapon.CROSSBOWHAND.getName(), Weapon.CROSSBOWHAND);
    allWeapons.put(Weapon.CROSSBOWHEAVY.getName(), Weapon.CROSSBOWHEAVY);
    allWeapons.put(Weapon.LONGBOW.getName(), Weapon.LONGBOW);
  }

  //constructs the weapons stuff
  private Weapon(String die, DamageType type, String properties, String weaponType, String name) {
    this.die = die;
    this.type = type;
    this.properties = properties;
    this.weaponType = weaponType;
    this.name = name;
    d = new Die();
  }


  /**
  * Returns the Die of the Weapon
  */
  public String getDie() { return die; }

  /**
  * Returns the Die of the Weapon
  */
  public DamageType getType() { return type; }

  /**
  * Returns the Die of the Weapon
  */
  public String getProperties() { return properties; }

  public String getWeaponType() { return weaponType; }

  @Override
  public String getName() { return name; }

  public HashMap<String, Weapon> getAllWeapons() { return allWeapons; }






  /**
  * Rolls a d20 and returns what it rolled
  */
  public int rollToAttack() { return d.roll(20); }



  /**
  * Rolls the die of the given weapon and returns the roll
  */
  public int rollDamage(){
    String s[] = die.split("d");
    int rollDamage = 0;

    for(int i = 0; i < Integer.parseInt(s[0]); i++) rollDamage += d.roll(Integer.parseInt(s[1]));

    return rollDamage;
  }

  /**
  * Returns true if the dagger is ranged
  */
  public boolean isRanged(){
    if(properties.contains("range")) return true;
    return false;
  }

  /**
  * Returns true if the dagger is melee
  */
  public boolean isMelee(){
    if(isRanged() == false) return true;
    return false;
  }

  /**
  * Returns true if the dagger is two-handed
  */
  public boolean isTwoHanded(){
    if(properties.contains("two-handed")) return true;
    return false;
  }

  /**
  * Returns true if the dagger is versatile
  */
  public boolean isVersatile(){
    if(properties.contains("versatile")) return true;
    return false;
  }


  public String toString() { return this.name; }

  @Override
  public boolean isWeapon() { return true; }

  public int numHands() {
    if (this.getProperties().contains("two-handed")) return 2;
    return 1;
  }
}
