package model;

import java.awt.Image;

import commonutil.AppImage;
import commonutil.Audio;

public class MazeElements {
	private String name;
	private int positionX;
	private int positionY;
	private Audio audio;
	private AppImage image;
	private boolean isFound;
	
	public MazeElements(){
		this("");
	}

	public MazeElements(String name){
		this.name=name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public int getPositionX() {
		return this.positionX;
	}
	
	public void setPositionX(int x) {
		this.positionX=x;
	}

	public int getPositionY() {
		return this.positionY;
	}
	
	public void setPositionY(int y) {
		this.positionY=y;
	}
	
	public Image getImage() {
		return this.image.loadImage();
	}
	
	public void setImage(String img) {
		this.image = new AppImage(img +".png");
	}
	
	public void playAudio() {
		audio=new Audio(this.name + ".wav");
		audio.playAudio();
	}
	
	public boolean isFound() {
		return isFound;
	}
	
	public void setisFound(boolean found){
		isFound=found;
	}
}
