package PointsPolygon;


/**
 * @author vesa6
 *
 */

public class Point {
	
	private int x,y;
	
	public Point(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public String getBoth() {
		return this.x + "," + this.y;
	}

}
