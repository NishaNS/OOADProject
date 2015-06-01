/**
 * 
 */
package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

import commonutil.Audio;

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
	private Audio auGame;
	private Maze maze;
	private Player player;
	private int[][] arrMaze;
	private int animalCount;
	public GameController() {
		theme = 1;
		level = 1;
		maze = new Maze(theme, level);
		gView = new GameView(maze);
		gView.addMazePanelListener(new MazeKeyListener());
		arrMaze=maze.getMazeLayout();
		player= gView.getPlayer();
		animalCount=0;
		
	}

	public GameView getView(){
		return gView;
	}


	private class MazeKeyListener extends KeyAdapter {

		public void keyPressed (KeyEvent e) {
			
			System.out.println("Inside key");
			int keycode = e.getKeyCode();
			if (keycode == KeyEvent.VK_UP) {
				int currentX = player.getTileX();
				int currentY = player.getTileY();
				if(currentY - 1 >= 0)
				{
					if(arrMaze[currentY - 1][currentX] != 1)
						player.move(0, -1);
					if(arrMaze[currentY][currentX]==2){
						gView.getParrot().setImage(gView.getParrot().getAnimalImage());
						gView.getParrot().playAudio();
						}
					if(arrMaze[currentY][currentX]==3){
						gView.getSheep().setImage(gView.getSheep().getAnimalImage());
						}
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
					if(arrMaze[currentY][currentX]==2){
						gView.getParrot().setImage(gView.getParrot().getAnimalImage());
						gView.getParrot().playAudio();
						}
					if(arrMaze[currentY][currentX]==3){
						gView.getSheep().setImage(gView.getSheep().getAnimalImage());
						}
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
					if(arrMaze[currentY][currentX]==2){
						gView.getParrot().setImage(gView.getParrot().getAnimalImage());
						}
					if(arrMaze[currentY][currentX]==3){
						gView.getSheep().setImage(gView.getSheep().getAnimalImage());
						}
					
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
					if(arrMaze[currentY][currentX]==2){
						gView.getParrot().setImage(gView.getParrot().getAnimalImage());
					}
					if(arrMaze[currentY][currentX]==3){
						gView.getSheep().setImage(gView.getSheep().getAnimalImage());
						}
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


