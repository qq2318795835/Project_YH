package com.datasupermacy.recruit_cat.service.impl;

import com.datasupermacy.recruit_cat.dao.CorpDao;
import com.datasupermacy.recruit_cat.dao.FavoritesListDao;
import com.datasupermacy.recruit_cat.dao.JobDao;
import com.datasupermacy.recruit_cat.entity.FavoritesList;
import com.datasupermacy.recruit_cat.entity.Job;
import com.datasupermacy.recruit_cat.service.FavoritesListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    @Autowired
    CorpDao corpDao;

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
    public List<FavoritesList> getListByUid(Integer Uid,int pageNum,int pageSize) {
        Specification<FavoritesList> specification =new Specification<FavoritesList>() {
            @Override
            public Predicate toPredicate(Root<FavoritesList> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate p =criteriaBuilder.equal(root.get("uid"),Uid);
                return p;
            }
        };
        Pageable pb = PageRequest.of(pageNum-1,pageSize);
        Page<FavoritesList> page = favoritesListDao.findAll(specification,pb);
        return page.getContent();
    }

    @Transactional
    @Override
    public int addToList(Integer Jid, Integer Uid) {
        int result = 0;
        FavoritesList favoritesList = favoritesListDao.findByJidAndUid(Jid,Uid);

        if (favoritesList==null){
            Optional<Job>o = jobDao.findById(Jid);
            Job job = o.get();
            favoritesList = new FavoritesList();
            favoritesList.setUid(Uid);
            favoritesList.setJid(job.getJid());
            favoritesList.setJname(job.getJname());
            favoritesList.setJsal(job.getJsal());
            favoritesList.setCid(job.getCid());
            favoritesList.setCname(corpDao.findByCid(job.getCid()).getCname());
            favoritesList.setFupdateTime(new Timestamp(System.currentTimeMillis()));
            if (favoritesListDao.save(favoritesList)!=null){
                result = 1;
            }
        }

        return result;
    }

    @Transactional
    @Override
    public int delListItem(Integer Jid,Integer Uid) {
        if (favoritesListDao.findByJidAndUid(Jid,Uid)!=null){
            return favoritesListDao.deleteByJidAndUid(Jid,Uid);
        }
        return 0;
    }
}
