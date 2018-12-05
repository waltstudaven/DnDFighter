public class Ezmerelda extends Monster {

	public Ezmerelda() {
		super(82, Sizes.MEDIUM, 30, 17, 3, 14, 19, 16, 16, 11, 17);	//the hp and size and speed, and scores
		setWisSave(true);
		damageDie8 = new Die(8);	//does 1d8 damage
		damageDie6 = new Die(6);
	}

	@Override
	public int rollInitiative() {
		return d20.roll() + getDexMod();
	}

	public int rollToAttackRapier() {
		int roll = d20.roll() + getDexMod() + getProfBonus()+1; //+1 weapon
		return roll;
	}
	public int rollDamageRapier(Monster enemy) {
		int piercing  = damageDie8.roll() + getDexMod() +1; //+1 weapon
		if (enemy.isResistant(DamageType.PIERCING))
		piercing = piercing/2;
		else if (enemy.isImmune(DamageType.PIERCING))
		return 0;

		return piercing;
	}
	public void attackRapier(Monster enemy) {
		if (rollToAttackRapier() >= enemy.getAc())
		enemy.setHp(enemy.getHp() - rollDamageRapier(enemy));
	}

	public int rollToAttackHandAxe() {
		int roll = d20.roll() + getStrMod() + getProfBonus() +1;
		return roll; //+1 weapon
	}
	public int rollDamageHandAxe(Monster enemy) {
		int slashing = damageDie6.roll() + getStrMod() +1;
		if (enemy.isResistant(DamageType.SLASHING))
		return slashing/2;
		else if (enemy.isImmune(DamageType.SLASHING))
		return 0;

		return slashing;  //+1 weapon
	}
	public void attackHandAxe(Monster enemy) {
		if (rollToAttackHandAxe() >= enemy.getAc())
		enemy.setHp(enemy.getHp() - rollDamageHandAxe(enemy));
	}

	public int rollToAttackSilverShortSword() {
		int roll = d20.roll() + getDexMod() + getProfBonus();
		return roll;
	}
	public int rollDamageSilverShortSword(Monster enemy) {
		int slashing = damageDie6.roll() + getDexMod();
		if (enemy.isResistant(DamageType.SLASHING))
		slashing = slashing/2;
		else if (enemy.isImmune(DamageType.SLASHING))
		return 0;

		return slashing;
	}
	public void attackSilverShortSword(Monster enemy) {
		if (rollToAttackSilverShortSword() >= enemy.getAc())
		enemy.setHp(enemy.getHp() - rollDamageSilverShortSword(enemy));
	}

	@Override
	public void action(Monster enemy) {
		attackRapier(enemy);
		attackHandAxe(enemy);
		attackSilverShortSword(enemy);
	}

	@Override
	public String toString() {
		return "Ezmerelda d'Avenir";		//is lower case because ignore case
	}

	@Override
	public void resetHealth() {
		setHp(82);
	}
}
