/**
 * 
 */
package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.awt.event.FocusListener;

import commonutil.Audio;
import commonutil.PanelWithAudio;
import model.HomeModel;
import model.Student;
import view.CreditsView;
import view.HelpView;
import view.HomeView;
import view.MainDisplayView;
import view.ThemeView;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


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
	private Student student;
	private Component[] components;
	private int currentPanel = 0;
	private MainDisplayController mainController;
	private HelpController helpController;
	private CreditsController cController;
	private boolean selectionPerformed;
	private boolean menuSelected;
	
	
	private String DEFAULT_FIRST_NAME="First name";
	private String DEFAULT_LAST_NAME="Last name";
	
	
	public HomeView getView() {
		return view;
	}

	public HomeController(MainDisplayController mController){
		this.view = new HomeView();
		this.model = new HomeModel();
		this.mainController = mController;
		timer = new Timer(4000,this);
		addListeners();
		timer.start();
		student=new Student();
		student.setFirstName(DEFAULT_FIRST_NAME);
		student.setLastName(DEFAULT_LAST_NAME);
		
	}
	
	public void setMenuSelected(boolean m){
		menuSelected=m;
	}
	
	
	
	private void addListeners(){
		
		this.view.addMenuActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				menuSelected=true;
				// TODO Auto-generated method stub
				if(e.getSource().equals(view.getHelp())){
					
					System.out.println("Help selected");
					helpController=mainController.getHlController();
					HelpView hView=helpController.getView();
					view.setVisible(false);
					(mainController.getView()).addPanels(hView);
				}
				if(e.getSource().equals(view.getCredits())){
					System.out.println("Credits Selected");
					cController=mainController.getCrController();
					CreditsView cView=cController.getView();
					view.setVisible(false);
					(mainController.getView()).addPanels(cView);
				}
			}
			
		});
//		this.view.addMenuListListener(new MenuListener(){
//
//			@Override
//			public void menuSelected(MenuEvent e) {
//				// TODO Auto-generated method stub
//				if(e.getSource().equals(view.getHelp())){
//					System.out.println("Help selected");
//				}
//				
//				if(e.getSource().equals(view.getCredits())){
//					System.out.println("Credits selected");
//				}
//				
//			}
//
//			@Override
//			public void menuDeselected(MenuEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void menuCanceled(MenuEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		});
	
		this.view.addTextField1Listener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				view.getFirstNameTextField().requestFocus();
				view.getFirstNameTextField().setFocusable(true);
				view.getFirstNameTextField().setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(view.getFirstNameTextField().getText().equals("")){
					student.setFirstName(DEFAULT_FIRST_NAME);
				}
				else{
					student.setFirstName(view.getFirstNameTextField().getText());
				}
				view.getFirstNameTextField().setFocusable(false);
				//view.getContinueButton().setFocusable(true);
			}
			
		});
		
		this.view.addTextField2Listener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				view.getLastNameTextField().requestFocus();
				view.getLastNameTextField().setFocusable(true);
				view.getLastNameTextField().setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(view.getLastNameTextField().getText().equals("")){
					student.setLastName(DEFAULT_LAST_NAME);
				}
				else{
					student.setLastName(view.getLastNameTextField().getText());
				}
				view.getLastNameTextField().setFocusable(false);
				//view.getContinueButton().setFocusable(true);
			}
			
		});
		
		this.view.addContinueKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				timer.stop();
				//System.out.println("Continue pressed");
				
				if(!view.getFirstNameTextField().hasFocus() && !view.getLastNameTextField().hasFocus()){
				selectionPerformed=true;
				ThemeController tController = mainController.getTController();
				tController.setStudent(student);
				ThemeView tView = tController.getView();
				mainController.getView().setJMenuBar(null);
				mainController.getView().repaint();
				view.setVisible(false);
				(mainController.getView()).addPanels(tView);
				tController.loadAudio();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});

		this.view.addContinueActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(e.getSource().equals(view.getContinueButton())){
					selectionPerformed=true;
					ThemeController tController = mainController.getTController();
					tController.setStudent(student);
					ThemeView tView = tController.getView();
					view.getContinueButton().setEnabled(false);
					view.getContinueButton().setFocusable(false);
					view.setVisible(false);
					mainController.getView().setJMenuBar(null);
					mainController.getView().repaint();
					(mainController.getView()).addPanels(tView);
					tController.loadAudio();
				}
			}
			
		});

//		this.view.addContinueActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Continue Button Clicked!");
//			}
//		});
	}
	
//	public void playWelcomeAudio(){
//	        Audio objAudio = new Audio("welcome.wav");
//	        objAudio.playAudio();
//	        //Thread.sleep(1000);
////	        audioTest();
//	        
//	}



	@Override
	public void actionPerformed(ActionEvent e) {
		java.util.List<PanelWithAudio> audioPanels = this.view.getAudioPanels();
		for(PanelWithAudio panel: audioPanels){
			panel.setBackground(Color.ORANGE);
		}
		PanelWithAudio panelWithAudio = audioPanels.get(currentPanel);
		panelWithAudio.setBackground(Color.YELLOW);
		if(!view.getFirstNameTextField().hasFocus() && !view.getLastNameTextField().hasFocus())
		panelWithAudio.getComponent(0).requestFocus();
		if(!selectionPerformed && !menuSelected)
		panelWithAudio.playAudio();
		currentPanel = currentPanel + 1 == audioPanels.size() ? 0 : currentPanel +1 ;
	}
	
	
	
}
