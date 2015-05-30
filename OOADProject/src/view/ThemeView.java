
package view;

import commonutil.AppImage;
import commonutil.Audio;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.ThemeController;
import model.ThemeModel;

/**
 * @author Nisha
 * The ThemeView lets user select the theme of the maze game from options provided.
 */
public class ThemeView extends JPanel {

	private static boolean btnSelected;		//variable for audio loop condition

	private GridBagLayout gridbag;
	private GridBagConstraints gridconstraints;
	private AppImage imgBackground;
	private AppImage imgButton1;
	private AppImage imgButton2;
	private String fileBackground;
	private String fileButton1;
	private String fileButton2;
	private String fileButton3;
	private String fileButton4;
	private JButton btnFarm;
	private JButton btnAlphabets;
	private Audio auObj;
	private String fileAu1, fileAu2, fileAu3;

	/**
	 * The constructor setups the elements and layout for the Theme page
	 */
	public ThemeView() {

		// set panel layout
		gridbag = new GridBagLayout();
		gridconstraints = new GridBagConstraints();
		this.setLayout(gridbag);

		btnSelected = false;

		//file names for all images
		fileBackground = "Bck_Green_2_Sprayed Filter.png";		
		fileButton1 = "Btn_Farm_Updated.png";
		fileButton2 = "Btn_Farm_Updated_Clicked.png";
		fileButton3 = "Btn_Alphabets_Updated.png";		
		fileButton4 = "Btn_Farm_Updated_Clicked.png";
		fileAu1 = "Theme_1.wav";
		fileAu2 = "Theme_2.wav";
		fileAu3 = "Theme_3.wav";
		
		
		//&&&&&&&&&&&&&&&  ADD LABEL "SELECT A THEME YOU WANT TO PLAY"
		

		//set background images
		imgBackground = new AppImage(fileBackground);
		imgButton1 = new AppImage(fileButton1);
		imgButton2 = new AppImage(fileButton3);
		
		//add button for Theme 1 - Farm
		btnFarm = new JButton();
		btnFarm.setName("FARM");
		btnFarm.setToolTipText("Select Farm Theme");
		btnFarm.setOpaque(false);
		btnFarm.setContentAreaFilled(false);
		btnFarm.setBorderPainted(false);		
		
		//add button for Theme 2 - Alphabets
		btnAlphabets = new JButton();
		btnAlphabets.setName("ALPHABETS");
		btnAlphabets.setToolTipText("Select Alphabets Theme");
		btnAlphabets.setOpaque(false);
		btnAlphabets.setContentAreaFilled(false);
		btnAlphabets.setBorderPainted(false);
		
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

	public void loadAudio(){
		//setup and play audio
		new Thread(new Runnable() {			
			@Override
			public void run() {		

				try {
							//pause for page load + before looping
				 while(!btnSelected) {		//loop condition
					Thread.sleep(1000);	
					auObj = new Audio(fileAu1);					
					auObj.playAudio();

					auObj = new Audio(fileAu2);
					setBtnImage2(fileButton3);
					setBtnImage1(fileButton2);					
					repaint();
					btnFarm.requestFocus();
					auObj.playAudio();
					Thread.sleep(1000);	
					
					auObj = new Audio(fileAu3);
					setBtnImage1(fileButton1);
					setBtnImage2(fileButton4);
					repaint();
					btnAlphabets.requestFocus();
					auObj.playAudio();
				}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
				
		}).start();	
	}
	public void setBtnImage1(String filename) {
		imgButton1 = new AppImage(filename);		
	}

	public void setBtnImage2(String filename) {
		imgButton2 = new AppImage(filename);
	}

	public static boolean isBtnSelected() {
		return btnSelected;
	}

	public static void setBtnSelected(boolean btnSelected) {			
		btnSelected = true;		
	}

	/**
	 * @param listenerFarmBtn Adds action listener to the Farm button 
	 */
	public void addFarmBtnListener(ActionListener listenerFarmBtn) {
		btnFarm.addActionListener(listenerFarmBtn);
	}

	/**
	 * @param listenerAlphaBtn Adds action listener to the Farm button
	 */
	public void addAlphaBtnListener(ActionListener listenerAlphaBtn) {
		btnAlphabets.addActionListener(listenerAlphaBtn);
	}

	// override paint component
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imgBackground.loadBackGroundImage(), 1, 0, getWidth() - 10, getHeight() , null);
		btnFarm.setIcon(new ImageIcon(imgButton1.loadImage()));
		btnAlphabets.setIcon(new ImageIcon(imgButton2.loadImage()));
	}

	// $$$$$$$$$$$$$$ delete this method later
//	public static void main(String[] args) {
//		//ThemeController themecontroller = new ThemeController();
//
//		JFrame mainframe = new JFrame("THEME");
//		Container mainpanel = mainframe.getContentPane();
//		mainpanel.add(themecontroller.getView());		
//		mainframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		mainframe.setVisible(true);		
//	}
}
