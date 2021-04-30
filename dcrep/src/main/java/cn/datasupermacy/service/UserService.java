package cn.datasupermacy.service;

import cn.datasupermacy.Exceptions.UserException;
import cn.datasupermacy.entity.User;
import cn.datasupermacy.util.UserUtil;

import java.util.List;

public interface UserService {
    List<User> findAllUser()throws UserException;

    User findById(Integer uid)throws UserException;

    User findByUlogname(String uloginName)throws UserException;

    User findByUname(String uname)throws UserException;

    int addUser(User user)throws UserException;

    int addUserSelective(User user)throws UserException;

    int delUser(Integer uid)throws UserException;

    int updateUserSelective(Integer uid,User user)throws UserException;

    User login(String uloginname,String upwd);

    UserUtil getAllUserUtilById(Integer uid)throws UserException;

}
