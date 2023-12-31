package vn.unigap.api.repository;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import vn.unigap.api.entity.Employer;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmployerRepositoryTests {

    @Autowired
    private EmployerRepository employerRepository;

    @Test
    public void EmployerRepository_SaveAll_ReturnSavedEmployer(){
        Employer employer = Employer.builder()
                                    .email("hello@gmail.com")
                                    .name("Hello")
                                    .province(12345)
                                    .description("")
                                    .build();

        Employer saveEmployer = employerRepository.save(employer);

        Assertions.assertThat(saveEmployer).isNotNull();
        Assertions.assertThat(saveEmployer.getId()).isGreaterThan(0);
    }

    @Test
    public void EmployerRepository_GetAll_ReturnMoreThanOneEmployer(){
        Employer employer1 = Employer.builder()
                .email("hello1@gmail.com")
                .name("Hello1")
                .province(12345)
                .description("")
                .build();
        Employer employer2 = Employer.builder()
                .email("hello2@gmail.com")
                .name("Hello2")
                .province(12345)
                .description("")
                .build();
        Employer saveEmployer1 = employerRepository.save(employer1);
        Employer saveEmployer2 = employerRepository.save(employer2);

        List<Employer> employerList = employerRepository.findAll();

        Assertions.assertThat(employerList).isNotNull();
        Assertions.assertThat(employerList.size()).isEqualTo(2);
    }

    @Test
    public void EmployerRepository_FindById_ReturnEmployer(){
        Employer employer1 = Employer.builder()
                .email("hello1@gmail.com")
                .name("Hello1")
                .province(12345)
                .description("")
                .build();

        Employer saveEmployer1 = employerRepository.save(employer1);

        Employer employerList = employerRepository.findById(employer1.getId()).get();

        Assertions.assertThat(employerList).isNotNull();
    }

    @Test
    public void EmployerRepository_FindByEmail_ReturnEmployer(){
        Employer employer1 = Employer.builder()
                .email("hello1@gmail.com")
                .name("Hello1")
                .province(12345)
                .description("")
                .build();

        Employer saveEmployer1 = employerRepository.save(employer1);

        Employer employerList = employerRepository.findByEmail(employer1.getEmail()).get();

        Assertions.assertThat(employerList).isNotNull();
    }

    @Test
    public void EmployerRepository_UpdateById_ReturnEmployer(){
        Employer employer1 = Employer.builder()
                .email("hello1@gmail.com")
                .name("Hello1")
                .province(12345)
                .description("")
                .build();

        employerRepository.save(employer1);

        Employer employerSave = employerRepository.findById(employer1.getId()).get();
        employerSave.setProvince(32112);

        Employer updatedEmployer = employerRepository.save(employerSave);

        Assertions.assertThat(updatedEmployer.getProvince()).isNotNull();
    }
}
