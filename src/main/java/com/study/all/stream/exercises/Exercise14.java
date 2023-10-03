package com.study.all.stream.exercises;

import com.study.all.stream.dao.InMemoryWorldDao;
import com.study.all.stream.dao.WorldDao;
import com.study.all.stream.domain.Country;
import com.study.all.stream.util.CountrySummaryStatistics;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

import static java.util.stream.Collector.of;
import static java.util.stream.Collectors.groupingBy;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise14 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

	private static final BiConsumer<String, CountrySummaryStatistics> printEntry =
			(continent, statistics) -> System.out.printf("%s: %s\n", continent, statistics);

	private static final BiConsumer<CountrySummaryStatistics, Country> accumulator = (a, c) -> a.accept(c);
	private static final BinaryOperator<CountrySummaryStatistics> combiner = (l, r) -> { l.combine(r);	return l; };
	private static final Supplier<CountrySummaryStatistics> countrySummaryStatisticsSupplier = 
			() -> new CountrySummaryStatistics((l, r) -> Long.compare(l.getPopulation(), r.getPopulation()));

	public static void main(String[] args) {
		// Find the countries of each continent with the minimum and the maximum population
		var continentStatistics = 
				worldDao.findAllCountries()
				        .stream()
				        .collect(groupingBy(Country::getContinent, of(countrySummaryStatisticsSupplier, accumulator, combiner)));
		continentStatistics.forEach(printEntry);
	}

}
