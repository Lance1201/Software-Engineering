import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.sql.Date;
import java.sql.Time;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.BorderLayout;

public class MainMenu implements ActionListener, ListSelectionListener{
	
	private int userId = 0;
	private int shareId = 0;
	private Boolean timerStart = false;
	private String relax[];

	protected JFrame frame;
	private CardLayout cl;
	private ImageIcon icoLogo;
	private JPanel pnlCards;
	private JPanel cardSchedule;
	private JPanel cardInsertSchedule;
	private JPanel cardTimer;
	private JPanel cardVisual;
	private JPanel cardTicTacToe;
	private JPanel cardNotification;
	private JPanel pnlListSchedule;
	private JPanel pnlInsertSchedule;
	private JPanel pnlDispSchedule;
	private JPanel pnlTimer;
	private JPanel pnlPieChart;
	private JLabel lblScheduleTitle;
	private JButton btnSchedule;
	private JButton btnInsertSchedule;
	private JButton btnTimer;
	private JButton btnTicTacToe;
	private JButton btnInsert;	
	private JButton btnLogout;
	private JButton btnNotification;
	private JButton btnShare;
	private JButton btnTimeStop;
	private JButton btnTimeStart;
	private JButton btnTimeReset;
	private JButton btnRecommend;
	private JComboBox <String> cbHours;
	private JComboBox <String> cbMinutes;
	private JComboBox <String> cbSeconds;
	private JList <Object> list;
	private JList <Object> listNotification;
	private JLabel lblShareUsername;
	private JLabel lblScheduleValue;
	private JLabel lblDateValue;
	private JLabel lblStartValue;
	private JLabel lblEndValue;
	private JTextArea lblDescValue;
	private JLabel lblScheduleName;
	private JLabel lblDate;
	private JLabel lblStartTime;
	private JLabel lblEndTime;
	private JLabel lblDesc;
	private JLabel lblInsertTitle;
	private JLabel lblInsertScheduleName;
	private JLabel lblInsertDate;
	private JLabel lblInsertStart;
	private JLabel lblInsertEnd;
	private JLabel lblInsertDesc;
	private JPanel pnlMenu;
	private JPanel pnlWelcome;
	private JLabel lblWelcome;
	private JLabel lblFullName;
	private JLabel lblGameTitle;
	private JLabel lblTimerTitle;
	private JLabel lblCountDown;
	private JLabel lblHours;
	private JLabel lblMinutes;
	private JLabel lblSeconds;
	private LocalTime startTime, endTime;
	private String sql;
	private String username;
	private JTextField txtScheduleName;
	private DatePicker datePicker;
	private TimePicker timeStartPicker;
	private TimePicker timeEndPicker;
	private JTextField txtScheduleDesc;
	private Boolean insertSchedule;
	private GroupLayout gl_cardSchedule;
	private GroupLayout gl_pnlDispSchedule;
	private GroupLayout gl_cardInsertSchedule;
	private GroupLayout groupLayout;
	private GroupLayout gl_pnlInsertSchedule;
	private DefaultListModel <Object> listModel;
	private DefaultListModel <Object> listNotificationModel;
	private JScrollPane scrollPane;
	private LocalDate todayDate;
	private LocalTime timeNow;
	
	private JButton btnGameStart;
	private JButton btn00;
	private JButton btn01;
	private JButton btn02;
	private JButton btn10;
	private JButton btn11;
	private JButton btn12;
	private JButton btn20;
	private JButton btn21;
	private JButton btn22;
	private Board b;
	private timer t;
	private notificationSystem notification;
	private JButton btnVisualization;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
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
	public MainMenu() {
		initialize();
	}
	
