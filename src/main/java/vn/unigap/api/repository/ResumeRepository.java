package vn.unigap.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.unigap.api.entity.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
//    Page<Resume> findBySeekerId(Integer seekerId, Pageable pageable);

}
