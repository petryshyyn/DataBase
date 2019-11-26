package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.ParkingTime;

public interface ParkingTimeRepository extends JpaRepository<ParkingTime, Integer> {
}
