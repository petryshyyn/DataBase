package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Company;
import ua.lviv.iot.repository.CompanyRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public List<Company> findAll() throws Exception {
        List<Company> company = new LinkedList<>(companyRepository.findAll());
        if (company.isEmpty()) {
            return null;
        }
        return company;
    }

    public Company findById(Integer id) throws Exception {
        if (companyRepository.findById(id).isPresent()) {
            return companyRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Company company) throws Exception {
        if (company != null) {
            companyRepository.save(company);
        }
    }

    @Transactional
    public void update(Company company) throws Exception {
        companyRepository.findById(company.getCompanyId())
                .map(oldEntity -> {
                    oldEntity.setName(company.getName());
                    oldEntity.setYearOfFoundation(company.getYearOfFoundation());
                    oldEntity.setNumberOfCars(company.getNumberOfCars());
                    return companyRepository.save(oldEntity);
                })
                .orElseGet(() -> companyRepository.save(company));
    }
    @Transactional
    public void delete(Integer id) throws Exception {
        if (companyRepository.findById(id).isPresent()) {
            companyRepository.deleteById(id);
        }
    }
}
