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
	public ThemeController tController;
	
	public static String BUTTON_EASY_O_IMG = "Level1.png";
	public static String BUTTON_HARD_O_IMG = "Level3.png";
	public static String BUTTON_EASY_AUD = "Level_easy_select_option.wav";
	public static String BUTTON_HARD_AUD = "Level_difficult_select_option.wav";
	public static String BUTTON_EASY_S_IMG = "testMaze.png";
	public static String BUTTON_HARD_S_IMG = "testMaze.png";
	public static String PAGE_LOAD_AUD = "Level_select.wav";
	
	
	/**
	 * LevelView constructor 
	 */
	public LevelView(){
		//if(tController.getTheme()==1)
		{
			imgEasySelected=new String("");
			//path of the farm level2 selected image
			imgHardSelected=new String("");
			btnEasy=new CustomButton(BUTTON_EASY_O_IMG,BUTTON_EASY_AUD,"Easy","Level1");
			btnHard=new CustomButton(BUTTON_HARD_O_IMG,BUTTON_HARD_AUD,"Hard","Level2");
			setFocusable(true);
		}
		/*else{
		imgEasy=new String("OOADProject/image/Level1.png");
	imgHard=new String("/Users/hemali/git/FinalProject/OOADProject/image/Level3.png");
	imgEasySelected=new String("");
	imgHardSelected=new String("");
	btnEasy=new CustomButton(imgEasy);
	btnHard=new CustomButton(imgHard);
	}*/
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



//	public static void main(String[] args) {
//		 MainDisplayController mainController=new MainDisplayController();
//		LevelController levelcontroller = new LevelController(mainController);
//		JFrame window = new JFrame("Level");
//		window.add(levelcontroller.getView());
//		levelcontroller.loadAudio();
//		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.setVisible(true);
//	}
}
