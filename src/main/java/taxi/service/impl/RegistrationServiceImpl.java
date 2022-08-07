package taxi.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import taxi.exception.RegistrationException;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Driver;
import taxi.service.DriverService;
import taxi.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    private static final Logger logger = LogManager.getLogger(RegistrationServiceImpl.class);
    @Inject
    private DriverService driverService;

    @Override
    public void register(Driver driver) throws RegistrationException {
        if (driverService.findByLogin(driver.getLogin()).isPresent()) {
            logger.error("Can't register a driver. Login already taken. "
                    + "Params: [login = {}]", driver.getLogin());
            throw new RegistrationException("This login already taken");
        }
        Driver registeredDriver = driverService.create(driver);
        logger.info("The driver has been registered. Params: [driverId = {}, login = {}]",
                registeredDriver.getId(), registeredDriver.getLogin());
    }
}
