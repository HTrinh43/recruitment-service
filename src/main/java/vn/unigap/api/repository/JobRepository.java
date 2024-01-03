package vn.unigap.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.unigap.api.entity.Job;

import java.util.Date;

public interface JobRepository extends JpaRepository<Job, Long> {
    @Query("SELECT COUNT(j) FROM Job j WHERE j.created_at BETWEEN :startDate AND :endDate")
    Long countJobsBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
