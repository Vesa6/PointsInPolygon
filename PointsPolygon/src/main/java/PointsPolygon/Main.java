package PointsPolygon;


import java.io.FileNotFoundException;


public class Main {

	/**
	 * @param args
	 * @throws Exception
	 * @throws FileNotFoundException
	 */

	public static void main(String[] args) throws Exception, FileNotFoundException {
		

		FileHandler filehandler = new FileHandler();

		String fileName;
		Polygon polygon = null;
		Points points = null;

		//Polygon.lineBuilder(new Point(4,2), new Point(6,4));
		//Polygon.lineBuilder(new Point(0,0), new Point(0,4));
		
		
		
		fileName = "polygoni.txt";
		polygon = new Polygon((filehandler.readFile(fileName)));

		if (polygon.getPoints().size() < 3) {
			throw new RuntimeException("The polygon needs at least 3 edges.");
		}

		fileName = "pisteet.txt";
		points = new Points((filehandler.readFile(fileName)));

		// Checks which points are inside the polygon, and writes to the report
		// accordingly.
		
		
		

	}

	

	// This finds out if the testPoint is on the edge of the polygon.
/*	public static boolean isOnEdge(Point testPoint, Polygon poly) {

		int polyLength = poly.getPoints().size();

		boolean result = false;

		for (int i = 0; i < polyLength; i++) {
			if (testPoint.getX() == poly.getPoints().get(i).getX()
					&& testPoint.getY() == poly.getPoints().get(i).getY()) {
				result = true;
			}
		}
		return result;
	}*/

	// This finds out if the testPoint is inside the polygon. Testpoints on the edge
	// are considered to be outside the polygon.
	

	/**
	 * // * @param args // * @throws Exception // * @throws FileNotFoundException //
	 * * Based on the following academic source:
	 * https://www.eecs.umich.edu/courses/eecs380/HANDOUTS/PROJ2/InsidePoly.html //
	 */
	/*public static boolean contains(Point testPoint, Polygon poly) {

		int polyLength = poly.getPoints().size();

		int i;
		int j;
		boolean result = false;
		for (i = 0, j = polyLength - 1; i < polyLength; j = i++) {
			if ((poly.getPoints().get(i).getY() > testPoint.getY()) != (poly.getPoints().get(j).getY() > testPoint
					.getY())
					&& (testPoint.getX() < (poly.getPoints().get(j).getX() - poly.getPoints().get(i).getX())
							* (testPoint.getY() - poly.getPoints().get(i).getY())
							/ (poly.getPoints().get(j).getY() - poly.getPoints().get(i).getY())
							+ poly.getPoints().get(i).getX())) {
				result = !result;
			}
		}
		return result;
	}
	*/
}
