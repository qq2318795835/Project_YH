package com.datasupermacy.recruit_cat.service;

import com.datasupermacy.recruit_cat.entity.User;
import org.springframework.data.domain.Page;

public interface UserService {
    User getUserById(Integer Uid);

    User getUserByPhone(String Uphone);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(Integer Uid);

    User login(String Uaccount,String Upass);

    Page<User> getUserByPaging(int pageNum, int pageSize);

}
