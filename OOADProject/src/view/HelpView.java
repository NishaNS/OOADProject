/**
 * 
 */
package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import javax.swing.*;

import commonutil.Audio;
import controller.HelpController;
/**
 * @author hemali
 *
 */
public class HelpView extends JPanel{
	
	private JButton back;
	private JTextArea info;
	private String BACK_BTN_IMG="image/Exit.png";
	private String BACKGROUND_IMG="image/HelpCreditsBG.png";
	
	private String information="Please press the right arrow key to move right\n"
							  +"Please press the left arrow key to move to the left\n"
							  +"Please press the up arrow key to move up\n"
							  +"Please press the down arrow key to move down\n";
	
	public HelpView(){
	GridBagLayout grid=new GridBagLayout();
	setLayout(grid);
	GridBagConstraints c=new GridBagConstraints();
	c.gridx=0;
	c.gridy=0;
	back=new JButton(){
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			back.setIcon(new ImageIcon(BACK_BTN_IMG));
			 back.setBorder(BorderFactory.createEmptyBorder());
		}
	};
	info=new JTextArea(information);
	Font font=new Font(Font.SANS_SERIF,Font.ITALIC,30);
	info.setBackground( new Color(0, 0, 0, 1) );
	info.setEditable(false);
	info.setOpaque(true);
	info.setFont(font);
	info.setBounds(20,20,200,200);
	add(info,c);
	c.gridy++;
	add(back,c);
	}
	
	public void addButtonListener(ActionListener a){
		back.addActionListener( a);
	}
	
	public JButton getBack(){
		return back;
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(new ImageIcon(BACKGROUND_IMG).getImage(), 0, 0,this);
	}
}
