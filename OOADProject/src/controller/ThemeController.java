
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import commonutil.AppImage;
import commonutil.Audio;
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
	
	public ThemeController(MainDisplayController mController) {
			tview = new ThemeView();
			tmodel = new ThemeModel();
			mainController=mController;
			tview.addFarmBtnListener(new myActionListener());
			tview.addAlphaBtnListener(new myActionListener());
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

	
//	public void loadAudio(){
//		//setup and play audio
//		new Thread(new Runnable() {			
//			@Override
//			public void run() {		
//				try {
//					while(!btnSelected) {		
//					Thread.sleep(1000);	
//					auObj = new Audio(fileAu1);					
//					auObj.playAudio();
//
//					auObj = new Audio(fileAu2);
//					setBtnImage2(fileButton3);
//					setBtnImage1(fileButton2);					
//					repaint();
//					btnFarm.requestFocus();
//					auObj.playAudio();
//					Thread.sleep(1000);	
//					
//					auObj = new Audio(fileAu3);
//					setBtnImage1(fileButton1);
//					setBtnImage2(fileButton4);
//					repaint();
//					btnAlphabets.requestFocus();
//					auObj.playAudio();
//				}
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				} 
//			}
//				
//		}).start();	
//	}
	
	/**
	 * @author Nisha
	 * Inner class to implement Action Listener for buttons in ThemeView
	 *
	 */
	private class myActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {			

			if(e.getSource().toString().contains("FARM") == true) {
				
				ThemeView.setBtnSelected(true); 
				tmodel.setTheme(1);				
				//lcontroller.getView();
				LevelController lController = mainController.getLController();
				LevelView lView = lController.getView();
				tview.setVisible(false);
				(mainController.getView()).addPanels(lView);
				lController.loadAudio();
				
			}

			else if(e.getSource().toString().contains("ALPHABETS") == true) {
			
				ThemeView.setBtnSelected(true);
				tmodel.setTheme(2);
				//lcontroller.getView();
				LevelController lController = mainController.getLController();
				LevelView lView = lController.getView();
				tview.setVisible(false);
				(mainController.getView()).addPanels(lView);
				lController.loadAudio();
			}
		}
	}	
}
