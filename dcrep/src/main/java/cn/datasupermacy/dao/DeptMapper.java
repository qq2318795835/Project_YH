package cn.datasupermacy.dao;

import cn.datasupermacy.entity.Dept;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptMapper {
    int deleteByPrimaryKey(Integer did);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer did);

    int updateByPrimaryKeySelective(Integer did,@Param("dept")Dept dept);

    int updateByPrimaryKey(Dept record);

    List<Dept> findAllDept();

    Dept findDeptByName(String dtitle);

    List<Dept> findDeptByDpid(Integer dpid);

    List<Dept> findDeptByAddress(String daddress);
}