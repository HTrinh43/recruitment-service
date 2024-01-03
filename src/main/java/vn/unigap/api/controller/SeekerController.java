package vn.unigap.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.unigap.api.dto.in.*;
import vn.unigap.api.service.SeekerService;

import java.util.HashMap;

@RestController
@RequestMapping("/seekers")
public class SeekerController extends AbstractResponseController {
    private final SeekerService seekerService;

    @Autowired
    public SeekerController(SeekerService seekerService){
        this.seekerService = seekerService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid SeekerDtoIn seekerDtoIn){
        return responseEntity(
                ()-> {
                    return seekerService.create(seekerDtoIn);
                }, 201, true
        );
    }

    @GetMapping
    public ResponseEntity<?> list(@RequestBody @Valid PageSeekerDtoIn pageDtoIn){
        return responseEntity(
                () -> {return seekerService.list(pageDtoIn);}
                , 201, false
        );
    }
    @PutMapping(value="/{id}")
    public ResponseEntity<?> update(@PathVariable(value="id") Long id, @RequestBody @Valid UpdateSeekerDtoIn updateSeekerDtoIn){
        return responseEntity(
                () -> {return seekerService.update(id, updateSeekerDtoIn);},
                201, false
        );
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable(value="id") Long id){
        return responseEntity(
                () -> {
                    seekerService.delete(id);
                    return new HashMap<>();
                }
                , 201, false
        );
    }
}
