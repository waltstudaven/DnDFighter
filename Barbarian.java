/**
 * Barbarian is a character's class that will determine a character's
 * skills, attacks, and health.
 */
public class Barabarian extends CharacterClass{
   int rages; 
   int rageDmg;
   boolean raging;
   public Barabrian(int level, Die hitDie) {
     super.level = level;
     super.profBonus = setProfBonusViaLevel(level);
     super.hitDie = hitDie;
     raging = false;
   }
   /**
    * Determines the strength and other bonuses based off of character's level.
    */
   public void setLvl(int level){
     if(level >= 1) setLvlOne();
   }
   /**
    * Determines the strength and other bonuses for level 1 character.
    */
   public void setLvlOne() {
     rages = 2;
     rageDmg = 2;
     if (raging)
   }
   /**
    * Uses the Barbarian rage.
    */
   public void rage() {
     raging = true;

   }
 }
