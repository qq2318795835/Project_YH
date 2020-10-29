package com.datasupermacy.recruit_cat;

import com.datasupermacy.recruit_cat.entity.Corp;
import com.datasupermacy.recruit_cat.entity.Job;
import com.datasupermacy.recruit_cat.entity.User;
import com.datasupermacy.recruit_cat.service.CorpService;
import com.datasupermacy.recruit_cat.service.JobService;
import com.datasupermacy.recruit_cat.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class RecruitCatApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private CorpService corpService;
    @Autowired
    private JobService  jobService;

    @Test
    void contextLoads() {
    }
    @Test
    public void login(){
        userService.login("李四","123456");
    }

    @Test
    public void loginC(){
        corpService.login("DataSupermacy","123456");
    }

    @Test
    public void getJobsByJtype(){
        jobService.getJobsByJtype("后端开发",1,5);
    }

    @Test
    public void searchJobs(){
        jobService.searchJobs("开发",1,5);
        System.out.println(jobService.searchJobs("开发",1,5));
    }
    @Test
    public void getJobById(){
        jobService.getJobById(2);
    }


    @Test
    public  void updateJob(){
        Job job = new Job();
        job.setJid(4);
        job.setJname("c++");
        job.setJtype("游戏引擎相关");
        job.setJdescribe("亲手打造一款畅销榜首的手游产品。");
        job.setJsal("15k");
        job.setJtreatment("五险一金,补充医疗保险,定期体检,年终奖");
        job.setJaddress("深圳");
        job.setCid(3);
        job.setJupdateTime(new Date(System.currentTimeMillis()));
        jobService.updateJob(job);
    }

    @Test
    public void getCorpById(){
        Corp corp = corpService.getCorpById(2);
        System.out.println(corp.getCid());
        System.out.println(corp.getCname());
    }

    @Test
    public void getCorpByName(){
        corpService.getCorpByName("宏深资本");
    }

    @Test
    public void deleteJobById(){
        jobService.deleteJobById(1);
    }

    @Test
    public void deleteJob(){
        int Jid = 16;
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

                System.out.println(jidList.toString().replaceAll("(?:\\[|null|\\]| +)", ""));
                System.out.println(jnameList.toString().replaceAll("(?:\\[|null|\\]| +)", ""));

                corp.setJid(jidList.toString().replaceAll("(?:\\[|null|\\]| +)", ""));
                corp.setJname(jnameList.toString().replaceAll("(?:\\[|null|\\]| +)", ""));

                corpService.updateCorp(corp);
                jobService.deleteJobById(Jid);

            }

        }


    }

    @Test
    public void delCorp(){
        int Cid = 3;
        if (corpService.getCorpById(Cid)!=null){
            Corp corp = corpService.getCorpById(Cid);
            List<String> list = Arrays.asList(corp.getJid().split(","));
            List<String> jidList = new ArrayList<String>(list);

            for (int i = 1; i < jidList.size(); i++) {
                System.out.println(Integer.valueOf(StringUtils.isNotEmpty(jidList.get(i))?jidList.get(i):"0"));
                jobService.deleteJobById(Integer.valueOf(StringUtils.isNotEmpty(jidList.get(i))?jidList.get(i):"0"));
            }
            corpService.deleteCorp(Cid);
        }
    }

    @Test
    public void updateUser(){
        User user= new User();
        user.setUid(1);
        user.setUname("王五");
        user.setUphone("18202223082");
        userService.updateUser(user);
    }

    @Test
    public void getUserById(){
        User user = userService.getUserById(2);
        System.out.println(user.getUid());
        System.out.println(user.getUname());
    }

    @Test
    public void getUserByPhone(){
        User user = userService.getUserByPhone("18202223082");
        System.out.println(user.getUid());
        System.out.println(user.getUname());
        System.out.println(user.getUphone());
    }

    @Test
    public void getUserByPaging(){
        userService.getUserByPaging(1,3);
    }

    @Test
    public void addUser(){
        User user = new User();
        user.setUname("赵六");
        user.setUgender("男");
        user.setUphone("15714873679");
        user.setUpass("123456");

        userService.addUser(user);
    }

    @Test
    public void deleteUser(){
        userService.deleteUser(3);
    }


}
