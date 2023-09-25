package com.study.all.example.exercises;

import com.study.all.example.dao.InMemoryWorldDao;
import com.study.all.example.dao.WorldDao;
import com.study.all.example.domain.Country;
import com.study.all.example.util.CountryCitySummaryStatistics;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;

import static java.util.stream.Collector.of;
import static java.util.stream.Collectors.groupingBy;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise16 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

	private static final BiConsumer<CountryCitySummaryStatistics, Country> accumulator = (s, c) -> s.accept(c);
	private static final BinaryOperator<CountryCitySummaryStatistics> combiner = (l, r) -> { l.combine(r); return l; };
	private static final BiConsumer<String, CountryCitySummaryStatistics> printEntry = 
			(country,statistics) -> System.out.printf("%s: %s\n", country, statistics);

	public static void main(String[] args) {
		// Find the cities with the minimum and the maximum population in countries.
		var countryCityStatistics = 
		worldDao.findAllCountries()
				.stream()
				.collect(groupingBy(Country::getCode, of(CountryCitySummaryStatistics::new, accumulator, combiner)));
		countryCityStatistics.forEach(printEntry);
	}
}
