package execice.jpa.Exercice.Jpa.controllers.storeController;

import execice.jpa.Exercice.Jpa.controllers.payloads.StorePayload;
import execice.jpa.Exercice.Jpa.controllers.salesDTO.StoreDTO;
import execice.jpa.Exercice.Jpa.services.storeService.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/store")
@AllArgsConstructor
public class StoreController {

    private StoreService storeService;

    @PostMapping("/create")
    public StoreDTO createStore(@RequestBody StorePayload payload){
        StoreDTO storeDTO = storeService.CreateStore(payload);
        return  storeDTO;
    }

    @GetMapping("/{id}")
    public StoreDTO getStoreById(@PathVariable int id){
        StoreDTO storeDTO = storeService.getStoreById(id);
        return storeDTO;

    }

    @GetMapping("/all")
    public List<StoreDTO> getAllStore(){
        List<StoreDTO> storeDTOS = storeService.getAllStore();
        return  storeDTOS;
    }

    //mise à jour
    @PutMapping("{id}")
    public StoreDTO updateStore(@PathVariable int id, @RequestBody StorePayload payload) {
        StoreDTO storeDTO = storeService.updateStore(id, payload);
        return storeDTO;
    }

    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable int id){
        storeService.deleteStore(id);
    }

}
