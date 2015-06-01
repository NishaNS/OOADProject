package model;

import java.awt.Image;

public interface MazeElement {
public void setName(String name);
public String getName();
int getPositionX();
void setPositionX(int x);
int getPositionY();
void setPositionY(int y);
Image getImage();
void setImage(Image img);
void playAudio();
boolean isFound();
public void setisFound(boolean found);
public Image getAnimalImage();
//boolean isFoundOnce();

}
