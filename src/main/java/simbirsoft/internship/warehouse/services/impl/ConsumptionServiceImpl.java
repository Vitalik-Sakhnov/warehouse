package simbirsoft.internship.warehouse.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbirsoft.internship.warehouse.entities.Consumption;
import simbirsoft.internship.warehouse.repositories.ConsumptionRepository;
import simbirsoft.internship.warehouse.services.ConsumptionService;

import java.util.List;

@Service
public class ConsumptionServiceImpl implements ConsumptionService {
    private ConsumptionRepository consumptionRepository;

    @Autowired
    public ConsumptionServiceImpl(ConsumptionRepository consumptionRepository) {
        this.consumptionRepository = consumptionRepository;
    }

    /**
     * Метод добавления расхода.
     *
     * @param consumption - информация о расходе, который нужно выполнить
     * @return - информацию о выполненном расходе
     */
    @Override
    public Consumption save(Consumption consumption) {
        consumptionRepository.save(consumption);
        return consumption;
    }

    /**
     * Метод поиска всех расходов.
     *
     * @return - список всех расходов
     */
    @Override
    public List<Consumption> findAll() {
        return consumptionRepository.findAll();
    }
}
