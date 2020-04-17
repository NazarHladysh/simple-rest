package ua.lviv.iot.DB_Lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.DB_Lab.model.Author;

public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
