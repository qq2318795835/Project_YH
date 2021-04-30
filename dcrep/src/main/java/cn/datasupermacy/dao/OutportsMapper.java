package cn.datasupermacy.dao;

import cn.datasupermacy.entity.Outports;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OutportsMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(Outports outports);

    int insertSelective(Outports outports);

    Outports selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(Integer oid,@Param("outports")Outports outports);

    int updateByPrimaryKey(Outports outports);

    List<Outports> findAllOutports();

    List<Outports> findOutportsByGid(Integer gid);

    List<Outports> findOutportsByPid(Integer pid);

    List<Outports> findOutportsBySid(Integer sid);

    List<Outports> findOutportsByDate(Date outputtime);
}