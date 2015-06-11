package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Game;
import commonutil.AppImage;
import commonutil.Audio;
import commonutil.CustomButton;
import controller.GameController;
import controller.MainDisplayController;


public class EndGameView extends JPanel {

	private JPanel footer;
	private JPanel body;
	private JLabel star;
	private JLabel theme_level;
	private JLabel congrats;
	private JLabel time_l;
	private JLabel score_l;
	private JPanel time_p;
	private JPanel score_p;
	private JButton cButton;
	private JButton eButton;
	
	
	
//	private int TIME;
//	private int SCORE;
//	private int THEME;
//	private int LEVEL;
//	private int selectionPerformed;
	private int scanrate=1000;
	
	private Audio auEnd;
	private Game game;
//	private MainDisplayController mainController;
	Toolkit toolkit =  Toolkit.getDefaultToolkit ();
	private Dimension d=toolkit.getScreenSize();
	
	private String FOOTER_IMG;
	private String BODY_IMG="image/cloud_burst.png";

	private String CONTINUE_O_IMG="image/Continue.png";
	private String CONTINUE_S_IMG="image/";
	private String CONTINUE_IMG=CONTINUE_O_IMG;
	private String EXIT_O_IMG="image/Exit.png";
	private String EXIT_S_IMG;
	private String EXIT_IMG=EXIT_O_IMG;
	private String STAR_IMG="";
	

//	private String SELECTION_AU="End_game_select_option.wav";
//	
//	private String CONTINUE_AU="End_game_Continue.wav";
	
	
	
	

	public EndGameView(Game game){
		this.game=game;
		System.out.println(game.getTime());
		star=new JLabel();
		congrats=new JLabel();
		theme_level=new JLabel();
		time_l=new JLabel();
		score_l=new JLabel();
		FOOTER_IMG="image/endGameTitle.png";
		BODY_IMG="image/cloud_burst.png";
		
		setButtons();
		setPanel();
		settings();
		
		//this.setFocusable(true);
		
	}
	
	/**
	 * The method to set buttons image 
	 */
	public void setButtons(){
		cButton=new JButton("Continue"){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				cButton.setIcon(new ImageIcon(CONTINUE_IMG));
				cButton.setBorder(BorderFactory.createEmptyBorder());
				validate();
				cButton.setPreferredSize(new Dimension((int)(0.18*d.getWidth()),(int)(0.12*d.getHeight())));
			}
		};
		
