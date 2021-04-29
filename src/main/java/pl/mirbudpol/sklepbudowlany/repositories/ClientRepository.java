package pl.mirbudpol.sklepbudowlany.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.mirbudpol.sklepbudowlany.entities.Client;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long>, PagingAndSortingRepository<Client, Long> {

    Optional<Client> findById(Long id);

}
