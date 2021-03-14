package simbirsoft.internship.warehouse.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbirsoft.internship.warehouse.dto.SupplyDto;
import simbirsoft.internship.warehouse.entities.Supply;
import simbirsoft.internship.warehouse.repositories.SupplyRepository;
import simbirsoft.internship.warehouse.services.SupplyService;

import java.util.List;

@Service
public class SupplyServiceImpl implements SupplyService {
    private SupplyRepository supplyRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public SupplyServiceImpl(SupplyRepository supplyRepository, ModelMapper modelMapper) {
        this.supplyRepository = supplyRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Метод добавления прихода товара.
     *
     * @param supplyDto - информация о приходе, которую нужно добавить
     * @return - информацию о выполненном приходе
     */
    @Override
    public SupplyDto save(SupplyDto supplyDto) {
        Supply supply = supplyRepository.save(modelMapper.map(supplyDto, Supply.class));
        return modelMapper.map(supply, SupplyDto.class);
    }

    /**
     * Метод поиска всех приходов.
     *
     * @return - список всех приходов
     */
    @Override
    public List<SupplyDto> findAll() {
        return modelMapper.map(
                supplyRepository.findAll(),
                new TypeToken<List<SupplyDto>>() {
                }.getType()
        );
    }
}
