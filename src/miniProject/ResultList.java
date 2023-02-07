package miniProject;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ResultList extends JFrame {

	private JPanel contentPane;
    JList<String>list;
    Vector<String>v;
    
    static ResultList rl;
    static ViewFaculty1 vf;
    static MainPage mp;
    private JLabel lblNewLabel_1;
   
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
	public ResultList(MainPage mp) {
		this.mp=mp;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Results available");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(324, 33, 246, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mp.setVisible(true);
			}
		});
		v=new Vector<String>();
		list = new JList<String>(v);
		list.setBounds(106, 85, 663, 333);
		contentPane.add(list);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\res1 (1).png"));
		lblNewLabel_1.setBounds(0, 0, 884, 461);
		contentPane.add(lblNewLabel_1);
		
		
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if(me.getClickCount()==2) {
					JList tar=(JList)me.getSource();
					Object item=tar.getSelectedValue();
					String resname=item.toString();
				
					ViewResult vr=new ViewResult(resname,mp,rl,vf);
					vr.setVisible(true);
				}
				
			}
		});
	}
	
 
	public void addResultList(String s) {
		v.add(s);
		list.setListData(v);
	}

	
}
