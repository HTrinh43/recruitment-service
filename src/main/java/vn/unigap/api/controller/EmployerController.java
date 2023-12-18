package vn.unigap.api.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import vn.unigap.api.dto.in.EmployerDtoIn;
import vn.unigap.api.entity.Employer;
import vn.unigap.api.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/employers")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @GetMapping
    public List<Employer> getAllEmployers() {
        return employerService.getAllEmployers();
    }

    @PostMapping
    public Employer create(@RequestBody @Valid EmployerDtoIn employerDtoIn){
        return this.employerService.createEmployer(employerDtoIn);
    }

    // Other endpoints
}
