package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame{
	JLabel bank,mini,card;
	String pin;
	MiniStatement(String pin){
		this.pin=this.pin;
		setTitle("Mini Statement");
		setLayout(null);
		
		mini=new JLabel();
		add(mini);
		
		bank=new JLabel("Indian Bank");
		bank.setBounds(150,20,100,20);
		add(bank);
		
		card=new JLabel();
		card.setBounds(20,80,300,20);
		add(card);
		
		JLabel balance=new JLabel();
		balance.setBounds(20,400,300,20);
		add(balance);
		
		try {
			Conn conn=new Conn();
			
			ResultSet rs=conn.s.executeQuery("select * from login where pin = '"+pin+"'");
			while(rs.next()) {
				//set card number from database to label
				//display only starting 4 char and ending 4 char
				card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX" +rs.getString("cardnumber").substring(12));
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		try {
			Conn conn=new Conn();
			int bal=0;

		//	ResultSet rs=conn.s.executeQuery("select * from bank where pin = '1234'");

			ResultSet rs=conn.s.executeQuery("select * from bank where pin = '"+pin+"'");
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					//Because in table column is named as amoun not amount
					bal +=Integer.parseInt(rs.getString("amoun"));
				}else {
					bal -=Integer.parseInt(rs.getString("amoun"));
				}
				//set card number from database to label
				//display only starting 4 char and ending 4 char
				//using html for space, nbsp puts spaces
                mini.setText(mini.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amoun") + "<br><br><html>");
			
		}
			balance.setText("Current Balance: Rs "+bal);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		mini.setBounds(20,140,400,200);
		setSize(400,600);
		setLocation(20,20);
		getContentPane().setBackground(Color.white);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MiniStatement("");

	}

}
