package spring.java_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import spring.java_spring.model.Country;
import spring.java_spring.model.City;
import spring.java_spring.service.CountryService;
import spring.java_spring.service.CityService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CountryList {

    private final CountryService countryService;

    private final CityService cityService;

    @Autowired
    public CountryList(CountryService countryService, CityService cityService) {
        this.countryService = countryService;
        this.cityService = cityService;
    }

    // commented this because i use angular to display the data insted with thymeleaf
    
    /**@GetMapping("/countries")
    public ModelAndView listCountries() {
        ModelAndView modelAndView = new ModelAndView("CountryList");
        List<Country> countries = countryService.findAll();
        modelAndView.addObject("countries", countries);
        return modelAndView;
    }**/

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return countryService.findAll();
    }

    @GetMapping("/cities")
    public List<City> getCities() {
        return cityService.findAll();
    }

    @PostMapping("/countries")
    public Country addCountry(@RequestBody Country country) {
        return countryService.save(country);
    }

    @PostMapping("/countries/{countryId}/cities")
    public City addCityToCountry(@PathVariable Long countryId, @RequestBody City city) {
        return cityService.addCityToCountry(countryId, city);
    }

    @GetMapping("/countries/{countryId}")
    public Country getCountry(@PathVariable Long countryId) {
        return countryService.findById(countryId).
                orElseThrow(() -> new RuntimeException("Country not found"));
    }
    
}
