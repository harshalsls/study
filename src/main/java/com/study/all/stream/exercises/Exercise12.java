package com.study.all.stream.exercises;

import com.study.all.stream.dao.InMemoryWorldDao;
import com.study.all.stream.dao.WorldDao;
import com.study.all.stream.domain.Country;

import java.util.LongSummaryStatistics;
import java.util.function.BiConsumer;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summarizingLong;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise12 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

	private static final BiConsumer<String, LongSummaryStatistics> printEntry = (continent, statistics) -> System.out.printf("%s: %s\n", continent, statistics);

	public static void main(String[] args) {
		// Find the minimum, the maximum and the average population of each continent.
		var populationSummaryByContinent = 
			worldDao.findAllCountries()
			        .stream()
				    .collect(groupingBy(Country::getContinent, summarizingLong(Country::getPopulation)));
		populationSummaryByContinent.forEach(printEntry);
	}

}
