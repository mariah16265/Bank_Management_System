package bank_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import java.awt.*;
public class PinChange  extends JFrame implements ActionListener{
	JLabel image,text,pintext,repintext;
	JPasswordField pin1,repin;
	JButton change,back;
	String pin;
	PinChange(String pin){	
		this.pin=pin;
		setLayout(null);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);	
		ImageIcon i3=new ImageIcon(i2);
		image=new JLabel(i3);
		image.setBounds(0,0,900,900);		
		add(image);
		
		text=new JLabel("Change your PIN");
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(250,280,500,35);
		image.add(text);
		
		pintext=new JLabel("New PIN");
		pintext.setForeground(Color.white);
		pintext.setFont(new Font("System",Font.BOLD,16));
		pintext.setBounds(165,320,180,25);
		image.add(pintext);

		pin1=new JPasswordField();
		pin1.setFont(new Font("Raleway",Font.BOLD,25));
		pin1.setBounds(330,320,180,25);
		image.add(pin1);
		
		repin=new JPasswordField();
		repin.setFont(new Font("Raleway",Font.BOLD,25));
		repin.setBounds(330,360,180,25);
		image.add(repin);
		
		change=new JButton("CHANGE");
		change.setBounds(355,485,150,30);
		change.addActionListener(this);
		image.add(change);
			
		back=new JButton("BACK");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
		
		repintext=new JLabel("Re-Enter New PIN");
		repintext.setForeground(Color.white);
		repintext.setFont(new Font("System",Font.BOLD,16));
		repintext.setBounds(165,360,180,25);
		image.add(repintext);
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true); //so taskbar at top is removed
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
	    try {
	        String npin = pin1.getText();
	        String rpin = repin.getText();

	        if (!npin.equals(rpin)) {
	            JOptionPane.showMessageDialog(null, "Entered PINs do not match");
	            return;
	        }

	        if (ae.getSource() == change) {
	            if (npin.isEmpty() || rpin.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "Please enter both New PIN and Re-Enter PIN");
	                return;
	            }

	            // Validate that the new PIN contains only digits and has the desired length
	            if (!npin.matches("\\d{4}")) {
	                JOptionPane.showMessageDialog(null, "PIN must be a 4-digit number");
	                return;
	            }

	            Conn c1 = new Conn();

	            // Use prepared statements to prevent SQL injection
//? is replaced with the value of npin.
//The second ? is replaced with the value of pin.	            
	            String updateQuery1 = "UPDATE bank SET pin = ? WHERE pin = ?";
	            String updateQuery2 = "UPDATE login SET pin = ? WHERE pin = ?";
	            String updateQuery3 = "UPDATE signupthree SET pin = ? WHERE pin = ?";
//Prepared statements are used to perform the database updates. Prepared statements are precompiled SQL statements 
//that can be reused with different parameter values, making them more secure and efficient.
	            PreparedStatement ps1 = c1.c.prepareStatement(updateQuery1);
	            PreparedStatement ps2 = c1.c.prepareStatement(updateQuery2);
	            PreparedStatement ps3 = c1.c.prepareStatement(updateQuery3);
//Parameters are placeholders in the SQL query that will be replaced with actual values when the query is executed. This helps prevent SQL injection.
//For each prepared statement (ps1, ps2, and ps3), two parameters are set:

	            // Set the parameters for the prepared statements
	            ps1.setString(1, npin);
	            ps1.setString(2, pin);

	            ps2.setString(1, npin);
	            ps2.setString(2, pin);

	            ps3.setString(1, npin);
	            ps3.setString(2, pin);

	            // Execute the prepared statements
	            ps1.executeUpdate();
	            ps2.executeUpdate();
	            ps3.executeUpdate();

	            JOptionPane.showMessageDialog(null, "PIN changed successfully");
	            setVisible(false);
	            new Transactions(rpin).setVisible(true);
	        } else if (ae.getSource() == back) {
	            new Transactions(pin).setVisible(true);
	            setVisible(false);
	        }
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "An error occurred while changing the PIN");
	        e.printStackTrace();
	    }
	}

	public static void main(String[] args) {
	    new PinChange("").setVisible(true);
	}
}