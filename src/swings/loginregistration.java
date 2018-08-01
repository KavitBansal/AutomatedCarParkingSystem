package swings;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class loginregistration extends JFrame{
	Connection con;
	PreparedStatement pst;
	JTextField userf, mobilef,passf;
	JLabel lerr,lerr1;
	loginregistration()
	{
		 con=connection.doConnect();
		setTitle("Admin Registration");
	setSize(500,500);
	setLayout(null);
	getContentPane().setBackground(new Color(190,190,190,80));
	
	JLabel user=new JLabel("UID: ");
	user.setBounds(90,50 , 120, 30);
	user.setFont(new Font("Garamond",Font.BOLD,14));
	user.setForeground(new Color(0,0,128));
	add(user);
	
	JLabel mobi=new JLabel("MOBILE: ");
	mobi.setBounds(90,100 , 120, 30);
	mobi.setFont(new Font("Garamond",Font.BOLD,14));
	mobi.setForeground(new Color(0,0,128));
	add(mobi);
	
	JLabel passkey=new JLabel("PASSWORD:");
	passkey.setBounds(90,150 , 120, 30);
	passkey.setFont(new Font("Garamond",Font.BOLD,14));
	passkey.setForeground(new Color(0,0,128));
	add(passkey);
	
	userf=new JTextField();
	userf.setBounds(210, 50, 150, 30);
	userf.setFont(new Font("Baskerville Old Face Regular",Font.ITALIC,14));
	userf.setBorder(BorderFactory.createLineBorder(Color.black,2));
	add(userf);
	
	lerr=new JLabel("");
	lerr.setBounds(380,100,110,30);
	add(lerr);
	
	lerr1=new JLabel("");
	lerr1.setBounds(380,150,110,30);
	add(lerr1);
	
	mobilef=new JTextField();
	mobilef.setBounds(210, 100, 150, 30);
	mobilef.setFont(new Font("Baskerville Old Face Regular",Font.ITALIC,14));
	mobilef.setBorder(BorderFactory.createLineBorder(Color.black,2));
	add(mobilef);
	mobilef.addFocusListener(new FocusListener() {
		@Override
		public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		String mobile="^[789]\\d{9}$";
		boolean b=mobilef.getText().matches(mobile);
		if(b==false)
		{
		lerr.setText("Invalid...");
		lerr.setFont(new Font("Baskerville Old Face Regular",Font.ITALIC,14));
		lerr.setForeground(Color.black);
		mobilef.requestFocusInWindow();
		}
		else
		lerr.setText("");
		mobilef.setBackground(Color.white);
		}
		@Override
		public void focusGained(FocusEvent e) {
		mobilef.setBackground(new Color(190,190,190));
		}
		});
	
	passf=new JTextField();
	passf.setBounds(210, 150, 150, 30);
	passf.setFont(new Font("Baskerville Old Face Regular",Font.ITALIC,14));
	passf.setBorder(BorderFactory.createLineBorder(Color.black,2));
	add(passf);

	/*passf.addFocusListener(new FocusListener() {
		@Override
		public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
    String exp="(?=^.{8,}$)(?=.*\\d)(?=.*[!@#$%^&*]+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
    
	boolean b=passf.getText().matches(exp);
	if(b==false)
	{
	lerr1.setText("Invalid...");
	lerr1.setFont(new Font("Baskerville Old Face Regular",Font.ITALIC,14));
	lerr1.setForeground(Color.black);
	passf.requestFocusInWindow();
	}
	else
	lerr1.setText("");
	passf.setBackground(Color.white);
	}
	@Override
	public void focusGained(FocusEvent e) {
	passf.setBackground(new Color(190,190,190));
	}
	});*/
	
	JButton sv=new JButton("SAVE");
	sv.setBounds(100, 300, 100,30);
	sv.setBackground(new Color(255,69,0));
	sv.setForeground(Color.white);
	add(sv);
	sv.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			playSound("click.wav");
			try {
				pst=con.prepareStatement("insert into login values(?,?,?)");
				pst.setString(1, userf.getText());
				pst.setString(3,(String) mobilef.getText());
				pst.setString(2, passf.getText());
										
				int res=pst.executeUpdate();
				JOptionPane.showMessageDialog(null,res+"record saved");
				
				pst=con.prepareStatement("Select * from login where uid=?");
	    		pst.setString(1, userf.getText());
	    		ResultSet res1=pst.executeQuery();
	    		while(res1.next())
	    		{
	    			String UID=res1.getString("uid");
				String Password=res1.getString("password");
				String mobile=res1.getString("mobile");
				String msg=SST_SMS.bceSunSoftSend(mobile,"Ur password for registered id: "+UID+" is: "+Password);
		       	}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
	});
	
	JButton close=new JButton("CLOSE");
	close.setBounds(250, 300, 100,30);
	close.setBackground(new Color(255,69,0));
	close.setForeground(Color.white);//new Color(210,180,140));
	add(close);
	close.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{ 
			playSound("click.wav");	
			int it=JOptionPane.showConfirmDialog(null, "Sure?");
			if(it==0)
			dispose();				
			
			//lfld.setFocusable(false);
		}
	});

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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    new loginregistration();
    
    
	}
}