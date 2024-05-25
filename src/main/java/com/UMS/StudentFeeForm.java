package com.UMS;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class StudentFeeForm extends JFrame implements ActionListener {
	
	private static final String String = null;
	Choice crollno;
	JComboBox cbcourse, cbbranch, cbsemester;
	JLabel labeltotal;
	JButton update, pay, back;
	
	StudentFeeForm(){
		setSize(900, 500);
		setLocation(300, 100);
		setLayout(null);
		
		
		
		getContentPane().setBackground(Color.WHITE);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400, 50, 500,300);
		add(image);
		
		JLabel heading = new JLabel();
		heading.setBounds(50,10,500,50);
		heading.setFont(new Font("Tahoma", Font.ITALIC, 35));
		add(heading);
		
		JLabel lblrollno = new JLabel("Select Roll No");
		lblrollno.setBounds(40, 60, 150, 20);
		lblrollno.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblrollno);
		
		crollno = new Choice();
		crollno.setBounds(200, 60, 150, 20);
		add(crollno);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from student");
			while(rs.next()) {
				crollno.add(rs.getString("rollno"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(40,100,150,20);
		lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblname);
		
		JLabel labelname  = new JLabel();
		labelname.setBounds(200, 100,150, 20);
		labelname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(labelname);
		
		JLabel lblfname = new JLabel("Father's Name");
		lblfname.setBounds(40,140,150,20);
		lblfname.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblfname);
		
		JLabel labelfname = new JLabel();
		labelfname.setBounds(200, 140,150, 20);
		lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(labelfname);
		
		try {
			Conn c = new Conn();
			String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()){
				labelname.setText(rs.getString("name"));
				labelfname.setText(rs.getString("fname"));
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		crollno.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				try {
					Conn c = new Conn();
					String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
					ResultSet rs = c.s.executeQuery(query);
					while(rs.next()){
						labelname.setText(rs.getString("name"));
						labelfname.setText(rs.getString("fname"));
						
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		JLabel lblcourse = new JLabel("Courses");
		lblcourse.setBounds(40,180,150,20);
		lblcourse.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblcourse);
		
		String course[] = {"B.Tech", "M.Tech", "BBA", "BCA", "MBA", "MCA"};
		
		cbcourse = new JComboBox(course);
		cbcourse.setBounds(200, 180, 150, 20);
		cbcourse.setBackground(Color.white);
		add(cbcourse);
		
		JLabel lblbranch = new JLabel("Branch");
		lblbranch.setBounds(40,220,150,20);
		lblbranch.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblbranch);
		
        String branch[] = {"Computer Science & Engineering", "Mechanical", "Civil Engineering", "Biotechnology", "Information Technlogy", "Electronics"};
		
		cbbranch = new JComboBox(branch);
		cbbranch.setBounds(200, 220, 150, 20);
		cbbranch.setBackground(Color.white);
		add(cbbranch);
		
		JLabel lblsemester = new JLabel("semester");
		lblsemester.setBounds(40, 260, 150, 20);
		lblsemester.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblsemester);
		
		
		String semester [] = {"1", "2", "3", "4", "5", "6", "7", "8"};
		cbsemester = new JComboBox(semester);
		cbsemester.setBounds(200, 260, 150, 20);
		cbsemester.setBackground(Color.WHITE);
		add(cbsemester);
		
		JLabel lbltotal = new JLabel("Total Payble");
		lbltotal.setBounds(40, 300, 150, 20);
		lbltotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lbltotal);
		
		labeltotal = new JLabel();
		labeltotal.setBounds(200, 300, 150, 20);
		labeltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(labeltotal);
		
		update = new JButton("Update");
		update.setBounds(30, 380, 100, 25);
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.addActionListener(this);
		update.setFont(new Font("serif", Font.BOLD, 16));
		add(update);
		
		pay = new JButton("Pay Fee");
		pay.setBounds(150, 380, 100, 25);
		pay.setBackground(Color.black);
		pay.setForeground(Color.white);
		pay.addActionListener(this);
		pay.setFont(new Font("serif", Font.BOLD, 16));
		add(pay);
		
		
		back = new JButton("Back");
		back.setBounds(270, 380, 100, 25);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		back.setFont(new Font("serif", Font.BOLD, 16));
		add(back);

		
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == update) {
			String course =  (java.lang.String) cbcourse.getSelectedItem();
			String semester =  (java.lang.String) cbsemester.getSelectedItem();
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery("select * from fee where course = '"+course+"'");
				while(rs.next()) {
					labeltotal.setText(rs.getString(semester));
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else if(ae.getSource() == pay) {
			String rollno = crollno.getSelectedItem();
			String course =  (java.lang.String) cbcourse.getSelectedItem();
			String semester =  (java.lang.String) cbsemester.getSelectedItem();
			String branch =  (java.lang.String) cbbranch.getSelectedItem();
			String total = labeltotal.getText();
			
			try {
				Conn c = new Conn();
				String query = "insert into collegefee values('"+rollno+"', '"+course+"', '"+branch+"', '"+semester+"', '"+total+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "College Fee Submitted Successfully");
				setVisible(false);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else {
			setVisible(false);
		}
	}
	public static void main(String [] args) {
		new StudentFeeForm();
	}

}
