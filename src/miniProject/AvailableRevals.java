package miniProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AvailableRevals extends JFrame {

	private JPanel contentPane;
	private JTable table;
    DefaultTableModel dm;
    MainPage mp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AvailableRevals frame = new AvailableRevals();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
   String sub;
   private JButton btnNewButton;
   private JLabel lblNewLabel_1;
	/**
	 * Create the frame.
	 */
   public void init(MainPage mp,String sub) {
	   this.sub=sub;
	   this.mp=mp;
   }
   
   public void fun() {

		Connection conn=new Connect().ConnectDB();
		String querry="select * from reval where subject='"+sub+"'";
		try {
			Statement stm=conn.createStatement();
			ResultSet rs=stm.executeQuery(querry);
			while(rs.next()) {
				String nam=(String)rs.getObject(1);
				String usn=(String)rs.getObject(2);
				String phn=(String)rs.getObject(3);
				String suu=(String)rs.getObject(4);
				String mo=(String)rs.getObject(5);
				String me=(String)rs.getObject(6);
				System.out.println(nam+" "+usn+" "+phn+" "+suu+" "+mo+" "+me);
				dm.addRow(new Object[] {nam,usn,phn,suu,mo,me});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
   }
	public AvailableRevals() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Available Revaluations");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(303, 37, 259, 38);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(147, 112, 585, 294);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student Name", "USN", "Phone", "Subject", "Marks Obtained", "Marks Expected"
			}
		));
		dm=(DefaultTableModel) table.getModel();
		btnNewButton = new JButton("BACK");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mp.setVisible(true);
			}
		});
		btnNewButton.setBounds(41, 49, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\res1 (1).png"));
		lblNewLabel_1.setBounds(0, 0, 874, 467);
		contentPane.add(lblNewLabel_1);
		
	}
}
