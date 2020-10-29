package com.datasupermacy.recruit_cat.Api;

import com.datasupermacy.recruit_cat.entity.Corp;
import com.datasupermacy.recruit_cat.service.CorpService;
import com.datasupermacy.recruit_cat.service.JobService;
import com.datasupermacy.recruit_cat.util.ResponseEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/Api/Corp")
public class CorpApi {
    @Autowired
    JobService jobService;
    @Autowired
    CorpService corpService;

    @GetMapping("")
    public ResponseEntity getCorpByPaging(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize) {
        Page<Corp> page = corpService.getCorpByPaging(pageNum,pageSize);
        if (page != null && !page.isEmpty()) {
            return new ResponseEntity(1, page);
        }
        return new ResponseEntity(-1, "没有信息");
    }

    @GetMapping("/{Cid}")
    public ResponseEntity getCorpById(@PathVariable(name = "Cid") Integer Cid){
        Corp corp = corpService.getCorpById(Cid);
        if (corp!=null){
            return new ResponseEntity(1,corp);
        }
        return new ResponseEntity(-1,"没有corp信息");
    }

    @PostMapping("/addCorp")
    public ResponseEntity addCorp(@RequestBody Corp corp){
        if (corpService.addCorp(corp)>0){
            return new ResponseEntity(1);
        }
        return new ResponseEntity(-1,"添加企业失败");
    }

    @PutMapping("/updateCorp")
    public ResponseEntity updateCorp(@RequestBody Corp corp){
        if (corpService.updateCorp(corp)>0){
            return new ResponseEntity(1);
        }
        return new ResponseEntity(-1,"更新企业失败");
    }

    @DeleteMapping("/delCorp/{Cid}")
    public ResponseEntity delCorp(@PathVariable(name = "Cid") Integer Cid){
        if (corpService.getCorpById(Cid)!=null){
            Corp corp = corpService.getCorpById(Cid);
            List<String> list = Arrays.asList(corp.getJid().split(","));
            List<String> jidList = new ArrayList<String>(list);

            for (int i = 1; i < jidList.size(); i++) {
                System.out.println(Integer.valueOf(StringUtils.isNotEmpty(jidList.get(i))?jidList.get(i):"0"));
                jobService.deleteJobById(Integer.valueOf(StringUtils.isNotEmpty(jidList.get(i))?jidList.get(i):"0"));
            }
            corpService.deleteCorp(Cid);
            return new ResponseEntity(1);
        }
        return new ResponseEntity(-1,"删除失败");
    }
}
