package com.example.demo.model;

public class Marvel {

	private int phase;
	private String movie;

	public Marvel(int phase, String movie) {
		super();
		this.phase = phase;
		this.movie = movie;
	}

	public int getPhase() {
		return phase;
	}

	public void setPhase(int phase) {
		this.phase = phase;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

}
