package com.datasupermacy.recruit_cat.Api;

import com.datasupermacy.recruit_cat.entity.Job;
import com.datasupermacy.recruit_cat.service.CorpService;
import com.datasupermacy.recruit_cat.service.JobService;
import com.datasupermacy.recruit_cat.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/Api/PostListApi")
public class PostListApi {
    @Autowired
    JobService jobService;
    @Autowired
    CorpService corpService;


    @GetMapping("JobList")
    public ResponseEntity getJobByCid(Integer Cid, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize){
        Page<Job> page = jobService.getJobByCid(Cid,pageNum,pageSize);
        if (page!=null&&!page.isEmpty()){
            return new ResponseEntity(1,page);
        }
        return new ResponseEntity(-1,"未找到发布job");
    }

}
