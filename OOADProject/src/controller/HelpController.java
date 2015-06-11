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
import view.HomeView;

/**
 * @author
 *
 */
public class HelpController{

private MainDisplayController mController;
private HomeController hController;
private HelpView view;	
	HelpController(MainDisplayController mainController){
		mController=mainController;
		view=new HelpView();
		addListeners();
	}
	public void addListeners(){
		view.addButtonListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource().equals(view.getBack())){
					hController=mController.getHController();
					
					HomeView hView=hController.getView();
					getView().setVisible(false);
					hController.setMenuSelected(false);
					(mController.getView()).addPanels(hView);
				}
			}
			
		});
	}
	
	public HelpView getView(){
		return view;
	}
}
