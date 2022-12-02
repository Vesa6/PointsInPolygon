package PointsPolygon;
//
//	import org.junit.Test;
//	import static org.junit.Assert.assertEquals;
//	import static org.junit.Assert.assertTrue;
//
//	import java.util.ArrayList;
//	import java.util.List;
//
//public class TestPoints {
//
//	Point point1 = new Point(1, 1);
//	Point point2 = new Point(-5, -10);
//	Point point3 = new Point(3, -9999999);
//	Point point4 = new Point(0, 0);
//	Point point5 = new Point(10000000, 1005050);
//	
//		@Test
//		public void TestConstruct() {
//			List<Point> pointsList = new ArrayList<Point>();
//			pointsList.add(point1);
//			pointsList.add(point2);
//			pointsList.add(point3);
//			pointsList.add(point4);
//			pointsList.add(point5);
//			
//			Points points1 = new Points(pointsList);
//			
//			assertEquals("1,1", points1.getPoints().get(0).getBoth());
//			assertEquals("-5,-10", points1.getPoints().get(1).getBoth());
//			assertEquals("3,-9999999", points1.getPoints().get(2).getBoth());
//			assertEquals("0,0", points1.getPoints().get(3).getBoth());
//			assertEquals("10000000,1005050", points1.getPoints().get(4).getBoth());
//			
//			
//		}
//		
//		@Test
//		public void TestEmpty() {
//			List<Point> pointsList = new ArrayList<Point>();
//			Points points1 = new Points(pointsList);
//			assertTrue(points1.getPoints().isEmpty());
//		}
//		
//	}
//
//
