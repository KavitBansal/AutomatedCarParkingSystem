package swings;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.sql.Connection;
//import com.mysql.jdbc.PreparedStatement;

public class AboutUs 
{
	public static void main(String[] args) 
	{
		about a=new about();


	}

}
class about extends JFrame 
{
	JPanel p,p1;
	Border brd;
	JFrame myFrame;
	JLabel label,lid,l1,l2,l3,l4,l5,l6,l7,l8,pic1,pic2,l9;
	JButton bclose;
	
	about()
	{			
			
			setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
			setLayout(null);
			getContentPane().setBackground(new Color(238,232,170));
						
			p=new JPanel();
			p.setBackground(new Color(0,0,128,80));
			p.setBounds(0, 0, 700, 80);
			add(p);
			
	      	label= new JLabel(" ABOUT US ");
			label.setFont(new Font("Baskerville Old Face Regular", Font.BOLD, 45));
			label.setBounds(170, 20, 370, 50);
			label.setForeground(new Color(0,0,128));
			label.setLayout(null);
			p.add(label);

			p1=new JPanel();
			p1.setBackground(new Color(0,0,128));
			p1.setBounds(0, 90, 700, 10);
			add(p1);
			
			lid= new JLabel(" Made By: ");
			lid.setText("<HTML><U><BOLD>Made By: </BOLD></U></HTML>");
			lid.setFont(new Font("Time of roman", Font.BOLD, 30));
			lid.setBounds(200, 150, 180, 35);
			lid.setLayout(null);
			add(lid);
		
			
			l1= new JLabel("Er Kavit Bansal ");
			l1.setFont(new Font("Arial", Font.BOLD, 20));
			l1.setBounds(380, 200, 300, 30);
			l1.setLayout(null);
			add(l1);

			l2= new JLabel("B-TECH,CSE-5th sem ");
			l2.setFont(new Font("Arial", Font.BOLD, 20));
			l2.setBounds(380, 240, 300, 30);
			l2.setLayout(null);
			add(l2);

			l3= new JLabel("1413458 ");
			l3.setFont(new Font("Arial", Font.BOLD, 20));
			l3.setBounds(380, 280, 300, 30);
			l3.setLayout(null);
			add(l3);

			l4= new JLabel("Giani Zail Singh Campus,Bti ");
			l4.setFont(new Font("Arial", Font.BOLD, 20));
			l4.setBounds(380, 320, 400, 30);
					l4.setLayout(null);
			add(l4);

		/*	l7= new JLabel("");
			l7.setBounds(400, 300, 160, 150);
			l7.setBorder(BorderFactory.createLineBorder(Color.black,2));
			l7.setLayout(null);
			add(l7);
		*/
			l5= new JLabel(" Under The Guidance Of: ");
			l5.setText("<HTML><U><BOLD> Under The Guidance Of: </BOLD></U></HTML>");
			l5.setFont(new Font("Times of roman", Font.BOLD, 30));
			l5.setBounds(150, 370, 400, 39);
			l5.setLayout(null);
			add(l5);

			l6= new JLabel(" MR.RAJESH K. BANSAL ");
			l6.setFont(new Font("Arial", Font.BOLD, 20));
			l6.setBounds(40, 430, 300, 30);
			//	l7.setBorder(brd);
			l6.setLayout(null);
			add(l6);
			
			l9= new JLabel(" C.E.O. at SUNSOFT TECH. PVT. LTD.");
			l9.setFont(new Font("Arial", Font.BOLD, 20));
			l9.setBounds(40, 470, 390, 30);
			//	l7.setBorder(brd);
			l9.setLayout(null);
			add(l9);
			
			l7= new JLabel(" Banglore Computer Education ");
			l7.setFont(new Font("Arial", Font.BOLD, 20));
			l7.setBounds(40, 510, 300, 30);
			//	l7.setBorder(brd);
			l7.setLayout(null);
			add(l7);
			
			l8= new JLabel(" BATHINDA ");
			l8.setFont(new Font("Arial", Font.BOLD, 20));
			l8.setBounds(40, 550, 300, 30);
			//	l7.setBorder(brd);
			l8.setLayout(null);
			add(l8);
			

			pic1=new JLabel("");
			pic1.setBounds(100,200,120,150);
			pic1.setBorder(BorderFactory.createLineBorder(Color.black,1));
			BufferedImage image=null;
	        try {
	            image=ImageIO.read(new File("me2.jpg"));
	            } catch (IOException e) {
	                 // TODO Auto-generated catch block
	             e.printStackTrace();
	             }
	                       Image img=image.getScaledInstance(pic1.getWidth(), pic1.getHeight(), Image.SCALE_SMOOTH);
			               ImageIcon imageIcon=new ImageIcon(img);
		                   pic1.setIcon(imageIcon);
			add(pic1);
			

			pic2=new JLabel("");
			pic2.setBounds(490,430,120,150);
			pic2.setBorder(BorderFactory.createLineBorder(Color.black,1));
			BufferedImage image1=null;
	        try {
	            image1=ImageIO.read(new File("sir.jpg"));
	            } catch (IOException e) {
	                 // TODO Auto-generated catch block
	             e.printStackTrace();
	             }
	                       Image img1=image1.getScaledInstance(pic2.getWidth(), pic2.getHeight(), Image.SCALE_SMOOTH);
			               ImageIcon imageIcon1=new ImageIcon(img1);
		                   pic2.setIcon(imageIcon1);
			add(pic2);
			
			bclose = new JButton("Close");
			bclose.setBounds(270,610,100,35);
			bclose.setBackground(new Color(255,69,0));
			bclose.setForeground(Color.white);
			//UIManager.put("Button.select", Color.red);
			//bclose.setBorder(brd);
			bclose.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					playSound("click.wav");
				//	int it=JOptionPane.showConfirmDialog( null,"sure?");
				//	if(it==0)
						dispose();
				}
			});
			
			add(bclose);

	      	setSize(700,700);
			setResizable(false);
			setLocationRelativeTo(null);
			setVisible(true);
			}
	
	public void playSound(String soundName)
    {
      try 
      {
       AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
       Clip clip = AudioSystem.getClip();
       clip.open(audioInputStream);
       clip.start();
      }
      catch(Exception ex)
      {
        System.out.println("Error with playing sound.");
        ex.printStackTrace( );
      }
    }
	
public static void main(String[] args)
{
	new about();
}


}
	

			
	