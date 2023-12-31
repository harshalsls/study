package com.study.all.stream.exercises;

import com.study.all.stream.dao.InMemoryWorldDao;
import com.study.all.stream.dao.WorldDao;
import com.study.all.stream.util.CountrySummaryStatistics;

import java.util.function.Supplier;

import static java.lang.Long.compare;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise13 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

	private static final Supplier<CountrySummaryStatistics> countrySummaryStatisticsSupplier = 
			() -> new CountrySummaryStatistics((l, r) -> compare(l.getPopulation(), r.getPopulation()));

	public static void main(String[] args) {
		// Find the countries with the minimum and the maximum population
		var countrySummaryStatistics = 
				worldDao.findAllCountries()
				        .stream()
				        .collect(countrySummaryStatisticsSupplier, CountrySummaryStatistics::accept, CountrySummaryStatistics::combine);
		System.out.println(countrySummaryStatistics);
	}

}
