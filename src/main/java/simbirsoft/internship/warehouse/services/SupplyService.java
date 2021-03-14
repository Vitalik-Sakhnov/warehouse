package simbirsoft.internship.warehouse.services;

import simbirsoft.internship.warehouse.dto.SupplyDto;

import java.util.List;

public interface SupplyService {
    /**
     * Метод добавления прихода товара.
     *
     * @param supplyDto - информация о приходе, которую нужно добавить
     * @return - информацию о выполненном приходе
     */
    SupplyDto save(SupplyDto supplyDto);

    /**
     * Метод поиска всех приходов.
     *
     * @return - список всех приходов
     */
    List<SupplyDto> findAll();
}
