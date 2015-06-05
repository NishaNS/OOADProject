package view;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import commonutil.MazeElementPane;
import model.Maze;
import model.Player;

public class MazeDrawingPanel extends JPanel {
	
	private Player player;
	private Maze maze;
	private static int PIXEL_COUNT = 100;
	private Timer timer;
	private int theme;
	private int[][] arrMaze;
	private Image backgroundImage;
	private Image block;
	
	private static final String IMAGE_PATH = "image/";
	private static final String IMG_BACKGROUND_T1 = "farm2.jpg";
	private static final String IMG_BACKGROUND_T2 = "farm.png";
	private static String IMG_T1_BLOCK = "tree.png";
	private static String IMG_T2_BLOCK = "tree.png";
	MazeElementPane p;

	
	public MazeDrawingPanel(Player player,Maze maze,int[][] arrMaze,int theme){
		this.player = player;
		this.maze = maze;
		this.arrMaze = arrMaze;
		this.theme = theme;
		loadBackgroundImage();
	}
	
	private void loadBackgroundImage(){
		File filename = null;
		if(theme==1)
			filename = new File(IMAGE_PATH+IMG_BACKGROUND_T1);
		else if(theme ==2)
			filename = new File(IMAGE_PATH+IMG_BACKGROUND_T2);
		try {
		      this.backgroundImage = ImageIO.read(filename);
		    } catch (IOException e) {System.out.println("Error in reading the maze panel background image");}
	}
	
	public void paintComponent(Graphics g){
			super.paintComponent(g);
			//g.drawImage(backgroundImage, 0, 0, this);
			for(int x=0; x<arrMaze[0].length;x++){
				for(int y=0; y<arrMaze.length;y++){
					if(arrMaze[y][x] == 1){
						g.drawImage(maze.getBlock(), x*PIXEL_COUNT, y*PIXEL_COUNT, this);
					}
				}
			}
			g.drawImage(player.getPlayer(), player.getTileX()*PIXEL_COUNT, player.getTileY()*PIXEL_COUNT, this);
		}
}
	
