package taxi.service.impl;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import taxi.dao.CarDao;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Car;
import taxi.model.Driver;
import taxi.service.CarService;

@Service
public class CarServiceImpl implements CarService {
    private static final Logger logger = LogManager.getLogger(CarServiceImpl.class);
    @Inject
    private CarDao carDao;

    @Override
    public void addDriverToCar(Driver driver, Car car) {
        car.getDrivers().add(driver);
        carDao.update(car);
        logger.info("The driver has been added to the car. Params: [driverId = {}, carId = {}]",
                driver.getId(), car.getId());
    }

    @Override
    public void removeDriverFromCar(Driver driver, Car car) {
        car.getDrivers().remove(driver);
        carDao.update(car);
        logger.info("The driver has been removed from the car. "
                        + "Params: [driverId = {}, carId = {}]",
                driver.getId(), car.getId());
    }

    @Override
    public List<Car> getAllByDriver(Long driverId) {
        return carDao.getAllByDriver(driverId);
    }

    @Override
    public Car create(Car car) {
        Car createdCar = carDao.create(car);
        logger.info("The car has been created. Params: [carId = {}, carModel = {}, "
                + "manufacturerId = {}]", createdCar.getId(), createdCar.getModel(),
                createdCar.getManufacturer().getId());
        return createdCar;
    }

    @Override
    public Car get(Long id) {
        Optional<Car> car = carDao.get(id);
        if (car.isPresent()) {
            return car.get();
        }
        logger.error("There is no car with such id. Params: [carId = {}]", id);
        throw new RuntimeException("There is no car with such id: " + id);
    }

    @Override
    public List<Car> getAll() {
        return carDao.getAll();
    }

    @Override
    public Car update(Car car) {
        Car updatedCar = carDao.update(car);
        logger.info("The car has been updated. Params: [carId = {}]", updatedCar.getId());
        return car;
    }

    @Override
    public boolean delete(Long id) {
        boolean isDeleted = carDao.delete(id);
        if (isDeleted) {
            logger.info("The car has been deleted. Params: [carId = {}]", id);
            return true;
        }
        logger.error("There is no car with such id. Params: [carId = {}]", id);
        return false;
    }
}
