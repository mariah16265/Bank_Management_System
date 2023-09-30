package bank_management_system;
import java.awt.Image;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
	JLabel image,text;
	JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
	String pin;
	FastCash(String pin){
		setTitle("Fast Cash");

		this.pin=pin;
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);	
		ImageIcon i3=new ImageIcon(i2);
		image=new JLabel(i3);
		image.setBounds(0,0,900,900);		
		add(image);

		text=new JLabel("Select Withdrawl Amount");
		text.setBounds(210,300,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);	//so it doesnt hide under the image
		
		deposit=new JButton("Rs 100");
		deposit.setBounds(170,415,150,30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawl=new JButton("Rs 500");
		withdrawl.setBounds(355,415,150,30);
		withdrawl.addActionListener(this);

		image.add(withdrawl);
		
		fastcash=new JButton("Rs 1000");
		fastcash.setBounds(170,450,150,30);
		fastcash.addActionListener(this);

		image.add(fastcash);
		
		ministatement=new JButton("Rs 2000");
		ministatement.setBounds(355,450,150,30);
		ministatement.addActionListener(this);

		image.add(ministatement);
		
		pinchange=new JButton("Rs 5000");
		pinchange.setBounds(170,485,150,30);
		pinchange.addActionListener(this);

		image.add(pinchange);
		
		balanceenquiry=new JButton("Rs 10000");
		balanceenquiry.setBounds(355,485,150,30);
		balanceenquiry.addActionListener(this);

		image.add(balanceenquiry);
		
		exit=new JButton("Back");
		exit.setBounds(355,520,150,30);
		exit.addActionListener(this);

		image.add(exit);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true); //so taskbar at top is removed
		setVisible(true);

	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exit) {
			setVisible(false);
			new Transactions(pin).setVisible(true);
		}else {
			//subtract first 3 letter so we dont get Rs only amount
			String amount=((JButton)ae.getSource()).getText().substring(3);
			Conn c=new Conn();
			try {
				//check if balance is there
				ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pin+"'");
				int balance=0;
				//loop all the values
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						//beacause in table column is named as amoun not amount
						balance +=Integer.parseInt(rs.getString("amoun"));
					}else {
						balance -=Integer.parseInt(rs.getString("amoun"));
					}
				}
				//balance is less than amount to be withdrawed
				if(ae.getSource()!=exit && balance<Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				Date date=new Date();
				String query="insert into bank values('"+pin+"','"+date+"','Withdrawl','"+amount+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully!");
				setVisible(false);
				new Transactions(pin).setVisible(true);
			}catch(Exception e) {
				System.out.println(e);
			}
			
		
	}}
	
	public static void main(String[] args) {
		new FastCash("").setVisible(true);;
		
	}

}
