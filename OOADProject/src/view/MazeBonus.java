package view;

import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MazeBonus extends JPanel {
	private static final String IMG_BONUS_T1 = "egg1.png"; 
	private static final String IMG_BONUS_T2 = "choc1.png"; 
	private static final String IMG_PATH = "image/";
	private ImageIcon iconLogo;
	private int theme;
	
	public MazeBonus(int theme){
		this.theme = theme;
		if(theme == 1)
			iconLogo = new ImageIcon(IMG_PATH+IMG_BONUS_T1);
		else if (theme == 2)
			iconLogo = new ImageIcon(IMG_PATH+IMG_BONUS_T2);
		//setLayout(new FlowLayout());
//		for(int i = 0 ;i<3; i++){
//			JLabel lblBonus = new JLabel(iconLogo);
//			this.add(lblBonus);
//			lblBonus.setVisible(true);
//		}
		 
	}
	
//	public void paintComponent(Graphics g){
//		super.paintComponent(g);
//		g.drawImage(new ImageIcon("image/hen_egg.jpg").getImage(), 0, 0, this);
//	}
}
