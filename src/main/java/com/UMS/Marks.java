package com.UMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Marks extends JFrame implements ActionListener {
	
	String rollNo;
	JButton cancel;
	
	Marks(String rollNo){
		this.rollNo = rollNo;
		setSize(500, 600);
		setLocation(500, 100);
		
		setLayout(null);
		getContentPane().setBackground(Color.white);
		
		JLabel heading = new JLabel("Chandigarh University");
		heading.setBounds(100,10,500,25);
		heading.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(heading);
		
		JLabel subheading = new JLabel("Examination Result");
		subheading.setBounds(100,50,500,20);
		subheading.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(subheading);
		
		
		JLabel lblrollNo = new JLabel("Roll Number" + rollNo);
		lblrollNo.setBounds(60,100,500,20);
		lblrollNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblrollNo);
		
		JLabel lblsemester = new JLabel();
		lblsemester.setBounds(60,130,500,20);
		lblsemester.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblsemester);
		
		JLabel sub1 = new JLabel();
		sub1.setBounds(100,200,500,20);
		sub1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(sub1);
		
		JLabel sub2 = new JLabel();
		sub2.setBounds(100,230,500,20);
		sub2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(sub2);
		
		JLabel sub3 = new JLabel();
		sub3.setBounds(100,260,500,20);
		sub3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(sub3);
		
		JLabel sub4 = new JLabel();
		sub4.setBounds(100,290,500,20);
		sub4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(sub4);
		
		JLabel sub5 = new JLabel();
		sub5.setBounds(100,320,500,20);
		sub5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(sub5);
		
		try {
			Conn c = new Conn();
			ResultSet rs1 = c.s.executeQuery("select * from subject where rollNo = '"+rollNo+"'");
			while(rs1.next()){
				sub1.setText(rs1.getString("subject1"));
				sub2.setText(rs1.getString("subject2"));
				sub3.setText(rs1.getString("subject4"));
				sub4.setText(rs1.getString("subject4"));
				sub5.setText(rs1.getString("subject5"));
			}
			
			ResultSet rs2 = c.s.executeQuery("select * from marks where rollNo = '"+rollNo+"'");
			while(rs2.next()) {
				sub1.setText(sub1.getText() + "-----------" + rs2.getString("marks1"));
				sub2.setText(sub2.getText() + "-----------" + rs2.getString("marks2"));
				sub3.setText(sub3.getText() + "-----------" + rs2.getString("marks3"));
				sub4.setText(sub4.getText() + "-----------" + rs2.getString("marks4"));
				sub5.setText(sub5.getText() + "-----------" + rs2.getString("marks5"));
				lblsemester.setText("semester" + rs2.getString("semester"));
				
				
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		cancel = new JButton("Back");
		cancel.setBounds(250, 500, 120, 25);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.addActionListener(this);
		cancel.setFont(new Font("serif", Font.BOLD, 16));
		add(cancel);
		
		
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
	}
	public static void main(String [] args) {
		new Marks("");
	}

}
