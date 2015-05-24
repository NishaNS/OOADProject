/**
 * 
 */
package commonutil;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.*;

import javax.imageio.ImageIO;


/**
 * @author 
 *
 */
public class AppImage {
	private static final String FILE_PATH = "image/";
	private String imgFileName = "";
	
	/**
	 * The constructor of the Image class
	 * @param fileName
	 */
	public AppImage(String fileName)
	{
		this.imgFileName = fileName;
	}
	
	/**
	 * The method that is used to set the name of the image file
	 * @param filename
	 */
	public void setImgFileName(String fileName){
		this.imgFileName = fileName;
	}
	
	/**
	 * The method that returns the name of the image file
	 * @return String
	 */
	public String getImgFileName(){
		return this.imgFileName;
	}
	
	/**
	 * The method that is used to read the image from the specified location and scale it to the size of the window
	 * @return Image
	 */
	public Image loadBackGroundImage(){
		 File filename = new File(FILE_PATH.concat(this.imgFileName));
		 Toolkit tkit = Toolkit.getDefaultToolkit();
		 int windowWidth = tkit.getScreenSize().width; 
		 int windowHeight = tkit.getScreenSize().height;
		 Image img = null;
		    try {
		      img = ImageIO.read(filename);
		      img = img.getScaledInstance(windowWidth,windowHeight, Image.SCALE_SMOOTH);
		    } catch (IOException e) {
		      System.out.println("An error has occurred while reading image file. Check that file exists and is in the correct directory.");
		    }
		return img;
	}
	
	/**
	 * The method that is used to read the image from the specified location
	 * @return Image
	 */
	public Image loadImage(){
		 File filename = new File(FILE_PATH.concat(this.imgFileName));
		 Image img = null;
		    try {
		      img = ImageIO.read(filename);
		      } catch (IOException e) {
		      System.out.println("An error has occurred while reading image file. Check that file exists and is in the correct directory.");
		    }
		return img;
	}
	
	
    
}
