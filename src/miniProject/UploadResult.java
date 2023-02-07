package miniProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;

public class UploadResult extends JFrame {

	private JPanel contentPane;
	private JTextField resultname1;

	/**
	 * Launch the application.
	 */
    ResultList rl;
    MainPage mp;
    ViewFaculty1 vf;
    AvailableRevals ar;
    
    private JTextField usn1;
    private JTable table;
    private JTextField subject1;
    
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
	DefaultTableModel dmodel;
	private JTextField resid1;
	private JTextField name1;
	private JTextField subject2;
	private JTextField subject3;
	private JTextField marks2;
	private JTextField marks3;
	private JTextField marks1;
	
	public UploadResult(MainPage mp,ResultList rl,ViewFaculty1 vf) {
		this.vf=vf;
		this.rl=rl;
		this.mp=mp;
		this.ar=ar;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter result values");
		lblNewLabel.setBounds(341, 11, 218, 47);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Result name");
		lblNewLabel_1.setBounds(48, 74, 163, 31);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1);
		
		resultname1 = new JTextField();
		resultname1.setBounds(146, 79, 237, 24);
		contentPane.add(resultname1);
		resultname1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter values");
		lblNewLabel_2.setBounds(21, 126, 132, 24);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblNewLabel_2);
			
		JButton back_btn = new JButton("Back");
		back_btn.setForeground(new Color(255, 255, 255));
		back_btn.setBackground(new Color(0, 128, 128));
		back_btn.setBounds(10, 11, 89, 23);
		contentPane.add(back_btn);
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mp.setVisible(true);
			}
		});
		JButton submit_btn = new JButton("SUBMIT");
		submit_btn.setForeground(new Color(255, 255, 255));
		submit_btn.setBackground(new Color(0, 128, 128));
		submit_btn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		submit_btn.setBounds(364, 390, 147, 31);
		contentPane.add(submit_btn);
		
		JLabel lblNewLabel_3 = new JLabel("USN");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(48, 209, 43, 14);
		contentPane.add(lblNewLabel_3);
		
		usn1 = new JTextField();
		usn1.setBounds(105, 207, 163, 17);
		contentPane.add(usn1);
		usn1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Marks");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(277, 173, 54, 14);
		contentPane.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(341, 116, 543, 220);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name","USN","Subject1","Subject2","Subject3"
			}
		));
		
		
		dmodel=(DefaultTableModel) table.getModel();
		
		JButton add_btn = new JButton("ADD");
		add_btn.setBackground(new Color(0, 128, 128));
		add_btn.setForeground(new Color(255, 255, 255));
		add_btn.setFont(new Font("Tahoma", Font.BOLD, 11));
		add_btn.setBounds(28, 372, 71, 23);
		contentPane.add(add_btn);
		add_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				model.addRow(new Object[] {name1.getText(),usn1.getText(),marks1.getText(),marks2.getText(),marks3.getText()});
			}
		});
		JButton delete_btn = new JButton("DELETE");
		delete_btn.setForeground(new Color(255, 255, 255));
		delete_btn.setBackground(new Color(0, 128, 128));
		delete_btn.setFont(new Font("Tahoma", Font.BOLD, 11));
		delete_btn.setBounds(109, 372, 84, 23);
		contentPane.add(delete_btn);
		
		delete_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				model.removeRow(model.getRowCount()-1);
			}
		});
		JButton update_btn = new JButton("UPDATE");
		update_btn.setForeground(new Color(255, 255, 255));
		update_btn.setBackground(new Color(0, 128, 128));
		update_btn.setFont(new Font("Tahoma", Font.BOLD, 11));
		update_btn.setBounds(209, 373, 89, 22);
		contentPane.add(update_btn);
		

		JButton savebtn = new JButton("SAVE");
		savebtn.setForeground(new Color(255, 255, 255));
		savebtn.setBackground(new Color(0, 128, 128));
		savebtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		savebtn.setBounds(575, 356, 89, 23);
		contentPane.add(savebtn);
		savebtn.setVisible(false);
		
		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				savebtn.setVisible(false);
				add_btn.setVisible(true);
				delete_btn.setVisible(true);
				update_btn.setVisible(true);
				submit_btn.setVisible(true);
				table.setEnabled(false);
			}
		});
		
		update_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setEnabled(true);
				add_btn.setVisible(false);
				delete_btn.setVisible(false);
			    update_btn.setVisible(false);
			    submit_btn.setVisible(false);
			    savebtn.setVisible(true);
			}
		});
		subject1 = new JTextField();
		subject1.setBounds(105, 244, 163, 16);
		contentPane.add(subject1);
		subject1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Subject 1");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(37, 245, 57, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Result id");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6.setBounds(426, 84, 84, 14);
		contentPane.add(lblNewLabel_6);
		
		resid1 = new JTextField();
		resid1.setBounds(521, 81, 43, 20);
		contentPane.add(resid1);
		resid1.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Name");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(48, 173, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		name1 = new JTextField();
		name1.setBounds(105, 172, 163, 16);
		contentPane.add(name1);
		name1.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Subject 2");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(37, 281, 57, 14);
		contentPane.add(lblNewLabel_8);
		
		subject2 = new JTextField();
		subject2.setBounds(105, 279, 163, 17);
		contentPane.add(subject2);
		subject2.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Subject 3");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(37, 322, 57, 14);
		contentPane.add(lblNewLabel_9);
		
		subject3 = new JTextField();
		subject3.setBounds(105, 318, 163, 18);
		contentPane.add(subject3);
		subject3.setColumns(10);
		
		marks2 = new JTextField();
		marks2.setBounds(277, 278, 36, 21);
		contentPane.add(marks2);
		marks2.setColumns(10);
		
		marks3 = new JTextField();
		marks3.setBounds(277, 316, 36, 20);
		contentPane.add(marks3);
		marks3.setColumns(10);
		
		marks1 = new JTextField();
		marks1.setBounds(277, 242, 36, 20);
		contentPane.add(marks1);
		marks1.setColumns(10);
		
		
		
		
		submit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(dmodel.getRowCount()==0)
					JOptionPane.showMessageDialog(null,"table is empty");
				else {
					
				   try {
				    Connection conn=new Connect().ConnectDB();
					String name;
					String usn;
					String subj1=subject1.getText();
					String subj2=subject2.getText();
					String subj3=subject3.getText();
					String marks1;  
					String marks2;
					String marks3;
					
					
					for(int i=0;i<dmodel.getRowCount();i++) {
						
						name=(String)dmodel.getValueAt(i, 0);
						usn=(String)dmodel.getValueAt(i, 1);
						marks1=(String)dmodel.getValueAt(i, 2);
						marks2=(String)dmodel.getValueAt(i, 3);
						marks3=(String)dmodel.getValueAt(i, 4);
						
						
						String querry1="insert into result values('"+Integer.parseInt(resid1.getText())+"','0','fail','"+subj1+"','"+subj2+"','"+subj3+"','"+Integer.parseInt(marks1)+"','"+Integer.parseInt(marks2)+"','"+Integer.parseInt(marks3)+"','"+resultname1.getText()+"','"+usn+"','"+name+"')";
						Statement stm1=conn.createStatement();
						stm1.execute(querry1);
					}
				   } catch (SQLException e1) {
				 	// TODO Auto-generated catch block
					   e1.printStackTrace();
				   }
				   
				}
				dmodel.setRowCount(0);
				rl.addResultList(resultname1.getText());
				setVisible(false);
				mp.setVisible(true);
			}
		});
		
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mp.setVisible(true);
			}
		});
	}
}
