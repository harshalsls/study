package com.study.all.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Binnur Kurt (binnur.kurt@gmail.com)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	private int id;
	private String title;
	private int year;
	private String imdb;
	private List<Genre> genres;
	private List<Director> directors;
	{
		genres = new ArrayList<>();
		directors = new ArrayList<>();
	}

	public Movie(int id, String title, int year, String imdb) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.imdb = imdb;
	}

}