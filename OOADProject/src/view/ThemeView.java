
package view;

import commonutil.AppImage;
import commonutil.Audio;
import commonutil.CustomButton;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import javax.swing.*;

import controller.ThemeController;
import model.ThemeModel;

/**
 * @author Nisha
 * The ThemeView lets user select the theme of the maze game from options provided.
 */
public class ThemeView extends JPanel {

	private GridBagLayout gridbag;
	private GridBagConstraints gridconstraints;	
	private AppImage imgPageBck;
	private CustomButton btnFarm;
	private CustomButton btnAlphabets;
	private Audio auObj;	
	public static String BUTTON_FARM_O_IMG = "Btn_Farm_Updated.png";
	public static String BUTTON_ALPHABETS_O_IMG = "Btn_Alphabets_Updated.png";
	public static String BUTTON_FARM_S_IMG ="Btn_Farm_Updated_Clicked.png";
	public static String BUTTON_ALPHABETS_S_IMG = "Btn_Alphabets_Updated_Clicked.png";
	
	public static String AUD_PAGE_LOAD = "pg2_theme_onload.wav";
	public static String AUD_BUTTON_FARM = "pg2_theme1_selection.wav";
	public static String AUD_BUTTON_ALPHABETS = "pg2_theme2_selection.wav";
	public static String AUD_BUTTON_FARM_S="pg2_theme1_selected.wav";
	public static String AUD_BUTTON_ALPHA_S="pg2_theme2_selected.wav";
	
	private static String PAGE_BKGND = "Bck_Green_2_Sprayed Filter.png";

	/**
	 * The constructor setups the elements and layout for the Theme page
	 */
	public ThemeView() {

		// set panel layout
		gridbag = new GridBagLayout();
		gridconstraints = new GridBagConstraints();
		this.setLayout(gridbag);


		//&&&&&&&&&&&&&&&  ADD LABEL "SELECT A THEME YOU WANT TO PLAY"


		btnFarm = new CustomButton(BUTTON_FARM_O_IMG, AUD_BUTTON_FARM, "Select Farm Theme", "FARM");
		btnAlphabets = new CustomButton(BUTTON_ALPHABETS_O_IMG, AUD_BUTTON_ALPHABETS, "Select Alphabets Theme", "ALPHABETS");	
		imgPageBck = new AppImage(PAGE_BKGND);

		//set position on grid and add buttons
		gridconstraints.gridheight = 20;
		gridconstraints.gridx = 1;
		gridconstraints.gridy = 20;
		gridconstraints.weightx = 0;
		gridconstraints.weighty = 0;
		gridbag.setConstraints(btnFarm, gridconstraints);
		this.add(btnFarm);

		gridconstraints.gridx = 2;
		gridconstraints.gridy = 20;
		gridbag.setConstraints(btnAlphabets, gridconstraints);
		this.add(btnAlphabets);
	}


	public CustomButton getBtnFarm(){
		return btnFarm;
	}

	public CustomButton getBtnAlphabets(){
		return btnAlphabets;
	}


	/**
	 * @param listenerFarmBtn Adds action listener to the Farm button 
	 */
	public void addBtnListener(ActionListener listenerBtn) {
		btnFarm.addActionListener(listenerBtn);
		btnAlphabets.addActionListener(listenerBtn);
	}

	public void addMyKeyListener(KeyAdapter adapter) {
		btnFarm.addKeyListener(adapter);
		btnAlphabets.addKeyListener(adapter);
	}


}
