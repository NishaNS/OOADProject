package view;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MazeBonus extends JPanel {
	private static final String IMG_BONUS_T1 = "egg1.png"; 
	private static final String IMG_BONUS_T2 = "choc1.png"; 
	private static final String IMG_PATH = "image/";
	private ImageIcon iconLogo;
	private int theme;
	private JLabel lblBonus;
	
	public MazeBonus(int theme){
		this.theme = theme;
		lblBonus = new JLabel();
//		if(theme == 1)
//			iconLogo = new ImageIcon(IMG_PATH+IMG_BONUS_T1);
//		else if (theme == 2)
//			iconLogo = new ImageIcon(IMG_PATH+IMG_BONUS_T2);
		//setLayout(new FlowLayout());
//		for(int i = 0 ;i<3; i++){
//			JLabel lblBonus = new JLabel(iconLogo);
//			this.add(lblBonus);
//			lblBonus.setVisible(true);
//		}
		 
	}
	
	public void loadBonusImage(String fileName){
		iconLogo = new ImageIcon(IMG_PATH+fileName);
		//lblBonus.repaint();
		//lblBonus.setIcon(iconLogo);
		//lblBonus.setVisible(true);
		//System.out.println("Bonus:" + fileName);
	}
	
	public void reDraw(){
		lblBonus.setIcon(iconLogo);
		lblBonus.setVisible(true);
		repaint();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;	
		//reDraw(g2);
		if(iconLogo!=null)
			g.drawImage(iconLogo.getImage(), 0, 0,getWidth(),getHeight(), null);
	}
}
