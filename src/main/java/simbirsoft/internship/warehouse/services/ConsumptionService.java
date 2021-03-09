package simbirsoft.internship.warehouse.services;

import simbirsoft.internship.warehouse.dto.ConsumptionDto;

import java.util.List;

public interface ConsumptionService {
    /**
     * Метод добавления расхода.
     *
     * @param consumptionDto - информация о расходе, который нужно выполнить
     * @return - информацию о выполненном расходе
     */
    ConsumptionDto save(ConsumptionDto consumptionDto);

    /**
     * Метод поиска всех расходов.
     *
     * @return - список всех расходов
     */
    List<ConsumptionDto> findAll();
}
