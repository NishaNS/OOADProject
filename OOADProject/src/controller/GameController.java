/**
 * 
 */
package controller;

import javax.swing.JPanel;

import view.GameView;

/**
 * @author 
 *
 */
public class GameController {
	
	private GameView gView;
	private ThemeController tController;
	private LevelController lController;
	
	
	public GameController() {
		gView = new GameView();
		//tController = new ThemeController();
		lController = new LevelController();
		
	}
	
	public JPanel getView(){
		return gView;
	}

}
