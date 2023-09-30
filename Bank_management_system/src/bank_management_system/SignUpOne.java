package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame implements ActionListener{
	
	long random;
	
	JTextField nameTextField,fnameTextField,emailTextField,
	cityTextField,addressTextField,pinTextField,stateTextField;
	
	JDateChooser dateChooser;
	
	JLabel personalDetails,name,formno,fname,dob,gender,email,
	state,city,pincode,marital,address;
	
	JRadioButton male,female,married,unmarried,other;
	
	ButtonGroup gendergroup,maritalgroup;
	
	JButton next;
	
	SignUpOne(){
		
		setLayout(null);	//if you want to give custom layout (to use Setbounds)
		Random ran= new Random(); //for printing random numbers
		random= Math.abs((ran.nextLong()% 9000L) + 1000L );
		
		formno=new JLabel("APPLICATION FORM NO. " + random);
		formno.setFont(new Font("Raleway", Font.BOLD, 38));
		formno.setBounds(140,20,600,40);
		add(formno);
		
		personalDetails=new JLabel("Page 1: Personal Details");
		personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		personalDetails.setBounds(290,80,400,30);
		add(personalDetails);
		
		name=new JLabel("Name: ");
		name.setFont(new Font("Raleway", Font.BOLD, 22));
		name.setBounds(100,140,100,30);
		add(name);
		
		nameTextField= new JTextField();
		nameTextField.setFont(new Font("Raleway", Font.BOLD, 20));
		nameTextField.setBounds(300,140,400,30);
		add(nameTextField);
		
		fname=new JLabel("Father's Name: ");
		fname.setFont(new Font("Raleway", Font.BOLD, 22));
		fname.setBounds(100,190,200,30);
		add(fname);
		
		fnameTextField= new JTextField();
		fnameTextField.setFont(new Font("Raleway", Font.BOLD, 20));
		fnameTextField.setBounds(300,190,400,30);
		add(fnameTextField);
		
		dob=new JLabel("Date of Birth: ");
		dob.setFont(new Font("Raleway", Font.BOLD, 22));
		dob.setBounds(100,240,200,30);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300,240,400,30);
		dateChooser.setForeground(new Color(105,105,105));
		add(dateChooser);
		
		gender=new JLabel("Gender: ");
		gender.setFont(new Font("Raleway", Font.BOLD, 22));
		gender.setBounds(100,290,200,30);
		add(gender);
		
		male=new JRadioButton("Male");
		male.setBounds(300,290,60,30);
		male.setBackground(Color.white);
		add(male);
		
		female=new JRadioButton("Female");
		female.setBounds(450,290,120,30);
		female.setBackground(Color.white);
		add(female);
		
		gendergroup =new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		email=new JLabel("Email Address: ");
		email.setFont(new Font("Raleway", Font.BOLD, 22));
		email.setBounds(100,340,200,30);
		add(email);
		
		emailTextField= new JTextField();
		emailTextField.setFont(new Font("Raleway", Font.BOLD, 20));
		emailTextField.setBounds(300,340,400,30);
		add(emailTextField);
		
		marital=new JLabel("Marital Status: ");
		marital.setFont(new Font("Raleway", Font.BOLD, 22));
		marital.setBounds(100,390,200,30);
		add(marital);
		
		married=new JRadioButton("Married");
		married.setBounds(300,390,100,30);
		married.setBackground(Color.white);
		add(married);
		
		unmarried=new JRadioButton("Unmarried");
		unmarried.setBounds(450,390,100,30);
		unmarried.setBackground(Color.white);
		add(unmarried);
		
		other=new JRadioButton("Other");
		other.setBounds(630,390,100,30);
		other.setBackground(Color.white);
		add(other);
		
		maritalgroup =new ButtonGroup();
		maritalgroup.add(married);
		maritalgroup.add(unmarried);
		maritalgroup.add(other);

		
		address=new JLabel("Address: ");
		address.setFont(new Font("Raleway", Font.BOLD, 22));
		address.setBounds(100,440,200,30);
		add(address);
		
		addressTextField= new JTextField();
		addressTextField.setFont(new Font("Raleway", Font.BOLD, 20));
		addressTextField.setBounds(300,440,400,30);
		add(addressTextField);
		
		city=new JLabel("City: ");
		city.setFont(new Font("Raleway", Font.BOLD, 22));
		city.setBounds(100,490,200,30);
		add(city);
		
		cityTextField= new JTextField();
		cityTextField.setFont(new Font("Raleway", Font.BOLD, 20));
		cityTextField.setBounds(300,490,400,30);
		add(cityTextField);
		
		state=new JLabel("Sate: ");
		state.setFont(new Font("Raleway", Font.BOLD, 22));
		state.setBounds(100,540,200,30);
		add(state);
		
		stateTextField= new JTextField();
		stateTextField.setFont(new Font("Raleway", Font.BOLD, 20));
		stateTextField.setBounds(300,540,400,30);
		add(stateTextField);
		
		pincode=new JLabel("Pin Code");
		pincode.setFont(new Font("Raleway", Font.BOLD, 22));
		pincode.setBounds(100,590,200,30);
		add(pincode);
		
		pinTextField= new JTextField();
		pinTextField.setFont(new Font("Raleway", Font.BOLD, 20));
		pinTextField.setBounds(300,590,400,30);
		add(pinTextField);
		
		next=new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBounds(620,660,80,30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.white);
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		String formno=" " + random; //formno is long, if we concatenate with " " it gets converted to String
		String name=nameTextField.getText();
		String fname=fnameTextField.getText();
		String dob= ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
		String gender=null;
		if(male.isSelected()) {
			gender="Male";
		}else if(female.isSelected()) {
			gender="Female";
		}
		String email = emailTextField.getText();
		String marital=null;
		if(married.isSelected()) {
			marital="Married";
		}
		else if(unmarried.isSelected()) {
			marital="Unmarried";
		}else if(other.isSelected()) {
			marital="Other";
		}
		
		String address=addressTextField.getText();
		String city=cityTextField.getText();
		String state=stateTextField.getText();
		String pin=pinTextField.getText();
		
		
		try {
			
			//if name is empty
			if(name.equals("")) {
				//to show a pop-up
				JOptionPane.showMessageDialog(null,"Name can't be blank!");
			}else {
				//call the database
				//first create a connection
				Conn c =new Conn();
				//insert data to mySQL DDL command
				//to insert string variable 
				//"String'"+variable+"'String"
				//use insert into table_name values
				String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
				//now we execute using Conn class
				//DML command
				c.s.executeUpdate(query);
				//NOW create signup table in mySQL, data should get stored in table signup
				
				//close after user fills details
				setVisible(false);
				//second window opens
				//passing formno as parameter to signuptwo, because it is PK, and we need the same 
				new SignUpTwo(formno).setVisible(true);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}
	
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignUpOne().setVisible(true);;
	}

}
