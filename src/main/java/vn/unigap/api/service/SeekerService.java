package vn.unigap.api.service;

import vn.unigap.api.dto.in.*;
import vn.unigap.api.dto.out.PageDtoOut;
import vn.unigap.api.dto.out.SeekerDtoOut;

import java.util.List;

public interface SeekerService {
    SeekerDtoOut get(Long id);

    SeekerDtoOut create(SeekerDtoIn seekerDtoIn);

    SeekerDtoOut update(Long id, UpdateSeekerDtoIn updateSeekerDtoIn);

    void delete(Long id);

    List<SeekerDtoOut> getAllSeekers();

    PageDtoOut<SeekerDtoOut> list(PageSeekerDtoIn pageDtoIn);
}
