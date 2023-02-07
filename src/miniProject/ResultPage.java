package miniProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import java.awt.Color;

public class ResultPage extends JFrame {

	private JPanel contentPane;
    String usn="";
    String marks="";
    String sname="";
    String mar1="";
    String mar2="";
    String mar3="";
    String sub1="";
    String sub2="";
    String sub3="";
    String tot="";
    String descc="";
    
	/**
	 * Launch the application.
	 */
    String resultname;
    
    ResultList rl;
    MainPage mp;
    ViewFaculty1 vf;
    ResultPage rp;
    
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
	
	
	public ResultPage(String resultname,String us,MainPage mp,ResultList rl,ViewFaculty1 vf) {
		this.vf=vf;
		this.rl=rl;
		this.mp=mp;
		
		try {
			Connection conn=new Connect().ConnectDB();
			String querry=String.format("select * from result where resname='%s' and usn='%s'",resultname,us);
			java.sql.Statement stm=conn.createStatement();
			ResultSet rs=stm.executeQuery(querry);
			while(rs.next()) {
			tot=rs.getString(2);
			descc=rs.getString(3);
			sub1=rs.getString(4);
			sub2=rs.getString(5);
			sub3=rs.getString(6);
			mar1=rs.getString(7);
			mar2=rs.getString(8);
			mar3=rs.getString(9);
			usn=rs.getString(11);
			sname=rs.getString(12);
			
			}
		}
			catch(SQLException | HeadlessException e){
	            JOptionPane.showMessageDialog(null, e);
	        }
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(156, 114, 89, 25);
		contentPane.add(lblNewLabel);
		
		JLabel hiddenmarks1 = new JLabel(mar1);
		hiddenmarks1.setFont(new Font("Tahoma", Font.BOLD, 16));
		hiddenmarks1.setBounds(258, 196, 86, 41);
		contentPane.add(hiddenmarks1);
		
		JLabel hiddenusn = new JLabel(usn);
		hiddenusn.setFont(new Font("Tahoma", Font.BOLD, 16));
		hiddenusn.setBounds(255, 116, 219, 20);
		contentPane.add(hiddenusn);
		
		JLabel hiddenmarks2 = new JLabel(mar2);
		hiddenmarks2.setFont(new Font("Tahoma", Font.BOLD, 16));
		hiddenmarks2.setBounds(258, 255, 100, 20);
		contentPane.add(hiddenmarks2);
		
		JButton home = new JButton("HOME");
		home.setBackground(new Color(0, 128, 128));
		home.setForeground(new Color(255, 255, 255));
		home.setBounds(34, 45, 86, 23);
		contentPane.add(home);
		
		JButton btnNewButton = new JButton("REVALUATE");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setBounds(573, 45, 126, 25);
		contentPane.add(btnNewButton);
		
		JLabel hiddensubject1 = new JLabel(sub1);
		hiddensubject1.setFont(new Font("Tahoma", Font.BOLD, 16));
		hiddensubject1.setBounds(156, 204, 89, 25);
		contentPane.add(hiddensubject1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(156, 167, 61, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel hiddensubject2 = new JLabel(sub2);
		hiddensubject2.setFont(new Font("Tahoma", Font.BOLD, 16));
		hiddensubject2.setBounds(156, 256, 89, 14);
		contentPane.add(hiddensubject2);
		
		JLabel hiddensubject3 = new JLabel(sub3);
		hiddensubject3.setFont(new Font("Tahoma", Font.BOLD, 16));
		hiddensubject3.setBounds(157, 300, 46, 14);
		contentPane.add(hiddensubject3);
		
		JLabel hiddenmarks3 = new JLabel(mar3);
		hiddenmarks3.setFont(new Font("Tahoma", Font.BOLD, 16));
		hiddenmarks3.setBounds(258, 302, 86, 14);
		contentPane.add(hiddenmarks3);
		
		JLabel hiddentotmarks1 = new JLabel(tot);
		hiddentotmarks1.setFont(new Font("Tahoma", Font.BOLD, 16));
		hiddentotmarks1.setBounds(260, 344, 54, 25);
		contentPane.add(hiddentotmarks1);
		
		JLabel hiddendesc1 = new JLabel(descc);
		hiddendesc1.setFont(new Font("Tahoma", Font.BOLD, 16));
		hiddendesc1.setBounds(258, 388, 107, 25);
		contentPane.add(hiddendesc1);
		
		JLabel hiddenname = new JLabel(sname);
		hiddenname.setFont(new Font("Tahoma", Font.BOLD, 16));
		hiddenname.setBounds(258, 164, 171, 20);
		contentPane.add(hiddenname);
		
		JLabel lblNewLabel_1 = new JLabel("Total Marks");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(121, 344, 100, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Description");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(121, 393, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Revaluation rv=new Revaluation(resultname,us,mp,rl,vf);
				rv.init(mp,rl,vf);
				setVisible(false);
				rv.setVisible(true);
			}
			
		});
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mp.setVisible(true);
			}
		});
	}
}
