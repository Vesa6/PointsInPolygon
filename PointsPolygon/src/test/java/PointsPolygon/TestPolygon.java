package PointsPolygon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;



public class TestPolygon extends TestPolygonWithFile {
	
	
	FileHandler filehandler = new FileHandler();
	List<Point> testPoints = new ArrayList<>();
	List<String> results = new ArrayList<>();
	List<String> reportedPoints = new ArrayList<>();
	Polygon localPoly = null;
	

	@Test
	public void testTriangle_PointsInside() throws IOException {
		
		List<Point> p1 = new ArrayList<>();
		p1.add(new Point(1,1));
		p1.add(new Point(2,2));
		p1.add(new Point(3,3));
		p1.add(new Point(2,3));
		p1.add(new Point(5,5));
		
		setPolygon("triangle");
		setTestPoints(p1);
		
		testPoints = getTestPoints();
		reportedPoints = getResults(getPolygon(), testPoints);

		assertEquals(reportedPoints.get(0), "The point 1,1 is in the polygon.");
		assertEquals(reportedPoints.get(1), "The point 2,2 is in the polygon.");
		assertEquals(reportedPoints.get(2), "The point 3,3 is outside the polygon.");
		assertEquals(reportedPoints.get(3), "The point 2,3 is outside the polygon.");
		assertEquals(reportedPoints.get(4), "The point 5,5 is outside the polygon.");

	}

	@Test
	public void testTriangle_PointsInside2() throws IOException {

		List<Point> testPoints = new ArrayList<>();
		String[] reportedPoints = null;
		Polygon localPoly = super.makeTriangle();
		
		testPoints.add(new Point(1,1));
		testPoints.add(new Point(3,1));
		testPoints.add(new Point(3,3));

		filehandler.writePoints(testPoints);

		// Writes to testPolygon.txt
		filehandler.writePoly(localPoly);
		// Points written in testPolygon.txt, testPoints come from TestPoints.txt
		testPoints = getTestPoints();
		// After that, create report based on the results.
		filehandler.createReport(getResults(localPoly, testPoints));
		// Read the report.
		reportedPoints = filehandler.readReport();

		assertEquals(reportedPoints[0], "The point 1,1 is in the polygon.");
		assertEquals(reportedPoints[2], "The point 3,3 is outside the polygon.");
		
		//This should be inside the polygon, bug in algorithm.
		assertEquals(reportedPoints[1], "The point 3,1 is inside the polygon.");

	}
	
	@Test
	public void TestTriangle_pointsOutside() throws IOException {
		
		List<Point> testPoints = new ArrayList<>();
		String[] reportedPoints = null;
		Polygon localPoly = super.makeTriangle();
		
		testPoints.add(new Point(3,3));
		testPoints.add(new Point(4,4));
		testPoints.add(new Point(-1,0));

		filehandler.writePoints(testPoints);

		// Writes to testPolygon.txt
		filehandler.writePoly(localPoly);
		// Points written in testPolygon.txt, testPoints come from TestPoints.txt
		testPoints = getTestPoints();
		// After that, create report based on the results.
		filehandler.createReport(getResults(localPoly, testPoints));
		// Read the report.
		reportedPoints = filehandler.readReport();

		assertEquals(reportedPoints[0], "The point 3,3 is outside the polygon.");
		assertEquals(reportedPoints[1], "The point 4,4 is outside the polygon.");
		assertEquals(reportedPoints[2], "The point -1,0 is outside the polygon.");
		
	}
	
	@Test
	//PointsOnBorder only detects points which are one of the original points of the polygon.
	public void TestTriangle_pointsOnBorder() throws IOException {
	
		List<Point> testPoints = new ArrayList<>();
		String[] reportedPoints = null;
		Polygon localPoly = super.makeTriangle();
		
		testPoints.add(new Point(0,0));
		testPoints.add(new Point(4,0));
		testPoints.add(new Point(2,4));

		filehandler.writePoints(testPoints);

		// Writes to testPolygon.txt
		filehandler.writePoly(localPoly);
		// Points written in testPolygon.txt, testPoints come from TestPoints.txt
		// After that, create report based on the results.
		filehandler.createReport(getResults(getPolygon(), getTestPoints()));
		// Read the report.
		reportedPoints = filehandler.readReport();

		assertEquals(reportedPoints[0], "The point 0,0 is on the edge of the polygon.");
		assertEquals(reportedPoints[1], "The point 4,0 is on the edge of the polygon.");
		assertEquals(reportedPoints[2], "The point 2,4 is on the edge of the polygon.");
		
	}
	
