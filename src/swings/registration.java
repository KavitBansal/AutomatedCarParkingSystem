package swings;

//import java.awt.Toolkit;
//import java.awt.Dimension;
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

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

class first extends JFrame
{
	Connection con;
	PreparedStatement pst;
	JPanel pnl,pnl1;
	JButton nw,sv,updt,cncl,close,ftch,brwse,delete;
	JLabel lcnc,name,address,city,mb,pic,pp,reg,lerr;
	JTextField lfld,fld1,fld2,fld3,fld4,fld5;
	String picpath;
	final JFileChooser fc=new JFileChooser();
	//Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
	
	first()
	{  
		
      setTitle("Registration");
      JFrame.setDefaultLookAndFeelDecorated(true);
   	  setLayout(null);
	  setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
	  getContentPane().setBackground(new Color(190,190,190));
		
	  con=connection.doConnect();
	  /*  if(con!=null)
		{
			JOptionPane.showMessageDialog(null, "Connected to server");
			
		}
		else
			JOptionPane.showMessageDialog(null,"Connection problem");*/
		
	//----------labels and fields-----------------------------------------------------------------------	              	              
		lcnc=new JLabel("Licence no.");
		lcnc.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,16));
		lcnc.setForeground(new Color(0,0,128));
		lcnc.setBounds(200, 50,180,30);
		add(lcnc);
		
		lfld=new JTextField();
		lfld.setBounds(310,50,120,30);
		lfld.setBorder(BorderFactory.createLineBorder(Color.black,1));
		lfld.setForeground(new Color(255,69,0));
		lfld.setCaretColor(new Color(255,69,0));
		lfld.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,16));
		lfld.requestFocusInWindow();
		lfld.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e)
			{
				if(lfld.getText().length()==0)
					lfld.requestFocus();
				else
				{
					lfld.setBackground(Color.white);
				}
				}
		public void focusGained(FocusEvent e) {
				lfld.setBackground(new Color(0,0,128));
			}
		});
		add(lfld);
		
		pnl1=new JPanel();
		pnl1.setLayout(new FlowLayout());
		pnl1.setBounds(50, 95, 600, 50);
		pnl1.setBackground(new Color(0,0,128));
		//pnl1.setOpaque(false);
		pnl1.setVisible(true);
		pnl1.setBorder(BorderFactory.createBevelBorder(HEIGHT));
        add(pnl1);
		
		reg=new JLabel("Customer Registration");
		reg.setFont(new Font("Britannic Bold",Font.BOLD,30));
		reg.setForeground(Color.WHITE);//new Color(165,42,42));
		//reg.setBackground(Color.white);
		reg.setBounds(135, 10, 500, 40);
		pnl1.add(reg);

		pnl=new JPanel();
		pnl.setLayout(null);
		pnl.setBounds(50,150, 600,370);
		pnl.setBackground(new Color(238,232,170));
		pnl.setVisible(true);
		//Font font=new Font("Britannic Bold",Font.BOLD,40);
		pnl.setBorder(BorderFactory.createBevelBorder(HEIGHT));
		//BorderFactory.createLineBorder(Color.black,3),"Customer Info",TitledBorder.CENTER,0,font, new Color(165,42,42)));
		add(pnl);
		
		
		name=new JLabel("Name");
		name.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,14));
		name.setForeground(new Color(165,42,42));
		name.setBounds(20,50,120,30);
		pnl.add(name);
		
		address=new JLabel("Address");
		address.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,14));
		address.setForeground(new Color(165,42,42));
		address.setBounds(20, 90,120,30);
		pnl.add(address);
		
		city=new JLabel("City");
		city.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,14));
		city.setForeground(new Color(165,42,42));
		city.setBounds(20, 200,120,30);
		pnl.add(city);
		
		mb=new JLabel("Mobile no.");
		mb.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,14));
		mb.setForeground(new Color(165,42,42));
		mb.setBounds(20, 240,120,30);
		pnl.add(mb);

		pic=new JLabel("Customer pic");
		pic.setFont(new Font("Baskerville Old Face Regular",Font.BOLD,14));
		pic.setForeground(new Color(165,42,42));
        pic.setBounds(20, 280,120,30);
		pnl.add(pic);
		
		
		lerr=new JLabel("");
		lerr.setBounds(280,240,150,30);
		pnl.add(lerr);
		
		fld1=new JTextField();
		fld2=new JTextField();
		fld3=new JTextField();
		fld4=new JTextField();
		fld5=new JTextField();		
		
		fld1.setBounds(120, 50, 150, 30);
		fld2.setBounds(120, 90, 150,90);
		fld3.setBounds(120, 200,150, 30);
		fld4.setBounds(120, 240, 150,30);
		fld5.setBounds(120, 280,150, 30);
		
		fld1.setFont(new Font("Baskerville Old Face Regular",Font.ITALIC,14));
		fld2.setFont(new Font("Baskerville Old Face Regular",Font.ITALIC,14));
		fld3.setFont(new Font("Baskerville Old Face Regular",Font.ITALIC,14));
		fld4.setFont(new Font("Baskerville Old Face Regular",Font.ITALIC,14));
		fld5.setFont(new Font("Baskerville Old Face Regular",Font.ITALIC,14));
		
		fld1.setBorder(BorderFactory.createLineBorder(Color.black,2));
		fld2.setBorder(BorderFactory.createLineBorder(Color.black,2));
		fld3.setBorder(BorderFactory.createLineBorder(Color.black,2));
		fld4.setBorder(BorderFactory.createLineBorder(Color.black,2));
		fld5.setBorder(BorderFactory.createLineBorder(Color.black,2));
		
		fld4.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			String mobile="^[789]\\d{9}$";
			boolean b=fld4.getText().matches(mobile);
			if(b==false)
			{
			lerr.setText("Invalid...");
			lerr.setFont(new Font("Baskerville Old Face Regular",Font.ITALIC,14));
			lerr.setForeground(Color.black);
			fld4.requestFocusInWindow();
			}
			else
			lerr.setText("");
			fld4.setBackground(Color.white);
			}
			@Override
			public void focusGained(FocusEvent e) {
			fld4.setBackground(new Color(190,190,190));
			}
			});
		
		
		pnl.add(fld1);
		pnl.add(fld2);
		pnl.add(fld3);
		pnl.add(fld4);
		pnl.add(fld5);
		
		
		pp=new JLabel("");
		pp.setBounds(450,50,100,120);
	//	pp.setBorder(BorderFactory.createLineBorder(Color.black,3));
		BufferedImage image=null;
        try {
            image=ImageIO.read(new File("add2.png"));
            } catch (IOException e) {
                 // TODO Auto-generated catch block
             e.printStackTrace();
             }
                       Image img=image.getScaledInstance(pp.getWidth(), pp.getHeight(), Image.SCALE_SMOOTH);
		               final ImageIcon imageIcon=new ImageIcon(img);
	                   pp.setIcon(imageIcon);
	
		pnl.add(pp);
		
		//--------------------------------------------------------------
		
		brwse=new JButton("BROWSE");
		brwse.setBounds(450, 180, 100,30);
		brwse.setBackground(new Color(255,69,0));
		brwse.setForeground(Color.white);
		pnl.add(brwse);
		brwse.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				playSound("click.wav");
				int returnval=fc.showOpenDialog(pnl);
	
				if(fc.showSaveDialog(pnl)==JFileChooser.APPROVE_OPTION)
				{
				  picpath=fc.getSelectedFile().getAbsolutePath();
				  ImageIcon full=new ImageIcon(picpath);
				  ImageIcon small=resize_img(full,pp.getWidth(),pp.getHeight());
				  pp.setIcon(small);
				  pp.setBorder(BorderFactory.createLineBorder(Color.black));
				//  pp.add(pnl) ;
				  fld5.setText(picpath);
				}
				
				}
				});

	//------------------------------------------------------------------------------------------	
		
		nw=new JButton("NEW");
		nw.setBounds(100, 550, 100,30);
		nw.setBackground(new Color(255,69,0));
		nw.setForeground(Color.white);
		add(nw);
		nw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   playSound("click.wav");
					int it=JOptionPane.showConfirmDialog(null, "New Record?");
				    if(it==0)
				
					lfld.setText("");
					fld1.setText("");
					fld2.setText("");
					fld3.setText("");
					fld4.setText("");
					fld5.setText("");
					lfld.requestFocusInWindow();		
		}
		});
		
		
		ftch=new JButton("FETCH");
		ftch.setBounds(100, 600, 100,30);
		ftch.setBackground(new Color(255,69,0));
		ftch.setForeground(Color.white);
		//void fetchOne(String id)
	
		ftch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound("click.wav");
			try {
				boolean jasus=false;
		pst=con.prepareStatement("select * from registration where LNo=?");
		pst.setString(1, lfld.getText());
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
		jasus=true;
		lfld.setText(rs.getString(1));
		fld1.setText(rs.getString(2));
		fld2.setText(rs.getString(3));
		fld3.setText(rs.getString(4));
		fld4.setText(rs.getString(5));
		fld5.setText(rs.getString(6));
		
		 ImageIcon full=new ImageIcon(fld5.getText());
		  ImageIcon small=resize_img(full,pp.getWidth(),pp.getHeight());
		  pp.setIcon(small);
		  pp.setBorder(BorderFactory.createLineBorder(Color.black));
		}
		if(jasus==false)
		JOptionPane.showMessageDialog(null, "Invalid Id");
		pst.close();
		} catch (SQLException eX) {
		// TODO Auto-generated catch block
		eX.printStackTrace();
		}
		}
		});
		add(ftch);
		
		
		sv=new JButton("SAVE");
		sv.setBounds(300, 550, 100,30);
		sv.setBackground(new Color(255,69,0));
		sv.setForeground(Color.white);
		add(sv);
		sv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound("click.wav");
				try {
					pst=con.prepareStatement("insert into registration values(?,?,?,?,?,?)");
					pst.setString(1, lfld.getText());
					pst.setString(2, fld1.getText());
					pst.setString(3, fld2.getText());
					pst.setString(4, fld3.getText());
					pst.setString(5, fld4.getText());
					pst.setString(6, picpath);
					
					int res=pst.executeUpdate();
					JOptionPane.showMessageDialog(null,res+"record saved");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}
		});
		
		updt=new JButton("UPDATE");
		updt.setBounds(500, 550, 100,30);
		updt.setBackground(new Color(255,69,0));
		updt.setForeground(Color.white);
		add(updt);
		updt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound("click.wav");
				try {
					pst=con.prepareStatement("update registration set name=?,address=?,city=?,mobile=?,picpath=? where LNo=?");
					pst.setString(6, lfld.getText());
					pst.setString(1, fld1.getText());
					pst.setString(2, fld2.getText());
					pst.setString(3, fld3.getText());
					pst.setString(4, fld4.getText());
					pst.setString(5, picpath);
					
					int res=pst.executeUpdate();
					JOptionPane.showMessageDialog(null,res+"record saved");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}
		});
		
		delete=new JButton("Delete");
		delete.setBounds(460, 50, 100,30);
		delete.setBackground(new Color(255,69,0));
		delete.setForeground(Color.white);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound("click.wav");
				int it=JOptionPane.showConfirmDialog(null,"Delete?");
				if (it==0)
					try {
						pst=con.prepareStatement("delete from registration where LNo=?");
						pst.setString(1, lfld.getText());
						/*pst.setString(2, fld1.getText());
						pst.setString(3, fld2.getText());
						pst.setString(4, fld3.getText());
						pst.setString(5, fld4.getText());
						pst.setString(6, fld5.getText());
						*/
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null,"record deleted");
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				lfld.requestFocusInWindow();
				
			}
		});
		add(delete);
		
		
		cncl=new JButton("CANCEL");
		cncl.setBounds(300, 600, 100,30);
		cncl.setBackground(new Color(255,69,0));
		cncl.setForeground(Color.white);
		cncl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lfld.setText("");
				fld1.setText("");
				fld2.setText("");
				fld3.setText("");
				fld4.setText("");
				fld5.setText("");
				pp.setIcon(imageIcon);
				nw.setEnabled(true);
				ftch.setEnabled(true);
				sv.setEnabled(true);
				updt.setEnabled(true);
				//cncl.setEnabled(true);
				playSound("click.wav");
				lfld.requestFocusInWindow();
			}});
		add(cncl);
		
		close=new JButton("CLOSE");
		close.setBounds(500, 600, 100,30);
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
		
		
		
	setSize(700,700);
	setVisible(true);
	setResizable(false);
	
	setLocationRelativeTo(null);
	  
	 }
	
	ImageIcon resize_img(ImageIcon log,int width,int height)
	{
	Image img=log.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
	ImageIcon bhai=new ImageIcon(img);
	return(bhai);
	
	
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

public class registration {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    new first();
    
    
	}

}
