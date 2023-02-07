package miniProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MainPage extends JFrame {

	private JPanel contentPane;   

	/**
	 * Launch the application.
	 */
	static MainPage mp;
	static ResultList rl;
    static ViewFaculty1 vf;
    
    static boolean admin;
    static boolean faculty;
   
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    mp = new MainPage();
					mp.setVisible(true);
					rl=new ResultList(mp);
					vf=new ViewFaculty1(mp);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */          
	JButton view_faculty_btn;
	JButton logout_btn;
	JLabel hello;
    JButton reval_btn;
    static String sub="";
    private JButton btnNewButton_2;
    private JLabel lblNewLabel_2;
	
	public MainPage() {	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,900,506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RESULT MANAGEMENT SYSTEM");
		lblNewLabel.setForeground(new Color(250, 235, 215));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(230, 20, 407, 34);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("VIEW RESULTS");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(187, 174, 171, 52);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    setVisible(false);
				rl.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton("UPLOAD RESULTS");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setBounds(463, 174, 199, 52);
		contentPane.add(btnNewButton_1);
		
		view_faculty_btn = new JButton("VIEW FACULTY");
		view_faculty_btn.setForeground(new Color(255, 255, 255));
		view_faculty_btn.setBackground(new Color(0, 0, 0));
		view_faculty_btn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		view_faculty_btn.setBounds(329, 292, 161, 28);
		view_faculty_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				vf.setVisible(true);
			}
		});
		contentPane.add(view_faculty_btn);
		
		logout_btn = new JButton("LOGOUT");
		logout_btn.setFont(new Font("Times New Roman", Font.BOLD, 13));
		logout_btn.setBounds(756, 32, 97, 23);
		contentPane.add(logout_btn);
		
	    hello = new JLabel("");
	    hello.setForeground(new Color(255, 255, 255));
		hello.setBounds(38, 36, 136, 18);
		contentPane.add(hello);
		hello.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		reval_btn = new JButton("VIEW REVALUATIONS");
		reval_btn.setForeground(new Color(255, 255, 255));
		reval_btn.setBackground(new Color(0, 0, 0));
		reval_btn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		reval_btn.setBounds(301, 293, 212, 26);
		contentPane.add(reval_btn);
		
		btnNewButton_2 = new JButton("Give feedback");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Feedback fb=new Feedback(mp);
				setVisible(false);
				fb.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		btnNewButton_2.setBounds(740, 409, 117, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel testt = new JLabel("New label");
		testt.setForeground(new Color(0, 100, 0));
		testt.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\res1 (1).png"));
		testt.setBounds(-11, -33, 895, 500);
		contentPane.add(testt);
		
		
		hello.setVisible(false);
		reval_btn.setVisible(false);
		
		reval_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AvailableRevals ar=new AvailableRevals();
				ar.init(mp, sub);
				ar.fun();
				ar.setVisible(true);
				
			}
			
		});
		logout_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logout_btn.setVisible(false);
				admin=false;
				faculty=false;
				view_faculty_btn.setVisible(false);
				reval_btn.setVisible(false);
			}
		});
		
	    logout_btn.setVisible(false);
	    
		    btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				if(admin||faculty) {
					UploadResult ur=new UploadResult(mp,rl,vf);
				    setVisible(false);
					ur.setVisible(true);
				}
				else {
				LoginPage lp1=new LoginPage(mp, rl, vf);
				lp1.setVisible(true);
				}
			}
			
		});
		
		view_faculty_btn.setVisible(false);
	}
}
