public class CharacterCreation {
    private Race characterRace;
    private CharacterClass characterClass;
    int level;


    ///asdgbwour
    private int strScore;
    private int dexScore;
    private int conScore;
    private int intScore;
    private int wisScore;
    private int charScore;

    private int strMod;
    private int dexMod;
    private int conMod;
    private int intMod;
    private int wisMod;
    private int charMod;

    private int strSave;
    private int dexSave;
    private int conSave;
    private int intSave;
    private int wisSave;
    private int charSave;

    public CharacterCreation(Race characterRace, CharacterClass characterClass, int level){
        this.characterRace = characterRace;
        this.characterClass = characterClass;
        this.level = level;
    }

    public Race getCharacterRace() { return this.characterRace; }
    public CharacterClass getCharacterClass() {return this.characterClass; }

    public void setCharacterRace(Race newRace) { this.characterRace = newRace; }
    public void setCharacterClass(CharacterClass newClass) { this.characterClass = newClass; }



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
    public void setStrSaveProf(boolean hasProf) {
        if (hasProf)
            strSave = strMod + profBonus;
    }
    public int getStrScore() {
        return strScore;
    }
    public int getStrMod() {
        return strMod;
    }
    public int getStrSave() { return strSave; }

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
    public void setDexSaveProf(boolean hasProf) {
        if (hasProf)
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
    public void setConSaveProf(boolean hasProf) {
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
    public void setIntSaveProf(boolean hasProf) {
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
    public void setWisSaveProf(boolean hasProf) {
        if (hasProf)
            wisSave = wisSave + profBonus;
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
    public void setCharSaveProf(boolean hasProf) {
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