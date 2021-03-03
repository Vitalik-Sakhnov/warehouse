package simbirsoft.internship.warehouse.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbirsoft.internship.warehouse.entities.Warehouse;
import simbirsoft.internship.warehouse.repositories.WarehouseRepository;
import simbirsoft.internship.warehouse.services.WarehouseService;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    private WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    /**
     * Метод добавления товара на склад.
     *
     * @param warehouse - информация о товаре, который нужно добавить
     * @return - информацию о добавленном товаре на склад
     */
    @Override
    public Warehouse save(Warehouse warehouse) {
        if (warehouse.getId() != null) {
            warehouseRepository.deleteById(warehouse.getId());
        }
        warehouseRepository.save(warehouse);
        return warehouse;
    }

    /**
     * Метод поиска всех товаров на складе.
     *
     * @return - список всех товаров на складе
     */
    @Override
    public List<Warehouse> findAll() {
        return warehouseRepository.findAll();
    }
}
