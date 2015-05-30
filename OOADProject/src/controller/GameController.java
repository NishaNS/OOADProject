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
	
	public GameController() {
		gView = new GameView();
	}
	
	public JPanel getView(){
		return gView;
	}

}
