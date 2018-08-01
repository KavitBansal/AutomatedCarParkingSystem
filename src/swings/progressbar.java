package swings;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRootPane;
import javax.swing.border.Border;
public class progressbar extends JFrame
{ 
JProgressBar progressBar;
JLabel icon;
progressbar()
{ 
Container content = getContentPane();

icon=new JLabel(); 
icon.setIcon(new ImageIcon("13.gif"));
add(icon);

//---------------------------
progressBar = new JProgressBar(0,100);
progressBar.setValue(1);
progressBar.setStringPainted(true);
add(progressBar, BorderLayout.AFTER_LAST_LINE);
progressBar.setBackground(Color.white);
progressBar.setForeground(new Color(0,0,0));
setUndecorated(true);
setSize(380, 200);
setVisible(true); 
setLocation(400,400);//screen location
setLocationRelativeTo(null);
runn();
}
public void runn()
{
for(int i=1;i<=100;i++)
{
progressBar.setValue(i);
try {
Thread.sleep(20);
} catch (Exception e) { }
}
setVisible(false);
//0584JOptionPane.showMessageDialog(null, "Completed");
}
public static void main(String args[])
{
new progressbar();
login l=new login();
}
}