package model;

import java.awt.Image;

import javax.swing.ImageIcon;

import commonutil.AppImage;

public class Player {
	private int positionX,positionY;
	private Image player;
	private Image rightPlayer;
	private Image leftPlayer;
	private Image downPlayer;
	private Image upPlayer;
	
	
public Player(){
	
	player=new AppImage("player.png").loadImage();
//	rightPlayer=new AppImage("").loadImage();
//	leftPlayer=new AppImage("").loadImage();
//	downPlayer=new AppImage("").loadImage();
//	upPlayer=new AppImage("").loadImage();
	
	positionX=0;
	positionY=0;
}
public Image getPlayer(){
	return player;
}
public Image getRightPlayer(){
	return rightPlayer;
}
public Image getLeftPlayer(){
	return leftPlayer;
}
public Image getDownPlayer(){
	return downPlayer;
}
public Image getUpPlayer(){
	return upPlayer;
}

public int getTileX(){
	return positionX;
}
public int getTileY(){
	return positionY;
}


public void move(int tx,int ty){
	positionX+=tx;
	positionY+=ty;
}
}