		eButton=new JButton("Exit"){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				eButton.setIcon(new ImageIcon(EXIT_IMG));
				
				eButton.setBorder(BorderFactory.createEmptyBorder());
				validate();
				eButton.setPreferredSize(new Dimension((int)(0.18*d.getWidth()),(int)(0.12*d.getHeight())));
			}
		};
	}
	
	public JButton getCButton(){
		return cButton;
	}
	
	public JButton getEButton(){
		return eButton;
	}
	/**
	 * The method to add listeners to the buttons
	 * @return void
	 */
	
	public void addEndKeyListener(KeyAdapter k){
		cButton.addKeyListener(k);
		eButton.addKeyListener(k);
	}
	
	/**
	 * 
	 * @param a
	 */
	public void addEndActionListener(ActionListener a){
		cButton.addActionListener(a);
		eButton.addActionListener(a);
	}
	
	/**
	 * Method to set Panel images
	 */
	public void setPanel(){
		footer=new JPanel(){
//			public void paintComponent(Graphics g){
//				super.paintComponent(g);
//				//g.setColor(Color.CYAN);
//				g.fillRect(0, 0, (int)d.getWidth(), (int)(0.2*d.getHeight()));
//				
//				//g.drawImage(new ImageIcon(FOOTER_IMG).getImage(), 0, 0, 1200,100,null);
//				
//			}
		};	
		
		footer.setOpaque(false);
		body=new JPanel(){
//			public void paintComponent(Graphics g){
//				super.paintComponent(g);
//				g.drawImage(new ImageIcon(BODY_IMG).getImage(), 0, 0,(int)(d.getWidth()),(int)(0.8*d.getHeight()),null);
//				
//			}
				
		};
		
		body.setOpaque(false);
		time_p=new JPanel(){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(new ImageIcon().getImage(), 0, 0,null);
				
			}	
		};
		score_p=new JPanel();
	}
	
	/**
	 * The method to select the star image
	 */
	public void loadStarImage(){
		
		if(game.getTime() < 100){
		 //star.setIcon(new ImageIcon("image/Three_star.png"));
		STAR_IMG="image/Three_star.png";
		}
		else if(game.getTime() >= 100 && game.getTime()<=360){
		//star.setIcon(new ImageIcon("image/Two_star.png"));
			STAR_IMG="image/Two_star.png";
		}
		else if(game.getTime()>360){
		System.out.println("one star");
		//star.setIcon(new ImageIcon("image/One_star.png"));
		STAR_IMG="image/One_star.png";
		System.out.println("one star");
		}
		
	}
	
	public void cButtonSet(){
		CONTINUE_IMG=CONTINUE_S_IMG;
		cButton.repaint();
	}
	
	public void cButtonReset(){
		CONTINUE_IMG=CONTINUE_O_IMG;
		cButton.repaint();

	}
	
	public void eButtonSet(){
		EXIT_IMG=EXIT_S_IMG;
		eButton.repaint();
	}
	
	public void eButtonReset()
	{
		EXIT_IMG=EXIT_O_IMG;
		eButton.repaint();
	}
	/**
	 * The method to set gridbag constaraints the body of the page
	 */
	public void bodyConstraints(){
		GridBagLayout gridBag=new GridBagLayout();
		body.setLayout(gridBag);
		Font font=new Font("",Font.ITALIC,35);
		
		GridBagConstraints constraints=new GridBagConstraints();
		
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.gridwidth=2;
		constraints.weightx=1;
		constraints.weighty=0.1;

		theme_level.setForeground(Color.BLUE);
		theme_level.setText(game.getTheme()+" - "+game.getLevel());
		theme_level.setFont(font);
		body.add(theme_level,constraints);
		
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.gridwidth=2;
		constraints.weightx=1;
		constraints.weighty=0.2;
		congrats.setText("Congratulations!!!");
		congrats.setFont(font);
		congrats.setForeground(Color.BLUE);
		body.add(congrats, constraints);
		
		constraints.gridx=0;
		constraints.gridy=2;
		constraints.weightx=1;
		constraints.weighty=0.4;
		loadStarImage();
		star.setIcon(new ImageIcon(STAR_IMG));
		body.add(star, constraints);
		
		constraints.gridx=0;
		constraints.gridy=3;
		constraints.gridwidth=1;
		constraints.gridheight=1;
		constraints.weightx=0.5;
		constraints.weighty=0.2;
		constraints.fill=GridBagConstraints.BOTH;
		time_l.setText("Time is " + game.getTime());
		time_p.setBackground(Color.getHSBColor(20, 20, 20));
		time_p.setOpaque(false);
		time_p.setPreferredSize(new Dimension(150,50));
		font=new Font("",Font.ITALIC,40);
		time_l.setFont(font);
		time_l.setForeground(Color.RED);
		time_p.add(time_l);
		time_p.setVisible(true);
		body.add(time_p, constraints);
		
		
		constraints.gridx=1;
		constraints.gridy=3;
		constraints.gridwidth=1;
		constraints.gridheight=1;
		constraints.weightx=0.5;
		constraints.weighty=0.2;
		constraints.fill=GridBagConstraints.BOTH;
		score_l.setText("Score is "+game.getScore());
		score_p.setBackground(Color.getHSBColor(20, 20, 20));
		score_p.setPreferredSize(new Dimension(150,50));
		font=new Font("",Font.ITALIC,40);
		score_l.setFont(font);
		score_p.setOpaque(false);
		score_p.setBorder(BorderFactory.createBevelBorder(10));
		score_l.setForeground(Color.RED);
		score_p.add(score_l);
		body.add(score_p, constraints);
		

	}
	
	/**
	 * The method to set gridbag constarints on the exit and repeat buttons
	 */
	public void footerConstraints(){
		GridBagLayout gridBag=new GridBagLayout();
		footer.setLayout(gridBag);
		GridBagConstraints constraints=new GridBagConstraints();
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.weighty=1;
		constraints.weightx=0.5;
		constraints.anchor=GridBagConstraints.BELOW_BASELINE;
		footer.add(cButton, constraints);
		
		constraints.gridx=1;
		constraints.gridy=0;
		constraints.weighty=1;
		constraints.weightx=0.5;
		constraints.anchor=GridBagConstraints.BELOW_BASELINE;
		footer.add(eButton, constraints);
		
	}
	
	/**
	 * The method for overall gridbad settings
	 */
	public void settings(){
		
		GridBagLayout gridBag=new GridBagLayout();
		this.setLayout(gridBag);
		GridBagConstraints constraints=new GridBagConstraints();
		
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.weighty=0.85;
		constraints.weightx=1;
		bodyConstraints();
		constraints.anchor=GridBagConstraints.FIRST_LINE_START;
		constraints.fill=GridBagConstraints.BOTH;
		//body.setBackground(Color.CYAN);
		this.add(body,constraints);
		
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.weighty=0.15;
		constraints.weightx=1;
		footerConstraints();
		constraints.anchor=GridBagConstraints.FIRST_LINE_START;
		//footer.setBackground(Color.RED);
		this.add(footer,constraints);
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(new ImageIcon(BODY_IMG).getImage(), 0, 0, this);
	}
	

	
	
}
