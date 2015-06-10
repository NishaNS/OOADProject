/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

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

	private Game game;

	private Timer localTimer = new Timer(1000,new MyTimer());

	private int[][] arrMaze;
	private int countElements;
	private MainDisplayController mainController;

	//Mad
	private MazeElement[] mazeObjects;
	private int mazeElementsFound;
	private int bonusCount;
	//end Mad


 	public GameController(MainDisplayController main) {
		mainController=main;
		initializeComponents();
		addListeners();
		
	}

	private void initializeComponents(){
		//maze = new Maze(tController.getTheme(), lController.getLevel());
		maze = new Maze(1, 1);
		game = new Game();
		gView = new GameView(maze);
		arrMaze = maze.getMazeLayout();
		player = gView.getPlayer();
		auGame = new Audio("goodjob.wav");
		game.setLevel(maze.getLevel());
		game.setTheme(maze.getTheme());
		
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

		int playerX =player.getTileY();
		int playerY = player.getTileX();
		int gameScore = game.getScore();

		if(arrMaze[playerX][playerY]==2){
			mazeElementsFound++;
			gameScore = gameScore + 10;
			game.setScore(gameScore);
			gView.getScorePanel().setScore(game.getScore());
			MazeElements objElement = maze.getMazeElement(playerX, playerY);
			objElement.setisFound(true);
			System.out.println(objElement.getName());

			gView.setMazeObject(objElement);
			objElement.setisFound(true);
			arrMaze[playerX][playerY] = 0;
			gView.makeGlassPane();
			gView.removeGlassPane();
			
			if((game.getLevel()==1 && mazeElementsFound == 5) || (game.getLevel()==2 && mazeElementsFound == 10) ){
				localTimer.stop();
				gView.setVisible(false);
				gView.setFocusable(false);
				EndGameController end=new EndGameController(game,mainController);
				mainController.getView().addPanels(end.getView());
				end.loadAudio();
			}
		}

		else if(arrMaze[playerX][playerY]==3){
			arrMaze[playerX][playerY] = 0;
			gameScore = gameScore + 5;
			bonusCount++;
			game.setScore(gameScore);
			gView.getScorePanel().setScore(game.getScore());
			gView.getBonusPanel().loadBonusImage("img_t1_bonus".concat(bonusCount+"").concat(".png"));
			//playaudio -- you found an egg
			new Thread(new Runnable(){
				@Override
				public void run(){
					try{
						auGame.playAudio();
						//isTimerPaused = false;
					}catch(Exception ex){}
				}
			}).start();

		}
	}

	private class MyTimer implements ActionListener {
		int temp;
		int time;
		public void actionPerformed(ActionEvent e) {
			if(gView.getIsTimerPaused()){
				time = game.getTime();
				gView.getScorePanel().setTime(time/60, time%60);
				System.out.println("Timer Paused:" + time);
			}else{
				temp++;
				game.setTime(temp);
				time = game.getTime();
				gView.getScorePanel().setTime(time/60, time%60);
				System.out.println("Timer Resumed:" + time);
			}
		}

	}

	private class MazeKeyListener extends KeyAdapter {

		private boolean downKey = false;

		public void keyReleased (KeyEvent e) {
			int keyCode = e.getKeyCode();
			if (keyCode == KeyEvent.VK_DOWN) {downKey = false;}
		}

		public void keyPressed (KeyEvent e) {
			int keyCode = e.getKeyCode();
			int currentX = player.getTileX();
			int currentY = player.getTileY();

			if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT){
				if(!localTimer.isRunning()){
					localTimer.start();
				}
			}

			if (keyCode == KeyEvent.VK_UP) {
				if(currentY - 1 >= 0){
					if(arrMaze[currentY - 1][currentX] != 1){
						updatePlayerPosition(0,-1);
					}
				}
			}

			if (keyCode == KeyEvent.VK_DOWN) {
				if(currentY + 1 < arrMaze.length){
					if(arrMaze[currentY + 1][currentX] != 1)
						updatePlayerPosition(0,1);
				}
			}

			if (keyCode == KeyEvent.VK_LEFT) {
				//playAudio("moveleft.wav");
				if(currentX - 1 >= 0){
					if(arrMaze[currentY][currentX-1] != 1)
						updatePlayerPosition(-1,0);
				}

			}

			if (keyCode == KeyEvent.VK_RIGHT) {
				//playAudio("moveright.wav");
				if(currentX + 1 < arrMaze[0].length){
					if(arrMaze[currentY][currentX+1] != 1)
						updatePlayerPosition(1,0);
				}

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

/*
 * 
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

			}*/
 
