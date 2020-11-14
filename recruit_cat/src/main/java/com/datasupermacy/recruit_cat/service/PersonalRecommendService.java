package com.datasupermacy.recruit_cat.service;

import com.datasupermacy.recruit_cat.entity.PersonalRecommend;

import java.util.List;

public interface PersonalRecommendService {
    List<PersonalRecommend> getUserHotJob();
    void delPer();
}
