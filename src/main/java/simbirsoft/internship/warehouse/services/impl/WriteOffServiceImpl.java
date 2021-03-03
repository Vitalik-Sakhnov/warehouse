package simbirsoft.internship.warehouse.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbirsoft.internship.warehouse.entities.WriteOff;
import simbirsoft.internship.warehouse.repositories.WriteOffRepository;
import simbirsoft.internship.warehouse.services.WriteOffService;

import java.util.List;

@Service
public class WriteOffServiceImpl implements WriteOffService {
    private WriteOffRepository writeOffRepository;

    @Autowired
    public WriteOffServiceImpl(WriteOffRepository writeOffRepository) {
        this.writeOffRepository = writeOffRepository;
    }

    /**
     * Метод добавления списания.
     *
     * @param writeOff - информация о списании, которое нужно выполнить
     * @return - информацию о выполненном списании
     */
    @Override
    public WriteOff save(WriteOff writeOff) {
        if (writeOff.getId() != null) {
            writeOffRepository.deleteById(writeOff.getId());
        }
        writeOffRepository.save(writeOff);
        return writeOff;
    }

    /**
     * Метод поиска всех списаний.
     *
     * @return - список всех списаний
     */
    @Override
    public List<WriteOff> findAll() {
        return writeOffRepository.findAll();
    }
}
