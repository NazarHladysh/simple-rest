package ua.lviv.iot.DB_Lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.DB_Lab.model.App;

@Repository
public interface AppRepo extends JpaRepository<App, Integer> {
}
