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
import ua.lviv.iot.service.ParkingService;

import java.util.List;

@RestController
@RequestMapping("/petryshyn_lab3")
public class ParkingController {
    @Autowired
    ParkingService parkingService;

    @GetMapping("/parking")
    public List<Parking> findAll() throws Exception {
        return parkingService.findAll();
    }

    @GetMapping("/parking/{id}")
    public Parking findById(@PathVariable Integer id) throws Exception {
        return parkingService.findById(id);
    }

    @PostMapping("/parking")
        public void create(@RequestBody Parking entity) throws Exception {
        parkingService.create(entity);
    }

    @PutMapping("/parking/{id}")
    public void update(@PathVariable Integer id, @RequestBody Parking entity) throws Exception {
        entity.setParkingId(id);
        parkingService.update(entity);
    }

    @DeleteMapping("/parking/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        parkingService.delete(id);
    }
}
