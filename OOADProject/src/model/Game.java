package model;

public class Game {

private int theme;
private int level;
private int score;
private int game_time;

/**
 * 
 * @param theme
 */
public void setTheme(int theme){
	this.theme=theme;
}

/**
 * 
 * @return int 
 */
public int getTheme(){
	return theme;
}
/**
 * 
 * @param level
 */
public void setLevel(int level){
	this.level=level;
}
/**
 * 
 * @return int
 */
public int getLevel(){
	return level;
}
/**
 * 
 * @return int
 */
public int getTime(){
	return game_time;
}
/**
 * 
 * @param time
 */
public void setTime(int time){
	this.game_time=time;
}

/**
 * 
 * @return int
 */
public int getScore(){
	return score;
}

/**
 * 
 * @param score
 */
public void setScore(int score){
	this.score=score;
}


}
