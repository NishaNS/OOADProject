
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import commonutil.AppImage;
import model.GameModel;
import model.ThemeModel;
import controller.GameController;
import controller.ThemeController;

/**
 * @author - Nisha
 * 
 * 	Defines the layout page for the main game view
 *
 */
public class GameView extends JPanel {

	private JPanel pnlTitle;
	private JPanel pnlMaze;
	private JPanel pnlDashboard;
	private AppImage imgBackground;
	private AppImage imgTitleBck;
	private AppImage imgMazeBck;
	private AppImage imgDashBack;
	private String fileBackground;
	private String fileTitleBck;
	private String fileMazeBck;
	private String fileDashBck;
	private GridBagLayout gridBagLayout;
	private GridBagConstraints gridconstraints;
	private int pnlWidth;
	private int pnlHeight;
	private JLabel lblTitle;


	public GameView() {



		pnlTitle = new JPanel();
		pnlMaze = new JPanel();
		pnlDashboard = new JPanel();		

		fileBackground = "Bck_Green_2_Sprayed Filter.png";
		fileTitleBck = "testTitle.png";
		fileMazeBck = "testMaze.png";
		fileDashBck = "testDash.png";

		imgBackground = new AppImage(fileBackground);
		imgTitleBck = new AppImage(fileTitleBck);
		imgMazeBck = new AppImage(fileMazeBck);
		imgDashBack = new AppImage(fileDashBck);

		gridBagLayout = new GridBagLayout();
		gridconstraints = new GridBagConstraints();
		this.setLayout(gridBagLayout);


		//title panel
		gridconstraints.fill =  GridBagConstraints.HORIZONTAL;
		gridconstraints.gridwidth = GridBagConstraints.RELATIVE;
		gridconstraints.anchor = GridBagConstraints.FIRST_LINE_START;	//starts alignment at top
		gridconstraints.ipady = 100;      //make this component tall ; hardcoded value is fine here as resize happens automatically
		gridconstraints.ipadx = 1;		
		gridconstraints.weightx = 1;
		gridconstraints.weighty = 1;	//keep x, y = 1, else centers panel
		gridconstraints.gridwidth = 3;	//makes it span whole window
		gridconstraints.insets = new Insets(3,3,3,3);
		pnlTitle.setBackground(Color.PINK);
		this.add(pnlTitle, gridconstraints);


		//maze panel
		gridconstraints.gridx = 1;
		gridconstraints.gridy = 1;
		gridconstraints.ipady = 600;
		gridconstraints.fill = GridBagConstraints.BOTH;
		gridconstraints.gridwidth = GridBagConstraints.RELATIVE;	//required 
		gridconstraints.anchor = GridBagConstraints.LINE_START;
		pnlMaze.setBackground(Color.CYAN);
		this.add(pnlMaze, gridconstraints);


		//dashboard panel
		gridconstraints.gridx = 2;
		gridconstraints.gridy = 1;
		gridconstraints.ipady = 600;
		gridconstraints.fill = GridBagConstraints.BOTH;
		gridconstraints.gridwidth = GridBagConstraints.RELATIVE;	//required 
		gridconstraints.anchor = GridBagConstraints.LINE_END;
		gridconstraints.weightx = 0.4;		//adjust the width
		pnlDashboard.setBackground(Color.YELLOW);		
		this.add(pnlDashboard, gridconstraints);
	}

	// override paint component
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);	
		g.drawImage(imgBackground.loadBackGroundImage(), 1, 0, getWidth(), getHeight() , null);
		pnlWidth = getPanelWidth();
		pnlHeight = getPanelHeight();			
	}

	public int getPanelWidth() {
		return getWidth();			
	}

	public int getPanelHeight() {
		return getHeight();			
	}

	// $$$$$$$$$$$$$$ delete this method later
	public static void main(String[] args){
		GameController gameController = new GameController();

		JFrame mainframe = new JFrame("GAME VIEW");
		Container mainpanel = mainframe.getContentPane();
		mainpanel.add(gameController.getView());		
		mainframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.pack();
		mainframe.setVisible(true);

	}

}
