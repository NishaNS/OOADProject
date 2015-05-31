/**
 * 
 */
package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.RepaintManager;

import model.Maze;
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
	private int theme, level;

	private Maze maze;
	private Player player;
	private int[][] arrMaze;

	public GameController() {
		theme = 1;
		level = 1;
		maze = new Maze(theme, level);
		gView = new GameView(maze);
		gView.addMazePanelListener(new MazeKeyListener());
		arrMaze=maze.getMazeLayout();
		player= gView.getPlayer();
	}

	public JPanel getView(){
		return gView;
	}


	private class MazeKeyListener extends KeyAdapter {

		public void keyPressed (KeyEvent e) {


			int keycode = e.getKeyCode();
			if (keycode == KeyEvent.VK_UP) {
				int currentX = player.getTileX();
				int currentY = player.getTileY();
				if(currentY - 1 >= 0)
				{
					if(arrMaze[currentY - 1][currentX] != 1)
						player.move(0, -1);
				}
				gView.redrawMazePanel();

			}

			if (keycode == KeyEvent.VK_DOWN) {
				int currentX = player.getTileX();
				int currentY = player.getTileY();
				if(currentY + 1 <= 5)
				{
					if(arrMaze[currentY + 1][currentX] != 1)
						player.move(0, 1);
				}
				gView.redrawMazePanel();
			}

			if (keycode == KeyEvent.VK_LEFT) {
				int currentX = player.getTileX();
				int currentY = player.getTileY();
				if(currentX - 1 >= 0)
				{
					if(arrMaze[currentY][currentX - 1] != 1)
						player.move(-1, 0);
				}
				gView.redrawMazePanel();
			}

			if (keycode == KeyEvent.VK_RIGHT) {
				int currentX = player.getTileX();
				int currentY = player.getTileY();
				if(currentX + 1 <= 8)
				{
					if(arrMaze[currentY][currentX + 1] != 1)
						player.move(1, 0);
				}
				gView.redrawMazePanel();
			}

			/*


			if (keycode == KeyEvent.VK_S) {
				if(!m.getMap(p.getTileX(), p.getTileY() + 1).equals("w")){
					p.move(0, 1);
				}

			}

			if (keycode == KeyEvent.VK_A) {
				if(!m.getMap(p.getTileX() - 1, p.getTileY()).equals("w")){
					//move left
					p.move(-1, 0);
				}


			}
			if (keycode == KeyEvent.VK_D) {
				if(!m.getMap(p.getTileX() + 1, p.getTileY()).equals("w")){
					p.move(1, 0);	
				}
			 */
		}
	}
}


