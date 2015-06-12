/**
 * 
 */
package controller;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import jpa.ScoreTableController;
import model.Student;
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
		private HelpController helpController;
		private CreditsController cController;
		private HomeView hView;
		private ScoreTableController scoreController;
	
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
			this.gController=new GameController(this);
		if(helpController==null)
			this.helpController=new HelpController(this);
		if(cController==null)
			this.cController=new CreditsController(this);
		if (scoreController==null)
			this.scoreController=new  ScoreTableController(this);
		
		hView = hController.getView();
		this.getView().setJMenuBar(hView.getMenu());
		hView.setSize(mainView.getWindowWidth(), mainView.getWindowHeight());
		mainView.addPanels(hView);
		hController.loadAudio();
	}
	public CreditsController getCrController(){
		return cController; 
	}
	
	public HelpController getHlController(){
		return helpController;
	}
	
	public HomeController getHController(){
	return hController;
	}
	
	public void close(){
		WindowEvent winClosingEvent= new WindowEvent(this.getView(),WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	
	public ScoreTableController getScoreController(){
		return scoreController;
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
