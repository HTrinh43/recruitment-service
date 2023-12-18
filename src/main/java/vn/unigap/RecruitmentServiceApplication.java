package vn.unigap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@SpringBootApplication
@EntityScan("vn.unigap.api.entity")
public class RecruitmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruitmentServiceApplication.class, args);

	}

}
