package PointsPolygon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

	String filename = null;

	public FileHandler() {

	}

	/**
	 * @param fileName
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException
	 */
	
	//Write multiple points to file.
	public void WriteToFile(String[] toWrite, String filename) throws IOException {
		PrintWriter writer = new PrintWriter(filename + ".txt");
		for(String str: toWrite) {
			writer.println(str);
		}
		writer.close();
	}
	
	//Write a single point to file.
	public void WriteToFile(String toWrite, String filename) throws IOException {
		FileWriter writer = new FileWriter(filename + ".txt");
		writer.write(toWrite);
		writer.close();
	}
	
	//Read strings from the file, return them as a list.
	public List<String> readFromFile(String filename) throws IOException {
		
		List<String> ls = new ArrayList<String>();
		
		int i = 0;
		String[] lines = null;
		
		File readFile = new File(filename + ".txt");
		
		Scanner fileScanner = new Scanner(readFile);
		while (fileScanner.hasNextLine()) {
			
			ls.add(fileScanner.nextLine());
		}
		
		fileScanner.close();
		return ls;
		
	}
	
	public void writePoints(List<Point> list) throws IOException {
		
		
		PrintWriter writer = new PrintWriter("testPoints.txt", "UTF-8");
		
		for(Point point: list) {
			writer.println(point.getBoth());
		}
		
		writer.close();
	}
	
	public void writePoly(Polygon poly) throws IOException {
		
		PrintWriter writer = new PrintWriter("testPolygon.txt", "UTF-8");
		
		for(Point point: poly.getPoints()) {
			writer.println(point.getBoth());
		}
		
		writer.close();
	}
	
	public List<Point> readFile(String fileName) throws FileNotFoundException {

		List<Point> list = new ArrayList<Point>();

		try {
			File myFile = new File(fileName);
			Scanner fileScanner = new Scanner(myFile);
			while (fileScanner.hasNextLine()) {

				String string = fileScanner.nextLine();

				String[] parts = string.split(",");

				list.add(new Point(Integer.valueOf(parts[0]), Integer.valueOf(parts[1])));
			}
			fileScanner.close();

		} catch (FileNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return list;
	}
	
	/**
	 * @param myFile
	 * @return
	 * @throws FileNotFoundException
	 */
	
	public List<Point> readFile(File myFile) throws FileNotFoundException {

		List<Point> list = new ArrayList<Point>();

		try {
		
			Scanner fileScanner = new Scanner(myFile);
			while (fileScanner.hasNextLine()) {

				String string = fileScanner.nextLine();

				String[] parts = string.split(",");

				list.add(new Point(Integer.valueOf(parts[0]), Integer.valueOf(parts[1])));
			}
			fileScanner.close();

		} catch (FileNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	
	public void createReport(List<String> inOrOut) throws IOException {

		try

		{
			File myFile = new File("selvitys.txt");
			if (myFile.createNewFile()) {
				System.out.println("File added: " + myFile.getName());
			} else if (myFile.delete()) {
				System.out.println("The old report: " + myFile.getName() + " was replaced with a new one.");
			} else {
				System.out.println("File deletion failed.");
			}

			int u = 0;

			FileWriter writer = new FileWriter("selvitys.txt");
			while (u < inOrOut.size()) {
				writer.write(inOrOut.get(u) + "\n");
				u++;
			}
			writer.close();

		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public String[] readReport() {
		
		int i = 0;
		String read[] = new String[100];
		try {
			
			File myFile = new File("selvitys.txt");
			
			Scanner fileScanner = new Scanner(myFile);
			while (fileScanner.hasNextLine()) {

				read[i] = fileScanner.nextLine();
				i++;
			}
			
			fileScanner.close();
			
		}

		catch (Exception e) {
			throw new RuntimeException(e);
		}

		return read;
	}
		
}


