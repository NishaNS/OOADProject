/**
 * 
 */
package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

import commonutil.Audio;
import commonutil.PanelWithAudio;
import model.HomeModel;
import view.HomeView;

import javax.swing.*;
import javax.swing.Timer;


/**
 * @author Madhu
 * 
 * Welcome page (1st panel)
 *
 */
public class HomeController implements ActionListener{
	private HomeView view;  
	private HomeModel model;
	private Timer timer;
	private Component[] components;
	private int currentPanel = 0;

	public HomeView getView() {
		return view;
	}

	public HomeController(){
		this.view = new HomeView();
		this.model = new HomeModel();
		timer = new Timer(4000,this);
		addListeners();
		timer.start();
	}
	
	
	
	private void addListeners(){
		this.view.addContinueKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				timer.stop();
				System.out.println("Continue pressed");
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});


//		this.view.addContinueActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Continue Button Clicked!");
//			}
//		});
	}
	
	public void playWelcomeAudio(){
	        Audio objAudio = new Audio("welcome.wav");
	        objAudio.playAudio();
	        //Thread.sleep(1000);
//	        audioTest();
	        
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		java.util.List<PanelWithAudio> audioPanels = this.view.getAudioPanels();
		for(PanelWithAudio panel: audioPanels){
			panel.setBackground(Color.GREEN);
		}
		PanelWithAudio panelWithAudio = audioPanels.get(currentPanel);
		panelWithAudio.setBackground(Color.BLUE);
		panelWithAudio.getComponent(0).requestFocus();
		panelWithAudio.playAudio();
		currentPanel = currentPanel + 1 == audioPanels.size() ? 0 : currentPanel +1 ;
	}
	
}
