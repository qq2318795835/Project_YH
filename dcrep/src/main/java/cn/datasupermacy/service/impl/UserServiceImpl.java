package cn.datasupermacy.service.impl;

import cn.datasupermacy.Exceptions.UserException;
import cn.datasupermacy.dao.DeptMapper;
import cn.datasupermacy.dao.UserMapper;
import cn.datasupermacy.entity.User;
import cn.datasupermacy.service.UserService;
import cn.datasupermacy.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public User findById(Integer uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    @Override
    public User findByUlogname(String uloginName) {
        return userMapper.findUserByName(uloginName);
    }

    @Override
    public User findByUname(String uname) throws UserException {
        return userMapper.findUserByUname(uname);
    }

    @Transactional
    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Transactional
    @Override
    public int addUserSelective(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int delUser(Integer uid) {
        return userMapper.deleteByPrimaryKey(uid);
    }

    @Transactional
    @Override
    public int updateUserSelective(Integer uid, User user) {
        return userMapper.updateByPrimaryKeySelective(uid,user);
    }

    @Override
    public User login(String uloginname, String upwd) {
        User user = userMapper.findUserByName(uloginname);
        if (user!=null){
            if (user.getUpwd().equals(upwd)){
                return user;
            }
        }
        return null;
    }

    @Override
    public UserUtil getAllUserUtilById(Integer uid) {
        if (uid != null) {
            UserUtil userUtil = new UserUtil();
            User user2 = userMapper.selectByPrimaryKey(uid);
            userUtil.setUid(user2.getUid());
            userUtil.setUname(user2.getUname());
            userUtil.setUloginName(user2.getUloginname());
            userUtil.setUremark(user2.getUremark());
            userUtil.setDeptName(deptMapper.selectByPrimaryKey(user2.getDid()).getDtitle());
            userUtil.setUmgr(userMapper.selectByPrimaryKey(user2.getUmgr()).getUname());
            userUtil.setUaddress(user2.getUaddress());
            return userUtil;
        }
        return null;
    }
}
