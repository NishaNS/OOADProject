/**
 * 
 */
package controller;

import view.HomeView;
import view.MainDisplayView;

/**
 * @author 
 *
 *	for frame window
 */
public class MainDisplayController {
		private MainDisplayView mainView;
		private HomeController hController;
		private HomeView hView;
	
	public MainDisplayController(){
		mainView = new MainDisplayView();
		hController = new HomeController();
		hView = hController.getView();
		hView.setSize(mainView.getWindowWidth(), mainView.getWindowHeight());
		mainView.addPanels(hView);
		
	}
	
	public static void main(String[] args){
		new MainDisplayController();
	}
}
