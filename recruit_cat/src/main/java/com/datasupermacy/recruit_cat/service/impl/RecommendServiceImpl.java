package com.datasupermacy.recruit_cat.service.impl;

import com.datasupermacy.recruit_cat.My1.RecommendController;
import com.datasupermacy.recruit_cat.dao.RecommendDao;
import com.datasupermacy.recruit_cat.entity.Recommend;
import com.datasupermacy.recruit_cat.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendServiceImpl implements RecommendService {
    @Autowired
    RecommendDao recommendDao;

    @Override
    public List<Recommend> getReTop9() {
        return recommendDao.findAll(Sort.by(Sort.Direction.ASC,"Exp"));
    }

    @Override
    public List<Recommend> getReTop10() {
        return recommendDao.getRecommendTop10();
    }
}
