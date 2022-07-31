package taxi.service.impl;

import taxi.exception.RegistrationException;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Driver;
import taxi.service.DriverService;
import taxi.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Inject
    private DriverService driverService;

    @Override
    public void register(Driver driver) throws RegistrationException {
        if (driverService.findByLogin(driver.getLogin()).isPresent()) {
            throw new RegistrationException("This login already taken");
        }
        driverService.create(driver);
    }
}
