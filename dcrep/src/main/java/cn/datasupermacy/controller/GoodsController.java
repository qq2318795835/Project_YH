package cn.datasupermacy.controller;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.entity.Goods;
import cn.datasupermacy.entity.Provider;
import cn.datasupermacy.service.GoodsService;
import cn.datasupermacy.service.ProviderService;
import cn.datasupermacy.util.GoodsUtil;
import cn.datasupermacy.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//@CrossOrigin(origins = "http://localhost:8081")
//@CrossOrigin(origins = "http://81.70.152.49:8081")
@RestController
@RequestMapping("/Goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private ProviderService providerService;

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
            String pname = providerService.findProviderById(goods.getPid()).getProvidername();
            GoodsUtil goodsUtil = new GoodsUtil(goods.getGid(),goods.getGname(),
                    goods.getProduceplace(),goods.getSize(),goods.getGpackage(),
                    goods.getProductcode(),goods.getPromitcode(),goods.getDescription(),
                    goods.getPrice(),goods.getNumber(),goods.getDangernum(),goods.getGimg(),
                    goods.getAvailable(),goods.getPid(),pname);
            if (goodsUtil!=null){
                return new ResponseEntity(1,goodsUtil);
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

    @PostMapping("/goodsListByKey")
    public ResponseEntity findGoodsByKey(String key){
        if (key!=null && !key.isEmpty()){
            List<Goods> list = goodsService.findGoodsByKey(key);
            if (list!=null){
                return new ResponseEntity(1,list);
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"key为空！！！");
    }

    @PostMapping("/goodsListByPid")
    public ResponseEntity findGoodsByPid(Integer pid){
        if (pid!=null && pid>0){
            List<Goods> list = goodsService.findGoodsByPid(pid);
            if (list!=null){
                return new ResponseEntity(1,list);
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"pid为空！！！");
    }

    @GetMapping("/providerName")
    public ResponseEntity findAllProviderName(){
        List<Provider> list = providerService.findAllProvider();
        if (list!=null){
            HashMap<Object, Object> map2 = providerService.findAllProviderName(list);
            if (map2!=null){
                return new ResponseEntity(1,map2);
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"list为空！！！");
    }

}
