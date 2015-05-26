/**
 * 
 */
package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import javax.swing.*;

import controller.LevelController;

import commonutil.Audio;
/**
 * @author hemali
 *
 */
public class LevelView extends JPanel{

	public JButton btnLevel1;
	public JButton btnLevel2;
	public JButton btnLevel3;
	private JLabel lblDisplay1;
	private JLabel lblDisplay2;
	private ImageIcon imglevelOne;
	private ImageIcon imglevelTwo;
	private ImageIcon imglevelThree;
	private int trackVariable;
	public Audio auLevel;
	public LevelController levelController;
/**
 * LevelView constructor 
 */
public LevelView(){
	imglevelOne=new ImageIcon("image/Level1.png","Easy");
	imglevelTwo=new ImageIcon("image/Level2.png","Medium");
	imglevelThree=new ImageIcon("image/Level3.png","Hard");
	imglevelOne=this.scaleImage(60, 50, imglevelOne);
	imglevelTwo=this.scaleImage(60, 50, imglevelTwo);
	imglevelThree=this.scaleImage(60, 50, imglevelThree);
	
	btnLevel1=new JButton(imglevelOne);
	btnLevel2=new JButton(imglevelTwo);
	btnLevel3=new JButton(imglevelThree);
	
	btnLevel1.setBackground(Color.MAGENTA);
	lblDisplay1=new JLabel("Select the level");
	lblDisplay2=new JLabel("(Default level is easy)");

	GridBagLayout gridBag=new GridBagLayout();
	this.setLayout(gridBag);
	Font font=new Font("",Font.ITALIC,35);
	
	GridBagConstraints constraint=new GridBagConstraints();
	constraint.gridx=1;
	constraint.gridy=0;
	
	lblDisplay1.setFont(font);
	this.add(lblDisplay1,constraint);
	constraint.gridy++;
	lblDisplay2.setFont(font);
	this.add(lblDisplay2,constraint);

	constraint.gridx--;	
	constraint.gridy++;
	
	this.add(btnLevel1,constraint);
	constraint.gridx++;

	this.add(btnLevel2,constraint);
	constraint.gridx++;

	this.add(btnLevel3,constraint);
	this.setSize(200, 200);
	this.setBackground(Color.ORANGE);
	
}
/**
 * The method to scale the images given to the button
 */
public ImageIcon scaleImage(int x,int y,ImageIcon i){
	Image img = i.getImage(); 
	Image newimg = img.getScaledInstance(230, 310,  java.awt.Image.SCALE_SMOOTH);  
	return new ImageIcon(newimg); 
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
 * @param t
 */
public void setTrackVariable(int t){
	trackVariable=t;
}

/**
 * The method to add listeners to the buttons
 * @return void
 */
public void addPressListen(LevelController.KeyListen k){
	this.setFocusable(true);
	this.addKeyListener(k);
}
/**
 * 
 * @param a
 */
public void addButtonListen(ActionListener a){
btnLevel1.addActionListener(a);
btnLevel2.addActionListener(a);
btnLevel3.addActionListener(a);
}

/**
 * The method which plays the initial audio
 * @return void
 */

public void playSelectAudio(){
	trackVariable=0;
	
	auLevel=new Audio("Level_select.wav");
	auLevel.playAudio();
	setTrackVariable(1);
	if(levelController.getSelectionPerformed()!=1){
	auLevel.setauFileName("Level_easy_select_option.wav");
	auLevel.playAudio();
	
	}
	
	if(levelController.getSelectionPerformed()!=1){
	try{
	Thread.sleep(3000);
	}catch(Exception e){}
	}
	
	
	if(levelController.getSelectionPerformed()!=1){
		setTrackVariable(2);
		auLevel.setauFileName("Level_medium_select_option.wav");
		auLevel.playAudio();
	}
	if(levelController.getSelectionPerformed()!=1){
	try{
		Thread.sleep(3000);
		}catch(Exception e){}
	}
	
	
	if(levelController.getSelectionPerformed()!=1){
		setTrackVariable(3);
		auLevel.setauFileName("Level_difficult_select_option.wav");
		auLevel.playAudio();
		trackVariable=4;
	}
	
	
}
}
