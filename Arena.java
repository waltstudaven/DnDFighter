import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;
import java.util.HashMap;


public class Arena {
  private static HashMap allMonsters;

  static {
    allMonsters = new HashMap<Integer, Monster>();
    allMonsters.put(1, new Ezmerelda());
    allMonsters.put(2, new Thug());
  }

  public static void main(String[] args) throws UnsupportedAudioFileException,IOException, LineUnavailableException{

    Music music = new Music("rosey.wav");    /////////////////// change !!!!!!!!!!!!!!!!!!!!!!!!!!
    music.playLoop();

    CharacterCreation creatingCharacter = new CharacterCreation();
    Character mainCharacter = creatingCharacter.characterCreator();
    mainCharacter.setCurrentHp(mainCharacter.getMaxHp());




    System.out.println("Who would you like to fight against? ");
    for (Object i: allMonsters.keySet()) {
      System.out.println("(" + (Integer)i + ") " + allMonsters.get((Integer) i));
    }
    Scanner scan = new Scanner(System.in);
    Integer monsterChoice = scan.nextInt();


    music.stop();

    Music music2 = new Music("king_pin.wav");
    music2.playLoop();


    Arena arena = new Arena( (Monster) allMonsters.get(monsterChoice), mainCharacter);



  }

  public Arena(Monster m1, Character m2) {
    if (rollInitiative(m1, m2) == m1) System.out.println(fight(m1, m2));
    else System.out.println("The winner is: " + fight(m2, m1));

  }

  public Monster fight(Monster first, Monster second) {
    while (true) {
      // System.out.println(first.getCurrentHp() + "\t" + first.getMaxHp());
      // System.out.println(second.getCurrentHp() + "\t" + second.getMaxHp());
      if (first.getCurrentHp() < 1) {
        System.out.println("winner health: " + second.getCurrentHp());
        return second;
      }
      else if (second.getCurrentHp() < 1) {
        System.out.println("winner health: " +first.getCurrentHp());
        return first;
      }
      first.turn(second);
      if (second.getCurrentHp() > 0) second.turn(first);
    }
  }

  public Monster rollInitiative(Monster m1, Monster m2) {
    int firstRoll = m1.rollInitiative();
    System.out.println(firstRoll);
    int secondRoll = m2.rollInitiative();
    System.out.println(secondRoll);

    if (firstRoll > secondRoll) return m1;
    else if (firstRoll < secondRoll) return m2;

    if (m1.getDexScore() > m2.getDexScore()) return m1;
    else if (m1.getDexScore() < m2.getDexScore()) return m2;

    return rollInitiative(m1, m2);
  }
}
