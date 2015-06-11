

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
import javax.sound.sampled.LineEvent.Type;

/**
 * @author Nisha
 * 
 * LineListener
 *
 */
public class audio1 {
	
	private boolean done = false;
	
	public void playClip(File clipfile) throws IOException {
		
		class myAudioListener implements LineListener {
			
			@Override
			public void update(LineEvent event) {
				Type eventType = event.getType();
				if(eventType == Type.STOP || eventType == Type.CLOSE) {
					done = true;
					notifyAll();
				}
			}
			public synchronized void waitUntilDone() throws InterruptedException {
				while(!done)
					Thread.sleep(1000);
					//wait();
			}			
		}
		
		myAudioListener listener = new myAudioListener();
		AudioInputStream inputstream = null;
		
		try {	
			inputstream = AudioSystem.getAudioInputStream(clipfile);
			Clip clip = AudioSystem.getClip();
			clip.addLineListener(listener);
			clip.open(inputstream);
			clip.start();
			try {
				listener.waitUntilDone();
			} catch (InterruptedException e) {					
				e.printStackTrace();
			} finally {
				clip.close();
			}

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {			
			e.printStackTrace();
		} finally {
			inputstream.close();
		}
	}

	/*public static void main(String[] args) {
		
		audio1 a1 = new audio1();
		audio1 a2 = new audio1();
		audio1 a3 = new audio1();
		
		File file1 = new File("E:\\Audio\\Theme_1.wav");
		File file2 = new File("E:\\Audio\\Theme_2.wav");
		File file3 = new File("E:\\Audio\\Theme_3.wav");	
		
			try {
				a1.playClip(file1);				
				a2.playClip(file2);				
				a3.playClip(file3);
			} catch (IOException e) {				
				e.printStackTrace();
			}
	}*/
}
