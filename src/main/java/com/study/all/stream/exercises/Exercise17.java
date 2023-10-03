package com.study.all.stream.exercises;

import com.study.all.stream.dao.InMemoryWorldDao;
import com.study.all.stream.dao.WorldDao;
import com.study.all.stream.domain.Country;
import com.study.all.stream.util.DoubleSummaryGaussianStatistics;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise17 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the minimum, the maximum, the average, and the standard deviation of GNP values.
        var gnpStatistics =
           worldDao.findAllCountries()
                   .stream()
                   .mapToDouble(Country::getGnp)
                   .collect(
                           DoubleSummaryGaussianStatistics::new,
                           DoubleSummaryGaussianStatistics::accept,
                           DoubleSummaryGaussianStatistics::combine
                   );
        System.out.println(gnpStatistics);
	}

}
