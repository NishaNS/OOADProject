
package model;

/**
 * @author Nisha
 * The ThemeModel stores the theme number selected
 *
 */

public class ThemeModel {
	
	private int themeSelected;
	private String nextPanel;
	
	public ThemeModel() {				
		themeSelected = 0;				
	}
	
	public int getTheme(){	
		return themeSelected;
	}		
	
	public void setTheme(int theme){
		themeSelected = theme;
	}

	public void setView(String nextPanel) {
		this.nextPanel = nextPanel;
	}
	
	public String getView() {
		return this.nextPanel;
	}
}
