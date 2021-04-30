package cn.datasupermacy.service.impl;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.dao.InportsMapper;
import cn.datasupermacy.entity.Inports;
import cn.datasupermacy.service.InportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class InportsServiceImpl implements InportsService {
    @Autowired
    InportsMapper inportsMapper;

    @Override
    public int delInports(Integer iid) throws DcrepException {
        try {
            return inportsMapper.deleteByPrimaryKey(iid);
        } catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    @Transactional
    @Override
    public int addInports(Inports inports) throws DcrepException {
        try {
            return inportsMapper.insertSelective(inports);
        } catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Inports findInportsById(Integer iid) throws DcrepException {
        try {
            return inportsMapper.selectByPrimaryKey(iid);
        } catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    @Override
    public int updateInports(Integer iid,Inports inports) throws DcrepException {
        try {
            return inportsMapper.updateByPrimaryKeySelective(iid,inports);
        } catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Inports> findAllInports() {
        return inportsMapper.findAllInports();
    }

    @Override
    public List<Inports> findInportsByGid(Integer gid) throws DcrepException {
        try {
            return inportsMapper.findInportsByGid(gid);
        } catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Inports> findInportsByPid(Integer pid) throws DcrepException {
        try {
            return inportsMapper.findInportsByPid(pid);
        } catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Inports> findInportsBySid(Integer sid) throws DcrepException {
        try {
            return inportsMapper.findInportsBySid(sid);
        } catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Inports> findInportsByOname(String operateperson) throws DcrepException {
        try {
            return inportsMapper.findInportsByOname(operateperson);
        } catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Inports> findInportsByDate(Date inporttime) throws DcrepException {
        try {
            return inportsMapper.findInportsByDate(inporttime);
        } catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
