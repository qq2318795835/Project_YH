package com.datasupermacy.recruit_cat.dao;

import com.datasupermacy.recruit_cat.My1.RecommendController;
import com.datasupermacy.recruit_cat.entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RecommendDao extends JpaRepository<Recommend,Integer>, JpaSpecificationExecutor<Recommend> {
    @Query(value = "select id,Uid,Jid,Exp from recommend group by Jid ORDER BY Exp desc",nativeQuery = true)

     List<Recommend> getRecommendTop10();
}
