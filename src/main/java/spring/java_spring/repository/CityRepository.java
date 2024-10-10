package spring.java_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.java_spring.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
    
}
