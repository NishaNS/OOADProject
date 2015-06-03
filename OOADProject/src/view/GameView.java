
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import commonutil.AppImage;
import commonutil.MazeElementPane;
import model.Animal;
import model.GameModel;
import model.Maze;
import model.MazeElement;
import model.MazeElements;
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
public class GameView extends JPanel{

	private JPanel pnlTitle;
	private MazeDrawingPanel pnlMaze;
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
	private Maze maze;
	private Player player;
	private static int PIXEL_COUNT = 100;
	
	
	//Mad
	private MazeElements mazeObject;
	private MazeElementPane p;
	//end Mad

	public GameView(Maze maze) {
		this.maze = maze;
		arrMaze = maze.getMazeLayout();
		player = new Player();
		setName("Game");
		initializeComponents();
	}

	public void setMazeObject(MazeElements mObject){
		this.mazeObject = mObject;
	}
	
	private void initializeComponents(){
		pnlTitle = new JPanel();
		pnlMaze = new MazeDrawingPanel(player,maze,arrMaze, maze.getTheme());
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

	public void addMazePanelListener(KeyAdapter kAdapter){
		pnlMaze.setFocusable(true);
		pnlMaze.requestFocusInWindow();
		pnlMaze.addKeyListener(kAdapter);
	}

	public void redrawMazePanel(){		
		pnlMaze.repaint();
	}

	public void makeGlassPane(){
		//pnlMaze.
		createGlassPane();
	}

	public void removeGlassPane(){
		//pnlMaze.
		removeGlassPane1();
	}
	

	public void createGlassPane(){
		p=new MazeElementPane();
		p.setOpaque(true); 
		p.setBackground(Color.blue);
		p.add(new JLabel(new ImageIcon("image/"+ mazeObject.getName()+ ".png"))); 
		pnlMaze.getRootPane().setGlassPane(p);   

		p.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me)      
			{   
				me.consume();                            
				Toolkit.getDefaultToolkit().beep();      
			}                                            
		});   

		p.addKeyListener(new KeyAdapter() {
			public void keyPressed (KeyEvent me)      
			{   
				me.consume();                            
				Toolkit.getDefaultToolkit().beep();      
			}                                            
		});
		p.repaint();
		p.setVisible(true); 
		p.setFocusable(true);
		p.requestFocus();
	}
	
	
	public void removeGlassPane1(){
		if(mazeObject.isFound()){
			new Thread(new Runnable(){
				@Override
				public void run(){
					try{
						mazeObject.playAudio();
						//Thread.sleep(3000);
						p.setVisible(false);
						
					}catch(Exception ex){}
				}
			}).start();
			
			}
	}
//	
//	public class MazePanel extends JPanel {
//		private Timer timer;
//		GridBagConstraints gc=new GridBagConstraints();
//		MazeElementPane p;
//
//		public void paintComponent(Graphics g){
//			super.paintComponent(g);
//			g.drawImage(new ImageIcon("image/farm.png").getImage(), 0, 0, this);
//			for(int x=0; x<arrMaze[0].length;x++){
//				for(int y=0; y<arrMaze.length;y++){
//					if(arrMaze[y][x] == 1){
//						g.drawImage(maze.getBlock(), x*PIXEL_COUNT, y*PIXEL_COUNT, this);
//					}
//				}
//			}
//			g.drawImage(player.getPlayer(), player.getTileX()*PIXEL_COUNT, player.getTileY()*PIXEL_COUNT, this);
//		}


//		public void createGlassPane(){
//			p=new MazeElementPane();
//			p.setOpaque(true); 
//			p.setBackground(Color.blue);
//			p.add(new JLabel(new ImageIcon("image/"+ mazeObject.getName()+ ".png"))); 
//			getRootPane().setGlassPane(p);   
//
//			p.addMouseListener(new MouseAdapter() {
//				public void mousePressed(MouseEvent me)      
//				{   
//					me.consume();                            
//					Toolkit.getDefaultToolkit().beep();      
//				}                                            
//			});   
//
//			p.addKeyListener(new KeyAdapter() {
//				public void keyPressed (KeyEvent me)      
//				{   
//					me.consume();                            
//					Toolkit.getDefaultToolkit().beep();      
//				}                                            
//			});
//			p.repaint();
//			p.setVisible(true); 
//			p.setFocusable(true);
//			p.requestFocus();
//		}
//		
//		public void removeGlassPane(){
//			if(mazeObject.isFound()){
//				new Thread(new Runnable(){
//					@Override
//					public void run(){
//						try{
//							mazeObject.playAudio();
//							//Thread.sleep(3000);
//							p.setVisible(false);
//							
//						}catch(Exception ex){}
//					}
//				}).start();
//				
//				}
//		}
//	};
}
