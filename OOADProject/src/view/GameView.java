
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
import controller.EndExectuor;
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
	private int theme;
	private int level;
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
	 private JLabel scoreLabel;
	 private JLabel timeLabel;
	//end Mad
	 
	 private String MAZE_BG="image/";
	 public GameController control;
	 
	public GameView(Maze maze) {
		
		this.maze = maze;
		arrMaze = maze.getMazeLayout();
		player = new Player();
		theme=maze.getTheme();
		level=maze.getLevel();
		if(theme==1 && level==1)
			{
			player.setInitialPositon(0, 0);
			MAZE_BG="MazeFarm.png";
			}		
		else if(theme==1 && level==2)
			{
			player.setInitialPositon(0, 0);
			MAZE_BG="MazeFarm.png";
			}	
		else if(theme==2 && level==1)
			{
			player.setInitialPositon(9, 0);
			MAZE_BG="Bck_pond.png";
			}	
		else
			{
			player.setInitialPositon(9, 0);
			MAZE_BG="Bck_pond.png";
			}	
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
	
	public void setPnlDashBoard(int count){
		if(theme==1)
		{pnlDashboard.loadBonusImage("Egg"+Integer.toString(count)+".png");	
		pnlDashboard.reDraw();}
		else{
			pnlDashboard.loadBonusImage("Fish"+Integer.toString(count)+".png");
			pnlDashboard.reDraw();
		}
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
		pnlTitle.setOpaque(false);
		
		pnlMaze = new MazeDrawingPanel(player,maze,arrMaze, maze.getTheme());
		
		
		pnlMaze.setOpaque(false);
		pnlDashboard = new MazeBonus(maze.getTheme());	
		pnlDashboard.setOpaque(false);
		pnlScoreBoard = new JPanel();
		pnlScoreBoard.setOpaque(false);
		fileBackground = "Bck_Green_2_Sprayed Filter.png";
		fileTitleBck = "testTitle.png";
		//fileMazeBck = "testMaze.png";
		fileDashBck = "testDash.png";
		
		imgBackground = new AppImage(fileBackground);
		imgTitleBck = new AppImage(fileTitleBck);
		//imgMazeBck = new AppImage(fileMazeBck);
		imgDashBack = new AppImage(fileDashBck);
		scoreField = new JLabel();
		scoreLabel = new JLabel();
		scoreLabel.setText("SCORE");
		scoreLabel.setFont(new Font("Lucida Sans", Font.ITALIC, 25));
		scoreLabel.setForeground(Color.MAGENTA);
        scoreField.setText("0");
        scoreField.setFont(new Font("Lucida Sans", Font.ITALIC, 25));
        scoreField.setForeground(Color.MAGENTA);
        
		  
		 timeLabel = new JLabel("TIME");
		 timeLabel.setFont(new Font("Lucida Sans", Font.ITALIC, 25)); 
		 timeLabel.setText("Time");
		 
		 minField = new JLabel();
		 minField.setFont(new Font("Lucida Sans", Font.ITALIC, 25)); 
		 minField.setText("0");
		 minField.setText("0");
		 
		 secField = new JLabel();
		 secField.setFont(new Font("Lucida Sans", Font.ITALIC, 25)); 
		 secField.setText("0");
		 secField.setText("00");
		 
		 pnlScoreBoard.setBackground(Color.cyan);
        
		
		setPanelLayout();

	}
	
	
	public void setPanelLayout(){
		       
        javax.swing.GroupLayout pnlScoreBoardLayout = new javax.swing.GroupLayout(pnlScoreBoard);
        pnlScoreBoard.setLayout(pnlScoreBoardLayout);
        pnlScoreBoardLayout.setHorizontalGroup(
                pnlScoreBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlScoreBoardLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnlScoreBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlScoreBoardLayout.createSequentialGroup()
                            .addComponent(scoreLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scoreField)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(timeLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(minField)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(secField)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
            );
            pnlScoreBoardLayout.setVerticalGroup(
                pnlScoreBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlScoreBoardLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnlScoreBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(scoreLabel)
                        .addComponent(scoreField)
                        .addComponent(timeLabel)
                        .addComponent(minField)
                        .addComponent(secField))
                    .addGap(18, 18, 18)
                    .addComponent(pnlDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(565, Short.MAX_VALUE))
            );

        javax.swing.GroupLayout pnlTitleLayout = new javax.swing.GroupLayout(pnlTitle);
        pnlTitle.setLayout(pnlTitleLayout);
        pnlTitleLayout.setHorizontalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlTitleLayout.setVerticalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlMazeLayout = new javax.swing.GroupLayout(pnlMaze);
        pnlMaze.setLayout(pnlMazeLayout);
        pnlMazeLayout.setHorizontalGroup(
            pnlMazeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        pnlMazeLayout.setVerticalGroup(
            pnlMazeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMaze, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlScoreBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pnlTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMaze, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlScoreBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

       // pack();

		
		
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

	public void removeGlassPane(EndExectuor endExectuor){
		//pnlMaze.
		removeGlassPane1(endExectuor);

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
//		if(control.temp==1)
//			try{
//		Thread.sleep(5000);
//			}catch(Exception e){}

	}
	
	
	public void removeGlassPane1(EndExectuor endExectuor){
		if(mazeObject.isFound()){
			new Thread(new Runnable(){
				@Override
				public void run(){
					try{
						mazeObject.playAudio();
						//if(control.temp==1)
						//Thread.sleep(5000);
						p.setVisible(false);
						isTimerPaused = false;
						if(endExectuor != null){
							endExectuor.run();
						}

					}catch(Exception ex){}
					finally{p = null;}
				}
			}).start();
			
			}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Image backgroundImage;
		Image imgBackground = new AppImage(MAZE_BG).loadBackGroundImage();
		File filename = null;
//		try {
//			filename = new File(MAZE_BG);
//		      backgroundImage = ImageIO.read(filename);
		      g.drawImage( imgBackground, 0, 0,getWidth(),getHeight(), this);
//		    } catch (IOException e) {System.out.println("Error in reading the maze panel background image");}
		
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
