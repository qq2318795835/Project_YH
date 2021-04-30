package cn.datasupermacy.controller;

import cn.datasupermacy.Exceptions.UserException;
import cn.datasupermacy.entity.User;
import cn.datasupermacy.service.DeptService;
import cn.datasupermacy.service.UserService;
import cn.datasupermacy.util.JwtUtil;
import cn.datasupermacy.util.LoginedUser;
import cn.datasupermacy.util.ResponseEntity;
import cn.datasupermacy.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/User")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private DeptService deptService;

    @PostMapping("/doLogin")
    public LoginedUser login(String uloginName, String upass, HttpServletResponse response) {
        User user = userService.login(uloginName, upass);
        if (user != null) {
            String token = JwtUtil.sign(uloginName, upass);
            if (token != null) {
                response.setHeader("authorization", token);
                stringRedisTemplate.opsForValue().set(user.getUloginname(), token, 12, TimeUnit.HOURS);
                return new LoginedUser(1, "token认证成功", token, user);
            } else {
                return new LoginedUser(-2, "token认证失败");
            }
        }
        return new LoginedUser(-1, "无任何信息");
    }

    @PostMapping("/outLogin")
    public void outLogin(boolean out, String token) {
        String uloginname = JwtUtil.getuloginnameByToken2(token);
        if (out) {
            stringRedisTemplate.delete(uloginname);
        }
    }

    @GetMapping("/userList")
    public ResponseEntity findAllUser() {
        List<User> users = userService.findAllUser();
        if (users != null) {
            return new ResponseEntity(1, users);
        } else
            throw new UserException(0, "users为空");
    }

    @GetMapping("/oneUser")
    public ResponseEntity findUserById(Integer uid) {
        if (uid != null) {
            User user = userService.findById(uid);
            return new ResponseEntity(1, user);
        } else
            throw new UserException(0, "uid为空!");
    }

    @GetMapping("/oneUser1")
    public ResponseEntity findUserByName(String uloginName) {
        if (uloginName != null && !uloginName.isEmpty()) {
            User user = userService.findByUlogname(uloginName);
            if (user != null) {
                return new ResponseEntity(1, user);
            } else {
                throw new UserException(-1, "User为空");
            }
        } else {
            throw new UserException(0, "uloginName为空");
        }
    }

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody User user) {
        if (user != null) {
            user.setUhiredate(new Timestamp(System.currentTimeMillis()));
            if (userService.addUser(user) > 0) {
                return new ResponseEntity(1, "添加成功!");
            } else {
                return new ResponseEntity(-1, "添加失败!");
            }
        } else {
            throw new UserException(0, "user为空!");
        }
    }

    @PostMapping("/delUser")
    public ResponseEntity delUser(Integer uid) {
        if (uid != null) {
            userService.delUser(uid);
            return new ResponseEntity(1, "删除成功!");
        } else
            throw new UserException(0, "uid为空!");
    }

    @PutMapping("/updateUser")
    public ResponseEntity update(Integer uid, @RequestBody User user) {
        if (uid != null && user != null) {
            if (userService.updateUserSelective(uid, user) > 0) {
                return new ResponseEntity(1, "更新成功!");
            } else
                return new ResponseEntity(-1, "更新失败!");
        } else
            throw new UserException(0, "uid/user为空");
    }

    @GetMapping("/getUserUtils")
    public ResponseEntity getAllUserUtils() {
        List<UserUtil> userUtils = new ArrayList<>();
        List<User> users = userService.findAllUser();
        if (users != null) {

        for (User user : users) {
            UserUtil userUtil = new UserUtil();
            userUtil.setUid(user.getUid());
            userUtil.setUname(user.getUname());
            userUtil.setUloginName(user.getUloginname());
            userUtil.setUremark(user.getUremark());
            userUtil.setDeptName(deptService.findDeptById(user.getDid()).getDtitle());
            userUtil.setUaddress(user.getUaddress());
            userUtil.setUmgr(userService.findById(user.getUmgr()).getUname());
            userUtils.add(userUtil);
        }
        if (userUtils != null) {
            return new ResponseEntity(1, userUtils);
        }
        return new ResponseEntity(-1, "无任何信息!");
        }
        throw new UserException(0,"users为空！！！");
    }


    @GetMapping("/getUserUtilById")
    public ResponseEntity getUserUtilById(Integer uid) {
        if (uid != null) {
            UserUtil userUtil = userService.getAllUserUtilById(uid);
            if (userUtil != null) {
                return new ResponseEntity(1, userUtil);
            }
        }
        throw new UserException(0, "uid为空");
    }

    @PutMapping("/updateUserUtil")
    public ResponseEntity updateUserUtil(Integer uid, @RequestBody UserUtil userUtil){
        if (uid != null && userUtil != null){
            User user = new User();
            user.setUname(userUtil.getUname());
            user.setUremark(userUtil.getUremark());
            user.setDid(deptService.findDeptByName(userUtil.getDeptName()).getDid());
            user.setUmgr(userService.findByUname(userUtil.getUmgr()).getUid());
            if (user!=null){
                if (userService.updateUserSelective(uid,user)>0){
                    return new ResponseEntity(1, "更新成功!");
                }else
                    return new ResponseEntity(-1, "更新失败!");
            }
        }
        throw new UserException(0, "uid/user为空");
    }

    @PostMapping("/addUserUtil")
    public ResponseEntity addUserUtil(@RequestBody UserUtil userUtil){
        if (userUtil!=null){
            User user = new User();
            user.setUname(userUtil.getUname());
            user.setUloginname(userUtil.getUloginName());
            user.setUpwd(userUtil.getUpwd());
            user.setUremark(userUtil.getUremark());
            user.setUaddress(userUtil.getUaddress());
            user.setDid(deptService.findDeptByName(userUtil.getDeptName()).getDid());
            user.setUmgr(userService.findByUname(userUtil.getUmgr()).getUid());
            user.setUhiredate(new Timestamp(System.currentTimeMillis()));
            if (userService.addUserSelective(user)>0){
                return new ResponseEntity(1,"添加成功!");
            }else
                return new ResponseEntity(-1,"添加失败!!!");
        }
        throw new UserException(0,"userUtil为空");
    }
}
