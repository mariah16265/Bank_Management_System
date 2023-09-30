package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener{
		
	JTextField nameTextField,fnameTextField,emailTextField,
	cityTextField,addressTextField,pinTextField,stateTextField,pan,aadhar;
		
	JLabel additionalDetails,name,fname,dob,gender,email,
	state,city,pincode,marital,address;
	
	JRadioButton syes,sno,eyes,eno;
	
	ButtonGroup gendergroup,maritalgroup,emaritalgroup;
	
	JButton next;
	String formno;
	JComboBox religion,category,income,education,occupation;
	
	SignUpTwo(String formno){
		
		this.formno=formno;
		
		setLayout(null);	//if you want to give custom layout (to use Setbounds)
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
				
		additionalDetails=new JLabel("Page 1: Additional Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		additionalDetails.setBounds(290,80,400,30);
		add(additionalDetails);
		
		name=new JLabel("Religion: ");
		name.setFont(new Font("Raleway", Font.BOLD, 22));
		name.setBounds(100,140,200,30);
		add(name);
		
		//pass an array of String
		String valReligion[]={"Muslim","Hindu","Sikh","Christian","Other"};
		religion= new JComboBox (valReligion);
		religion.setBounds(300,140,400,30);
		religion.setBackground(Color.white);
		add(religion);
		
		fname=new JLabel("Category: ");
		fname.setFont(new Font("Raleway", Font.BOLD, 22));
		fname.setBounds(100,190,200,30);
		add(fname);
				
		String valCategory[]= {"General","OBC","SC","ST","Other"};
		category= new JComboBox(valCategory);
		category.setBounds(300,190,400,30);
		category.setBackground(Color.white);
		add(category);
		
		dob=new JLabel("Income: ");
		dob.setFont(new Font("Raleway", Font.BOLD, 22));
		dob.setBounds(100,240,200,30);
		add(dob);
		
		String incomeCategory[]= {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
		income= new JComboBox(incomeCategory);
		income.setBounds(300,240,400,30);
		income.setBackground(Color.white);
		add(income);
			
		gender=new JLabel("Educational: ");
		gender.setFont(new Font("Raleway", Font.BOLD, 22));
		gender.setBounds(100,290,200,30);
		add(gender);
		
		email=new JLabel("Qualification: ");
		email.setFont(new Font("Raleway", Font.BOLD, 22));
		email.setBounds(100,317,200,30);
		add(email);
		
		String educationValues[]= {"Non-graduate","Graduate","Post-Graduation","Docterate","Others"};
		education= new JComboBox(educationValues);
		education.setBounds(300,315,400,30);
		education.setBackground(Color.white);
		add(education);
			
		marital=new JLabel("Occupation: ");
		marital.setFont(new Font("Raleway", Font.BOLD, 22));
		marital.setBounds(100,390,200,30);
		add(marital);
		
		String occupationValues[]= {"Salaried","Self-Employed","Business","Student","Retired","Others"};
		occupation= new JComboBox(occupationValues);
		occupation.setBounds(300,390,400,30);
		occupation.setBackground(Color.white);
		add(occupation);
		
		
		address=new JLabel("PAN Number: ");
		address.setFont(new Font("Raleway", Font.BOLD, 22));
		address.setBounds(100,440,200,30);
		add(address);
		
		pan=new JTextField();
		pan.setFont(new Font("Raleway", Font.BOLD, 20));
		pan.setBounds(300,440,400,30);
		add(pan);
		
		
		city=new JLabel("Aadhar Number: ");
		city.setFont(new Font("Raleway", Font.BOLD, 22));
		city.setBounds(100,490,200,30);
		add(city);
		
		aadhar= new JTextField();
		aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
		aadhar.setBounds(300,490,400,30);
		add(aadhar);
		
		state=new JLabel("Senior Citizen: ");
		state.setFont(new Font("Raleway", Font.BOLD, 22));
		state.setBounds(100,540,200,30);
		add(state);
		
		
		syes=new JRadioButton("Yes");
		syes.setBounds(300,540,100,30);
		syes.setBackground(Color.white);
		add(syes);
		
		sno=new JRadioButton("No");
		sno.setBounds(450,540,100,30);
		sno.setBackground(Color.white);
		add(sno);
	
		maritalgroup =new ButtonGroup();
		maritalgroup.add(syes);
		maritalgroup.add(sno);


		pincode=new JLabel("Existing Account");
		pincode.setFont(new Font("Raleway", Font.BOLD, 22));
		pincode.setBounds(100,590,200,30);
		add(pincode);
		
		
		eyes=new JRadioButton("Yes");
		eyes.setBounds(300,590,100,30);
		eyes.setBackground(Color.white);
		add(eyes);
		
		
		eno=new JRadioButton("No");
		eno.setBounds(450,590,100,30);
		eno.setBackground(Color.white);
		add(eno);
	
		emaritalgroup =new ButtonGroup();
		emaritalgroup.add(eyes);
		emaritalgroup.add(eno);
		
		
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
		
		//returns obj, typecast to string
		String sreligion=(String)religion.getSelectedItem();
		String scategory=(String)category.getSelectedItem();
		String sincome=(String)income.getSelectedItem();
		String seducation=(String) education.getSelectedItem();
		String soccupation=(String) occupation.getSelectedItem();
		String seniorcitizen=null;
		if(syes.isSelected()){
			seniorcitizen="Yes";
		}
		else if(sno.isSelected()) {
			seniorcitizen="No";
		}
		
		String exisitingaccount=null;
		if(eyes.isSelected()){
			exisitingaccount="Yes";
		}
		else if(eno.isSelected()) {
			exisitingaccount="No";
		}

		String span=pan.getText();
	
		String saadhar=aadhar.getText();
		
		//now put values in database
		
		try {
			Conn c =new Conn();
			String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+exisitingaccount+"')";
			c.s.executeUpdate(query);
			
//Now we create signup3 object for next window in future
			setVisible(false);
			new SignUpThree(formno).setVisible(true);
		}catch(Exception e) {
			System.out.println(e);
		}

	}
	
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignUpTwo("");
	}

}
