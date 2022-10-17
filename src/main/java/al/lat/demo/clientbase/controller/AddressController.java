package al.lat.demo.clientbase.controller;

import al.lat.demo.clientbase.entity.Address;
import al.lat.demo.clientbase.exception.AddressNotFoundException;
import al.lat.demo.clientbase.repository.AddressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    private final AddressRepository repository;

    AddressController(AddressRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/addresses")
    List<Address> all() {
        return repository.findAll();
    }

    @PostMapping("/addresses")
    Address newAddress(@RequestBody Address newAddress) {
        return repository.save(newAddress);
    }

    @GetMapping("/addresses/{id}")
    Address one(@PathVariable Long id) throws AddressNotFoundException {
        return repository.findById(id)
            .orElseThrow(() -> new AddressNotFoundException(id));
    }

    @PutMapping("/addresses/{id}")
    Address replaceAddress(@RequestBody Address newAddress, @PathVariable Long id) {
        return repository.findById(id)
            .map(address -> {
                address.setLine(newAddress.getLine());
                address.setMunicipality(newAddress.getMunicipality());
                address.setPostalCode(newAddress.getPostalCode());
                return repository.save(address);
            })
            .orElseGet(() -> {
                newAddress.setId(id);
                return repository.save(newAddress);
            });
    }

    @DeleteMapping("/addresses/{id}")
    void deleteAddress(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
