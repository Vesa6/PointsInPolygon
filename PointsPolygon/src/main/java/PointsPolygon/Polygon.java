package PointsPolygon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vesa6
 *
 */
public class Polygon {

	private List<Point> pointsInPolygon = new ArrayList<Point>();

	public Polygon(List<Point> pointsInPolygon) {
		this.pointsInPolygon = pointsInPolygon;
	}

	public List<Point> getPoints() {
		return pointsInPolygon;
	}

	/**
	 * @param filehandler
	 * @param polygon
	 * @param points
	 * @throws IOException
	 */
	public List<String> comparePointsToPolygon(Polygon polygon, List<Point> points)

			throws IOException {

		List<String> inOrOut = new ArrayList<String>();

		for (int i = 0; i < points.size(); i++) {
			
			if (isOnEdge(points.get(i), polygon)) {
				inOrOut.add("The point " + points.get(i).getBoth() + " is on the edge of the polygon.");
			}
			else if (contains(points.get(i), polygon)) {
				inOrOut.add("The point " + points.get(i).getBoth() + " is in the polygon.");
			}  
			else {
			inOrOut.add("The point " + points.get(i).getBoth() + " is outside the polygon.");
			}
		}

		return inOrOut;
	}

	// This finds out if the testPoint is on the edge of the polygon.
	public static boolean isOnEdge(Point testPoint, Polygon poly) {

		int polyLength = poly.getPoints().size();

		boolean result = false;

		for (int i = 0; i < polyLength; i++) {
			if (testPoint.getX() == poly.getPoints().get(i).getX()
					&& testPoint.getY() == poly.getPoints().get(i).getY()) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * // * @param args // * @throws Exception // * @throws FileNotFoundException //
	 * * Based on the following academic source:
	 * https://www.eecs.umich.edu/courses/eecs380/HANDOUTS/PROJ2/InsidePoly.html //
	 */

	public static boolean contains(Point testPoint, Polygon poly) {

		boolean result = false;
		int polyLength = poly.getPoints().size();
	

		for (int i = 0, j = polyLength - 1; i < polyLength; j = i++) {
			if (((poly.getPoints().get(i).getY() > testPoint.getY()) != (poly.getPoints().get(j).getY() > testPoint
					.getY()))
					&& (testPoint.getX() < (poly.getPoints().get(j).getX() - poly.getPoints().get(i).getX())
							* (testPoint.getY() - poly.getPoints().get(i).getY())
							/ (poly.getPoints().get(j).getY() - poly.getPoints().get(i).getY())
							+ poly.getPoints().get(i).getX())) {
				result = !result;

			}
		}
		return result;

	

	
}
}
