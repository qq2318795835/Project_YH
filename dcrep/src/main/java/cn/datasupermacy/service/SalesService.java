package cn.datasupermacy.service;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.entity.Sales;
import cn.datasupermacy.util.SalesAnalysisUtil;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SalesService {
    int delSales(Integer ssid)throws DcrepException;

    int addSales(Sales sales)throws DcrepException;

    Sales findSalesById(Integer ssid)throws DcrepException;

    int updateSales(Integer ssid,@Param("sales") Sales sales)throws DcrepException;

    List<Sales> findAllSales();

    List<Sales> findSalesByGid(Integer gid)throws DcrepException;

    List<Sales> findSalesByCid(Integer cid)throws DcrepException;

    List<Sales> findSalesBySid(Integer sid)throws DcrepException;

    List<Sales> findSalesByOname(String operateperson);

    List<Sales> findSalesByDate(Date salestime)throws DcrepException;

    List<Sales> findSalesByDateSelect(String salestime)throws DcrepException;

    List<SalesAnalysisUtil> AnalysisSales(String salestime);
}
