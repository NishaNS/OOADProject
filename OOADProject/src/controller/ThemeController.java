
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import commonutil.AppImage;
import model.ThemeModel;
import view.LevelView;
import view.ThemeView;

/**
 * @author Nisha
 * The ThemeController implements the listeners for the buttons in ThemeView class.
 */

//HELLO

public class ThemeController {

	private ThemeView tview;
	private ThemeModel tmodel;
	private LevelController lcontroller;
	private MainDisplayController mainController;
	public ThemeController(MainDisplayController mController) {
			tview = new ThemeView();
			tmodel = new ThemeModel();
			mainController=mController;
		
		//lcontroller = new LevelController(levelModel, levelView);

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
				lView.loadAudio();
				
			}

			else if(e.getSource().toString().contains("ALPHABETS") == true) {
			
				ThemeView.setBtnSelected(true);
				tmodel.setTheme(2);
				//lcontroller.getView();
				LevelController lController = mainController.getLController();
				LevelView lView = lController.getView();
				tview.setVisible(false);
				(mainController.getView()).addPanels(lView);
				lView.loadAudio();
			}
		}
	}	
}
