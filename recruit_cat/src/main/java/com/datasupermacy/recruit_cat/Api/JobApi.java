package com.datasupermacy.recruit_cat.Api;

import com.datasupermacy.recruit_cat.My.PersonalRecommendController;
import com.datasupermacy.recruit_cat.My1.RecommendController;
import com.datasupermacy.recruit_cat.entity.Corp;
import com.datasupermacy.recruit_cat.entity.Job;
import com.datasupermacy.recruit_cat.service.*;
import com.datasupermacy.recruit_cat.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/Api/Job")
public class JobApi {
    @Autowired
    JobService jobService;
    @Autowired
    CorpService corpService;
    @Autowired
    FavoritesListService favoritesListService;
    @Autowired
    PersonalRecommendService per;

//    public ResponseEntity getJobAndCorpByPaging(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize){
//        List<Job> jobList = jobService.getAllJobs();
//
//
//    }

    @GetMapping("/")
    public ResponseEntity getJobByPaging(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize){
        Page<Job> page = jobService.getJobByPaging(pageNum,pageSize);
        if (page!=null&&!page.isEmpty()){
            return new ResponseEntity(1,page);
        }
        return new ResponseEntity(-1,"没有信息");
    }

    @GetMapping("/jobDetail")
    public ResponseEntity getJobById(Integer jid){
        Job job =jobService.getJobById(jid);
        if (job!=null){
            return new ResponseEntity(1,job);
        }
        return new ResponseEntity(-1,"没有job信息");
    }

    @GetMapping("/GetJobByJtype")
    public ResponseEntity GetJobByJtype(String jtype,@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "8") int pageSize){
        Page<Job> page = jobService.getJobsByJtype(jtype,pageNum,pageSize);
        if (page!=null&&!page.isEmpty()){
            return new ResponseEntity(1, page);
        }
        return new ResponseEntity(-1,"没有信息");
    }

    @PostMapping("/addJob")
    public ResponseEntity addJob(@RequestBody Job job){

        if (jobService.addJob(job)>0){
                Integer Jid = job.getJid();
                String Jname = job.getJname();
                Corp corp = corpService.getCorpById(job.getCid());
                if (corp.getCid().equals(job.getCid())){
                    StringBuffer arrayJid = new StringBuffer(corp.getJid());
                    StringBuffer arrayJname = new StringBuffer(corp.getJname());
                    arrayJid.append(",").append(Jid);
                    arrayJname.append(",").append(Jname);
                    corp.setJid(arrayJid.toString());
                    corp.setJname(arrayJname.toString());
//                    corp.setJid(corp.getJid()+","+Jid);
//                    corp.setJname(corp.getJname()+","+Jname);
                    corpService.updateCorp(corp);
                    return new ResponseEntity(1);
            }
        }
        return new ResponseEntity(-1,"添加工作失败");
    }

    @PutMapping("/updateJob")
    public ResponseEntity updateJob(@RequestBody Job job){
        if (jobService.updateJob(job)>0){
            return new ResponseEntity(1);
        }
        return new ResponseEntity(-1,"修改job失败");
    }

    @DeleteMapping("/delJob")
    public ResponseEntity delJob(Integer Jid){
        if (jobService.getJobById(Jid)!=null){
            Job job = jobService.getJobById(Jid);
            String jid = job.getJid().toString();
            String jname = job.getJname();
            Corp corp = corpService.getCorpById(job.getCid());
            if (corp.getCid().equals(job.getCid())) {

                List<String> list = Arrays.asList(corp.getJid().split(","));
                List<String> jidList = new ArrayList<String>(list);
                jidList.remove(jid);

                List<String> list2 = Arrays.asList(corp.getJname().split(","));
                List<String> jnameList = new ArrayList<String>(list2);
                jnameList.remove(jname);

                corp.setJid(jidList.toString().replaceAll("(?:\\[|null|\\]| +)", ""));
                corp.setJname(jnameList.toString().replaceAll("(?:\\[|null|\\]| +)", ""));

                corpService.updateCorp(corp);
                jobService.deleteJobById(Jid);

                return new ResponseEntity(1);
            }

        }

        return new ResponseEntity(-1,"删除失败");
    }

    @PutMapping("/{Jid}/{Uid}")
    public ResponseEntity addToList(@PathVariable(name = "Jid") Integer Jid,@PathVariable(name = "Uid") Integer Uid) throws Exception {
        if (favoritesListService.addToList(Jid,Uid)>0){
            per.delPer();
            RecommendController.hotAnalysis();
          PersonalRecommendController.PersonalRecommend();

            return new ResponseEntity(1);
        }
        return new ResponseEntity(-1,"添加失败");
    }

}
