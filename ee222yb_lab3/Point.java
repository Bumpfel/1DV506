package ee222yb_lab3;

public class Point {
	private int xCoord, yCoord;
	
	public Point() {
	}
	
	public Point(int x, int y) {
		xCoord = x;
		yCoord = y;
	}
	
	public String toString() {
		return "(" + xCoord + "," + yCoord + ")";
	}
	
	public boolean isEqualTo(Point coord) {
		return xCoord == coord.xCoord && yCoord == coord.yCoord;
	}
	
	public double distanceTo(Point coord) {
		double xCoordsSquared = Math.pow(xCoord - coord.xCoord, 2); // (x1-x2)^2
		double yCoordsSquared = Math.pow(yCoord - coord.yCoord, 2);
		return Math.sqrt(xCoordsSquared + yCoordsSquared);
	}
	
	public void move(int x, int y) {
		xCoord += x;
		yCoord += y;
	}
	
	public void moveToXY(int x, int y) {
		xCoord = x;
		yCoord = y;
	}
	
}