package cn.datasupermacy.controller;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.entity.Goods;
import cn.datasupermacy.entity.Inports;
import cn.datasupermacy.entity.StoreHouse;
import cn.datasupermacy.service.GoodsService;
import cn.datasupermacy.service.InportsService;
import cn.datasupermacy.service.ProviderService;
import cn.datasupermacy.service.StoreHouseService;
import cn.datasupermacy.util.InportsUtil;
import cn.datasupermacy.util.ResponseEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;

@CrossOrigin(origins = "http://localhost:8081")
//@CrossOrigin(origins = "http://81.70.152.49:8081")
@RestController
@RequestMapping("/Inports")
public class InportsController {
    @Autowired
    private InportsService inportsService;

    @Autowired
    private StoreHouseService storeHouseService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ProviderService providerService;

    @PostMapping("/delInports")
    public ResponseEntity delInports(Integer iid){
        if (iid!=null){
            if (inportsService.delInports(iid)>0){
                return new ResponseEntity(1,"删除成功！！！");
            }
            return new ResponseEntity(-1,"删除失败！！！");
        }
        throw new DcrepException(0,"iid为空！！！");
    }

    @PostMapping("/addInports")
    public ResponseEntity addIntports(@RequestBody Inports inports){
        if (inports!=null){
            Integer sid = inports.getSid();
            Double weight = inports.getTotalweight();
            StoreHouse storeHouse = storeHouseService.findStoreHouseById(sid);
            Double margin = storeHouse.getMargin();
            if (margin>=weight){
                if (inportsService.addInports(inports)>0){
                    storeHouse.setMargin(margin - weight);
                    storeHouseService.updateStoreHouse(sid,storeHouse);
                    Goods goods = goodsService.findGoodsById(inports.getGoodsid());
                    goods.setTotalweight(goods.getTotalweight()+weight);
                    goods.setNumber(goods.getNumber()+inports.getNumber());
                    goodsService.updatGoods(inports.getGoodsid(),goods);
                    return new ResponseEntity(1,"添加入库成功！！！");
                }
                return new ResponseEntity(-1,"添加入库失败！！！");
            }
            return  new ResponseEntity(-2,"本仓库余量不足,请选择其他仓库！！！");
        }
        throw new DcrepException(0,"inports为空！！！");
    }

    @PutMapping("/updateInports")
    public ResponseEntity updateInports(Integer iid,@RequestBody Inports inports){
        if (iid!=null && inports!=null){
            Inports inports1 = inportsService.findInportsById(iid);
            if (inports.getSid() != inports1.getSid()){
                //新inports的weight
                Double weight = inports.getTotalweight();
                //之前inports的weight
                Double weight2 = inports1.getTotalweight();
                StoreHouse storeHouse = storeHouseService.findStoreHouseById(inports1.getSid());
                StoreHouse storeHouse2 = storeHouseService.findStoreHouseById(inports.getSid());
                Goods goods1 = goodsService.findGoodsById(inports.getGoodsid());
                if (weight<storeHouse2.getMargin()){
                    //更新仓库原仓库挪走货物+margin
                    storeHouse.setMargin(storeHouse.getMargin()+weight2);
                    storeHouseService.updateStoreHouse(inports1.getSid(),storeHouse);
                    //更新仓库新仓库挪来货物-margin
                    storeHouse2.setMargin(storeHouse2.getMargin()-weight);
                    storeHouseService.updateStoreHouse(inports.getSid(),storeHouse2);

                    goods1.setSid(inports.getSid());
                    goodsService.updatGoods(inports.getGoodsid(),goods1);
                }else return new ResponseEntity(-2,"仓库余量不足！！！");

            }
                //这里为什么要断掉else 不断不进if 很奇怪
                if (inports.getGoodsid() != inports1.getGoodsid()){
                    Goods goods1 = goodsService.findGoodsById(inports1.getGoodsid());
                    goods1.setNumber(goods1.getNumber()-inports1.getNumber());
                    goods1.setTotalweight(goods1.getTotalweight()-inports1.getTotalweight());
                    goodsService.updatGoods(inports1.getGoodsid(),goods1);
                    Goods goods2 = goodsService.findGoodsById(inports.getGoodsid());
                    goods2.setNumber(goods2.getNumber()+inports.getNumber());
                    goods2.setTotalweight(goods2.getTotalweight()+inports.getTotalweight());
                    goodsService.updatGoods(inports.getGoodsid(),goods2);
                }
                    if (inports.getTotalweight() != inports1.getTotalweight()){
                        //更新的货物重量
                        Double weight = inports.getTotalweight();
                        //之前的货物重量
                        Double weight2 = inports1.getTotalweight();
                        StoreHouse storeHouse = storeHouseService.findStoreHouseById(inports1.getSid());
                        if (storeHouse.getMargin()+weight2>weight){
                            storeHouse.setMargin(storeHouse.getMargin()+weight2-weight);
                            storeHouseService.updateStoreHouse(inports.getSid(),storeHouse);

                            Goods goods1 = goodsService.findGoodsById(inports1.getGoodsid());
                            goods1.setTotalweight(goods1.getTotalweight()-weight2+weight);
                            goodsService.updatGoods(inports1.getGoodsid(),goods1);
                    }
                    else return new ResponseEntity(-2,"仓库余量不足！！！");
                }
                     if (inports.getNumber() != inports1.getNumber()){
                        Goods goods = goodsService.findGoodsById(inports1.getGoodsid());
                        goods.setNumber(goods.getNumber()-inports1.getNumber()+inports.getNumber());
                        goodsService.updatGoods(inports1.getGoodsid(),goods);
                }
            if (inportsService.updateInports(iid,inports)>0) {
                return new ResponseEntity(1, "修改成功！！！");
            }
            return new ResponseEntity(-1,"修改失败！！！");
        }
        throw new DcrepException(0,"iid/inports为空！！！");
    }

