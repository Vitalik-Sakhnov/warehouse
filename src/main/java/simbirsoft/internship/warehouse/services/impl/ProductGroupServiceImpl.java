package simbirsoft.internship.warehouse.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbirsoft.internship.warehouse.dto.ProductGroupDto;
import simbirsoft.internship.warehouse.entities.ProductGroup;
import simbirsoft.internship.warehouse.repositories.ProductGroupRepository;
import simbirsoft.internship.warehouse.services.ProductGroupService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductGroupServiceImpl implements ProductGroupService {
    private static final Logger logger = LoggerFactory.getLogger(ProductGroupServiceImpl.class);
    private ProductGroupRepository groupRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public ProductGroupServiceImpl(ProductGroupRepository groupRepository, ModelMapper modelMapper) {
        this.groupRepository = groupRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Метод добавления товарной группы.
     *
     * @param productGroupDto - товарная группа, которую нужно добавить
     * @return - добавленную товарную группу
     */
    @Override
    public ProductGroupDto save(ProductGroupDto productGroupDto) {
        ProductGroup group = groupRepository.save(modelMapper.map(productGroupDto, ProductGroup.class));
        return modelMapper.map(group, ProductGroupDto.class);
    }

    /**
     * Метод поиска всех товарных групп.
     *
     * @return - список всех товарных групп
     */
    @Override
    public List<ProductGroupDto> findAll() {
        return modelMapper.map(
                groupRepository.findAll(),
                new TypeToken<List<ProductGroupDto>>() {
                }.getType()
        );
    }

    /**
     * Метод поиска товарной группы по её id.
     *
     * @param productGroupId - id товарной группы, которую нужно найти
     * @return - товарную группу, у которой id равно передаваемому
     */
    @Override
    public ProductGroupDto findById(Long productGroupId) {
        ProductGroup productGroup = null;
        try {
            productGroup = groupRepository.findById(productGroupId).orElseThrow(
                    () -> new EntityNotFoundException("Entity not found")
            );
        } catch (EntityNotFoundException ex) {
            logger.error("EntityNotFoundException", ex);
            ex.printStackTrace();
        }
        return modelMapper.map(productGroup, ProductGroupDto.class);
    }

    /**
     * Метод поиска товарной группы по её наименованию.
     *
     * @param productGroupName - наименование товарной группы, которую нужно найти
     * @return - товарную группу, у которой наименование равно передаваемому
     */
    @Override
    public ProductGroupDto findByName(String productGroupName) {
        return modelMapper.map(groupRepository.findByName(productGroupName), ProductGroupDto.class);
    }

    /**
     * Метод удаления товарной группы по её id.
     *
     * @param productGroupId - id товарной группы, которую нужно удалить
     * @return - true, если удаление прошло успешно, false в противном случае
     */
    @Override
    public boolean deleteById(Long productGroupId) {
        if (groupRepository.existsById(productGroupId)) {
            if (groupRepository.getOne(productGroupId).getProducts().isEmpty()) {
                groupRepository.deleteById(productGroupId);
                return true;
            }
        }
        return false;
    }

    /**
     * Метод обновления товарной группы.
     *
     * @param productGroupDto - новая товарная группа
     * @return - обновлённая товарная группа
     */
    @Override
    public ProductGroupDto update(ProductGroupDto productGroupDto) {
        return save(productGroupDto);
    }
}
