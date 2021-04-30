package cn.datasupermacy.dao;

import cn.datasupermacy.entity.Sales;
import cn.datasupermacy.util.SalesAnalysisUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface SalesMapper {
    int deleteByPrimaryKey(Integer ssid);

    int insert(Sales sales);

    int insertSelective(Sales sales);

    Sales selectByPrimaryKey(Integer ssid);

    int updateByPrimaryKeySelective(Integer ssid,@Param("sales") Sales sales);

    int updateByPrimaryKey(Sales sales);

    List<Sales> findAllSales();

    List<Sales> findSalesByGid(Integer gid);

    List<Sales> findSalesByCid(Integer cid);

    List<Sales> findSalesBySid(Integer sid);

    List<Sales> findSalesByOname(String operateperson);

    List<Sales> findSalesByDate(Date salestime);

    List<Sales> findSalesByDateSelect(String salestime);

    List<SalesAnalysisUtil> AnalysisSales(String salestime);
}