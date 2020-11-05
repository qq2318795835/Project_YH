package com.datasupermacy.recruit_cat.service.impl;

import com.datasupermacy.recruit_cat.dao.JobDao;
import com.datasupermacy.recruit_cat.entity.Job;
import com.datasupermacy.recruit_cat.service.JobService;
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
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    JobDao jobDao;

    @Override
    public List<Job> getAllJobs() {
        return jobDao.findAll();
    }

    @Override
    public Page<Job> getJobsByJtype(String Jtype,int pageNum, int pageSize) {
        PageRequest pb = PageRequest.of(pageNum-1,pageSize);
        Page<Job> page = jobDao.findByJtype(Jtype,pb);
        return page;
    }

    @Override
    public Page<Job> getJobByCid(Integer Cid, int pageNum, int pageSize) {
        Pageable pb = PageRequest.of(pageNum-1,pageSize);
        Page<Job> page = jobDao.findByCid(Cid,pb);
        return page;
    }

    @Override
    public Job getJobById(Integer Jid) {
        Optional<Job> o = jobDao.findById(Jid);
        if (o.isPresent()){
            return o.get();
        }
        return null;
    }

    @Transactional
    @Override
    public int addJob(Job job) {
        job.setJupdateTime(new Date(System.currentTimeMillis()));
        if (jobDao.save(job)!=null){

            return 1;
        }
        return 0;
    }

    @Transactional
    @Override
    public int updateJob(Job job) {
        job.setJupdateTime(new Date(System.currentTimeMillis()));
        Job job1 = getJobById(job.getJid());
            if (job1.getJid().equals(job.getJid())){
                jobDao.save(job);
                return 1;
            }
        return 0;
    }

    @Override
    public int deleteJobById(Integer Jid) {
        jobDao.deleteById(Jid);
        return 1;
    }

    @Override
    public Page<Job> getJobByPaging(int pageNum, int pageSize) {
        PageRequest pb = PageRequest.of(pageNum-1,pageSize);
        Page<Job> page = jobDao.findAll(pb);
        return page;
    }

    @Override
    public List<Job> searchJobs(String key, int pageNum, int pageSize) {
        Specification<Job> specification = new  Specification<Job>(){
            @Override
            public Predicate toPredicate(Root<Job> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate p =criteriaBuilder.or(criteriaBuilder.like(root.get("jname"),"%"+key+"%"),criteriaBuilder.like(root.get("jtype"),"%"+key+"%"));
                return p;
            }
        };
        Pageable pb = PageRequest.of(pageNum-1,pageSize);
        Page<Job> page = jobDao.findAll(specification,pb);
        return page.getContent();
    }


}
