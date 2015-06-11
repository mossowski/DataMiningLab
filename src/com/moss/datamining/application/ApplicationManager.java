package com.moss.datamining.application;

import java.io.FileNotFoundException;
import java.util.Map.Entry;

import com.moss.datamining.model.Joke;
import com.moss.datamining.utilities.FileReader;

public class ApplicationManager {

	public ApplicationManager() throws FileNotFoundException {

		FileReader fr = new FileReader();
		fr.loadData("jester_ratings.txt", 1);
		fr.loadData("jester_items.txt", 2);
		
		for (Entry<Integer, Joke> entry : FileReader.itsJokes.entrySet()) {
		    Joke value = entry.getValue();
		    value.calculateRating();
		    value.setFunny(3);
		}
		
		fr.saveData("jester.txt");
		
		fr.printData();
	}

}