	@Test
	public void TestRectangle_pointsInside() throws IOException {

		List<Point> testPoints = new ArrayList<>();
		String[] reportedPoints = null;
		Polygon localPoly = super.makeRectangle();
		
		testPoints.add(new Point(1,1));
		testPoints.add(new Point(2,2));
		testPoints.add(new Point(3,3));
		testPoints.add(new Point(3,2));

		filehandler.writePoints(testPoints);
		filehandler.writePoly(localPoly);
		filehandler.createReport(getResults(getPolygon(), getTestPoints()));
		reportedPoints = filehandler.readReport();

		assertEquals(reportedPoints[0], "The point 1,1 is in the polygon.");
		assertEquals(reportedPoints[1], "The point 2,2 is in the polygon.");
		assertEquals(reportedPoints[2], "The point 3,3 is in the polygon.");
		assertEquals(reportedPoints[3], "The point 3,2 is in the polygon.");
	}
	
	@Test
	public void TestRectangle_pointsOutside() throws IOException {
		
		List<Point> testPoints = new ArrayList<>();
		String[] reportedPoints = null;
		Polygon localPoly = super.makeRectangle();
		
		testPoints.add(new Point(5,5));
		testPoints.add(new Point(4,5));
		testPoints.add(new Point(-1, -1));

		filehandler.writePoints(testPoints);
		filehandler.writePoly(localPoly);
		filehandler.createReport(getResults(getPolygon(), getTestPoints()));
		reportedPoints = filehandler.readReport();

		assertEquals(reportedPoints[0], "The point 5,5 is outside the polygon.");
		assertEquals(reportedPoints[1], "The point 4,5 is outside the polygon.");
		assertEquals(reportedPoints[2], "The point -1,-1 is outside the polygon.");
		
	}
	
	@Test
	public void TestRectangle_pointsOnBorder() throws IOException {
		
		List<Point> testPoints = new ArrayList<>();
		String[] reportedPoints = null;
		Polygon localPoly = super.makeRectangle();
		
		testPoints.add(new Point(4,4));
		testPoints.add(new Point(0,1));
		testPoints.add(new Point(4,2));

		filehandler.writePoints(testPoints);
		filehandler.writePoly(localPoly);
		filehandler.createReport(getResults(getPolygon(), getTestPoints()));
		reportedPoints = filehandler.readReport();

		assertEquals(reportedPoints[0], "The point 4,4 is on the edge of the polygon.");
		assertEquals(reportedPoints[1], "The point 0,1 is on the edge of the polygon.");
		assertEquals(reportedPoints[2], "The point 4,2 is on the edge of the polygon.");

	}
	
	@Test
	public void TestMShape_pointsInside() throws IOException {
		
		List<Point> testPoints = new ArrayList<>();
		String[] reportedPoints = null;
		Polygon localPoly = super.makeMShape();
		
		testPoints.add(new Point(1,2));
		testPoints.add(new Point(3,2));
		testPoints.add(new Point(5,2));

		filehandler.writePoints(testPoints);
		filehandler.writePoly(localPoly);
		filehandler.createReport(getResults(getPolygon(), getTestPoints()));
		reportedPoints = filehandler.readReport();

		assertEquals(reportedPoints[0], "The point 1,2 is in the polygon.");
		
		//These should assert to true.
		assertEquals(reportedPoints[1], "The point 3,2 is in the polygon.");
		assertEquals(reportedPoints[2], "The point 5,2 is in the polygon.");
		
	}
	
	@Test
	public void TestMShape_pointsOutside() throws IOException {
		
		
		List<Point> testPoints = new ArrayList<>();
		String[] reportedPoints = null;
		Polygon localPoly = super.makeMShape();
		
		testPoints.add(new Point(6,2));
		testPoints.add(new Point(5,0));
		testPoints.add(new Point(1,0));

		filehandler.writePoints(testPoints);
		filehandler.writePoly(localPoly);
		filehandler.createReport(getResults(getPolygon(), getTestPoints()));
		reportedPoints = filehandler.readReport();

		assertEquals(reportedPoints[0], "The point 6,2 is outside the polygon.");
		assertEquals(reportedPoints[1], "The point 5,0 is outside the polygon.");
		assertEquals(reportedPoints[2], "The point 1,0 is outside the polygon.");
}
	
