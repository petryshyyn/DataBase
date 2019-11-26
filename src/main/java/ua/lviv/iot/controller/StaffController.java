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
import ua.lviv.iot.model.Staff;
import ua.lviv.iot.service.StaffService;

import java.util.List;

@RestController
@RequestMapping("/petryshyn_lab3")
public class StaffController {
    @Autowired
    StaffService staffService;

    @GetMapping("/staff")
    public List<Staff> findAll() throws Exception {
        return staffService.findAll();
    }

    @GetMapping("/staff/{id}")
    public Staff findById(@PathVariable Integer id) throws Exception {
        return staffService.findById(id);
    }

    @PostMapping("/staff")
    public void create(@RequestBody Staff entity) throws Exception {
        staffService.create(entity);
    }

    @PutMapping("/staff/{id}")
    public void update(@PathVariable Integer id, @RequestBody Staff entity) throws Exception {
        entity.setStaffId(id);
        staffService.update(entity);
    }

    @DeleteMapping("/staff/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        staffService.delete(id);
    }
}
