
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import commonutil.AppImage;
import commonutil.Audio;
import model.Student;
import model.ThemeModel;
import view.LevelView;
import view.ThemeView;

/**
 * @author Nisha
 * The ThemeController implements the listeners for the buttons in ThemeView class.
 */

public class ThemeController {

	private ThemeView tview;
	private ThemeModel tmodel;
	private LevelController lcontroller;
	private MainDisplayController mainController;	
	private static boolean btnSelected;		//variable for audio loop condition
	private Audio auObj;
	private Student student;

	
	public ThemeController(MainDisplayController mController) {
		tview = new ThemeView();
		tmodel = new ThemeModel();
		mainController=mController;
		btnSelected = false;
		auObj = new Audio("");
		
		student=new Student();
		
		tview.addBtnListener(new myActionListener());
		tview.addMyKeyListener(new myKeyListener());		
	}


	public ThemeView getView(){
		return tview;
	}

	/**
	 * @return Returns the theme number selected
	 */
	public int getTheme() {		
		return tmodel.getTheme();		
	}
	/**
	 * 
	 * @param s
	 */
	public void setStudent(Student s){
		student.setFirstName(s.getFirstName());
		student.setLastName(s.getLastName());
	}

	public void loadAudio(){
		//setup and play audio
		new Thread(new Runnable() {			


			@Override
			public void run() {		
				try {
					while(!btnSelected) {		
						Thread.sleep(1000);	
						auObj.setauFileName(ThemeView.AUD_PAGE_LOAD);					
						auObj.playAudio();
						tview.getBtnFarm().requestFocus();
						auObj.setauFileName(tview.getBtnFarm().getAudioFile());
						tview.getBtnFarm().requestFocus();
						tview.getBtnFarm().setButton(ThemeView.BUTTON_FARM_S_IMG);
						tview.getBtnAlphabets().setButton(ThemeView.BUTTON_ALPHABETS_O_IMG);				

						if(btnSelected == true) {
							auObj.stopAudio();	
							break;
						}
						
						auObj.playAudio();

						Thread.sleep(1000);

						auObj.setauFileName(tview.getBtnAlphabets().getAudioFile());
						tview.getBtnAlphabets().requestFocus();
						tview.getBtnFarm().setButton(ThemeView.BUTTON_FARM_O_IMG);
						tview.getBtnAlphabets().setButton(ThemeView.BUTTON_ALPHABETS_S_IMG);

						if(btnSelected == true) {
							auObj.stopAudio();	
							break;
						}

						auObj.playAudio();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}

		}).start();	
	}

	/**
	 * @author Nisha
	 * Inner class to implement Action Listener for buttons in ThemeView
	 *
	 */
	private class myActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {			
			auObj.stopAudio();
			if(e.getSource().toString().contains("FARM") == true) {

				btnSelected = true; 
				tmodel.setTheme(1);
				LevelController lController = mainController.getLController();
				lController.setStudent(student);
				LevelView lView = lController.getView();
				tview.getBtnFarm().setEnabled(false);
				tview.getBtnFarm().setFocusable(false);
				tview.setVisible(false);
				(mainController.getView()).addPanels(lView);
				lController.loadAudio();

			}

			else if(e.getSource().toString().contains("ALPHABETS") == true) {

				btnSelected = true; 
				tmodel.setTheme(2);
				LevelController lController = mainController.getLController();
				lController.setStudent(student);
				LevelView lView = lController.getView();
				tview.getBtnAlphabets().setEnabled(false);
				tview.getBtnAlphabets().setFocusable(false);
				tview.setVisible(false);
				(mainController.getView()).addPanels(lView);
				lController.loadAudio();
			}
		}
	}	

	public class myKeyListener extends KeyAdapter {

		public void keyPressed(KeyEvent e){
			auObj.stopAudio();
			System.out.println("HEREEE");

			if(e.getSource().toString().contains("FARM") == true) {
				btnSelected = true; 
				tmodel.setTheme(1);
				LevelController lController = mainController.getLController();
				lController.setStudent(student);
				LevelView lView = lController.getView();
				tview.setVisible(false);
				(mainController.getView()).addPanels(lView);
				lController.loadAudio();

			}
			else if(e.getSource().toString().contains("ALPHABETS") == true) {
				btnSelected = true; 
				tmodel.setTheme(2);
				LevelController lController = mainController.getLController();
				lController.setStudent(student);
				LevelView lView = lController.getView();
				tview.setVisible(false);
				(mainController.getView()).addPanels(lView);
				lController.loadAudio();
			}
		}

	}

}
