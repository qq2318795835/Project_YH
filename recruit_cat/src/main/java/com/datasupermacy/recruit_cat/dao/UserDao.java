package com.datasupermacy.recruit_cat.dao;

import com.datasupermacy.recruit_cat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

    User findByUname(String uName);

    User findByUnameOrUphone(String Uname,String Uphone);

    User findByUphone(String Uphone);
}
