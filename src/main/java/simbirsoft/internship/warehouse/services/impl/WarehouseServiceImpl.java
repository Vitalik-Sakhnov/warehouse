package simbirsoft.internship.warehouse.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbirsoft.internship.warehouse.dto.WarehouseDto;
import simbirsoft.internship.warehouse.entities.Warehouse;
import simbirsoft.internship.warehouse.repositories.WarehouseRepository;
import simbirsoft.internship.warehouse.services.WarehouseService;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    private WarehouseRepository warehouseRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public WarehouseServiceImpl(WarehouseRepository warehouseRepository, ModelMapper modelMapper) {
        this.warehouseRepository = warehouseRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Метод добавления товара на склад.
     *
     * @param warehouseDto - информация о товаре, который нужно добавить
     * @return - информацию о добавленном товаре на склад
     */
    @Override
    public WarehouseDto save(WarehouseDto warehouseDto) {
        Warehouse warehouse = warehouseRepository.save(modelMapper.map(warehouseDto, Warehouse.class));
        return modelMapper.map(warehouse, WarehouseDto.class);
    }

    /**
     * Метод поиска всех товаров на складе.
     *
     * @return - список всех товаров на складе
     */
    @Override
    public List<WarehouseDto> findAll() {
        return modelMapper.map(
                warehouseRepository.findAll(),
                new TypeToken<List<WarehouseDto>>() {
                }.getType()
        );
    }
}
