package simbirsoft.internship.warehouse.services;

import simbirsoft.internship.warehouse.entities.Warehouse;

import java.util.List;

public interface WarehouseService {
    /**
     * Метод добавления товара на склад.
     *
     * @param warehouse - информация о товаре, который нужно добавить
     * @return - информацию о добавленном товаре на склад
     */
    Warehouse save(Warehouse warehouse);

    /**
     * Метод поиска всех товаров на складе.
     *
     * @return - список всех товаров на складе
     */
    List<Warehouse> findAll();
}
