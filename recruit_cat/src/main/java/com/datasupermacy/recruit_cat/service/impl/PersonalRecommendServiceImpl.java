package com.datasupermacy.recruit_cat.service.impl;

import com.datasupermacy.recruit_cat.dao.PersonalRecommendDao;
import com.datasupermacy.recruit_cat.entity.PersonalRecommend;
import com.datasupermacy.recruit_cat.service.PersonalRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonalRecommendServiceImpl implements PersonalRecommendService {
    @Autowired
    PersonalRecommendDao personalRecommendDao;

    @Override
    public List<PersonalRecommend> getUserHotJob() {

        return personalRecommendDao.getURecommendTop();
    }

    @Override
    public void delPer() {
         personalRecommendDao.deleteAll();
    }
}
