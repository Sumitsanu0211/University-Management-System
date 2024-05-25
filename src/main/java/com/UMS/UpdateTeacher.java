package com.UMS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.*;
import com.toedter.calendar.*;

public class UpdateTeacher extends JFrame implements ActionListener {
	
	JTextField tfcourse, tffname, tfaddress, tfphone, tfemail, tfbranch;
	JLabel labelrollno;
	
	Choice cEmpId;
	JButton submit, cancel;
	
	UpdateTeacher(){
		setSize(900, 650);
		setLocation(350, 50);
		setLayout(null);
		
		
		JLabel heading = new JLabel("Update Teacher Details");
		heading.setBounds(50,10,500,50);
		heading.setFont(new Font("Tahoma", Font.ITALIC, 35));
		add(heading);
		
		JLabel lblrollno = new JLabel("Select Employee Id");
		lblrollno.setBounds(50, 100, 200, 20);
		heading.setFont(new Font("serif", Font.PLAIN, 20));
		add(lblrollno);
		
		cEmpId = new Choice();
		cEmpId.setBounds(250, 100, 200, 20);
		add(cEmpId);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from teacher");
			while(rs.next()) {
				cEmpId.add(rs.getString("rollno"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel lblname = new JLabel("New Teacher Details");
		lblname.setBounds(50,150,100,30);
		lblname.setFont(new Font("serif", Font.BOLD, 20));
		add(lblname);
		
		JLabel labelname  = new JLabel();
		labelname.setBounds(200, 150,150, 30);
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 10));
		add(labelname);
		
		JLabel lblfname = new JLabel("Father's Name");
		lblfname.setBounds(400,150,200,30);
		lblfname.setFont(new Font("serif", Font.BOLD, 20));
		add(lblfname);
		
		JLabel labelfname = new JLabel();
		labelfname.setBounds(600, 150,150, 30);
		lblname.setFont(new Font("Tahoma", Font.BOLD, 10));
		add(labelfname);
		
		JLabel lblrollNo = new JLabel("Employee Id");
		lblrollNo.setBounds(50,200,200,30);
		lblrollNo.setFont(new Font("serif", Font.BOLD, 20));
		add(lblrollNo);
		
		labelrollno  = new JLabel();
		labelrollno.setBounds(200,200,200,30);
		labelrollno.setFont(new Font("Tahoma", Font.BOLD, 10));
		add(labelrollno);
		
		JLabel lbldob = new JLabel("Date Of Birth");
		lbldob.setBounds(400,200,200,30);
		lbldob.setFont(new Font("serif", Font.BOLD, 20));
		add(lbldob);
		
		JLabel labeldob = new JLabel();
		labeldob.setBounds(600, 200, 150, 30);
		labeldob.setFont(new Font("Tahoma", Font.BOLD, 10));
		add(labeldob);
		
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
		
		JLabel labelx = new JLabel();
		labelx.setBounds(600, 300,150, 30);
		labelx.setFont(new Font("Tahoma", Font.BOLD, 10));
		add(labelx);
		
		JLabel lblxii = new JLabel("Class XIIth %age");
		lblxii.setBounds(50,350,200,30);
		lblxii.setFont(new Font("serif", Font.BOLD, 20));
		add(lblxii);
		
		JLabel labelxii = new JLabel();
		labelxii.setBounds(200, 350,150, 30);
		labelxii.setFont(new Font("Tahoma", Font.BOLD, 10));
		add(labelxii);
		
		JLabel lbladhaar = new JLabel("Adhaar Number");
		lbladhaar.setBounds(400,350,200,30);
		lbladhaar.setFont(new Font("serif", Font.BOLD, 20));
		add(lbladhaar);
		
		JLabel labeladhaar = new JLabel();
		labeladhaar.setBounds(600, 350,150, 30);
		labeladhaar.setFont(new Font("Tahoma", Font.BOLD, 10));
		add(labeladhaar);
		
		JLabel lblcourse = new JLabel("Education");
		lblcourse.setBounds(50,400,200,30);
		lblcourse.setFont(new Font("serif", Font.BOLD, 20));
		add(lblcourse);
		
		
		
		tfcourse = new JTextField();
		tfcourse.setBounds(200, 400, 150, 30);
		tfcourse.setBackground(Color.white);
		add(tfcourse);
		
		JLabel lblbranch = new JLabel("Department");
		lblbranch.setBounds(400,400,200,30);
		lblbranch.setFont(new Font("serif", Font.BOLD, 20));
		add(lblbranch);
		
		try {
			Conn c = new Conn();
			String query = "select * from teacher where empId = '"+cEmpId.getSelectedItem()+"'";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()){
				labelname.setText(rs.getString("name"));
				labelfname.setText(rs.getString("fname"));
				labeldob.setText(rs.getString("dob"));
				tfaddress.setText(rs.getString("address"));
				tfphone.setText(rs.getString("phone"));
				tfemail.setText(rs.getString("email"));
				labelx.setText(rs.getString("x"));
				labelxii.setText(rs.getString("xii"));
				labeladhaar.setText(rs.getString("adhaar"));
				labelrollno.setText(rs.getString("Empid"));
				tfcourse.setText(rs.getString("education"));
				tfbranch.setText(rs.getString("department"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		cEmpId.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				try {
					Conn c = new Conn();
					String query = "select * from student where rollno = '"+cEmpId.getSelectedItem()+"'";
					ResultSet rs = c.s.executeQuery(query);
					while(rs.next()){
						labelname.setText(rs.getString("name"));
						labelfname.setText(rs.getString("fname"));
						labeldob.setText(rs.getString("dob"));
						tfaddress.setText(rs.getString("address"));
						tfphone.setText(rs.getString("phone"));
						tfemail.setText(rs.getString("email"));
						labelx.setText(rs.getString("x"));
						labelxii.setText(rs.getString("xii"));
						labeladhaar.setText(rs.getString("adhaar"));
						labelrollno.setText(rs.getString("EmpId"));
						tfcourse.setText(rs.getString("education"));
						tfbranch.setText(rs.getString("department"));
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		});
        
		
		tfbranch = new JTextField();
		tfbranch.setBounds(600, 400, 150, 30);
		tfbranch.setBackground(Color.white);
		add(tfbranch);
		
		submit = new JButton("Update");
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
		submit.addActionListener(this);
		cancel.setFont(new Font("serif", Font.BOLD, 16));
		add(cancel);
		
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == submit) {
			
			String EmpId = labelrollno.getText();
			String address = tfaddress.getText();
			String email = tfemail.getText();
			String phone = tfphone.getText();
			String course = tfcourse.getText();
			String department = tfbranch.getText();
			
			try {
				String query = "update teacher set address = '"+EmpId+"',  '"+address+"', '"+email+"', '"+phone+"',    '"+course+"', '"+department+"' where EmpId='"+EmpId+"'";
				Conn con = new Conn();
				con.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Student Details updated Successfully");
				setVisible(false);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			setVisible(false);
		}
		
	}
	public static void main(String [] args) {
		new UpdateTeacher();
		
	}

}