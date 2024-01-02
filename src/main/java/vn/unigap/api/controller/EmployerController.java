package vn.unigap.api.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.unigap.api.common.ApiPagingResponse;
import vn.unigap.api.common.ApiResponse;
import vn.unigap.api.dto.in.CreateEmployerDtoIn;
import vn.unigap.api.dto.in.PagingEmployerDtoIn;
import vn.unigap.api.dto.in.UpdateEmployerDtoIn;
import vn.unigap.api.dto.out.EmployerDtoOut;
import vn.unigap.api.dto.out.EmployerPagingDtoOut;
import vn.unigap.api.entity.Employer;
import vn.unigap.api.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employers")
public class EmployerController {

    @Autowired
    private EmployerService employerService;




    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateEmployerDtoIn employerDtoIn){
        Employer employer = this.employerService.createEmployer(employerDtoIn);
        ApiResponse<List<Object>> response = new ApiResponse<>();
        response.setErrorCode(0);
        response.setStatusCode(201);
        response.setMessage("Employer created successfully");
        response.setData(new ArrayList<>());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value="id") Long id, @RequestBody @Valid UpdateEmployerDtoIn updateEmployerDtoIn){
        Employer employer = this.employerService.updateEmployer(updateEmployerDtoIn);
        ApiResponse<List<Object>> response = new ApiResponse<>();
        response.setErrorCode(0);
        response.setErrorCode(201);
        response.setMessage("Employer updated successfully");
        response.setData(new ArrayList<>());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable(value="id") Integer id){
        EmployerDtoOut employerDtoOut = this.employerService.getEmployer(id);
        ApiResponse<EmployerDtoOut> response = new ApiResponse<>();
        response.setErrorCode(0);
        response.setErrorCode(200);
        response.setMessage("Retrieved employer successfully");
        response.setData(employerDtoOut);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<?> getEmployers(@RequestBody @Valid PagingEmployerDtoIn dtoIn){
        Pageable pageable = PageRequest.of(dtoIn.getPage(), dtoIn.getPageSize());
        Page<EmployerPagingDtoOut> page = employerService.findPaginated(pageable);
        ApiPagingResponse<EmployerPagingDtoOut> response = new ApiPagingResponse<>(page);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployers() {
        List<Employer> employers = employerService.getAllEmployers();
        ApiResponse<List<Employer>> response = new ApiResponse<>();
        response.setErrorCode(0);
        response.setStatusCode(200);
        response.setMessage("Successfully retrieved all employer");
        response.setData(employers);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployer(@PathVariable Integer id) {
        employerService.deleteEmployer(id);
        ApiResponse<List<Employer>> response = new ApiResponse<>();
        response.setErrorCode(0);
        response.setStatusCode(200);
        response.setMessage("Successfully delete employer");
        response.setData(new ArrayList<>());
        return ResponseEntity.ok(response);
    }

}
