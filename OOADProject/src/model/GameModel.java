/**
 * 
 */
package model;

import commonutil.MazeElementPane;

/**
 * @author 
 *
 */
public class GameModel {
	private int theme;
	private int level;
	private MazeElementPane myGlassPane;
	
	
	public void setTheme(int theme){
		this.theme = theme;
	}
	
	public void setLevel(int level){
		this.level = level;
	}
	
	public MazeElementPane getGlassPane(){
		return this.myGlassPane;
	}
	
	
}
