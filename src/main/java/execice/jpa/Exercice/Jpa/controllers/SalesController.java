package execice.jpa.Exercice.Jpa.controllers;

import execice.jpa.Exercice.Jpa.dto.CustomerDTO;
import execice.jpa.Exercice.Jpa.services.SalesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/sales")
@AllArgsConstructor
public class SalesController {

    private final SalesService salesService;

    @PostMapping("/customers")
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO createdCustomer = salesService.addCustomer(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Integer id, @RequestBody CustomerDTO customerDTO) {
        if (salesService.findCustomerById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        CustomerDTO updatedCustomer = salesService.updateCustomer(id, customerDTO);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        if (salesService.findCustomerById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        salesService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerDTO> findCustomerById(@PathVariable Integer id) {
        CustomerDTO customer = salesService.findCustomerById(id);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> findAllCustomers() {
        List<CustomerDTO> customers = salesService.findAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/customers/search")
    public ResponseEntity<List<CustomerDTO>> findCustomersByCityOrZipCode(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String zipCode) {
        List<CustomerDTO> customers = salesService.findCustomersByCityOrZipCode(city, zipCode);
        return ResponseEntity.ok(customers);
    }
}