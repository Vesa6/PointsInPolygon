package PointsPolygon;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestPoint {
	
	@Test
	public void TestConstruct() {
		Point point1 = new Point(1, 1);
		Point point2  = new Point(-5, -10);
		Point point3 = new Point(3, -9999999);
		Point point4 = new Point(0, 0);
		Point point5 = new Point(10000000, 1005050);
		
		assertEquals(1, point1.getX());
		assertEquals(1, point1.getY());
		assertEquals("1,1", point1.getBoth());
		
		assertEquals(-5, point2.getX());
		assertEquals(-10, point2.getY());
		assertEquals("-5,-10", point2.getBoth());
		
		assertEquals(3, point3.getX());
		assertEquals(-9999999, point3.getY());
		assertEquals("3,-9999999", point3.getBoth());
		
		assertEquals(0, point4.getX());
		assertEquals(0, point4.getY());
		assertEquals("0,0", point4.getBoth());
		
		assertEquals(10000000, point5.getX());
		assertEquals(1005050, point5.getY());
		assertEquals("10000000,1005050", point5.getBoth());
		
		
	}
	
}
