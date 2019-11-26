package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Cars;
import ua.lviv.iot.repository.CarsRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class CarsService {
    @Autowired
    private CarsRepository carsRepository;

    public List<Cars> findAll() throws Exception {
        List<Cars> cars = new LinkedList<>(carsRepository.findAll());
        if (cars.isEmpty()) {
            return null;
        }
        return cars;
    }

    public Cars findById(Integer id) throws Exception {
        if (carsRepository.findById(id).isPresent()) {
            return carsRepository.findById(id).get();
        }
        return null;
    }
    @Transactional
    public void create(Cars cars) throws Exception {
        if (cars != null) {
            carsRepository.save(cars);
        }
    }
    @Transactional
    public void update(Cars cars) throws Exception {
        carsRepository.findById(cars.getCarsId())
                .map(oldEntity -> {
                    oldEntity.setOuner(cars.getOuner());
                    oldEntity.setYearOfConstruction(cars.getYearOfConstruction());
                    oldEntity.setColor(cars.getColor());
                    return carsRepository.save(oldEntity);
                })
                .orElseGet(() -> carsRepository.save(cars));
    }
    @Transactional
    public void delete(Integer id) throws Exception {
        if (carsRepository.findById(id).isPresent()) {
            carsRepository.deleteById(id);
        }
    }
}
