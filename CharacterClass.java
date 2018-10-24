public abstract class CharacterClass {
    int level;
    int profBonus;
    Die hitDie;

    /**
    * Sets the prof bonus for based on level
    * @param level The level
    */
    public void setProfBonusViaLevel(int level) {
        if (level < 5) setProfBonus(2);
        else if (level < 9 && level >= 5) setProfBonus(3);
        else if (level < 13 && level >= 9) setProfBonus(4);
        else if (level < 17 && level >= 13) setProfBonus(5);
        else if (level < 20 && level >= 17) setProfBonus(6);
        else {
            System.out.println("Not a valid level");
        }
    }

    /**
    * Sets the prof bonus for the character
    * @param profBonus The prof bonus
    */
    public void setProfBonus(int profBonus) { this.profBonus = profBonus; }

    /**
    * Returns the prof bonus
    * @return The prof bonus
    */
    public int getProfBonus() { return profBonus; }

    /**
    * Sets the level for the character
    * @param level The level
    */
    public void setLevel(int level) { this.level = level; }

    /**
    * Returns the level
    * @return The level
    */
    public int getLevel() { return this.level; }

    /**
    * Sets the saved throws 
    */
    public abstract void setSaveThrowsProf();

    /**
    * Determines the health
    */
    public abstract void determineHealth();
}
