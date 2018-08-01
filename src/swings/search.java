package swings;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;

class fifth extends JFrame
{
	JLabel vehicle,lcnc;
	JComboBox v,l;
	JButton search,ftch;
	Connection con;
	ResultSet rs;
	JTable table;
	PreparedStatement pst;
	fifth()
	{
	setTitle("Search panel");
    JFrame.setDefaultLookAndFeelDecorated(true);
	  setLayout(null);
	  setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
	  getContentPane().setBackground(new Color(190,190,190));
	  
	  JLabel l1=new JLabel("Search");
	  l1.setBounds(200,10,150,50);
	  l1.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,40));
	  l1.setForeground(new Color(0,0,128));
	  add(l1);
	  
	    vehicle=new JLabel("Vehicle no.");
		vehicle.setFont(new Font("Courier new",Font.BOLD,16));
		vehicle.setForeground(new Color(0,0,128));
		vehicle.setBounds(100, 100,180,30);
		vehicle.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,16));
		add(vehicle);
		
         v=new JComboBox();
		 v.setEditable(true);
		 v.setBounds(200,100,120,30);
		 add(v);
		
		lcnc=new JLabel("Licence no.");
		lcnc.setFont(new Font("Courier new",Font.BOLD,16));
		lcnc.setForeground(new Color(0,0,128));
		lcnc.setBounds(100, 150,180,30);
		lcnc.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,16));
		add(lcnc);
		
		l=new JComboBox();
		l.setEditable(true);
		l.setBounds(200,150,120,30);
		add(l);
		
		search=new JButton("SEARCH");
		search.setBounds(350, 100, 100,30);
		search.setBackground(new Color(255,69,0));
		search.setForeground(Color.white);
		add(search);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound("click.wav");
				searchtable();
			}
		});
		
		ftch=new JButton("FETCH");
		ftch.setBounds(350, 150, 100,30);
		ftch.setBackground(new Color(255,69,0));
		ftch.setForeground(Color.white);
		add(ftch);
		ftch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound("click.wav");
			 fetchtable();
			}});
		
		JButton close=new JButton("CLOSE");
		close.setBounds(250, 530, 100,30);
		close.setBackground(new Color(255,69,0));
		close.setForeground(Color.white);//new Color(210,180,140));
		add(close);
		close.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{ 
				
				dispose();				
				playSound("click.wav");	
				//lfld.setFocusable(false);
			}
		});
		
		setSize(600,600);	
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}
		void fetchtable()
		{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_parking","root","bce");
		String sql = "Select * from entry where LNo=?";
		
		pst = con.prepareStatement(sql);
		pst.setString(1, (String) l.getSelectedItem());
		rs = pst.executeQuery();
		
		java.sql.ResultSetMetaData md = rs.getMetaData();
		Vector<String> columnNames = new Vector<String>();
		int columns = md.getColumnCount();
		for (int i = 1; i <= columns; i++)
		{
		columnNames.addElement( md.getColumnName(i) );
		}
		//--------------------------------------------------
		Vector<Object> data = new Vector<Object>();
		while (rs.next())
		{
		Vector<Object> row = new Vector<Object>(columns);
		for (int i = 1; i <= columns; i++)
		{
		row.addElement( rs.getObject(i) );
		}
		v.addItem(rs.getString("VNo"));
		data.addElement(row);
		}
		rs.close();
		pst.close();
		table = new JTable(data,columnNames);
		JScrollPane scrollPane = new JScrollPane( table );
		table.setFont(new Font("Arial",Font.BOLD,10));
		table.setBackground(new Color(0,0,128));
		table.setForeground(Color.white);
		table.setSelectionBackground(new Color(0,0,128));
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar 
		scrollPane.setBounds(50, 250, 500, 200);
		scrollPane.getViewport().setScrollMode(JViewport.BACKINGSTORE_SCROLL_MODE);
		add( scrollPane );
		}
		catch(Exception nex)
		{
		nex.printStackTrace();
		}
		
		}
		
		//-----------------------------------------------------------
		
		void searchtable()
		{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_parking","root","bce");
		String sql = "Select * from entry where VNo=?";
		pst = con.prepareStatement(sql);
		pst.setString(1, (String) v.getSelectedItem());
		rs = pst.executeQuery();
		java.sql.ResultSetMetaData md = rs.getMetaData();
		Vector<String> columnNames = new Vector<String>();
		int columns = md.getColumnCount();
		for (int i = 1; i <= columns; i++)
		{
		columnNames.addElement( md.getColumnName(i) );
		}
		//--------------------------------------------------
		Vector<Object> data = new Vector<Object>();
		while (rs.next())
		{
		Vector<Object> row = new Vector<Object>(columns);
		for (int i = 1; i <= columns; i++)
		{
		row.addElement( rs.getObject(i) );
		}
		l.addItem(rs.getString("LNo"));
		data.addElement(row);
		}
		rs.close();
		pst.close();
		table = new JTable(data,columnNames);
		JScrollPane scrollPane = new JScrollPane( table );
		table.setBackground(new Color(0,0,128));
		table.setForeground(Color.white);
		table.setFont(new Font("Arial",Font.BOLD,10));
		table.setSelectionBackground(new Color(0,0,128));
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar 
		scrollPane.setBounds(50, 250, 500, 200);
		scrollPane.getViewport().setScrollMode(JViewport.BACKINGSTORE_SCROLL_MODE);
		add( scrollPane );
		}
		catch(Exception nex)
		{
		nex.printStackTrace();
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

public class search {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new fifth();
	}

}
