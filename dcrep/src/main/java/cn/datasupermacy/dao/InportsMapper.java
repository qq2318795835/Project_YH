package cn.datasupermacy.dao;

import cn.datasupermacy.entity.Inports;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface InportsMapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(Inports record);

    int insertSelective(Inports inports);

    Inports selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(Integer iid,@Param("inports")Inports inports);

    int updateByPrimaryKey(Inports inports);

    List<Inports> findAllInports();

    List<Inports> findInportsByGid(Integer gid);

    List<Inports> findInportsByPid(Integer pid);

    List<Inports> findInportsBySid(Integer sid);

    List<Inports> findInportsByOname(String operateperson);

    List<Inports> findInportsByDate(Date inporttime);

}