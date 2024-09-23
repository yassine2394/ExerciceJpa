package execice.jpa.Exercice.Jpa.controllers;

import execice.jpa.Exercice.Jpa.controllers.payloads.StaffPayload;
import execice.jpa.Exercice.Jpa.controllers.salesDTO.CustomerDTO;
import execice.jpa.Exercice.Jpa.controllers.salesDTO.StaffDTO;
import execice.jpa.Exercice.Jpa.services.SalesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/sales")
@AllArgsConstructor
public class SalesController {

    // Injection de SalesService qui contient les méthodes CRUD
    @Autowired
    private SalesService salesService;


    @PostMapping("/createCustomeer")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO createdCustomer = salesService.createCustomer(customerDTO);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable int id) {
        CustomerDTO customerDTO = salesService.getCustomerById(id);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String zipCode) {
        List<CustomerDTO> customerDTOs = salesService.getAllCustomers(city, zipCode);
        return new ResponseEntity<>(customerDTOs, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable int id, @RequestBody CustomerDTO customerDTO) {
        CustomerDTO updatedCustomer = salesService.updateCustomer(id, customerDTO);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
        salesService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Gestion des Staffs
    @PostMapping("/createStaff")
    public  ResponseEntity<StaffDTO> createStaff(@RequestBody StaffPayload payload){
        StaffDTO createStaff = salesService.createStaff(payload);
        return new ResponseEntity<>(createStaff, HttpStatus.CREATED);

    }

    @GetMapping("/staff/{id}")
    public ResponseEntity<StaffDTO> getStaffById(@PathVariable int id){
        StaffDTO staffDTO = salesService.getStaffById(id);
        return  new ResponseEntity<>(staffDTO, HttpStatus.OK);
    }

    @GetMapping("/allStaff")
    public ResponseEntity<List<StaffDTO>> getAllStaff() { // Ajoutez les parenthèses ici
        List<StaffDTO> staffDTOs = salesService.getAllStaff();
        return new ResponseEntity<>(staffDTOs, HttpStatus.OK);
    }

    @PutMapping("/updateStaff")
    public ResponseEntity<StaffDTO> updateStaff(@PathVariable int id, @RequestBody StaffDTO dto){
        StaffDTO updateStaff = salesService.updateStaff(id, dto);
        return new ResponseEntity<>(updateStaff, HttpStatus.OK);
    }

    @PostMapping("/asignermanager")
    public ResponseEntity<StaffDTO> asignerManager(@RequestBody StaffPayload payload){
        StaffDTO asignerStaff = salesService.assignManager(payload);
        return new ResponseEntity<>(asignerStaff, HttpStatus.CREATED);
    }

    @DeleteMapping("/staff/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable int id){
        salesService.deleteStaff(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
