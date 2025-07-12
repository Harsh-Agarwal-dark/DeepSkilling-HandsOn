package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    private static final Map<String, Country> countryMap = new HashMap<>();

    static {
        countryMap.put("IN", new Country("IN", "India"));
        countryMap.put("US", new Country("US", "United States"));
        countryMap.put("FR", new Country("FR", "France"));
    }

    @GetMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START");
        Country country = countryMap.get("IN");
        LOGGER.info("END");
        return country;
    }

    @GetMapping("/countries/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        LOGGER.info("START: getCountryByCode({})", code);
        Country country = countryMap.get(code.toUpperCase());
        LOGGER.info("END");
        return country;
    }
}
