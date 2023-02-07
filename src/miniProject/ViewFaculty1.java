package miniProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;



import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.Color;

public class ViewFaculty1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static MainPage mp;
	static ResultList rl;
	static ViewFaculty1 vf;
	private JTable table;
	DefaultTableModel dmodel;
	int selRow=0;
	
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
	JButton updateFaculty_btn;
	JButton removeFaculty_btn;
	JButton addFaculty_btn;
	private JTextField name;
	private JTextField phone;
	private JTextField userid;
	private JTextField password;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	
public ViewFaculty1(MainPage mp) {
	    Connection conn=new Connect().ConnectDB();
 	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FACULTY LIST");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(327, 35, 174, 29);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(true);
		
		
		
		scrollPane.setBounds(10, 87, 572, 312);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				updateFaculty_btn.setVisible(true);
				removeFaculty_btn.setVisible(true);
				selRow=table.getSelectedRow();
				System.out.println(selRow);
				table.setEnabled(true);
				name.setVisible(false);
				phone.setVisible(false);
				userid.setVisible(false);
				password.setVisible(false);
				btnNewButton.setVisible(false);
				lblNewLabel_1.setVisible(false);
				lblNewLabel_2.setVisible(false);
				lblNewLabel_3.setVisible(false);
				lblNewLabel_4.setVisible(false);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Phone","Subject","User id", "Password",
			}
		));
		
	    dmodel=(DefaultTableModel) table.getModel();
		scrollPane.setViewportView(table);
		
		addFaculty_btn = new JButton("ADD FACULTY");
		addFaculty_btn.setForeground(new Color(255, 255, 255));
		addFaculty_btn.setBackground(new Color(0, 128, 128));
		addFaculty_btn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		addFaculty_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateFaculty_btn.setVisible(false);
				removeFaculty_btn.setVisible(false);
				addFaculty_btn.setVisible(false);
				name.setVisible(true);
				phone.setVisible(true);
				userid.setVisible(true);
				password.setVisible(true);
				lblNewLabel_1.setVisible(true);
				lblNewLabel_2.setVisible(true);
				lblNewLabel_3.setVisible(true);
				lblNewLabel_4.setVisible(true);
				btnNewButton.setVisible(true);
			}
		});
		addFaculty_btn.setBounds(649, 143, 185, 29);
		contentPane.add(addFaculty_btn);
		
		updateFaculty_btn = new JButton("UPDATE FACULTY");
		updateFaculty_btn.setForeground(new Color(255, 255, 255));
		updateFaculty_btn.setBackground(new Color(0, 128, 128));
		updateFaculty_btn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		updateFaculty_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userr=(String)dmodel.getValueAt(selRow, 3);
				String nam=(String)dmodel.getValueAt(selRow, 0);
				String pho=(String)dmodel.getValueAt(selRow, 1);
				String pas=(String)dmodel.getValueAt(selRow, 4);
				String sub=(String)dmodel.getValueAt(selRow, 2);
				String querry="update faculty set name='"+nam+"', phone='"+pho+"', user='"+userr+"',password='"+pas+"',subject='"+sub+"' where user='"+userr+"'";
			    addFaculty_btn.setVisible(true);
			    updateFaculty_btn.setVisible(false);
			    removeFaculty_btn.setVisible(false);
				try {
					Statement stm=conn.createStatement();
					stm.execute(querry);
					dmodel.setValueAt(nam, selRow, 0);
					dmodel.setValueAt(pho, selRow, 1);
					dmodel.setValueAt(userr, selRow, 2);
					dmodel.setValueAt(pas, selRow, 3);
					JOptionPane.showMessageDialog(null, "Faculty updated");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		updateFaculty_btn.setBounds(649, 199, 185, 29);
		contentPane.add(updateFaculty_btn);
		updateFaculty_btn.setVisible(false);
		
		
		removeFaculty_btn = new JButton("REMOVE FACULTY");
		removeFaculty_btn.setForeground(new Color(255, 255, 255));
		removeFaculty_btn.setBackground(new Color(0, 128, 128));
		removeFaculty_btn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		removeFaculty_btn.setBounds(649, 260, 185, 29);
		contentPane.add(removeFaculty_btn);
		removeFaculty_btn.setVisible(false);
		
		removeFaculty_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String userr=(String)dmodel.getValueAt(selRow, 2);
				String querry="delete from faculty where user='"+userr+"'";
				try {
					Statement stm=conn.createStatement();
					stm.execute(querry);
					dmodel.removeRow(selRow);
					if(dmodel.getRowCount()==0) {
						removeFaculty_btn.setVisible(false);
					    updateFaculty_btn.setVisible(false);	
					}
					JOptionPane.showMessageDialog(null, "Faculty Deleted");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
		});
		
		JButton btnNewButton_3 = new JButton("BACK");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(0, 128, 128));
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mp.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(10, 24, 89, 23);
		contentPane.add(btnNewButton_3);
		
		name = new JTextField();
		name.setBounds(685, 116, 136, 20);
		contentPane.add(name);
		name.setColumns(10);
		name.setVisible(false);
		
		phone = new JTextField();
		phone.setBounds(685, 147, 136, 20);
		contentPane.add(phone);
		phone.setColumns(10);
		phone.setVisible(false);
		
		userid = new JTextField();
		userid.setBounds(685, 177, 136, 20);
		contentPane.add(userid);
		userid.setColumns(10);
		userid.setVisible(false);
		
		password = new JTextField();
		password.setBounds(685, 208, 136, 20);
		contentPane.add(password);
		password.setColumns(10);
		password.setVisible(false);
		
		btnNewButton = new JButton("ADD");
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(665, 251, 74, 23);
		contentPane.add(btnNewButton);
		btnNewButton.setVisible(false);
		btnNewButton.addActionListener(new ActionListener() {
          @Override
			public void actionPerformed(ActionEvent e) {
				
				String n=name.getText();
				String p=phone.getText();
				String u=userid.getText();
				String pa=password.getText();
				String querry="insert into faculty values('"+n+"','"+p+"','"+u+"','"+pa+"')";
				try {
					Statement stm=(Statement) conn.createStatement();
					stm.execute(querry);
					dmodel.addRow(new Object[] {n,p,u,pa});
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				name.setVisible(false);
				phone.setVisible(false);
				userid.setVisible(false);
				password.setVisible(false);
				btnNewButton.setVisible(false);
				lblNewLabel_1.setVisible(false);
				lblNewLabel_2.setVisible(false);
				lblNewLabel_3.setVisible(false);
				lblNewLabel_4.setVisible(false);
				addFaculty_btn.setVisible(true);
			}	
		});
		
		lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(595, 119, 46, 14);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		lblNewLabel_2 = new JLabel("Phone");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(595, 152, 46, 14);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		lblNewLabel_3 = new JLabel("User id");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(595, 180, 46, 14);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		
		lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(586, 211, 52, 14);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setVisible(false);
		
		DefaultTableModel dm=(DefaultTableModel) table.getModel();
		
		
	}
}
