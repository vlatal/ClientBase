package al.lat.demo.clientbase.repository;

import al.lat.demo.clientbase.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
