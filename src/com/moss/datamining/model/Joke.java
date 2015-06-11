package com.moss.datamining.model;

import java.util.ArrayList;

public class Joke {
	
	private int id;
	private ArrayList<Double> ratings;
	private double rating;
	private ArrayList<String> content;
	private String funny;
	
	public Joke (int id) {
		this.id = id;
		this.ratings = new ArrayList<Double>();
		this.content = new ArrayList<String>();
	}
	
	public void addRating(double aRating) {
		this.ratings.add(aRating);
	}
	
	public void calculateRating() {
		
		double sum = 0;
		
		for (double i : this.ratings) {
			sum += i;
		}
		
		if (sum != 0)
			this.rating = sum / this.ratings.size();
		else {
			this.rating = 0;
		}
		
	}
	
	public void setFunny(double range) {
		
		if (this.rating >= range)
			this.funny = "yes";
		else
			this.funny = "no";
	}
	
	public String getFunny() {
		return this.funny;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int aId) {
		this.id = aId;
	}

	public ArrayList<Double> getRatings() {
		return this.ratings;
	}

	public void setRatings(ArrayList<Double> aRatings) {
		this.ratings = aRatings;
	}

	public double getRating() {
		return this.rating;
	}

	public void setRating(double aRating) {
		this.rating = aRating;
	}

	public ArrayList<String> getContent() {
		return this.content;
	}

	public void setContent(ArrayList<String> aContent) {
		this.content = aContent;
	}

}
