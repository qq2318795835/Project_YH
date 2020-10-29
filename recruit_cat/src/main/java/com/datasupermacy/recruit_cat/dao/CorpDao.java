package com.datasupermacy.recruit_cat.dao;

import com.datasupermacy.recruit_cat.entity.Corp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CorpDao extends JpaRepository<Corp,Integer>, JpaSpecificationExecutor<Corp> {
    /**
     * 根据名称查公司
     * @param Cname
     * @return
     */
    Corp findByCname(String Cname);

    /**
     * 根据企业id查企业
     * @param Cid
     * @return
     */
    Corp findByCid(Integer Cid);

    /**
     * 根据名称或电话查公司
     * @param Cname
     * @param Cphone
     * @return
     */
    Corp findByCnameOrCphone(String Cname,String Cphone);

}
