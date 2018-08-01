package swings;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;


import java.sql.Connection;
import java.sql.DriverManager;

class fourth extends JFrame
{ 
Connection con;
java.sql.PreparedStatement pstmt;
ResultSet rs;
JButton loadAll,print,sms,reg;
JTable table;
JLabel l1;
fourth()
{
	setTitle("Client Portal");
    JFrame.setDefaultLookAndFeelDecorated(true);
	  setLayout(null);
	  setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
	  getContentPane().setBackground(new Color(190,190,190));
	  
	  l1=new JLabel();
	  l1.setBounds(150,50,500,50);
	  l1.setText("Our Clients");
	  l1.setFont(new Font("Britannic Bold",Font.BOLD,40));
	  l1.setForeground(new Color(0,0,128));
	  add(l1);
	  
	reg=new JButton("Registers");
	reg.setBounds(200, 120, 100,30);
	reg.setBackground(new Color(255,69,0));
	reg.setForeground(Color.white);
	add(reg);
	reg.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		       playSound("click.wav");
				tablehyr();
				}
				});
	
	JButton close=new JButton("CLOSE");
	close.setBounds(200, 420, 100,30);
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
	
	setSize(500,500);	
	setVisible(true);
	setResizable(false);
	setLocationRelativeTo(null);
	
}
void tablehyr()
{
try {
	Class.forName("com.mysql.jdbc.Driver");
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_parking","root","bce");
String sql = "Select LNo,name,address,city,mobile,picpath from registration";
pstmt = con.prepareStatement(sql);
rs = pstmt.executeQuery();
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
data.addElement(row);
}
rs.close();
pstmt.close();
table = new JTable(data,columnNames);
JScrollPane scrollPane = new JScrollPane( table );
table.setBackground(new Color(0,0,128));
table.setForeground(Color.white);
table.setSelectionBackground(new Color(0,0,128));
//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar 
scrollPane.setBounds(50, 180, 400, 200);
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

public class registers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new fourth();
	}

}
