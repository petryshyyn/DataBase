package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Parking;
import ua.lviv.iot.repository.ParkingRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class ParkingService {
    @Autowired
    ParkingRepository parkingRepository;

    public List<Parking> findAll() throws Exception {
        List<Parking> parking = new LinkedList<>(parkingRepository.findAll());
        if (parking.isEmpty()) {
            return null;
        }
        return parking;
    }

    public Parking findById(Integer id) throws Exception {
        if (parkingRepository.findById(id).isPresent()) {
            return parkingRepository.findById(id).get();
        }
        return null;
    }
    @Transactional
    public void create(Parking parking) throws Exception {
        if (parking != null) {
            parkingRepository.save(parking);
        }
    }

    @Transactional
    public void update(Parking parking) throws Exception {
        parkingRepository.findById(parking.getParkingId())
                .map(oldEntity -> {
                    oldEntity.setAdress(parking.getAdress());
                    oldEntity.setPriceForOneHour(parking.getPriceForOneHour());
                    oldEntity.setTradingNetwork(parking.getTradingNetwork());
                    oldEntity.setPlacesForDisabledPeople(parking.getPlacesForDisabledPeople());
                    return parkingRepository.save(oldEntity);
                })
                .orElseGet(() -> parkingRepository.save(parking));
    }
    @Transactional
    public void delete(Integer id) throws Exception {
        if (parkingRepository.findById(id).isPresent()) {
            parkingRepository.deleteById(id);
        }
    }
}
