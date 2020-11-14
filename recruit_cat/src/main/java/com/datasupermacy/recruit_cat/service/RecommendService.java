package com.datasupermacy.recruit_cat.service;

import com.datasupermacy.recruit_cat.entity.Recommend;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RecommendService {
    List<Recommend> getReTop9();
    List<Recommend> getReTop10();
}
