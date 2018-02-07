package ee222yb_lab3;

public class MultiDisplay {

	private String displayMessage; // Defaults to null
	private int displayRows; // Defaults to 0
	
	public MultiDisplay() { // Not really needed in this case. Java creates an empty constructor automatically if there is none
	}
	
	/**
	 * Sets display message of the MultiDisplay object
	 * @param text  Message
	 */
	public void setDisplayMessage(String text) {
		displayMessage = text;
	}

	/**
	 * Sets number of output rows for the object
	 * @param count  Number of output rows 
	 */
	public void setDisplayCount(int count) {
		if(count >= 0)
			displayRows = count;
		else
			System.out.println("Cannot set a negative display count");
	}
	
	/**
	 * @return the current display message
	 */
	public String getDisplayMessage() {
		return displayMessage;
	}
	
	/**
	 * Prints the current display message as many times as the number displayRows is set to
	 */
	public void display() {
		String print = new String();
		for(int i = 1; i <= displayRows; i ++) {
			print += displayMessage + "\n";
		}
		System.out.print(print);
	}
	
	/**
	 * Prints the supplied text, count nr of rows
	 * @param text  the message to be printed
	 * @param count  nr of rows to print
	 */
	public void display(String text, int count) {
		setDisplayMessage(text);
		setDisplayCount(count);
		display();
	}
	
}
