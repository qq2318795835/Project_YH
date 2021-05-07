package cn.datasupermacy.controller;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.entity.StoreHouse;
import cn.datasupermacy.service.StoreHouseService;
import cn.datasupermacy.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
//@CrossOrigin(origins = "http://81.70.152.49:8081")
@RestController
@RequestMapping("/StoreHouse")
public class StoreHouseController {
    @Autowired
    StoreHouseService storeHouseService;

    @GetMapping("/houseList")
    public ResponseEntity findAllHouse(){
        List<StoreHouse> list = storeHouseService.findAllHouse();
        if (list!=null){
            return new ResponseEntity(1,list);
        }
        return new ResponseEntity(-1,"无任何信息！！！");
    }

    @GetMapping("/oneHouse")
    public ResponseEntity findHouseById(Integer sid){
        if (sid!=null){
            StoreHouse house = storeHouseService.findStoreHouseById(sid);
            if (house!=null){
                return new ResponseEntity(1,house);
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"sid为空！！！");
    }

    @PutMapping("/addStoreHouse")
    public ResponseEntity addStoreHouse(@RequestBody StoreHouse storeHouse){
        if (storeHouse!=null){
            if (storeHouseService.addStoreHouse(storeHouse)>0){
                return new ResponseEntity(1,"添加成功！！！");
            }
            return new ResponseEntity(-1,"添加失败！！！");
        }
        throw new DcrepException(0,"storeHouse为空！！！");
    }

    @PostMapping("/delStoreHouse")
    public ResponseEntity delStoreHouse(Integer sid){
        if (sid!=null){
            if (storeHouseService.delStoreHouse(sid)>0){
                return new ResponseEntity(1,"删除成功！！！");
            }
            return new ResponseEntity(-1,"删除失败！！！");
        }
        throw new DcrepException(0,"sid为空！！！");
    }

    @PutMapping("/updateStoreHouse")
    public ResponseEntity updateStoreHouse(Integer sid,@RequestBody StoreHouse storeHouse){
        if (sid!=null && storeHouse!=null){
            if (storeHouseService.updateStoreHouse(sid,storeHouse)>0){
                return new ResponseEntity(1,"更新成功！！！");
            }
            return new ResponseEntity(-1,"更新失败！！！");
        }
        throw new DcrepException(0,"sid/storeHouse为空！！！");
    }
}
