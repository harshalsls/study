package com.study.all.stream.exercises;

import com.study.all.stream.domain.Movie;
import com.study.all.stream.service.InMemoryMovieService;
import com.study.all.stream.service.MovieService;

import java.util.stream.Collectors;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise8 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Group the movies by the year and list them
		var moviesByYear =
		movieService.findAllMovies().stream()
		            .collect(Collectors.groupingBy(Movie::getYear));
		moviesByYear.forEach((year,movies) -> System.out.printf("%d: %s\n",year,movies));
	}

}
