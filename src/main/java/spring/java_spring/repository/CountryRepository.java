package spring.java_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.java_spring.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
    
}
