class Die {

	private int sides;


	public Die() {
		this.sides = 0;
	}

	public Die(int sides) {
		this.sides = sides;
	}

	public int roll() {
		return (int) (Math.random() * sides) + 1;
	}

	public int roll(int theSides) {
		return (int) (Math.random() * theSides) + 1;
	}

	public void setSides(int theSides){
		this.sides = theSides;
	}

}
