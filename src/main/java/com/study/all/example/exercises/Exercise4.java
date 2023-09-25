package com.study.all.example.exercises;

import com.study.all.example.dao.CityDao;
import com.study.all.example.dao.CountryDao;
import com.study.all.example.dao.InMemoryWorldDao;
import com.study.all.example.domain.City;
import com.study.all.example.domain.Country;

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
