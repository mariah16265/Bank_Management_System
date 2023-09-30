package bank_management_system;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.*;
public class SignUpThree extends JFrame implements ActionListener{

	JRadioButton r1,r2,r3,r4;
	JLabel l1,type,card,number,services,pin,pnumber,carddetail,pindetail;
	ButtonGroup groupaccount;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit,cancel;
	String formno;
	
	SignUpThree(String formno){
		this.formno=formno;
		setLayout(null); //for setbounds to work
		l1=new JLabel("Page 3: Account Details");
		l1.setFont(new Font ("Raleway", Font.BOLD,22));
		l1.setBounds(280,40,400,40);
		add(l1);
		
		type=new JLabel("Account Type: ");
		type.setFont(new Font ("Raleway", Font.BOLD,22));
		type.setBounds(100,140,200,30);
		add(type);
		
		r1=new JRadioButton("Saving Account");
		r1.setFont(new Font("Raleway", Font.BOLD,16));
		r1.setBackground(Color.white);
		r1.setBounds(100,180,160,20);
		add(r1);
		
		
		r2=new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font("Raleway", Font.BOLD,16));
		r2.setBackground(Color.white);
		r2.setBounds(350,180,250,20);
		add(r2);
		
		r3=new JRadioButton("Current Account");
		r3.setFont(new Font("Raleway", Font.BOLD,16));
		r3.setBackground(Color.white);
		r3.setBounds(100,220,250,20);
		add(r3);
		
		r4=new JRadioButton("Recurring Account");
		r4.setFont(new Font("Raleway", Font.BOLD,16));
		r4.setBackground(Color.white);
		r4.setBounds(350,220,250,30);
		add(r4);
		
		groupaccount=new ButtonGroup();
		groupaccount.add(r1);
		groupaccount.add(r2);
		groupaccount.add(r3);
		groupaccount.add(r4);
		
		card=new JLabel("Card Number: ");
		card.setFont(new Font ("Raleway", Font.BOLD,22));
		card.setBounds(100,300,200,30);
		add(card);
		
		//dummy card number
		number=new JLabel("XXXX-XXXX-XXXX-4184 ");
		number.setFont(new Font ("Raleway", Font.BOLD,22));
		number.setBounds(330,300,300,30);
		add(number);
		
		carddetail=new JLabel("Your 16 Digit Card Number");
		carddetail.setFont(new Font ("Raleway", Font.BOLD,17));
		carddetail.setBounds(100,330,300,20);
		add(carddetail);
		
		pin=new JLabel("PIN: ");
		pin.setFont(new Font ("Raleway", Font.BOLD,22));
		pin.setBounds(100,370,200,30);
		add(pin);
		
		pnumber=new JLabel("XXXX");
		pnumber.setFont(new Font ("Raleway", Font.BOLD,22));
		pnumber.setBounds(330,370,300,30);
		add(pnumber);
		
		pindetail=new JLabel("Your 4 Digit PIN");
		pindetail.setFont(new Font ("Raleway", Font.BOLD,17));
		pindetail.setBounds(100,400,300,30);
		add(pindetail);
		
		services=new JLabel("Services Required: ");
		services.setFont(new Font ("Raleway", Font.BOLD,17));
		services.setBounds(100,450,400,30);
		add(services);
		
		c1=new JCheckBox("ATM Card");
		c1.setBackground(Color.white);
		c1.setFont(new Font("Raleway",Font.BOLD,16));
		c1.setBounds(100,500,200,30);
		add(c1);
		
		c2=new JCheckBox("Internet Banking");
		c2.setBackground(Color.white);
		c2.setFont(new Font("Raleway",Font.BOLD,16));
		c2.setBounds(350,500,200,30);
		add(c2);
		
		c3=new JCheckBox("Mobile Banking");
		c3.setBackground(Color.white);
		c3.setFont(new Font("Raleway",Font.BOLD,16));
		c3.setBounds(100,550,200,30);
		add(c3);
		
		c4=new JCheckBox("Email & SMS Alerts");
		c4.setBackground(Color.white);
		c4.setFont(new Font("Raleway",Font.BOLD,16));
		c4.setBounds(350,550,200,30);
		add(c4);
		
		c5=new JCheckBox("Cheque Book");
		c5.setBackground(Color.white);
		c5.setFont(new Font("Raleway",Font.BOLD,16));
		c5.setBounds(100,600,200,30);
		add(c5);
		
		c6=new JCheckBox("E-Statement");
		c6.setBackground(Color.white);
		c6.setFont(new Font("Raleway",Font.BOLD,16));
		c6.setBounds(350,600,200,30);
		add(c6);
		
		c7=new JCheckBox("I confirm above entered details are correct");
		c7.setBackground(Color.white);
		c7.setFont(new Font("Raleway",Font.BOLD,16));
		c7.setBounds(100,680,600,30);
		add(c7);

		ButtonGroup services1=new ButtonGroup();
		services1.add(c1);
		services1.add(c2);
		services1.add(c3);
		services1.add(c4);
		services1.add(c5);
		services1.add(c6);
		services1.add(c7);
	
		submit = new JButton("Submit");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setFont(new Font("Raleway", Font.BOLD, 14));
		submit.setBounds(250,720,100,30);
		submit.addActionListener(this);
		add(submit);
		
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Raleway", Font.BOLD, 14));
		cancel.setBounds(420,720,100,30);
		cancel.addActionListener(this);
		add(cancel);
		
		getContentPane().setBackground(Color.white);
		setSize(850,820);
		setLocation(350,0);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
        String atype = null;
        if(r1.isSelected()){ 
            atype = "Saving Account";
        }
        else if(r2.isSelected()){ 
            atype = "Fixed Deposit Account";
        }
        else if(r3.isSelected()){ 
            atype = "Current Account";
        }else if(r4.isSelected()){ 
            atype = "Recurring Deposit Account";
        }
        
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(first7);
        
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);
        
        String facility = "";
        if(c1.isSelected()){ 
            facility = facility + " ATM Card";
        }
        if(c2.isSelected()){ 
            facility = facility + " Internet Banking";
        }
        if(c3.isSelected()){ 
            facility = facility + " Mobile Banking";
        }
        if(c4.isSelected()){ 
            facility = facility + " EMAIL Alerts";
        }
        if(c5.isSelected()){ 
            facility = facility + " Cheque Book";
        }
        if(c6.isSelected()){ 
            facility = facility + " E-Statement";
        }
        
        try{
            if(ae.getSource()==submit){
                
                if(atype.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                }else{
                    Conn c1 = new Conn();
                    String q1 = "insert into signupthree values('"+formno+"','"+atype+"','"+cardno+"','"+pin+"','"+facility+"')";  
                    String q2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:"+ pin);
                    
                    new Deposit(pin).setVisible(true);
                    setVisible(false);
                }
            
            }else if(ae.getSource()==cancel){
                System.exit(0);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    
    public static void main(String[] args){
        new SignUpThree("").setVisible(true);
    }
    
}