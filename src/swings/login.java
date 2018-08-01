package swings;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class login extends JFrame 

{
	Connection con;
	PreparedStatement pst;
	JPanel pnl,pnl2;
	JLabel login,pp;
	JTextField uid,pwd;
	JButton forgot,log,change,close,reg;
	JPasswordField p;
	login()

	{
		con=connection.doConnect();
		if(con!=null)
		{
			JOptionPane.showMessageDialog(null, "Connected to server");
			
		}
		else
			JOptionPane.showMessageDialog(null,"Connection problem");

        setTitle("Login");
		JFrame.setDefaultLookAndFeelDecorated(true);
		setSize(500,500);
		setLayout(null);
		getContentPane().setBackground(new Color(190,190,190,80));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pnl=new JPanel();
		pnl.setLayout(null);
		pnl.setBounds(0, 50, 500, 60);
		pnl.setBackground(new Color(190,190,190));
		pnl.setVisible(true);
		pnl.setBorder(BorderFactory.createBevelBorder(HEIGHT));
        add(pnl);
        
        pnl2=new JPanel();
		pnl2.setLayout(null);
		pnl2.setBounds(75, 0, 330,60);
		pnl2.setBackground(new Color(0,0,128,80));
		pnl2.setBorder(BorderFactory.createBevelBorder(HEIGHT));
		pnl.add(pnl2);
		
		login=new JLabel("LOGIN");
		login.setBounds(180,8 , 500, 50);
		login.setFont(new Font("Garamond",Font.BOLD,30));
		login.setForeground(new Color(0,0,128));
		pnl.add(login);

		
		
		uid=new JTextField("User ID");
		uid.setBounds(100,120 ,200, 40);
		uid.setBorder(BorderFactory.createLineBorder(Color.black,1));
		uid.setFont(new Font("Baskerville Old Face Regular",Font.ITALIC,15));
		uid.setForeground(Color.gray);
		uid.setEditable(true);
		uid.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				uid.selectAll();
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		
		});
		add(uid);
				
		
		p=new JPasswordField("abcde");
		p.setBorder(BorderFactory.createLineBorder(Color.black,1));
		p.setFont(new Font("Baskerville Old Face Regular",Font.ITALIC,15));
    	p.setForeground(Color.gray);
		p.setBounds(100,160,200,40);
		p.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				p.selectAll();
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub  
				
			}
		
		});
		add(p);
	
		pp=new JLabel("");
		pp.setBounds(350,120,100,120);
		
	//	pp.setBorder(BorderFactory.createLineBorder(Color.black,3));
		BufferedImage image=null;
        try {
            image=ImageIO.read(new File("11.png"));
            } catch (IOException e) {
                 // TODO Auto-generated catch block
             e.printStackTrace();
             }
                       Image img=image.getScaledInstance(pp.getWidth(), pp.getHeight(), Image.SCALE_SMOOTH);
		               ImageIcon imageIcon=new ImageIcon(img);
	                   pp.setIcon(imageIcon);
		add(pp);
		// buttons
		
		/*reg=new JButton("REGISTER");
		reg.setBounds(300,430,120,30);
		reg.setBorderPainted( false );
		reg.setBackground(null);
		reg.setOpaque(false);
		reg.setBorder(new EmptyBorder(0,0,0,0));
        add(reg);
		reg.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				playSound("cashreg.wav");
		        loginregistration l=new loginregistration();
				}
		});*/
		
		log=new JButton("LOGIN");
		log.setBounds(100,215,200,40);
		log.setBackground(new Color(255,69,0));
		log.setForeground(Color.white);
		add(log);
		log.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				boolean jasus=false;
				char p1[]= p.getPassword();
				String pw=new String(p1);
				playSound("cashreg.wav");
				try {
					pst=con.prepareStatement("Select password from login where password=?");
					pst.setString(1, pw);
					ResultSet res1=pst.executeQuery();
		    		while(res1.next())
		    		{
		    			jasus=true;
		    			
					        seventh sv= new seventh();
					        dispose();
		    		}
		    		if(jasus==false)
		    			JOptionPane.showMessageDialog(null, "Invalid password");
		    			pst.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		
				
			}});

		forgot=new JButton("FORGOT PASSWORD");
		forgot.setBounds(70,260,120,30);
		forgot.setBorderPainted( false );
		forgot.setBackground(null);
		forgot.setOpaque(false);
		forgot.setBorder(new EmptyBorder(0,0,0,0));
		add(forgot);
		forgot.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{  
				playSound("click.wav");
				search();
			}});
		
		change=new JButton("CHANGE PASSWORD");
		change.setBounds(270,260,120,30);
		change.setBorderPainted( false );
		change.setBackground(null);
		change.setOpaque(false);
		change.setBorder(new EmptyBorder(0, 0,0,0));
		add(change);
		change.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				playSound("click.wav");
				change c=new change();
			}});
		
		
		close=new JButton("CLOSE");
		close.setBounds(380,430,120,30);
		close.setBorderPainted( false );
		close.setBackground(null);
		close.setOpaque(false);
		close.setBorder(new EmptyBorder(0,0,0,0));
		add(close);
		close.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				playSound("click.wav");
				dispose();
			}});
	//-------------------------------------------------------------------
		
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}




	// void search
	
	void search()
	{
		
		try
		{  
				
        pst=con.prepareStatement("Select * from login where uid=?");
		pst.setString(1, uid.getText());
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			String UID=rs.getString("uid");
			String Password=rs.getString("password");
			String mobile=rs.getString("mobile");
			//System.out.println(UID+""+Password+""+mobile);
			uid.setText(""+UID);
			
			SST_SMS.bceSunSoftSend(mobile, Password);
		}}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		
	
	//------------------------------------------------------------
	
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
	
	public static void main(String args[])
	{
		new login();
		
		
	}
	
	
}



	
