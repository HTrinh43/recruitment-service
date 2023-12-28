package vn.unigap.api.service;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.unigap.api.dto.in.CreateEmployerDtoIn;
import vn.unigap.api.dto.in.UpdateEmployerDtoIn;
import vn.unigap.api.dto.out.EmployerDtoOut;
import vn.unigap.api.dto.out.EmployerPagingDtoOut;
import vn.unigap.api.entity.Employer;
import vn.unigap.api.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    public Employer createEmployer(CreateEmployerDtoIn employerDtoIn) {
        Employer employer = new Employer();
        employer.setEmail(employerDtoIn.getEmail());
        employer.setName(employerDtoIn.getName());
        employer.setProvince(employerDtoIn.getProvinceId());
        employer.setDescription(employerDtoIn.getDescription());
        return employerRepository.save(employer);
    }

    public Employer updateEmployer(UpdateEmployerDtoIn employerDtoIn){
        Employer employer = employerRepository.findById(employerDtoIn.getId())
                .orElseThrow(() -> new EntityNotFoundException("Employer not found with id: " + employerDtoIn.getId()));
        if (employerDtoIn.getName() != null){
            employer.setName(employerDtoIn.getName());
        }
        if (employerDtoIn.getDescription() != null){
            employer.setDescription(employerDtoIn.getDescription());
        }
        if (employerDtoIn.getProvinceId() != null){
            employer.setProvince(employerDtoIn.getProvinceId());
        }
        return employerRepository.save(employer);
    }

    public EmployerDtoOut getEmployer(Integer id){
        Employer employer = employerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employer not found with id: " + id));
        EmployerDtoOut responseDto = new EmployerDtoOut();
        responseDto.setId(employer.getId());
        responseDto.setName(employer.getName());
        responseDto.setDescription(employer.getDescription());
        responseDto.setProvinceId(employer.getProvince());
        responseDto.setEmail(employer.getEmail());
        responseDto.setProvinceName("");
        return responseDto;
    }

    public Page<EmployerPagingDtoOut> findPaginated(Pageable pageable){
        Page<Employer> employers = employerRepository.findAll(pageable);
        return employers.map(this::convertToEmployerPagingDtoOut);
    }

    private EmployerPagingDtoOut convertToEmployerPagingDtoOut(Employer employer){
        EmployerPagingDtoOut dto = new EmployerPagingDtoOut();
        dto.setProvinceName("");
        dto.setEmail(employer.getEmail());
        dto.setId(employer.getId());
        dto.setName(employer.getName());
        dto.setProvinceId(employer.getProvince());
        return dto;
    }

    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }

    public void deleteEmployer (Integer id){
        Employer employer = employerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employer not found with id: " + id));
        employerRepository.deleteById(id);
    }
}
