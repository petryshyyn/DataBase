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
import ua.lviv.iot.model.Reserved;
import ua.lviv.iot.service.ReservedService;

import java.util.List;

@RestController
@RequestMapping("/petryshyn_lab3")
public class ReservedController {
    @Autowired
    ReservedService reservedService;

    @GetMapping("/reserved")
    public List<Reserved> findAll() throws Exception {
        return reservedService.findAll();
    }

    @GetMapping("/reserved/{id}")
    public Reserved findById(@PathVariable Integer id) throws Exception {
        return reservedService.findById(id);
    }

    @PostMapping("/reserved")
    public void create(@RequestBody Reserved entity) throws Exception {
        reservedService.create(entity);
    }

    @PutMapping("/reserved/{id}")
    public void update(@PathVariable Integer id, @RequestBody Reserved entity) throws Exception {
        entity.setReservedId(id);
        reservedService.update(entity);
    }

    @DeleteMapping("/reserved/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        reservedService.delete(id);
    }
}
