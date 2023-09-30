package bank_management_system;
import java.awt.Image;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class BalanceEnquiry extends JFrame implements ActionListener{
	JButton back;
	String pin;
	
		BalanceEnquiry(String pin){
			setTitle("Balance Enquiry");
			this.pin=pin;
			setLayout(null);
			ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
			Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
			ImageIcon i3=new ImageIcon(i2);
			JLabel image=new JLabel(i3);
			image.setBounds(0,0,900,900);
			add(image);
			
	  back=new JButton("Back");
	  back.setBounds(355,520,150,30);
	  back.addActionListener(this);
	  image.add(back);
	  
	  //note: added connection to constructor, so we get the balance as soon as page opens(no need to press button)
	  
		Conn c=new Conn();
		int balance=0;
		try {
			//check if balance is there
			ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pin+"'");
		
			//loop all the values
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					//Because in table column is named as amoun not amount
					balance +=Integer.parseInt(rs.getString("amoun"));
				}else {
					balance -=Integer.parseInt(rs.getString("amoun"));
				}
			}
	  
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel text=new JLabel("Your Current Account Balance: Rs " +balance);
		text.setForeground(Color.white);
		text.setBounds(170,300,400,30);
		image.add(text);
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
		}
		public void actionPerformed(ActionEvent ae) {
			setVisible(false);
			new Transactions(pin).setVisible(true);
		}
	public static void main(String[] args) {
		new BalanceEnquiry(" ");
	}

}
