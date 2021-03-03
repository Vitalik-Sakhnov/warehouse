package simbirsoft.internship.warehouse.services;

import simbirsoft.internship.warehouse.entities.Supply;

import java.util.List;

public interface SupplyService {
    /**
     * Метод добавления прихода товара.
     *
     * @param supply - информация о приходе, которую нужно добавить
     * @return - информацию о выполненном приходе
     */
    Supply save(Supply supply);

    /**
     * Метод поиска всех приходов.
     *
     * @return - список всех приходов
     */
    List<Supply> findAll();
}
