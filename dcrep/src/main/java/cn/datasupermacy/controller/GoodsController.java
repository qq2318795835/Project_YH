package cn.datasupermacy.controller;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.entity.Goods;
import cn.datasupermacy.service.GoodsService;
import cn.datasupermacy.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/Goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/goodsList")
    public ResponseEntity findAllGoods(){
        List<Goods> list = goodsService.findAllGoods();
        if (list!=null){
            return new ResponseEntity(1,list);
        }
        return new ResponseEntity(-1,"无任何信息！！！");
    }

    @GetMapping("/oneGoods")
    public ResponseEntity findGoodsById(Integer gid){
        if (gid!=null){
            Goods goods = goodsService.findGoodsById(gid);
            if (goods!=null){
                return new ResponseEntity(1,goods);
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"gid为空！！！");
    }

    @GetMapping("/oneGoods2")
    public ResponseEntity findGoodsByName(String gname){
        if (gname!=null){
            Goods goods = goodsService.findGoodsByName(gname);
            if (goods!=null){
                return new ResponseEntity(1,goods);
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"gname为空");
    }

    @PostMapping("/delGoods")
    public ResponseEntity delGoods(Integer gid){
        if (gid!=null){
            if (goodsService.delGoods(gid)>0){
                return new ResponseEntity(1,"删除成功！！！");
            }
            return new ResponseEntity(-1,"删除失败！！！");
        }
        throw new DcrepException(0,"gid为空！！！");
    }
    @PostMapping("/delGoodsList")
    public ResponseEntity delGoodsList(@RequestBody List<Goods> list){
        if (list.size()>0){
            List<Integer> numberList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                numberList.add(list.get(i).getGid());
            }
            if (numberList!=null){
                for (int i = 0; i < numberList.size(); i++) {
                    goodsService.delGoods(numberList.get(i));
                }
                return new ResponseEntity(1,"批量删除成功！！！");
            }
        }
        throw new DcrepException(0,"list入参为空！！！");
    }

    @PostMapping("/addGoods")
    public ResponseEntity addGoods(@RequestBody Goods goods){
        if (goods!=null){
            if (goodsService.addGoods(goods)>0){
                return new ResponseEntity(1,"添加成功！！！");
            }
            return new ResponseEntity(-1,"添加失败！！！");
        }
        throw new DcrepException(0,"goods为空！！！");
    }

    @PutMapping("/updateGoods")
    public ResponseEntity updateGoods(Integer gid,@RequestBody Goods goods){
        if (gid!=null && goods!=null){
            if (goodsService.updatGoods(gid,goods)>0){
                return new ResponseEntity(1,"修改成功！！！");
            }
            return new ResponseEntity(-1,"修改失败！！！");
        }
        throw new DcrepException(0,"gid/goods为空！！！");
    }
}
