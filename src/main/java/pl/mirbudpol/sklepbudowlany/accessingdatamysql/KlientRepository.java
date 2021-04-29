package pl.mirbudpol.sklepbudowlany.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;
import pl.mirbudpol.sklepbudowlany.Entity.Klient;

public interface KlientRepository extends CrudRepository<Klient, Integer> {
}
