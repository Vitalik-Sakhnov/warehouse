package simbirsoft.internship.warehouse.services;

import simbirsoft.internship.warehouse.entities.WriteOff;

import java.util.List;

public interface WriteOffService {
    /**
     * Метод добавления списания.
     *
     * @param writeOff - информация о списании, которое нужно выполнить
     * @return - информацию о выполненном списании
     */
    WriteOff save(WriteOff writeOff);

    /**
     * Метод поиска всех списаний.
     *
     * @return - список всех списаний
     */
    List<WriteOff> findAll();
}
