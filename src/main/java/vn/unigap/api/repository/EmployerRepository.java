package vn.unigap.api.repository;
import vn.unigap.api.entity.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployerRepository extends JpaRepository<Employer, Integer>{

}
