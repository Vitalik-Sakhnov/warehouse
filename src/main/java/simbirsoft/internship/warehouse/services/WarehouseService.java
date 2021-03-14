package simbirsoft.internship.warehouse.services;

import simbirsoft.internship.warehouse.dto.WarehouseDto;

import java.util.List;

public interface WarehouseService {
    /**
     * Метод добавления товара на склад.
     *
     * @param warehouseDto - информация о товаре, который нужно добавить
     * @return - информацию о добавленном товаре на склад
     */
    WarehouseDto save(WarehouseDto warehouseDto);

    /**
     * Метод поиска всех товаров на складе.
     *
     * @return - список всех товаров на складе
     */
    List<WarehouseDto> findAll();
}
