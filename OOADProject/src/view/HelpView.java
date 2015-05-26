/**
 * 
 */
package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import javax.swing.*;

import commonutil.Audio;
import controller.HelpController;
/**
 * @author hemali
 *
 */
public class HelpView extends JPanel{

	public JButton btnYes;
	public JButton btnNo;
	private JLabel lblDisplay;
	private int trackVariable;
	public Audio auHelp;
	public HelpController helpController;
/**
 * HelpView constructor 
 */
public HelpView(){
	btnYes=new JButton(new ImageIcon("image/YesButton.png"));
	btnNo=new JButton(new ImageIcon("image/NoButton.png"));
	lblDisplay=new JLabel("Do you need help?  ");
	
	GridBagLayout gridBag=new GridBagLayout();
	this.setLayout(gridBag);
	Font font=new Font("",Font.ITALIC,35);
	
	GridBagConstraints constraint=new GridBagConstraints();
	constraint.gridx=0;
	constraint.gridy=0;
	lblDisplay.setFont(font);
	
	this.add(lblDisplay,constraint);
	constraint.gridy++;
	Insets in=new Insets(10,10,10,10);
	constraint.insets=in;
	
	this.add(btnYes,constraint);
	constraint.gridy++;
	
	this.add(btnNo,constraint);
	this.setSize(200, 200);
	this.setBackground(Color.ORANGE);
}
/** 
 * The getter method for the private variable trackVariable
 * @return int
 * 
 */
public int getTrackVariable(){
	return trackVariable;
}
/**
 * The setter method for the private variable trackVariable
 * @param int
 */
public void setTrackVariable(int t){
	trackVariable=t;
}

/**
 * The method to add listeners to the buttons
 * @return void
 */
public void addPressListen(KeyAdapter k){
	this.setFocusable(true);
	this.addKeyListener(k);
}
/**
 * 
 * @param a
 */
public void addButtonListen(ActionListener a){
btnYes.addActionListener(a);
btnNo.addActionListener(a);
}

/**
 * The method which plays the initial audio
 * @return void
 */

public void playSelectAudio(){
	trackVariable=0;
	
	auHelp=new Audio("do_you_need_help.wav");
	auHelp.playAudio();
	trackVariable=1;
	if(helpController.getSelectionPerformed()!=1){
	auHelp.setauFileName("help_yes.wav");
	auHelp.playAudio();
	try{
	Thread.sleep(3000);
	}catch(Exception e){}
	}
	
	if(helpController.getSelectionPerformed()!=1){
	trackVariable=2;
	btnYes.transferFocus();
	auHelp.setauFileName("help_no.wav");
	auHelp.playAudio();
	trackVariable=3;
	try{
		Thread.sleep(3000);
		}catch(Exception e){}
	
	}
	
	auHelp.setauFileName("help_no_option_selected.wav");
	auHelp.playAudio();

	
}
}
