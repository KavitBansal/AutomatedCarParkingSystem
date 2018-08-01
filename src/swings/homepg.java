package swings;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;

class seventh extends JFrame
{   
	Connection con;
	JPanel pnl;
	JLabel l1,reg,entry,exit,plout,srch,clnts;
	JButton nw,e,ex,p,s,c,a;
	
	seventh()
	{   
		setTitle("home");
        JFrame.setDefaultLookAndFeelDecorated(true);
	    setLayout(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().setBackground(new Color(190,190,190));
		con=connection.doConnect();
		/*if(con!=null)
		{
			JOptionPane.showMessageDialog(null, "Connected to server");
			
		}
		else
			JOptionPane.showMessageDialog(null,"Connection problem");*/
		
		pnl=new JPanel();
		pnl.setLayout(new FlowLayout());
		pnl.setBounds(0, 0, 600, 50);
		pnl.setBackground(new Color(0,0,128));
		pnl.setVisible(true);
		pnl.setBorder(BorderFactory.createBevelBorder(HEIGHT));
        add(pnl);
        
		l1=new JLabel("CAR PARKING");
		l1.setFont(new Font("Britannic Bold",Font.BOLD,30));
		l1.setForeground(Color.WHITE);//new Color(165,42,42));
		//l1.setBackground(Color.white);
		l1.setBounds(250, 10, 500, 40);
		pnl.add(l1);
		//------------------------------------------------------
		
		nw=new JButton("");
 		nw.setBounds(10, 100, 100,100);
 	//	nw.setIcon(new ImageIcon("ln.png"));
 		nw.setBorderPainted( false );
 		nw.setBackground(null);
 		nw.setOpaque(false);
 		nw.setBorder(new EmptyBorder(0,0,0,0));
		BufferedImage image=null;
        try {
            image=ImageIO.read(new File("ln.png"));
            } catch (IOException e) {
                 // TODO Auto-generated catch block
             e.printStackTrace();
             }
                       Image img=image.getScaledInstance(nw.getWidth(), nw.getHeight(), Image.SCALE_SMOOTH);
		               ImageIcon imageIcon=new ImageIcon(img);
	                   nw.setIcon(imageIcon);
    		add(nw);
    		nw.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				playSound("click.wav");
    				first f=new first();	
        }});
    		
    		reg=new JLabel("Registration");
    		reg.setFont(new Font("Britannic Bold",Font.PLAIN,20));
    		reg.setForeground(new Color(165,42,42));
    		//l1.setBackground(Color.white);
    		reg.setBounds(10, 210, 120, 30);
    		add(reg);
    		//--------------------------------------------------------------------
            
    		e=new JButton("");
    		e.setBounds(170, 100, 100,100);
    	//	e.setIcon(new ImageIcon("lf.png"));
    		e.setBorderPainted( false );
    		e.setBackground(null);
    		e.setOpaque(false);
    		e.setBorder(new EmptyBorder(0,0,0,0));
    		BufferedImage image1=null;
            try {
                image1=ImageIO.read(new File("lf.png"));
                } catch (IOException e) {
                     // TODO Auto-generated catch block
                 e.printStackTrace();
                 }
                           Image img1=image1.getScaledInstance(e.getWidth(), e.getHeight(), Image.SCALE_SMOOTH);
    		               ImageIcon imageIcon1=new ImageIcon(img1);
    	                   e.setIcon(imageIcon1);
    		add(e);
    		e.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				playSound("click.wav");
    				second s=new second();	
        }});
    		
    		entry=new JLabel(" ENTRY");
    		entry.setFont(new Font("Britannic Bold",Font.BOLD,20));
    		entry.setForeground(new Color(165,42,42));
    		entry.setBounds(170, 210, 120, 30);
    		add(entry);
            //---------------------------------------------------------------------
    		p=new JButton("");
    		p.setBounds(330, 100, 100,100);
    		//p.setIcon(new ImageIcon("lj.png"));
    		p.setBorderPainted( false );
    		p.setBackground(null);
    		p.setOpaque(false);
    		p.setBorder(new EmptyBorder(0,0,0,0));
    		BufferedImage image2=null;
            try {
                image2=ImageIO.read(new File("lj.png"));
                } catch (IOException e) {
                     // TODO Auto-generated catch block
                 e.printStackTrace();
                 }
                           Image img2=image2.getScaledInstance(p.getWidth(), p.getHeight(), Image.SCALE_SMOOTH);
    		               ImageIcon imageIcon2=new ImageIcon(img2);
    	                   p.setIcon(imageIcon2);
    		add(p);
    		p.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				playSound("click.wav");
    				third t=new third();	
        }});
    		
    		plout=new JLabel("Parking Layout");
    		plout.setFont(new Font("Britannic Bold",Font.PLAIN,17));
    		plout.setForeground(new Color(165,42,42));
    		plout.setBounds(300, 210, 120, 30);
    		add(plout);
         //------------------------------------------------------------------------------
    		
    		ex=new JButton("");
    		ex.setBounds(480, 100, 100,100);
    		//ex.setIcon(new ImageIcon("lq.png"));
    		ex.setBorderPainted( false );
    		ex.setBackground(null);
    		ex.setOpaque(false);
    		//nw.setBackground(new Color(0,191,255));
    		ex.setBorder(new EmptyBorder(0,0,0,0));
    		BufferedImage image3=null;
            try {
                image3=ImageIO.read(new File("lq.png"));
                } catch (IOException e) {
                     // TODO Auto-generated catch block
                 e.printStackTrace();
                 }
                           Image img3=image3.getScaledInstance(ex.getWidth(), ex.getHeight(), Image.SCALE_SMOOTH);
    		               ImageIcon imageIcon3=new ImageIcon(img3);
    	                   ex.setIcon(imageIcon3);
    		add(ex);
    		ex.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				playSound("click.wav");
    				sixth s=new sixth();	
        }});
    		
    		exit=new JLabel("Exit");
    		exit.setFont(new Font("Britannic Bold",Font.BOLD,20));
    		exit.setForeground(new Color(165,42,42));
    		exit.setBounds(480, 210, 120, 30);
    		add(exit);
    		//------------------------------------------------------------------------------

    		s=new JButton("");
    		s.setBounds(150, 300, 100,100);
    		//s.setIcon(new ImageIcon("lo.png"));
    		s.setBorderPainted( false );
    		s.setBackground(null);
    		s.setOpaque(false);
    		//nw.setBackground(new Color(0,191,255));
    		s.setBorder(new EmptyBorder(0,0,0,0));
    		BufferedImage image4=null;
            try {
                image4=ImageIO.read(new File("lo.png"));
                } catch (IOException e) {
                     // TODO Auto-generated catch block
                 e.printStackTrace();
                 }
                           Image img4=image4.getScaledInstance(s.getWidth(), s.getHeight(), Image.SCALE_SMOOTH);
    		               ImageIcon imageIcon4=new ImageIcon(img4);
    	                   s.setIcon(imageIcon4);
    		add(s);
    		s.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				playSound("click.wav");
    				fifth ft=new fifth();
        }});
    		
    		srch=new JLabel("Search");
    		srch.setFont(new Font("Britannic Bold",Font.BOLD,20));
    		srch.setForeground(new Color(165,42,42));
    		srch.setBounds(150, 410, 120, 30);
    		add(srch);
    		//----------------------------------------------------------------------------------
    		
    		c=new JButton("");
    		c.setBounds(380, 300, 100,100);
    		//c.setIcon(new ImageIcon("lk.png"));
    		c.setBorderPainted( false );
    		c.setBackground(null);
    		c.setOpaque(false);
    		//nw.setBackground(new Color(0,191,255));
    		c.setBorder(new EmptyBorder(0,0,0,0));
    		BufferedImage image5=null;
            try {
                image5=ImageIO.read(new File("lk.png"));
                } catch (IOException e) {
                     // TODO Auto-generated catch block
                 e.printStackTrace();
                 }
                           Image img5=image5.getScaledInstance(c.getWidth(), c.getHeight(), Image.SCALE_SMOOTH);
    		               ImageIcon imageIcon5=new ImageIcon(img5);
    	                   c.setIcon(imageIcon5);
    		add(c);
    		c.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				playSound("click.wav");
    				fourth f=new fourth();
        }});
    		
    		clnts=new JLabel("Our Clients");
    		clnts.setFont(new Font("Britannic Bold",Font.BOLD,20));
    		clnts.setForeground(new Color(165,42,42));
    		clnts.setBounds(380, 410, 120, 30);
    		add(clnts);
    		
    		a=new JButton("ABOUT US");
    		a.setFont(new Font("Britannic Bold",Font.BOLD,20));
    		a.setForeground(new Color(165,42,42));
    		a.setBounds(250,450,120,30);
    		a.setBorderPainted( false );
    		a.setBackground(null);
    		a.setOpaque(false);
    		a.setBorder(new EmptyBorder(0,0,0,0));
    		add(a);
    		a.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent e) 
    			{
    				playSound("click.wav");
    				about ab=new about();
    			}});
    		

		setSize(600,600);	
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
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
	
}
public class homepg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new seventh();
	}

}
