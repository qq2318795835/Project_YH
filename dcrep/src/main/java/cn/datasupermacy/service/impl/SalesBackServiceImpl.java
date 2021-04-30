package cn.datasupermacy.service.impl;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.dao.SalesBackMapper;
import cn.datasupermacy.entity.SalesBack;
import cn.datasupermacy.service.SalesBackService;
import cn.datasupermacy.util.SalesAnalysisBackUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SalesBackServiceImpl implements SalesBackService {
    @Autowired
    private SalesBackMapper salesBackMapper;


    @Override
    public int delSalesBack(Integer sbid) throws DcrepException {
        try {
            return salesBackMapper.deleteByPrimaryKey(sbid);
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
    public int insert(SalesBack salesBack) throws DcrepException {
        try {
            return salesBackMapper.insert(salesBack);
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
    public int addSalesBack(SalesBack salesBack) throws DcrepException {
        try {
            return salesBackMapper.insertSelective(salesBack);
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
    public SalesBack findSalesBackById(Integer sbid) throws DcrepException {
        try {
            return salesBackMapper.selectByPrimaryKey(sbid);
        }catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateSalesBack(Integer sbid, SalesBack salesBack) throws DcrepException {
        try {
            return salesBackMapper.updateByPrimaryKeySelective(sbid,salesBack);
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
    public int updateByPrimaryKey(SalesBack salesBack) throws DcrepException {
        try {
            return salesBackMapper.updateByPrimaryKey(salesBack);
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
    public List<SalesBack> findAllSalesBack() {
        return salesBackMapper.findAllSalesBack();
    }

    @Override
    public List<SalesBack> findSalesBackByGid(Integer gid) throws DcrepException {
        try {
            return salesBackMapper.findSalesBackByGid(gid);
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
    public List<SalesBack> findSalesBackByCid(Integer cid) throws DcrepException {
        try {
            return salesBackMapper.findSalesBackByCid(cid);
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
    public List<SalesBack> findSalesBackBySid(Integer sid) throws DcrepException {
        try {
            return salesBackMapper.findSalesBackBySid(sid);
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
    public List<SalesBack> findSalesBackByDate(Date salesbacktime) throws DcrepException {
        try {
            return salesBackMapper.findSalesBackByDate(salesbacktime);
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
    public List<SalesAnalysisBackUtil> AnalysisSalesBack(String salesbacktime) throws DcrepException {
        try {
            return salesBackMapper.AnalysisSalesBack(salesbacktime);
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
