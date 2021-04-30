package cn.datasupermacy.service;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.entity.Outports;
import java.util.Date;
import java.util.List;

public interface OutportsService {
    int delOutports(Integer oid)throws DcrepException;

    int addOutports(Outports outports)throws DcrepException;

    Outports findOutportsById(Integer oid)throws DcrepException;

    int updateOutports(Integer oid,Outports outports)throws DcrepException;

    List<Outports> findAllOutports();

    List<Outports> findOutportsByGid(Integer gid)throws DcrepException;

    List<Outports> findOutportsByPid(Integer pid)throws DcrepException;

    List<Outports> findOutportsBySid(Integer sid)throws DcrepException;

    List<Outports> findOutportsByDate(Date outputtime)throws DcrepException;
}
