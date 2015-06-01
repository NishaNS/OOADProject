package commonutil;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CustomButton extends JButton{
	
	
	private String imageFile;
	//private int height=400;
	//private int width=400;
	private String audioFile;
	private String toolTip;
	private String name;
	
	private static String IMG_FILE_PATH = "image/";
	//private static String AUD_FILE_PATH = "audio/";
	
	
	public CustomButton(String imgFile, String audFile){
		this.imageFile=IMG_FILE_PATH+ imgFile;
		this.audioFile =  audFile;
		this.setIcon(new ImageIcon(imageFile));
	}
	
	public CustomButton(String imgFile, String audFile,String toolTipText, String name){
		this.imageFile=IMG_FILE_PATH+ imgFile;
		this.audioFile =  audFile;
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);	
		this.setName(name);
		this.setToolTipText(toolTipText);
		this.setIcon(new ImageIcon(imageFile));
	}
	
	public String getAudioFile(){
		return this.audioFile;
	}

	/**
	 * The method to set the button when the audio is playing
	 * @param img
	 */
	public void setButton(String img){
		imageFile=IMG_FILE_PATH+img;
		repaint();
	}
	/**
	 * The method to reset the button back to original image when the audio is stopped for that button
	 */
	public void reset(String img){
		imageFile=IMG_FILE_PATH+img;
		repaint();
	}
	
	/**
	 * The method to scale the images given to the button
	 */
	public ImageIcon scaleImage(int x,int y,ImageIcon i){
		Image img = i.getImage(); 
		Image newimg = img.getScaledInstance(x,y,java.awt.Image.SCALE_SMOOTH);  
		return new ImageIcon(newimg); 
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setIcon(new ImageIcon(imageFile));
		//this.setIcon(scaleImage(height,width,new ImageIcon(imageFile)));
	}

}