package simbirsoft.internship.warehouse.services;

import simbirsoft.internship.warehouse.dto.StoreDto;

import java.util.List;

public interface StoreService {
    /**
     * Метод добавления магазина.
     *
     * @param storeDto - магазин, который нужно добавить
     * @return - добавленный магазин
     */
    StoreDto save(StoreDto storeDto);

    /**
     * Метод поиска всех магазинов.
     *
     * @return - список всех магазинов
     */
    List<StoreDto> findAll();

    /**
     * Метод поиска магазина по его id.
     *
     * @param storeId - id магазина, который нужно найти
     * @return - магазин, у которого id равно передаваемому
     */
    StoreDto findById(Long storeId);

    /**
     * Метод поиска магазина по его наименованию.
     *
     * @param storeName - наименование магазина, который нужно найти
     * @return - магазин, у которого наименование равно передаваемому
     */
    StoreDto findByName(String storeName);

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
     * @param storeDto - новый магазин
     * @return - обновлённый магазин
     */
    StoreDto update(StoreDto storeDto);

}
