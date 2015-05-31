package model;

import java.awt.Image;

import javax.swing.ImageIcon;

import commonutil.AppImage;

public class Maze {

	private final int[][] arrMaze = {
			{0, 0, 0, 1, 1, 1, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0, 0},
			{0, 0, 1, 0, 0, 0, 1, 0 ,0},
			{0, 0, 1, 0, 0, 0, 1, 0 ,0},
			{0, 0, 1, 1, 0, 1, 1, 0 ,0},
			{0, 0, 1, 1, 1, 1, 1, 0 ,0}
	};

	private Image grass, brick, borderV, borderH; 
	private int t, l;

	public Maze(int th, int lvl){
		t = th;
		l = lvl;
		//load images
		ImageIcon img = new ImageIcon("image/brick.png");
		brick = img.getImage();

		img = new ImageIcon("image/grass.png");
		grass = img.getImage();

		img = new ImageIcon("image/border_h.png");
		borderH = img.getImage();

		
		img = new ImageIcon("image/border_v.png");
		borderV = img.getImage();

	}
	
	public Image getGrass(){
		return grass;
	}
	
	public Image getBrick(){
		return brick;
	}
	
	public Image getBorderH(){
		return borderH;
	}
	
	public Image getBorderV(){
		return borderV;
	}
	
	public int[][] getMazeLayout() {
		/*y corresponds to row of map; 
		within that gets a particular col; 
		then decide what tile to put down*/
		
		return arrMaze;		
	}

}
