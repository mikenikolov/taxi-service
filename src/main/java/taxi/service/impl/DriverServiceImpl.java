package taxi.service.impl;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import taxi.dao.DriverDao;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Driver;
import taxi.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {
    private static final Logger logger = LogManager.getLogger(DriverServiceImpl.class);
    @Inject
    private DriverDao driverDao;

    @Override
    public Driver create(Driver driver) {
        return driverDao.create(driver);
    }

    @Override
    public Driver get(Long id) {
        Optional<Driver> driver = driverDao.get(id);
        if (driver.isPresent()) {
            return driver.get();
        }
        logger.error("There is no driver with such id. Params: [driverId = {}]", id);
        throw new RuntimeException("There is no driver with such id: " + id);
    }

    @Override
    public List<Driver> getAll() {
        return driverDao.getAll();
    }

    @Override
    public Driver update(Driver driver) {
        Driver updatedDriver = driverDao.update(driver);
        logger.info("The driver has been updated. Params: [driverId = {}]", updatedDriver.getId());
        return updatedDriver;
    }

    @Override
    public boolean delete(Long id) {
        boolean isDeleted = driverDao.delete(id);
        if (isDeleted) {
            logger.info("The driver has been deleted. Params: [driverId = {}]", id);
            return true;
        }
        logger.error("There is no driver with such id. Params: [driverId = {}]", id);
        return false;
    }

    @Override
    public Optional<Driver> findByLogin(String login) {
        return driverDao.findByLogin(login);
    }
}
