package ee222yb_lab3;

public class Radio {

	final static int VOL_DEFAULT = 1;
	final static int VOL_MIN = 0;
	final static int VOL_MAX = 5;
	
	final static int CHAN_DEFAULT = 1;
	final static int CHAN_MIN = 1;
	final static int CHAN_MAX = 10;
	
	private boolean radioOn = false;
	private int volume = VOL_DEFAULT;
	private int channel = CHAN_DEFAULT;
	
	final String VOL_ERROR = "New volume not within range!";
	final String CHAN_ERROR = "New channel not within range!";
	
	public String getSettings() {
		return "Settings: On " + radioOn + ", Channel " + channel + ", Volume " + volume;
	}
	
	public void turnOn() {
		radioOn = true;
	}
	
	public void turnOff() {
		radioOn = false;
		volume = VOL_DEFAULT;
		channel = CHAN_DEFAULT;
	}
	
	
	public void setVolume(int newVol) {
		if(isOff())
			return;
		if(newVol >= VOL_MIN && newVol <= VOL_MAX)
			volume = newVol;
		else
			System.out.println(VOL_ERROR);
	}
	
	public void volumeUp() {
		setVolume(volume ++);
	}

	public void volumeDown() {
		setVolume(volume --);
	}
	
	
	public void setChannel(int newChan) {
		if(isOff())
			return;
		if(newChan >= CHAN_MIN && newChan <= CHAN_MAX)
			channel = newChan;
		else
			System.out.println(CHAN_ERROR);
	}
	
	public void channelUp() {
		setChannel(channel ++);
	}
	
	public void channelDown() {
		setChannel(channel --);
	}
	
	private boolean isOff() {
		if(radioOn)
			return false;
		System.out.println("Radio off ==> No adjustment possible");
		return true;
	}
	
}
