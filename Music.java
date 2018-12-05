// Java program to play an Audio
// file using Clip Object


//https://www.freesounds.info/music-loops/electronic-rhythms/     //Sounds

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;

public class Music{


  private AudioInputStream stream;
  private static String filePath;
  private Long frame;
  private Clip clip;
  private String status;


  public Music(String file) throws UnsupportedAudioFileException,IOException, LineUnavailableException{
    String osName = System.getProperty("os.name").toLowerCase();
    boolean isMacOs = osName.contains("mac");
    if (isMacOs) {
      filePath = "music/" + file;
    }else{
      filePath = "DnDFighter/music/" + file;
    }
      stream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
      clip = AudioSystem.getClip();
      clip.open(stream);
      status = "paused";
  }



  public void playLoop() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
    clip.loop(Clip.LOOP_CONTINUOUSLY);
    clip.start();
    status = "play";
  }


  public void playOnce() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
    clip.start();
    status = "play";
    if(clip.getMicrosecondLength() == clip.getMicrosecondPosition()) {
      clip.stop();
      clip.close();
      resetAudioStream();
      frame = 0L;
      clip.setMicrosecondPosition(frame);
      status = "paused";
    }
  }



  public void pause(){
    if (status.equals("paused")){
      System.out.println("audio is already paused");
      return;
    }
    this.frame = this.clip.getMicrosecondPosition();
    clip.stop();
    status = "paused";

  }


  public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
    clip.stop();
    frame = 0L;
    clip.setMicrosecondPosition(frame);
  }


  private void resetAudioStream() throws UnsupportedAudioFileException, IOException,LineUnavailableException{
    stream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
    clip.open(stream);
    clip.loop(Clip.LOOP_CONTINUOUSLY);
  }



}
