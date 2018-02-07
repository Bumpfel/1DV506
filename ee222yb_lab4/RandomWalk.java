package ee222yb_lab4;

import java.util.Random;

public class RandomWalk {
	
	private Random rand = new Random();
	private final int MIN_MAX_COORD, MAX_STEPS;
	private int x, y, stepsTaken;
	
	public RandomWalk(int maxSteps, int size) throws IllegalArgumentException {
		if(maxSteps < 0 || size < 0)
			throw new IllegalArgumentException("Can't create walk! Arguments out of range.");
		MAX_STEPS = maxSteps;
		MIN_MAX_COORD = size;
	}
	
	public String toString() {
		return "Nr of steps taken: " + stepsTaken + "\nCurrent position: (" + x + "," + y + ")";
	}
	
	private void takeStep() {
		int direction = rand.nextInt(4);
		switch(direction) {
			case 0: y ++;
			break;
			
			case 1: x ++;
			break;
			
			case 2: y --;
			break;
			
			case 3: x --;
			break;
		}
		stepsTaken ++;
	}
	
	private boolean moreSteps() {
		return stepsTaken < MAX_STEPS;
	}
	
	public boolean inBounds() {
		if(x <= MIN_MAX_COORD && x + MIN_MAX_COORD >= 0 && y <= MIN_MAX_COORD && y + MIN_MAX_COORD >= 0)
			return true;
		return false;
	}
	
	public void walk() {
		while(moreSteps() && inBounds()) {
			takeStep();
		}
	}
	
}
