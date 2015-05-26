/**
 * The Audio class functions as a utility that aids the application in playing the various audio files
 */
package commonutil;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

/**
 * @author 
 *
 */
public class Audio {
	
	private static final String FILE_PATH = "audio/";
	private String auFileName = "";
	private SourceDataLine audioLine;
	/**
	 * The constructor of the Audio class
	 * @param fileName
	 */
	public Audio(String fileName)
	{
		this.auFileName = fileName;
	}
	
	/**
	 * The method that is used to set the name of the audio file
	 * @param fileName
	 */
	public void setauFileName(String fileName){
		this.auFileName = fileName;
	}
	
	/**
	 * The method that returns the name of the audio file
	 * @return String
	 */
	public String getauFileName(){
		return this.auFileName;
	}
	
	/**
	 * The method that is used to play the respective audio 
	 */
	public void playAudio(){
		File audioFile = null;
		AudioInputStream audioStream = null;
		audioLine = null;
		try
		{
			audioFile = new File(FILE_PATH.concat(this.auFileName));
			audioStream = AudioSystem.getAudioInputStream(audioFile);
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
			audioLine = (SourceDataLine) AudioSystem.getLine(info);
			audioLine.open(format);
	        audioLine.start();
	        byte[] bytesBuffer = new byte[4096];
	        int bytesRead = -1;
	        	while ((bytesRead = audioStream.read(bytesBuffer)) != -1) {
	                audioLine.write(bytesBuffer, 0, bytesRead);
	            }
	        audioStream.close();
		}catch(NullPointerException ex){
			System.out.println("Audio file path is empty");
		}catch (UnsupportedAudioFileException ex) {
            System.out.println(ex.getMessage().toString());
        } catch (LineUnavailableException ex) {
            System.out.println(ex.getMessage().toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage().toString());
        }finally{
        	if(audioLine!=null){
        	audioLine.drain();
            audioLine.close();
        	}
        }
	}
	/**
	 * The method to stop the audio once started
	 */
	public void stopAudio(){
		audioLine.stop();
		audioLine.flush();
	}
	
}
