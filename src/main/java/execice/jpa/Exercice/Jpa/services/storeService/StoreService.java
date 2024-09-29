package execice.jpa.Exercice.Jpa.services.storeService;

import execice.jpa.Exercice.Jpa.controllers.payloads.StorePayload;
import execice.jpa.Exercice.Jpa.controllers.salesDTO.StoreDTO;
import execice.jpa.Exercice.Jpa.controllers.salesDTO.StoreMapper;
import execice.jpa.Exercice.Jpa.repo.sales.stores.Store;
import execice.jpa.Exercice.Jpa.repo.sales.stores.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {

    @Autowired
    private StoreRepo storeRepo;
    private  final StoreMapper storeMapper= StoreMapper.INSTANCE;


    public StoreDTO CreateStore(StorePayload payload){
        Store store = storeMapper.toEntity(payload);
        store = storeRepo.save(store);
        return storeMapper.toDTO(store);
    }

    public StoreDTO getStoreById(int id){
        Store store = storeRepo.findByStoreId(id);
        return  storeMapper.toDTO(store);
    }

    public List<StoreDTO> getAllStore(){
        List<Store> stores = storeRepo.findAll();
        return stores.stream()
                .map(storeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public StoreDTO updateStore(int storeId, StorePayload payload) {

        Store store = storeRepo.findByStoreId(storeId);
        store.setStoreName(payload.getStoreName());
        store.setPhone(payload.getPhone());
        store.setEmail(payload.getEmail());
        store.setStreet(payload.getStreet());
        store.setCity(payload.getCity());
        store.setState(payload.getState());
        store.setZipCode(payload.getZipCode());
        store = storeRepo.save(store);
        return storeMapper.toDTO(store);
    }

    public void deleteStore(int storeId){
        Store store = storeRepo.findByStoreId(storeId);
        storeRepo.delete(store);
    }
}
