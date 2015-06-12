/**
 * The class is responsible for the GUI of the home screen, which extends the JPanel. and holds the
 * various javax.swing components together.
 */
package view;

import commonutil.AppImage;
import commonutil.Audio;
import commonutil.GUIComponent;
import commonutil.PanelWithAudio;

import javax.swing.*;
import javax.swing.event.MenuListener;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Madhu
 *
 */
public class HomeView extends JPanel {
	private AppImage backgroundImage;
	private List<PanelWithAudio> audioPanels = new ArrayList<PanelWithAudio>();
	private JButton btnContinue;
	private JButton btnTeacherLgn;
	private JTextField txtStudentFirstName;
	private JTextField txtStudentLastName;
	private JLabel lblOptional;
	private JMenuBar menuBar;
	private JMenu options;
	private JMenuItem help;
	private JMenuItem credits;
	private GridBagLayout gridbaglayout;
	private GridBagConstraints gridconstraints;

	public HomeView() {
		//        AppImage img = new AppImage("TestingWelcomePage.png");
		//        backgroundImage = img.loadBackGroundImage();

		gridbaglayout = new GridBagLayout();
		gridconstraints = new GridBagConstraints();
		this.setLayout(gridbaglayout);

		PanelWithAudio  pnlTeacher = new PanelWithAudio(new Audio(""));
		btnTeacherLgn = GUIComponent.createButton("BtnTeacherLogin.png", "");
		btnTeacherLgn.setBorder(BorderFactory.createEmptyBorder());
		btnTeacherLgn.setOpaque(false);
		btnTeacherLgn.setContentAreaFilled(false);
		pnlTeacher.add(btnTeacherLgn);
		pnlTeacher.setOpaque(false);
		//pnlTeacher.setBackground(Color.ORANGE);
				
		
		gridconstraints.fill = GridBagConstraints.HORIZONTAL;
		gridconstraints.weightx = 0.5;
		gridconstraints.weighty = 1;
		gridconstraints.gridx = 2;
		gridconstraints.gridy = 0;
		gridconstraints.anchor = GridBagConstraints.SOUTH;
		gridconstraints.insets = new Insets(0, 30, 5, 10);
		gridbaglayout.setConstraints(pnlTeacher, gridconstraints);
		audioPanels.add(pnlTeacher);

		backgroundImage=new AppImage("bckWelcomePage.png");
		PanelWithAudio pnlContinue = new PanelWithAudio(new Audio("pg1_continue.wav"));
		btnContinue = GUIComponent.createButton("BtnContinue.png", "");
		btnContinue.setBorder(BorderFactory.createEmptyBorder());
		btnContinue.setOpaque(false);
		btnContinue.setContentAreaFilled(false);
		pnlContinue.add(btnContinue);
		pnlContinue.setOpaque(false);
		//pnlContinue.setBackground(Color.ORANGE);
		
		gridconstraints.fill = GridBagConstraints.HORIZONTAL;
		gridconstraints.weightx = 0.5;
		gridconstraints.weighty = 1;
		gridconstraints.gridx = 3;
		gridconstraints.gridy = 0;
		gridconstraints.anchor = GridBagConstraints.SOUTH;
		gridconstraints.insets = new Insets(0, 10, 5, 10);
		gridbaglayout.setConstraints(pnlContinue, gridconstraints);		
		audioPanels.add(pnlContinue);

		Font font=new Font(Font.SANS_SERIF,Font.ITALIC,20);

		txtStudentFirstName = new JTextField("Enter First name(optional)");
		//lblOptional = new JLabel("(optional)");
		txtStudentFirstName.setFont(font);
		// btnContinue.setFocusable(true);

		txtStudentLastName = new JTextField("Enter Last name(optional)");
		//lblOptional = new JLabel("(optional)");
		btnContinue.setFocusable(true);
		txtStudentLastName.setFont(font);


		menuBar=new JMenuBar();
		options=new JMenu("Options");
		help=new JMenuItem("Help");
		credits=new JMenuItem("Credits");



		addComponents();
	}

	public void addContinueKeyListener(KeyListener kListener) {
		btnContinue.addKeyListener(kListener);
	}

	//    public void addContinueMouseListener(MouseListener mListener) {
	//        btnContinue.addMouseListener(mListener);
	//    }

	public void addContinueActionListener(ActionListener listener) {
		btnContinue.addActionListener(listener);
	}

	public void addTeacherLoginListener(ActionListener listener) {
		btnTeacherLgn.addActionListener(listener);
	}

	public void addTextField1Listener(FocusListener f){
		txtStudentFirstName.addFocusListener(f);
	}
	public void addTextField2Listener(FocusListener f){
		txtStudentLastName.addFocusListener(f);
	}

	public void addMenuListListener(MenuListener m){
		options.addMenuListener(m);
	}

	public void addMenuActionListener(ActionListener a){
		help.addActionListener(a);
		credits.addActionListener(a);
	}
	private void addComponents() {

		//c.anchor=GridBagConstraints.LINE_START;

		//constraints.gridwidth;

		
		gridconstraints.fill = GridBagConstraints.HORIZONTAL;
		gridconstraints.weightx = 0.5;
		gridconstraints.weighty = 1;
		gridconstraints.gridx = 0;
		gridconstraints.gridy = 0;
		gridconstraints.insets = new Insets(0, 20, 10, 10);
		gridconstraints.anchor = GridBagConstraints.SOUTH;
		gridbaglayout.setConstraints(txtStudentFirstName, gridconstraints);
		add(txtStudentFirstName);
		
		gridconstraints.fill = GridBagConstraints.HORIZONTAL;
		gridconstraints.weightx = 0.5;
		gridconstraints.weighty = 1;
		gridconstraints.gridx = 1;
		gridconstraints.gridy = 0;
		gridconstraints.insets = new Insets(0, 10, 10, 10);
		gridconstraints.anchor = GridBagConstraints.SOUTH;
		gridbaglayout.setConstraints(txtStudentLastName, gridconstraints);
		add(txtStudentLastName); 
		
		options.add(help);
		options.add(credits);
		menuBar.add(options);
		//add(menuBar,constraints);


		//Insets in=new Insets(0,0,0,20);
		for(PanelWithAudio panel : audioPanels){
			add(panel); 

		}



	}

	public JMenuItem getHelp(){
		return help;
	}

	public JMenuItem getCredits(){
		return credits;
	}

	public JMenuBar getMenu(){
		return menuBar;
	}
	public List<PanelWithAudio> getAudioPanels() {
		return audioPanels;
	}
	public JTextField getFirstNameTextField(){
		return txtStudentFirstName;
	}

	public JTextField getLastNameTextField(){
		return txtStudentLastName;
	}

	public JButton getContinueButton(){
		return btnContinue;
	}

	public JButton getTeacherLgnButton(){
		return btnTeacherLgn;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(backgroundImage.loadBackGroundImage(), 0, 0, getWidth(), getHeight(), this);
	}


}
