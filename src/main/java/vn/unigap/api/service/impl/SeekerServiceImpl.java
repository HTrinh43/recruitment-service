package vn.unigap.api.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.unigap.api.dto.in.PageSeekerDtoIn;
import vn.unigap.api.dto.in.SeekerDtoIn;
import vn.unigap.api.dto.in.UpdateSeekerDtoIn;
import vn.unigap.api.dto.out.PageDtoOut;
import vn.unigap.api.dto.out.SeekerDtoOut;
import vn.unigap.api.entity.Seeker;
import vn.unigap.api.repository.SeekerRepository;
import vn.unigap.api.service.SeekerService;

import java.util.List;

@Service
public class SeekerServiceImpl implements SeekerService {

    private SeekerRepository seekerRepository;

    @Autowired
    public SeekerServiceImpl(SeekerRepository seekerRepository){
        this.seekerRepository=seekerRepository;
    }
    @Override
    public SeekerDtoOut get(Long id) {
        Seeker seeker = seekerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Cannot find entity id: " + id)
        );
        return SeekerDtoOut.from(seeker);
    }

    @Override
    public SeekerDtoOut create(SeekerDtoIn seekerDtoIn) {
        Seeker seeker = seekerRepository.save(
                Seeker.builder()
                        .name(seekerDtoIn.getName())
                        .birthday(seekerDtoIn.getBirthday())
                        .address(seekerDtoIn.getAddress())
                        .province(seekerDtoIn.getProvinceId())
                        .build()
        );
        return SeekerDtoOut.from(seeker);
    }

    @Override
    public SeekerDtoOut update(Long id, UpdateSeekerDtoIn updateSeekerDtoIn) {
        Seeker seeker = seekerRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("Cannot find entity id: " + id)
        );
        seeker.setName(updateSeekerDtoIn.getName());
        seeker.setBirthday(updateSeekerDtoIn.getBirthday());
        if (updateSeekerDtoIn.getAddress() != null)
            seeker.setAddress(updateSeekerDtoIn.getAddress());
        seeker.setProvince(updateSeekerDtoIn.getProvinceId());
        seeker = seekerRepository.save(seeker);
        return SeekerDtoOut.from(seeker);
    }

    @Override
    public void delete(Long id) {
        Seeker seeker = seekerRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("Cannot find entity id: " + id)
        );
        seekerRepository.delete(seeker);
    }

    @Override
    public List<SeekerDtoOut> getAllSeekers() {
        List<Seeker> seekerList = seekerRepository.findAll();
        return seekerList.stream()
                .map(SeekerDtoOut::from).toList();
    }

    @Override
    public PageDtoOut<SeekerDtoOut> list(PageSeekerDtoIn pageDtoIn) {
        Page<Seeker> seekers;
        if (pageDtoIn.getProvinceId() == -1)
            seekers = seekerRepository.findAll(PageRequest.of(pageDtoIn.getPage()-1,
                pageDtoIn.getPageSize(),
                Sort.by("id").ascending()));
        else {
            seekers = seekerRepository.findByProvince(pageDtoIn.getProvinceId(), PageRequest.of(pageDtoIn.getPage()-1,
                    pageDtoIn.getPageSize(),
                    Sort.by("id").ascending()));
        }
        return PageDtoOut.from(pageDtoIn.getPage(), pageDtoIn.getPageSize(), seekers.getTotalElements(),
                seekers.stream().map(SeekerDtoOut::from).toList());
    }
}
