package com.UMS;
import java.awt.Image;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class project extends JFrame implements ActionListener {
	project(){
		setSize(1560, 890);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1560, 850, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 20, 200,200);
		add(image);
		
		
		JMenuBar mb = new JMenuBar();
		
		JMenu newInformation = new JMenu("New Information");
		newInformation.setForeground(Color.red);
		mb.add(newInformation);
		
		JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
		facultyInfo.setBackground(Color.white);
		facultyInfo.addActionListener(this);
		newInformation.add(facultyInfo);
		
		JMenuItem studentInfo = new JMenuItem("New Student Information");
		studentInfo.setBackground(Color.white);
		studentInfo.addActionListener(this);
		newInformation.add(studentInfo);
		
		JMenu details = new JMenu("View Details");
		details.setForeground(Color.blue);
		mb.add(details);
		
		JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
		facultyDetails.setBackground(Color.white);
		facultyDetails.addActionListener(this);
		details.add(facultyDetails);
		
		JMenuItem studentDetails = new JMenuItem("View Student Details");
		studentDetails.setBackground(Color.white);
		studentDetails.addActionListener(this);
		details.add(studentDetails);
		
		//Leaves
		
		JMenu leave = new JMenu("Apply leaves");
		leave.setForeground(Color.blue);
		mb.add(leave);
		
		JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
		facultyLeave.setBackground(Color.white);
		facultyLeave.addActionListener(this);
		leave.add(facultyLeave);
		
		JMenuItem studentLeave = new JMenuItem("Student Leave");
		studentLeave.setBackground(Color.white);
		studentLeave.addActionListener(this);
		leave.add(studentLeave);
		
		//Leave Details
		
		JMenu leaveDetails = new JMenu("Leave Details");
		leaveDetails.setForeground(Color.red);
		mb.add(leaveDetails);
		
		JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
		facultyLeave.setBackground(Color.white);
		facultyLeaveDetails.addActionListener(this);
		leaveDetails.add(facultyLeaveDetails);
		
		JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
		studentLeave.setBackground(Color.white);
		studentLeaveDetails.addActionListener(this);
		leaveDetails.add(studentLeaveDetails);
		
		//Exams
		
		JMenu exam = new JMenu("Examination");
		exam.setForeground(Color.blue);
		mb.add(exam);
		
		JMenuItem examDetails = new JMenuItem("Examination Results");
		examDetails.setBackground(Color.white);
		examDetails.addActionListener(this);
		exam.add(examDetails);
		
		JMenuItem enterMarks = new JMenuItem("Enter Marks");
		enterMarks.setBackground(Color.white);
		enterMarks.addActionListener(this);
		exam.add(enterMarks);
		
		
		//update Info
		
		JMenu updateInfo = new JMenu("Update Details");
		updateInfo.setForeground(Color.red);
		mb.add(updateInfo);
		
		JMenuItem updatefacultyInfo = new JMenuItem("Update Faculty Details");
		updatefacultyInfo.setBackground(Color.white);
		updatefacultyInfo.addActionListener(this);
		updateInfo.add(updatefacultyInfo);
		
		JMenuItem updatestudentInfo = new JMenuItem("Update Studnent Details");
		updatestudentInfo.setBackground(Color.white);
		updatestudentInfo.addActionListener(this);
		updateInfo.add(updatestudentInfo);
		
		//fees
		
		JMenu fee = new JMenu("Fee Details");
		fee.setForeground(Color.blue);
		mb.add(fee);
		
		JMenuItem feeStructure = new JMenuItem("Fee Structure");
		feeStructure.setBackground(Color.white);
		feeStructure.addActionListener(this);
		fee.add(feeStructure);
		
		JMenuItem feeForm = new JMenuItem("Student Fee Form");
		feeForm.setBackground(Color.white);
		feeForm.addActionListener(this);
		fee.add(feeForm);
		
		//utility
		
		JMenu utility = new JMenu("Utility");
		utility.setForeground(Color.blue);
		mb.add(utility);
		
		JMenuItem notepad = new JMenuItem("Notepad");
		notepad.setBackground(Color.white);
		notepad.addActionListener(this);
		utility.add(notepad);
		
		JMenuItem calc = new JMenuItem("Calculator");
		calc.setBackground(Color.white);
		calc.addActionListener(this);
		utility.add(calc);
		
		//exit
		
		JMenu exit = new JMenu("Exit");
		exit.setForeground(Color.blue);
		mb.add(exit);
		
		JMenuItem ex = new JMenuItem("Exit");
		ex.setBackground(Color.white);
		ex.addActionListener(this);
		exit.add(ex);
		
		
		
		
		
		
		
		
		setJMenuBar(mb);
		setVisible(true);
		
	}
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae) {
		String msg = ae.getActionCommand();
		
		if(msg.equals("Exit")) {
			setVisible(false);
		} else if(msg.equals("Calculator")) {
			try {
				Runtime.getRuntime().exec("calc.exe");
				
			} catch (Exception e){
				
			}
		} else if(msg.equals("Notepad")) {
			try {
				Runtime.getRuntime().exec("notepad.exe");
				
			} catch (Exception e){
				
			}
		} else if(msg.equals("New Faculty Information")) {
			new AddTeacher();
		}else if (msg.equals("New Student Information")) {
			new AddStudent();
		} else if(msg.equals("View Faculty Details")) {
			new TeacherDetails();
		} else if(msg.equals("View Student Details")) {
			new StudentDetails();
		} else if(msg.equals("Faculty Leave")) {
			new TeacherLeave();
		} else if(msg.equals("Student Leave")) {
			new StudentLeave();
		} else if(msg.equals("Update Faculty Details")) {
			new UpdateTeacher();
		} else if(msg.equals("Update Students Details")) {
			new UpdateStudent();
		} else if(msg.equals("Faculty Leave Details")) {
			new TeacherLeaveDetails();
		} else if(msg.equals("Students Leave Details")) {
			new StudentLeaveDetails();
		} else if(msg.equals("Enter Marks")) {
			new EnterMarks();
		} else if(msg.equals("Fee Structure")) {
			new FeeStructure();
		} else if(msg.equals("About")) {
			new About();
		} else if(msg.equals("Student Fee Form")) {
			new StudentFeeForm();
		} else if(msg.equals("Examination Results")) {
			new ExaminationDetails();
		} else if(msg.equals("Exit")) {
			setVisible(false);
		}
		
	}
	


public static void main(String [] args) {
	new project();
	
}
}
