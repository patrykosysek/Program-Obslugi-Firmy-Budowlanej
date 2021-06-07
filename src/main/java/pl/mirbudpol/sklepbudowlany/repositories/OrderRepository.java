package pl.mirbudpol.sklepbudowlany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mirbudpol.sklepbudowlany.entities.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {



    Optional<List<Order>> findAllByKlient_Id(Long id);
}
