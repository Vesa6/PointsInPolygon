package PointsPolygon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestPolygonWithFile {

	FileHandler filehandler = new FileHandler();

	@Test
	public void testTriangle_PointsInside() throws IOException {

		List<Point> testPoints = new ArrayList<>();
		String[] reportedPoints = null;
		Polygon localPoly = makeTriangle();

		testPoints.add(new Point(1, 1));
		testPoints.add(new Point(2, 2));
		testPoints.add(new Point(3, 3));
		testPoints.add(new Point(2, 3));
		testPoints.add(new Point(5, 5));

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
		assertEquals(reportedPoints[1], "The point 2,2 is in the polygon.");
		assertEquals(reportedPoints[2], "The point 3,3 is outside the polygon.");
		assertEquals(reportedPoints[3], "The point 2,3 is outside the polygon.");
		assertEquals(reportedPoints[4], "The point 5,5 is outside the polygon.");

	}


	@Test
	public void testTriangle_PointsInside2() throws IOException {

		List<Point> testPoints = new ArrayList<>();
		String[] reportedPoints = null;
		Polygon localPoly = makeTriangle();

		testPoints.add(new Point(1, 1));
		testPoints.add(new Point(3, 1));
		testPoints.add(new Point(3, 3));

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

		// This should be inside the polygon, bug in algorithm.
		assertEquals(reportedPoints[1], "The point 3,1 is inside the polygon.");

	}

	@Test
	public void TestTriangle_pointsOutside() throws IOException {

		List<Point> testPoints = new ArrayList<>();
		String[] reportedPoints = null;
		Polygon localPoly = makeTriangle();

		testPoints.add(new Point(3, 3));
		testPoints.add(new Point(4, 4));
		testPoints.add(new Point(-1, 0));

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
	// PointsOnBorder only detects points which are one of the original points of
	// the polygon.
	public void TestTriangle_pointsOnBorder() throws IOException {

		List<Point> testPoints = new ArrayList<>();
		String[] reportedPoints = null;
		Polygon localPoly = makeTriangle();

		testPoints.add(new Point(0, 0));
		testPoints.add(new Point(4, 0));
		testPoints.add(new Point(2, 4));

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
		Polygon localPoly = makeRectangle();

		testPoints.add(new Point(1, 1));
		testPoints.add(new Point(2, 2));
		testPoints.add(new Point(3, 3));
		testPoints.add(new Point(3, 2));

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
		Polygon localPoly = makeRectangle();

		testPoints.add(new Point(5, 5));
		testPoints.add(new Point(4, 5));
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
		Polygon localPoly = makeRectangle();

		testPoints.add(new Point(4, 4));
		testPoints.add(new Point(0, 1));
		testPoints.add(new Point(4, 2));

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
		Polygon localPoly = makeMShape();

		testPoints.add(new Point(1, 2));
		testPoints.add(new Point(3, 2));
		testPoints.add(new Point(5, 2));

		filehandler.writePoints(testPoints);
		filehandler.writePoly(localPoly);
		filehandler.createReport(getResults(getPolygon(), getTestPoints()));
		reportedPoints = filehandler.readReport();

		assertEquals(reportedPoints[0], "The point 1,2 is in the polygon.");

		// These should assert to true.
		assertEquals(reportedPoints[1], "The point 3,2 is in the polygon.");
		assertEquals(reportedPoints[2], "The point 5,2 is in the polygon.");

	}

	@Test
	public void TestMShape_pointsOutside() throws IOException {

		List<Point> testPoints = new ArrayList<>();
		String[] reportedPoints = null;
		Polygon localPoly = makeMShape();

		testPoints.add(new Point(6, 2));
		testPoints.add(new Point(5, 0));
		testPoints.add(new Point(1, 0));

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
		Polygon localPoly = makeMShape();

		testPoints.add(new Point(3, 3));
		testPoints.add(new Point(0, 1));
		testPoints.add(new Point(6, 1));

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
		Polygon localPoly = makeOtherShape();

		testPoints.add(new Point(3, 2));
		testPoints.add(new Point(3, 3));
		testPoints.add(new Point(3, 4));

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
		Polygon localPoly = makeOtherShape();

		testPoints.add(new Point(1, 4));
		testPoints.add(new Point(5, 4));
		testPoints.add(new Point(3, 6));

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
		Polygon localPoly = makeOtherShape();

		testPoints.add(new Point(2, 2));
		testPoints.add(new Point(2, 4));
		testPoints.add(new Point(3, 5));

		filehandler.writePoints(testPoints);
		filehandler.writePoly(localPoly);
		filehandler.createReport(getResults(getPolygon(), getTestPoints()));
		reportedPoints = filehandler.readReport();

		assertEquals(reportedPoints[0], "The point 2,2 is on the edge of the polygon.");
		assertEquals(reportedPoints[1], "The point 2,4 is on the edge of the polygon.");
		assertEquals(reportedPoints[2], "The point 3,5 is on the edge of the polygon.");

	}

	public Polygon makeMShape() {

		List<Point> pointsList = new ArrayList<Point>();
		pointsList.add(new Point(0, 1));
		pointsList.add(new Point(1, 1));
		pointsList.add(new Point(2, 3));
		pointsList.add(new Point(3, 1));
		pointsList.add(new Point(3, 3));
		pointsList.add(new Point(4, 3));
		pointsList.add(new Point(5, 1));
		pointsList.add(new Point(6, 1));
		pointsList.add(new Point(4, 4));
		pointsList.add(new Point(2, 4));

		Polygon MShape = new Polygon(pointsList);

		return MShape;

	}

	public Polygon makeOtherShape() {

		List<Point> pointsList = new ArrayList<Point>();

		pointsList.add(new Point(2, 2));
		pointsList.add(new Point(2, 4));
		pointsList.add(new Point(3, 5));
		pointsList.add(new Point(4, 4));
		pointsList.add(new Point(4, 2));
		pointsList.add(new Point(3, 1));

		Polygon otherShape = new Polygon(pointsList);

		return otherShape;
	}

	public Polygon makeTriangle() {

		List<Point> pointsList = new ArrayList<Point>();
		pointsList.add(new Point(0, 0));
		pointsList.add(new Point(1, 0));
		pointsList.add(new Point(2, 0));
		pointsList.add(new Point(3, 0));
		pointsList.add(new Point(4, 0));
		pointsList.add(new Point(2, 4));

		Polygon triangle = new Polygon(pointsList);

		return triangle;

	}

	public Polygon makeRectangle() {

		List<Point> pointsList = new ArrayList<Point>();
		pointsList.add(new Point(0, 0));
		pointsList.add(new Point(0, 1));
		pointsList.add(new Point(0, 2));
		pointsList.add(new Point(0, 3));
		pointsList.add(new Point(0, 4));
		pointsList.add(new Point(1, 0));
		pointsList.add(new Point(2, 0));
		pointsList.add(new Point(3, 0));
		pointsList.add(new Point(4, 0));
		pointsList.add(new Point(4, 1));
		pointsList.add(new Point(4, 2));
		pointsList.add(new Point(4, 3));
		pointsList.add(new Point(4, 4));
		pointsList.add(new Point(3, 4));
		pointsList.add(new Point(2, 4));
		pointsList.add(new Point(1, 4));

		Polygon rectangle = new Polygon(pointsList);

		return rectangle;
	}

	public Polygon getPolygon() throws FileNotFoundException {
		Polygon poly = new Polygon(filehandler.readFile("testPolygon.txt"));
		return poly;
	}

	public List<Point> getTestPoints() throws FileNotFoundException {
		return new ArrayList<Point>(filehandler.readFile("testPoints.txt"));
	}

	public List<String> getResults(Polygon polygon, List<Point> points) throws IOException {
		return polygon.comparePointsToPolygon(polygon, points);
	}

}
