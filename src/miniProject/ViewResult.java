package miniProject;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ViewResult extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
    ResultList rl;
    MainPage mp;
    ViewFaculty1 vf;
    
    
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
	
	String s;
	
	public ViewResult(String s,MainPage mp,ResultList rl,ViewFaculty1 vf) {
		this.vf=vf;
		this.rl=rl;
		this.mp=mp;
		this.s=s;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter USN");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(242, 166, 89, 29);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(348, 172, 196, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(314, 218, 130, 29);
		contentPane.add(btnNewButton);
		
		JButton back = new JButton("BACK");
		back.setBackground(new Color(0, 0, 0));
		back.setForeground(new Color(255, 255, 255));
		back.setFont(new Font("Times New Roman", Font.BOLD, 13));
		back.setBounds(23, 23, 89, 23);
		contentPane.add(back);
		
		JLabel lblNewLabel_1 = new JLabel("All the best");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Pristina", Font.ITALIC, 25));
		lblNewLabel_1.setBounds(324, 266, 118, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\res1 (1).png"));
		lblNewLabel_2.setBounds(0, 0, 874, 467);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(195, 86, 400, 269);
		contentPane.add(lblNewLabel_3);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				rl.setVisible(true);
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(check(textField.getText())) {
					
					ResultPage rp=new ResultPage(s, textField.getText(),mp,rl,vf);
					setVisible(false);
					rp.setVisible(true);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid USN");
				}
			}
		});
	}
	
	
	public boolean check(String us) {
		boolean flag=true;
		Connect c=new Connect();
		Connection conn=c.ConnectDB();
		try {
			String querry=String.format("select * from result where resname='%s' ",s);
		    java.sql.Statement stm=conn.createStatement();
		    ResultSet rs=stm.executeQuery(querry);
		    flag=rs.isBeforeFirst();
		  
		}catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
         }
		return flag;
	}
}
