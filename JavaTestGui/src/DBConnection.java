import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class DBConnection {
	Connection conn = null;
	
	public static Connection ConnectDB() {
		try {
//			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/krzysiek/Desktop/EiT/Programy/JavaEclipse/JavaTestGui/plane.db");
			System.out.println("Connected!");
			return conn;
			
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(null,exc);
			return null;
		}
	}

}
