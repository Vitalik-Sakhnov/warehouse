package simbirsoft.internship.warehouse.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbirsoft.internship.warehouse.entities.Supply;
import simbirsoft.internship.warehouse.repositories.SupplyRepository;
import simbirsoft.internship.warehouse.services.SupplyService;

import java.util.List;

@Service
public class SupplyServiceImpl implements SupplyService {
    private SupplyRepository supplyRepository;

    @Autowired
    public SupplyServiceImpl(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }

    /**
     * Метод добавления прихода товара.
     *
     * @param supply - информация о приходе, которую нужно добавить
     * @return - информацию о выполненном приходе
     */
    @Override
    public Supply save(Supply supply) {
        if (supply.getId() != null) {
            supplyRepository.deleteById(supply.getId());
        }
        supplyRepository.save(supply);
        return supply;
    }

    /**
     * Метод поиска всех приходов.
     *
     * @return - список всех приходов
     */
    @Override
    public List<Supply> findAll() {
        return supplyRepository.findAll();
    }
}
