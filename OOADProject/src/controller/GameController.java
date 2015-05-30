/**
 * 
 */
package controller;

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

		gView = new GameView();


	}

	public JPanel getView(){
		return gView;
	}

	public void getMazeLayout() {
		arrMaze = maze.getMazeLayout();
	}

}
