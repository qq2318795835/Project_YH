package cn.datasupermacy;

import cn.datasupermacy.controller.DeptController;
import cn.datasupermacy.controller.UserController;
import cn.datasupermacy.dao.DeptMapper;
import cn.datasupermacy.dao.GoodsMapper;
import cn.datasupermacy.entity.Dept;
import cn.datasupermacy.entity.User;
import cn.datasupermacy.service.impl.DeptServiceImpl;
import cn.datasupermacy.service.impl.UserServiceImpl;
import cn.datasupermacy.util.JwtUtil;
import cn.datasupermacy.util.TreeUtil;
import cn.datasupermacy.util.UserUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@SpringBootTest
class DcrepApplicationTests {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private DeptServiceImpl deptService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private DeptController deptController;

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private UserController userController;

    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void findAllUser(){
        List<User> users = userService.findAllUser();
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
    }

    @Test
    void addUser(){
        User user = new User();
        user.setUname("张三");
        user.setUloginname("zhangsan");
        user.setUsex(1);
        user.setUpwd("123456");
        userService.addUserSelective(user);
    }
    @Test
    void updateUser(){
        User user = new User();
        user.setUsex(1);
        user.setUpwd("123123");
        user.setUaddress("北京");
        userService.updateUserSelective(8,user);
    }

    @Test
    void findUserById(){
        System.out.println(userService.findById(1));
    }

    @Test
    void delUser(){
        userService.delUser(8);
    }

    @Test
    void login(){
        System.out.println(userService.login("system","532ac00e86893901af5f0be6b704dbc7"));
    }

    @Test
    void findAllDept(){
        System.out.println(deptService.findAllDept());
    }

    @Test
    void findDeptById(){
        System.out.println(deptService.findDeptById(9));
    }

    @Test
    void findDeptByName(){
        System.out.println(deptService.findDeptByName("总经办"));
    }

    @Test
    void findDeptByDpid(){
        System.out.println(deptService.findDeptByDpid(1));
    }

    @Test
    void findDeptByAddress(){
        System.out.println(deptService.findDeptByAddress("武汉"));
    }

    @Test
    void addDept(){
        Dept dept = new Dept();
        dept.setDpid(4);
        dept.setDtitle("生产二部");
        dept.setDaddress("北京");
        dept.setDavailable(1);
        dept.setDremark("demark");
        deptService.addDeptSelective(dept);
    }

    @Test
    void updateDeptSelective(){
        Dept dept = new Dept();
        dept.setDtitle("生产三部111");
        dept.setDavailable(0);
        dept.setDremark("生产主力");
        deptService.updateDeptSelective(28,dept);
    }

    @Test
    void delDept(){
        deptService.delDept(20);
    }

    @Test
    void test() throws InterruptedException {
        //添加key为name，value为lisi的数据，该数据6秒后过期
        /**
         *	参数1：key值
         *	参数2：value值
         *	参数3：过期时间
         *	参数4：时间单位
         */
        redisTemplate.opsForValue().set("id","wangwu",20, TimeUnit.SECONDS);
        //从数据库中获取对应key的value
        String value = redisTemplate.opsForValue().get("id");
        System.out.println(value);
    }

    @Test
    void getuloginnameByToken2(){
        System.out.println(JwtUtil.getuloginnameByToken2("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MTUxMDY2NTAsInVsb2dpbm5hbWUiOiJzeXN0ZW0ifQ.8z0Id70R89FXcBnZ68sjgq4LXbujoNI727Zoe6AtkoM"));
    }

    @Test
    public void getDeptTree(){
        System.out.println(deptController.getDeptTree());
    }

    @Test
    public void selectByPrimaryKey(){
        System.out.println(deptMapper.selectByPrimaryKey(9));
    }

    @Test
    public void getUserUtils(){
        System.out.println(userController.getAllUserUtils());
    }

    @Test
    public void findUserUtilById(){
        System.out.println(userService.getAllUserUtilById(1));
    }

    @Test
    public void delUserUserUtilById(){
        userController.delUser(6);
    }

    @Test
    public void updateUserUtilById(){
        UserUtil userUtil = new UserUtil();
        userUtil.setUname("三笠");
        userUtil.setUremark("王的仆人");
        userUtil.setDeptName("销售一部");
        userUtil.setUmgr("王五");
        userController.updateUserUtil(5,userUtil);
    }

    @Test
    public  void addUserUtil(){
        UserUtil userUtil = new UserUtil();
        userUtil.setUname("阿尔敏");
        userUtil.setUloginName("aermin");
        userUtil.setUpwd("123456");
        userUtil.setUremark("超大巨人");
        userUtil.setUaddress("艾尔迪亚");
        userUtil.setDeptName("运营部");
        userUtil.setUmgr("李四");
        userController.addUserUtil(userUtil);
    }

    @Test
    public void getGoodsById(){
        System.out.println(goodsMapper.selectByPrimaryKey(2));
    }

}
