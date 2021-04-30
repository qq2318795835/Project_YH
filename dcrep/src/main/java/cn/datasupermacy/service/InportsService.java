package cn.datasupermacy.service;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.entity.Inports;
import java.util.Date;
import java.util.List;

public interface InportsService {
    int delInports(Integer iid)throws DcrepException;

    int addInports(Inports inports)throws DcrepException;

    Inports findInportsById(Integer iid)throws DcrepException;

    int updateInports(Integer iid,Inports inports)throws DcrepException;

    List<Inports> findAllInports();

    List<Inports> findInportsByGid(Integer gid)throws DcrepException;

    List<Inports> findInportsByPid(Integer pid)throws DcrepException;

    List<Inports> findInportsBySid(Integer sid)throws DcrepException;

    List<Inports> findInportsByOname(String operateperson)throws DcrepException;

    List<Inports> findInportsByDate(Date inporttime)throws DcrepException;
}
