package miniProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;

public class Revaluation extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField usn;
	private JTextField phone;
	private JTextField subject;
	private JTextField markso;
	private JTextField markse;
    MainPage mp;
    ResultList rl;
    ViewFaculty1 vf;
	/**
	 * Launch the application.
	 */
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
	public void init(MainPage mp,ResultList rl,ViewFaculty1 vf) {
		this.mp=mp;
		this.rl=rl;
		this.vf=vf;
	}
	
	public Revaluation(String resultname,String us,MainPage mp,ResultList rl,ViewFaculty1 vf) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(54, 90, 117, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USN");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(54, 141, 74, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone number");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(54, 190, 101, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Subject");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(54, 231, 74, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Expected Marks");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(54, 319, 117, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Marks Obtained");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(54, 275, 101, 14);
		contentPane.add(lblNewLabel_5);
		
		name = new JTextField();
		name.setBounds(189, 90, 152, 22);
		contentPane.add(name);
		name.setColumns(10);
		
		usn = new JTextField();
		usn.setBounds(189, 137, 152, 22);
		contentPane.add(usn);
		usn.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(188, 183, 153, 22);
		contentPane.add(phone);
		phone.setColumns(10);
		
		subject = new JTextField();
		subject.setBounds(189, 227, 152, 22);
		contentPane.add(subject);
		subject.setColumns(10);
		
		markso = new JTextField();
		markso.setBounds(189, 272, 152, 22);
		contentPane.add(markso);
		markso.setColumns(10);
		
		markse = new JTextField();
		markse.setColumns(10);
		markse.setBounds(189, 316, 152, 22);
		contentPane.add(markse);
		
		Connection conn=new Connect().ConnectDB();
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(374, 363, 130, 41);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name1=name.getText();
				String usn1=usn.getText();
				String pho=phone.getText();
				String sub=subject.getText();
				String mo=markso.getText();
				String me=markse.getText();
				
				String querry="insert into reval values ('"+name1+"','"+usn1+"','"+pho+"','"+sub+"','"+mo+"','"+me+"')";
				try {
					Statement stm=conn.createStatement();
					stm.execute(querry);
					JOptionPane.showMessageDialog(null, "Applied for Revaluation");
					setVisible(false);
					mp.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		JLabel lblNewLabel_6 = new JLabel("Revaluation Details");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_6.setBounds(335, 31, 306, 28);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\SIGNIN_IMG (1).png"));
		lblNewLabel_7.setBounds(421, 69, 338, 283);
		contentPane.add(lblNewLabel_7);
		
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResultPage rp=new ResultPage(resultname,us,mp,rl,vf);
				setVisible(false);
				rp.setVisible(true);			
			}
			
		});
	}
}
