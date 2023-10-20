package com.study.all.stream.exercises;

import com.study.all.stream.domain.Director;
import com.study.all.stream.domain.Movie;
import com.study.all.stream.service.InMemoryMovieService;
import com.study.all.stream.service.MovieService;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise1 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Find the number of movies of each director
        final Collection<Movie> movies = movieService.findAllMovies();



//		movies.stream().map(Movie::getDirectors).flatMap(Collection::stream)
//				.collect(Collectors.groupingBy(Director::getName, Collectors.counting()))
//				.forEach((string, aLong) -> System.out.println("Director : " + string + " , Movies : " + aLong ));

		movies.stream().map(movie -> movie.getDirectors().stream().map(director -> new AbstractMap.SimpleEntry<>(director.getName(), movie.getTitle())).toList())
				.flatMap(Collection::stream)
				.collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getKey, Collectors.mapping(AbstractMap.SimpleEntry::getValue, Collectors.toSet())))
				.forEach((director, movies1) -> System.out.println("Director : " + director + " , Movies : " + movies1.toString() ));



        Map<String,Long> dirMovCounts =
        movies.stream().map(Movie::getDirectors)
        			   .flatMap(Collection::stream)
                       .collect(Collectors.groupingBy(
                    		       Director::getName,
                    		       Collectors.counting()
                    		     )
                        );
        dirMovCounts.forEach((name,count) -> System.out.printf("%20s: %3d\n",name,count));

	}




}
