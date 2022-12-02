package PointsPolygon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class TestFileHandler {

	@Test
	public void testReadFile() throws IOException {

		FileHandler fhandler = new FileHandler();
		List<Point> list = new ArrayList<Point>();

		File myFile = new File("testFile.txt");

		FileWriter writer = new FileWriter(myFile);

		writer.write("1,1\n");
		writer.write("2,2\n");
		writer.write("3,3\n");
		writer.write("4,4\n");
		writer.write("5,5\n");
		writer.write("6,6\n");

		writer.close();

		Scanner fileScanner = new Scanner(myFile);

		list = fhandler.readFile(myFile);

		fileScanner.close();

		assertEquals(1, list.get(0).getX());
		assertEquals(1, list.get(0).getY());
		assertEquals(2, list.get(1).getX());
		assertEquals(2, list.get(1).getY());
		assertEquals(3, list.get(2).getX());
		assertEquals(3, list.get(2).getY());
		assertEquals(4, list.get(3).getX());
		assertEquals(4, list.get(3).getY());
		assertEquals(5, list.get(4).getX());
		assertEquals(5, list.get(4).getY());
		assertEquals(6, list.get(5).getX());
		assertEquals(6, list.get(5).getY());
		
		myFile.delete();

	}
	
	@Test
	public void testReadFileString() throws IOException {
		FileHandler fhandler = new FileHandler();
		List<Point> list = new ArrayList<Point>();

		list = fhandler.readFile("readfile.txt");

		assertEquals(2, list.get(0).getX());
		assertEquals(1, list.get(0).getY());
		assertEquals(1, list.get(1).getX());
		assertEquals(2, list.get(1).getY());
		assertEquals(1, list.get(2).getX());
		assertEquals(3, list.get(2).getY());
		assertEquals(2, list.get(3).getX());
		assertEquals(4, list.get(3).getY());
		assertEquals(3, list.get(4).getX());
		assertEquals(3, list.get(4).getY());
		assertEquals(3, list.get(5).getX());
		assertEquals(2, list.get(5).getY());
	}
	
	@Test
	public void testExceptions() {
		FileHandler fhandler = new FileHandler();
		
		assertThrows(FileNotFoundException.class, ()-> fhandler.readFile("idontexist.txt"));
		assertThrows(FileNotFoundException.class, ()-> fhandler.readFile(new File("noFile")));
		
	}
	
	@Test
	public void testWriteFile() throws IOException {
		
		List<Point> list1 = new ArrayList<>();
		list1.add(new Point(1,1));
		list1.add(new Point(2,2));
		list1.add(new Point(3,3));
		Polygon poly = new Polygon(list1);
		
	FileHandler filehandler = new FileHandler();
	filehandler.writePoly(poly);
	}
	

	@Test
	public void testCreateReport() throws IOException {

		List<String> inOrOutTest = new ArrayList<>();

		inOrOutTest.add("1,5");
		inOrOutTest.add("3,5");
		inOrOutTest.add("1,2");
		inOrOutTest.add("3,1");

		FileHandler filehandler = new FileHandler();

		filehandler.createReport(inOrOutTest);
		

	}

}
