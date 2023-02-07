package miniProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
    static ResultList rl;
    static MainPage mp;
    static ViewFaculty1 vf;
   
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	int len;
	Timer tm;
	int ct=0;
	Timer tm2;
	
	public LoginPage(MainPage mp,ResultList rl,ViewFaculty1 vf) {
		this.rl=rl;
		this.vf=vf;
		this.mp=mp;
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RESULT MANAGEMENT SYSTEM");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(264, 31, 451, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(83, 175, 79, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(83, 247, 79, 24);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(225, 170, 227, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(225, 242, 227, 36);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   String user=textField.getText();
			   String pass=passwordField.getText();
			   if(checkAdmin(user,pass)) {
				   setVisible(false);
				   
				   mp.view_faculty_btn.setVisible(true);
				   mp.logout_btn.setVisible(true);
				   
				   mp.admin=true;
				   mp.hello.setText("Hello "+user);
				   mp.hello.setVisible(true);
				   mp.setVisible(true);	
				   String txt=mp.hello.getText();
				   len=txt.length();
				   mp.hello.setVisible(true);
				   tm=new Timer(100,new ActionListener() {
                    	@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
                    	ct++;
						if(ct<=len) {
						  mp.hello.setText(txt.substring(0,ct));
						}
						else {
							ct--;
							System.out.println("st"+ct);
							tm2.start();
							tm.stop();
						}
						System.out.println(ct);
					}	   
				   });   
				   tm.start();   
				   tm2=new Timer(100,new ActionListener() {
                   	@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
                   		System.out.println(ct);
						if(ct>=0) {
						  mp.hello.setText(txt.substring(0,ct));
						}
						else {
							tm2.stop();
						}
						ct--;
						
					}	   
				   });
			   }
			   else if(check(user,pass)) {
				   UploadResult ur=new UploadResult(mp,rl,vf);
				   setVisible(false);
				   mp.logout_btn.setVisible(true);
				   mp.faculty=true;
				   mp.reval_btn.setVisible(true);
				   ur.setVisible(true);
			   } 
			   else {
				   JOptionPane.showMessageDialog(null,"Invalid username or password");  
			   }
			}
		});
		btnNewButton.setBounds(174, 319, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SIGN UP");                                                             
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 128, 128));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacultySignIn fsi=new FacultySignIn(mp,rl,vf);
				fsi.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(310, 319, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Doesn't have an account?");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_2.setBounds(278, 294, 121, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBackground(new Color(0, 128, 128));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\login_logo (1).png"));
		lblNewLabel_3.setBounds(161, 162, 46, 52);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\password_logo (1).png"));
		lblNewLabel_4.setBounds(161, 234, 46, 52);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\login_img (2).png"));
		lblNewLabel_5.setBounds(478, 96, 350, 329);
		contentPane.add(lblNewLabel_5);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mp.setVisible(true);
			}
		});
	}
	
	public static boolean checkAdmin(String username,String password) {
		boolean flag=true;
		Connect c=new Connect();
		Connection conn=c.ConnectDB();
		try {
			String querry="select * from admin where usename='"+username+"' and password='"+password+"'";
		    java.sql.Statement stm=conn.createStatement();
		    ResultSet rs=stm.executeQuery(querry);
		    flag=rs.isBeforeFirst();
		  
		}catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
         }
		return flag;
	}
			
	
	public static boolean check(String username,String password) {
		boolean flag=false;
		Connect c=new Connect();
		Connection conn=c.ConnectDB();
		try {
			String querry="select * from faculty where user='"+username+"' and password='"+password+"'";
		    Statement stm=conn.createStatement();
		    ResultSet rs=stm.executeQuery(querry);
		    
		    if(rs.next()) {
		    	flag=true;
		    	mp.sub=(String)rs.getObject(5);
		    
		    }
		  
		}catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
         }
		return flag;
	}
}


