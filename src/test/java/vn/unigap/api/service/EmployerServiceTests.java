package vn.unigap.api.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import vn.unigap.api.dto.in.CreateEmployerDtoIn;
import vn.unigap.api.dto.in.UpdateEmployerDtoIn;
import vn.unigap.api.dto.out.EmployerDtoOut;
import vn.unigap.api.entity.Employer;
import vn.unigap.api.repository.EmployerRepository;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployerServiceTests {

    @Mock
    private EmployerRepository employerRepository;

    @InjectMocks
    private EmployerService employerService;

    @Test
    public void EmployerService_CreateEmployer_ReturnEmployer(){
        Employer employer1 = Employer.builder()
                .email("hello1@gmail.com")
                .name("Hello1")
                .province(12345)
                .description("")
                .build();

        CreateEmployerDtoIn employerDtoIn = CreateEmployerDtoIn.builder()
                                                                .email("hello1@gmail.com")
                                                                .name("Hello1")
                                                                .provinceId(12345)
                                                                .description("")
                                                                .build();
        when(employerRepository.save(Mockito.any(Employer.class))).thenReturn(employer1);

        Employer saveEmployerDto = employerService.createEmployer(employerDtoIn);
        Assertions.assertThat(saveEmployerDto).isNotNull();
    }

    @Test
    public void EmployerService_updateEmployer_ReturnEmployer(){
        Employer employer1 = Employer.builder()
                .id(1)
                .email("hello1@gmail.com")
                .name("Hello1")
                .province(12345)
                .description("")
                .build();

        UpdateEmployerDtoIn employerDtoIn = UpdateEmployerDtoIn.builder()
                .id(1)
                .name("Hello1")
                .provinceId(12345)
                .description("")
                .build();

        when(employerRepository.findById(1)).thenReturn(Optional.ofNullable(employer1));
        when(employerRepository.save(Mockito.any(Employer.class))).thenReturn(employer1);

        Employer saveEmployerDto = employerService.updateEmployer(employerDtoIn);
        Assertions.assertThat(saveEmployerDto).isNotNull();
    }

    @Test
    public void EmployerService_getEmployer_ReturnEmployer(){
        Employer employer1 = Employer.builder()
                .id(1)
                .email("hello1@gmail.com")
                .name("Hello1")
                .province(12345)
                .description("")
                .build();


        when(employerRepository.findById(1)).thenReturn(Optional.ofNullable(employer1));

        EmployerDtoOut saveEmployerDto = employerService.getEmployer(1);
        Assertions.assertThat(saveEmployerDto).isNotNull();
    }
}
