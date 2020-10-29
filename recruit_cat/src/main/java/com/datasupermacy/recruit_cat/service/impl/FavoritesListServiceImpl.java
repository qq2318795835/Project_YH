package com.datasupermacy.recruit_cat.service.impl;

import com.datasupermacy.recruit_cat.dao.FavoritesListDao;
import com.datasupermacy.recruit_cat.dao.JobDao;
import com.datasupermacy.recruit_cat.entity.FavoritesList;
import com.datasupermacy.recruit_cat.entity.Job;
import com.datasupermacy.recruit_cat.service.FavoritesListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class FavoritesListServiceImpl implements FavoritesListService {
    @Autowired
    FavoritesListDao favoritesListDao;
    @Autowired
    JobDao jobDao;

    @Override
    @Transactional
    public int addList(FavoritesList favoritesList) {
        if (favoritesListDao.save(favoritesList)!=null){
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteList(Integer Fid) {
        favoritesListDao.deleteById(Fid);
        return 1;
    }

    @Transactional
    @Override
    public int updateList(FavoritesList favoritesList) {
        if (favoritesListDao.save(favoritesList)!=null){
            return 1;
        }
        return 0;
    }

    @Override
    public FavoritesList getListById(Integer Fid) {
        Optional<FavoritesList> o =favoritesListDao.findById(Fid);
        if (o.isPresent()){
            return o.get();
        }
        return null;
    }

    @Override
    public List<FavoritesList> getListByUid(Integer Uid) {
        Specification<FavoritesList> specification =new Specification<FavoritesList>() {
            @Override
            public Predicate toPredicate(Root<FavoritesList> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate p =criteriaBuilder.equal(root.get("Uid"),Uid);
                return p;
            }
        };
        Sort sort = Sort.by(Sort.Order.desc("jupdateTime"));
        return favoritesListDao.findAll(specification);
    }

    @Override
    public int addToList(Integer Jid, Integer Uid) {
        int result = 0;
        FavoritesList favoritesList = favoritesListDao.findByJidAndUid(Jid,Uid);

        if (favoritesList==null){
            Optional<Job>o = jobDao.findById(Jid);
            Job job = o.get();
            favoritesList = new FavoritesList();
            favoritesList.setJname(job.getJname());
            favoritesList.setJid(job.getJid());
            favoritesList.setUid(Uid);
            favoritesList.setFupdate_time(new Timestamp(System.currentTimeMillis()));

            if (favoritesListDao.save(favoritesList)!=null){
                result = 1;
            }
        }else {
            result = 2;
        }
        return result;
    }
}
