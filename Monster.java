public abstract class Monster {

	public int currentHp;
	private int maxHp;

	private Sizes size;
	private int speed;
	private int ac;
	private int profBonus;
	public Die damageDie, damageDie4, damageDie6, damageDie8, damageDie10, damageDie12, d20;

	private int strScore, dexScore, conScore, intScore, wisScore, charScore;
	private int strMod, dexMod, conMod, intMod, wisMod, charMod;
	private int strSave, dexSave, conSave, intSave, wisSave, charSave;

	public int athletics, insight, intimidation, stealth, perception;
	public boolean athleticsAdv, insightAdv, intimidationAdv, stealthAdv, perceptionAdv;
	public boolean athleticsDisAdv, insightDisAdv, intimidationDisAdv, stealthDisAdv, perceptionDisAdv;

	public boolean attackAdv;
	public boolean attackDisAdv;

	public Monster(Sizes size, int profBonus, int strScore, int dexScore, int conScore,
	int intScore, int wisScore, int charScore) {
		super();
		setSize(size);
		setSpeed(speed);
		setProfBonus(profBonus);

		setStrScore(strScore);
		setDexScore(dexScore);
		setConScore(conScore);
		setIntScore(intScore);
		setWisScore(wisScore);
		setCharScore(charScore);
		d20 = new Die(20);

	}

	abstract int rollInitiative();
	abstract void action(Monster enemy);
  public void resetHealth() { this.setCurrentHp(this.getMaxHp()); }

	public void setMaxHp(int hp) {
		this.maxHp = hp;
	}
	public int getMaxHp() {
		return maxHp;
	}

	public void setCurrentHp(int hp) {
		this.currentHp = hp;
	}
	public int getCurrentHp() {
		return currentHp;
	}

	public void setSize(Sizes size) {
		this.size = size;
	}
	public Sizes getSize() {
		return size;
	}

	public void setSpeed(int speed) {
		if (speed < 0) {
			System.out.println("Not a valid speed");
			return;
		}
		this.speed = speed;
	}
	public int getSpeed() {
		return speed;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}
	public int getAc() {
		return ac;
	}

	public void setProfBonus(int profBonus) {
		this.profBonus = profBonus;
	}
	public int getProfBonus() {
		return profBonus;
	}

	public void setDamageDie(Die damageDie) {
		this.damageDie = damageDie;
	}
	public Die getDamageDie() {
		return damageDie;
	}

	public abstract boolean isResistant(DamageType damage);
	public abstract boolean isImmune(DamageType damage);

	/*
	all getters and setters
	*/
	public void setStrScore(int strScore) {
		if (strScore < 0) {
			System.out.println("Not a valid strength score");
			return;
		}
		this.strScore = strScore;
		strMod = (strScore - 10) / 2;
		strSave = strMod;
	}
	public void setStrMod(int strMod) {
		this.strMod = strMod;
	}
	public void setStrSave(int strSave) {
		this.strSave = strSave;
	}
	public void setStrSaveProf() {
		strSave = strMod + profBonus;
	}
	public int getStrScore() {
		return strScore;
	}
	public int getStrMod() {
		return strMod;
	}
	public int getStrSave() {
		return strSave;
	}

	public void setDexScore(int dexScore) {
		if (dexScore < 0) {
			System.out.println("Not a valid dextarity score");
			return;
		}
		this.dexScore = dexScore;
		dexMod = (dexScore - 10) / 2;
		dexSave = dexMod;
	}
	public void setDexMod(int dexMod) {
		this.dexMod = dexMod;
	}
	public void setDexSave(int dexSave) {
		this.dexSave = dexSave;
	}
	public void setDexSaveProf() {
		dexSave = dexMod + profBonus;
	}
	public int getDexScore() {
		return dexScore;
	}
	public int getDexMod() {
		return dexMod;
	}
	public int getDexSave() {
		return dexSave;
	}

	public void setConScore(int conScore) {
		if (conScore < 0) {
			System.out.println("Not a valid constitution score");
			return;
		}
		this.conScore = conScore;
		conMod = (conScore - 10) / 2;
		conSave = conMod;
	}
	public void setConMod(int conMod) {
		this.conMod = conMod;
	}
	public void setConSave(int conSave) {
		this.conSave = conSave;
	}
	public void setConSave(boolean hasProf) {
		if (hasProf)
		conSave = conMod + profBonus;
	}
	public int getConScore() {
		return conScore;
	}
	public int getConMod() {
		return conMod;
	}
	public int getConSave() {
		return conSave;
	}

	public void setIntScore(int intScore) {
		if (intScore < 0) {
			System.out.println("Not a valid intelligence score");
			return;
		}
		this.intScore = intScore;
		intMod = (intScore - 10) / 2;
		intSave = intMod;
	}
	public void setIntMod(int intMod) {
		this.intMod = intMod;
	}
	public void setIntSave(int intSave) {
		this.intSave = intSave;
	}
	public void setIntSave(boolean hasProf) {
		if (hasProf)
		intSave = intMod + profBonus;
	}
	public int getIntScore() {
		return intScore;
	}
	public int getIntMod() {
		return intMod;
	}
	public int getIntSave() {
		return intSave;
	}

	public void setWisScore(int wisScore) {
		if (wisScore < 0) {
			System.out.println("Not a valid wisdom score");
			return;
		}
		this.wisScore = wisScore;
		wisMod = (wisScore - 10) / 2;
		wisSave = wisMod;
	}
	public void setWisMod(int wisMod) {
		this.wisMod = wisMod;
	}
	public void setWisSave(int wisSave) {
		this.wisSave = wisSave;
	}
	public void setWisSave(boolean hasProf) {
		if (hasProf)
		wisSave = wisMod + profBonus;
	}
	public int getWisScore() {
		return wisScore;
	}
	public int getWisMod() {
		return wisMod;
	}
	public int getWisSave() {
		return wisSave;
	}

	public void setCharScore(int charScore) {
		if (charScore < 0) {
			System.out.println("Not a valid charisma score");
			return;
		}
		this.charScore = charScore;
		charMod = (charScore - 10) / 2;
		charSave = charMod;
	}
	public void setCharMod(int charMod) {
		this.charMod = charMod;
	}
	public void setCharSave(int charSave) {
		this.charSave = charSave;
	}
	public void setCharSave(boolean hasProf) {
		if (hasProf)
		charSave = charMod + profBonus;
	}
	public int getCharScore() {
		return charScore;
	}
	public int getCharMod() {
		return charMod;
	}
	public int getCharSave() {
		return charSave;
	}
}
