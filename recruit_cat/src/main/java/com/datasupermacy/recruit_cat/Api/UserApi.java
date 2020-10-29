package com.datasupermacy.recruit_cat.Api;

import com.datasupermacy.recruit_cat.entity.User;
import com.datasupermacy.recruit_cat.service.UserService;
import com.datasupermacy.recruit_cat.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/Api/User")
public class UserApi {
    @Autowired
    UserService userService;

    @GetMapping("")
    public ResponseEntity getUserByPaging(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize){
        Page<User> page = userService.getUserByPaging(pageNum,pageSize);
        if (page!=null&&!page.isEmpty()){
            return new ResponseEntity(1,page);
        }
        return new ResponseEntity(-1,"无用户信息");
    }

    @GetMapping("/{Uid}")
    public ResponseEntity getUserById(@PathVariable(name = "Uid") Integer Uid){
        User user = userService.getUserById(Uid);
        if (user!=null){
            return new ResponseEntity(1,user);
        }
        return new ResponseEntity(-1,"未找到user");
    }

//    @PutMapping("/addUser")
//    public ResponseEntity addUser(@RequestBody User user){
//        if (userService.addUser(user)>0){
//            return new ResponseEntity(1);
//        }
//        return new ResponseEntity(-1,"添加失败");
//    }

    @PutMapping("/updateUser")
    public ResponseEntity updateUser(@RequestBody User user){
        if (userService.updateUser(user)>0){
            return new ResponseEntity(1);
        }
        return new ResponseEntity(-1,"更新失败");
    }

    @DeleteMapping("/delUser/{Uid}")
    public ResponseEntity delUser(@PathVariable(name = "Uid") Integer Uid){
        if (userService.getUserById(Uid)!=null){
            userService.deleteUser(Uid);
            return new ResponseEntity(1);
        }
        return new ResponseEntity(-1,"删除失败");
    }
}
