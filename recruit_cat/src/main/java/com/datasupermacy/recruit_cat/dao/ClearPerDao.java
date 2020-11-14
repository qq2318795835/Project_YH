package com.datasupermacy.recruit_cat.dao;

import com.datasupermacy.recruit_cat.entity.PersonalRecommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClearPerDao extends JpaRepository<PersonalRecommend,Integer>, JpaSpecificationExecutor<PersonalRecommend> {
    @Query(value = "DELETE FROM personal_recommend",nativeQuery = true)
    boolean clearPersonal_recommend ();
}
