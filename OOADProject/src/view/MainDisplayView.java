/**
 * 
 */
package view;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.*;
/**
 * @author 
 *
 */
public class MainDisplayView extends JFrame {

	private JPanel pnlContainer;
	private static CardLayout layoutCard;
	private int width;
	private int height;
	
	public MainDisplayView(){
		if(pnlContainer==null)
			pnlContainer = new JPanel();
		if(layoutCard==null){
			layoutCard = new CardLayout();
			pnlContainer.setLayout(layoutCard);
		setWindowProperties();
		}
	}
	
	public void addPanels(JPanel pnlChild){
		pnlContainer.add(pnlChild);
		pnlChild.setVisible(true);
		layoutCard.show(pnlContainer, "");
		setContentPane(pnlContainer);
		setVisible(true);
		
	}
	private void setWindowProperties(){
		Toolkit tkit = Toolkit.getDefaultToolkit();
		this.width = tkit.getScreenSize().width; 
		this.height = tkit.getScreenSize().height;
		setSize(this.width, this.height);
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public int getWindowHeight(){
		return this.height;
	}
	
	public int getWindowWidth(){
		return this.width;
	}
	
	
	
}
