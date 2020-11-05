package com.datasupermacy.recruit_cat.dao;

import com.datasupermacy.recruit_cat.entity.FavoritesList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesListDao extends JpaRepository<FavoritesList,Integer>, JpaSpecificationExecutor<FavoritesList> {
    FavoritesList findByJidAndUid(Integer Jid,Integer Uid);
    int deleteByJidAndUid(Integer Jid,Integer Uid);
}
