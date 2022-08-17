package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JPasswordField passwordField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("L O G I N");
		lblNewLabel.setBounds(177, 23, 89, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblNewLabel);
		
		JLabel lbUsername = new JLabel("Username");
		lbUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbUsername.setBounds(44, 69, 93, 33);
		contentPane.add(lbUsername);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(147, 71, 206, 33);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		JLabel lbPassword = new JLabel("Password");
		lbPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbPassword.setBounds(44, 125, 93, 33);
		contentPane.add(lbPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(147, 127, 206, 33);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBounds(79, 191, 89, 33);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection conn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-C9L4BQL3:1433;databaseName=EmployeeManagement;user=sa;password=116615");			
					System.out.println("Connected");
					String q = "SELECT * FROM Login WHERE Username ='"+tfUsername.getText()+"' AND Password = '"+passwordField.getText()+"'";

					PreparedStatement ps = conn.prepareStatement(q);
					ResultSet rs = ps.executeQuery();
					if(rs.next()){
						JOptionPane.showMessageDialog(btnLogin, "Successfully Login");
		                EmployeeManage E =new EmployeeManage();
		                E.setVisible(true);
		                		                
		            }else{
		                JOptionPane.showMessageDialog(btnLogin, "Invalid login");
		            
		            }
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(btnLogin, "Error: "+e2.getMessage());
				}
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBounds(263, 191, 89, 33);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnCancel);
	}
}

