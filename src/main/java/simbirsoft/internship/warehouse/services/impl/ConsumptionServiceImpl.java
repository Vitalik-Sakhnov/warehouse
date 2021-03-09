package simbirsoft.internship.warehouse.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbirsoft.internship.warehouse.dto.ConsumptionDto;
import simbirsoft.internship.warehouse.entities.Consumption;
import simbirsoft.internship.warehouse.repositories.ConsumptionRepository;
import simbirsoft.internship.warehouse.services.ConsumptionService;

import java.util.List;

@Service
public class ConsumptionServiceImpl implements ConsumptionService {
    private ConsumptionRepository consumptionRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public ConsumptionServiceImpl(ConsumptionRepository consumptionRepository, ModelMapper modelMapper) {
        this.consumptionRepository = consumptionRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Метод добавления расхода.
     *
     * @param consumptionDto - информация о расходе, который нужно выполнить
     * @return - информацию о выполненном расходе
     */
    @Override
    public ConsumptionDto save(ConsumptionDto consumptionDto) {
        Consumption consumption = consumptionRepository.save(modelMapper.map(consumptionDto, Consumption.class));
        return modelMapper.map(consumption, ConsumptionDto.class);
    }

    /**
     * Метод поиска всех расходов.
     *
     * @return - список всех расходов
     */
    @Override
    public List<ConsumptionDto> findAll() {
        return modelMapper.map(
                consumptionRepository.findAll(),
                new TypeToken<List<ConsumptionDto>>() {
                }.getType()
        );
    }
}
