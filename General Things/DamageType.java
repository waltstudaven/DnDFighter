public enum DamageType {
	ACID("acid"), BLUDGEONING("bludgeoning"), COLD("cold"), FIRE("fire"), FORCE("force"),
	LIGHTNING("lightning"), NECROTIC("necrotic"), PIERCING("piercing"), POISON("poison"), PSYCHIC("psychic"),
	RADIANT("radiant"), SLASHING("slashing"), THUNDER("thunder");

	private String damageType;

	DamageType(String damageType) {
		this.damageType = damageType;
	}

	public String getDamageType() {
		return damageType;
	}

}
