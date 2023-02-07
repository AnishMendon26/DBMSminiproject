package miniProject;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class FacultySignIn extends JFrame {

	private JPanel contentPane;
	private JTextField name1;
	private JTextField phone1;
	private JTextField userid1;
	private JPasswordField password1;
	private JPasswordField confirmPassword1;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
    ResultList rl;
    MainPage mp;
    ViewFaculty1 vf;
    private JLabel lblNewLabel_5;
    private JTextField subject1;
    private JLabel lblNewLabel_6;
    
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
	
	
	public FacultySignIn(MainPage mp,ResultList rl,ViewFaculty1 vf) {
		this.vf=vf;
		this.rl=rl;
		this.mp=mp;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(50, 77, 99, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mobile Number");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(50, 124, 152, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User id");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(50, 168, 99, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(50, 258, 99, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Password");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(50, 301, 168, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(189, 364, 140, 33);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=name1.getText();
				String mobile=phone1.getText();
				String userid=userid1.getText();
				String password=password1.getText();
				String subject=subject1.getText();
				String confirmPass=confirmPassword1.getText();
				if(userid.equals(""))
					JOptionPane.showMessageDialog(null, "Invalid username");
				else if(!(password.equals(confirmPass)))
					JOptionPane.showMessageDialog(null, "Password does not match");
				else {
				  insert(name,mobile,userid,password,subject);
			      setVisible(false);
			      LoginPage lp=new LoginPage(mp,rl,vf);
			      lp.setVisible(true);
			      vf.dmodel.addRow(new Object[] {name,mobile,userid,password});
			      
				}
			}
		});
			
		
		name1 = new JTextField();
		name1.setBounds(228, 77, 140, 20);
		contentPane.add(name1);
		name1.setColumns(10);
		
		phone1 = new JTextField();
		phone1.setBounds(228, 118, 140, 20);
		contentPane.add(phone1);
		phone1.setColumns(10);
		
		userid1 = new JTextField();
		userid1.setBounds(228, 168, 140, 20);
		contentPane.add(userid1);
		userid1.setColumns(10);
		
		password1 = new JPasswordField();
		password1.setBounds(228, 252, 140, 20);
		contentPane.add(password1);
		
		confirmPassword1 = new JPasswordField();
		confirmPassword1.setBounds(228, 301, 140, 20);
		contentPane.add(confirmPassword1);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 128, 128));
		btnNewButton_1.setBounds(10, 4, 89, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_5 = new JLabel("Subject");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(50, 213, 99, 14);
		contentPane.add(lblNewLabel_5);
		
		subject1 = new JTextField();
		subject1.setBounds(228, 207, 140, 20);
		contentPane.add(subject1);
		subject1.setColumns(10);
		
		lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\SIGNIN_IMG (1).png"));
		lblNewLabel_6.setBounds(443, 66, 338, 331);
		contentPane.add(lblNewLabel_6);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginPage lp=new LoginPage(mp, rl, vf);
				lp.setVisible(true);
			}
		});
	}	
	
	public static void insert(String name,String phone,String user,String password,String subject) {
		Connect c=new Connect();
		Connection conn=c.ConnectDB();
		try {
			
			String querry="insert into faculty values('"+name+"','"+phone+"','"+user+"','"+password+"','"+subject+"')";
			PreparedStatement ps=conn.prepareStatement(querry);
			ps.execute();
			JOptionPane.showMessageDialog(null, "Data added");
			
           }catch(SQLException | HeadlessException e){
              JOptionPane.showMessageDialog(null, e);
           }
		}

}


