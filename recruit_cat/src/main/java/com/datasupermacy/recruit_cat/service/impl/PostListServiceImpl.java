package com.datasupermacy.recruit_cat.service.impl;

import com.datasupermacy.recruit_cat.dao.JobDao;
import com.datasupermacy.recruit_cat.dao.PostListDao;
import com.datasupermacy.recruit_cat.entity.Job;
import com.datasupermacy.recruit_cat.entity.PostList;
import com.datasupermacy.recruit_cat.service.PostListService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PostListServiceImpl implements PostListService {
    @Autowired
    PostListDao postListDao;
    @Autowired
    JobDao jobDao;

    @Override
    @Transactional
    public int addList(PostList postList) {
        if (postListDao.save(postList)!=null){
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteList(Integer Pid) {
        postListDao.deleteById(Pid);
        return 1;
    }

    @Override
    @Transactional
    public int updateList(PostList postList) {
        if (postListDao.save(postList)!=null){
            return 1;
        }
        return 0;
    }

    @Override
    public PostList getListById(Integer Pid) {
        Optional<PostList>o = postListDao.findById(Pid);
        if (o.isPresent()){
            return o.get();
        }
        return null;
    }

    @Override
    public List<PostList> getListByCid(Integer Cid) {
        Specification<PostList> specification = new Specification<PostList>(){
            @Override
            public Predicate toPredicate(Root<PostList> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate p = criteriaBuilder.equal(root.get("Cid"),Cid);
                return p;
            }
        };
        return null;
    }

    @Override
    public int addToList(Integer Jid, Integer Cid) {
        int result = 0;
        PostList postList = postListDao.findByJidAndCid(Jid,Cid);

        if (postList==null){
            Optional<Job>o = jobDao.findById(Jid);
            Job job = o.get();
            postList = new PostList();
            postList.setCid(Cid);
            postList.setJid(Jid);
            postList.setJname(job.getJname());
            postList.setPupdate_time(new Timestamp(System.currentTimeMillis()));

            if (postListDao.save(postList)!=null){
                result=1;
            }
        }else {
            result = 2;
        }
        return result;
    }
}
