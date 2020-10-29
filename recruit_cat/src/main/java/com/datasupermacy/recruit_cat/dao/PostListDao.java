package com.datasupermacy.recruit_cat.dao;

import com.datasupermacy.recruit_cat.entity.PostList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PostListDao extends JpaRepository<PostList,Integer>, JpaSpecificationExecutor<PostList> {
    PostList findByJidAndCid(Integer Jid,Integer Cid);
}
