package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.Cars;

public interface CarsRepository extends JpaRepository<Cars, Integer> {
}
