package com.datasupermacy.recruit_cat.service.impl;

import com.datasupermacy.recruit_cat.dao.UserDao;
import com.datasupermacy.recruit_cat.entity.User;
import com.datasupermacy.recruit_cat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User getUserById(Integer Uid) {
        Optional <User> o = userDao.findById(Uid);
        if (o.isPresent()){
            return o.get();
        }
        return null;
    }

    @Override
    public User getUserByPhone(String Uphone) {
        return userDao.findByUphone(Uphone);
    }

    @Override
    public Page<User> getUserByPaging(int pageNum,int pageSize){
        PageRequest pb = PageRequest.of(pageNum-1,pageSize);
        Page<User> page = userDao.findAll(pb);
        return page;
    }

    @Override
    public int addUser(User user) {
        if (userDao.save(user)!=null){
            return 1;
        }
        return 0;
    }

    @Transactional
    @Override
    public int updateUser(User user) {
        User user1 = getUserById(user.getUid());
        if (user1.getUid().equals(user.getUid())){
            userDao.save(user);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteUser(Integer Uid) {
        userDao.deleteById(Uid);
        return 1;
    }

    @Override
    public User login(String Uaccount,String Upass) {
        User user = userDao.findByUnameOrUphone(Uaccount,Upass);
        if (user!=null){
            if(user.getUpass().equals(Upass)){
                return user;
            }
        }
        return null;
    }

}
