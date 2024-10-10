package spring.java_spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.java_spring.repository.CountryRepository;
import spring.java_spring.model.Country;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Country save(Country country) {
        return countryRepository.save(country);
    }

    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }
    
}
