package com.study.all.example.exercises;

import com.study.all.example.dao.CountryDao;
import com.study.all.example.dao.InMemoryWorldDao;
import com.study.all.example.domain.City;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise2 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the most populated city of each continent
		var highPopulatedCityOfEachContinent =
				countryDao.findAllCountries()
				          .stream()
				          .map( country -> country.getCities().stream().map(city -> new ContinentCityPair(country.getContinent(),city)).toList())
				          .flatMap(Collection::stream)
				          .collect(Collectors.groupingBy(ContinentCityPair::continent,Collectors.maxBy( ContinentCityPair::compareTo )));
		highPopulatedCityOfEachContinent.forEach(ContinentCityPair::printEntry);


		Map<String, Optional<AbstractMap.SimpleEntry<String, City>>> collect = countryDao.findAllCountries()
				.stream()
				.map(country -> country.getCities().stream().map(city -> new AbstractMap.SimpleEntry<>(country.getContinent(), city)).toList())
				.flatMap(Collection::stream)
				.collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getKey, Collectors.maxBy(Comparator.comparingInt(o -> o.getValue().getPopulation()))));

		collect.forEach((string, stringCitySimpleEntry) -> System.out.println("Continent : " + string + " , City Name : " + stringCitySimpleEntry.get()));


	}

}