package pl.mirbudpol.sklepbudowlany.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.mirbudpol.sklepbudowlany.entities.Category;

import java.util.Optional;

public interface CategoryRepository  extends CrudRepository<Category, Long>, PagingAndSortingRepository<Category, Long> {

    Optional<Category> findById(Long id);
}
