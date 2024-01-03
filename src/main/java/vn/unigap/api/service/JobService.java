package vn.unigap.api.service;

import vn.unigap.api.dto.in.DateDtoIn;
import vn.unigap.api.dto.in.JobDtoIn;
import vn.unigap.api.dto.in.PageDtoIn;
import vn.unigap.api.dto.in.UpdateJobDtoIn;
import vn.unigap.api.dto.out.JobDtoOut;
import vn.unigap.api.dto.out.PageDtoOut;

import java.util.List;


public interface JobService {

    JobDtoOut get(Long id);

    JobDtoOut create(JobDtoIn jobDtoIn);

    JobDtoOut update(Long id, UpdateJobDtoIn updateJobDtoIn);

    void delete(Long id);

    List<JobDtoOut> getAllJob();

    PageDtoOut<JobDtoOut> list(PageDtoIn pageDtoIn);

    Long countJobsBetweenDate(DateDtoIn dateDtoIn);
}
