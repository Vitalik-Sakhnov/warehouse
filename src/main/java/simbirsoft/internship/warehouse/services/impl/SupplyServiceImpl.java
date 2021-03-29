package simbirsoft.internship.warehouse.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbirsoft.internship.warehouse.dto.ProductDto;
import simbirsoft.internship.warehouse.dto.SupplyDto;
import simbirsoft.internship.warehouse.dto.WarehouseDto;
import simbirsoft.internship.warehouse.entities.Supply;
import simbirsoft.internship.warehouse.repositories.SupplyRepository;
import simbirsoft.internship.warehouse.services.SupplyService;
import simbirsoft.internship.warehouse.services.WarehouseService;

import java.util.List;

@Service
public class SupplyServiceImpl implements SupplyService {
    private SupplyRepository supplyRepository;
    private WarehouseService warehouseService;

    private final ModelMapper modelMapper;

    @Autowired
    public SupplyServiceImpl(SupplyRepository supplyRepository, WarehouseService warehouseService,
                             ModelMapper modelMapper) {
        this.supplyRepository = supplyRepository;
        this.warehouseService = warehouseService;
        this.modelMapper = modelMapper;
    }

    /**
     * Метод добавления прихода товара.
     * Если приход товара подтвержден, т.е. isApproved = true, тогда сохраняем запись прихода,
     * обновляем запись на складе с количеством товара. Если isApproved = false, т.е. приход не подтвержден,
     * просто сохраняем запись на приход, без обновления количества товара на складе.
     *
     * @param supplyDto - информация о приходе, которую нужно добавить
     * @return - информацию о выполненном приходе
     */
    @Override
    public SupplyDto save(SupplyDto supplyDto) {
        Supply supply;
        WarehouseDto warehouseDto;
        if (supplyDto.isApproved()) {
            supply = supplyRepository.save(modelMapper.map(supplyDto, Supply.class));
            ProductDto productDto = modelMapper.map(supplyDto.getProduct(), ProductDto.class);
            warehouseDto = warehouseService.getByProduct(productDto);
            warehouseDto.setGoodsQuantity(warehouseDto.getGoodsQuantity() + supplyDto.getGoodsQuantity());
            warehouseService.update(warehouseDto);
        } else {
            supply = supplyRepository.save(modelMapper.map(supplyDto, Supply.class));
        }
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
