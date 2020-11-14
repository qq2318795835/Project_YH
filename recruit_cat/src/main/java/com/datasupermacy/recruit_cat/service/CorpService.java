package com.datasupermacy.recruit_cat.service;

import com.datasupermacy.recruit_cat.entity.Corp;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CorpService {

    Corp getCorpById(Integer Cid);

    Corp getCorpByName(String Cname);

    Corp login(String Caccount,String Cpass);

    List<Corp> getAllCorps();

    Page<Corp> getCorpByPaging(int pageNum,int pageSize);

    Page<Corp> searchCorps(String key,int pageNum,int pageSize);

    int addCorp(Corp corp);

    int updateCorp(Corp corp);

    int deleteCorp(Integer Cid);
}
