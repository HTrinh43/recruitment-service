package vn.unigap.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.unigap.api.entity.Seeker;


public interface SeekerRepository extends JpaRepository<Seeker, Long> {
    Page<Seeker> findByProvince(Integer province, Pageable pageable);
}
