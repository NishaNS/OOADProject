package model;

import java.awt.Image;

import commonutil.AppImage;
import commonutil.Audio;

public class Animal implements MazeElement{
String name;
int positionX;
int positionY;
Image animalImage;
Audio auAnimal;
AppImage imgAnimal;
boolean isFound;

/**
 * The method used to get the name of the animal
 * @return String
 */
public String getName(){
	return name;
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
	return positionX;
}
@Override
public void setPositionX(int x) {
	// TODO Auto-generated method stub
	positionX=x;
}
@Override
public int getPositionY() {
	// TODO Auto-generated method stub
	return positionY;
}
@Override
public void setPositionY(int y) {
	// TODO Auto-generated method stub
	positionY=y;
}
@Override
public Image getImage() {
	// TODO Auto-generated method stub
	imgAnimal=new AppImage(name+".png");
	return imgAnimal.loadImage();
}
@Override
public void setImage(Image img) {
	// TODO Auto-generated method stub
	
}
@Override
public void playAudio() {
	// TODO Auto-generated method stub
	auAnimal=new Audio(name+".wav");
	auAnimal.playAudio();
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
