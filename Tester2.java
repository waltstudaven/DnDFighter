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
    System.out.println("Clubs name is: " + club.getName());
    System.out.println("Clubs die is: " + club.getDie());
    System.out.println("Clubs type is: " + club.getType());
    System.out.println("Clubs properties are: " + club.getProperties());
    System.out.println("Clubs weapon type is: " + club.getWeaponType());
    System.out.println();
    System.out.println("Is a club ranged: " + club.isRanged());
    System.out.println("Is a club melee: " + club.isMelee());
    System.out.println("Is a club two handed: " + club.isTwoHanded());
    System.out.println("Number of hands a club needs: " + club.numHands());
    System.out.println("Is a club versatile: " + club.isVersatile());
    System.out.println("Is a club a weapon: " + club.isWeapon());
    System.out.println();
    System.out.println();
    System.out.println();

    System.out.println("Battle Axe");
    System.out.println("battleAxes name is: " + battleAxe.getName());
    System.out.println("battleAxes die is: " + battleAxe.getDie());
    System.out.println("battleAxes type is: " + battleAxe.getType());
    System.out.println("battleAxes properties are: " + battleAxe.getProperties());
    System.out.println("battleAxes weapon type is: " + battleAxe.getWeaponType());
    System.out.println();
    System.out.println("Is a battleAxe ranged: " + battleAxe.isRanged());
    System.out.println("Is a battleAxe melee: " + battleAxe.isMelee());
    System.out.println("Is a battleAxe two handed: " + battleAxe.isTwoHanded());
    System.out.println("Number of hands a battleAxe needs: " + battleAxe.numHands());
    System.out.println("Is a battleAxe versatile: " + battleAxe.isVersatile());
    System.out.println("Is a battleAxe a weapon: " + battleAxe.isWeapon());
    System.out.println();
    System.out.println();
    System.out.println();

    System.out.println("Longbow");
    System.out.println("longbows name is: " + longbow.getName());
    System.out.println("longbows die is: " + longbow.getDie());
    System.out.println("longbows type is: " + longbow.getType());
    System.out.println("longbows properties are: " + longbow.getProperties());
    System.out.println("longbows weapon type is: " + longbow.getWeaponType());
    System.out.println();
    System.out.println("Is a longbow ranged: " + longbow.isRanged());
    System.out.println("Is a longbow melee: " + longbow.isMelee());
    System.out.println("Is a longbow two handed: " + longbow.isTwoHanded());
    System.out.println("Number of hands a longbow needs: " + longbow.numHands());
    System.out.println("Is a longbow versatile: " + longbow.isVersatile());
    System.out.println("Is a longbow a weapon: " + longbow.isWeapon());
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();


    System.out.println("All Weapons: ");
    HashMap<String, Weapon> allWeapons = club.getAllWeapons();
    for(String s: allWeapons.keySet()){
      System.out.println(allWeapons.get(s).getName());
    }

    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println("Club roll to attack: " + club.rollToAttack());
    System.out.println("battleAxe roll to attack: " + battleAxe.rollToAttack());
    System.out.println("longbow roll to attack: " + longbow.rollToAttack());


    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println("Club roll " + club.getDie() + " for damage: " + club.rollDamage());
    System.out.println("Battleaxe roll " + battleAxe.getDie() + " for damage: " + battleAxe.rollDamage());
    System.out.println("Longbow roll " + longbow.getDie() + " for damage: " + longbow.rollDamage());


    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();


    Music song = new Music("television_hype.wav");
    song.playLoop();





    Die randomDie = new Die();
    System.out.println("Roll a die with 20 sides: " + randomDie.roll(20));
    System.out.println("Setting my die to have 5 sides");
    randomDie.setSides(5);
    System.out.println("Roll the die with " + randomDie.getSides() + " sides: " + randomDie.roll());


    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
  }
}
