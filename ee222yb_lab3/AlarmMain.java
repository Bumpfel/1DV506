package ee222yb_lab3;

public class AlarmMain {

	public static void main(String[] args) {
		AlarmClock alarm = new AlarmClock(23, 48);
		alarm.displayTime();
		alarm.setAlarm(6, 15);
		
		final int TIME_ADVANCE = 500; // (minutes)
		for(int i = 0; i < TIME_ADVANCE; i ++) {
			alarm.timeTick();
		}
		alarm.displayTime();
	}

}
