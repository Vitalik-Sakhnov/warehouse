package simbirsoft.internship.warehouse.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbirsoft.internship.warehouse.entities.Store;
import simbirsoft.internship.warehouse.repositories.StoreRepository;
import simbirsoft.internship.warehouse.services.StoreService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    private StoreRepository storeRepository;

    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    /**
     * Метод добавления магазина.
     *
     * @param store - магазин, который нужно добавить
     * @return - добавленный магазин
     */
    @Override
    public Store save(Store store) {
        storeRepository.save(store);
        return store;
    }

    /**
     * Метод поиска всех магазинов.
     *
     * @return - список всех магазинов
     */
    @Override
    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    /**
     * Метод поиска магазина по его id.
     *
     * @param storeId - id магазина, который нужно найти
     * @return - магазин, у которого id равно передаваемому
     */
    @Override
    public Store findById(Long storeId) {
        return storeRepository.findById(storeId).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
    }

    /**
     * Метод поиска магазина по его наименованию.
     *
     * @param storeName - наименование магазина, который нужно найти
     * @return - магазин, у которого наименование равно передаваемому
     */
    @Override
    public Store findByName(String storeName) {
        return storeRepository.findByName(storeName);
    }

    /**
     * Метод удаления магазина по его id.
     *
     * @param storeId - id магазина, который нужно удалить
     * @return - true, если удаление прошло успешно, false в противном случа
     */
    @Override
    public boolean deleteById(Long storeId) {
        if (storeRepository.existsById(storeId)) {
            if (findById(storeId).getWarehouses().isEmpty()) {
                storeRepository.deleteById(storeId);
                return true;
            }
        }
        return false;
    }

    /**
     * Метод обновления магазина.
     *
     * @param store - новый магазин
     * @return - обновлённый магазин
     */
    @Override
    public Store update(Store store) {
        if (store.getId() != null) {
            storeRepository.save(store);
        }
        return store;
    }
}
