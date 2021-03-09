package simbirsoft.internship.warehouse.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbirsoft.internship.warehouse.dto.WriteOffDto;
import simbirsoft.internship.warehouse.entities.WriteOff;
import simbirsoft.internship.warehouse.repositories.WriteOffRepository;
import simbirsoft.internship.warehouse.services.WriteOffService;

import java.util.List;

@Service
public class WriteOffServiceImpl implements WriteOffService {
    private WriteOffRepository writeOffRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public WriteOffServiceImpl(WriteOffRepository writeOffRepository, ModelMapper modelMapper) {
        this.writeOffRepository = writeOffRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Метод добавления списания.
     *
     * @param writeOffDto - информация о списании, которое нужно выполнить
     * @return - информацию о выполненном списании
     */
    @Override
    public WriteOffDto save(WriteOffDto writeOffDto) {
        WriteOff writeOff = writeOffRepository.save(modelMapper.map(writeOffDto, WriteOff.class));
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
