package swings;

	import java.awt.Color;
	import java.awt.Font;
	import java.awt.Image;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
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

	public class change extends  JFrame implements ActionListener

	{

		Connection con;
		PreparedStatement pst;
		JPanel pnl1,pnl2;
		JLabel login,pp,uid,pwd,npwd;
		JTextField tuid;
		JPasswordField tpwd,tnpwd;
		JButton change,close;
		//JPasswordField p1;


		change()

		{
			con=connection.doConnect();
			/*if(con!=null)
			{
				JOptionPane.showMessageDialog(null, "Connected to server");
				
			}
			else
				JOptionPane.showMessageDialog(null,"Connection problem");*/



			setTitle("Change Password");
			JFrame.setDefaultLookAndFeelDecorated(true);
			setLayout(null);
			setSize(500,500);
			//setUndecorated(true);
			getContentPane().setBackground(Color.LIGHT_GRAY);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


			// panel first upper name 

			pnl1=new JPanel();
			pnl1.setLayout(null);
			pnl1.setBounds(0, 50, 500, 60);
			pnl1.setBackground(new Color(238,232,170));
			pnl1.setBorder(BorderFactory.createBevelBorder(HEIGHT));
			add(pnl1);

			// add label

			login=new JLabel("Change ur Password");
			login.setBounds(160,8 , 500, 50);
			login.setFont(new Font("Garamond",Font.BOLD,30));
			login.setForeground(Color.white);
			pnl1.add(login);

			
		
			pnl2=new JPanel();
			pnl2.setLayout(null);
			pnl2.setBounds(50, 70, 380,330);
			pnl2.setBackground(new Color(0,0,128,80));
			pnl2.setBorder(BorderFactory.createBevelBorder(HEIGHT));
			add(pnl2);
			
			// add iamge on left side
			

			pp=new JLabel("");
			pp.setBounds(30,70,100,120);
			BufferedImage image=null;
	        try {
	            image=ImageIO.read(new File("12.png"));
	            } catch (IOException e) {
	                 // TODO Auto-generated catch block
	             e.printStackTrace();
	             }
	                       Image img=image.getScaledInstance(pp.getWidth(), pp.getHeight(), Image.SCALE_SMOOTH);
			               ImageIcon imageIcon=new ImageIcon(img);
		                   pp.setIcon(imageIcon);
			pnl2.add(pp);
			
			// add labels
			
			uid=new JLabel("UID");
			uid.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,14));
			uid.setForeground(new Color(0,0,128));
			uid.setBounds(200,50,120,30);
			pnl2.add(uid);

			pwd=new JLabel("OLD PASSWORD");
			pwd.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,14));
			pwd.setForeground(new Color(0,0,128));
			pwd.setBounds(200,110 ,150, 30);
			pnl2.add(pwd);
			
			npwd=new JLabel("NEW PASSWORD");
			npwd.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,14));
			npwd.setForeground(new Color(0,0,128));
			npwd.setBounds(200,170 ,150, 30);
			pnl2.add(npwd);
			
			// add text fields
			
			tuid=new JTextField();
			tuid.setBounds(200,80,150,30);
			tuid.setBorder(BorderFactory.createLineBorder(Color.black,1));
			pnl2.add(tuid);

			tpwd=new JPasswordField();
			tpwd.setBounds(200,140,150,30);
			tpwd.setBorder(BorderFactory.createLineBorder(Color.black,1));
			pnl2.add(tpwd);
			
			tnpwd=new JPasswordField();
			tnpwd.setBounds(200,200,150,30);
			tnpwd.setBorder(BorderFactory.createLineBorder(Color.black,1));
			pnl2.add(tnpwd);
			
			// buttons
			

			change=new JButton("CHANGE PASSWORD");
			change.setBounds(190,250,170,30);
			change.setBackground(new Color(255,69,0));
			change.setForeground(Color.white);
			pnl2.add(change);
			change.addActionListener(this);
			
			
			close=new JButton("CLOSE");
			close.setBounds(280,290,80,30);
			close.setBackground(new Color(255,69,0));
			close.setForeground(Color.white);
			pnl2.add(close);
			close.addActionListener(this);
		//-------------------------------------------------------------------
			
			setResizable(false);
			setVisible(true);
			setLocationRelativeTo(null);
			
	}
		//-------------------------------------------------------------------------------------------
		
			// functions
			
			
			public void showData()
		    {
		    	JFrame f1 = new JFrame();
		        JLabel l, l0;
		        String str1 =tuid.getText();
		        char[] p = tpwd.getPassword();
		        char[]p1=tnpwd.getPassword();
		        String str2 = new String(p);
		        String str3=new String(p1);
		        try
		        {
		        	     
		            pst = con.prepareStatement("update login set password=? where uid=?");
		            pst.setString(1, str3);
		            pst.setString(2, str1);
		            int res = pst.executeUpdate();
		            JOptionPane.showMessageDialog(null, res+" records Updated");
		            
		            pst=con.prepareStatement("Select * from login where uid=?");
		    		pst.setString(1, tuid.getText());
		    		ResultSet res1=pst.executeQuery();
		    		while(res1.next())
		    		{
		    			String UID=res1.getString("uid");
					String Password=res1.getString("password");
					String mobile=res1.getString("mobile");
					String msg=SST_SMS.bceSunSoftSend(mobile,"Ur new password is: "+Password);
			       	}
		        }
				catch (SQLException e) 
				{
					e.printStackTrace();
				} 
				try{
					pst.close();
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
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
		
			
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getActionCommand().equals("CLOSE"))
			{
				playSound("click.wav");
				dispose();

			}

			else
				if(e.getActionCommand().equals("CHANGE PASSWORD"))
				{
					playSound("click.wav");
					showData();

				}

			
		}
		public static void main(String args[])
		{
			new change();
		}
	}


