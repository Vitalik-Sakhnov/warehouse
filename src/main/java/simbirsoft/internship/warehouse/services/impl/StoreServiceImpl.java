package simbirsoft.internship.warehouse.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbirsoft.internship.warehouse.dto.StoreDto;
import simbirsoft.internship.warehouse.entities.Store;
import simbirsoft.internship.warehouse.repositories.StoreRepository;
import simbirsoft.internship.warehouse.services.StoreService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    private StoreRepository storeRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository, ModelMapper modelMapper) {
        this.storeRepository = storeRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Метод добавления магазина.
     *
     * @param storeDto - магазин, который нужно добавить
     * @return - добавленный магазин
     */
    @Override
    public StoreDto save(StoreDto storeDto) {
        Store store = storeRepository.save(modelMapper.map(storeDto, Store.class));
        return modelMapper.map(store, StoreDto.class);
    }

    /**
     * Метод поиска всех магазинов.
     *
     * @return - список всех магазинов
     */
    @Override
    public List<StoreDto> findAll() {
        return modelMapper.map(
                storeRepository.findAll(),
                new TypeToken<List<StoreDto>>() {
                }.getType()
        );
    }

    /**
     * Метод поиска магазина по его id.
     *
     * @param storeId - id магазина, который нужно найти
     * @return - магазин, у которого id равно передаваемому
     */
    @Override
    public StoreDto findById(Long storeId) {
        return modelMapper.map(
                storeRepository.findById(storeId).orElseThrow(
                        () -> new EntityNotFoundException("Entity not found")
                ),
                StoreDto.class
        );
    }

    /**
     * Метод поиска магазина по его наименованию.
     *
     * @param storeName - наименование магазина, который нужно найти
     * @return - магазин, у которого наименование равно передаваемому
     */
    @Override
    public StoreDto findByName(String storeName) {
        return modelMapper.map(storeRepository.findByName(storeName), StoreDto.class);
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

            if (storeRepository.getOne(storeId).getWarehouses().isEmpty()) {
                storeRepository.deleteById(storeId);
                return true;
            }
        }
        return false;
    }

    /**
     * Метод обновления магазина.
     *
     * @param storeDto - новый магазин
     * @return - обновлённый магазин
     */
    @Override
    public StoreDto update(StoreDto storeDto) {
        return save(storeDto);
    }
}
