/**
 * 
 */
package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

import commonutil.Audio;
import commonutil.MazeElementPane;
import model.Game;
import model.GameModel;
import model.Maze;
import model.MazeElement;
import model.MazeElements;
import model.Player;
import view.GameView;

/**
 * @author 
 *
 */
public class GameController {

	private GameView gView;
	private ThemeController tController;
	private LevelController lController;
	private GameModel gModel;
	private Audio auGame;
	private Maze maze;
	private Player player;
	private int[][] arrMaze;
	private int countElements;
	private MainDisplayController mainController;
	
	//Mad
		private MazeElement[] mazeObjects;
	//end Mad

	public GameController(MainDisplayController main) {
		mainController=main;
		initializeComponents();
		addListeners();
	}

	private void initializeComponents(){
		//maze = new Maze(tController.getTheme(), lController.getLevel());
		maze = new Maze(1, 1);
		gView = new GameView(maze);
		arrMaze = maze.getMazeLayout();
		//mazeObjects = maze.getMazeObjects();
		player = gView.getPlayer();
		auGame = new Audio();
	}

	private void addListeners(){
		gView.addMazePanelListener(new MazeKeyListener());
	}

	public GameView getView(){
		return gView;
	}

	private void updatePlayerPosition(int x,int y){
		player.move(x, y);
		gView.redrawMazePanel();
		checkForMazeElements();
	}

	
	private void checkForMazeElements(){
		countElements++;
		if(countElements==3){
			Game g=new Game();
			g.setLevel(1);
			g.setTheme(1);
			g.setTime(190);
			g.setScore(200);
			this.getView().setVisible(false);
			this.getView().setFocusable(false);
			EndGameController end=new EndGameController(g,mainController);
			mainController.getView().addPanels(end.getView());
			end.loadAudio();
			
		}
		else{
		if(arrMaze[player.getTileY()][player.getTileX()]==2){
			//System.out.println("X:" + player.getTileX() + " " + "Y:" + player.getTileY());
			MazeElements objElement = maze.getMazeElement(player.getTileY(), player.getTileX());
			objElement.setisFound(true);
			System.out.println(objElement.getName());
			gView.setMazeObject(objElement);
			//objElement.playAudio();
//			gView.getParrot().setImage(gView.getParrot().getName());
			gView.makeGlassPane();
//			gView.getParrot().setisFound(true);
			gView.removeGlassPane();
		}
		}
	}

	
	private class MazeKeyListener extends KeyAdapter {
		private int keyCode ;
		private int currentX;
		private int currentY;
		private boolean downKey = false;
		
		public void keyReleased (KeyEvent e) {
			keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_DOWN) {downKey = false;}
			
			
		}

		public void keyPressed (KeyEvent e) {
			keyCode = e.getKeyCode();
			
			if (keyCode == KeyEvent.VK_UP) {
				currentX = player.getTileX();
				currentY = player.getTileY();
				if(currentY - 1 >= 0){
					if(arrMaze[currentY - 1][currentX] != 1){
						updatePlayerPosition(0,-1);
					}
				}
			}

			if (keyCode == KeyEvent.VK_DOWN) {
				currentX = player.getTileX();
				currentY = player.getTileY();
				if(currentY + 1 <= 5){
					if(arrMaze[currentY + 1][currentX] != 1)
						updatePlayerPosition(0,1);
				}
			}

			if (keyCode == KeyEvent.VK_LEFT) {
				//playAudio("moveleft.wav");
				currentX = player.getTileX();
				currentY = player.getTileY();
				if(currentX - 1 >= 0){
					if(arrMaze[currentY][currentX-1] != 1)
						updatePlayerPosition(-1,0);
				}

			}

			if (keyCode == KeyEvent.VK_RIGHT) {
				//playAudio("moveright.wav");
				currentX = player.getTileX();
				currentY = player.getTileY();
				if(currentX + 1 <= 8){
					if(arrMaze[currentY][currentX+1] != 1)
						updatePlayerPosition(1,0);
				}

			}
		}
		
		
		private void playAudio(String fileName){
			auGame.setauFileName(fileName);
			new Thread(new Runnable(){
				@Override
				public void run(){
					try{
						auGame.playAudio();
					}catch(Exception ex){}
				}
			}).start();
		}
	}
}


