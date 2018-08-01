package swings;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

 class third extends JFrame
{
	Connection con;
	JPanel pnl;
    JLabel f,c,parking;
    JTextField cfld;
    JComboBox floor;
    JRadioButton two,four;
    JButton sv,close,updt;
    PreparedStatement pst;
    third()
	 {
	 setTitle("Parking Layout");
     JFrame.setDefaultLookAndFeelDecorated(true);
	  setLayout(null);
	  setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
	  getContentPane().setBackground(new Color(190,190,190));
		con=connection.doConnect();
		/* if(con!=null)
		{
			JOptionPane.showMessageDialog(null, "Connected to server");
			
		}
		else
			JOptionPane.showMessageDialog(null,"Connection problem");*/
		
		pnl=new JPanel();
		pnl.setLayout(new FlowLayout());
		pnl.setBounds(50, 50, 500, 70);
		pnl.setBackground(new Color(0,0,128));
		pnl.setVisible(true);
		pnl.setBorder(BorderFactory.createBevelBorder(HEIGHT));
        add(pnl);
		
		parking=new JLabel("Parking Layout");
		parking.setFont(new Font("Britannic Bold",Font.BOLD,40));
		parking.setForeground(Color.WHITE);
		parking.setBounds(135, 50, 500, 80);
		pnl.add(parking);
    
		f=new JLabel("Floor");
		f.setForeground(new Color(0,0,128));
		f.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,20));
		f.setBounds(100, 200,180,30);
		add(f);
		String[] floors={"1","2"};
		floor=new JComboBox(floors);
		floor.setBounds(300, 200, 130, 30);
		add(floor);
		
		c=new JLabel("Capacity: ");
		c.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,20));
		c.setForeground(new Color(0,0,128));
		c.setBounds(100, 250,180,30);
		add(c);
		
		cfld=new JTextField();
		cfld.setBounds(300,250,120,30);
		cfld.setBorder(BorderFactory.createLineBorder(Color.black,1));
		cfld.setForeground(Color.white);
		cfld.setCaretColor(Color.white);
		cfld.setBackground(new Color(0,0,128));
		cfld.setFont(new Font("Baskerville Old Face Regular",Font.ITALIC,14));
		add(cfld);
        
		two=new JRadioButton("2 Wheeler");
		four=new JRadioButton("4 Wheeler");
		
		ButtonGroup grp=new ButtonGroup();
		grp.add(two);
		grp.add(four);
        
		Dimension dim=two.getPreferredSize();
		two.setBounds(180, 350, dim.width,dim.height);
		four.setBounds(330, 350, dim.width,dim.height);
		
		add(two);
		add(four);
		
		sv=new JButton("Save");
		sv.setBounds(150, 450, 100,30);
		sv.setBackground(new Color(255,69,0));
		sv.setForeground(Color.white);
		add(sv);
		sv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			playSound("click.wav");
				try {
					int w = 0;
					for(int i=1;i<=Integer.parseInt(cfld.getText());i++)
					{
						pst=con.prepareStatement("insert ignore into parking_layout(floor,slots,wheeler,status) values(?,?,?,?)");
						pst.setString(1,(String) floor.getSelectedItem());
						pst.setInt(2, i);	
					  			
				    if(two.isSelected())
				    	w=2;
					else if(four.isSelected())
						w=4;
					pst.setInt(3, w);
					pst.setInt(4,0);
					 pst.executeUpdate();
					 
					 
					}
					JOptionPane.showMessageDialog(null,"record saved");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
		});
		

		/*updt=new JButton("Update");
		updt.setBounds(240, 500, 100,30);
		updt.setBackground(new Color(255,69,0));
		updt.setForeground(Color.white);
		add(updt);
		updt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			playSound("click.wav");
				try {
					int w = 0;
									
					for(int j=1;j<=Integer.parseInt(cfld.getText());j++)
					{
					pst=con.prepareStatement("update parking_layout set floor=?,slots=?,wheeler=?,status=? where wheeler='2' or wheeler='4'");
					pst.setString(1,(String) floor.getSelectedItem());
					pst.setInt(2, j);	
					  			
				    if(two.isSelected())
				    	w=2;
					else if(four.isSelected())
						w=4;
					pst.setInt(3, w);
					pst.setInt(4,0);
					 pst.executeUpdate();
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
		});*/
		
		close=new JButton("Close");
		close.setBounds(350, 450, 100,30);
		close.setBackground(new Color(255,69,0));
		close.setForeground(Color.white);//new Color(210,180,140));
		add(close);
		close.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				playSound("click.wav");
				dispose();
				
			}
		});
		
		
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
		class  parking_layout
		{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    new third();
	}

}
