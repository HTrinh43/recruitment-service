package vn.unigap.api.service;

import vn.unigap.api.dto.in.*;
import vn.unigap.api.dto.out.PageDtoOut;
import vn.unigap.api.dto.out.PageResumeDtoOut;
import vn.unigap.api.dto.out.ResumeDtoOut;

import java.util.List;

public interface ResumeService {
    ResumeDtoOut get(Long id);

    ResumeDtoOut create(ResumeDtoIn seekerDtoIn);

    ResumeDtoOut update(Long id, UpdateResumeDtoIn updateSeekerDtoIn);

    void delete(Long id);

    List<ResumeDtoOut> getAllResumes();

    PageDtoOut<PageResumeDtoOut> list(PageResumeDtoIn pageDtoIn);
}
