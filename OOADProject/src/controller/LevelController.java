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

//import controller.LevelController.ActionListen;
import controller.LevelController.KeyListen;
import commonutil.Audio;
import model.HelpModel;
import model.LevelModel;
import view.HelpView;
import view.LevelView;

/**
 * @author
 *
 */
public class LevelController{

	public LevelView levelView;
	public LevelModel levelModel;
	private Audio auHelp;
	private int selectionPerformed=0;
/**
 * HelpController constructor which initializes the HelpModel and HelpView objects
 */
	public LevelController(LevelModel levelModel,LevelView levelView){
			this.levelModel=levelModel;
			this.levelView=levelView;
			levelView.levelController=this;
			auHelp=new Audio("");
			this.levelView.addPressListen(new KeyListen());
			this.levelView.addButtonListen(new ActionListen());
			this.levelView.playSelectAudio();
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
		if(e.getSource().equals(levelView.btnLevel1)){
			setSelectionPerformed(1);
			levelModel.setLevel(1);
			auHelp.setauFileName("Level_easy_selected.wav");
			auHelp.playAudio();
			
			
		}
		else if(e.getSource().equals(levelView.btnLevel2)){
			setSelectionPerformed(1);
			levelModel.setLevel(2);
			auHelp.setauFileName("Level_medium_selected.wav");
			auHelp.playAudio();
			
			
		}
		else if(e.getSource().equals(levelView.btnLevel3)){
			setSelectionPerformed(1);
			levelModel.setLevel(3);
			auHelp.setauFileName("Level_difficult_selected.wav");
			auHelp.playAudio();
			
			
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
			levelModel.setLevel(2);
			auHelp.setauFileName("Level_medium_selected.wav");
			auHelp.playAudio();
			
		}
		else if(levelView.getTrackVariable()==3){
			setSelectionPerformed(1);
			levelModel.setLevel(3);
			auHelp.setauFileName("Level_difficult_selected.wav");
			auHelp.playAudio();
			
		}
		
		
	}
	public void keyReleased(KeyEvent e){

	}
	public void keyTyped(KeyEvent e){
	}
	}

}
