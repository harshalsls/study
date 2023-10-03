package com.study.all.stream.exercises;

import com.study.all.stream.dao.CityDao;
import com.study.all.stream.dao.CountryDao;
import com.study.all.stream.dao.InMemoryWorldDao;
import com.study.all.stream.domain.City;
import com.study.all.stream.domain.Country;

import java.util.Comparator;
import java.util.Objects;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise4 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();
	private static final CityDao cityDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the highest populated capital city
		var highPopulatedCapitalCity = 
				countryDao.findAllCountries()
				          .stream()
				          .map(Country::getCapital)
				          .filter(Objects::nonNull)
				          .map(cityDao::findCityById)
				          .filter(Objects::nonNull)
				          .max(Comparator.comparing(City::getPopulation));
		highPopulatedCapitalCity.ifPresent(System.out::println);		          
	}

}
