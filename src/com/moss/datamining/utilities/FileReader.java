package com.moss.datamining.utilities;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import com.moss.datamining.model.Joke;

public class FileReader {

	public static Map<Integer, Joke> itsJokes = null;

	// --------------------------------------------------------------------------

	public FileReader() {
		itsJokes = new HashMap<Integer, Joke>();
	}

	// --------------------------------------------------------------------------

	/**
	 * Loads data
	 * 
	 * @throws FileNotFoundException
	 * 
	 */
	public void loadData(String aFileName, int aWhatType) throws FileNotFoundException {

		switch (aWhatType) {

		case 1:

			Scanner theScanner = new Scanner(new File(aFileName));

			while (theScanner.hasNextLine()) {

				String theLine = theScanner.nextLine();
				Scanner s = new Scanner(theLine);
				s.useDelimiter(" ");

				int userId = s.nextInt();
				int jokeId = s.nextInt();
				double rating = s.nextDouble();

				if (!itsJokes.containsKey(jokeId)) {
					Joke joke = new Joke(jokeId);
					joke.addRating(rating);
					itsJokes.put(jokeId, joke);
				} else {
					itsJokes.get(jokeId).addRating(rating);
				}

				s.close();
			}
			theScanner.close();
			break;

		case 2:

			Scanner theScanner2 = new Scanner(new File(aFileName));

			while (theScanner2.hasNextLine()) {

				String theLine = theScanner2.nextLine();
				Scanner s = new Scanner(theLine);
				s.useDelimiter(" ");

				int jokeId = s.nextInt();
				ArrayList<String> contents = new ArrayList<String>();

				while (s.hasNext()) {
					String content = s.next();
					contents.add(content);
				}

				if (!itsJokes.containsKey(jokeId)) {
					Joke joke = new Joke(jokeId);
					joke.setContent(contents);
					itsJokes.put(jokeId, joke);
				} else {
					itsJokes.get(jokeId).setContent(contents);
				}

				s.close();
			}

			theScanner2.close();
			break;

		default:
			break;
		}
	}

	// --------------------------------------------------------------------------

	/**
	 * 
	 * @param aFileName
	 * @throws FileNotFoundException
	 */
	public void saveData(String aFileName) throws FileNotFoundException {

		PrintWriter writer = new PrintWriter(aFileName);

		for (Entry<Integer, Joke> entry : FileReader.itsJokes.entrySet()) {

			int key = entry.getKey();
			Joke value = entry.getValue();

			double rating = value.getRating();
			int count = value.getContent().size();
			String funny = value.getFunny();

			if (rating != 0) {

				writer.println("{ 0 " + count + ", 1 " + rating + ", 2 \"");

				for (String s : value.getContent()) {
					writer.print(s + " ");
				}

				writer.print("\", 3 \"" + funny + "\" }");
			}
		}

		writer.close();
	}

	// --------------------------------------------------------------------------

	/**
	 * 
	 * @param aFileName
	 * @throws FileNotFoundException
	 */
	public void saveBestData(String aFileName) throws FileNotFoundException {

		PrintWriter writer = new PrintWriter(aFileName);

		for (Entry<Integer, Joke> entry : FileReader.itsJokes.entrySet()) {

			int key = entry.getKey();
			Joke value = entry.getValue();

			double rating = value.getRating();
			int count = value.getContent().size();
			String funny = value.getFunny();

			if (rating != 0) {

				writer.println("{ 0 " + count + ", 1 " + rating + ", 2 \"");

				for (String s : value.getContent()) {
					writer.print(s + " ");
				}

				writer.print("\", 3 \"" + funny + "\" }");
			}
		}

		writer.close();
	}
	
	// --------------------------------------------------------------------------

	/**
	 * Prints data points
	 * 
	 */
	public void printData() {

		System.out.println("----------FILE DATA----------");

		for (Entry<Integer, Joke> entry : FileReader.itsJokes.entrySet()) {

			int key = entry.getKey();
			Joke value = entry.getValue();

			System.out.println("id: " + key + " rating: " + value.getRating());
			System.out.println("content: " + value.getContent());
			System.out.println("count: " + value.getContent().size());
		}

		System.out.println("----------FILE DATA----------\n");
	}

}
