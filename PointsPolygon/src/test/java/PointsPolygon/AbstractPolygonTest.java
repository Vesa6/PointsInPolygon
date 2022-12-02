package PointsPolygon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AbstractPolygonTest {
	
	TestPolygonWithFile withFile = new TestPolygonWithFile();
	TestPolygon noFile = new TestPolygon();

	@Test
	public void testRectangle() throws IOException {

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

		Polygon localPolygon = new Polygon(pointsList);

		List<Point> localPoints = new ArrayList<Point>();
		localPoints.add(new Point(1, 1));
		localPoints.add(new Point(2, 2));
		localPoints.add(new Point(3, 3));
		localPoints.add(new Point(3, 2));

		List<String> localResults = new ArrayList<String>();

		localResults = localPolygon.comparePointsToPolygon(localPolygon, localPoints);

		assertEquals("The point 1,1 is in the polygon.", localResults.get(0));
		assertEquals("The point 2,2 is in the polygon.", localResults.get(1));
		assertEquals("The point 3,3 is in the polygon.", localResults.get(2));
		assertEquals("The point 3,2 is in the polygon.", localResults.get(3));

	}

	@Test
	public void testTriangle() throws IOException {

		/*List<Point> pointsList = new ArrayList<Point>();

		pointsList.add(new Point(0, 0));
		pointsList.add(new Point(1, 0));
		pointsList.add(new Point(2, 0));
		pointsList.add(new Point(3, 0));
		pointsList.add(new Point(4, 0));
		pointsList.add(new Point(2, 4));

		Polygon localPolygon = new Polygon(pointsList);

		List<Point> localPoints = new ArrayList<>();
		localPoints.add(new Point(1, 1));
		localPoints.add(new Point(2, 2));
		localPoints.add(new Point(3, 3));

		List<String> localResults = new ArrayList<String>();

		localResults = localPolygon.comparePointsToPolygon(localPolygon, localPoints);

		assertEquals("The point 1,1 is in the polygon.", localResults.get(0));
		assertEquals("The point 2,2 is in the polygon.", localResults.get(1));
		assertEquals("The point 3,3 is outside the polygon.", localResults.get(2));*/
	}

	@Test
	public void testOtherShape() throws IOException {

		List<Point> pointsList = new ArrayList<Point>();

		pointsList.add(new Point(2, 2));
		pointsList.add(new Point(2, 4));
		pointsList.add(new Point(3, 5));
		pointsList.add(new Point(4, 4));
		pointsList.add(new Point(4, 2));
		pointsList.add(new Point(3, 1));
		
		Polygon localPolygon = new Polygon(pointsList);
		
		List<Point> localPoints = new ArrayList<>();
		localPoints.add(new Point(3,2));
		localPoints.add(new Point(3,3));
		localPoints.add(new Point(3,4));
		
		List<String> localResults = new ArrayList<String>();

		localResults = localPolygon.comparePointsToPolygon(localPolygon, localPoints);

		assertEquals("The point 3,2 is in the polygon.", localResults.get(0));
		assertEquals("The point 3,3 is in the polygon.", localResults.get(1));
		assertEquals("The point 3,4 is in the polygon.", localResults.get(2));
	}
		
		@Test
		public void testMShape() throws IOException {

			List<Point> pointsList = new ArrayList<Point>();

			pointsList.add(new Point(0,1));
			pointsList.add(new Point(1,1));
			pointsList.add(new Point(2,3));
			pointsList.add(new Point(3,1));
			pointsList.add(new Point(3,3));
			pointsList.add(new Point(4,3));
			pointsList.add(new Point(5,1));
			pointsList.add(new Point(6,1));
			pointsList.add(new Point(4,4));
			pointsList.add(new Point(2,4));
			
			Polygon localPolygon = new Polygon(pointsList);
			
			List<Point> localPoints = new ArrayList<>();
			localPoints.add(new Point(1,2));
			localPoints.add(new Point(3,2));
			localPoints.add(new Point(5,2));
			
			List<String> localResults = new ArrayList<String>();

			localResults = localPolygon.comparePointsToPolygon(localPolygon, localPoints);

			assertEquals("The point 1,2 is in the polygon.", localResults.get(0));
			//These should be true, but there is a bug with the algorithm.
			assertEquals("The point 3,2 is in the polygon.", localResults.get(1));
			assertEquals("The point 5,2 is in the polygon.", localResults.get(2));
			
		
	}
}
