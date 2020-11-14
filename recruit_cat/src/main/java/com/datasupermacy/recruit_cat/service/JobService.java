package com.datasupermacy.recruit_cat.service;
import com.datasupermacy.recruit_cat.entity.Job;
import org.springframework.data.domain.Page;

import java.util.List;

public interface JobService {
    List<Job> getAllJobs();

    Page<Job> getJobsByJtype(String jtype,int pageNum, int pageSize);

    Page<Job> getJobByCid(Integer Cid,int pageNum, int pageSize);

    Job getJobById(Integer Jid);

    int addJob(Job job);

    int updateJob(Job job);

    int deleteJobById(Integer Jid);

    Page<Job> getJobByPaging(int pageNum,int pageSize);

    Page<Job> searchJobs(String key,int pageNum,int pageSize);

}
