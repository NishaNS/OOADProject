
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import commonutil.AppImage;
import model.ThemeModel;
import view.ThemeView;

/**
 * @author Nisha
 * The ThemeController implements the listeners for the buttons in ThemeView class.
 */

public class ThemeController {

	private ThemeView tview;
	private ThemeModel tmodel;
	private LevelController lcontroller;

	public ThemeController() {

		tview = new ThemeView();
		tmodel = new ThemeModel();
		//lcontroller = new LevelController(levelModel, levelView);

		tview.addFarmBtnListener(new myActionListener());
		tview.addAlphaBtnListener(new myActionListener());
	}
	
	public JPanel getView(){
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
			}

			else if(e.getSource().toString().contains("ALPHABETS") == true) {
			
				ThemeView.setBtnSelected(true);
				tmodel.setTheme(2);
				//lcontroller.getView();
				
			}
		}
	}	
}
