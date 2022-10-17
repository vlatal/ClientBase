package al.lat.demo.clientbase.controller;

import al.lat.demo.clientbase.repository.AddressRepository;
import al.lat.demo.clientbase.repository.ClientRepository;
import al.lat.demo.clientbase.entity.Client;
import al.lat.demo.clientbase.exception.ClientNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    private final ClientRepository repository;
    private final AddressRepository addressRepository;

    ClientController(ClientRepository repository, AddressRepository addressRepository) {
        this.repository = repository;
        this.addressRepository = addressRepository;
    }

    @GetMapping("/clients")
    List<Client> all() {
        return repository.findAll();
    }

    @PostMapping("/clients")
    Client newClient(@RequestBody Client newClient) {
        return repository.save(newClient);
    }

    @GetMapping("/clients/{id}")
    Client one(@PathVariable Long id) throws ClientNotFoundException {
        return repository.findById(id)
            .orElseThrow(() -> new ClientNotFoundException(id));
    }

    @PutMapping("/clients/{id}")
    Client replaceClient(@RequestBody Client newClient, @PathVariable Long id) {
        return repository.findById(id)
            .map(client -> {
                client.setFirstName(newClient.getFirstName());
                client.setLastName(newClient.getLastName());
                client.setBilling(newClient.getBilling());
                client.setMailing(newClient.getMailing());
                return repository.save(client);
            })
            .orElseGet(() -> {
                newClient.setId(id);
                return repository.save(newClient);
            });
    }

    @DeleteMapping("/clients/{id}")
    void deleteClient(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
