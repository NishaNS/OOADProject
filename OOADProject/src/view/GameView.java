
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import commonutil.AppImage;
import model.GameModel;
import model.Maze;
import model.Player;
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
	private MazePanel pnlMaze;
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
	
	private int[][] arrMaze;
	private Image grass, brick, borderV, borderH; 
	private Maze maze;
	private Player player;
	private static int PIXEL_COUNT = 100;
	
	
	public GameView(Maze maze) {
		//super();
		this.maze = maze;
		arrMaze = maze.getMazeLayout();
		initializeComponents();
		player = new Player();
		setName("Game");
		
	}

	private void initializeComponents(){
		pnlTitle = new JPanel();
		pnlMaze = new MazePanel();
		pnlDashboard = new JPanel();	
		fileBackground = "Bck_Green_2_Sprayed Filter.png";
		fileTitleBck = "testTitle.png";
		//fileMazeBck = "testMaze.png";
		fileDashBck = "testDash.png";

		imgBackground = new AppImage(fileBackground);
		imgTitleBck = new AppImage(fileTitleBck);
		//imgMazeBck = new AppImage(fileMazeBck);
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
		//pnlMaze.setBackground(Color.CYAN);
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
	
	public void getMazeLayout(int[][] arrMaze){
		this.arrMaze = arrMaze;
	}
	
	public Player getPlayer(){
		return this.player;
	}
	
	//@Override
	/*protected void paintComponent(Graphics g) {
		super.paintComponent(g);	
		g.drawImage(imgBackground.loadBackGroundImage(), 1, 0, getWidth(), getHeight() , null);
		pnlWidth = getPanelWidth();
		pnlHeight = getPanelHeight();	
		pnlMaze.repaint();
	}*/

	/*public int getPanelWidth() {
		return getWidth();			
	}

	public int getPanelHeight() {
		return getHeight();			
	}*/

	
	public void addMazePanelListener(KeyAdapter kAdapter){
		pnlMaze.setFocusable(true);
		pnlMaze.requestFocusInWindow();
		pnlMaze.addKeyListener(kAdapter);
	}
	
	public void redrawMazePanel(){		
		pnlMaze.repaint();
	}
	
	//inner class to load the maze objects
	private class MazePanel extends JPanel {
		private Timer timer;
		GridBagConstraints gc=new GridBagConstraints();

		/*MazePanel(){
			
			setFocusable(true);
			requestFocusInWindow();
			
			
			//timer = new Timer(25,this);
			
			GridBagLayout gl=new GridBagLayout(); 
			this.setLayout(gl);
			gc=new GridBagConstraints();
			gc.gridx=0;
			gc.gridy=0;
			//timer.start();
		}*/
		
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			for(int x=0; x<arrMaze[0].length;x++)
			{
				for(int y=0; y<arrMaze.length;y++){
					if(arrMaze[y][x] == 0)
						{
						g.drawImage(maze.getGrass(), x*PIXEL_COUNT, y*PIXEL_COUNT, null);
						//gc.gridx++;
						}
					if(arrMaze[y][x] == 1)
						{
						g.drawImage(maze.getBrick(), x*PIXEL_COUNT, y*PIXEL_COUNT, null);
						//gc.gridx++;
						}
					
				}
				//gc.gridy++;
			}
			
			g.drawImage(player.getPlayer(), player.getTileX()*PIXEL_COUNT, player.getTileY()*PIXEL_COUNT, null);
			
		}

		/*@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			repaint();
			
		}*/

//		@Override
//		public void actionPerformed(ActionEvent e) {
//			repaint();
//		}
	};
	
	
	// $$$$$$$$$$$$$$ delete this method later
//	public static void main(String[] args){
//		//GameView view= new GameView(new Maze(1,2));
//		GameController gameController = new GameController();
//		JFrame mainframe = new JFrame("GAME VIEW");
//		Container mainpanel = mainframe.getContentPane();
//		mainpanel.add(gameController.getView());		
//		mainframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		mainframe.pack();
//		mainframe.setVisible(true);
//
//	}

}
