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
import java.io.File;

import javax.swing.*;

import controller.LevelController;
import controller.MainDisplayController;
import controller.ThemeController;
import commonutil.AppImage;
import commonutil.Audio;
import commonutil.CustomButton;
/**
 * @author hemali
 *
 */
public class LevelView extends JPanel{

	private CustomButton btnEasy;
	private CustomButton btnHard;
	//private JLabel lblDisplay1;
	//private JLabel lblDisplay2;

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
	public static String BUTTON_HARD_S_IMG_T1 = "LvlBtnFarmClicked_2.png";
	
	public static String PAGE_LOAD_AUD = "";
	public static String PAGE_LOAD_AUD_T1 = "pg3_t1_lvl_onload.wav";
	public static String PAGE_LOAD_AUD_T2 = "pg3_t2_lvl_onload.wav";
	
	public static String BUTTON_EASY_AUD = "";
	public static String BUTTON_HARD_AUD = "";
	public static String BUTTON_EASY_AUD_T1 = "pg3_t1_lvl1_selection.wav";
	public static String BUTTON_HARD_AUD_T1 = "pg3_t1_lvl2_selection.wav";
	public static String BUTTON_EASY_AUD_T2 = "pg3_t2_lvl1_selection.wav";
	public static String BUTTON_HARD_AUD_T2 = "pg3_t2_lvl2_selection.wav";
	
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
	
	public static String THEME_LEVEL_S="";
	public static String LEVEL_T1_AUD_S="pg3_t1_lvl_selected.wav";
	public static String LEVEL_T2_AUD_S="pg3_t2_lvl_selected.wav";
	private AppImage imgPageBck;
	private static String PAGE_BKGND = "bckOptions_Level.png";
	
	
	
	/**
	 * LevelView constructor 
	 */
	public LevelView(int theme){
		imgPageBck = new AppImage(PAGE_BKGND);
		
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
			
			THEME_LEVEL_S=LEVEL_T1_AUD_S;
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
			
			THEME_LEVEL_S=LEVEL_T2_AUD_S;
			BUTTON_HARD_S_IMG=BUTTON_HARD_S_IMG_T2;
			BUTTON_EASY_S_IMG=BUTTON_EASY_S_IMG_T2;
			btnEasy=new CustomButton(BUTTON_EASY_O_IMG,BUTTON_EASY_AUD,"Easy","Level1");
			btnHard=new CustomButton(BUTTON_HARD_O_IMG,BUTTON_HARD_AUD,"Hard","Level2");
			setFocusable(true);
	}
	

		GridBagLayout gridBag=new GridBagLayout();
		this.setLayout(gridBag);
		Font font=new Font("",Font.ITALIC,35);

		GridBagConstraints constraint=new GridBagConstraints();
		constraint.gridx=0;
		constraint.gridy=0;
		constraint.gridy++;
		constraint.gridy++;	
		this.add(btnEasy,constraint);
		constraint.gridx++;
		this.setName("LevelView");
		this.add(btnHard,constraint);
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

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Image backgroundImage;
		Image imgBackground = new AppImage(PAGE_BKGND).loadBackGroundImage();
		File filename = null;
		g.drawImage( imgBackground, 0, 0,getWidth(),getHeight(), this);
	}
}
