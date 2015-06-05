/**
 * 
 */
package view;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
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
		setWindowProperties();
		if(pnlContainer==null)
			pnlContainer = new JPanel();
		if(layoutCard==null){
			layoutCard = new CardLayout();
			pnlContainer.setLayout(layoutCard);
		
		}
	}
	
	public void addPanels(JPanel pnlChild){
		
		/*//with card layout
		if(pnlChild.getName() == null){
			pnlContainer.add(pnlChild);
			layoutCard.show(pnlContainer, "");
			this.add(pnlContainer);
			//setContentPane(pnlContainer);
			pnlChild.setVisible(true);
			pnlChild.requestFocusInWindow();
			
		}
		else{
			pnlContainer.add(pnlChild);
			pnlChild.setVisible(true);
			layoutCard.show(pnlContainer, "");
			this.add(pnlContainer);
			
		}
		setVisible(true);*/
		
		//works without card layout
		Container c = getContentPane();
		if(pnlChild.getName() == null){
			//pnlChild.requestFocusInWindow();
			System.out.println("Inside panel");
			c.add(pnlChild);
			pnlChild.setVisible(true);
			pnlChild.requestFocusInWindow();
		}
		else
		{
			c.add(pnlChild);
			pnlChild.setVisible(true);
		}
		
		setVisible(true);
		
		
	}
	public void setWindowProperties(){
		
		Toolkit tkit = Toolkit.getDefaultToolkit();
		this.width = tkit.getScreenSize().width; 
		this.height = tkit.getScreenSize().height;
		setSize(this.width, this.height);
		setUndecorated(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public int getWindowHeight(){
		return this.height;
	}
	
	public int getWindowWidth(){
		return this.width;
	}
	
	
	
}
