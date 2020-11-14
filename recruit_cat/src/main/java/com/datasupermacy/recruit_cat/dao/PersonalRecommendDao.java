package com.datasupermacy.recruit_cat.dao;

import com.datasupermacy.recruit_cat.entity.PersonalRecommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalRecommendDao extends JpaRepository<PersonalRecommend,Integer>, JpaSpecificationExecutor<PersonalRecommend> {
    @Query(value = "select id,Uid,Jid,Exp from personal_recommend where Uid=1 group by Jid ORDER BY Exp desc",nativeQuery = true)
    List<PersonalRecommend> getURecommendTop();
}
