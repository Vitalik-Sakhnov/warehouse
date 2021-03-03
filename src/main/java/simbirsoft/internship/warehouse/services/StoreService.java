package simbirsoft.internship.warehouse.services;

import simbirsoft.internship.warehouse.entities.Store;

import java.util.List;

public interface StoreService {
    /**
     * Метод добавления магазина.
     *
     * @param store - магазин, который нужно добавить
     * @return - добавленный магазин
     */
    Store save(Store store);

    /**
     * Метод поиска всех магазинов.
     *
     * @return - список всех магазинов
     */
    List<Store> findAll();

    /**
     * Метод поиска магазина по его id.
     *
     * @param storeId - id магазина, который нужно найти
     * @return - магазин, у которого id равно передаваемому
     */
    Store findById(Long storeId);

    /**
     * Метод поиска магазина по его наименованию.
     *
     * @param storeName - наименование магазина, который нужно найти
     * @return - магазин, у которого наименование равно передаваемому
     */
    Store findByName(String storeName);

    /**
     * Метод удаления магазина по его id.
     *
     * @param storeId - id магазина, который нужно удалить
     * @return - true, если удаление прошло успешно, false в противном случа
     */
    boolean deleteById(Long storeId);

    /**
     * Метод обновления магазина.
     *
     * @param store - новый магазин
     * @return - обновлённый магазин
     */
    Store update(Store store);

}
