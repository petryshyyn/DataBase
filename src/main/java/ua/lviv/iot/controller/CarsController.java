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
import ua.lviv.iot.model.Cars;
import ua.lviv.iot.service.CarsService;

import java.util.List;

@RestController
@RequestMapping("/petryshyn_lab3")
public class CarsController {
    @Autowired
    CarsService carsService;

    @GetMapping("/cars")
    public List<Cars> findAll() throws Exception {
        return carsService.findAll();
    }

    @GetMapping("/cars/{id}")
    public Cars findById(@PathVariable Integer id) throws Exception {
        return carsService.findById(id);
    }

    @PostMapping("/cars")
    public void create(@RequestBody Cars entity) throws Exception {
        carsService.create(entity);
    }

    @PutMapping("/cars/{id}")
    public void update(@PathVariable Integer id, @RequestBody Cars entity) throws Exception {
        entity.setCarsId(id);
        carsService.update(entity);
    }

    @DeleteMapping("/cars/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        carsService.delete(id);
    }
}
