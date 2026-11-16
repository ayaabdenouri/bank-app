package ma.formations.msa.customerservice.web;

import ma.formations.msa.customerservice.entities.Customer;
import ma.formations.msa.customerservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerRestController {

    private CustomerRepository customerRepository;

    public CustomerRestController(
            CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Récupérer tous les clients
    @GetMapping("/customers")
    public List<Customer> listCustomers() {
        return customerRepository.findAll();
    }

    // Rechercher un client avec son ID
    @GetMapping("/customers/{id}")
    public Customer customerById(@PathVariable Long id) {
        return customerRepository.findById(id).get();
    }

    // Ajouter un nouveau client
    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    // Modifier un client existant
    @PutMapping("/customers/{id}")
    public Customer updateCustomer(
            @RequestBody Customer customer,
            @PathVariable Long id) {

        customer.setId(id);
        return customerRepository.save(customer);
    }

    // Supprimer un client
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }
}