package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.model.Parking;
import ua.lviv.iot.model.ParkingTime;
import ua.lviv.iot.service.ParkingService;
import ua.lviv.iot.service.ParkingTimeService;

import java.util.List;

@RestController
@RequestMapping("/petryshyn_lab3")
public class ParkingTimeController {
    @Autowired
    ParkingTimeService parkingTimeService;

    @GetMapping("/parking_time")
    public List<ParkingTime> findAll() throws Exception {
        return parkingTimeService.findAll();
    }

    @GetMapping("/parking_time/{id}")
    public ParkingTime findById(@PathVariable Integer id) throws Exception {
        return parkingTimeService.findById(id);
    }

    @PostMapping("/parking_time")
    public void create(@RequestBody ParkingTime entity) throws Exception {
        parkingTimeService.create(entity);
    }

    @PutMapping("/parking_time/{id}")
    public void update(@PathVariable Integer id, @RequestBody ParkingTime entity) throws Exception {
        entity.setParkingTimeId(id);
        parkingTimeService.update(entity);
    }

    @DeleteMapping("/parking_time/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        parkingTimeService.delete(id);
    }
}
