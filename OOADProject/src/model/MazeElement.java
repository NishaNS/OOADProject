package model;

import java.awt.Image;

public interface MazeElement {
	void setName(String name);
	String getName();
	int getPositionX();
	void setPositionX(int x);
	int getPositionY();
	void setPositionY(int y);
	Image getImage();
	void setImage(String img);
	void playAudio();
	boolean isFound();
	void setisFound(boolean found);
	//Image getAnimalImage();
	//boolean isFoundOnce();

}