	public MainMenu(int userId) {
		this.userId = userId;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		icoLogo = new ImageIcon("./logo/SmallLogo.png");
		frame.setIconImage(icoLogo.getImage());
		frame.setTitle("Breathe");
		
		//new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString(2) + " " + rs.getString(3));
		
		pnlCards = new JPanel(new CardLayout());
		pnlCards.setBorder(new LineBorder(Color.GRAY));
			
		pnlWelcome = new JPanel();
		pnlWelcome.setBackground(Color.WHITE);
		lblWelcome = new JLabel(" Welcome");
		lblWelcome.setVerticalAlignment(SwingConstants.BOTTOM);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(Color.DARK_GRAY);
		lblWelcome.setFont(new Font("Segoe UI", Font.PLAIN, 28));
		lblFullName = new JLabel("");
		lblFullName.setForeground(Color.DARK_GRAY);
		lblFullName.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		lblFullName.setHorizontalAlignment(SwingConstants.CENTER);
		pnlWelcome.add(lblWelcome);		
		pnlWelcome.add(lblFullName);
		
		pnlMenu = new JPanel();	
		pnlMenu.setBackground(Color.WHITE);
		
		btnSchedule = new JButton("Schedule");
		btnSchedule.setForeground(Color.DARK_GRAY);
		btnSchedule.setBackground(new Color(211, 211, 211));
		btnSchedule.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnInsertSchedule = new JButton("Insert Schedule");
		btnInsertSchedule.setForeground(Color.DARK_GRAY);
		btnInsertSchedule.setBackground(new Color(211, 211, 211));
		btnInsertSchedule.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnTimer = new JButton("Timer");
		btnTimer.setForeground(Color.DARK_GRAY);
		btnTimer.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnTimer.setBackground(new Color(211, 211, 211));
		btnVisualization = new JButton("Visualization");
		btnVisualization.setForeground(Color.DARK_GRAY);
		btnVisualization.setBackground(new Color(211, 211, 211));
		btnVisualization.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnTicTacToe = new JButton("Tic Tac Toe");
		btnTicTacToe.setBackground(new Color(211, 211, 211));
		btnTicTacToe.setForeground(Color.DARK_GRAY);
		btnTicTacToe.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnLogout = new JButton("Logout");
		btnLogout.setForeground(Color.DARK_GRAY);
		btnLogout.setBackground(new Color(211, 211, 211));
		btnLogout.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNotification = new JButton("Notification");
		btnNotification.setBackground(new Color(211, 211, 211));
		btnNotification.setForeground(Color.DARK_GRAY);
		btnNotification.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnSchedule.addActionListener(this);
		btnInsertSchedule.addActionListener(this);
		btnTimer.addActionListener(this);
		btnVisualization.addActionListener(this);
		btnTicTacToe.addActionListener(this);
		btnNotification.addActionListener(this);
		btnLogout.addActionListener(this);
		
		pnlMenu.add(btnSchedule);		
		pnlMenu.add(btnInsertSchedule);		
		pnlMenu.add(btnTimer);			
		pnlMenu.add(btnVisualization);
		pnlMenu.add(btnTicTacToe);		
		pnlMenu.add(btnNotification);
		pnlMenu.add(btnLogout);
				
		cardSchedule = new JPanel();
		cardSchedule.setBackground(new Color(0, 0, 102));
		cardSchedule.setBorder(null);
		cardInsertSchedule = new JPanel();
		cardInsertSchedule.setBackground(Color.WHITE);
		cardTimer = new JPanel();
		cardTimer.setBackground(new Color(0, 0, 102));
		cardVisual = new JPanel();
		cardVisual.setBackground(new Color(0, 0, 102));
		cardTicTacToe = new JPanel();
		cardTicTacToe.setBackground(Color.WHITE);
		cardNotification = new JPanel();
		cardNotification.setBackground(new Color(0, 0, 102));
		cl = (CardLayout)(pnlCards.getLayout());
		
		
		pnlCards.add(cardSchedule, "1");
		
		pnlListSchedule = new JPanel();		
		pnlDispSchedule = new JPanel();
		pnlDispSchedule.setBackground(Color.WHITE);
		pnlDispSchedule.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));		
		
		lblScheduleTitle = new JLabel("Schedule");				
		lblScheduleTitle.setForeground(Color.LIGHT_GRAY);
		lblScheduleTitle.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		lblScheduleName = new JLabel("SCHEDULE NAME");	
		lblScheduleName.setForeground(Color.DARK_GRAY);
		lblScheduleName.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblStartTime = new JLabel("START TIME");		
		lblStartTime.setForeground(Color.DARK_GRAY);
		lblStartTime.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblEndTime = new JLabel("END TIME");		
		lblEndTime.setForeground(Color.DARK_GRAY);
		lblEndTime.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblDesc = new JLabel("DESCRIPTION");	
		lblDesc.setForeground(Color.DARK_GRAY);
		lblDesc.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblDate = new JLabel("DATE");		
		lblDate.setForeground(Color.DARK_GRAY);
		lblDate.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		
		lblScheduleValue = new JLabel(" ");			
		lblScheduleValue.setForeground(Color.DARK_GRAY);
		lblScheduleValue.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblDateValue = new JLabel(" ");			
		lblDateValue.setForeground(Color.DARK_GRAY);
		lblDateValue.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblStartValue = new JLabel(" ");		
		lblStartValue.setForeground(Color.DARK_GRAY);
		lblStartValue.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblEndValue = new JLabel(" ");		
		lblEndValue.setForeground(Color.DARK_GRAY);
		lblEndValue.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));		
		lblDescValue = new JTextArea();
		lblDescValue.setForeground(Color.DARK_GRAY);
		lblDescValue.setEditable(false);
		lblDescValue.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblDescValue.setWrapStyleWord(true);
		lblDescValue.setRows(2);
		lblDescValue.setLineWrap(true);
						
		listModel = new DefaultListModel<Object>();
		list = new JList <Object>(listModel);
		list.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		list.setForeground(Color.DARK_GRAY);
		list.setBackground(Color.WHITE);
		list.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		list.addListSelectionListener(this);
		
		scrollPane = new JScrollPane(list);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);		
		pnlListSchedule.add(scrollPane);
		
		btnShare = new JButton("Share");
		btnShare.setBackground(new Color(211, 211, 211));
		btnShare.setForeground(Color.DARK_GRAY);
		btnShare.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		btnShare.setEnabled(false);
		btnShare.addActionListener(this);
		
		
		pnlCards.add(cardInsertSchedule, "2");
		
		pnlInsertSchedule = new JPanel();
		pnlInsertSchedule.setBackground(new Color(0, 0, 102));
		
		lblShareUsername = new JLabel("");
		lblShareUsername.setForeground(Color.DARK_GRAY);
		lblShareUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblShareUsername.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		lblInsertTitle = new JLabel("Insert Schedule");
		lblInsertTitle.setForeground(Color.DARK_GRAY);
		lblInsertTitle.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		lblInsertTitle.setHorizontalAlignment(SwingConstants.TRAILING);		
		lblInsertScheduleName = new JLabel("SCHEDULE NAME");		
		lblInsertScheduleName.setForeground(Color.LIGHT_GRAY);
		lblInsertScheduleName.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblInsertDate = new JLabel("DATE");		
		lblInsertDate.setForeground(Color.LIGHT_GRAY);
		lblInsertDate.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblInsertStart = new JLabel("START TIME");
		lblInsertStart.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblInsertStart.setForeground(Color.LIGHT_GRAY);
		lblInsertEnd = new JLabel("END TIME");
		lblInsertEnd.setForeground(Color.LIGHT_GRAY);
		lblInsertEnd.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblInsertDesc = new JLabel("SCHEDULE DESCRIPTION");
		lblInsertDesc.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblInsertDesc.setForeground(Color.LIGHT_GRAY);
		
		txtScheduleName = new JTextField();
		txtScheduleName.setForeground(Color.DARK_GRAY);
		txtScheduleName.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		txtScheduleName.setColumns(10);
		datePicker = new DatePicker();
		datePicker.getComponentToggleCalendarButton().setBackground(new Color(211, 211, 211));
		datePicker.getComponentDateTextField().setForeground(Color.DARK_GRAY);
		datePicker.getComponentToggleCalendarButton().setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		datePicker.getComponentDateTextField().setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		datePicker.getComponentDateTextField().setEditable(false);
		timeStartPicker = new TimePicker();
		timeStartPicker.getComponentToggleTimeMenuButton().setBackground(new Color(211, 211, 211));
		timeStartPicker.getComponentTimeTextField().setForeground(Color.DARK_GRAY);
		timeStartPicker.getComponentTimeTextField().setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		timeStartPicker.getComponentTimeTextField().setEditable(false);				
		timeEndPicker = new TimePicker();
		timeEndPicker.getComponentToggleTimeMenuButton().setBackground(new Color(211, 211, 211));
		timeEndPicker.getComponentTimeTextField().setForeground(Color.DARK_GRAY);
		timeEndPicker.getComponentTimeTextField().setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		timeEndPicker.getComponentTimeTextField().setEditable(false);
		txtScheduleDesc = new JTextField();
		txtScheduleDesc.setForeground(Color.DARK_GRAY);
		txtScheduleDesc.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		txtScheduleDesc.setColumns(10);
				
		btnInsert = new JButton("Insert");
		btnInsert.setBackground(new Color(211, 211, 211));
		btnInsert.setForeground(Color.DARK_GRAY);
		btnInsert.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnInsert.addActionListener(this);
		
		
		pnlCards.add(cardTimer, "3");
		cardTimer.setLayout(null);
		
		lblTimerTitle = new JLabel("Timer");
		lblTimerTitle.setForeground(Color.LIGHT_GRAY);
		lblTimerTitle.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		lblTimerTitle.setBounds(12, 13, 82, 31);
		cardTimer.add(lblTimerTitle);
		
		pnlTimer = new JPanel();
		pnlTimer.setBackground(Color.WHITE);
		pnlTimer.setBounds(12, 57, 402, 361);
		cardTimer.add(pnlTimer);
		pnlTimer.setLayout(null);
		
		lblCountDown = new JLabel("--:--:--");
		lblCountDown.setHorizontalAlignment(SwingConstants.CENTER);
		lblCountDown.setForeground(Color.DARK_GRAY);
		lblCountDown.setFont(new Font("Tahoma", Font.PLAIN, 70));
		lblCountDown.setBounds(12, 121, 378, 106);
		pnlTimer.add(lblCountDown);
		
		lblHours = new JLabel("HOURS:");
		lblHours.setForeground(Color.DARK_GRAY);
		lblHours.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblHours.setBounds(12, 13, 56, 16);
		pnlTimer.add(lblHours);
		
		lblMinutes = new JLabel("MINUTES:");
		lblMinutes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutes.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblMinutes.setForeground(Color.DARK_GRAY);
		lblMinutes.setBounds(167, 13, 69, 16);
		pnlTimer.add(lblMinutes);
		
		lblSeconds = new JLabel("SECONDS:");
		lblSeconds.setForeground(Color.DARK_GRAY);
		lblSeconds.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblSeconds.setBounds(321, 13, 69, 16);
		pnlTimer.add(lblSeconds);
		
		btnTimeStop = new JButton("Stop");
		btnTimeStop.setBackground(new Color(211, 211, 211));
		btnTimeStop.setForeground(Color.DARK_GRAY);
		btnTimeStop.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnTimeStop.setEnabled(false);
		btnTimeStop.setBounds(212, 313, 140, 35);
		pnlTimer.add(btnTimeStop);
		btnTimeStop.addActionListener(this);
		
		btnTimeStart = new JButton("Start");
		btnTimeStart.setBackground(new Color(211, 211, 211));
		btnTimeStart.setForeground(Color.DARK_GRAY);
		btnTimeStart.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnTimeStart.setBounds(59, 313, 140, 35);
		pnlTimer.add(btnTimeStart);
		btnTimeStart.addActionListener(this);
		
		cbHours = new JComboBox<String>();
		cbHours.setBounds(12, 42, 56, 22);
		pnlTimer.add(cbHours);
		
		cbMinutes = new JComboBox<String>();
		cbMinutes.setBounds(177, 42, 56, 22);
		pnlTimer.add(cbMinutes);
		
		cbSeconds = new JComboBox<String>();
		cbSeconds.setBounds(321, 42, 56, 22);
		pnlTimer.add(cbSeconds);
		
		btnTimeReset = new JButton("Reset");
		btnTimeReset.setBackground(new Color(211, 211, 211));
		btnTimeReset.setForeground(Color.DARK_GRAY);
		btnTimeReset.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		btnTimeReset.setEnabled(false);
		btnTimeReset.setBounds(317, 13, 97, 32);
		cardTimer.add(btnTimeReset);
		btnTimeReset.addActionListener(this);
		
		
		pnlCards.add(cardVisual, "4");
		cardVisual.setLayout(null);
		
		pnlPieChart = new JPanel();
		pnlPieChart.setBounds(12, 58, 394, 360);
		cardVisual.add(pnlPieChart);
		pnlPieChart.setLayout(new BorderLayout(0, 0));
		
		JLabel lblVisualTitle = new JLabel("Schedule Visualization");
		lblVisualTitle.setForeground(Color.LIGHT_GRAY);
		lblVisualTitle.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		lblVisualTitle.setBounds(12, 13, 251, 32);
		cardVisual.add(lblVisualTitle);
		
		btnRecommend = new JButton("Relax");
		btnRecommend.setForeground(Color.DARK_GRAY);
		btnRecommend.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		btnRecommend.setBackground(new Color(211, 211, 211));
		btnRecommend.setBounds(333, 13, 73, 32);
		btnRecommend.addActionListener(this);
		cardVisual.add(btnRecommend);
		
		
		pnlCards.add(cardTicTacToe, "5");
		cardTicTacToe.setLayout(null);
		
		lblGameTitle = new JLabel("Tic Tac Toe");
		lblGameTitle.setForeground(Color.DARK_GRAY);
		lblGameTitle.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		lblGameTitle.setBounds(12, 13, 131, 29);
		cardTicTacToe.add(lblGameTitle);
		
		btnGameStart = new JButton("Start / Reset");
		btnGameStart.setForeground(Color.DARK_GRAY);
		btnGameStart.setBackground(new Color(211, 211, 211));
		btnGameStart.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		btnGameStart.setBounds(307, 13, 124, 29);
		btnGameStart.addActionListener(this);
		cardTicTacToe.add(btnGameStart);
		
		JPanel pnlGrid = new JPanel();
		pnlGrid.setBounds(12, 51, 419, 367);
		cardTicTacToe.add(pnlGrid);
		pnlGrid.setLayout(new GridLayout(3, 3, 0, 0));
		
		btn00 = new JButton("");
		btn00.setFont(new Font("Segoe UI", Font.PLAIN, 70));
		btn00.addActionListener(this);
		pnlGrid.add(btn00);
		
		btn01 = new JButton("");
		btn01.setFont(new Font("Segoe UI", Font.PLAIN, 70));
		btn01.addActionListener(this);
		pnlGrid.add(btn01);
		
		btn02 = new JButton("");
		btn02.setFont(new Font("Segoe UI", Font.PLAIN, 70));
		btn02.addActionListener(this);
		pnlGrid.add(btn02);
		
		btn10 = new JButton("");
		btn10.setFont(new Font("Segoe UI", Font.PLAIN, 70));
		btn10.addActionListener(this);
		pnlGrid.add(btn10);
		
		btn11 = new JButton("");
		btn11.setFont(new Font("Segoe UI", Font.PLAIN, 70));
		btn11.addActionListener(this);
		pnlGrid.add(btn11);
		
		btn12 = new JButton("");
		btn12.setFont(new Font("Segoe UI", Font.PLAIN, 70));
		btn12.addActionListener(this);
		pnlGrid.add(btn12);
		
		btn20 = new JButton("");
		btn20.setFont(new Font("Segoe UI", Font.PLAIN, 70));
		btn20.addActionListener(this);
		pnlGrid.add(btn20);
		
		btn21 = new JButton("");
		btn21.setFont(new Font("Segoe UI", Font.PLAIN, 70));
		btn21.addActionListener(this);
		pnlGrid.add(btn21);
		
		btn22 = new JButton("");
		btn22.setFont(new Font("Segoe UI", Font.PLAIN, 70));
		btn22.addActionListener(this);
		pnlGrid.add(btn22);				
		gameStart(false);
			
		
		pnlCards.add(cardNotification, "6");
		cardNotification.setLayout(null);
		
		JLabel lblNotificationTitle = new JLabel("Notification");
		lblNotificationTitle.setForeground(Color.LIGHT_GRAY);
		lblNotificationTitle.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		lblNotificationTitle.setEnabled(true);
		lblNotificationTitle.setBounds(12, 13, 139, 38);
		cardNotification.add(lblNotificationTitle);
		
		listNotificationModel = new DefaultListModel<Object>();
		listNotification = new JList <Object>(listNotificationModel);
		listNotification.setForeground(Color.DARK_GRAY);
		listNotification.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		listNotification.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listNotification.setBounds(12, 50, 399, 368);
		cardNotification.add(listNotification);
		
		//notification
		notifySchedule();
		
		//set relax array
		relax = new String[10];
		insertRecommendation();
		
		for(int i = 0; i < 24; i++) {
			if(i < 10)
				cbHours.addItem("0"+i);
			else
				cbHours.addItem(Integer.toString(i));
		}
		
		for(int i = 0; i < 60; i++) {
			if(i < 10) {
				cbMinutes.addItem("0"+i);
				cbSeconds.addItem("0"+i);
			}else {
				cbMinutes.addItem(Integer.toString(i));
				cbSeconds.addItem(Integer.toString(i));
			}				
		}
		
		try (Connection con = connection.getConnection();
			Statement stmt = con.createStatement();){
			sql = "Select fullname from login Where u_id = '" + userId + "'";
			
			try (ResultSet rs = stmt.executeQuery(sql);){
				if (rs.next()) {
					lblFullName.setText(rs.getString(1)); //set fullname
				}
			}
			sql = "Select s_name from schedule Where u_id = '" + userId + "'";
			
			try (ResultSet rs = stmt.executeQuery(sql);){
				while (rs.next()) {
					listModel.addElement(rs.getString(1)); //set Schedule list
				}
			}
		} catch(Exception ex){
			System.err.println(ex.getMessage());
		}		
		runLayout();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSchedule) {
			cl.show(pnlCards, "1");
			listModel.clear();
			try (Connection con = connection.getConnection();
					Statement stmt = con.createStatement();){
					sql = "Select s_name from schedule Where u_id = '" + userId + "'";					
					
					try (ResultSet rs = stmt.executeQuery(sql);){
						while (rs.next()) {
							listModel.addElement(rs.getString(1));
						}
					}
			} catch(Exception ex){
					System.err.println(ex.getMessage());
			}			
		}		
		else if(e.getSource() == btnInsertSchedule) {
			cl.show(pnlCards, "2");			
		}
		else if(e.getSource() == btnTimer) {
			cl.show(pnlCards, "3");			
		}
		else if (e.getSource() == btnVisualization) {
			cl.show(pnlCards, "4");
			todayDate = LocalDate.now();
			DefaultPieDataset dataPie = new DefaultPieDataset();
			try(Connection con = connection.getConnection();
					Statement stmt = con.createStatement();){
				sql = "Select s_name, s_starttime, s_endtime from schedule Where u_id = '" + userId + "' AND s_date = '" + todayDate + "'";
				try (ResultSet rs = stmt.executeQuery(sql);){
					if(rs.next()) {
						do {
							dataPie.setValue(rs.getString(1), rs.getInt(3) - rs.getInt(2));
						}while (rs.next());
					}
					else 
						dataPie.setValue("No Schedule", 1);				
				}
			}
			catch(Exception ex){
				System.err.println(ex.getMessage());
			}	
			finally {
				JFreeChart chartPie = ChartFactory.createPieChart(
						"Pie Chart of Today Schedule",
						dataPie,
						true, // legend?
						true, 
						false);
				ChartPanel pieChart = new ChartPanel(chartPie);
				pnlPieChart.removeAll();
				pnlPieChart.add(pieChart, BorderLayout.CENTER);
			}
		} 
		else if (e.getSource() == btnTicTacToe) {
			cl.show(pnlCards, "5");	
		}
		else if (e.getSource() == btnNotification){
			cl.show(pnlCards, "6");
			refreshNotification();
		}
		else if (e.getSource() == btnLogout) {
			int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
			if (dialogResult == JOptionPane.YES_OPTION) {
				LoginPage window = new LoginPage();
				window.frame.setVisible(true);
				frame.dispose();
			}			
		}
		else if (e.getSource() == btnInsert) {			
			insertSchedule = isScheduleValidate();
			timeNow = LocalTime.now();
			todayDate = LocalDate.now();
			if (insertSchedule && userId != 0) {
				
				try (Connection con = connection.getConnection();
						Statement stmt = con.createStatement();){
					sql = "Select * From schedule where s_name ='" + txtScheduleName.getText() + "' AND u_id ='" + userId + "'";
					try (ResultSet rs = stmt.executeQuery(sql);){
						if(rs.next())
							JOptionPane.showMessageDialog(null,  "Schedule Name has been used");
						
						else {
							sql = "Insert Into schedule (u_id, s_name, s_date, s_starttime, s_endtime, s_desc)"+" Values (?,?,?,?,?,?)";
							
							try (PreparedStatement preparedStmt = con.prepareStatement(sql);){
									preparedStmt.setInt (1, userId);
									preparedStmt.setString (2, txtScheduleName.getText());
									preparedStmt.setDate(3, Date.valueOf(datePicker.getDateStringOrEmptyString()));
									preparedStmt.setTime(4, Time.valueOf(timeStartPicker.getTimeStringOrEmptyString()+ ":00")); 
									preparedStmt.setTime(5, Time.valueOf(timeEndPicker.getTimeStringOrEmptyString()+ ":00"));
									preparedStmt.setString(6, txtScheduleDesc.getText());
	        		
									preparedStmt.execute();
									JOptionPane.showMessageDialog(null,  "Insert Schedule Successfully");
									
									
									if(todayDate.equals(LocalDate.parse(datePicker.getDateStringOrEmptyString())) && timeNow.isBefore(LocalTime.parse(timeStartPicker.getTimeStringOrEmptyString()+ ":00"))) {
										notification = new notificationSystem(this);
										notification.startInsertNotification(todayDate.toString(), timeStartPicker.getTimeStringOrEmptyString()+ ":00", txtScheduleName.getText());									
									}
							}	
						}
					}						        		        			        			        		      	
	        	} catch(Exception ex) {	        
	        		System.err.println(ex.getMessage());
	        	}			
			}					
		}
		else if (e.getSource() == btnShare) {	
			if(list.getSelectedValue() != null) {
				System.out.println(list.getSelectedValue());
				System.out.println(userId);
				
				do {
					username = JOptionPane.showInputDialog(null, "Enter the username that recieve the schedule.", "Share Schedule", JOptionPane.QUESTION_MESSAGE);
					if (username.trim().isEmpty())
						JOptionPane.showMessageDialog(null, "Username should not be empty.");	
				} while(username.trim().isEmpty());
				
				try (Connection con = connection.getConnection();
	        			Statement stmt = con.createStatement();){
					sql = "Select u_id from login where username = '" + username + "'";
					try (ResultSet rs = stmt.executeQuery(sql);){
						if(rs.next()) {
							shareId = rs.getInt(1);
							if (shareId == userId) 
								JOptionPane.showMessageDialog(null,  "Cannot share the schedule to yourself");
							else {							
								sql = "Select s_id from schedule where u_id ='" + shareId +"' AND s_name ='" + lblScheduleValue.getText() + "'";
								try (ResultSet rs2 = stmt.executeQuery(sql);){
									if(rs2.next()) {
										JOptionPane.showMessageDialog(null,  "User already have the same schedule.");
									}
									else {
										sql = "Insert Into schedule (u_id, s_name, s_date, s_starttime, s_endtime, s_desc, share_id)"+" Values (?,?,?,?,?,?,?)";
										try(PreparedStatement preparedStmt = con.prepareStatement(sql);){
											preparedStmt.setInt (1, shareId);
											preparedStmt.setString (2, lblScheduleValue.getText());
											preparedStmt.setDate(3, Date.valueOf(lblDateValue.getText()));
											preparedStmt.setTime(4, Time.valueOf(lblStartValue.getText())); 
											preparedStmt.setTime(5, Time.valueOf(lblEndValue.getText()));
											preparedStmt.setString(6, lblDescValue.getText());
											preparedStmt.setInt(7, userId);
								
											preparedStmt.execute();
											JOptionPane.showMessageDialog(null,  "Share to "+ username +" sucessfully.");																						
										}
									}
								}
							}
						}else
							JOptionPane.showMessageDialog(null, "Username not found.");	
					}
					
				} catch(Exception ex) {
	        		System.err.println(ex.getMessage());
	        	}
				
			}			
			else
				JOptionPane.showMessageDialog(null, "Please select a schedule.");				
		}
		else if (e.getSource() == btnGameStart) {							        
	        String[] options = {"Computer", "Me"};
	        int choice = JOptionPane.showOptionDialog(null, "Who will start first?", "Start Game", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
	        	    options, options[0]);
	        
	        if (choice == JOptionPane.YES_OPTION){
	        	Random rand = new Random();
	        	gameStart(true);
	            Point p = new Point(rand.nextInt(3), rand.nextInt(3));
	            selectButton(p.x, p.y, 1);
	            b.placeAMove(p, 1);

	        }else if (choice == JOptionPane.NO_OPTION) 
	        	gameStart(true);	        
		}
		else if (e.getSource() == btn00) {			
			Point userMove = new Point(0, 0);
			selectButton(userMove.x, userMove.y, 2);
            b.placeAMove(userMove, 2); //2 is user
            //b.displayBoard();
            
            if (!b.isGameOver()) {
            	b.minimax(0, 1);  
            	selectButton(b.computersMove.x, b.computersMove.y, 1);
            	b.placeAMove(b.computersMove, 1);
            	//b.displayBoard();
            	if (b.isGameOver()) gameResult();
            }else 
            	gameResult();           
		}
		else if (e.getSource() == btn01) {			
			Point userMove = new Point(0, 1);
			selectButton(userMove.x, userMove.y, 2);
            b.placeAMove(userMove, 2); //2 is user
            //b.displayBoard();
            
            if (!b.isGameOver()) {
            	b.minimax(0, 1);  
            	selectButton(b.computersMove.x, b.computersMove.y, 1);
            	b.placeAMove(b.computersMove, 1);
            	//b.displayBoard();
            	if (b.isGameOver()) gameResult();
            }else 
            	gameResult();               
		}
		else if (e.getSource() == btn02) {			
			Point userMove = new Point(0, 2);
			selectButton(userMove.x, userMove.y, 2);
            b.placeAMove(userMove, 2); //2 is user
            //b.displayBoard();
            
            if (!b.isGameOver()) {
            	b.minimax(0, 1);  
            	selectButton(b.computersMove.x, b.computersMove.y, 1);
            	b.placeAMove(b.computersMove, 1);
            	//b.displayBoard();
            	if (b.isGameOver()) gameResult();
            }else 
            	gameResult();               
		}
		else if (e.getSource() == btn10) {			
			Point userMove = new Point(1, 0);
			selectButton(userMove.x, userMove.y, 2);
            b.placeAMove(userMove, 2); //2 is user
            //b.displayBoard();
            
            if (!b.isGameOver()) {
            	b.minimax(0, 1);  
            	selectButton(b.computersMove.x, b.computersMove.y, 1);
            	b.placeAMove(b.computersMove, 1);
            	//b.displayBoard();
            	if (b.isGameOver()) gameResult();
            }else 
            	gameResult();               
		}
		else if (e.getSource() == btn11) {			
			Point userMove = new Point(1, 1);
			selectButton(userMove.x, userMove.y, 2);
            b.placeAMove(userMove, 2); //2 is user
            //b.displayBoard();
            
            if (!b.isGameOver()) {
            	b.minimax(0, 1);  
            	selectButton(b.computersMove.x, b.computersMove.y, 1);
            	b.placeAMove(b.computersMove, 1);
            	//b.displayBoard();
            	if (b.isGameOver()) gameResult();
            }else 
            	gameResult();                
		}
		else if (e.getSource() == btn12) {			
			Point userMove = new Point(1, 2);
			selectButton(userMove.x, userMove.y, 2);
            b.placeAMove(userMove, 2); //2 is user
            //b.displayBoard();
            
            if (!b.isGameOver()) {
            	b.minimax(0, 1);  
            	selectButton(b.computersMove.x, b.computersMove.y, 1);
            	b.placeAMove(b.computersMove, 1);
            	//b.displayBoard();
            	if (b.isGameOver()) gameResult();
            }else 
            	gameResult();               
		}
		else if (e.getSource() == btn20) {			
			Point userMove = new Point(2, 0);
			selectButton(userMove.x, userMove.y, 2);
            b.placeAMove(userMove, 2); //2 is user
            //b.displayBoard();
            
            if (!b.isGameOver()) {
            	b.minimax(0, 1);  
            	selectButton(b.computersMove.x, b.computersMove.y, 1);
            	b.placeAMove(b.computersMove, 1);
            	//b.displayBoard();
            	if (b.isGameOver()) gameResult();
            }else 
            	gameResult();               
		}
		else if (e.getSource() == btn21) {			
			Point userMove = new Point(2, 1);
			selectButton(userMove.x, userMove.y, 2);
            b.placeAMove(userMove, 2); //2 is user
            //b.displayBoard();
            
            if (!b.isGameOver()) {
            	b.minimax(0, 1);  
            	selectButton(b.computersMove.x, b.computersMove.y, 1);
            	b.placeAMove(b.computersMove, 1);
            	//b.displayBoard();
            	if (b.isGameOver()) gameResult();
            }else 
            	gameResult();               
		}
		else if (e.getSource() == btn22) {			
			Point userMove = new Point(2, 2);
			selectButton(userMove.x, userMove.y, 2);
            b.placeAMove(userMove, 2); //2 is user
            //b.displayBoard();
            
            if (!b.isGameOver()) {
            	b.minimax(0, 1);  
            	selectButton(b.computersMove.x, b.computersMove.y, 1);
            	b.placeAMove(b.computersMove, 1);
            	//b.displayBoard();
            	if (b.isGameOver()) gameResult();
            }else 
            	gameResult();              
		}
		else if (e.getSource() == btnTimeStart) {
			if(convertSecond() != 0) {
				cbHours.setEnabled(false);
				cbMinutes.setEnabled(false);
				cbSeconds.setEnabled(false);
				btnTimeStart.setEnabled(false);
				btnTimeStop.setEnabled(true);			
				btnTimeReset.setEnabled(false);
				if(!timerStart) {				
					String text = JOptionPane.showInputDialog(null, "Please enter a message", "Timer", JOptionPane.QUESTION_MESSAGE);
					if(text != null) {
						t = new timer(this);
						t.setCountDown(convertSecond());
						timerStart = true;
						t.start(text);
					}else {
						cbHours.setEnabled(true);
						cbMinutes.setEnabled(true);
						cbSeconds.setEnabled(true);
						btnTimeStart.setEnabled(true);
						btnTimeStop.setEnabled(false);			
						btnTimeReset.setEnabled(false);
					}			
				}else 
					t.start();				
			}else
				JOptionPane.showMessageDialog(null, "Please select a valid time");							
		}
		else if (e.getSource() == btnTimeStop) {
			t.stop();
			btnTimeStart.setEnabled(true);
			btnTimeStop.setEnabled(false);
			btnTimeReset.setEnabled(true);			
		}
		else if (e.getSource() == btnTimeReset) {
			timerResetButton();
			t.reset();
		}
		else if (e.getSource() == btnRecommend) {
			JOptionPane.showMessageDialog(null, relax[new Random().nextInt(relax.length)], "Ways to Relax and Destress.", JOptionPane.PLAIN_MESSAGE);
		}

	}
	
	public void valueChanged(ListSelectionEvent arg0) {
        if (!arg0.getValueIsAdjusting()) {      	
        	try (Connection con = connection.getConnection();
        			Statement stmt = con.createStatement();){
        		sql = "Select s_name, s_date, s_starttime, s_endtime, s_desc, share_id from schedule where u_id = '" + userId + "' and s_name = '" + list.getSelectedValue() + "'";
        		try (ResultSet rs = stmt.executeQuery(sql);){
        			if (rs.next()) {
        				lblScheduleValue.setText(rs.getString(1));
        				lblDateValue.setText(rs.getString(2));
        				lblStartValue.setText(rs.getString(3));
        				lblEndValue.setText(rs.getString(4));
        				lblDescValue.setText(rs.getString(5));       				
        				
        				if(rs.getInt(6) != 0) {
        					sql = "Select fullname from login where u_id = '" + rs.getInt(6) + "'";
        					try(ResultSet rs2 = stmt.executeQuery(sql);){
        						if (rs2.next()) {
        							lblShareUsername.setText(rs2.getString(1));
        							btnShare.setEnabled(false);
        						}       							       						
        					}       						 							
        				}
        				else {
        					lblShareUsername.setText(" ");
        					btnShare.setEnabled(true);
        				}
        			}      			
        		}      	
        	} catch(Exception ex) {
        		System.err.println(ex.getMessage());
        	}
 
        }
    }
	
	public Boolean isScheduleValidate() {		
		if (txtScheduleName.getText().isEmpty() || txtScheduleName.getText().trim().isEmpty()) 
			JOptionPane.showMessageDialog(null, "Schedule Name should not be empty.");
			
		else if (datePicker.getDateStringOrEmptyString().isEmpty()) 
			JOptionPane.showMessageDialog(null, "Date should not be empty.");			
			
		else if (timeStartPicker.getTimeStringOrEmptyString().isEmpty()) 
			JOptionPane.showMessageDialog(null, "Start Time should not be empty.");
			
		else if (timeEndPicker.getTimeStringOrEmptyString().isEmpty()) 
			JOptionPane.showMessageDialog(null, "End Time should not be empty.");
			
		else if (!timeStartPicker.getTimeStringOrEmptyString().isEmpty() 
				&& !timeEndPicker.getTimeStringOrEmptyString().isEmpty()) {
			startTime = LocalTime.parse(timeStartPicker.getTimeStringOrEmptyString());
			endTime = LocalTime.parse(timeEndPicker.getTimeStringOrEmptyString());
			
			if(startTime.isAfter(endTime) || startTime.equals(endTime)) 
				JOptionPane.showMessageDialog(null, "Start Time should be more than End Time");
				
			else 
				return true;					
		}else 
			System.out.println("This should not happen");
		
		return false;
			
	}
	
	public void selectButton(int x, int y, int player) {
		String shape = "?";
		Color color = Color.WHITE;
		if (player == 1) {//computer
			shape = "O";
			color = Color.LIGHT_GRAY;
		}else if (player == 2) {//user
			shape = "X";
			color = Color.DARK_GRAY;
		}
				
		if (x == 0) {
			if (y == 0) {
				btn00.setEnabled(false);
				btn00.setForeground(color);
				btn00.setText(shape);				
			}else if (y == 1) {
				btn01.setEnabled(false);
				btn01.setForeground(color);
				btn01.setText(shape);				
			}else if (y == 2) {
				btn02.setEnabled(false);
				btn02.setForeground(color);
				btn02.setText(shape);				
			}				
		}else if (x == 1) {
			if (y == 0) {
				btn10.setEnabled(false);
				btn10.setForeground(color);
				btn10.setText(shape);				
			}else if (y == 1) {
				btn11.setEnabled(false);
				btn11.setForeground(color);
				btn11.setText(shape);			
			}else if (y == 2) {
				btn12.setEnabled(false);
				btn12.setForeground(color);
				btn12.setText(shape);				
			}
		}else if (x == 2) {
			if (y == 0) {
				btn20.setEnabled(false);
				btn20.setForeground(color);
				btn20.setText(shape);				
			}else if (y == 1) {
				btn21.setEnabled(false);
				btn21.setForeground(color);
				btn21.setText(shape);				
			}else if (y == 2) {
				btn22.setEnabled(false);
				btn22.setForeground(color);
				btn22.setText(shape);				
			}
		}
	}
	
	public void gameStart(Boolean bool) {
		if(bool) {
			b = new Board();
			btn00.setText("");
			btn01.setText("");
			btn02.setText("");
			btn10.setText("");
			btn11.setText("");
			btn12.setText("");
			btn20.setText("");
			btn21.setText("");
			btn22.setText("");
		} 
		
		btn00.setEnabled(bool);		
		btn01.setEnabled(bool);		
		btn02.setEnabled(bool);		
		btn10.setEnabled(bool);		
		btn11.setEnabled(bool);		
		btn12.setEnabled(bool);		
		btn20.setEnabled(bool);		
		btn21.setEnabled(bool);	
		btn22.setEnabled(bool);		
	}
	
	public void setCountDownText(String text) {
		lblCountDown.setText(text);
	}
	
	public int convertSecond() {
		int hour = Integer.parseInt(cbHours.getSelectedItem().toString());
		int minutes = Integer.parseInt(cbMinutes.getSelectedItem().toString());
		int seconds = Integer.parseInt(cbSeconds.getSelectedItem().toString());
		hour = hour*3600;
		minutes = minutes* 60;
		return hour+minutes+seconds;
	}
	
	public void timerResetButton() {
		cbHours.setEnabled(true);
		cbMinutes.setEnabled(true);
		cbSeconds.setEnabled(true);
		btnTimeStart.setEnabled(true);
		btnTimeStop.setEnabled(false);			
		btnTimeReset.setEnabled(false);
		lblCountDown.setText("--:--:--");
		timerStart = false;		
	}
	
	public void gameResult() {
		if (b.hasXWon()) {
			JOptionPane.showMessageDialog(null, "Unfortunately, you lost!");
			gameStart(false);
		} 			
        else if (b.hasOWon()) 
            System.out.println("You win!"); //Can't happen
        else 
        	JOptionPane.showMessageDialog(null, "It's a draw");
	}
	
	public void insertRecommendation() {
		relax[0] = "Listen to your favourite song will help you to destress.";
		relax[1] = "Try to play our included Tic Tac Toe minigame, it might loosen you up.";
		relax[2] = "Take a break from your work and have some snack and sweets.";
		relax[3] = "Stop your work and enjoy the scenery around you.";
		relax[4] = "Go and have a chat with someone.";
		relax[5] = "Take a tea break and have some refreshing green tea.";
		relax[6] = "Reading will help you to destress.";
		relax[7] = "Head outside and have some fresh air.";
		relax[8] = "Watch your favourite show or video on your free time.";
		relax[9] = "Playing video games is a good way to relieve your stress.";
	}
	
	public void notifySchedule() {
		Boolean gotNotification = false;	
		timeNow = LocalTime.now();
		todayDate = LocalDate.now();
		try (Connection con = connection.getConnection();
				Statement stmt = con.createStatement();){
			sql = "Select s_starttime, s_name from schedule Where u_id = '" + userId + "' and s_date = '" + todayDate + "'";
			try (ResultSet rs = stmt.executeQuery(sql);){
				if(rs.next()) {
					do {
						if(timeNow.isBefore(LocalTime.parse(rs.getString(1))) ) {
							//System.out.println("got notification");
							notification = new notificationSystem(this);
							notification.startNotification(todayDate.toString(), rs.getString(1), rs.getString(2));
							gotNotification = true;
						}					
					}while(rs.next() && !gotNotification);
				}
				else
					System.out.println("no notification");
			}
		}
		catch(Exception ex){
			System.err.println(ex.getMessage());
		}		
	}
	
	public void refreshNotification() {
		listNotificationModel.clear();
		
		try (Connection con = connection.getConnection();
				Statement stmt = con.createStatement();){
				sql = "Select n_name from notification Where u_id = '" + userId + "'";					
				
				try (ResultSet rs = stmt.executeQuery(sql);){
					while (rs.next()) {
						listNotificationModel.addElement(rs.getString(1));
					}
				}
		} catch(Exception ex){
				System.err.println(ex.getMessage());
		}
	}
	
	public void insertNotification(String message) {
		try (Connection con = connection.getConnection();
				Statement stmt = con.createStatement();){
			sql = "Insert Into notification (u_id, n_name)"+" Values (?,?)";
			
			try(PreparedStatement preparedStmt = con.prepareStatement(sql);){
				preparedStmt.setInt (1, userId);
				preparedStmt.setString (2, message);
	
				preparedStmt.execute();
			}
		}
		catch(Exception ex){
			System.err.println(ex.getMessage());
		}finally {
			refreshNotification();
		}
	}
	
	public void runLayout() {
		gl_cardSchedule = new GroupLayout(cardSchedule);
		gl_cardSchedule.setHorizontalGroup(
			gl_cardSchedule.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cardSchedule.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_cardSchedule.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cardSchedule.createSequentialGroup()
							.addComponent(pnlListSchedule, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pnlDispSchedule, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_cardSchedule.createSequentialGroup()
							.addComponent(lblScheduleTitle)
							.addPreferredGap(ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
							.addComponent(btnShare)))
					.addContainerGap())
		);
		gl_cardSchedule.setVerticalGroup(
			gl_cardSchedule.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_cardSchedule.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_cardSchedule.createParallelGroup(Alignment.LEADING)
						.addComponent(lblScheduleTitle)
						.addComponent(btnShare))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_cardSchedule.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlDispSchedule, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlListSchedule, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		

		gl_pnlDispSchedule = new GroupLayout(pnlDispSchedule);
		gl_pnlDispSchedule.setHorizontalGroup(
			gl_pnlDispSchedule.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_pnlDispSchedule.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlDispSchedule.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlDispSchedule.createSequentialGroup()
							.addGap(10)
							.addComponent(lblDescValue, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlDispSchedule.createSequentialGroup()
							.addComponent(lblScheduleName)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblShareUsername, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblDate)
						.addComponent(lblStartTime)
						.addComponent(lblEndTime)
						.addComponent(lblDesc)
						.addGroup(gl_pnlDispSchedule.createSequentialGroup()
							.addGap(10)
							.addComponent(lblScheduleValue))
						.addGroup(gl_pnlDispSchedule.createSequentialGroup()
							.addGap(10)
							.addComponent(lblDateValue))
						.addGroup(gl_pnlDispSchedule.createSequentialGroup()
							.addGap(10)
							.addComponent(lblStartValue))
						.addGroup(gl_pnlDispSchedule.createSequentialGroup()
							.addGap(10)
							.addComponent(lblEndValue)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_pnlDispSchedule.setVerticalGroup(
			gl_pnlDispSchedule.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDispSchedule.createSequentialGroup()
					.addGroup(gl_pnlDispSchedule.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlDispSchedule.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblScheduleName)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblScheduleValue)
							.addGap(13)
							.addComponent(lblDate)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDateValue)
							.addGap(13)
							.addComponent(lblStartTime)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblStartValue)
							.addGap(13)
							.addComponent(lblEndTime)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblEndValue)
							.addGap(13)
							.addComponent(lblDesc))
						.addComponent(lblShareUsername))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDescValue, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_cardInsertSchedule = new GroupLayout(cardInsertSchedule);
		gl_cardInsertSchedule.setHorizontalGroup(
			gl_cardInsertSchedule.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cardInsertSchedule.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_cardInsertSchedule.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlInsertSchedule, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInsertTitle))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		gl_cardInsertSchedule.setVerticalGroup(
			gl_cardInsertSchedule.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cardInsertSchedule.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInsertTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlInsertSchedule, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnlInsertSchedule = new GroupLayout(pnlInsertSchedule);
		gl_pnlInsertSchedule.setHorizontalGroup(
			gl_pnlInsertSchedule.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlInsertSchedule.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_pnlInsertSchedule.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblInsertDesc)
						.addComponent(lblInsertEnd)
						.addComponent(lblInsertStart)
						.addComponent(lblInsertDate)
						.addComponent(lblInsertScheduleName)
						.addComponent(timeEndPicker, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(timeStartPicker, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(datePicker, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtScheduleName, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
						.addComponent(txtScheduleDesc))
					.addContainerGap(25, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_pnlInsertSchedule.createSequentialGroup()
					.addContainerGap(176, Short.MAX_VALUE)
					.addComponent(btnInsert, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addGap(118))
		);
		gl_pnlInsertSchedule.setVerticalGroup(
			gl_pnlInsertSchedule.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlInsertSchedule.createSequentialGroup()
					.addGap(7)
					.addComponent(lblInsertScheduleName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtScheduleName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblInsertDate)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblInsertStart)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(timeStartPicker, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblInsertEnd)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(timeEndPicker, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblInsertDesc)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtScheduleDesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnInsert)
					.addGap(8))
		);
		pnlInsertSchedule.setLayout(gl_pnlInsertSchedule);
		groupLayout = new GroupLayout(frame.getContentPane());
		
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(pnlMenu, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
						.addComponent(pnlWelcome, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlCards, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(pnlWelcome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pnlMenu, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE))
						.addComponent(pnlCards, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		pnlDispSchedule.setLayout(gl_pnlDispSchedule);
		pnlListSchedule.setLayout(new BoxLayout(pnlListSchedule, BoxLayout.X_AXIS));
		cardSchedule.setLayout(gl_cardSchedule);
		cardInsertSchedule.setLayout(gl_cardInsertSchedule);		
		pnlWelcome.setLayout(new GridLayout(2, 1, 0, 0));
		pnlMenu.setLayout(new GridLayout(7, 0, 0, 0));
		
		
		frame.getContentPane().setLayout(groupLayout);
	}
}
