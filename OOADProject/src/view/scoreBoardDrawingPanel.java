package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class scoreBoardDrawingPanel extends JPanel{
	private JLabel lblScore;
	private JTextField txtScore;
	
	
	public scoreBoardDrawingPanel(){
		lblScore = new JLabel("Score");
		JLabel scoreLabel = new JLabel("SCORE", JLabel.RIGHT);
		 JTextField scoreField = new JTextField(3);
		 
		 scoreField.setEditable(false);
		 scoreField.setText("0");
		   
		 JLabel timeLabel = new JLabel("TIME", JLabel.LEFT);
		 JTextField mins = new JTextField(3);
		 mins.setEditable(false);
		 mins.setText("0");
		 JTextField secs = new JTextField(3);
		 secs.setEditable(false);
		 secs.setText("0");
		 
		 scoreLabel.setFont(new Font("Lucida Sans", Font.ITALIC, 25));
		 scoreField.setFont(new Font("Lucida Sans", Font.ITALIC, 25));
		 scoreLabel.setForeground(Color.magenta);
		 scoreField.setForeground(Color.magenta);
		 timeLabel.setFont(new Font("Lucida Sans", Font.ITALIC, 25));
		 mins.setFont(new Font("Lucida Sans", Font.ITALIC, 25));
		 secs.setFont(new Font("Lucida Sans", Font.ITALIC, 25));
		
	}
	
	
	
	

}
