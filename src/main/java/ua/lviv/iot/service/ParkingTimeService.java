package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.ParkingTime;
import ua.lviv.iot.repository.ParkingTimeRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class ParkingTimeService {
    @Autowired
    ParkingTimeRepository parkingTimeRepository;

    public List<ParkingTime> findAll() throws Exception {
        List<ParkingTime> parkingTime = new LinkedList<>(parkingTimeRepository.findAll());
        if (parkingTime.isEmpty()) {
            return null;
        }
        return parkingTime;
    }

    public ParkingTime findById(Integer id) throws Exception {
        if (parkingTimeRepository.findById(id).isPresent()) {
            return parkingTimeRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(ParkingTime parkingTime) throws Exception {
        if (parkingTime != null) {
            parkingTimeRepository.save(parkingTime);
        }
    }

    @Transactional
    public void update(ParkingTime parkingTime) throws Exception {
        parkingTimeRepository.findById(parkingTime.getParkingTimeId())
                .map(oldEntity -> {
                    oldEntity.setTimeOfArrival(parkingTime.getTimeOfArrival());
                    oldEntity.setCheckOutTime(parkingTime.getCheckOutTime());
                    oldEntity.setCarNumber(parkingTime.getCarNumber());
                    return parkingTimeRepository.save(oldEntity);
                })
                .orElseGet(() -> parkingTimeRepository.save(parkingTime));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (parkingTimeRepository.findById(id).isPresent()) {
            parkingTimeRepository.deleteById(id);
        }
    }
}
