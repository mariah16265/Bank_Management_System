package bank_management_system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;
public class Withdrawl extends JFrame implements ActionListener{
	
	JLabel text,image ;
	JTextField amount;
	JButton withdraw,back;
	String pin;
	//during deposit we will ask for pin number
		Withdrawl(String pin){
			this.pin=pin;
			setLayout(null);
			ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
			Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
			ImageIcon i3= new ImageIcon(i2);
			
			image=new JLabel(i3);
			image.setBounds(0,0,900,900);
			add(image);
			
			text =new JLabel("Enter Withdraw Amount: ");
			text.setForeground(Color.white);
			text.setFont(new Font("System", Font.BOLD,16));
			text.setBounds(170,300,400,20);
			image.add(text);
			
			amount=new JTextField();
			amount.setFont(new Font("Raleway",Font.BOLD,22));
			amount.setBounds(170,350,320,25);
			image.add(amount);
			
			withdraw=new JButton("Withdraw");
			withdraw.setBounds(355,485,150,30);
			withdraw.addActionListener(this);
			image.add(withdraw);
			
			back=new JButton("Back");
			back.setBounds(355,520,150,30);
			back.addActionListener(this);
			image.add(back);
			
			setSize(900,900);
			setLocation(300,0);
			setVisible(true);
		}// 5040936037064605
		public void actionPerformed(ActionEvent ae) {
		    if (ae.getSource() == withdraw) {
		        String withdrawalAmount = amount.getText();
		        Date date = new Date();

		        if (withdrawalAmount.equals("")) {
		            JOptionPane.showMessageDialog(null, "Enter Amount To Withdraw!");
		        } else {
		            try {
		                Conn conn = new Conn();

		                // Retrieve the total deposited amount
		                ResultSet rs = conn.s.executeQuery("SELECT SUM(amoun) AS total_amount FROM bank WHERE pin='" + pin + "' AND type='Deposit'");
		                int depositedAmount = 0;

		                if (rs.next()) {
		                    depositedAmount = rs.getInt("total_amount");
		                }

		                int withdrawal = Integer.parseInt(withdrawalAmount);

		                if (withdrawal <= depositedAmount) {
		                    // Perform the withdrawal
		                    String query = "INSERT INTO bank VALUES ('" + pin + "','" + date + "','Withdraw','" + withdrawalAmount + "')";
		                    conn.s.executeUpdate(query);
		                    JOptionPane.showMessageDialog(null, "Rs " + withdrawalAmount + " Withdrawn Successfully");
		                    setVisible(false);
		                    new Transactions(pin).setVisible(true);
		                } else {
		                    JOptionPane.showMessageDialog(null, "Insufficient Deposited Balance");
		                }
		            } catch (Exception e) {
		                System.out.println(e);
		            }
		        }
		    } else if (ae.getSource() == back) {
		        setVisible(false);
		        new Transactions(pin).setVisible(true);
		    }
		}

	public static void main(String[] args) {
		new Withdrawl("");
		
	}

}
