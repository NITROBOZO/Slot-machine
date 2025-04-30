package view;
import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
public class AudioPlayer {
	private Clip suono;
	
	public AudioPlayer(String pathSuono) {
        try {
            URL suonoURL = getClass().getResource(pathSuono);
            suono = AudioSystem.getClip();
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(suonoURL);
            suono.open(audioInput);
            
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
	public void play() {
		if(suono != null) {
			suono.setFramePosition(0);
			suono.start();
		}
	}
	public void loop() {
		if(suono != null) {
			suono.loop(Clip.LOOP_CONTINUOUSLY);
		}
	}
	public void stop() {
		if(suono != null) {
			suono.stop();
		}
	}
}
