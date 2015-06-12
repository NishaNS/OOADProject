 package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import model.Game;
import model.Student;
import commonutil.Audio;
import view.EndGameView;

public class EndGameController {

//	private int time;
//	private int score;
//	private int theme;
//	private int level;
	private int selectionPerformed;
	private int scanrate=1000;
	
	private EndGameView endGameView;
	private Audio auEnd;
	private Game game;
	private Student student;
	MainDisplayController mainController;
	
	//Audio filename for selected buttons
	private String EXIT_S_AU="EndGame_Exit.wav";
	private String CONTINUE_S_AU="EndGame_Continue.wav";
	private String SELECTION_AU="End_game_select_option.wav";
	private String CONTINUE_AU="End_game_Continue.wav";
	private String EXIT_AU="End_game_Exit.wav";
	
	//database
	private static boolean storeDBResult = true;
	
	EndGameController(Game g, MainDisplayController main){
		mainController=main;
		endGameView=new EndGameView(g);
		this.game=g;
		student=new Student();
		endGameView.addEndActionListener(new EndActionListener());
		endGameView.addEndKeyListener(new EndKeyListener());
		auEnd=new Audio(""); 
		
	}

	/**
	 * The methods to get and set selectionPerformed variable
	 * @return
	 */
	public int getSelectionPerformed(){
		return selectionPerformed;
	}
	
	public void setSelectionPerformed(int set){
		selectionPerformed=set;
	}
	
	public int getScanRate(){
		return scanrate;
	}
	
	public void setScanRate(int scanrate){
		this.scanrate=scanrate;
	}
	/**
	 * 
	 * @param s
	 */
	public void setStudent(Student s){
		student.setFirstName(s.getFirstName());
		student.setLastName(s.getLastName());
	}
	private class EndActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			auEnd.stopAudio();
			if(e.getSource().toString().contains("Continue")){
				System.out.println("Continue!");
				setSelectionPerformed(1);
				auEnd.setauFileName(CONTINUE_S_AU);
				auEnd.playAudio();
				endGameView.setVisible(false);
				endGameView.setFocusable(false);
				MainDisplayController mainC=new MainDisplayController();
				mainC.getView().setVisible(true);
				mainController.getView().setVisible(false);
				mainController.getView().dispose();
				mainController.close();
			

			}
			else if(e.getSource().toString().contains("Exit")){
				
				setSelectionPerformed(1);
				auEnd.setauFileName(EXIT_S_AU);
				auEnd.playAudio();
				
				//Store game result to Database
				
				String[] data_array = new String[8];
				data_array[0] = "default";				//autoincrement Primary key
				data_array[1] = student.getFirstName();
				data_array[2] = student.getLastName();
				
				if(game.getTheme() == 1)
					data_array[3] = "Farm";
				else if(game.getTheme() == 2)
					data_array[3] = "Alphabets";
				
				data_array[4] = Integer.toString(game.getLevel());
				data_array[5] = Integer.toString(game.getScore());
				data_array[6] = Integer.toString(game.getTime());
				data_array[7] = "NOW()";				//insert current time in DB
				
				if(storeDBResult == true) {
					mainController.getScoreController().addEndResult(data_array);
					storeDBResult = false;
				}
				mainController.getView().setVisible(false);
				mainController.getView().dispose();
				mainController.close();
			}
		}
	}
	
	public class EndKeyListener extends KeyAdapter{

		public void keyPressed(KeyEvent e){
			auEnd.stopAudio();
			if(e.getSource().toString().contains("Continue"))
			{
				System.out.println("Continue!");
				setSelectionPerformed(1);

				auEnd.setauFileName(CONTINUE_S_AU);
				auEnd.playAudio();
				endGameView.setVisible(false);
				endGameView.setFocusable(false);
				mainController.getView().setVisible(false);
				mainController.getView().dispose();
				
				MainDisplayController mainC=new MainDisplayController();
				mainC.getView().setVisible(true);
				
			}
			if(e.getSource().toString().contains("Exit"))
			{
				setSelectionPerformed(1);
				auEnd.setauFileName(EXIT_S_AU);
				auEnd.playAudio();
				
				//Store game result to Database
				String[] data_array = new String[8];
				data_array[0] = "default";				//autoincrement Primary key
				data_array[1] = student.getFirstName();
				data_array[2] = student.getLastName();
				
				if(game.getTheme() == 1)
					data_array[3] = "Farm";
				else if(game.getTheme() == 2)
					data_array[3] = "Alphabets";
				
				data_array[4] = Integer.toString(game.getLevel());
				data_array[5] = Integer.toString(game.getScore());
				data_array[6] = Integer.toString(game.getTime());
				data_array[7] = "NOW()";				//insert current time in DB
				
				if(storeDBResult == true) {
					mainController.getScoreController().addEndResult(data_array);
					storeDBResult = false;
				}
				mainController.getView().setVisible(false);
				mainController.getView().dispose();
				mainController.close();
			}
		}
	}
	public EndGameView getView(){
//		try{
//		Thread.sleep(2000);}catch(Exception e){}
		endGameView.settings();
		return endGameView;
	}
	
	/**
	 * The audio methods
	 */
	public void loadAudio(){
//		try{
//			Thread.sleep(3000);}catch(Exception e){}
		new Thread(new Runnable() {			
			@Override
			public void run() {		
					loadStarAudio();
					try{
					Thread.sleep(scanrate);}catch(Exception e){}
					playSelectAudio();//pause for page load + before looping
					} 
				}).start();
	}

	public void loadStarAudio(){
		if(game.getTime() < 180){
			 	auEnd.setauFileName("Three_star.wav");
			 	auEnd.playAudio();
			}
			else if(game.getTime() >= 180 && game.getTime() <= 360){
				auEnd.setauFileName("Two_stars.wav");
				auEnd.playAudio();
			}
			else{
				auEnd.setauFileName("One_stars.wav");
				auEnd.playAudio();
			}
	}
	
	public void playSelectAudio(){
		//levelView.setTrackVariable(1);
		try {
			while(true){
			Thread.sleep(getScanRate());
			//levelView.setTrackVariable(1);
			if(getSelectionPerformed()!=1){
				auEnd=new Audio(SELECTION_AU);
				auEnd.playAudio();
				//levelView.setTrackVariable(1);

			}else{
				break;
			}
			if(getSelectionPerformed()!=1){
				endGameView.getCButton().requestFocus();
				endGameView.cButtonSet();
				auEnd.setauFileName(CONTINUE_AU);
				auEnd.playAudio();
				endGameView.cButtonReset();
				Thread.sleep(100);
			}
			else{
				break;	
			}	

			if(getSelectionPerformed()!=1){
				System.out.println(getSelectionPerformed());
				endGameView.getEButton().requestFocus();
				auEnd.setauFileName(EXIT_AU);
				auEnd.playAudio();
				continue;
			}{
				break;
			}
		}
		}catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		
}
	
	

}
