package pl.mirbudpol.sklepbudowlany.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.mirbudpol.sklepbudowlany.entities.Klient;

public interface KlientRepository extends CrudRepository<Klient, Integer> {
}