	@Test
	public void TestMShape_pointsOnBorder() throws IOException {
		
		
		List<Point> testPoints = new ArrayList<>();
		String[] reportedPoints = null;
		Polygon localPoly = super.makeMShape();
		
		testPoints.add(new Point(3,3));
		testPoints.add(new Point(0,1));
		testPoints.add(new Point(6,1));

		filehandler.writePoints(testPoints);
		filehandler.writePoly(localPoly);
		filehandler.createReport(getResults(getPolygon(), getTestPoints()));
		reportedPoints = filehandler.readReport();

		assertEquals(reportedPoints[0], "The point 3,3 is on the edge of the polygon.");
		assertEquals(reportedPoints[1], "The point 0,1 is on the edge of the polygon.");
		assertEquals(reportedPoints[2], "The point 6,1 is on the edge of the polygon.");
}
	
	@Test
	public void TestOtherShape_pointsInside() throws IOException {
		
		List<Point> testPoints = new ArrayList<>();
		String[] reportedPoints = null;
		Polygon localPoly = super.makeOtherShape();
		
		testPoints.add(new Point(3,2));
		testPoints.add(new Point(3,3));
		testPoints.add(new Point(3,4));

		filehandler.writePoints(testPoints);
		filehandler.writePoly(localPoly);
		filehandler.createReport(getResults(getPolygon(), getTestPoints()));
		reportedPoints = filehandler.readReport();
		
		assertEquals(reportedPoints[0], "The point 3,2 is in the polygon.");
		assertEquals(reportedPoints[1], "The point 3,3 is in the polygon.");
		assertEquals(reportedPoints[2], "The point 3,4 is in the polygon.");

}
	
	@Test
	public void TestOtherShape_pointsOutside() throws IOException {
		
		List<Point> testPoints = new ArrayList<>();
		String[] reportedPoints = null;
		Polygon localPoly = super.makeOtherShape();
		
		testPoints.add(new Point(1,4));
		testPoints.add(new Point(5,4));
		testPoints.add(new Point(3,6));

		filehandler.writePoints(testPoints);
		filehandler.writePoly(localPoly);
		filehandler.createReport(getResults(getPolygon(), getTestPoints()));
		reportedPoints = filehandler.readReport();

		assertEquals(reportedPoints[0], "The point 1,4 is outside the polygon.");
		assertEquals(reportedPoints[1], "The point 5,4 is outside the polygon.");
		assertEquals(reportedPoints[2], "The point 3,6 is outside the polygon.");
}
	
	@Test
	public void TestOtherShape_pointsOnBorder() throws IOException {
		
		List<Point> testPoints = new ArrayList<>();
		String[] reportedPoints = null;
		Polygon localPoly = super.makeOtherShape();
		
		testPoints.add(new Point(2,2));
		testPoints.add(new Point(2,4));
		testPoints.add(new Point(3,5));

		filehandler.writePoints(testPoints);
		filehandler.writePoly(localPoly);
		filehandler.createReport(getResults(getPolygon(), getTestPoints()));
		reportedPoints = filehandler.readReport();

		assertEquals(reportedPoints[0], "The point 2,2 is on the edge of the polygon.");
		assertEquals(reportedPoints[1], "The point 2,4 is on the edge of the polygon.");
		assertEquals(reportedPoints[2], "The point 3,5 is on the edge of the polygon.");
		
}


	@Override
	public Polygon getPolygon() throws FileNotFoundException {
		return this.localPoly;
	}
	
	public void setPolygon(String type) {
		
		if (type.equalsIgnoreCase("triangle")) {
		this.localPoly = super.makeTriangle(); 
		} else if (type.equalsIgnoreCase("rectangle")) {
			this.localPoly = super.makeRectangle();
		} else if(type.equalsIgnoreCase("mshape")) {
			this.localPoly = super.makeRectangle();
		} else if(type.equalsIgnoreCase("othershape")) {
			this.localPoly = super.makeRectangle();
		}
	}

