package model;

import java.awt.Image;

public interface MazeElement {
int getPositionX();
void setPositionX(int x);
int getPositionY();
void setPositionY(int y);
Image getImage();
void setImage(Image img);
void playAudio();
boolean isFound();
//boolean isFoundOnce();

}
