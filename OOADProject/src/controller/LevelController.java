/**
 * 
 */
package controller;

/**
 * @author hemali
 *
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import commonutil.Audio;
import model.LevelModel;
import view.GameView;
import view.LevelView;

/**
 * @author
 *
 */
public class LevelController{

	public LevelView levelView;
	public LevelModel levelModel;
	private Audio auLevel;
	private int selectionPerformed=0;
	private MainDisplayController mainController;
	private GameController gameController;
	/**
	 * HelpController constructor which initializes the HelpModel and HelpView objects
	 */
	public LevelController(MainDisplayController mainController){
		
		this.mainController=mainController;
		levelModel=new LevelModel();
		levelView=new LevelView();
		levelView.setTrackVariable(1);
		//levelView.levelController=this;
		//levelView.setFocusable(true);
		auLevel=new Audio("");
		levelView.addPressListen(new KeyListen());
		levelView.addButtonListen(new ActionListen());
		
	}
	/**
	 * 
	 */
	
	/**
	 * The method used to get the View for this controller
	 */
	public LevelView getView(){
		return levelView;
	}

	/**
	 * The method used to get the model for this class
	 */
	public LevelModel getModel(){
		return levelModel;
	}


	/**
	 * The getter method for selectionPerformed variable
	 * @return int
	 */
	public int getSelectionPerformed(){
		return selectionPerformed;
	}

	/**
	 * The setter method for the selectionPerformed Variable
	 * @param s
	 */
	public void setSelectionPerformed(int s){
		selectionPerformed=s;
	}
	/**
	 * 
	 * private inner ActionListener class 
	 *
	 */
	private class ActionListen implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			auLevel.stopAudio();
			if(e.getSource().equals(levelView.btnEasy)){
				setSelectionPerformed(1);
				levelModel.setLevel(1);
				auLevel.setauFileName("Level_easy_selected.wav");
				auLevel.playAudio();
				GameController gController = mainController.getGController();
				GameView gView = gController.getView();
				levelView.setVisible(false);
				(mainController.getView()).addPanels(gView);

			}
			else if(e.getSource().equals(levelView.btnHard)){
				setSelectionPerformed(1);
				levelModel.setLevel(3);
				auLevel.setauFileName("Level_difficult_selected.wav");
				auLevel.playAudio();
				GameController gController = mainController.getGController();
				GameView gView = gController.getView();
				levelView.setVisible(false);
				(mainController.getView()).addPanels(gView);


			}
		}

	}
	/**
	 * 
	 *private inner KeyEvent Listener class
	 *
	 */
	public class KeyListen extends KeyAdapter{

		public void keyPressed(KeyEvent e){
			auLevel.stopAudio();
			if(e.getSource().toString().contains("Level1"))
			{
				System.out.println("Level 1 pressed!");
				setSelectionPerformed(1);
				levelModel.setLevel(1);
				auLevel.setauFileName("Level_easy_selected.wav");
				auLevel.playAudio();
				
				GameController gController = mainController.getGController();
				GameView gView = gController.getView();
				levelView.btnEasy.setFocusable(false);
				levelView.setFocusable(false);
				levelView.setVisible(false);
				(mainController.getView()).addPanels(gView);
			}
			if(e.getSource().toString().contains("Level2"))
			{
				System.out.println("Level 2 pressed!");
				setSelectionPerformed(1);
				levelModel.setLevel(3);
				auLevel.setauFileName("Level_difficult_selected.wav");
				auLevel.playAudio();
				GameController gController = mainController.getGController();
				GameView gView = gController.getView();
				levelView.btnHard.setFocusable(false);
				levelView.setFocusable(false);
				levelView.setVisible(false);
				(mainController.getView()).addPanels(gView);
			}
		}
	}
	public void loadAudio(){
		new Thread(new Runnable() {			
			@Override
			public void run() {		
				
					playSelectAudio();//pause for page load + before looping
					} 
				}).start();
	}

	public void playSelectAudio(){
		levelView.setTrackVariable(1);
		try {
				
		
		while(true){
			Thread.sleep(1000);
			//System.out.println("true");
			levelView.setTrackVariable(1);
			if(getSelectionPerformed()!=1){
				auLevel=new Audio(LevelView.PAGE_LOAD_AUD);
				auLevel.playAudio();
				levelView.setTrackVariable(1);

			}else{
				break;
			}
			if(getSelectionPerformed()!=1){
				levelView.btnEasy.requestFocus();
				levelView.btnEasy.setButton(LevelView.BUTTON_EASY_S_IMG);
				auLevel.setauFileName(levelView.btnEasy.getAudioFile());
				auLevel.playAudio();
				levelView.btnEasy.reset(LevelView.BUTTON_EASY_O_IMG);
			}
			else{
				break;	
			}	

			if(getSelectionPerformed()!=1){
				levelView.setTrackVariable(2);
				levelView.btnHard.requestFocus();
				levelView.btnHard.setButton(LevelView.BUTTON_HARD_S_IMG);
				auLevel.setauFileName(levelView.btnHard.getAudioFile());
				auLevel.playAudio();
				levelView.btnHard.reset(LevelView.BUTTON_HARD_O_IMG);
				continue;
			}{
				break;
			}
		}
		}catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		
}

}
