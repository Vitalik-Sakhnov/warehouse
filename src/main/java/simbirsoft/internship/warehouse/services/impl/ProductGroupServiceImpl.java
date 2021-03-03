package simbirsoft.internship.warehouse.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbirsoft.internship.warehouse.entities.ProductGroup;
import simbirsoft.internship.warehouse.repositories.ProductGroupRepository;
import simbirsoft.internship.warehouse.services.ProductGroupService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductGroupServiceImpl implements ProductGroupService {
    private ProductGroupRepository groupRepository;

    @Autowired
    public ProductGroupServiceImpl(ProductGroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    /**
     * Метод добавления товарной группы.
     *
     * @param productGroup - товарная группа, которую нужно добавить
     * @return - добавленную товарную группу
     */
    @Override
    public ProductGroup save(ProductGroup productGroup) {
        groupRepository.save(productGroup);
        return productGroup;
    }

    /**
     * Метод поиска всех товарных групп.
     *
     * @return - список всех товарных групп
     */
    @Override
    public List<ProductGroup> findAll() {
        return groupRepository.findAll();
    }

    /**
     * Метод поиска товарной группы по её id.
     *
     * @param productGroupId - id товарной группы, которую нужно найти
     * @return - товарную группу, у которой id равно передаваемому
     */
    @Override
    public ProductGroup findById(Long productGroupId) {
        return groupRepository.findById(productGroupId).orElseThrow(()
                -> new EntityNotFoundException("Entity not found"));
    }

    /**
     * Метод поиска товарной группы по её наименованию.
     *
     * @param productGroupName - наименование товарной группы, которую нужно найти
     * @return - товарную группу, у которой наименование равно передаваемому
     */
    @Override
    public ProductGroup findByName(String productGroupName) {
        return groupRepository.findByName(productGroupName);
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
            if (findById(productGroupId).getProducts().isEmpty()) {
                groupRepository.deleteById(productGroupId);
                return true;
            }
        }
        return false;
    }

    /**
     * Метод обновления товарной группы.
     *
     * @param productGroup - новая товарная группа
     * @return - обновлённая товарная группа
     */
    @Override
    public ProductGroup update(ProductGroup productGroup) {
        if (productGroup.getId() != null) {
            groupRepository.save(productGroup);
        }
        return productGroup;
    }
}
