package com.datasupermacy.recruit_cat.dao;
import com.datasupermacy.recruit_cat.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface JobDao extends JpaRepository<Job,Integer>, JpaSpecificationExecutor<Job> {
    Page<Job> findByJtype(String jtype, Pageable pageable);
}
