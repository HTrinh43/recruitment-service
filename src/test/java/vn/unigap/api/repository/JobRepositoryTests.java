package vn.unigap.api.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import vn.unigap.api.entity.Job;

import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class JobRepositoryTests {
    @Autowired
    private JobRepository jobRepository;

    @Test
    public void JobRepository_CreateAJob_ReturnAJob(){
        Job job = Job.builder()
                        .title("Job1")
                        .employer_id(1)
                        .quantity(2)
                        .description("Hiring")
                        .fields("1,2,3,4")
                        .provinces("12345,23456")
                        .salary(50000)
                        .expired_at(new Date())
                        .build();
        Job savedJob = jobRepository.save(job);
        Assertions.assertThat(savedJob).isNotNull();
    }
}
