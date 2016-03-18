package Entities.Sound;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class AudioPlayer {

	Clip clip;
	public AudioPlayer(String s){
		try{
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(s));

			AudioFormat baseFormat = ais.getFormat();
			AudioFormat decodeFomat = new AudioFormat(
					AudioFormat.Encoding.PCM_SIGNED,
					baseFormat.getSampleRate(),
					16,
					baseFormat.getChannels(),
					baseFormat.getChannels() * 2,
					baseFormat.getSampleRate(),
					false
			);

			AudioInputStream dais =
					AudioSystem.getAudioInputStream(
							decodeFomat, ais);
			clip = AudioSystem.getClip();
			clip.open(dais);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	public void play(){
		System.out.println("1");
		if(clip == null) return;
		stop();
		System.out.println("2");
		clip.setFramePosition(0);
		clip.start();
	}
	public void stop(){
		if(clip.isRunning()) clip.stop();
	}

	public void close(){
		stop();
		clip.close();
	}
}














