package ua.lviv.iot.DB_Lab.repository;

import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ua.lviv.iot.DB_Lab.model.Country;

@Api
//@RepositoryRestResource
public interface CountryRepo extends JpaRepository<Country, Integer> {
    Country save(Country country);
}
