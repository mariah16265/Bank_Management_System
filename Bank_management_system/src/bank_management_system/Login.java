package bank_management_system;
import java.awt.Image;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
	
	JButton login, signup,clear; //globally defining them
	JTextField cardTextField;
	JPasswordField pinTextField;
	JLabel cardno1,text,pin1;
	
	
	Login(){
		setTitle("AUTOMATED TELLER MACHINE");
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));
		Image i2= i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2); //passing i2 to convert image to imageicon
		JLabel label = new JLabel(i3);
		label.setBounds(70,10,100,100);
		add(label); 
		
		text=new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward", Font.BOLD, 38));
		text.setBounds(200,40,400,40);
		add(text);
		
		cardno1=new JLabel("Card No.");
		cardno1.setFont(new Font("Raleway", Font.BOLD, 28));
		cardno1.setBounds(120,150,150,30);
		add(cardno1);
		
		cardTextField=new JTextField();
		cardTextField.setBounds(300,150,230,30);
		cardTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(cardTextField);
		
		pin1=new JLabel("PIN:");
		pin1.setFont(new Font("Raleway", Font.BOLD, 28));
		pin1.setBounds(120,220,250,40);
		add(pin1);
		
		pinTextField=new JPasswordField(15);
		pinTextField.setBounds(300,220,230,30);
		pinTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(pinTextField);
		
		login= new JButton("SIGN IN");
		login.setBounds(300,300,100,30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		
	    clear= new JButton("CLEAR");
		clear.setBounds(430,300,100,30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.addActionListener(this);
		add(clear);
		getContentPane().setBackground(Color.white);
		
		signup= new JButton("SIGN UP");
		signup.setBounds(300,350,230,30);
		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		signup.addActionListener(this);
		add(signup);
		
		
		setSize(800,480); //  sets frame dimensions
		setVisible(true);
		setLocation(350,200);	//setting own location		
		
	} 
	public void actionPerformed(ActionEvent ae) {
	    try {
	        if (ae.getSource() == login) {
	            Conn c1 = new Conn();
	            String cardno = cardTextField.getText().trim();
	            String pin2 = pinTextField.getText().trim();

//FOR MORE EXPLINATION CHECK BELOW
	            // Construct the SQL query with parameterized values
	            String query = "SELECT * FROM login WHERE TRIM(cardnumber) = ? AND TRIM(pin) = ?";

//A PreparedStatement is a feature provided by Java Database Connectivity (JDBC) to execute parameterized SQL queries against a database. 
//It's a specific type of JDBC Statement that allows you to pass parameters into the SQL query, providing several benefits:	            
	            
	            try (PreparedStatement preparedStatement = c1.c.prepareStatement(query)) {
	                preparedStatement.setString(1, cardno);
	                preparedStatement.setString(2, pin2);
	                
//The setString method is used to set the value of a placeholder, and it expects two parameters: the index of the placeholder 
//(1 in this case, because it's the first placeholder) and the value to be inserted (the value of the cardno variable).

	                try (ResultSet rs = preparedStatement.executeQuery()) {
//his executes the SQL query with the provided parameter values and returns a ResultSet. The ResultSet contains the results of the query, if any.	                    
	                	if (rs.next()) {
	                        // If data is in the ResultSet, the user has successfully logged in
	                        setVisible(false);
	                        new Transactions(pin2).setVisible(true);
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
	                    }
	                }
	            }
	        } else if (ae.getSource() == clear) {
	            cardTextField.setText("");
	            pinTextField.setText("");
	        } else if (ae.getSource() == signup) {
	            setVisible(false);
	            new SignUpOne().setVisible(true);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "SQL Exception: " + e.getMessage());
	    }
	}
	public static void main(String[] args){
        new Login().setVisible(true);
    }

    
}
//The cardno and pin2 values provided by the user are set as parameters in the prepared statement.
//
//When you execute the query with preparedStatement.executeQuery(), the database server receives the query with these parameter values.
//
//The database performs the query by comparing the trimmed cardnumber and pin columns in the login table with the provided values.
//
//If a row in the table matches both the cardnumber and pin values, the ResultSet returned by the query will have at least one row.
//
//The code checks if rs.next() is true, indicating that a matching record was found. If true, it means the user's login credentials are correct, and it proceeds to show the "Transactions" window.