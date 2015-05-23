
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


@SuppressWarnings("serial")
public class cardlayout extends JFrame implements MouseListener {


public static CardLayout card = new CardLayout();


public static JPanel container = new JPanel();
public static JPanel panel1 = new JPanel();
public static JPanel panel2 = new JPanel();
public static JPanel panel3 = new JPanel();
public static JPanel panel4 = new JPanel();

private static JButton bt[] = new JButton[4];
private static JButton pr[]=new JButton[4];
private static JLabel lb[]=new JLabel[4];
private static JButton main[]=new JButton[4];

private String[] text = {"Next ","Next >",
"Next >> ","Next >>>"};

private String[] prev={"Prev", "< Prev","<< Prev","<<< Prev"}; 
private String[] label={"Panel1","Panel2","Panel3","Panel4"};
private String[] mainm={"Main","Main>","Main >>","Main >>> "};


public cardlayout() {

container.setLayout(card);
panel1.setLayout(null);
panel2.setLayout(null);
panel3.setLayout(null);
panel4.setLayout(null);



for (int i = 0; i < bt.length; i++) {

bt[i]=new JButton(text[i]) ;
bt[i].setBounds(400, 150, 100, 40);
bt[i].addMouseListener(this) ;

}
for (int i = 0; i < pr.length; i++) {

pr[i]=new JButton(prev[i]) ;
pr[i].setBounds(0, 150, 100, 40);
pr[i].addMouseListener(this) ;
 
}
for (int i = 0; i < lb.length; i++) {

lb[i]=new JLabel(label[i]) ;
lb[i].setBounds(200, 150, 100, 40);
lb[i].addMouseListener(this) ;

}
for (int i = 0; i < main.length; i++)
{
	main[i]=new JButton(mainm[i]);
main[i].setBounds(200, 250, 100,50);
main[i].addMouseListener(this);
}
panel1.add(pr[0]);
panel1.add(bt[0]);
panel1.add(lb[0]);
panel1.add(main[0]);

panel2.add(pr[1]);
panel2.add(bt[1]);
panel2.add(lb[1]);
panel2.add(main[1]);

panel3.add(pr[2]);
panel3.add(bt[2]);
panel3.add(lb[2]);
panel3.add(main[2]);

panel4.add(pr[3]);
panel4.add(bt[3]);
panel4.add(lb[3]);
panel4.add(main[3]);



panel1.setBackground(Color.red);
panel2.setBackground(Color.blue);
panel3.setBackground(Color.DARK_GRAY);
panel4.setBackground(Color.green);




setSize(500, 500); 

setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;


container.add(panel1, "0");
container.add(panel2, "1");
container.add(panel3, "2");
container.add(panel4, "3");


card.show(container,"0");

}

public static void main(String[] args) {

cardlayout c = new cardlayout();

c.add(container); 
c.setVisible(true);

}

@Override
public void mouseClicked(MouseEvent e) {


//for (int i = 0; i < bt.length; i++) {

if (e.getSource() == bt[0]) {
card.show(container, "" + 1); 


}
if (e.getSource() == bt[1]) {
card.show(container, "" + 2);


}
if (e.getSource() == bt[2]) {
card.show(container, "" + 3);


}
if (e.getSource() == bt[3]) { 
card.show(container, "" + 0);


}
if (e.getSource() == pr[0]) {
card.show(container, "" + 3); 


}
if (e.getSource() == pr[1]) {
card.show(container, "" + 0);


}
if (e.getSource() == pr[2]) {
card.show(container, "" + 1);


}
if (e.getSource() == pr[3]) {
card.show(container, "" + 2);


}
if(e.getSource() ==main[0]){
card.show(container,""+0);	
}
if(e.getSource() ==main[1]){
card.show(container,""+0);	
}
if(e.getSource() ==main[2]){
card.show(container,"0");	
}
if(e.getSource() ==main[3]){
card.show(container,"0");	
}

//}

}




@Override
public void mouseEntered(MouseEvent e) {

}

@Override
public void mouseExited(MouseEvent e) {

}

@Override
public void mousePressed(MouseEvent arg0) {
// TODO Auto-generated method stub

}

@Override
public void mouseReleased(MouseEvent arg0) {
// TODO Auto-generated method stub

}

}

