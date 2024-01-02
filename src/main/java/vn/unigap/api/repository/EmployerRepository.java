package vn.unigap.api.repository;
import vn.unigap.api.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployerRepository extends JpaRepository<Employer, Integer>{
    Optional<Employer> findByEmail(String email);
}
