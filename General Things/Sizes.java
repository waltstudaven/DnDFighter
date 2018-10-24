public enum Sizes {
	TINY(2.5, "tiny"), SMALL(5, "small"), MEDIUM(5, "medium"), LARGE(10, "large"), HUGE(15, "huge"), GARGANTUAN(20,
			"gargantuan");

	private double space;
	private String size;

	Sizes(double space, String size) {
		this.space = space;
		this.size = size;
	}

	public double getSpace() {
		return space;
	}

	public String getSize() {
		return size;
	}

}
