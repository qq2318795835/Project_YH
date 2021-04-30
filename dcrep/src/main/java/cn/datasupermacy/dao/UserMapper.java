package cn.datasupermacy.dao;

import cn.datasupermacy.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> findAllUser();

    User selectByPrimaryKey(Integer uid);

    int insert(User user);

    int insertSelective(User user);

    int deleteByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Integer uid,@Param("user")User user);

    User findUserByName(String uloginname);

    User findUserByUname(String uname);
}