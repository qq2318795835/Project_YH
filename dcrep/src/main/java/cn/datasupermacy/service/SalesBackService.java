package cn.datasupermacy.service;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.entity.SalesBack;
import cn.datasupermacy.util.SalesAnalysisBackUtil;

import java.util.Date;
import java.util.List;

public interface SalesBackService {
    int delSalesBack(Integer sbid)throws DcrepException;

    int insert(SalesBack salesBack)throws DcrepException;

    int addSalesBack(SalesBack salesBack)throws DcrepException;

    SalesBack findSalesBackById(Integer sbid)throws DcrepException;

    int updateSalesBack(Integer sbid, SalesBack salesBack)throws DcrepException;

    int updateByPrimaryKey(SalesBack salesBack)throws DcrepException;

    List<SalesBack> findAllSalesBack();

    List<SalesBack> findSalesBackByGid(Integer gid)throws DcrepException;

    List<SalesBack> findSalesBackByCid(Integer cid)throws DcrepException;

    List<SalesBack> findSalesBackBySid(Integer sid)throws DcrepException;

    List<SalesBack> findSalesBackByDate(Date salesbacktime)throws DcrepException;

    List<SalesAnalysisBackUtil> AnalysisSalesBack(String salesbacktime)throws DcrepException;
}
