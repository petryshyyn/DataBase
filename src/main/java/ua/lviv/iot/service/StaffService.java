package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Staff;
import ua.lviv.iot.repository.StaffRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class StaffService {

    @Autowired
    StaffRepository staffRepository;

    public List<Staff> findAll() throws Exception {
        List<Staff> staff = new LinkedList<>(staffRepository.findAll());
        if (staff.isEmpty()) {
            return null;
        }
        return staff;
    }

    public Staff findById(Integer id) throws Exception {
        if (staffRepository.findById(id).isPresent()) {
            return staffRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Staff staff) throws Exception {
        if (staff != null) {
            staffRepository.save(staff);
        }
    }

    @Transactional
    public void update(Staff staff) throws Exception {
        staffRepository.findById(staff.getStaffId())
                .map(oldEntity -> {
                    oldEntity.setGuards(staff.getGuards());
                    oldEntity.setCleaners(staff.getCleaners());
                    return staffRepository.save(oldEntity);
                })
                .orElseGet(() -> staffRepository.save(staff));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (staffRepository.findById(id).isPresent()) {
            staffRepository.deleteById(id);
        }
    }
}
