package com.cna.cp2561;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class Music {

    void playMusic(String musicLocation) {
        try {
            File musicPath = new File(musicLocation);

            if (musicPath.exists()) {

                // grabs wav file from the filepath and plays it
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY); // loops music
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
