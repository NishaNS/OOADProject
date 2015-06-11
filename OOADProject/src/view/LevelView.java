/**
 * 
 */
package view;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyAdapter;

import javax.swing.*;

import controller.LevelController;
import controller.MainDisplayController;
import controller.ThemeController;
import commonutil.Audio;
import commonutil.CustomButton;
/**
 * @author hemali
 *
 */
public class LevelView extends JPanel{

	private CustomButton btnEasy;
	private CustomButton btnHard;
	private JLabel lblDisplay1;
	private JLabel lblDisplay2;

	private String imgEasy;
	private String imgEasySelected;

	private String imgHard;
	private String imgHardSelected;


	private int trackVariable;
	public Audio auLevel;
	public LevelController levelController;
	private int theme;
	
	public static String BUTTON_EASY_O_IMG_T1 = "LvlBtnFarm1.png";
	public static String BUTTON_HARD_O_IMG_T1 = "LvlBtnFarm2.png";	
	public static String BUTTON_EASY_S_IMG_T1 = "LvlBtnFarmClicked_1.png";
	public static String BUTTON_HARD_S_IMG_T1 = "LvlBtnFarmClicked_1.png";
	
	public static String PAGE_LOAD_AUD = "";
	public static String PAGE_LOAD_AUD_T1 = "Level_select.wav";
	public static String PAGE_LOAD_AUD_T2 = "Level_select.wav";
	
	public static String BUTTON_EASY_AUD = "";
	public static String BUTTON_HARD_AUD = "";
	public static String BUTTON_EASY_AUD_T1 = "Level_easy_select_option.wav";
	public static String BUTTON_HARD_AUD_T1 = "Level_difficult_select_option.wav";
	public static String BUTTON_EASY_AUD_T2 = "Level_easy_select_option.wav";
	public static String BUTTON_HARD_AUD_T2 = "Level_difficult_select_option.wav";
	
	public static String BUTTON_EASY_O_IMG_T2 = "BtnLvlAlpha1.png";
	public static String BUTTON_HARD_O_IMG_T2 = "BtnLvlAlpha2.png";
	public static String BUTTON_EASY_S_IMG_T2 = "BtnLvlAlphaClicked_1.png";
	public static String BUTTON_HARD_S_IMG_T2 = "BtnLvlAlphaClicked_2.png";
	
	public static String BUTTON_EASY_O_IMG = "";
	public static String BUTTON_HARD_O_IMG = "";
	public static String BUTTON_EASY_S_IMG = "";
	public static String BUTTON_HARD_S_IMG = "";
	
	public static String T1_L1_AUD="";
	public static String T1_L2_AUD="";
	public static String T2_L1_AUD="";
	public static String T2_L2_AUD="";
	
	public static String LEVEL_EASY_AUD_S="Level_easy_selected.wav";
	public static String LEVEL_HARD_AUD_S="Level_difficult_selected.wav";
	
	
	
	
	/**
	 * LevelView constructor 
	 */
	public LevelView(int theme){
		System.out.println("Theme "+theme);
		if(theme == 1)
		{
			BUTTON_EASY_O_IMG=BUTTON_EASY_O_IMG_T1;
			BUTTON_HARD_O_IMG=BUTTON_HARD_O_IMG_T1;
			BUTTON_HARD_S_IMG=BUTTON_HARD_S_IMG_T1;
			BUTTON_EASY_S_IMG=BUTTON_EASY_S_IMG_T1;
			
			BUTTON_EASY_AUD=BUTTON_EASY_AUD_T1;
			BUTTON_HARD_AUD=BUTTON_HARD_AUD_T1;
			PAGE_LOAD_AUD=PAGE_LOAD_AUD_T1;
			btnEasy=new CustomButton(BUTTON_EASY_O_IMG,BUTTON_EASY_AUD,"Easy","Level1");
			btnHard=new CustomButton(BUTTON_HARD_O_IMG,BUTTON_HARD_AUD,"Hard","Level2");
			setFocusable(true);
		}
		else{
			BUTTON_EASY_O_IMG=BUTTON_EASY_O_IMG_T2;
			BUTTON_HARD_O_IMG=BUTTON_HARD_O_IMG_T2;
			BUTTON_EASY_AUD=BUTTON_EASY_AUD_T2;
			BUTTON_HARD_AUD=BUTTON_HARD_AUD_T2;
			PAGE_LOAD_AUD=PAGE_LOAD_AUD_T2;
			BUTTON_HARD_S_IMG=BUTTON_HARD_S_IMG_T2;
			BUTTON_EASY_S_IMG=BUTTON_EASY_S_IMG_T2;
			btnEasy=new CustomButton(BUTTON_EASY_O_IMG,BUTTON_EASY_AUD,"Easy","Level1");
			btnHard=new CustomButton(BUTTON_HARD_O_IMG,BUTTON_HARD_AUD,"Hard","Level2");
			setFocusable(true);
	}
		lblDisplay1=new JLabel("Select the level");
		lblDisplay2=new JLabel("(Default level is easy)");

		GridBagLayout gridBag=new GridBagLayout();
		this.setLayout(gridBag);
		Font font=new Font("",Font.ITALIC,35);

		GridBagConstraints constraint=new GridBagConstraints();
		constraint.gridx=0;
		constraint.gridy=0;

		lblDisplay1.setFont(font);
		this.add(lblDisplay1,constraint);
		constraint.gridy++;
		lblDisplay2.setFont(font);
		this.add(lblDisplay2,constraint);

		constraint.gridy++;	

		this.add(btnEasy,constraint);
		constraint.gridx++;

		this.setName("LevelView");
		this.add(btnHard,constraint);
		this.setSize(200, 200);
		this.setBackground(Color.ORANGE);

	}
	
	public void setTheme(int th){
		theme=th;
	}
	
	public int getTheme(){
		return theme;
	}
	
	public CustomButton getBtnLevel1()
	{
		return this.btnEasy;
	}


	public CustomButton getBtnLevel2()
	{
		return this.btnHard;
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
	
	public void addMyKeyListener(KeyAdapter k){
		btnEasy.addKeyListener(k);
		btnHard.addKeyListener(k);
	}
	
	/**
	 * 
	 * @param a
	 */
	public void addMyActionListener(ActionListener a){
		btnEasy.addActionListener(a);
		btnHard.addActionListener(a);
	}

	/**
	 * The method which plays the initial audio
	 * @return void
	 */

}
