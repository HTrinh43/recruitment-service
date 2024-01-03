package vn.unigap.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.unigap.api.common.ApiResponse;
import vn.unigap.api.dto.in.DateDtoIn;
import vn.unigap.api.dto.in.JobDtoIn;
import vn.unigap.api.dto.in.PageDtoIn;
import vn.unigap.api.dto.out.JobDtoOut;
import vn.unigap.api.dto.out.PageDtoOut;
import vn.unigap.api.service.JobService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController extends AbstractResponseController {
    private final JobService jobService;
    @Autowired
    public JobController(JobService jobService){
        this.jobService = jobService;
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid JobDtoIn jobDtoIn) {
        JobDtoOut job = jobService.create(jobDtoIn);
        ApiResponse<List<Object>> response = new ApiResponse<>();
        response.setErrorCode(0);
        response.setData(new ArrayList<>());
        response.setStatusCode(201);
        response.setMessage("Job created successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllJob(){
        List<JobDtoOut> jobList = jobService.getAllJob();
        ApiResponse<List<JobDtoOut>> response = new ApiResponse<>();
        response.setErrorCode(0);
        response.setStatusCode(201);
        response.setData(jobList);
        response.setMessage("Get all jobs successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/pages")
    public ResponseEntity<?> list(@RequestBody @Valid PageDtoIn pageDtoIn){
        PageDtoOut<JobDtoOut> jobList = jobService.list(pageDtoIn);
        ApiResponse<PageDtoOut<JobDtoOut>> response = new ApiResponse<>();
        response.setErrorCode(0);
        response.setStatusCode(201);
        response.setData(jobList);
        response.setMessage("Get all jobs successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/analysis")
    public ResponseEntity<?> countJobsBetweenDate(@Valid DateDtoIn dateDtoIn){
        return responseEntity(
                ()-> {return jobService.countJobsBetweenDate(dateDtoIn);},
                201, false
        );
    }
}
