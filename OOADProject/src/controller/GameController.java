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
import model.Student;
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
	private Audio auLoad; 
	

	private Maze maze;
	private Player player;
	private Student student;
	
	private int theme;
	private int level;
	
	private Game game;

	private Timer localTimer = new Timer(1000,new MyTimer());

	private int[][] arrMaze;
	private int countElements;
	private MainDisplayController mainController;

	//Mad
	private MazeElement[] mazeObjects;
	private int mazeElementsFound;
	private int mazebonusFound;
	//end Mad
	
	private static String MAZE_LOAD_AUD="";
	public int temp;
 	public GameController(MainDisplayController main) {
		mainController=main;
		//initializeComponents();
		//addListeners();
		student=new Student();
		auLoad=new Audio("");
		
//		int theme=mainController.getTController().getTheme();
//		int level=mainController.getLController().getLevel();
	}

 	public void setStudent(Student s){
 		student.setFirstName(s.getFirstName());
		student.setLastName(s.getLastName());
 	}
	public void initializeComponents(int theme,int level){
		//maze = new Maze(tController.getTheme(), lController.getLevel());
		//int theme=mainController.getTController().getTheme();
		//int level=mainController.getLController().getLevel();
		maze = new Maze(theme, level);
		if(theme==1){
			MAZE_LOAD_AUD="mc_donald.wav";
		}
		else{
			MAZE_LOAD_AUD="Deedee.wav";
		}
		game = new Game();
		gView = new GameView(maze);
		gView.control=this;
		arrMaze = maze.getMazeLayout();
		player = gView.getPlayer();
		auGame = new Audio("goodjob.wav");
		game.setLevel(maze.getLevel());
		game.setTheme(maze.getTheme());
		
	}

	public void addListeners(){
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
	private boolean hasGameEnded(){
		return ((game.getLevel()==1 && mazeElementsFound == 5) || (game.getLevel()==2 && mazeElementsFound == 10) );
	}

	private void endGame() {
		EndGameController end=new EndGameController(game,mainController);
		end.setStudent(student);
		gView.setVisible(false);
		gView.setFocusable(false);
		mainController.getView().addPanels(end.getView());
		end.loadAudio();
	}

	private void checkForMazeElements(){

		int playerX =player.getTileY();
		int playerY = player.getTileX();
		int gameScore = game.getScore();

		if(arrMaze[playerX][playerY]==2){
			
			++mazeElementsFound;
			
			gameScore = gameScore + 10;
			game.setScore(gameScore);
			gView.setScore(game.getScore());
			MazeElements objElement = maze.getMazeElement(playerX, playerY);
			objElement.setisFound(true);
			System.out.println(objElement.getName());

			gView.setMazeObject(objElement);
			objElement.setisFound(true);
			arrMaze[playerX][playerY] = 0;
			gView.makeGlassPane();
			if(hasGameEnded()){
				EndExectuor endExectuor = new EndExectuor(){
					@Override
					public void run() {
						endGame();
					}
				};
				gView.removeGlassPane(endExectuor);
			}else {
				gView.removeGlassPane(null);
			}

			
			

		}

		else if(arrMaze[playerX][playerY]==3){
			gameScore = gameScore + 5;
			game.setScore(gameScore);
			gView.setScore(game.getScore());
			gView.setPnlDashBoard(++mazebonusFound);
			System.out.println("Bonus found"+ mazebonusFound);
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
			arrMaze[playerX][playerY] = 0;
		}
	}

	public void loadAudio(){
		new Thread(new Runnable() {			
			@Override
			public void run() {		
				
				auLoad.setauFileName(MAZE_LOAD_AUD);
				auLoad.playAudio();//pause for page load + before looping
					} 
				}).start();
		
	}
	private class MyTimer implements ActionListener {
		int temp;
		int time;
		public void actionPerformed(ActionEvent e) {
			if(gView.getIsTimerPaused()){
				time = game.getTime();
				gView.setTime(time/60, time%60);
				System.out.println("Timer Paused:" + time);
			}else{
				temp++;
				game.setTime(temp);
				time = game.getTime();
				gView.setTime(time/60, time%60);
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
 
