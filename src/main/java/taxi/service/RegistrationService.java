package taxi.service;

import taxi.exception.RegistrationException;
import taxi.model.Driver;

public interface RegistrationService {
    void register(Driver driver) throws RegistrationException;
}
