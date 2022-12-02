//package PointsPolygon;
//
//import static org.junit.Assert.assertEquals;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//
//public class Junit {
//	
//
//	@Test(expected = FileNotFoundException.class)
//	public void testReadFileNotFound() throws FileNotFoundException {
//		File myFile = new File("idontexist.txt");
//		if (!myFile.isFile()) {
//			throw new FileNotFoundException();
//		}
//		}
//	
//	@Test(expected = Test.None.class)
//	public void testReadFileFound() throws FileNotFoundException {
//		File myFile = new File("testPoly.txt");
//		String name = (myFile.getName());
//		
//		assertEquals("testPoly.txt", name);
//		}
//		
//	
//	@Test(expected = Test.None.class)
//	public void testMainExecution() throws FileNotFoundException, Exception {
//		Main.main(null);
//	}
//
//	@Test
//	public void testReadFile_FullDiamond() throws FileNotFoundException {
//
//		Polygon polygon = new Polygon(Main.readFile("polygoni.txt"));
//
//		int u = 0;
//
//		assertEquals(2, polygon.getPoints().get(u).getX());
//		assertEquals(1, polygon.getPoints().get(u).getY());
//		u++;
//		assertEquals(1, polygon.getPoints().get(u).getX());
//		assertEquals(2, polygon.getPoints().get(u).getY());
//		u++;
//		assertEquals(1, polygon.getPoints().get(u).getX());
//		assertEquals(3, polygon.getPoints().get(u).getY());
//		u++;
//		assertEquals(2, polygon.getPoints().get(u).getX());
//		assertEquals(4, polygon.getPoints().get(u).getY());
//		u++;
//		assertEquals(3, polygon.getPoints().get(u).getX());
//		assertEquals(3, polygon.getPoints().get(u).getY());
//		u++;
//		assertEquals(3, polygon.getPoints().get(u).getX());
//		assertEquals(2, polygon.getPoints().get(u).getY());
//
//
//	}
//
//	@Test
//	public void testReadFile_PointFileDiamond() throws FileNotFoundException {
//
//		Points points = new Points(Main.readFile("testPoints.txt"));
//
//		int u = 0;
//		
//		while (u < points.getPoints().size()-1) {
//		
//		assertEquals(2, points.getPoints().get(u).getX());
//		assertEquals(1, points.getPoints().get(u).getY());
//		u++;
//		assertEquals(2, points.getPoints().get(u).getX());
//		assertEquals(3, points.getPoints().get(u).getY());
//		u++;
//		assertEquals(4, points.getPoints().get(u).getX());
//		assertEquals(4, points.getPoints().get(u).getY());
//		u++;
//		assertEquals(2, points.getPoints().get(u).getX());
//		assertEquals(2, points.getPoints().get(u).getY());
//		u++;
//		assertEquals(1, points.getPoints().get(u).getX());
//		assertEquals(2, points.getPoints().get(u).getY());
//		
//		}
//
//	}
//
//	@Test(expected = Exception.class)
//	public void testReadFile_PolygonTwoPoints() throws Exception  {
//		
//		Polygon polygon = new Polygon(Main.readFile("twoPointsPolygon.txt"));
//		
//		if (polygon.getPoints().size() < 3) {
//			throw new Exception("The polygon needs at least 3 edges.");
//		}
//	}
//
//	@Test(expected = FileNotFoundException.class)
//	public void testReadFileThrows() throws FileNotFoundException {
//
//			Main.readFile("Idontexist.txt");
//	}
//	
//	
//	
//	@Test
//	public void testIsInside_Valid() {
//		
//		List<Point> pointsList = new ArrayList<Point>();
//		
//		pointsList.add(new Point(2,1));
//		pointsList.add(new Point(1,2));
//		pointsList.add(new Point(1,3));
//		pointsList.add(new Point(2,4));
//		pointsList.add(new Point(3,3));
//		pointsList.add(new Point(3,2));
//		
//		Polygon testPoly = new Polygon(pointsList);
//		
//		//This should throw an exception, since 2,2 should be inside.
//		assertEquals(true, Main.contains(new Point(2,2), testPoly));
//		
//	}
//	
//	@Test
//	public void testIsInside_Invalid() {
//		
//		List<Point> pointsList = new ArrayList<Point>();
//		
//		pointsList.add(new Point(2,1));
//		pointsList.add(new Point(1,2));
//		pointsList.add(new Point(1,3));
//		pointsList.add(new Point(2,4));
//		pointsList.add(new Point(3,3));
//		pointsList.add(new Point(3,2));
//		
//		Polygon testPoly = new Polygon(pointsList);
//		
//		//This should evaluate to false, since 3,4 should be outside.
//		assertEquals(true, Main.contains(new Point(3,4), testPoly));
//		
//	}
//
//
//		
//	
//	@Test
//	public void testIsOutside() {
//		
//			
//			List<Point> pointsList = new ArrayList<Point>();
//			
//			pointsList.add(new Point(2,1));
//			pointsList.add(new Point(1,2));
//			pointsList.add(new Point(1,3));
//			pointsList.add(new Point(2,4));
//			pointsList.add(new Point(3,3));
//			pointsList.add(new Point(3,2));
//			
//			Polygon testPoly = new Polygon(pointsList);
//			
//			//This should return false, since 2,5 is outside.
//			assertEquals(false, Main.contains(new Point(2,5), testPoly));
//			
//
//	}
//	
//	@Test 
//	public void testIsOnEdge() {
//			
//			
//			List<Point> pointsList = new ArrayList<Point>();
//			
//			pointsList.add(new Point(2,1));
//			pointsList.add(new Point(1,2));
//			pointsList.add(new Point(1,3));
//			pointsList.add(new Point(2,4));
//			pointsList.add(new Point(3,3));
//			pointsList.add(new Point(3,2));
//			
//			Polygon testPoly = new Polygon(pointsList);
//			
//			//This should throw an exception, since 2,2 should be inside.
//			assertEquals(true, Main.isOnEdge(new Point(2,4), testPoly));
//			
//
//	}
//	
//	@Test
//	public void testBigCoordinates() {
//		
//			List<Point> pointsList = new ArrayList<Point>();
//			
//			pointsList.add(new Point(1632000000, 59999999));
//			pointsList.add(new Point(1632000002, 60000002));
//			pointsList.add(new Point(1632000004, 59999997));
//			
//			Polygon testPoly = new Polygon(pointsList);
//			
//			//This should return true, since it is inside the triangle.
//			assertEquals(true, Main.contains(new Point(1632000001, 60000000), testPoly));
//			
//		
//
//	}
//	
//	@Test
//	public void testNegativeCoordinates() {
//		
//		List<Point> pointsList = new ArrayList<Point>();
//		
//		pointsList.add(new Point(-1, -1));
//		pointsList.add(new Point(-3, -1));
//		pointsList.add(new Point(-2, -3));
//		
//		Polygon testPoly = new Polygon(pointsList);
//		
//		assertEquals(true, Main.contains(new Point(-2,-2), testPoly));
//		
//	}
//	
//	@Test(expected = Test.None.class)
//	public void testCreateReport_NonASCII() throws IOException {
//		
//		List<String> ثثثثث = new ArrayList<String>();
//		Main.createReport(ثثثثث);
//		
//	}
//	
//}
