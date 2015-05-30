/**
 * 
 */
package controller;

/**
 * @author hemali
 *
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import commonutil.Audio;
import model.LevelModel;
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
	/**
	 * HelpController constructor which initializes the HelpModel and HelpView objects
	 */
	public LevelController(){
		levelModel=new LevelModel();
		levelView=new LevelView();
		levelView.levelController=this;
		auLevel=new Audio("");
		this.levelView.addPressListen(new KeyListen());
		this.levelView.addButtonListen(new ActionListen());
		new Thread(new Runnable() {			
			@Override
			public void run() {		
				try {
					Thread.sleep(3000);			//pause for page load + before looping
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
				levelView.playSelectAudio();
			}
		}).start();
	}
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
			levelView.auLevel.stopAudio();
			if(e.getSource().equals(levelView.btnEasy)){
				setSelectionPerformed(1);
				levelModel.setLevel(1);
				auLevel.setauFileName("Level_easy_selected.wav");
				auLevel.playAudio();


			}
			else if(e.getSource().equals(levelView.btnHard)){
				setSelectionPerformed(1);
				levelModel.setLevel(3);
				auLevel.setauFileName("Level_difficult_selected.wav");
				auLevel.playAudio();


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
			levelView.auLevel.stopAudio();

			if(levelView.getTrackVariable()==1){
				setSelectionPerformed(1);
				levelModel.setLevel(1);
				levelView.auLevel.setauFileName("Level_easy_selected.wav");
				levelView.auLevel.playAudio();

			}
			else if(levelView.getTrackVariable()==2){
				setSelectionPerformed(1);
				levelModel.setLevel(3);
				auLevel.setauFileName("Level_difficult_selected.wav");
				auLevel.playAudio();

			}


		}
	}

}
