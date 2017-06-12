package pl.biblioteka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.biblioteka.model.Rent;
import pl.biblioteka.model.Book;
/**
 * Created by domin on 08.06.2017.
 */
public interface RentRepository extends JpaRepository<Rent, Long> {
}
