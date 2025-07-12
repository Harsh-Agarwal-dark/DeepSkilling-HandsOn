package com.example.ormlearn;

import com.example.ormlearn.model.Country;
import com.example.ormlearn.service.CountryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

	private static CountryService countryService;

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);

		LOGGER.info("Inside main");

		testGetAllCountries();
		testFindByCode();
		testAddCountry();
		testUpdateCountry();
		testDeleteCountry();
	}

	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> list = countryService.getAllCountries();
		list.forEach(c -> LOGGER.info("Country: {}", c));
		LOGGER.info("End");
	}

	private static void testFindByCode() {
		Country c = countryService.findCountryByCode("IN");
		LOGGER.info("Found: {}", c);
	}

	private static void testAddCountry() {
		Country c = new Country();
		c.setCode("JP");
		c.setName("Japan");
		countryService.addCountry(c);
	}

	private static void testUpdateCountry() {
		countryService.updateCountry("JP", "Nippon");
	}

	private static void testDeleteCountry() {
		countryService.deleteCountry("JP");
	}
}
