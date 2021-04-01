package simbirsoft.internship.warehouse.services;

import simbirsoft.internship.warehouse.dto.WriteOffDto;

import java.util.Date;
import java.util.List;

public interface WriteOffService {
    /**
     * Метод добавления списания.
     *
     * @param writeOffDto - информация о списании, которое нужно выполнить
     * @return - информацию о выполненном списании
     */
    WriteOffDto save(WriteOffDto writeOffDto);

    /**
     * Метод поиска всех списаний.
     *
     * @return - список всех списаний
     */
    List<WriteOffDto> findAll();

    List<WriteOffDto> byPeriod(Date firstDate, Date secondDate);
}
