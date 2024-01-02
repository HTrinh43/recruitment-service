package vn.unigap.api.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.unigap.api.dto.in.PageResumeDtoIn;
import vn.unigap.api.dto.in.ResumeDtoIn;
import vn.unigap.api.dto.in.UpdateResumeDtoIn;
import vn.unigap.api.dto.out.PageDtoOut;
import vn.unigap.api.dto.out.PageResumeDtoOut;
import vn.unigap.api.dto.out.ResumeDtoOut;
import vn.unigap.api.entity.Resume;
import vn.unigap.api.repository.ResumeRepository;
import vn.unigap.api.service.ResumeService;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    private ResumeRepository resumeRepository;

    @Autowired
    public ResumeServiceImpl(ResumeRepository resumeRepository){
        this.resumeRepository = resumeRepository;
    }
    @Override
    public ResumeDtoOut get(Long id) {
        Resume resume = resumeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Cannot find entity id: " + id)
        );
        return ResumeDtoOut.from(resume);
    }

    @Override
    public ResumeDtoOut create(ResumeDtoIn resumeDtoIn) {
        Resume resume = resumeRepository.save(
                Resume.builder()
                        .seeker_id(resumeDtoIn.getSeekerId())
                        .career_obj(resumeDtoIn.getCareerObj())
                        .title(resumeDtoIn.getTitle())
                        .salary(resumeDtoIn.getSalary())
                        .fields(resumeDtoIn.getFieldIds())
                        .provinces(resumeDtoIn.getProvinceIds())
                        .build()
        );
        return ResumeDtoOut.from(resume);
    }

    @Override
    public ResumeDtoOut update(Long id, UpdateResumeDtoIn updateResumeDtoIn) {
        Resume resume = resumeRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("No entity")
        );
        resume.setTitle(updateResumeDtoIn.getTitle());
        resume.setFields(updateResumeDtoIn.getFieldIds());
        resume.setSalary(updateResumeDtoIn.getSalary());
        resume.setCareer_obj(updateResumeDtoIn.getCareerObj());
        resume.setProvinces(updateResumeDtoIn.getProvinceIds());
        resume = resumeRepository.save(resume);
        return ResumeDtoOut.from(resume);
    }

    @Override
    public void delete(Long id) {
        Resume resume = resumeRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("No entity")
        );
        resumeRepository.delete(resume);
    }

    @Override
    public List<ResumeDtoOut> getAllResumes() {
        List<Resume> resumeList = resumeRepository.findAll();
        return resumeList.stream()
                .map(ResumeDtoOut::from).toList();
    }

    @Override
    public PageDtoOut<PageResumeDtoOut> list(PageResumeDtoIn pageDtoIn) {
        Page<Resume> resumes;
//        if (pageDtoIn.getSeekerId() == -1)
            resumes = resumeRepository.findAll(PageRequest.of(pageDtoIn.getPage()-1,
                    pageDtoIn.getPageSize(),
                    Sort.by("id").ascending()));
//        else {
//            resumes = resumeRepository.findBySeekerId(pageDtoIn.getSeekerId(), PageRequest.of(pageDtoIn.getPage()-1,
//                    pageDtoIn.getPageSize(),
//                    Sort.by("id").ascending()));
//        }
        return PageDtoOut.from(pageDtoIn.getPage(), pageDtoIn.getPageSize(), resumes.getTotalElements(),
                resumes.stream().map(PageResumeDtoOut::from).toList());
    }
}
