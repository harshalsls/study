package com.study.all.stream.exercises;

import com.study.all.stream.dao.InMemoryWorldDao;
import com.study.all.stream.dao.WorldDao;
import com.study.all.stream.domain.Country;

import java.util.Optional;
import java.util.function.BiConsumer;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise10 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();
	private static final BiConsumer<String,Optional<Country>> printEntry = (continent, country) -> System.out.printf("%s: %s\n",continent,country.get());
	public static void main(String[] args) {
		// Find the richest country of each continent with respect to their GNP (Gross National Product) values.
        var richestCountryByContinent =
                worldDao.findAllCountries()
                      .stream()
                      .collect(groupingBy(Country::getContinent,maxBy(comparing(Country::getGnp))));
        richestCountryByContinent.forEach(printEntry);
	}

}
