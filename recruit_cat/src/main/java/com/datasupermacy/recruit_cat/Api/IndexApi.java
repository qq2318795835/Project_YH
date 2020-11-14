package com.datasupermacy.recruit_cat.Api;

import com.datasupermacy.recruit_cat.My1.RecommendController;
import com.datasupermacy.recruit_cat.entity.Corp;
import com.datasupermacy.recruit_cat.entity.Job;
import com.datasupermacy.recruit_cat.entity.PersonalRecommend;
import com.datasupermacy.recruit_cat.entity.Recommend;
import com.datasupermacy.recruit_cat.service.CorpService;
import com.datasupermacy.recruit_cat.service.JobService;
import com.datasupermacy.recruit_cat.service.PersonalRecommendService;
import com.datasupermacy.recruit_cat.service.RecommendService;
import com.datasupermacy.recruit_cat.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/Api/index")
public class IndexApi {
    @Autowired
    JobService jobService;
    @Autowired
    CorpService corpService;
    @Autowired
    RecommendService recommendService;
    @Autowired
    PersonalRecommendService personalRecommendService;


    @GetMapping("/Search")
    public ResponseEntity SearchByKey(String content,@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "8") int pageSize){
       Page<Job> jobList = jobService.searchJobs(content,pageNum,pageSize);
       Page<Corp> corpList = corpService.searchCorps(content,pageNum,pageSize);
       if (jobList!=null&&!jobList.isEmpty()){
           return new ResponseEntity(1,jobList);
       }else if (corpList!=null&&!corpList.isEmpty()){
           return new ResponseEntity(1,corpList);
       }
       return new ResponseEntity(-1,"无任何信息");
    }


    //缺少热门企业和热门工作，大数据相关，后面补

    @GetMapping("/hotJob")
    public ResponseEntity HotJob() throws Exception {

        List<Recommend> list = recommendService.getReTop10();
        List<Job> hotJob = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            hotJob.add(jobService.getJobById(Integer.parseInt(list.get(i).getJid())));
        }
        if (hotJob!=null&&!hotJob.isEmpty()){
            return new ResponseEntity(1,hotJob);
        }
        return new ResponseEntity(-1,"没有找到任何信息");
    }

    @GetMapping("/userHotJob")
    public ResponseEntity UserHotJob(){
        List<PersonalRecommend> list = personalRecommendService.getUserHotJob();
        List<Job> userHotJob = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            userHotJob.add(jobService.getJobById(Integer.parseInt(list.get(i).getJid())));
        }
        if (userHotJob!=null&&!userHotJob.isEmpty()){
            return  new ResponseEntity(1,userHotJob);
        }
        return new ResponseEntity(-1,"未找到任何信息");
    }


}