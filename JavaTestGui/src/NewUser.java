import java.awt.BorderLayout;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class NewUser extends JFrame {

	private JPanel contentPane;
	private JTextField firstnameTF;
	private JTextField usernameTF;
	private JTextField emailTF;
	private JTextField lastnameTF;
	private JTextField passwordPF;
	private JTextField phoneNrTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUser frame = new NewUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void infoMessage(String message, String title) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	/**
	 * Create the frame.
	 */
	public NewUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New User Register");
		lblNewLabel.setBounds(170, 30, 130, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(29, 67, 72, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setBounds(29, 95, 72, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("E-mail:");
		lblNewLabel_3.setBounds(29, 123, 72, 16);
		contentPane.add(lblNewLabel_3);
		
		firstnameTF = new JTextField();
		firstnameTF.setBounds(103, 62, 101, 26);
		contentPane.add(firstnameTF);
		firstnameTF.setColumns(10);
		
		usernameTF = new JTextField();
		usernameTF.setBounds(103, 90, 101, 26);
		contentPane.add(usernameTF);
		usernameTF.setColumns(10);
		
		emailTF = new JTextField();
		emailTF.setBounds(103, 118, 101, 26);
		contentPane.add(emailTF);
		emailTF.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Last Name:");
		lblNewLabel_4.setBounds(231, 67, 79, 16);
		contentPane.add(lblNewLabel_4);
		
		lastnameTF = new JTextField();
		lastnameTF.setColumns(10);
		lastnameTF.setBounds(304, 62, 101, 26);
		contentPane.add(lastnameTF);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(231, 95, 79, 16);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel_5 = new JLabel("Phone Nr:");
		lblNewLabel_5.setBounds(231, 123, 79, 16);
		contentPane.add(lblNewLabel_5);
		
		passwordPF = new JTextField();
		passwordPF.setColumns(10);
		passwordPF.setBounds(304, 90, 101, 26);
		contentPane.add(passwordPF);
		
		phoneNrTF = new JTextField();
		phoneNrTF.setColumns(10);
		phoneNrTF.setBounds(304, 118, 101, 26);
		contentPane.add(phoneNrTF);
		
		JButton registerBtn = new JButton("Register");
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstname = firstnameTF.getText();
				String lastname = lastnameTF.getText();
				String username = usernameTF.getText();
				String password = passwordPF.getText();
				String email = emailTF.getText();
				String phonenr = phoneNrTF.getText();
				
				try
				{
					Class.forName("com.mysql.jdbc.DriverManager"); 
					String databaseURL = "jdbc:mysql://localhost:8080/plane";
					Connection con = DriverManager.getConnection(databaseURL,"root","");
					String insertQuery = "INSERT INTO user_details('','"+firstname+"','"+lastname+"','"+username+"','"+password+"','"+email+"','"+phonenr+"')";
					Statement stat = con.createStatement();
					int x = stat.executeUpdate(insertQuery);
					System.out.print(x);
					if(x==1) {
						infoMessage("Success! Information added.", "Alert");
					}
				}
				catch(Exception exc) {
					System.out.print(exc);
				}
				
			}
		});
		registerBtn.setBounds(87, 170, 117, 29);
		contentPane.add(registerBtn);
		
		JButton resetBtn = new JButton("Reset");
		resetBtn.setBounds(256, 170, 117, 29);
		contentPane.add(resetBtn);
		
		JButton btnNewButton_2 = new JButton("Already have an account? Sign in");
		btnNewButton_2.setBounds(97, 211, 276, 29);
		contentPane.add(btnNewButton_2);
	}
}
