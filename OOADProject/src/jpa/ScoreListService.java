package jpa;


import java.sql.Time;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ScoreListService {

	private EntityManager manager;


	public ScoreListService(EntityManager manager) {
		this.manager = manager;
	}

	// method to create a new record
	public StudentScoreDetails createCourse(String GameID, String First_Name, String Last_Name, 
			String Game_Theme, String Game_Level, int Game_Score,
			String Game_Time, String Created_Time) {

		StudentScoreDetails details = new StudentScoreDetails();

		details.setFirstName(First_Name);
		details.setLastName(Last_Name);
		details.setGameTheme(Game_Theme);
		details.setGameLevel(Game_Level);
		details.setGameScore(Game_Score);
		details.setGameTime(Game_Time);

		manager.persist(details);
		System.out.println("list service - add mthd!!");
		return details;
		
		
	}   

	// method to read a record
	public StudentScoreDetails readScore(String GameID){
		StudentScoreDetails details = manager.find(StudentScoreDetails.class, GameID);
		return details;
	}

	// method to read all records
	public List<StudentScoreDetails> readAll() {
		TypedQuery<StudentScoreDetails> query = manager.createQuery("SELECT e FROM StudentScoreDetails e", StudentScoreDetails.class);
		List<StudentScoreDetails> result =  query.getResultList();
		return result;   	 
	}

	// method to update a record
	public StudentScoreDetails updateScore(int GameID, String First_Name, String Last_Name, 
			String Game_Theme, String Game_Level, int Game_Score,
			String Game_Time) {
		
		StudentScoreDetails details = manager.find(StudentScoreDetails.class, GameID);
		
		if (details != null) {

			details.setGameID(GameID);
			details.setFirstName(First_Name);
			details.setLastName(Last_Name);
			details.setGameTheme(Game_Theme);
			details.setGameLevel(Game_Level);
			details.setGameScore(Game_Score);
			details.setGameTime(Game_Time);

			System.out.println("list service - update method!");
		}
		
		return details;
	}

	// method to delete a record
	public void deleteScore(String GameID) {
		StudentScoreDetails details = manager.find(StudentScoreDetails.class, Integer.parseInt(GameID));
		if (details != null) {
			manager.remove(details);
			System.out.println("list service - delete method!");
		}
	}
}
