package vn.unigap.api.service;

import vn.unigap.api.dto.in.EmployerDtoIn;
import vn.unigap.api.entity.Employer;
import vn.unigap.api.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    public Employer createEmployer(EmployerDtoIn employerDtoIn) {
        Employer employer = new Employer();
        employer.setEmail(employerDtoIn.getEmail());
        employer.setName(employerDtoIn.getName());
        employer.setProvince(employerDtoIn.getProvinceId());
        employer.setDescription(employerDtoIn.getDescription());
        return employerRepository.save(employer);
    }

    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }
}
