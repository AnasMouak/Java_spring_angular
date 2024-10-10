package spring.java_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.java_spring.model.City;
import spring.java_spring.model.Country;
import spring.java_spring.repository.CityRepository;
import spring.java_spring.repository.CountryRepository;

import java.util.List;


@Service
public class CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public CityService(CityRepository cityRepository, CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public City addCityToCountry(Long countryId, City city) {
        Country country = countryRepository.findById(countryId).orElse(null);
        city.setCountry(country);
        return cityRepository.save(city);
    }
}
