package com.study.all.example.exercises;

import com.study.all.example.dao.InMemoryWorldDao;
import com.study.all.example.dao.WorldDao;
import com.study.all.example.domain.Country;

import static java.util.stream.Collectors.summarizingLong;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise11 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the minimum, the maximum and the average population of world countries
		var populationSummary = 
		worldDao.findAllCountries()
		        .stream()
				.collect(summarizingLong(Country::getPopulation));
		System.out.println(populationSummary);
	}

}
