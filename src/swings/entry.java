package swings;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class second extends JFrame
{  
	Connection con;
    JLabel lcnc,vhno,floor,slot,parking;
    JPanel pnl,pnl1;
    JTextField vfld;
    JComboBox f,l,s;
    JRadioButton two,four;
    JButton sv,close,cncl;
    PreparedStatement pst;
    second()
	 {
	 setTitle("Vehical Entry");
     JFrame.setDefaultLookAndFeelDecorated(true);
	  setLayout(null);
	  setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
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
		pnl.setBounds(0, 50, 700, 70);
		pnl.setBackground(new Color(0,0,128));
		pnl.setVisible(true);
		pnl.setBorder(BorderFactory.createBevelBorder(HEIGHT));
        add(pnl);
		
		parking=new JLabel("Entry");
		parking.setFont(new Font("Britannic Bold",Font.BOLD,40));
		parking.setForeground(Color.WHITE);
		parking.setBounds(135, 10, 500, 80);
		pnl.add(parking);
		
		pnl1=new JPanel();
		pnl1.setLayout(null);
		pnl1.setBounds(50, 150, 600, 500);
		pnl1.setBackground(new Color(238,232,170));
		pnl1.setVisible(true);
		pnl1.setBorder(BorderFactory.createBevelBorder(HEIGHT));
        add(pnl1);

		lcnc=new JLabel("Licence no:");
		//lcnc.setFont(new Font("Courier new",Font.BOLD,16));
		lcnc.setForeground(new Color(0,0,128));
		lcnc.setBounds(100, 50,180,30);
		lcnc.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,20));
		pnl1.add(lcnc);
		
		l=new JComboBox();
		Statement stat;
		try {
			stat = con.createStatement();
			String s1="SELECT LNo from registration";
			ResultSet rs= stat.executeQuery(s1);
			while(rs.next())
			{
				l.addItem(rs.getString("LNo"));
			}
		} 
		catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		l.setBounds(300,50,120,30);
		pnl1.add(l);
		/*rs.close();
		stat.close();
		con.close();
		*/
		
		vhno=new JLabel("Vehical no:");
		vhno.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,20));
		vhno.setForeground(new Color(0,0,128));
		vhno.setBounds(100, 100,180,30);
		pnl1.add(vhno);
		
		vfld=new JTextField();
		vfld.setBounds(300,100,120,30);
		vfld.setBorder(BorderFactory.createLineBorder(Color.black,1));
		vfld.setForeground(Color.white);
		vfld.setCaretColor(Color.white);
		vfld.setBackground(new Color(0,0,128));
		vfld.setFont(new Font("Baskerville Old Face Regular",Font.ITALIC,14));
		pnl1.add(vfld);
		
		two=new JRadioButton("2 Wheeler");
		four=new JRadioButton("4 Wheeler");
		
		ButtonGroup grp=new ButtonGroup();
		grp.add(two);
		grp.add(four);
        
		Dimension dim=two.getPreferredSize();
		two.setBounds(130, 180, dim.width,dim.height);
		four.setBounds(280, 180, dim.width,dim.height);
		
		pnl1.add(two);
		pnl1.add(four);
		two.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fetcht();
				
			}
		});
		four.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fetchf();
				
			}
		});
		
		JLabel floor=new JLabel("Floor :");
		floor.setForeground(new Color(0,0,128));
		floor.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,20));
		floor.setBounds(150, 230,180,30);
		pnl1.add(floor);
		//String[] floors={"1","2","3"};
		f=new JComboBox();
		f.setBounds(300, 230, 130, 30);
		pnl1.add(f);
		
		slot=new JLabel("Slot :");
		slot.setForeground(new Color(0,0,128));
		slot.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,20));
		slot.setBounds(150, 300,180,30);
		pnl1.add(slot);
		s=new JComboBox();
		s.setBounds(300, 300, 130, 30);
		pnl1.add(s);
	
		
		sv=new JButton("Save");
		sv.setBounds(100, 400, 100,30);
		sv.setBackground(new Color(255,69,0));
		sv.setForeground(Color.white);
		pnl1.add(sv);
		sv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound("click.wav");
				try { 
					int w=0;
				
					pst=con.prepareStatement("insert into entry values(?,?,?,?,?,?,CURRENT_DATE,CURRENT_TIME)");
				    pst.setString(1,(String) l.getSelectedItem());
					pst.setString(2, vfld.getText());
					pst.setString(3, (String) f.getSelectedItem());
					pst.setString(4, (String) s.getSelectedItem());
					 if(two.isSelected())
					    	w=2;
						else if(four.isSelected())
							w=4;
				
					pst.setInt(5, w);
				
				/*	Calendar calender=calender.getInstance();
					java.sql.Date date=new java.sql.Date(calender.getTime().getTime());
					java.sql.Timestamp time=new java.sql.Time(calender.getTimeZone());*/
					pst.setInt(6, 1);
				  /*  long date = 0;
				    java.sql.Timestamp datentime=new java.sql.Timestamp(new java.sql.Date(date).getTime());
				    pst.setString(7, String.valueOf(datentime));*/
					int res=pst.executeUpdate();
					JOptionPane.showMessageDialog(null,res+"record saved");
					
					pst=con.prepareStatement("update parking_layout set status=1 where slots=? && wheeler=? ");
					pst.setString(1, (String) s.getSelectedItem());
					pst.setInt(2, w);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"record updated");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		}
			});
		close=new JButton("Close");
		close.setBounds(340, 400, 100,30);
		close.setBackground(new Color(255,69,0));
		close.setForeground(Color.white);//new Color(210,180,140));
		pnl1.add(close);
		close.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				playSound("click.wav");
				int it=JOptionPane.showConfirmDialog(null, "Sure?");
				if(it==0)
				dispose();				
			}
		});
		
		cncl=new JButton("CANCEL");
		cncl.setBounds(220, 400, 100,30);
		cncl.setBackground(new Color(255,69,0));
		cncl.setForeground(Color.white);
		cncl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound("click.wav");
				vfld.setText("");
				sv.setEnabled(true);
				
			}});
		pnl1.add(cncl);
		
		setSize(700,700);	
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
}
    void fetcht()
    {
    	s.removeAllItems();
    	f.removeAllItems();
    	try { 

    		 Statement ss;
			 ss=con.createStatement();
			String s1="SELECT distinct floor from parking_layout where wheeler=2";
			
			ResultSet rs= ss.executeQuery(s1);
			
			while(rs.next())
			{
				String f1=String.valueOf(rs.getInt("floor"));
				f.addItem(f1);
			}
			 
				String s2="SELECT distinct slots from parking_layout where status=0 && wheeler=2";
				
				rs= ss.executeQuery(s2);
				
				while(rs.next())
				{
					String f2=String.valueOf(rs.getInt("slots"));
					s.addItem(f2);
				}
		} 
		catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
    }
    
    void fetchf()
    {
    	s.removeAllItems();
    	f.removeAllItems();
    	try { 

    		 Statement ss;
			 ss=con.createStatement();
			String s1="SELECT distinct floor from parking_layout where wheeler=4";
			
			ResultSet rs= ss.executeQuery(s1);
			
			while(rs.next())
			{
				String f3=String.valueOf(rs.getInt("floor"));
				f.addItem(f3);
			}

			String s2="SELECT distinct slots from parking_layout where status=0 && wheeler=4";
			
			rs= ss.executeQuery(s2);
			
			while(rs.next())
			{
				String f4=String.valueOf(rs.getInt("slots"));
				s.addItem(f4);
			}
	
			
		} 
		catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
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
    
   
}
public class entry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    new second();
	}
	
}
