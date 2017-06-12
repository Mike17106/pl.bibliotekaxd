package pl.biblioteka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.biblioteka.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
