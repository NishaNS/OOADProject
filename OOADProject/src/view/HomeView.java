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
import java.awt.*;
import java.awt.event.ActionListener;
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
    private JTextField txtStudentName;
    private JLabel lblOptional;

    public HomeView() {
        AppImage img = new AppImage("welcomepg.png");
        backgroundImage = img.loadBackGroundImage();
        PanelWithAudio pnlContinue = new PanelWithAudio(new Audio("continuekey.wav"));
        btnContinue = GUIComponent.createButton("", "Continue");
        pnlContinue.add(btnContinue);
        pnlContinue.setBackground(Color.GREEN);
        audioPanels.add(pnlContinue);

        PanelWithAudio  pnlTeacher = new PanelWithAudio(new Audio("goodjob.wav"));
        btnTeacherLgn = GUIComponent.createButton("", "Teacher Login");
        pnlTeacher.add(btnTeacherLgn);
        pnlTeacher.setBackground(Color.GREEN);
        audioPanels.add(pnlTeacher);

        txtStudentName = new JTextField("--Enter the student name--");
        lblOptional = new JLabel("(optional)");
        btnContinue.setFocusable(true);
        addComponents();
    }

    public void addContinueKeyListener(KeyListener kListener) {
        btnContinue.addKeyListener(kListener);
    }

    public void addContinueMouseListener(MouseListener mListener) {
        btnContinue.addMouseListener(mListener);
    }

    public void addContinueActionListener(ActionListener listener) {
        btnContinue.addActionListener(listener);
    }

    public void addTeacherLoginListener(ActionListener listener) {
        btnTeacherLgn.addActionListener(listener);
    }

    private void addComponents() {
        for(PanelWithAudio panel : audioPanels){
            add(panel);
        }
        add(txtStudentName);
        add(lblOptional);
    }

    public List<PanelWithAudio> getAudioPanels() {
        return audioPanels;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(backgroundImage, 0, 0, this);
    }


}
