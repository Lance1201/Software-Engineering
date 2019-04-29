import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.border.CompoundBorder;

public class LoginPage implements ActionListener{

	protected JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private ImageIcon icoLogo;
	private JPanel pnlLogin;
	private JLabel lblLogo;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblLogin;
	private JButton btnLogin;
	private JButton btnRegister;
	private GroupLayout glMain;
	private GroupLayout glLogin;
	private String sql;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
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
	public LoginPage() {
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
		
		/* icon logo on the top left */
		icoLogo = new ImageIcon("./logo/SmallLogo.png");
		frame.setIconImage(icoLogo.getImage());
		frame.setTitle("Breathe");
		
		/* Big Logo on Middle */
		lblLogo = new JLabel("");
		lblLogo.setAlignmentY(Component.TOP_ALIGNMENT);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(new ImageIcon("./logo/BigLogo.png").getImage().getScaledInstance(320, 320, Image.SCALE_DEFAULT)));
		
		/* Login Panel in Middle */
		pnlLogin = new JPanel();
		pnlLogin.setBackground(new Color(0, 0, 102));
		pnlLogin.setBorder(new CompoundBorder());
		
		/*Login Label*/
		lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.LIGHT_GRAY);
		lblLogin.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		
		/*Username textfield*/
		txtUsername = new JTextField();
		txtUsername.setForeground(Color.DARK_GRAY);
		txtUsername.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		txtUsername.setColumns(10);
		
		/*Username Label*/
		lblUsername = new JLabel("USERNAME");
		lblUsername.setForeground(Color.LIGHT_GRAY);
		lblUsername.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));		
		lblUsername.setLabelFor(txtUsername);
		
		/*Password textfield*/
		txtPassword = new JPasswordField();		
		txtPassword.setForeground(Color.DARK_GRAY);
		txtPassword.setColumns(10);
		txtPassword.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		
		/*Password Label*/
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.LIGHT_GRAY);
		lblPassword.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblPassword.setLabelFor(txtPassword);

		/*Login Button*/
		btnLogin = new JButton("Login");
		btnLogin.setForeground(Color.DARK_GRAY);
		btnLogin.setBackground(new Color(211, 211, 211));
		btnLogin.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnLogin.addActionListener(this);

		/*Register Button*/
		btnRegister = new JButton("Register");
		btnRegister.setBackground(new Color(211, 211, 211));
		btnRegister.setForeground(Color.DARK_GRAY);
		btnRegister.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnRegister.addActionListener(this);
		
		/*run GroupLayout*/
		runLayout();
	}
	
	/*GroupLayout*/
	public void runLayout() {
		glMain = new GroupLayout(frame.getContentPane());
		glMain.setHorizontalGroup(
			glMain.createParallelGroup(Alignment.TRAILING)
				.addGroup(glMain.createSequentialGroup()
					.addGroup(glMain.createParallelGroup(Alignment.LEADING)
						.addGroup(glMain.createSequentialGroup()
							.addGap(87)
							.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
						.addGroup(glMain.createSequentialGroup()
							.addGap(40)
							.addComponent(pnlLogin, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		glMain.setVerticalGroup(
			glMain.createParallelGroup(Alignment.TRAILING)
				.addGroup(glMain.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(pnlLogin, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
		);
		
		glLogin = new GroupLayout(pnlLogin);
		glLogin.setHorizontalGroup(
			glLogin.createParallelGroup(Alignment.TRAILING)
				.addGroup(glLogin.createSequentialGroup()
					.addGap(36)
					.addGroup(glLogin.createParallelGroup(Alignment.LEADING)
						.addGroup(glLogin.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRegister, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
						.addComponent(lblPassword)
						.addComponent(txtPassword, 288, 288, 288)
						.addComponent(lblUsername)
						.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
					.addGap(29))
				.addComponent(lblLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
		);
		glLogin.setVerticalGroup(
			glLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, glLogin.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLogin)
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addComponent(lblUsername)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPassword)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(glLogin.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addGap(21))
		);
		
		pnlLogin.setLayout(glLogin);
		frame.getContentPane().setLayout(glMain);
	}
	
	/*Button actionListener*/
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnLogin) {
			try (Connection con = connection.getConnection();
					Statement stmt = con.createStatement();){
				
				sql = "Select u_id from login Where username ='" + txtUsername.getText() + "'"
						+ "AND password ='" + new String(txtPassword.getPassword()) + "'";
				
				try(ResultSet rs = stmt.executeQuery(sql);){
					if (rs.next()) {
						MainMenu window = new MainMenu(rs.getInt(1));
					
						window.frame.setVisible(true);					
						frame.dispose();
					} else 
						JOptionPane.showMessageDialog(null, "Wrong id or password");					
				}
											
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Failed to connect to database", "Warning", JOptionPane.WARNING_MESSAGE);
			} 
		}
		else if(e.getSource() == btnRegister) {
			RegisterPage window = new RegisterPage();
			window.frame.setVisible(true);
			frame.dispose();
		}
		
	}
}
