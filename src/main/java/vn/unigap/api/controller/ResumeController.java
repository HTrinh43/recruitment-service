package vn.unigap.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.unigap.api.dto.in.PageResumeDtoIn;
import vn.unigap.api.dto.in.ResumeDtoIn;
import vn.unigap.api.dto.in.UpdateResumeDtoIn;
import vn.unigap.api.service.ResumeService;

import java.util.HashMap;

@RestController
@RequestMapping("/resumes")
public class ResumeController extends AbstractResponseController{
    private final ResumeService resumeService;

    @Autowired
    public ResumeController (ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ResumeDtoIn resumeDtoIn) {
        return responseEntity(
                ()-> {
                    return resumeService.create(resumeDtoIn);
                }, 201, true
        );
    }
    @GetMapping
    public ResponseEntity<?> list(@RequestBody @Valid PageResumeDtoIn pageDtoIn){
        return responseEntity(
                () -> {return resumeService.list(pageDtoIn);}
                , 201, false
        );
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<?> update(@PathVariable(value="id") Long id, @RequestBody @Valid UpdateResumeDtoIn updateResumeDtoIn){
        return responseEntity(
                () -> {return resumeService.update(id, updateResumeDtoIn);},
                201, false
        );
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable(value="id") Long id){
        return responseEntity(
                () -> {
                    resumeService.delete(id);
                    return new HashMap<>();
                    }
                , 201, false
        );
    }
}
