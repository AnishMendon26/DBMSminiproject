package miniProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Feedback extends JFrame {

	private JPanel contentPane;
	private JTextField name1;
    MainPage mp;
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
	public Feedback(MainPage mp) {
		this.mp=mp;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FEEDBACK");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(388, 35, 157, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(107, 95, 58, 29);
		contentPane.add(lblNewLabel_1);
		
		JSpinner ratings1 = new JSpinner();
		ratings1.setBounds(195, 148, 38, 39);
		contentPane.add(ratings1);
		
		JLabel lblNewLabel_2 = new JLabel("Ratings");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(107, 151, 97, 29);
		contentPane.add(lblNewLabel_2);
		
		name1 = new JTextField();
		name1.setBounds(175, 97, 166, 25);
		contentPane.add(name1);
		name1.setColumns(10);
		
		JTextArea feed1 = new JTextArea();
		feed1.setBounds(205, 208, 379, 103);
		contentPane.add(feed1);
		
		JLabel lblNewLabel_3 = new JLabel("Write feedback");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(73, 212, 131, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(351, 359, 114, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_1.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\res1 (1).png"));
		lblNewLabel_4.setBounds(0, 0, 874, 467);
		contentPane.add(lblNewLabel_4);
		
        btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mp.setVisible(true);
			}
        	
        });
        
        btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Connection conn=new Connect().ConnectDB();
		        String querry="insert into feedback values('"+name1.getText()+"',"+ratings1.getValue()+",'"+feed1.getText()+"')";
		        try {
					Statement stm=conn.createStatement();
					stm.execute(querry);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        setVisible(false);
		        mp.setVisible(true);
			}
        	
        });
        
	}
}
