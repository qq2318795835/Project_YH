package com.datasupermacy.recruit_cat.service.impl;

import com.datasupermacy.recruit_cat.dao.ClearPerDao;
import com.datasupermacy.recruit_cat.service.ClearPerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClearPerServiceImpl implements ClearPerService {
    @Autowired
    ClearPerDao clearPerDao;

    @Override
    public void clearPer() {
        clearPerDao.clearPersonal_recommend();
    }
}
