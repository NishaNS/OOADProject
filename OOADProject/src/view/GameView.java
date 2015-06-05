
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
	private JPanel pnlScoreBoard;
	private MazeBonus pnlDashboard;

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
	
	private boolean isTimerPaused;
	
	//score components
	 private JLabel scoreField;
	 private JLabel minField;
	 private JLabel secField;
	//end Mad

	public GameView(Maze maze) {
		this.maze = maze;
		arrMaze = maze.getMazeLayout();
		player = new Player();
		setName("Game");
		initializeComponents();
	}

	public void setIsTimerPaused(boolean isPaused){
		isTimerPaused = isPaused;
	}
	
	public boolean getIsTimerPaused(){
		return this.isTimerPaused;
	}
	
	public void setMazeObject(MazeElements mObject){
		this.mazeObject = mObject;
	}
	
	public void setScore(int score){
		scoreField.setText(score+"");
	}
	
	public void setTime(int mins, int secs){
		minField.setText(mins+"");
		if(secs<10)
			secField.setText("0"+secs+"");
		else
			secField.setText(secs+"");
	}
	
	private void initializeComponents(){
		pnlTitle = new JPanel();
		pnlMaze = new MazeDrawingPanel(player,maze,arrMaze, maze.getTheme());
		
		pnlDashboard = new MazeBonus(maze.getTheme());	
		pnlScoreBoard = new JPanel();
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
		//setOpaque(true);

		//Madhu begin
		//title Panel
		gridconstraints.fill = GridBagConstraints.HORIZONTAL;
		gridconstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		gridconstraints.weightx = 1;
		gridconstraints.ipady = 100;
		gridconstraints.gridx = 0;       
		gridconstraints.gridy = 0;
		gridconstraints.gridwidth = 3;
		gridconstraints.gridheight = 1;
		//pnlTitle.setBackground(Color.PINK);
		pnlTitle.setOpaque(false);
		this.add(pnlTitle, gridconstraints);
		
		//game Panel
		gridconstraints.fill = GridBagConstraints.BOTH;
		gridconstraints.anchor = GridBagConstraints.LINE_START;
		gridconstraints.weightx = 0.8;
		gridconstraints.weighty = 0.9;
		gridconstraints.gridx = 0;
		gridconstraints.gridy = 1;
		gridconstraints.gridwidth = 2;
		gridconstraints.gridheight = 2;
		pnlMaze.setOpaque(false);
		this.add(pnlMaze, gridconstraints);
		
		//scoreBoard
		gridconstraints.fill = GridBagConstraints.BOTH;
		gridconstraints.anchor = GridBagConstraints.LINE_END;
		gridconstraints.weightx = 0.2;
		gridconstraints.weighty = 0.45;
		gridconstraints.gridx = 2;
		gridconstraints.gridy = 1;
		gridconstraints.gridwidth = 1;
		gridconstraints.gridheight = 1;
		//pnlScoreBoard.setBackground(Color.RED);	
		pnlScoreBoard.setOpaque(false);
		
		//add labels for score and time
		 JLabel scoreLabel = new JLabel("SCORE");
		 scoreField = new JLabel();
		 scoreField.setText("0");
		   
		 JLabel timeLabel = new JLabel("TIME");
		 minField = new JLabel();
		 minField.setText("0");
		 secField = new JLabel();
		 secField.setText("0");
		 
		 scoreLabel.setFont(new Font("Lucida Sans", Font.ITALIC, 25));
		 scoreField.setFont(new Font("Lucida Sans", Font.ITALIC, 25));
		 scoreLabel.setForeground(Color.magenta);
		 scoreField.setForeground(Color.magenta);
		 timeLabel.setFont(new Font("Lucida Sans", Font.ITALIC, 25));
		 minField.setFont(new Font("Lucida Sans", Font.ITALIC, 25));
		 secField.setFont(new Font("Lucida Sans", Font.ITALIC, 25));
		 pnlScoreBoard.add(scoreLabel);
		 pnlScoreBoard.add(scoreField);
		 pnlScoreBoard.add(timeLabel);
		 pnlScoreBoard.add(minField);
		 pnlScoreBoard.add(secField);
		 
		   
		
		this.add(pnlScoreBoard, gridconstraints);
		
		//dashboard
		gridconstraints.fill = GridBagConstraints.BOTH;
		gridconstraints.anchor = GridBagConstraints.LAST_LINE_END;
		gridconstraints.weightx = 0.2;
		gridconstraints.weighty = 0.45;
		gridconstraints.gridx = 2;
		gridconstraints.gridy = 2;
		gridconstraints.gridwidth = 1;
		gridconstraints.gridheight = 1;
		//pnlDashboard.setBackground(Color.YELLOW);
		pnlDashboard.setOpaque(false);
		this.add(pnlDashboard, gridconstraints);
		
		
//		 Toolkit tkit = Toolkit.getDefaultToolkit();
//		   int windowWidth = tkit.getScreenSize().width; 
//		   int windowHeight = tkit.getScreenSize().height;
//			 
//		   setSize(windowWidth, windowHeight);
		
		//Madhu end
		

//		//title panel
//		gridconstraints.fill =  GridBagConstraints.HORIZONTAL;
//		gridconstraints.gridwidth = GridBagConstraints.RELATIVE;
//		gridconstraints.anchor = GridBagConstraints.FIRST_LINE_START;	//starts alignment at top
//		gridconstraints.ipady = 100;      //make this component tall ; hardcoded value is fine here as resize happens automatically
//		gridconstraints.ipadx = 1;		
//		gridconstraints.weightx = 1;
//		gridconstraints.weighty = 1;	//keep x, y = 1, else centers panel
//		gridconstraints.gridwidth = 3;	//makes it span whole window
//		gridconstraints.insets = new Insets(3,3,3,3);
//		pnlTitle.setBackground(Color.PINK);
//		this.add(pnlTitle, gridconstraints);


//		//maze panel
//		gridconstraints.gridx = 1;
//		gridconstraints.gridy = 1;
//		gridconstraints.ipady = 600;
//		gridconstraints.fill = GridBagConstraints.BOTH;
//		gridconstraints.gridwidth = GridBagConstraints.RELATIVE;	//required 
//		gridconstraints.anchor = GridBagConstraints.LINE_START;
//		//pnlMaze.setBackground(Color.CYAN);
//		this.add(pnlMaze, gridconstraints);


//		//dashboard panel
//		gridconstraints.gridx = 3;
//		gridconstraints.gridy = 1;
//		
//		gridconstraints.ipady = 300;
//		gridconstraints.fill = GridBagConstraints.BOTH;
//		gridconstraints.gridwidth = GridBagConstraints.RELATIVE;	//required 
//		gridconstraints.gridheight = GridBagConstraints.RELATIVE;
//		gridconstraints.anchor = GridBagConstraints.LINE_END;
//		gridconstraints.weightx = 0.4;		//adjust the width
//		gridconstraints.weighty = 0.45;	
//		pnlScoreBoard.setBackground(Color.RED);		
//		this.add(pnlScoreBoard, gridconstraints);
//		
//		//dashboard panel
//		gridconstraints.gridx = 3 ;
//		gridconstraints.gridy = 2;
//		gridconstraints.ipady = 300;
//		gridconstraints.fill = GridBagConstraints.VERTICAL;
//		gridconstraints.gridwidth = GridBagConstraints.RELATIVE;	//required 
//		gridconstraints.gridheight = GridBagConstraints.RELATIVE;
//		gridconstraints.anchor = GridBagConstraints.LAST_LINE_END;
//		gridconstraints.weightx = 0.4;		//adjust the width
//		gridconstraints.weighty = 0.45;	
//		pnlDashboard.setBackground(Color.YELLOW);		
//		this.add(pnlDashboard, gridconstraints);
//		
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
		this.isTimerPaused = true;
		System.out.println("Timer Paused:" + isTimerPaused);
		createGlassPane();
	}

	public void removeGlassPane(){
		//pnlMaze.
		removeGlassPane1();

		System.out.println("Timer Paused:" + false);
		
	}
	
	public void createGlassPane(){
		p=new MazeElementPane();
		p.setOpaque(false); 
		p.setSize(new Dimension(400,400));
		//p.setBackground(Color.blue);
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
						isTimerPaused = false;

					}catch(Exception ex){}
					finally{p = null;}
				}
			}).start();
			
			}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Image backgroundImage;
		Image imgBackground = new AppImage("farm2.jpg").loadBackGroundImage();
		File filename = null;
		try {
			filename = new File("image/farm2.jpg");
		      backgroundImage = ImageIO.read(filename);
		      g.drawImage(imgBackground, 0, 0, this);
		    } catch (IOException e) {System.out.println("Error in reading the maze panel background image");}
		
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
