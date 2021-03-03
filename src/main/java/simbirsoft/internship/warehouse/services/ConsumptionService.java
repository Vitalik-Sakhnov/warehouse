package simbirsoft.internship.warehouse.services;

import simbirsoft.internship.warehouse.entities.Consumption;

import java.util.List;

public interface ConsumptionService {
    /**
     * Метод добавления расхода.
     *
     * @param consumption - информация о расходе, который нужно выполнить
     * @return - информацию о выполненном расходе
     */
    Consumption save(Consumption consumption);

    /**
     * Метод поиска всех расходов.
     *
     * @return - список всех расходов
     */
    List<Consumption> findAll();
}
