package com.datasupermacy.recruit_cat.Api;

import com.datasupermacy.recruit_cat.entity.Corp;
import com.datasupermacy.recruit_cat.entity.Job;
import com.datasupermacy.recruit_cat.service.CorpService;
import com.datasupermacy.recruit_cat.service.JobService;
import com.datasupermacy.recruit_cat.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/Api/Job")
public class JobApi {
    @Autowired
    JobService jobService;
    @Autowired
    CorpService corpService;

    @GetMapping("/")
    public ResponseEntity getJobByPaging(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize){
        Page<Job> page = jobService.getJobByPaging(pageNum,pageSize);
        if (page!=null&&!page.isEmpty()){
            return new ResponseEntity(1,page);
        }
        return new ResponseEntity(-1,"没有信息");
    }

    @GetMapping("/{jid}")
    public ResponseEntity getJobById(@PathVariable(name = "jid") Integer jid){
        Job job =jobService.getJobById(jid);
        if (job!=null){
            return new ResponseEntity(1,job);
        }
        return new ResponseEntity(-1,"没有job信息");
    }

    @GetMapping("/GetJobByJtype/{jtype}")
    public ResponseEntity GetJobByJtype(@PathVariable(name = "jtype") String jtype,@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "8") int pageSize){
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

    @DeleteMapping("/delJob/{Jid}")
    public ResponseEntity delJob(@PathVariable(name = "Jid") Integer Jid){
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

}