	@Override
	public List<Point> getTestPoints() throws FileNotFoundException {	
		return this.testPoints;
	}
	
	public void setTestPoints(List<Point> li) throws IOException {
		
		for (Point pt: li) {
		this.testPoints.add(pt);
		}
		
	}
	

	@Override
	public List<String> getResults(Polygon polygon, List<Point> points) throws IOException {
		return polygon.comparePointsToPolygon(polygon, points);
	}
	
	
	/*	
		Point point1 = new Point(1, 1);
		Point point2 = new Point(-5, -10);
		Point point3 = new Point(3, -9999999);
		Point point4 = new Point(0, 0);
		Point point5 = new Point(10000000, 1005050);

			@Test
			public void TestConstructPoly() {
				List<Point> pointsList = new ArrayList<Point>();
				pointsList.add(point1);
				pointsList.add(point2);
				pointsList.add(point3);
				pointsList.add(point4);
				pointsList.add(point5);
				
				Polygon poly = new Polygon(pointsList);
				
				assertEquals("1,1", poly.getPoints().get(0).getBoth());
				assertEquals("-5,-10", poly.getPoints().get(1).getBoth());
				assertEquals("3,-9999999", poly.getPoints().get(2).getBoth());
				assertEquals("0,0", poly.getPoints().get(3).getBoth());
				assertEquals("10000000,1005050", poly.getPoints().get(4).getBoth());
			}
			
			@Test
			public void TestEmptyPoly() {
				List<Point> pointsList = new ArrayList<Point>();
				Polygon poly = new Polygon(pointsList);
				assertTrue(poly.getPoints().isEmpty());
			}
			
			
			@Test
			public void TestTriangle_pointsInside() {
				
				Polygon poly = TestPolygonWithFile.makeTriangle();

				Point pointTest1 = new Point(1,1);
				Point pointTest2 = new Point(2,2);
				Point pointTest3 = new Point(3,3);
				
				assertTrue((Polygon.contains(pointTest1, poly)));
				assertFalse((Polygon.contains(pointTest3, poly)));
				
				//This test reveals an interesting bug, possibly caused by lacking precision of integers.
				assertTrue((Polygon.contains(pointTest2, poly)));
				
			}
			
			@Test
			public void TestTriangle_pointsInside2() {
				
				Polygon poly = makeTriangle();
				
				Point pointTest1 = new Point(1,1);
				Point pointTest2 = new Point(3,1);
				Point pointTest3 = new Point(3,3);
				
				assertTrue((Polygon.contains(pointTest1, poly)));
				assertFalse((Polygon.contains(pointTest3, poly)));
				
				//This test reveals an interesting bug, possibly caused by lacking precision of integers (?).
				//It appears that the bug is caused by points that are close to the border, but not on it.
				assertTrue((Polygon.contains(pointTest2, poly)));
				
			}
			

			@Test
			public void TestTriangle_pointsOutside() {
				
				Polygon poly = makeTriangle();
				
				Point pointTest1 = new Point(3,3);
				Point pointTest2 = new Point(4,4);
				Point pointTest3 = new Point(-1,0);
				
				assertFalse((Polygon.contains(pointTest1, poly)));
				assertFalse((Polygon.contains(pointTest3, poly)));
				assertFalse((Polygon.contains(pointTest2, poly)));
			}
			
			@Test
			//PointsOnBorder only detects points which are one of the original points of the polygon.
			public void TestTriangle_pointsOnBorder() {
			
				Polygon poly = makeTriangle();
				
				Point pointTest1 = new Point(0,0);
				Point pointTest2 = new Point(4,0);
				Point pointTest3 = new Point(2,4);
				
				assertTrue((Polygon.isOnEdge(pointTest1, poly)));
				assertTrue((Polygon.isOnEdge(pointTest3, poly)));
				assertTrue((Polygon.isOnEdge(pointTest2, poly)));
			}
			
			
			@Test
			public void TestRectangle_pointsInside() {
				
				Polygon poly = makeRectangle();
				
				Point pointTest1 = new Point(1,1);
				Point pointTest2 = new Point(2,2);
				Point pointTest3 = new Point(3,3);
				Point pointTest4 = new Point(3,2);
				
				assertTrue((Polygon.contains(pointTest1, poly)));
				assertTrue((Polygon.contains(pointTest2, poly)));
				assertTrue((Polygon.contains(pointTest3, poly)));
				assertTrue((Polygon.contains(pointTest4, poly)));
				
			}
			
			@Test
			public void TestRectangle_pointsOutside() {
				
				Polygon poly = makeRectangle();
				
				Point pointTest1 = new Point(5,5);
				Point pointTest2 = new Point(4,5);
				Point pointTest3 = new Point(-1, -1);
				
				assertFalse((Polygon.contains(pointTest1, poly)));
				assertFalse((Polygon.contains(pointTest2, poly)));
				assertFalse((Polygon.contains(pointTest3, poly)));
				
			}
			
			@Test
			public void TestRectangle_pointsOnBorder() {
				
				Polygon poly = makeRectangle();
				
				Point pointTest1 = new Point(4,4);
				Point pointTest2 = new Point(0,1);
				Point pointTest3 = new Point(4,2);
				
				assertTrue((Polygon.isOnEdge(pointTest1, poly)));
				assertTrue((Polygon.isOnEdge(pointTest2, poly)));
				assertTrue((Polygon.isOnEdge(pointTest3, poly)));
			}
			
			@Test
			public void TestMShape_pointsInside() {
				
				Polygon poly = makeMShape();
				
				Point pointTest1 = new Point(1,2);
				Point pointTest2 = new Point(3,2);
				Point pointTest3 = new Point(5,2);
				
				assertTrue((Polygon.contains(pointTest1, poly)));
				//These should assert true, but something is wrong with the algorithm.
				assertTrue((Polygon.contains(pointTest2, poly)));
				assertTrue((Polygon.contains(pointTest3, poly)));
				
			}
			
			@Test
			public void TestMShape_pointsOutside() {
				
				Polygon poly = makeMShape();
				
				Point pointTest1 = new Point(6,2);
				Point pointTest2 = new Point(5,0);
				Point pointTest3 = new Point(1,0);
				
				assertFalse((Polygon.contains(pointTest1, poly)));
				assertFalse((Polygon.contains(pointTest2, poly)));
				assertFalse((Polygon.contains(pointTest3, poly)));
		}
			
			@Test
			public void TestMShape_pointsOnBorder() {
				
				Polygon poly = makeMShape();
				
				Point pointTest1 = new Point(3,3);
				Point pointTest2 = new Point(0,1);
				Point pointTest3 = new Point(6,1);
				
				assertTrue((Polygon.isOnEdge(pointTest1, poly)));
				assertTrue((Polygon.isOnEdge(pointTest2, poly)));
				assertTrue((Polygon.isOnEdge(pointTest3, poly)));
}
			
			@Test
			public void TestOtherShape_pointsInside() {
				
				Polygon poly = makeOtherShape();
				
				Point pointTest1 = new Point(3,2);
				Point pointTest2 = new Point(3,3);
				Point pointTest3 = new Point(3,4);
				
				assertTrue((Polygon.contains(pointTest1, poly)));
				assertTrue((Polygon.contains(pointTest2, poly)));
				assertTrue((Polygon.contains(pointTest3, poly)));
}
			
			@Test
			public void TestOtherShape_pointsOutside() {
				
				Polygon poly = makeOtherShape();
				
				Point pointTest1 = new Point(1,4);
				Point pointTest2 = new Point(5,4);
				Point pointTest3 = new Point(3,6);
				
				assertFalse((Polygon.contains(pointTest1, poly)));
				assertFalse((Polygon.contains(pointTest2, poly)));
				assertFalse((Polygon.contains(pointTest3, poly)));
}
			
			@Test
			public void TestOtherShape_pointsOnBorder() {
				
				Polygon poly = makeOtherShape();
				
				Point pointTest1 = new Point(2,2);
				Point pointTest2 = new Point(2,4);
				Point pointTest3 = new Point(3,5);
				
				assertTrue((Polygon.isOnEdge(pointTest1, poly)));
				assertTrue((Polygon.isOnEdge(pointTest2, poly)));
				assertTrue((Polygon.isOnEdge(pointTest3, poly)));
}
			
			
		*/
			
}


