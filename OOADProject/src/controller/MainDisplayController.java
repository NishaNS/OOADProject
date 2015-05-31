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
		private ThemeController tController;
		private LevelController lController;
		private GameController gController;
		private HomeView hView;
		
	
	public MainDisplayController(){
		if(mainView==null)
			mainView = new MainDisplayView();
		if(hController==null)
			this.hController = new HomeController(this);
		if(tController==null)
			this.tController = new ThemeController(this);
		if(lController==null)
			this.lController = new LevelController(this);
		if(gController==null)
			this.gController=new GameController();
		
		hView = hController.getView();
		
		hView.setSize(mainView.getWindowWidth(), mainView.getWindowHeight());
		mainView.addPanels(hView);
	}
	
	public GameController getGController(){
		return gController;
	}
	public ThemeController getTController(){
		return this.tController;
	}
	
	public LevelController getLController(){
		return this.lController;
	}
	
	public MainDisplayView getView(){
		return mainView;
	}
	
	public static void main(String[] args){
		new MainDisplayController();
	}
}
