package cn.datasupermacy.service.impl;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.dao.OutportsMapper;
import cn.datasupermacy.entity.Outports;
import cn.datasupermacy.service.OutportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OutportsServiceImpl implements OutportsService {
    @Autowired
    private OutportsMapper outportsMapper;

    @Override
    public int delOutports(Integer oid) {
        try {
            return outportsMapper.deleteByPrimaryKey(oid);
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
    public int addOutports(Outports outports) {
        try {
            return outportsMapper.insertSelective(outports);
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
    public Outports findOutportsById(Integer oid) {
        try {
            return outportsMapper.selectByPrimaryKey(oid);
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
    public int updateOutports(Integer oid, Outports outports) {
        try {
            return outportsMapper.updateByPrimaryKeySelective(oid,outports);
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
    public List<Outports> findAllOutports() {
        return outportsMapper.findAllOutports();
    }

    @Override
    public List<Outports> findOutportsByGid(Integer gid) {
        try {
            return outportsMapper.findOutportsByGid(gid);
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
    public List<Outports> findOutportsByPid(Integer pid) {
        try {
            return outportsMapper.findOutportsByPid(pid);
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
    public List<Outports> findOutportsBySid(Integer sid) {
        try {
            return outportsMapper.findOutportsBySid(sid);
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
    public List<Outports> findOutportsByDate(Date outputtime) {
        try {
            return outportsMapper.findOutportsByDate(outputtime);
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
