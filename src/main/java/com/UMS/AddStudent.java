package com.UMS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import com.toedter.calendar.*;

public class AddStudent extends JFrame implements ActionListener {
	
	JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfxii, tfadhaar;
	JLabel labelrollno;
	JDateChooser dcdob;
	JComboBox<?> cbcourse, cbbranch;
	JButton submit, cancel;
	Random rn = new Random();
	long first4 = Math.abs((rn.nextLong() % 9000L) + 1000L); 
	AddStudent(){
		setSize(900, 700);
		setLocation(350, 50);
		setLayout(null);
		
		
		JLabel heading = new JLabel("New Student Details");
		heading.setBounds(310,30,500,50);
		heading.setFont(new Font("serif", Font.BOLD, 30));
		add(heading);
		
		JLabel lblname = new JLabel("New Student Details");
		lblname.setBounds(50,150,100,30);
		lblname.setFont(new Font("serif", Font.BOLD, 20));
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(200, 150,150, 30);
		add(tfname);
		
		JLabel lblfname = new JLabel("Father's Name");
		lblfname.setBounds(400,150,200,30);
		lblfname.setFont(new Font("serif", Font.BOLD, 20));
		add(lblfname);
		
		tffname = new JTextField();
		tffname.setBounds(600, 150,150, 30);
		add(tffname);
		
		JLabel lblrollNo = new JLabel("University Roll Number");
		lblrollNo.setBounds(50,200,200,30);
		lblrollNo.setFont(new Font("serif", Font.BOLD, 20));
		add(lblrollNo);
		
		labelrollno  = new JLabel("145"+first4);
		labelrollno.setBounds(200,200,200,30);
		labelrollno.setFont(new Font("serif", Font.BOLD, 20));
		add(labelrollno);
		
		JLabel lbldob = new JLabel("Date Of Birth");
		lbldob.setBounds(400,200,200,30);
		lbldob.setFont(new Font("serif", Font.BOLD, 20));
		add(lbldob);
		
		dcdob = new JDateChooser();
		dcdob.setBounds(600, 200, 150, 30);
		add(dcdob);
		
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(50,250,200,30);
		lbladdress.setFont(new Font("serif", Font.BOLD, 20));
		add(lbladdress);
		
		tfaddress = new JTextField();
		tfaddress.setBounds(200, 250,150, 30);
		add(tfaddress);
		
		JLabel lblphone = new JLabel("Phone");
		lblphone.setBounds(400,250,200,30);
		lblphone.setFont(new Font("serif", Font.BOLD, 20));
		add(lblphone);
		
		tfphone = new JTextField();
		tfphone.setBounds(600, 250,150, 30);
		add(tfphone);
		
		JLabel lblemail = new JLabel("Email Id");
		lblemail.setBounds(50,300,200,30);
		lblemail.setFont(new Font("serif", Font.BOLD, 20));
		add(lblemail);
		
		tfemail = new JTextField();
		tfemail.setBounds(200, 300,150, 30);
		add(tfemail);
		
		JLabel lblx = new JLabel("Class Xth %age");
		lblx.setBounds(400,300,200,30);
		lblx.setFont(new Font("serif", Font.BOLD, 20));
		add(lblx);
		
		tfx = new JTextField();
		tfx.setBounds(600, 300,150, 30);
		add(tfx);
		
		JLabel lblxii = new JLabel("Class XIIth %age");
		lblxii.setBounds(50,350,200,30);
		lblxii.setFont(new Font("serif", Font.BOLD, 20));
		add(lblxii);
		
		tfxii = new JTextField();
		tfxii.setBounds(200, 350,150, 30);
		add(tfxii);
		
		JLabel lbladhaar = new JLabel("Adhaar Number");
		lbladhaar.setBounds(400,350,200,30);
		lbladhaar.setFont(new Font("serif", Font.BOLD, 20));
		add(lbladhaar);
		
		tfadhaar = new JTextField();
		tfadhaar.setBounds(600, 350,150, 30);
		add(tfadhaar);
		
		JLabel lblcourse = new JLabel("Courses");
		lblcourse.setBounds(50,400,200,30);
		lblcourse.setFont(new Font("serif", Font.BOLD, 20));
		add(lblcourse);
		
		String course[] = {"B.Tech", "M.Tech", "BBA", "BCA", "MBA", "MCA"};
		
		cbcourse = new JComboBox(course);
		cbcourse.setBounds(200, 400, 150, 30);
		cbcourse.setBackground(Color.white);
		add(cbcourse);
		
		JLabel lblbranch = new JLabel("Branch");
		lblbranch.setBounds(400,400,200,30);
		lblbranch.setFont(new Font("serif", Font.BOLD, 20));
		add(lblbranch);
		
        String branch[] = {"Computer Science & Engineering", "Mechanical", "Civil Engineering", "Biotechnology", "Information Technlogy", "Electronics"};
		
		cbbranch = new JComboBox(branch);
		cbbranch.setBounds(600, 400, 150, 30);
		cbbranch.setBackground(Color.white);
		add(cbbranch);
		
		submit = new JButton("Submit");
		submit.setBounds(250, 550, 120, 30);
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.addActionListener(this);
		submit.setFont(new Font("serif", Font.BOLD, 16));
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(450, 550, 120, 30);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.addActionListener(this);
		cancel.setFont(new Font("serif", Font.BOLD, 16));
		add(cancel);
		
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == submit) {
			String name = tfname.getText();
			String fname = tffname.getText();
			String rollNo = labelrollno.getText();
			String dob =((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
			String address = tfaddress.getText();
			String email = tfemail.getText();
			String phone = tfphone.getText();
			String x = tfx.getText();
			String xii = tfxii.getText();
			String adhaar = tfadhaar.getText();
			String course = (String) cbcourse.getSelectedItem();
			String branch = (String) cbbranch.getSelectedItem();
			
			try {
				String query = "insert into student values ('"+name+"', '"+fname+"', '"+rollNo+"', '"+dob+"', '"+address+"', '"+email+"', '"+phone+"', '"+x+"', '"+xii+"', '"+adhaar+"', '"+course+"', '"+branch+"')";
				Conn con = new Conn();
				con.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
				setVisible(false);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			setVisible(false);
		}
		
	}
	public static void main(String [] args) {
		new AddStudent();
		
	}

}
