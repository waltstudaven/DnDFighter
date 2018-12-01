public class Thug extends Monster {
	int numAttacks = 2;

	public Thug() {
		super(Sizes.MEDIUM, 2, 15, 11, 14, 10, 10, 11);	//the hp and size and speed, and scores
		damageDie6 = new Die(6);	//does 1d6 damage
		damageDie10 = new Die(10);
    setMaxHp(32);
    setCurrentHp(32);
		this.setAc(11);
	}

	@Override
	public int rollInitiative() {
		return d20.roll() + getDexMod();
	}

	public int rollToAttackMace() {
		int roll = d20.roll() + getStrMod() + getProfBonus();
		return roll;
	}
	public int rollDamageMace(Monster enemy) {
		int bludgeoning = damageDie6.roll() + getStrMod();

		if (enemy.isResistant(DamageType.BLUDGEONING))
		bludgeoning = bludgeoning/2;
		else if (enemy.isImmune(DamageType.BLUDGEONING))
		bludgeoning = 0;

		return bludgeoning;
	}
	public void attackMace(Monster enemy) {
		if (rollToAttackMace() >= enemy.getAc())
		enemy.setCurrentHp(enemy.getCurrentHp() - rollDamageMace(enemy));
	}

	public int rollToAttackHeavyCrossBow() {
		int roll = d20.roll() + getDexMod() + getProfBonus();
		return roll;
	}
	public int rollDamageHeavyCrossBow(Monster enemy) {
		int piercing = damageDie10.roll() + getDexMod();

		if (enemy.isResistant(DamageType.PIERCING))
		piercing = piercing/2;
		else if (enemy.isImmune(DamageType.PIERCING))
		piercing = 0;

		return piercing;
	}
	public void attackHeavyCrossBow(Monster enemy) {
		if (rollToAttackHeavyCrossBow() >= enemy.getAc())
		enemy.setCurrentHp(enemy.getCurrentHp() - rollDamageHeavyCrossBow(enemy));
	}

	@Override
	public void action(Monster enemy) {
		attackMace(enemy);
		attackHeavyCrossBow(enemy);
	}

	@Override
	public String toString() {
		return "Thug";		//is lower case because ignore case
	}

	@Override
	public void resetHealth() {
		setCurrentHp(32);
	}

  @Override
  public boolean isImmune(DamageType damageType) {
    return false;
  }

  @Override
  public boolean isResistant(DamageType damageType) {
    return false;
  }
}
