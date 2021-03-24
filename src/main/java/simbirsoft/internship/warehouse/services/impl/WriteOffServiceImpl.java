package simbirsoft.internship.warehouse.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbirsoft.internship.warehouse.dto.ProductDto;
import simbirsoft.internship.warehouse.dto.WarehouseDto;
import simbirsoft.internship.warehouse.dto.WriteOffDto;
import simbirsoft.internship.warehouse.entities.WriteOff;
import simbirsoft.internship.warehouse.repositories.WriteOffRepository;
import simbirsoft.internship.warehouse.services.WarehouseService;
import simbirsoft.internship.warehouse.services.WriteOffService;

import java.util.List;

@Service
public class WriteOffServiceImpl implements WriteOffService {
    private WriteOffRepository writeOffRepository;
    private final ModelMapper modelMapper;
    private WarehouseService warehouseService;

    @Autowired
    public WriteOffServiceImpl(WriteOffRepository writeOffRepository, ModelMapper modelMapper,
                               WarehouseService warehouseService) {
        this.writeOffRepository = writeOffRepository;
        this.modelMapper = modelMapper;
        this.warehouseService = warehouseService;
    }

    /**
     * Метод добавления списания.
     * Если количество товара на списание <= количеству товара на складе, то проверяем на подтверждение списания.
     * Если списание подтверждено, т.е. isApproved = true, тогда сохраняем запись списания, обновляем запись на складе
     * с количеством товара. Если isApproved = false, т.е. списание не подтверждено, просто сохраняем запись на
     * списание, без обновления количества товара на складе.
     *
     * @param writeOffDto - информация о списании, которое нужно выполнить
     * @return - null, если количество товара на списание > колчества товара на складе,
     * иначе - информацию о выполненном списании
     */
    @Override
    public WriteOffDto save(WriteOffDto writeOffDto) {
        WriteOff writeOff;
        ProductDto productDto = modelMapper.map(writeOffDto.getProduct(), ProductDto.class);
        WarehouseDto warehouseDto;
        if (writeOffDto.getGoodsQuantity() <= warehouseService.getByProduct(productDto).getGoodsQuantity()) {
            if (writeOffDto.isApproved()) {
                writeOff = writeOffRepository.save(modelMapper.map(writeOffDto, WriteOff.class));
                warehouseDto = warehouseService.getByProduct(productDto);
                warehouseDto.setGoodsQuantity(warehouseDto.getGoodsQuantity() - writeOffDto.getGoodsQuantity());
                warehouseService.update(warehouseDto);
            } else {
                writeOff = writeOffRepository.save(modelMapper.map(writeOffDto, WriteOff.class));
            }
        } else {
            return null;
        }
        return modelMapper.map(writeOff, WriteOffDto.class);
    }

    /**
     * Метод поиска всех списаний.
     *
     * @return - список всех списаний
     */
    @Override
    public List<WriteOffDto> findAll() {
        return modelMapper.map(
                writeOffRepository.findAll(),
                new TypeToken<List<WriteOffDto>>() {
                }.getType()
        );
    }
}
