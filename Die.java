/**
 * The Die class is used to roll random values between 1 and 
 * however many sides the created Die has.
 */
class Die {

	private int sides;

	/**
	 * Create a Die with specified amount of sides.
	 * @param	Number of Die faces.
	 */
	public Die(int sides) {
		this.sides = sides;
	}
	/**
	 * Determines a random value between 1 and the number of sides.
	 */
	public int roll() {
		return (int) (Math.random() * sides) + 1;
	}
	/**
	 * Roll a specified number of sides(?)
	 * @param theSides	Number of die sides
	 */
	public int roll(int theSides) {
		return (int) (Math.random() * theSides) + 1;
	}
	/**
	 * Sets the Die to desired amount of sides
	 * @param	theSides	New amount of sides.
	 */
	public void setSides(int theSides){
		this.sides = theSides;
	}

}
