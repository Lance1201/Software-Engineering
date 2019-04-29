import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class RegisterPage implements ActionListener{

	protected JFrame frame;
	private JTextField txtUsername;
	private JTextField txtFullName;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPass;
	private ImageIcon icoLogo;
	private JButton btnRegister;
	private JLabel lblRegister; 		
	private JLabel lblUsername; 		
	private JLabel lblFullName; 	
	private JLabel lblPassword;	
	private JLabel lblConfirmPass;
	private String sql;
	private JButton btnBack;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage window = new RegisterPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 632);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		icoLogo = new ImageIcon("./logo/SmallLogo.png");
		frame.setIconImage(icoLogo.getImage());
		frame.setTitle("Breathe");
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 102));
		
		lblRegister = new JLabel("Register");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(Color.LIGHT_GRAY);
		lblRegister.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		lblUsername = new JLabel("USERNAME");
		lblUsername.setForeground(Color.LIGHT_GRAY);
		lblUsername.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		txtUsername = new JTextField();
		txtUsername.setForeground(Color.DARK_GRAY);
		txtUsername.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		txtUsername.setColumns(10);
		lblFullName = new JLabel("FULL NAME");
		lblFullName.setForeground(Color.LIGHT_GRAY);
		lblFullName.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		txtFullName = new JTextField();
		txtFullName.setForeground(Color.DARK_GRAY);
		txtFullName.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		txtFullName.setColumns(10);
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.LIGHT_GRAY);
		lblPassword.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		txtPassword = new JPasswordField();
		txtPassword.setForeground(Color.DARK_GRAY);
		txtPassword.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		txtPassword.setColumns(10);
		lblConfirmPass = new JLabel("CONFIRM PASSWORD");
		lblConfirmPass.setForeground(Color.LIGHT_GRAY);
		lblConfirmPass.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		txtConfirmPass = new JPasswordField();
		txtConfirmPass.setForeground(Color.DARK_GRAY);
		txtConfirmPass.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		txtConfirmPass.setColumns(10);
		btnBack = new JButton("Back");
		btnBack.setForeground(Color.DARK_GRAY);
		btnBack.setBackground(new Color(211, 211, 211));
		btnBack.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnBack.addActionListener(this);
		
		btnRegister = new JButton("Register");
		btnRegister.setForeground(Color.DARK_GRAY);
		btnRegister.setBackground(new Color(211, 211, 211));
		btnRegister.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnRegister.addActionListener(this);
		
		setLayout();				
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRegister) {			
			Boolean insertUser = isValidate();
			
			if (insertUser) {
				System.out.println("validate success");
				try (Connection con = connection.getConnection();
	        			Statement stmt = con.createStatement();){
	        		sql = "Select * From login Where username ='" + txtUsername.getText() + "'";
	        		try (ResultSet rs = stmt.executeQuery(sql);){
	        			if (rs.next()) 
	        				JOptionPane.showMessageDialog(null,  "Username has been used");
	        			else {
	        				sql = "Insert Into login (username, password, fullname)" + "Values (?, ?, ?)";
	        				try(PreparedStatement preparedStmt = con.prepareStatement(sql);){
	        					preparedStmt.setString (1, txtUsername.getText());
	        					preparedStmt.setString (2, new String(txtConfirmPass.getPassword()));
	        					preparedStmt.setString (3, txtFullName.getText());
	        					
	        					preparedStmt.execute();
	        					JOptionPane.showMessageDialog(null,  "Successfully Registered");	        					
	        				}
	        			}
	        		}      	
	        	} catch(Exception ex) {
	        		System.err.println(ex.getMessage());
	        	}
			}
			
		} else if(e.getSource() == btnBack) {
			LoginPage window = new LoginPage();
			window.frame.setVisible(true);
			frame.dispose();
		}
	}
	
	public Boolean isValidate() {
		String uname = txtUsername.getText();
		String fullname = txtFullName.getText();
		String pass = new String(txtPassword.getPassword());
		String cpass = new String(txtConfirmPass.getPassword());
		
		if(uname.equals("")) 
			JOptionPane.showMessageDialog(null,  "Username cannot be empty!");
		
		else if(uname.contains(" ") || !uname.matches("[A-Za-z0-9]*")) 
			JOptionPane.showMessageDialog(null,  "Username input is invalid!");
		
		else if(fullname.equals("")) 
			JOptionPane.showMessageDialog(null,  "Fullname cannot be empty!");
		
		else if(!fullname.equals(fullname.trim()))
			JOptionPane.showMessageDialog(null,  "Fullname cannot contain leading/trailing blank space!");
		
		else if(!fullname.equals(fullname.replaceAll("\\s+", " ")))
			JOptionPane.showMessageDialog(null,  "Fullname cannot contain multiple middle blank space!");
		
		else if(!fullname.matches("[A-Za-z\\s+]*"))
			JOptionPane.showMessageDialog(null,  "Fullname can only contain alphabets");
		
		else if(pass.equals("")) 
			JOptionPane.showMessageDialog(null,  "Password cannot be empty!");
		
		else if(pass.length() <8 ) 
			JOptionPane.showMessageDialog(null,  "Password should be more than 8 characters!");
		
		else if(pass.contains(" ")) 
			JOptionPane.showMessageDialog(null,  "Password cannot contain blank space!");
			
		else if(!pass.equals(cpass))
			JOptionPane.showMessageDialog(null,"Password did not match");
        
		else 
        	return true;
        		
		return false;
	}
	
	public void setLayout() {		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 322, Short.MAX_VALUE)
					.addGap(40))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE)
					.addGap(43))
		);
				
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblUsername)
						.addComponent(lblFullName)
						.addComponent(lblPassword)
						.addComponent(lblConfirmPass)
						.addComponent(txtFullName)
						.addComponent(txtPassword)
						.addComponent(txtConfirmPass)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtUsername))
					.addGap(32))
				.addComponent(lblRegister, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(25)
					.addComponent(lblRegister)
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addComponent(lblUsername)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblFullName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtFullName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblPassword)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblConfirmPass)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtConfirmPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addGap(24))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
