package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CreditsView;
import view.HelpView;
import view.HomeView;

public class CreditsController {
	private MainDisplayController mController;
	private HomeController hController;
	private CreditsView view;	
		
	public CreditsController(MainDisplayController mainController){
			mController=mainController;
			view=new CreditsView();
			addListeners();
		}
		public void addListeners(){
			view.addButtonListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(e.getSource().equals(view.getBack())){
						hController=mController.getHController();
						hController.setMenuSelected(false);
						HomeView hView=hController.getView();
						getView().setVisible(false);
						(mController.getView()).addPanels(hView);
					}
				}
				
			});
		}
		
		public CreditsView getView(){
			return view;
		}
}
