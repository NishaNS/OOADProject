/**
 * 
 */
package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import model.Maze;
import view.GameView;

/**
 * @author 
 *
 */
public class GameController {

	private GameView gView;
	private ThemeController tController;
	private LevelController lController;
	private int theme, level;

	private Maze maze;
	private int[][] arrMaze;

	public GameController() {
		theme = 1;
		level = 1;
		maze = new Maze(theme, level);
		gView = new GameView(maze);
		gView.addMazePanelListener(new MazeKeyListener());
	}

	public JPanel getView(){
		return gView;
	}

	public void getMazeLayout() {
		arrMaze = maze.getMazeLayout();
	}

	private class MazeKeyListener extends KeyAdapter{
		public void keyPress(KeyEvent e){
			
		}
	}
	
}
