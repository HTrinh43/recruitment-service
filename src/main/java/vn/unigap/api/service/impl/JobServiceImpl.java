package vn.unigap.api.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.unigap.api.dto.in.JobDtoIn;
import vn.unigap.api.dto.in.PageDtoIn;
import vn.unigap.api.dto.in.UpdateJobDtoIn;
import vn.unigap.api.dto.out.JobDtoOut;
import vn.unigap.api.dto.out.PageDtoOut;
import vn.unigap.api.entity.Job;
import vn.unigap.api.repository.JobRepository;
import vn.unigap.api.service.JobService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;
    @Autowired
    public JobServiceImpl(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }
    @Override
    public JobDtoOut get(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Do not find the id:" + id)
        );

        return JobDtoOut.from(job);
    }

    @Override
    public JobDtoOut create(JobDtoIn jobDtoIn) {
        Job job = jobRepository.save(Job.builder()
                .employer_id(jobDtoIn.getEmployerId())
                .title(jobDtoIn.getTitle())
                .quantity(jobDtoIn.getQuantity())
                .description(jobDtoIn.getDescription())
                .salary(jobDtoIn.getSalary())
                .fields(jobDtoIn.getFieldIds())
                .provinces(jobDtoIn.getProvinceIds())
                .expired_at(jobDtoIn.getExpiredAt())
                .build());
        return JobDtoOut.from(job);
    }

    @Override
    public JobDtoOut update(Long id, UpdateJobDtoIn updateJobDtoIn) {
        Job job = jobRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Do not find the id:" + id)
        );
        job.setTitle(updateJobDtoIn.getTitle());
        job.setEmployer_id(updateJobDtoIn.getEmployerId());
        job.setQuantity(updateJobDtoIn.getQuantity());
        job.setDescription(updateJobDtoIn.getDescription());
        job.setFields(updateJobDtoIn.getFieldIds());
        job.setProvinces(updateJobDtoIn.getProvinceIds());
        job.setSalary(updateJobDtoIn.getSalary());
        job.setExpired_at(updateJobDtoIn.getExpiredAt());
        job = jobRepository.save(job);
        return JobDtoOut.from(job);
    }

    @Override
    public void delete(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Cannot found entity id: " + id)
        );
        jobRepository.delete(job);
    }

    @Override
    public List<JobDtoOut> getAllJob(){
        List<Job> jobList = jobRepository.findAll();
        return jobList.stream()
                .map(JobDtoOut::from)
                .collect(Collectors.toList());
    }

    @Override
    public PageDtoOut<JobDtoOut> list(PageDtoIn pageDtoIn) {
        Page<Job> jobs = jobRepository.findAll(PageRequest.of(pageDtoIn.getPage() - 1,
                pageDtoIn.getPageSize(),
                Sort.by("id").ascending()));
        return PageDtoOut.from(pageDtoIn.getPage(), pageDtoIn.getPageSize(), jobs.getTotalElements(),
                jobs.stream().map(JobDtoOut::from).toList());
    }


}
