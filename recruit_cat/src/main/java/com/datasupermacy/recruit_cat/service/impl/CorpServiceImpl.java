package com.datasupermacy.recruit_cat.service.impl;

import com.datasupermacy.recruit_cat.dao.CorpDao;
import com.datasupermacy.recruit_cat.entity.Corp;
import com.datasupermacy.recruit_cat.service.CorpService;
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
import java.util.List;
import java.util.Optional;

@Service
public class CorpServiceImpl implements CorpService {
    @Autowired
    CorpDao corpDao;

    @Override
    public Corp getCorpById(Integer Cid) {
        Optional<Corp> o = corpDao.findById(Cid);
        if (o.isPresent()){
            return o.get();
        }
        return null;
    }

    @Override
    public Corp getCorpByName(String Cname) {
        return corpDao.findByCname(Cname);
    }

    @Override
    public Corp login(String Caccount, String Cpass) {
        Corp corp = corpDao.findByCnameOrCphone(Caccount,Cpass);
        if (corp!=null){
            if (corp.getCpass().equals(Cpass)){
                return corp;
            }
        }
        return null;
    }

    @Override
    public List<Corp> getAllCorps() {
        return corpDao.findAll();
    }

    @Override
    public Page<Corp> getCorpByPaging(int pageNum, int pageSize) {
        PageRequest pb = PageRequest.of(pageNum-1,pageSize);
        Page<Corp> page = corpDao.findAll(pb);
        return page;
    }

    @Override
    public Page<Corp> searchCorps(String key, int pageNum, int pageSize) {
        Specification<Corp> specification = new  Specification<Corp>(){
            @Override
            public Predicate toPredicate(Root<Corp> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate p =criteriaBuilder.or(criteriaBuilder.like(root.get("cname"),"%"+key+"%"));
                return p;
            }
        };
        Pageable pb = PageRequest.of(pageNum-1,pageSize);
        Page<Corp> page = corpDao.findAll(specification,pb);
        return page;
    }

    @Transactional
    @Override
    public int addCorp(Corp corp) {
        if (corpDao.save(corp)!=null){
            return 1;
        }
        return 0;
    }

    @Transactional
    @Override
    public int updateCorp(Corp corp) {
        Corp corp1 = getCorpById(corp.getCid());
        if (corp1.getCid().equals(corp.getCid())){
            corpDao.save(corp);
            return 1;
        }
        return 0;
    }


    @Transactional
    @Override
    public int deleteCorp(Integer Cid) {
        corpDao.deleteById(Cid);
        return 1;
    }
}
