package execice.jpa.Exercice.Jpa.services;

import execice.jpa.Exercice.Jpa.dto.StoreDTO;
import execice.jpa.Exercice.Jpa.dto.StoreMapper;
import execice.jpa.Exercice.Jpa.repo.sales.stores.Store;
import execice.jpa.Exercice.Jpa.repo.sales.stores.StoreRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StoreService {

    private final StoreRepo storeRepo;
    private final StoreMapper storeMapper = StoreMapper.INSTANCE;

    public StoreDTO addStore(StoreDTO storeDTO) {
        Store store = storeMapper.storeDTOToStore(storeDTO);
        return storeMapper.storeToStoreDTO(storeRepo.save(store));
    }

    public StoreDTO updateStore(int id, StoreDTO storeDTO) {
        if (!storeRepo.existsById(id)) {
            return null;
        }
        Store store = storeMapper.storeDTOToStore(storeDTO);
        store.setStoreId(id);
        return storeMapper.storeToStoreDTO(storeRepo.save(store));
    }

    public void deleteStore(int storeId) {
        storeRepo.deleteById(storeId);
    }

    public StoreDTO getStoreById(int storeId) {
        Optional<Store> storeOptional = storeRepo.findById(storeId);
        return storeOptional.map(storeMapper::storeToStoreDTO).orElse(null);
    }

    public List<StoreDTO> getAllStores() {
        List<Store> stores = storeRepo.findAll();
        return storeMapper.storesToStoreDTOs(stores);
    }

}