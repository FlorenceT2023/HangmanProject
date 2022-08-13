package com.cna.cp2561;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundEffects {
    void playMusic(String musicLocation) {
        try {
            File musicPath = new File(musicLocation);
            if (musicPath.exists()) {

                // grabs wav file from the filepath and plays it
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }

            else
            {
                System.out.println("Cannot find file.");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
