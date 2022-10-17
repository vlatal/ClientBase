package al.lat.demo.clientbase.repository;

import al.lat.demo.clientbase.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
