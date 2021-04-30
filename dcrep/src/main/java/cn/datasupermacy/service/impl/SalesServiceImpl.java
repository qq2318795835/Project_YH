package cn.datasupermacy.service.impl;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.dao.SalesMapper;
import cn.datasupermacy.entity.Sales;
import cn.datasupermacy.service.SalesService;
import cn.datasupermacy.util.SalesAnalysisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {
    @Autowired
    private SalesMapper salesMapper;

    @Override
    public int delSales(Integer ssid) throws DcrepException {
        try {
            return salesMapper.deleteByPrimaryKey(ssid);
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
    public int addSales(Sales sales) throws DcrepException {
        try {
            return salesMapper.insertSelective(sales);
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
    public Sales findSalesById(Integer ssid) throws DcrepException {
        try {
            return salesMapper.selectByPrimaryKey(ssid);
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
    public int updateSales(Integer ssid, Sales sales) throws DcrepException {
        try {
            return salesMapper.updateByPrimaryKeySelective(ssid,sales);
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
    public List<Sales> findAllSales() {
        return salesMapper.findAllSales();
    }

    @Override
    public List<Sales> findSalesByGid(Integer gid) throws DcrepException {
        try {
            return salesMapper.findSalesByGid(gid);
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
    public List<Sales> findSalesByCid(Integer cid) throws DcrepException {
        try {
            return salesMapper.findSalesByCid(cid);
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
    public List<Sales> findSalesBySid(Integer sid) throws DcrepException {
        try {
            return salesMapper.findSalesBySid(sid);
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
    public List<Sales> findSalesByOname(String operateperson) {
        try {
            return salesMapper.findSalesByOname(operateperson);
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
    public List<Sales> findSalesByDate(Date salestime) throws DcrepException {
        try {
            return salesMapper.findSalesByDate(salestime);
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
    public List<Sales> findSalesByDateSelect(String salestime) throws DcrepException {
        try {
            return salesMapper.findSalesByDateSelect(salestime);
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
    public List<SalesAnalysisUtil> AnalysisSales(String salestime) {
        try {
            return salesMapper.AnalysisSales(salestime);
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
