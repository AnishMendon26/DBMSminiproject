package miniProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Connect {

	public static Connection ConnectDB() {
		String url="jdbc:mysql://localhost:3306/anish";
		String username="root";
		String password="anish26";
		 try {
	         Connection connection = DriverManager.getConnection(url, username, password);
	          return connection;
	      } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, e);
	            return null;
	        }        
	}

}
