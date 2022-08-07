package taxi.service.impl;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import taxi.dao.ManufacturerDao;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Manufacturer;
import taxi.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private static final Logger logger = LogManager.getLogger(ManufacturerServiceImpl.class);
    @Inject
    private ManufacturerDao manufacturerDao;

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        Manufacturer createdManufacturer = manufacturerDao.create(manufacturer);
        logger.info("The manufacturer has been created. Params: [manufacturerId = {}, "
                        + "manufacturerName = {}, manufacturerCountry = {}]",
                createdManufacturer.getId(), createdManufacturer.getName(),
                createdManufacturer.getCountry());
        return createdManufacturer;
    }

    @Override
    public Manufacturer get(Long id) {
        Optional<Manufacturer> manufacturer = manufacturerDao.get(id);
        if (manufacturer.isPresent()) {
            return manufacturer.get();
        }
        logger.error("There is no manufacturer with such id. "
                + "Params: [manufacturerId = {}]", id);
        throw new RuntimeException("There is no manufacturer with such id: " + id);
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerDao.getAll();
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        Manufacturer updatedManufacturer = manufacturerDao.update(manufacturer);
        logger.info("The manufacturer has been updated. Params: [manufacturerId = {}]",
                updatedManufacturer.getId());
        return updatedManufacturer;
    }

    @Override
    public boolean delete(Long id) {
        boolean isDeleted = manufacturerDao.delete(id);
        if (isDeleted) {
            logger.info("The manufacturer has been deleted. Params: [manufacturerId = {}]", id);
            return true;
        }
        logger.error("There is no manufacturer with such id. "
                + "Params: [manufacturerId = {}]", id);
        return false;
    }
}
