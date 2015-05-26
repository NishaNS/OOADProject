/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import commonutil.Audio;
import model.HelpModel;
import view.HelpView;

/**
 * @author
 *
 */
public class HelpController{
public HelpView helpView;
public HelpModel helpModel;
private Audio auHelp;
private int selectionPerformed=0;
/**
 * HelpController constructor which initializes the HelpModel and HelpView objects
 */
public HelpController(HelpModel helpModel,HelpView helpView){
this.helpModel=helpModel;
this.helpView=helpView; 
auHelp=new Audio("");
this.helpView.addPressListen(new KeyListen());
this.helpView.addButtonListen(new ActionListen());
this.helpView.playSelectAudio();
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
 * private inner Mouse ActionListener class 
 *
 */
private class ActionListen implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		helpView.auHelp.stopAudio();
		if(e.getSource().equals(helpView.btnYes)){
			setSelectionPerformed(1);
			auHelp.setauFileName("help_yes_selected.wav");
			auHelp.playAudio();
			helpModel.setNeedHelp(true);
		}
		else if(e.getSource().equals(helpView.btnNo)){
			setSelectionPerformed(1);
			auHelp.setauFileName("help_no_selected.wav");
			auHelp.playAudio();
			helpModel.setNeedHelp(false);
		}
	}
	
}
/**
 * 
 *private inner KeyEvent Listener class
 *
 */
private class KeyListen extends KeyAdapter{
	public void keyPressed(KeyEvent e){
		int keycode=e.getKeyCode();
		helpView.auHelp.stopAudio();
		if( helpView.getTrackVariable()==1){
			setSelectionPerformed(1);
			helpModel.setNeedHelp(true);
			helpView.auHelp.setauFileName("help_yes_selected.wav");
			helpView.auHelp.playAudio();
			
		}
		if(helpView.getTrackVariable()==3){
			helpModel.setNeedHelp(false);
			setSelectionPerformed(1);
			auHelp.setauFileName("help_no_selected.wav");
			auHelp.playAudio();
			
		}
		
	}
	public void keyReleased(KeyEvent e){
	}
	public void keyTyped(KeyEvent e){
		
	}
}

}
