package com.UMS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login extends JFrame implements ActionListener {
	JButton login, cancel;
	JTextField tfUserName, tfPassword;
	
	login(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setBounds(40, 20, 100, 20);
		add(lblUserName);
		
		tfUserName = new JTextField();
		tfUserName.setBounds(150, 20, 150, 20);
		add(tfUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(40, 70, 100, 20);
		add(lblPassword);
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(150, 70, 150, 20);
		add(tfPassword);
		
		login = new JButton("Login");
		login.setBounds(40, 140, 120, 30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		login.setFont(new Font("serif", Font.BOLD, 16));
		add(login);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(180, 140, 120, 30);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
	    cancel.addActionListener(this);
		cancel.setFont(new Font("serif", Font.BOLD, 16));
		add(cancel);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 20, 200,200);
		add(image);
		
		
		setSize(600, 300);
		setLocation(500, 250);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == login) {
			String username = tfUserName.getText();
			String password = tfPassword.getText();
			String query = "select * from login where username = '" + username + "' and password = '"+password+"'";
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new project();
					
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Username or Password");
					setVisible(false);
					
				}
				c.s.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else if(ae.getSource() == cancel) {
			setVisible(false);
			
		}
		
	}
	
	public static void main(String [] args) {
		new login();
	}

}
