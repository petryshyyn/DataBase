package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.Parking;

public interface ParkingRepository extends JpaRepository<Parking, Integer> {
}
