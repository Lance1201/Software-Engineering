import java.awt.event.ActionListener;
import javax.swing.Timer;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class timer implements ActionListener {
	private Timer time;
	private int countDown = 0;
	private int hours = 0;
	private int remainderOfHours = 0;
	private int minutes = 0;
	private int seconds = 0;
	private String message;
	protected MainMenu mainmenu;

	public timer(MainMenu mainmenu) {
		time = new Timer(1000, this);
		this.mainmenu = mainmenu;
	}

	public void setCountDown(int countDown) {
		this.countDown = countDown;
	}

	public void reset() {
		hours = 0;
		minutes = 0;
		seconds = 0;
		countDown = 0;
		mainmenu.timerResetButton();
	}

	public void start(String message) {
		this.message = message;
		time.start();
	}
	
	public void start() {
		time.start();
	}

	public void stop() {
		time.stop();
	}

	public void actionPerformed(ActionEvent e) {

		if (countDown > 0) {
			getTime(countDown);
			countDown--;
			System.out.print(countDown);
			String text = writeTime();
			mainmenu.setCountDownText(text);
		} else {
			stop();
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null,  message);			
			reset();
		}

	}

	public void getTime(int sec) {
		// if we have hours minutes and seconds

		if (sec >= 3600) // if we have an hour or more
		{
			hours = sec / 3600;
			remainderOfHours = sec % 3600; // could be more or less than a min

			if (remainderOfHours >= 60) // check if remainder is more or equal to a min
			{
				minutes = remainderOfHours / 60;
				seconds = remainderOfHours % 60;
			} else { // if it's less than a min
				seconds = remainderOfHours;
			}
		}
		// if we have a min or more
		else if (sec >= 60) {
			hours = 0; // 62
			minutes = sec / 60;
			seconds = sec % 60;
		}
		// if we have just seconds
		else if (sec < 60) {
			hours = 0;
			minutes = 0;
			seconds = sec;
		}

		// i get integer hour minute second. i want to transform them to strings:

	}

	public String writeTime() {
		String strHours;
		String strMins;
		String strSecs;

		if (seconds < 10)
			strSecs = "0" + Integer.toString(seconds);
		else
			strSecs = Integer.toString(seconds);

		if (minutes < 10)
			strMins = "0" + Integer.toString(minutes);
		else
			strMins = Integer.toString(minutes);

		if (hours < 10)
			strHours = "0" + Integer.toString(hours);
		else
			strHours = Integer.toString(hours);

		String time = strHours + ":" + strMins + ":" + strSecs;
		return time;
	}

}