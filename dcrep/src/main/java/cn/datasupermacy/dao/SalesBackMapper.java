package cn.datasupermacy.dao;

import cn.datasupermacy.entity.SalesBack;
import cn.datasupermacy.util.SalesAnalysisBackUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SalesBackMapper {
    int deleteByPrimaryKey(Integer sbid);

    int insert(SalesBack salesBack);

    int insertSelective(SalesBack salesBack);

    SalesBack selectByPrimaryKey(Integer sbid);

    int updateByPrimaryKeySelective(Integer sbid, @Param("salesBack")SalesBack salesBack);

    int updateByPrimaryKey(SalesBack salesBack);

    List<SalesBack> findAllSalesBack();

    List<SalesBack> findSalesBackByGid(Integer gid);

    List<SalesBack> findSalesBackByCid(Integer cid);

    List<SalesBack> findSalesBackBySid(Integer sid);

    List<SalesBack> findSalesBackByDate(Date salesbacktime);

    List<SalesAnalysisBackUtil> AnalysisSalesBack(String salesbacktime);
}