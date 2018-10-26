enum Weapon{

CLUB("1d4", "bludgeoning", "light"),
DAGGER("1d4", "piercing", "finesse, light, thrown (range 20/60)"),
GREATCLUB("1d8", "bludgeoning", "two-handed"),
HANDAXE("1d6", "slashing", "light, thrown (range 20/60)"),
JAVELIN("1d6", "type", "thrown (range 30/120)"),
LIGHTHAMMER("1d4", "bludgeoning", "light, thrown (range 20/60)"),
MACE("1d6", "bludgeoning", ""),
QUARTERSTAFF("1d6", "bludgeoning", "versatile (1d8)"),
SICKLE("1d4", "slashing", "light"),
SPEAR("1d6", "piercing", "thrown (range 20/60), versatile (1d8)"),
CROSSBOWLIGHT("1d8", "piercing", "ammunition (range 80/320), loading, two-handed"),
DART("1d4", "piercing", "finesse, thrown (range 20/60)"),
SHORTBOW("1d6", "piercing", "ammunition (range 80/320), two-handed"),
SLING("1d4", "bludgeoning", "ammunition (range 30/120)"),
BATTLEAXE("1d8", "slashing", "versatile (1d10)"),
FLAIL("1d8", "bludgeoning", ""),
GLAIVE("1d10", "slashing", "heavy, reach, two-handed"),
GREATAXE("1d12", "slashing", "heavy, two-handed"),
GREATSWORD("2d6", "slashing", "heavy, two-handed"),
HALBERD("1d10", "slashing", "heavy, reach, two-handed"),
LANCE("1d12", "piercing", "reach, special"),
LONGSWORD("1d8", "slashing", "versatile (1d10)"),
MAUL("2d6", "bludgeoning", "heavy, two-handed"),
MORNINGSTAR("1d8", "piercing", ""),
PIKE("1d10", "piercing", "heavy, reach, two-handed"),
RAPIER("1d8", "piercing", "finesse"),
SCHIMITAR("1d6", "slashing", "finesse, light"),
SHORTSWORD("1d6", "piercing", "finesse, light"),
TRIDENT("1d6", "piercing", "thrown (range 20/60), versatile (1d8)"),
WARPICK("1d8", "piercing", ""),
WARHAMMER("1d8", "bludgeoning", "versatile (1d10)"),
WHIP("1d4", "slashing", "finesse, reach"),


NAME("die", "type", "properties"),



//constructs the weapons stuff
private Weapon(String die, String type, String properties){

}




//roll a d20 and return number
public int rollToAttack()



//roll damage die and return number
rollDamage()


//returns if its ranged
public boolean ranged()

//returns if its mele
mele()

//returns if its twohanded
twoHanded()


//returns if its versatile
versatile()





}
