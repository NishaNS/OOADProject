package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class scoreBoardDrawingPanel extends JPanel{
	private JLabel lblScore;
	private JLabel scoreField;
	private JLabel lblTime;
	private JLabel lblColon;;
	private JLabel minField;
	private JLabel secField;
	private JPanel pnlScore;
	private JPanel pnlTimerMain;
	private JPanel pnlTimer;

	public scoreBoardDrawingPanel(){
		pnlScore = new JPanel();
		pnlScore.setLayout(new BoxLayout(pnlScore, BoxLayout.Y_AXIS));
		
		pnlTimerMain = new JPanel();
		pnlTimerMain.setLayout(new BoxLayout(pnlTimerMain, BoxLayout.Y_AXIS));
		pnlTimer = new JPanel(new FlowLayout());
		lblScore = new JLabel("Score");
		
		scoreField = new JLabel("SCORE",JLabel.RIGHT);;
		scoreField = new JLabel("",JLabel.RIGHT);
		scoreField.setText("0");

		lblTime = new JLabel("TIME",JLabel.RIGHT);
		
		minField = new JLabel("",JLabel.RIGHT);
		minField.setText("00");
		lblColon = new JLabel(":",JLabel.RIGHT);
		secField = new JLabel("",JLabel.RIGHT);
		secField.setText("00");

		lblScore.setFont(new Font("Comic Sans", Font.BOLD, 30));
		scoreField.setFont(new Font("Comic Sans", Font.BOLD, 25));
		lblScore.setForeground(Color.BLACK);
		scoreField.setForeground(Color.magenta);
		lblTime.setFont(new Font("Comic Sans", Font.BOLD, 30));
		minField.setFont(new Font("Comic Sans", Font.BOLD, 25));
		secField.setFont(new Font("Comic Sans", Font.BOLD, 25));
		lblColon.setFont(new Font("Comic Sans", Font.BOLD, 25));
		
		lblTime.setForeground(Color.BLACK);
		minField.setForeground(Color.magenta);
		secField.setForeground(Color.magenta);
		
		pnlScore.setOpaque(false);
		pnlTimerMain.setOpaque(false);
		pnlTimer.setOpaque(false);
		pnlScore.add(lblScore);
		pnlScore.add(scoreField);
		pnlTimerMain.add(lblTime);
		pnlTimer.add(minField);
		pnlTimer.add(lblColon);
		pnlTimer.add(secField);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(pnlScore);
		add(pnlTimerMain);
		add(pnlTimer);
		setVisible(true);
		setOpaque(false);
		setMaximumSize(new Dimension(100,100));
		
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



}
