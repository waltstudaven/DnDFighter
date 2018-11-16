import java.util.HashMap;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;

public class Tester2{
  public static void main(String[] args) throws UnsupportedAudioFileException,IOException, LineUnavailableException{
    System.out.println();
    System.out.println();
    System.out.println();


    Weapon club = Weapon.CLUB;  //light, melee
    Weapon battleAxe = Weapon.BATTLEAXE; //versatile
    Weapon longbow = Weapon.LONGBOW;   //heavy, two-handed, ranged

    System.out.println("Club");
    //testing club get name
    System.out.println("Clubs name is: " + club.getName());
    //testing club get die
    System.out.println("Clubs die is: " + club.getDie());
    //testing club get type
    System.out.println("Clubs type is: " + club.getType());
    //testing club get properties
    System.out.println("Clubs properties are: " + club.getProperties());
    //testing club get weapon type
    System.out.println("Clubs weapon type is: " + club.getWeaponType());
    System.out.println();
    //testing club is ranged
    System.out.println("Is a club ranged: " + club.isRanged());
    //testing club is melee
    System.out.println("Is a club melee: " + club.isMelee());
    //testing club gis two handed
    System.out.println("Is a club two handed: " + club.isTwoHanded());
    //testing club num hands
    System.out.println("Number of hands a club needs: " + club.numHands());
    //testing club is versatile
    System.out.println("Is a club versatile: " + club.isVersatile());
    //testing club is weapon
    System.out.println("Is a club a weapon: " + club.isWeapon());
    System.out.println();
    System.out.println();
    System.out.println();



    System.out.println("Battle Axe");
    //testing battle axe get name
    System.out.println("battleAxes name is: " + battleAxe.getName());
    //testing battle axe get die
    System.out.println("battleAxes die is: " + battleAxe.getDie());
    //testing battle axe get type
    System.out.println("battleAxes type is: " + battleAxe.getType());
    //testing battle axe get properties
    System.out.println("battleAxes properties are: " + battleAxe.getProperties());
    //testing battle axe get weapon type
    System.out.println("battleAxes weapon type is: " + battleAxe.getWeaponType());
    System.out.println();
    //testing battle axe is ranged
    System.out.println("Is a battleAxe ranged: " + battleAxe.isRanged());
    //testing battle axe is melee
    System.out.println("Is a battleAxe melee: " + battleAxe.isMelee());
    //testing battle axe is two handed
    System.out.println("Is a battleAxe two handed: " + battleAxe.isTwoHanded());
    //testing battle axe number of hands
    System.out.println("Number of hands a battleAxe needs: " + battleAxe.numHands());
    //testing battle axe is versatile
    System.out.println("Is a battleAxe versatile: " + battleAxe.isVersatile());
    //testing battle axe is a weapon
    System.out.println("Is a battleAxe a weapon: " + battleAxe.isWeapon());
    System.out.println();
    System.out.println();
    System.out.println();



    System.out.println("Longbow");
    //testing longbow get name
    System.out.println("longbows name is: " + longbow.getName());
    //testing longbow get die
    System.out.println("longbows die is: " + longbow.getDie());
    //testing longbow get type
    System.out.println("longbows type is: " + longbow.getType());
    //testing longbow get properties
    System.out.println("longbows properties are: " + longbow.getProperties());
    //testing longbow get weapon type
    System.out.println("longbows weapon type is: " + longbow.getWeaponType());
    System.out.println();
    //testing longbow is ranged
    System.out.println("Is a longbow ranged: " + longbow.isRanged());
    //testing longbow is melee
    System.out.println("Is a longbow melee: " + longbow.isMelee());
    //testing longbow is two handed
    System.out.println("Is a longbow two handed: " + longbow.isTwoHanded());
    //testing longbow num hands
    System.out.println("Number of hands a longbow needs: " + longbow.numHands());
    //testing longbow is versatile
    System.out.println("Is a longbow versatile: " + longbow.isVersatile());
    //testing longbow is a weapon
    System.out.println("Is a longbow a weapon: " + longbow.isWeapon());
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();



    //testing getting all weapons
    System.out.println("All Weapons: ");
    HashMap<String, Weapon> allWeapons = Weapon.getAllWeapons();
    for(String s: allWeapons.keySet()){
      System.out.println(allWeapons.get(s).getName());
    }



    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    //testing club roll to attack
    System.out.println("Club roll to attack: " + club.rollToAttack());
    //testing club roll to attack
    System.out.println("battleAxe roll to attack: " + battleAxe.rollToAttack());
    //testing club roll to attack
    System.out.println("longbow roll to attack: " + longbow.rollToAttack());




    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    //testing club roll die
    System.out.println("Club roll " + club.getDie() + " for damage: " + club.rollDamage());
    //testing club roll die
    System.out.println("Battleaxe roll " + battleAxe.getDie() + " for damage: " + battleAxe.rollDamage());
    //testing club roll die
    System.out.println("Longbow roll " + longbow.getDie() + " for damage: " + longbow.rollDamage());




    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();

    //testing playing music
    Music song = new Music("television_hype.wav");
    song.playLoop();




    //testing creating a die
    Die randomDie = new Die();
    //testing rolling a die with 20 sides
    System.out.println("Roll a die with 20 sides: " + randomDie.roll(20));
    System.out.println("Setting my die to have 5 sides");
    //testing setting die to 5 sides
    randomDie.setSides(5);
    //testing rolling die with set number of sides
    System.out.println("Roll the die with " + randomDie.getSides() + " sides: " + randomDie.roll());




    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
  }
}
