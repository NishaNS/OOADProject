package jpa;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

@Entity(name = "StudentScoreDetails")

public class StudentScoreDetails implements Serializable {

	//Indicates that the persistence provider must assign primary keys for the entity
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	 	//AUTO, TABLE
	@Column
	private int GameID;

	@Column
	private String First_Name;

	@Column
	private String Last_Name;

	@Column
	private String Game_Theme;

	@Column
	private String Game_Level;

	@Column
	private int Game_Score;

	@Column
	private String Game_Time;

	@Column
	private Timestamp Created_Time;


	public int getGameID(){
		return GameID;
	}

	public String getFirstName(){
		return First_Name;
	}

	public String getLastName(){
		return Last_Name;
	}

	public String getGameTheme(){
		return Game_Theme;
	}

	public String getGameLevel(){
		return Game_Level;
	}

	public int getGameScore(){
		return Game_Score;
	}

	public String getGameTime(){
		return Game_Time.toString();
	}

	public Timestamp getCreatedTime(){
		return Created_Time;
	}

	public int getNumberOfColumns() {
		return 8;
	}
	
	public void setGameID(int gameID) {
		this.GameID = gameID;
	}
	
	public void setFirstName(String firstname) {
		this.First_Name = firstname;
	}
	
	public void setLastName(String lastname) {
		this.Last_Name = lastname;
	}
	
	public void setGameTheme(String theme) {
		this.Game_Theme = theme;
	}
	
	public void setGameLevel(String level) {
		this.Game_Level = level;
	}
	
	public void setGameScore(int score) {
		this.Game_Score = score;
	}

	public void setGameTime(String time) {
		this.Game_Time = time;
	}
	
	public String getColumnData(int i) throws Exception {
		if (i == 0)
			return Integer.toString(getGameID());
		else if (i == 1)
			return getFirstName();
		else if (i == 2) 
			return getLastName();
		else if (i == 3) 
			return getGameTheme();
		else if (i == 4) 
			return getGameLevel();
		else if (i == 5) 
			return Integer.toString(getGameScore());
		else if (i == 6) 
			return getGameTime().toString();
		else if (i == 7) 
			return getCreatedTime().toString();
		else
			throw new Exception("Error: invalid column index in scorelist table"); 
	}

	public String getColumnName(int i) throws Exception {

		String colName = null;

		if (i == 0)
			colName = "Game_ID";
		else if (i == 1)
			colName = "First_Name";		
		else if (i == 2)
			colName = "Last_Name";
		else if (i == 3) 
			colName = "Game_Theme";
		else if (i == 4)
			colName = "Game_Level";
		else if (i == 5)
			colName = "Game_Score";
		else if (i == 6)
			colName = "Game_Time";
		else if (i == 7)			
			colName = "Created_Time";		
		else
			throw new Exception("Error: invalid column index in scorelist table"); 

		return colName;
	}

	public void setColumnData(int i, Object value) throws Exception {
		if (i == 0) 
			GameID = Integer.parseInt((String) value);
		else if (i == 1) 
			First_Name = (String) value;
		else if (i == 2) 
			Last_Name = (String) value;
		else if (i == 3) 
			Game_Theme = (String) value;
		else if (i == 4) 
			Game_Level = (String) value;
		else if (i == 5)
			Game_Score = Integer.parseInt((String) value);
		else if (i == 6)
			Game_Time = (String) value;
		
		else if (i == 7) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");

		    Date parsedTimeStamp = dateFormat.parse((String) value);

		    Created_Time = new Timestamp(parsedTimeStamp.getTime());
			
		}
		
		else
			throw new Exception("Error: invalid column index in scorelist table");    		
	}

	@Override
	public String toString() {
		return "ScoreList [GameID =" + GameID + ", "
				+ "First Name =" + First_Name + ", "
				+ "Last Name =" + Last_Name + ", "
				+ "Game Theme =" + Game_Theme + ", "
				+ "Game Level =" + Game_Level + ", "
				+ "Game Score =" + Game_Score + ", "
				+ "Game Time =" + Game_Time + ", "
				+ "Created Time =" + Created_Time + ", "
				+ "]";
	}

	
}


