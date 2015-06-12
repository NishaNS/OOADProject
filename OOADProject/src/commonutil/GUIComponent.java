/**
 * 
 */
package commonutil;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author 
 *
 */
public class GUIComponent {
	private GUIComponent() {
	}

	private static final String FILE_PATH = "image/";
	
	public static JButton createButton(String imageFileName,String btnText){
		JButton btn;
		if(imageFileName.isEmpty() && !btnText.isEmpty())
		{
			btn = new JButton(btnText);
			btn.setOpaque(false);
			btn.setContentAreaFilled(false);
			//btn.setBackground(Color.BLACK);
		}
		else
			btn = new JButton(new ImageIcon(FILE_PATH.concat(imageFileName)));
		//btn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		return btn;
	}

}
