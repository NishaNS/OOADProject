package model;

import java.awt.Image;

import commonutil.AppImage;
import commonutil.Audio;

public class Animal implements MazeElement{
	private String name;
	private int positionX;
	private int positionY;
	private Audio audio;
	private AppImage image;
	private boolean isFound;

	public Animal(){
		this("");
	}

	public Animal(String name){
		this.name=name;
	}
	/**
	 * The method used to get the name of the animal
	 * @return String
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * The method used to set name of the animal eg:mouse,cat lion
	 * @param name
	 */
	public void setName(String name){
		this.name=name;
	}
	@Override
	public int getPositionX() {
		// TODO Auto-generated method stub
		return this.positionX;
	}
	@Override
	public void setPositionX(int x) {
		// TODO Auto-generated method stub
		this.positionX=x;
	}
	@Override
	public int getPositionY() {
		// TODO Auto-generated method stub
		return this.positionY;
	}
	@Override
	public void setPositionY(int y) {
		// TODO Auto-generated method stub
		this.positionY=y;
	}
//	public Image getImageFromPath() {
//		// TODO Auto-generated method stub
//		imgAnimal=new AppImage(name+".png");
//		return imgAnimal.loadImage();
//	}
//
//	public Image getAnimalImage(){
//		imgAnimal=new AppImage(name+".png");
//		return imgAnimal.loadImage();
//	}
	/**
	 * returns the set animal image
	 */
	@Override
	public Image getImage() {
		return this.image.loadImage();
	}
	/**
	 * set the image for the animal;this method is useful since we have the grass image before the actual animal image 
	 * called 
	 */
	@Override
	public void setImage(String img) {
		this.image = new AppImage(img +".png");
	}
	@Override
	public void playAudio() {
		audio=new Audio(this.name + ".wav");
		audio.playAudio();
	}
	@Override
	public boolean isFound() {
		// TODO Auto-generated method stub
		return isFound;
	}
	/**
	 * method used to set isFound variable of the animal class once an alphabet is found in the maze
	 * @param found
	 */
	public void setisFound(boolean found){
		isFound=found;
	}
	//@Override
	/*public boolean isFoundOnce() {
	// TODO Auto-generated method stub
	return false;
}*/
}
