import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class notificationSystem {

	protected MainMenu mainMenu;
	private Date notify;
	private Timer timer;
	
	public notificationSystem(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
	}
	/*
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}*/
	public void startNotification(String todayDate, String notifyTime, String message) {
		System.out.println(todayDate + " " + notifyTime);

		try {
			//notify = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-04-25 22:43:00");	
			notify = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(todayDate + " " + notifyTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(notify);
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, message + " start now. " + notifyTime);
				mainMenu.insertNotification(message + " start now. " + notifyTime);
				mainMenu.notifySchedule();
			}			
		};
		timer = new Timer();
		System.out.println("not yet running");
		timer.schedule(timerTask, notify);
		
	}
	
	public void startInsertNotification(String todayDate, String notifyTime, String message) {
		System.out.println(todayDate + " " + notifyTime);

		try {	
			notify = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(todayDate + " " + notifyTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(notify);
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, message + " start now. " + notifyTime);
				mainMenu.insertNotification(message + " start now. " + notifyTime);
			}			
		};
		timer = new Timer();
		System.out.println("not yet running");
		timer.schedule(timerTask, notify);
	}
}
