package com.datasupermacy.recruit_cat.Api;

import com.datasupermacy.recruit_cat.entity.Corp;
import com.datasupermacy.recruit_cat.entity.Job;
import com.datasupermacy.recruit_cat.service.CorpService;
import com.datasupermacy.recruit_cat.service.JobService;
import com.datasupermacy.recruit_cat.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/Api/index")
public class IndexApi {
    @Autowired
    JobService jobService;
    @Autowired
    CorpService corpService;


    @GetMapping("/Search/{content}")
    public ResponseEntity SearchByKey(@PathVariable(name = "content") String content,@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "8") int pageSize){
       List<Job> jobList = jobService.searchJobs(content,pageNum,pageSize);
       List<Corp> corpList = corpService.searchCorps(content,pageNum,pageSize);
       if (jobList!=null&&!jobList.isEmpty()){
           return new ResponseEntity(1,jobList);
       }else if (corpList!=null&&!corpList.isEmpty()){
           return new ResponseEntity(1,corpList);
       }
       return new ResponseEntity(-1,"无任何信息");
    }


    //缺少热门企业和热门工作，大数据相关，后面补



}