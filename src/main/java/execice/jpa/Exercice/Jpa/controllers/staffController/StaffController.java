package execice.jpa.Exercice.Jpa.controllers.staffController;

import execice.jpa.Exercice.Jpa.controllers.payloads.StaffPayload;
import execice.jpa.Exercice.Jpa.controllers.salesDTO.StaffDTO;
import execice.jpa.Exercice.Jpa.services.staffService.StaffService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/staff")
@AllArgsConstructor
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping("/create")
    public ResponseEntity<StaffDTO> createStaff(@RequestBody StaffPayload payload){
        StaffDTO createStaff = staffService.createStaff(payload);
        return new ResponseEntity<>(createStaff, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<StaffDTO> getStaffById(@PathVariable int id){
        StaffDTO staffDTO = staffService.getStaffById(id);
        return  new ResponseEntity<>(staffDTO, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<StaffDTO>> getAllStaff() { // Ajoutez les parenthèses ici
        List<StaffDTO> staffDTOs = staffService.getAllStaff();
        return new ResponseEntity<>(staffDTOs, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<StaffDTO> updateStaff(@PathVariable int id, @RequestBody StaffPayload payload){
        StaffDTO updateStaff = staffService.updateStaff(id, payload);
        return new ResponseEntity<>(updateStaff, HttpStatus.OK);
    }

    @PutMapping("/assign-manager/{staffId}/{managerId}")
    public StaffDTO assignManager(@PathVariable int staffId, @PathVariable int managerId) {
        return staffService.assignManager(staffId, managerId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable int id){
        staffService.deleteStaff(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }


}
