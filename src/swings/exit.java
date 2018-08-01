package swings;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

class sixth extends JFrame
{
	Connection con;
	JLabel vehicle,f,s,w,d,t,f1,s1,w1,d1,t1,CTT,CDD,ct,cd,days,hours,bill,DAYS,HRS,BILL;
	JPanel pnl,pnl1;
	JComboBox v;
	JButton ftch,calc,done,print;
	PreparedStatement pst;
	JTable table;
	
	sixth()
	{ 
		setTitle("exit");
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

	    vehicle=new JLabel("Vehicle no.");
		vehicle.setFont(new Font("Courier new",Font.BOLD,16));
		vehicle.setForeground(new Color(0,0,128));
		vehicle.setBounds(150, 50,180,30);
		vehicle.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,16));
		add(vehicle);
		
		v=new JComboBox();
		 v.setEditable(true);
		 v.setBounds(250,50,120,30);
		 add(v);
			try {
				String s1="SELECT VNo from entry where status=1";
				pst = con.prepareStatement(s1);
				ResultSet rs= pst.executeQuery();
				while(rs.next())
				{
					v.addItem(rs.getString("VNo"));
				}
			} 
			catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		 
		pnl=new JPanel();
		pnl.setLayout(null);
		pnl.setBounds(50,100, 600,240);
		pnl.setBackground(new Color(238,232,170));
		pnl.setVisible(true);
		pnl.setBorder(BorderFactory.createBevelBorder(HEIGHT));
		add(pnl);
		 		 
		f=new JLabel("Floor");
	    f.setForeground(new Color(0,0,128));
		f.setBounds(30, 30,120,30);
		f.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,20));
		pnl.add(f);
		
		f1=new JLabel("");
		f1.setBorder(BorderFactory.createLineBorder(Color.black,1));
		f1.setBounds(160,30,140,30);
		pnl.add(f1);
		
		w=new JLabel("wheeler");
		w.setForeground(new Color(0,0,128));
		w.setBounds(30, 80,120,30);
		w.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,20));
		pnl.add(w);
		
		w1=new JLabel("");
		w1.setBorder(BorderFactory.createLineBorder(Color.black,1));
		w1.setBounds(160, 80,140,30);
		pnl.add(w1);
		
		s=new JLabel("Slot ");
		s.setForeground(new Color(0,0,128));
		s.setBounds(350, 30,120,30);
		s.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,20));
		pnl.add(s);
		
		s1=new JLabel("");
		s1.setBorder(BorderFactory.createLineBorder(Color.black,1));
		s1.setBounds(400, 30,140,30);
		pnl.add(s1);
		
		d=new JLabel("Parking date");
		d.setForeground(new Color(0,0,128));
		d.setBounds(30, 130,120,30);
		d.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,20));
		pnl.add(d);
		
		d1=new JLabel("");
		d1.setBorder(BorderFactory.createLineBorder(Color.black,1));
		d1.setBounds(160, 130,140,30);
		pnl.add(d1);
		
		t=new JLabel("Parking time");
		t.setForeground(new Color(0,0,128));
		t.setBounds(30, 180,120,30);
		t.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,20));
		pnl.add(t);
		
		t1=new JLabel("");
		t1.setBorder(BorderFactory.createLineBorder(Color.black,1));
		t1.setBounds(160, 180,140,30);
		pnl.add(t1);
		
		//----------------------------------------------------------
		pnl1=new JPanel();
		pnl1.setLayout(null);
		pnl1.setBounds(50, 340, 600, 120);
		pnl1.setBackground(new Color(0,0,128));
		pnl1.setVisible(true);
		pnl1.setBorder(BorderFactory.createBevelBorder(HEIGHT));
        add(pnl1);
        
        CDD=new JLabel("Current date");
		CDD.setForeground(Color.white);
		CDD.setBounds(90, 20,120,30);
		CDD.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,20));
		pnl1.add(CDD);

		cd=new JLabel("");
		cd.setBounds(260, 20,180,30);
		cd.setForeground(Color.white);
	    cd.setBorder(BorderFactory.createLineBorder(Color.white,1));
		pnl1.add(cd);
		
		
		
        CTT=new JLabel("Current time");
	    CTT.setForeground(Color.white);
		CTT.setBounds(90, 70,120,30);
		CTT.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,20));
		pnl1.add(CTT);

        ct=new JLabel("");
		ct.setBorder(BorderFactory.createLineBorder(Color.white,1));
		ct.setBounds(260, 70,180,30);
		ct.setForeground(Color.white);
		pnl1.add(ct);
		//---------------------------------------
		
		DAYS=new JLabel("DAYS");
	    DAYS.setForeground(new Color(0,0,128));
		DAYS.setBounds(90, 470,180,30);
		DAYS.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,16));
		add(DAYS);

		days=new JLabel("");
		days.setBounds(150, 470,180,30);
		days.setBorder(BorderFactory.createLineBorder(Color.black,1));
	    //days.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,16));
		add(days);
	
		HRS=new JLabel("HOURS");
	    HRS.setForeground(new Color(0,0,128));
		HRS.setBounds(350, 470,180,30);
		HRS.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,16));
		add(HRS);

		hours=new JLabel("");
		hours.setBounds(420, 470,180,30);
		hours.setBorder(BorderFactory.createLineBorder(Color.black,1));
	   	add(hours);
		
	   	BILL=new JLabel("BILL");
	    BILL.setForeground(new Color(0,0,128));
		BILL.setBounds(260, 520,180,30);
		BILL.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,16));
		add(BILL);

	   	bill=new JLabel("");
	   	bill.setBorder(BorderFactory.createLineBorder(Color.black,1));
	   	bill.setBounds(310, 520,180,30);
		bill.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,16));
		add(bill);
		
		//---------------------------------------------------
        
		ftch=new JButton("FETCH");
		ftch.setBounds(400, 50, 100,30);
		ftch.setBackground(new Color(255,69,0));
		ftch.setForeground(Color.white);
		ftch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		       playSound("click.wav");
		       lala();
			}});
		add(ftch);
		
		calc=new JButton("calculate");
		calc.setBounds(50, 600, 100,30);
		calc.setBackground(new Color(255,69,0));
		calc.setForeground(Color.white);
		add(calc);
		calc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				playSound("click.wav");
				DateDifference();
			
			}});
		
		done=new JButton("Done");
		done.setBounds(210, 600, 100,30);
		done.setBackground(new Color(255,69,0));
		done.setForeground(Color.white);
        add(done);
        done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound("click.wav");
		  		try{
		  			pst=con.prepareStatement("update parking_layout set status=0 where slots=? ");
					pst.setString(1, (String) s1.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"record updated");
					
					pst=con.prepareStatement("insert into exitaa values(?,?,?,?,?,?,?)");
				    pst.setString(1,(String) v.getSelectedItem());
					pst.setString(2, cd.getText());
					pst.setString(3, ct.getText());
					pst.setString(4, bill.getText());
					pst.setString(5,  days.getText());
					pst.setString(6, hours.getText());
				    pst.setInt(7, 0);
				   // pst.setString(8,s1.getText() );
					int res=pst.executeUpdate();
					JOptionPane.showMessageDialog(null,res+"record saved");
										
					sms();
					
		  		}
		  		catch(SQLException nex)
				{
				nex.printStackTrace();
				}
			}
			});
        
		print=new JButton("Print");
		print.setBounds(360, 600, 100,30);
		print.setBackground(new Color(255,69,0));
		print.setForeground(Color.white);
	    add(print);
	    print.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		playSound("click.wav");
	    		try
	    		{
	    			MessageFormat header = new MessageFormat("Page {0,number,integer}");
	    			tablehyr();
	    			//table.print();
	    			table.print(JTable.PrintMode.FIT_WIDTH, header, null); 
	    		}
	    		catch(PrinterException e1){
	    			e1.printStackTrace();
	    		}
	    	}
	    });
		
	    JButton close=new JButton("Close");
      close.setBounds(530, 600, 100,30);
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
		
		setSize(700,700);	
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	//---------------------------------------------------
	
	void lala()
    {
    	try {
    		boolean r=false;
    		String sql = "Select * from entry where VNo=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, (String) v.getSelectedItem());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				r=true;
				String ss=String.valueOf(rs.getInt("floor"));
				f1.setText(ss);
				
				String ss1=String.valueOf(rs.getInt("slots"));
				s1.setText(ss1);

				String ss2=String.valueOf(rs.getInt("wheeler"));
				w1.setText(ss2);

				String ss3=String.valueOf(rs.getString("date"));
				d1.setText(ss3);

				String ss4=String.valueOf(rs.getString("time"));
				t1.setText(ss4);
				
				/*Date date = new Date();
                String ss5 = String.format("%1$s %2$tB %2$td, %2$tY","", date);
                ct.setText(ss5);*/
            
			    Calendar cal = Calendar.getInstance();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       	     cd.setText(dateFormat.format(cal.getTime()));
       	        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
             ct.setText(sdf.format(cal.getTime()));
         }
			}
			catch(Exception nex)
			{
			nex.printStackTrace();
			}
    	}
	void DateDifference() {

		    String dateStart = d1.getText();
		    String timeStart=  t1.getText();
			String dateStop = cd.getText();
			String timeStop= ct.getText();
			
			String start= dateStart.concat(timeStart);
			String stop= dateStop.concat(timeStop);
			//System.out.println(dateStart+"     "+timeStart+"      "+dateStop+"        "+ timeStop+"       "+start+"       "+stop);
			
			//HH converts hour in 24 hours format (0-23), day calculation
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
			
			Date d1 = null;
			Date d2 = null;
                    try {
				d1 = format.parse(start);
				d2 = format.parse(stop);

				//in milliseconds
				long diff = d2.getTime() - d1.getTime();

				long diffSeconds = diff / 1000 % 60;
				long diffMinutes = diff / (60 * 1000) % 60;
				long diffHours = diff / (60 * 60 * 1000) % 24;
				long diffDays = diff / (24 * 60 * 60 * 1000);
				
				days.setText(String.valueOf(diffDays));
				
				//System.out.println(diffDays+"     "+diffHours+"     "+diffMinutes+"      "+diffSeconds);
                hours.setText(String.valueOf(diffHours)+":"+String.valueOf(diffMinutes)+":"+String.valueOf(diffSeconds));
                long time=0;
                time= (diffDays*24*60*60)+(diffHours*60*60)+(diffMinutes*60)+(diffSeconds);
               // System.out.println(time);
                double garageCost = 0;

                if(time<=10800)//3 hrs
                    garageCost = 5;

                else if(time>10800 && time<=68400)// >3 hrs && <19 hrs
                    garageCost = 5 + 1*((time - 10800)/3600);

                else if (time >68400)// >19 hrs
                    garageCost = 20;

                bill.setText(String.valueOf(garageCost)+" Rs");

			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	//-------------------------------------------------
	void sms()
	{
		String lcnc=null,mobile=null;
		 try {
			pst=con.prepareStatement("Select * from entry where VNo=?");
		
 		pst.setString(1, (String)v.getSelectedItem());
 		ResultSet res1=pst.executeQuery();
 		while(res1.next())
 		{
 			lcnc=res1.getString("LNo");
 		}
 		pst=con.prepareStatement("Select * from registration where LNo=?");
 		pst.setString(1,lcnc);
 		ResultSet res2=pst.executeQuery();
 		while(res2.next())
 		{
 		mobile=res2.getString("mobile");
 		}
		//String mob=JOptionPane.showInputDialog("Enter Mobile No.");
		String msg=SST_SMS.bceSunSoftSend(mobile,"Ur Bill is: "+bill.getText()+".......THANKS FOR VISTING.....");
        if(msg.equals("sent"))
        	JOptionPane.showMessageDialog(null,msg);
        else
        	JOptionPane.showMessageDialog(null,"Internet connection problem");
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	//---------------------------------------------------
	void tablehyr()
	{
	try {
		
		pst=con.prepareStatement("update exitaa set status=1 where VNo=? ");
		pst.setString(1, (String) v.getSelectedItem());
		pst.executeUpdate();
		
		Class.forName("com.mysql.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_parking","root","bce");
	String sql = "Select VNo,cd,ct,bill,days,hours from exitaa where status=1";
	pst = con.prepareStatement(sql);
	ResultSet rs = pst.executeQuery();
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
	pst.close();
	table = new JTable(data,columnNames);
	JScrollPane scrollPane = new JScrollPane( table );
	table.setBackground(new Color(0,0,128));
	table.setForeground(Color.white);
	table.setSelectionBackground(new Color(0,0,128));
	//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar 
	scrollPane.setBounds(50, 100, 400, 200);
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

public class exit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new sixth();
	}

}
