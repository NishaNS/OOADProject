
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
import javax.swing.JFrame;

public class DirectionsAudio extends JFrame 
{
	private boolean isCompleted;
	private String audioFilePath = "audio/goodjob.wav";
	private Path.Step step, nextStep;
	private Path p;
	private int currentX, currentY;
	private Direction direction;
	private int count = 0;
	
	public DirectionsAudio(Path path){
		super("Maze");
		p=path;
		KeyListener listener = new KeyListener() {
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()){
				case 37:
					moveLeft(p);
					break;
				case 38:
					moveUp(p);
					break;
				case 39:
					moveRight(p);
					break;
				case 40: 
					moveDown(p);
					break;
				default:
					
					break;
				}
			 }
		public void keyReleased(KeyEvent e) {}
		public void keyTyped(KeyEvent e) {}  
		};
		addKeyListener(listener);
		setFocusable(true);
		setSize(600,600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		startMove(p);
	}
	private void moveLeft(Path p)
	{
		
	}
	private void moveRight(Path p)
	{
		if(direction == Direction.RIGHT)
		{
			count++;
			calculateMove();
		}
		else if(direction==Direction.DOWN)
		{
			audioFilePath = "audio/movedown.wav";
			playAudio();
		}
	}
	private void moveDown(Path p)
	{
		if(direction == Direction.DOWN)
		{
			count++;
			calculateMove();
		}
		else if(direction==Direction.RIGHT)
		{
			audioFilePath = "audio/moveright.wav";
			playAudio();
		}
			
		
	}
	private void moveUp(Path p)
	{
	
	}
	private void startMove(Path p)
	{
		count = 0;
		calculateMove();
	}
	private void calculateMove(){
		if((count+1)>=p.getLength()) 
			audioFilePath = "audio/goodjob.wav";
		else if(count<p.getLength())
		{
			step = p.getStep(count);
			nextStep = p.getStep(count+1);
			if(nextStep.getX()>step.getX()) 
			{
				direction = Direction.RIGHT;
				audioFilePath = "audio/moveright.wav";
			}
			else if(nextStep.getY()>step.getY()) 
			{
				direction = Direction.DOWN;
				audioFilePath = "audio/movedown.wav";
			}
		}
		playAudio();
	}
	private void playAudio(){
		File audioFile = new File(audioFilePath);
		try
		{
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
			SourceDataLine audioLine = (SourceDataLine) AudioSystem.getLine(info);
			 
	            audioLine.open(format);
	            audioLine.start();
	           
	            byte[] bytesBuffer = new byte[4096];
	            int bytesRead = -1;
	 
	            while ((bytesRead = audioStream.read(bytesBuffer)) != -1) {
	                audioLine.write(bytesBuffer, 0, bytesRead);
	            }
	            
	            audioLine.drain();
	            audioLine.close();
	            audioStream.close();
	     }
		catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }
	}
	void play(Path path){
		int i = 0;
		while(i<path.getLength())
		{
			if((i+1)>=path.getLength()) audioFilePath = "audio/goodjob.wav";
			else
			{
				step = path.getStep(i);
				nextStep = path.getStep(i+1);
				if(nextStep.getX()>step.getX()) 
					audioFilePath = "audio/moveright.wav";
				else if(nextStep.getY()>step.getY()) 
					audioFilePath = "audio/movedown.wav";
			}
			i++;
				
		File audioFile = new File(audioFilePath);
		try
		{
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
			SourceDataLine audioLine = (SourceDataLine) AudioSystem.getLine(info);
			 
	            audioLine.open(format);
	            audioLine.start();
	           
	            byte[] bytesBuffer = new byte[4096];
	            int bytesRead = -1;
	 
	            while ((bytesRead = audioStream.read(bytesBuffer)) != -1) {
	                audioLine.write(bytesBuffer, 0, bytesRead);
	            }
	            
	            audioLine.drain();
	            audioLine.close();
	            audioStream.close();
	     }
		catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }
		}
	}
	public void update(LineEvent event) {
        LineEvent.Type type = event.getType();
         if (type == LineEvent.Type.START) {
            System.out.println("Playback started.");
             
        } else if (type == LineEvent.Type.STOP) {
        	isCompleted = true;
            System.out.println("Playback completed.");
        }
 
    }

}
