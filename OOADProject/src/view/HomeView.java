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
    private Image backgroundImage;
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

    public HomeView() {
//        AppImage img = new AppImage("TestingWelcomePage.png");
//        backgroundImage = img.loadBackGroundImage();
    	
    	PanelWithAudio  pnlTeacher = new PanelWithAudio(new Audio(""));
        btnTeacherLgn = GUIComponent.createButton("BtnTeacherLogin.png", "");
        btnTeacherLgn.setBorder(BorderFactory.createEmptyBorder());
        pnlTeacher.add(btnTeacherLgn);
        pnlTeacher.setBackground(Color.ORANGE);
        audioPanels.add(pnlTeacher);
        
    	backgroundImage=new ImageIcon("image/TestingWelcomePage.png").getImage();
        PanelWithAudio pnlContinue = new PanelWithAudio(new Audio("pg1_continue.wav"));
        btnContinue = GUIComponent.createButton("BtnContinue.png", "");
        btnContinue.setBorder(BorderFactory.createEmptyBorder());
        pnlContinue.add(btnContinue);
        pnlContinue.setBackground(Color.ORANGE);
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
    	
    	add(txtStudentFirstName);
    	
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
        g2.drawImage(backgroundImage, 0, 0, this);
    }


}
