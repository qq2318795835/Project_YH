package cn.datasupermacy.controller;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.entity.*;
import cn.datasupermacy.service.*;
import cn.datasupermacy.util.OutportsUtil;
import cn.datasupermacy.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
//@CrossOrigin(origins = "http://81.70.152.49:8081")
@RestController
@RequestMapping("/Outports")
public class OutportsController {
    @Autowired
    private OutportsService outportsService;

    @Autowired
    private StoreHouseService storeHouseService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ProviderService providerService;

    @Autowired
    private InportsService inportsService;

    @GetMapping("/findAllOutports")
    public ResponseEntity findAllOutports(){
        List<Outports> list = outportsService.findAllOutports();
        if (list!=null){
            return new ResponseEntity(1,list);
        }
        return new ResponseEntity(-1,"无任何信息！！！");
    }

    @GetMapping("/findAllOutports2")
    public ResponseEntity findAllOutports2(){
        List<Outports> list = outportsService.findAllOutports();
        if (list!=null){
        List<OutportsUtil> outportsUtils = new ArrayList<>();
            for (Outports outports : list) {
                OutportsUtil outportsUtil = new OutportsUtil();
                outportsUtil.setOid(outports.getOid());
                outportsUtil.setProviderid(outports.getProviderid());
                outportsUtil.setPaytype(outports.getPaytype());
                outportsUtil.setOutputtime(outports.getOutputtime());
                outportsUtil.setOperateperson(outports.getOperateperson());
                outportsUtil.setOutportprice(outports.getOutportprice());
                outportsUtil.setNumber(outports.getNumber());
                outportsUtil.setRemark(outports.getRemark());
                outportsUtil.setGoodsid(outports.getGoodsid());
                outportsUtil.setSid(outports.getSid());
                outportsUtil.setTotalweight(outports.getTotalweight());
                outportsUtil.setIid(outports.getIid());
                outportsUtil.setGname(goodsService.findGoodsById(outports.getGoodsid()).getGname());
                outportsUtil.setPname(providerService.findProviderById(outports.getProviderid()).getProvidername());
                outportsUtil.setSname(storeHouseService.findStoreHouseById(outports.getSid()).getSname());
                outportsUtils.add(outportsUtil);
            }
            if (outportsUtils!=null){
                return new ResponseEntity(1,outportsUtils);
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"list为空！！！");
    }

    @PostMapping("/findOutportsByGid")
    public ResponseEntity findOutportsByGid(Integer gid){
        if (gid!=null) {
            List<Outports> list = outportsService.findOutportsByGid(gid);
            if (list != null) {
                List<OutportsUtil> outportsUtils = new ArrayList<>();
                for (Outports outports : list) {
                    OutportsUtil outportsUtil = new OutportsUtil();
                    outportsUtil.setOid(outports.getOid());
                    outportsUtil.setProviderid(outports.getProviderid());
                    outportsUtil.setPaytype(outports.getPaytype());
                    outportsUtil.setOutputtime(outports.getOutputtime());
                    outportsUtil.setOperateperson(outports.getOperateperson());
                    outportsUtil.setOutportprice(outports.getOutportprice());
                    outportsUtil.setNumber(outports.getNumber());
                    outportsUtil.setRemark(outports.getRemark());
                    outportsUtil.setGoodsid(outports.getGoodsid());
                    outportsUtil.setSid(outports.getSid());
                    outportsUtil.setTotalweight(outports.getTotalweight());
                    outportsUtil.setIid(outports.getIid());
                    outportsUtil.setGname(goodsService.findGoodsById(outports.getGoodsid()).getGname());
                    outportsUtil.setPname(providerService.findProviderById(outports.getProviderid()).getProvidername());
                    outportsUtil.setSname(storeHouseService.findStoreHouseById(outports.getSid()).getSname());
                    outportsUtils.add(outportsUtil);
                }
                if (outportsUtils != null) {
                    return new ResponseEntity(1, outportsUtils);
                }
                return new ResponseEntity(-1, "无任何信息！！！");
            }
        }
        throw new DcrepException(0,"gid为空！！！");
    }

    @PostMapping("/findOutportsByPid")
    public ResponseEntity findOutportsByPid(Integer pid){
        if (pid!=null) {
            List<Outports> list = outportsService.findOutportsByPid(pid);
            if (list != null) {
                List<OutportsUtil> outportsUtils = new ArrayList<>();
                for (Outports outports : list) {
                    OutportsUtil outportsUtil = new OutportsUtil();
                    outportsUtil.setOid(outports.getOid());
                    outportsUtil.setProviderid(outports.getProviderid());
                    outportsUtil.setPaytype(outports.getPaytype());
                    outportsUtil.setOutputtime(outports.getOutputtime());
                    outportsUtil.setOperateperson(outports.getOperateperson());
                    outportsUtil.setOutportprice(outports.getOutportprice());
                    outportsUtil.setNumber(outports.getNumber());
                    outportsUtil.setRemark(outports.getRemark());
                    outportsUtil.setGoodsid(outports.getGoodsid());
                    outportsUtil.setSid(outports.getSid());
                    outportsUtil.setTotalweight(outports.getTotalweight());
                    outportsUtil.setIid(outports.getIid());
                    outportsUtil.setGname(goodsService.findGoodsById(outports.getGoodsid()).getGname());
                    outportsUtil.setPname(providerService.findProviderById(outports.getProviderid()).getProvidername());
                    outportsUtil.setSname(storeHouseService.findStoreHouseById(outports.getSid()).getSname());
                    outportsUtils.add(outportsUtil);
                }
                if (outportsUtils != null) {
                    return new ResponseEntity(1, outportsUtils);
                }
                return new ResponseEntity(-1, "无任何信息！！！");
            }
        }
        throw new DcrepException(0,"pid为空！！！");
    }

    @PostMapping("/findOutportsBySid")
    public ResponseEntity findOutportsBySid(Integer sid){
        if (sid!=null) {
            List<Outports> list = outportsService.findOutportsBySid(sid);
            if (list != null) {
                List<OutportsUtil> outportsUtils = new ArrayList<>();
                for (Outports outports : list) {
                    OutportsUtil outportsUtil = new OutportsUtil();
                    outportsUtil.setOid(outports.getOid());
                    outportsUtil.setProviderid(outports.getProviderid());
                    outportsUtil.setPaytype(outports.getPaytype());
                    outportsUtil.setOutputtime(outports.getOutputtime());
                    outportsUtil.setOperateperson(outports.getOperateperson());
                    outportsUtil.setOutportprice(outports.getOutportprice());
                    outportsUtil.setNumber(outports.getNumber());
                    outportsUtil.setRemark(outports.getRemark());
                    outportsUtil.setGoodsid(outports.getGoodsid());
                    outportsUtil.setSid(outports.getSid());
                    outportsUtil.setTotalweight(outports.getTotalweight());
                    outportsUtil.setIid(outports.getIid());
                    outportsUtil.setGname(goodsService.findGoodsById(outports.getGoodsid()).getGname());
                    outportsUtil.setPname(providerService.findProviderById(outports.getProviderid()).getProvidername());
                    outportsUtil.setSname(storeHouseService.findStoreHouseById(outports.getSid()).getSname());
                    outportsUtils.add(outportsUtil);
                }
                if (outportsUtils != null) {
                    return new ResponseEntity(1, outportsUtils);
                }
                return new ResponseEntity(-1, "无任何信息！！！");
            }
        }
        throw new DcrepException(0,"sid为空！！！");
    }

    @PostMapping("/findOutportsByDate")
    public ResponseEntity findOutportsByDate(Date outputtime){
        if (outputtime!=null) {
            List<Outports> list = outportsService.findOutportsByDate(outputtime);
            if (list != null) {
                List<OutportsUtil> outportsUtils = new ArrayList<>();
                for (Outports outports : list) {
                    OutportsUtil outportsUtil = new OutportsUtil();
                    outportsUtil.setOid(outports.getOid());
                    outportsUtil.setProviderid(outports.getProviderid());
                    outportsUtil.setPaytype(outports.getPaytype());
                    outportsUtil.setOutputtime(outports.getOutputtime());
                    outportsUtil.setOperateperson(outports.getOperateperson());
                    outportsUtil.setOutportprice(outports.getOutportprice());
                    outportsUtil.setNumber(outports.getNumber());
                    outportsUtil.setRemark(outports.getRemark());
                    outportsUtil.setGoodsid(outports.getGoodsid());
                    outportsUtil.setSid(outports.getSid());
                    outportsUtil.setTotalweight(outports.getTotalweight());
                    outportsUtil.setIid(outports.getIid());
                    outportsUtil.setGname(goodsService.findGoodsById(outports.getGoodsid()).getGname());
                    outportsUtil.setPname(providerService.findProviderById(outports.getProviderid()).getProvidername());
                    outportsUtil.setSname(storeHouseService.findStoreHouseById(outports.getSid()).getSname());
                    outportsUtils.add(outportsUtil);
                }
                if (outportsUtils != null) {
                    return new ResponseEntity(1, outportsUtils);
                }
                return new ResponseEntity(-1, "无任何信息！！！");
            }
        }
        throw new DcrepException(0,"outputtime为空！！！");
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

    @PostMapping("/addOutports")
    public ResponseEntity addOutports(@RequestBody Outports outports){
        if (outports!=null){
            if (outportsService.addOutports(outports)>0){
                Inports inports = inportsService.findInportsById(outports.getIid());
                inports.setOutportinfo("已退:"+outports.getNumber()+"箱/"+outports.getTotalweight()+"kg");
                inportsService.updateInports(inports.getIid(),inports);

                Goods goods = goodsService.findGoodsById(outports.getGoodsid());
                goods.setNumber(goods.getNumber()-outports.getNumber());
                goods.setTotalweight(goods.getTotalweight()-outports.getTotalweight());
                goodsService.updatGoods(goods.getGid(),goods);

                StoreHouse storeHouse = storeHouseService.findStoreHouseById(outports.getSid());
                storeHouse.setMargin(storeHouse.getMargin()+outports.getTotalweight());
                storeHouseService.updateStoreHouse(storeHouse.getSid(),storeHouse);

                return new ResponseEntity(1,"添加退货成功！！！");
            }
            return new ResponseEntity(-1,"添加退货失败！！！");
        }
        throw new DcrepException(0,"outports为空！！！");
    }
}
