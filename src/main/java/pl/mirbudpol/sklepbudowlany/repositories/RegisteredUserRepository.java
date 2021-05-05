package pl.mirbudpol.sklepbudowlany.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.mirbudpol.sklepbudowlany.entities.RegisteredUser;

import java.util.Optional;

public interface RegisteredUserRepository extends CrudRepository<RegisteredUser, Long>, PagingAndSortingRepository<RegisteredUser, Long> {
    Optional<RegisteredUser> findById(Long id);
}