    @GetMapping("/inportsList")
    public ResponseEntity findAllInports(){
        List<Inports> list = inportsService.findAllInports();
        if (list!=null){
            return new ResponseEntity(1,list);
        }
        return new ResponseEntity(-1,"无任何信息！！！");
    }

    @GetMapping("/inportsUtils")
    public ResponseEntity findAllInports2(){
        List<Inports> list = inportsService.findAllInports();
        if (list!=null){
            List<InportsUtil> inportsUtils = new ArrayList<>();
            for (Inports inports : list) {
                InportsUtil inportsUtil = new InportsUtil();
                inportsUtil.setIid(inports.getIid());
                inportsUtil.setPaytype(inports.getPaytype());
                inportsUtil.setInporttime(inports.getInporttime());
                inportsUtil.setOperateperson(inports.getOperateperson());
                inportsUtil.setNumber(inports.getNumber());
                inportsUtil.setTotalweight(inports.getTotalweight());
                inportsUtil.setRemark(inports.getRemark());
                inportsUtil.setInportprice(inports.getInportprice());
                inportsUtil.setPid(inports.getProviderid());
                inportsUtil.setGid(inports.getGoodsid());
                inportsUtil.setSid(inports.getSid());
                inportsUtil.setOutportinfo(inports.getOutportinfo());
                inportsUtil.setGname(goodsService.findGoodsById(inports.getGoodsid()).getGname());
                inportsUtil.setPname(providerService.findProviderById(inports.getProviderid()).getProvidername());
                inportsUtil.setSname(storeHouseService.findStoreHouseById(inports.getSid()).getSname());
                inportsUtils.add(inportsUtil);
            }
            if (inportsUtils!=null){
                return new ResponseEntity(1,inportsUtils);
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"list为空！！！");
    }

    @GetMapping("/oneInports")
    public ResponseEntity findInportsById(Integer iid){
        if (iid!=null){
            Inports inports = inportsService.findInportsById(iid);
            String pname = providerService.findProviderById(inports.getProviderid()).getProvidername();
            String gname = goodsService.findGoodsById(inports.getGoodsid()).getGname();
            String sname = storeHouseService.findStoreHouseById(inports.getSid()).getSname();
            InportsUtil inportsUtil = new InportsUtil(inports.getIid(),inports.getPaytype(),
                    inports.getInporttime(),inports.getOperateperson(),inports.getNumber(),
                    inports.getRemark(),inports.getInportprice(),inports.getProviderid(),
                    pname,inports.getGoodsid(),sname,inports.getSid(),gname,inports.getTotalweight(),inports.getOutportinfo());
            if (inportsUtil!=null){
                return new ResponseEntity(1,inportsUtil);
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"iid为空！！！");
    }

    @GetMapping("/oneInports2")
    public ResponseEntity findInportsById2(Integer iid){
        if (iid!=null){
            Inports inports = inportsService.findInportsById(iid);
            if (inports!=null){
                return new ResponseEntity(1,inports);
            }
            return new ResponseEntity(-1,"无任何信息");
        }
        throw new DcrepException(0,"iid为空！！！");
    }

    @PostMapping ("/InportsListByOname")
    public ResponseEntity findInportsByOname(String oname){
        if (oname!=null && !oname.isEmpty()){
            List<Inports> list = inportsService.findInportsByOname(oname);
            if (list!=null){
                return new ResponseEntity(1,list);
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"oname为空！！！");
    }

    @PostMapping("/inportsListByGid")
    public ResponseEntity findInportsByGid(Integer gid){
        List<InportsUtil> inportsUtils = new ArrayList<>();
        if (gid!=null){
            List<Inports> list = inportsService.findInportsByGid(gid);
            if (list!=null){
                for (Inports inports : list) {
                    InportsUtil inportsUtil = new InportsUtil();
                    inportsUtil.setIid(inports.getIid());
                    inportsUtil.setPaytype(inports.getPaytype());
                    inportsUtil.setInporttime(inports.getInporttime());
                    inportsUtil.setOperateperson(inports.getOperateperson());
                    inportsUtil.setNumber(inports.getNumber());
                    inportsUtil.setTotalweight(inports.getTotalweight());
                    inportsUtil.setRemark(inports.getRemark());
                    inportsUtil.setInportprice(inports.getInportprice());
                    inportsUtil.setPid(inports.getProviderid());
                    inportsUtil.setGid(inports.getGoodsid());
                    inportsUtil.setSid(inports.getSid());
                    inportsUtil.setGname(goodsService.findGoodsById(inports.getGoodsid()).getGname());
                    inportsUtil.setPname(providerService.findProviderById(inports.getProviderid()).getProvidername());
                    inportsUtil.setSname(storeHouseService.findStoreHouseById(inports.getSid()).getSname());
                    inportsUtils.add(inportsUtil);
                }
                if (inportsUtils!=null){
                    return new ResponseEntity(1,inportsUtils);
                }
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"gid为空！！！");
    }

    @PostMapping("/inportsListByPid")
    public ResponseEntity findInportsByPid(Integer pid){
        List<InportsUtil> inportsUtils = new ArrayList<>();
        if (pid!=null){
            List<Inports> list = inportsService.findInportsByPid(pid);
            if (list!=null){
                for (Inports inports : list) {
                    InportsUtil inportsUtil = new InportsUtil();
                    inportsUtil.setIid(inports.getIid());
                    inportsUtil.setPaytype(inports.getPaytype());
                    inportsUtil.setInporttime(inports.getInporttime());
                    inportsUtil.setOperateperson(inports.getOperateperson());
                    inportsUtil.setNumber(inports.getNumber());
                    inportsUtil.setTotalweight(inports.getTotalweight());
                    inportsUtil.setRemark(inports.getRemark());
                    inportsUtil.setInportprice(inports.getInportprice());
                    inportsUtil.setPid(inports.getProviderid());
                    inportsUtil.setGid(inports.getGoodsid());
                    inportsUtil.setSid(inports.getSid());
                    inportsUtil.setGname(goodsService.findGoodsById(inports.getGoodsid()).getGname());
                    inportsUtil.setPname(providerService.findProviderById(inports.getProviderid()).getProvidername());
                    inportsUtil.setSname(storeHouseService.findStoreHouseById(inports.getSid()).getSname());
                    inportsUtils.add(inportsUtil);
                }
                if(inportsUtils!=null){
                    return new ResponseEntity(1,inportsUtils);
                }
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"pid为空！！！");
    }

    @PostMapping("/inportsListBySid")
    public ResponseEntity findInportsBySid(Integer sid){
        List<InportsUtil> inportsUtils = new ArrayList<>();
        if (sid!=null){
            List<Inports> list = inportsService.findInportsBySid(sid);
            if (list!=null){
                for (Inports inports : list) {
                    InportsUtil inportsUtil = new InportsUtil();
                    inportsUtil.setIid(inports.getIid());
                    inportsUtil.setPaytype(inports.getPaytype());
                    inportsUtil.setInporttime(inports.getInporttime());
                    inportsUtil.setOperateperson(inports.getOperateperson());
                    inportsUtil.setNumber(inports.getNumber());
                    inportsUtil.setTotalweight(inports.getTotalweight());
                    inportsUtil.setRemark(inports.getRemark());
                    inportsUtil.setInportprice(inports.getInportprice());
                    inportsUtil.setPid(inports.getProviderid());
                    inportsUtil.setGid(inports.getGoodsid());
                    inportsUtil.setSid(inports.getSid());
                    inportsUtil.setOutportinfo(inports.getOutportinfo());
                    inportsUtil.setGname(goodsService.findGoodsById(inports.getGoodsid()).getGname());
                    inportsUtil.setPname(providerService.findProviderById(inports.getProviderid()).getProvidername());
                    inportsUtil.setSname(storeHouseService.findStoreHouseById(inports.getSid()).getSname());
                    inportsUtils.add(inportsUtil);
                }
                if(inportsUtils!=null){
                    return new ResponseEntity(1,inportsUtils);
                }
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"sid为空！！！");
    }

    @PostMapping("/inportsListByDate")
    public ResponseEntity findInportsByDate(Date inporttime){
        List<InportsUtil> inportsUtils = new ArrayList<>();
        if (inporttime!=null){
            List<Inports> list = inportsService.findInportsByDate(inporttime);
            if (list!=null){
                for (Inports inports : list) {
                    InportsUtil inportsUtil = new InportsUtil();
                    inportsUtil.setIid(inports.getIid());
                    inportsUtil.setPaytype(inports.getPaytype());
                    inportsUtil.setInporttime(inports.getInporttime());
                    inportsUtil.setOperateperson(inports.getOperateperson());
                    inportsUtil.setNumber(inports.getNumber());
                    inportsUtil.setTotalweight(inports.getTotalweight());
                    inportsUtil.setRemark(inports.getRemark());
                    inportsUtil.setInportprice(inports.getInportprice());
                    inportsUtil.setPid(inports.getProviderid());
                    inportsUtil.setGid(inports.getGoodsid());
                    inportsUtil.setSid(inports.getSid());
                    inportsUtil.setOutportinfo(inports.getOutportinfo());
                    inportsUtil.setGname(goodsService.findGoodsById(inports.getGoodsid()).getGname());
                    inportsUtil.setPname(providerService.findProviderById(inports.getProviderid()).getProvidername());
                    inportsUtil.setSname(storeHouseService.findStoreHouseById(inports.getSid()).getSname());
                    inportsUtils.add(inportsUtil);
                }
                if(inportsUtils!=null) {
                    return new ResponseEntity(1, inportsUtils);
                }
            }
                return new ResponseEntity(-1,"无任何信息！！！");
        }
            throw new DcrepException(0,"inporttime为空！！！");
    }

    @GetMapping("/goodsName")
    public ResponseEntity findAllGoodsName(){
        List<Goods> list = goodsService.findAllGoods();
        if (list!=null){
            HashMap<Object, Object> map2 = goodsService.findAllGoodsName(list);
            if (map2!=null){
                return new ResponseEntity(1,map2);
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"list为空！！！");
    }

    @GetMapping("/houseName")
    public ResponseEntity findAllHouseName() {
        List<StoreHouse> list = storeHouseService.findAllHouse();
        if (list != null) {
            HashMap<Object, Object> map4 = storeHouseService.findAllHouseName(list);
            if (map4 != null) {
                return new ResponseEntity(1, map4);
            }
            return new ResponseEntity(-1, "无任何信息！！！");
        }
        throw new DcrepException(0, "list为空！！！");
    }

}