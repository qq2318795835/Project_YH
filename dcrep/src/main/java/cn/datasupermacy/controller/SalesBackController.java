package cn.datasupermacy.controller;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.entity.*;
import cn.datasupermacy.service.*;
import cn.datasupermacy.util.ResponseEntity;
import cn.datasupermacy.util.SalesBackUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/SalesBack")
public class SalesBackController {
    @Autowired
    private SalesBackService salesBackService;

    @Autowired
    private SalesService salesService;

    @Autowired

    private CustomerService customerService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private StoreHouseService storeHouseService;

    @PostMapping("/addSalesBack")
    public ResponseEntity addSalesBack(@RequestBody SalesBack salesBack){
        if (salesBack!=null){
            StoreHouse storeHouse = storeHouseService.findStoreHouseById(salesBack.getSid());
            if (storeHouse.getMargin()>=salesBack.getTotalweight()){
                if (salesBackService.addSalesBack(salesBack)>0){
                    storeHouse.setMargin(storeHouse.getMargin()-salesBack.getTotalweight());
                    storeHouseService.updateStoreHouse(salesBack.getSid(),storeHouse);

                    Goods goods = goodsService.findGoodsById(salesBack.getGoodsid());
                    goods.setTotalweight(goods.getTotalweight()+salesBack.getTotalweight());
                    goods.setNumber(goods.getNumber()+salesBack.getNumber());
                    goodsService.updatGoods(salesBack.getGoodsid(),goods);

                    Sales sales = salesService.findSalesById(salesBack.getSsid());
                    sales.setSalebackinfo("被退回："+salesBack.getNumber()+"箱/"+salesBack.getTotalweight()+"kg");
                    salesService.updateSales(salesBack.getSsid(),sales);
                    return new ResponseEntity(1,"退货成功！！！");
                }
                return new ResponseEntity(-1,"退货失败！！！");

            }else return new ResponseEntity(-2,"仓库余量不足！！！");

        }
        throw new DcrepException(0,"salesBack为空！！！");
    }

    @PostMapping("/delSalesBack")
    public ResponseEntity delSalesBack(Integer sbid){
        if (sbid!=null){
            if (salesBackService.delSalesBack(sbid)>0){
                return new ResponseEntity(1,"删除成功！！！");
            }
            return new ResponseEntity(-1,"删除失败！！！");
        }
        throw new DcrepException(0,"sbid为空！！！");
    }

    @GetMapping("/findAllSalesBack")
    public ResponseEntity findAllSalesBack(){
        List<SalesBack> list = salesBackService.findAllSalesBack();
        if (list!=null){
            return new ResponseEntity(1,list);
        }
        return new ResponseEntity(-1,"无任何信息！！！");
    }

    @GetMapping("/findAllSalesBack2")
    public ResponseEntity findAllSalesBack2(){
        List<SalesBack> list = salesBackService.findAllSalesBack();
        if (list!=null){
            List<SalesBackUtil> salesBackUtils = new ArrayList<>();
            for (SalesBack salesBack : list) {
                SalesBackUtil salesBackUtil = new SalesBackUtil();
                salesBackUtil.setSbid(salesBack.getSbid());
                salesBackUtil.setCustomerid(salesBack.getCustomerid());
                salesBackUtil.setPaytype(salesBack.getPaytype());
                salesBackUtil.setSalesbacktime(salesBack.getSalesbacktime());
                salesBackUtil.setSalebackprice(salesBack.getSalebackprice());
                salesBackUtil.setOperateperson(salesBack.getOperateperson());
                salesBackUtil.setNumber(salesBack.getNumber());
                salesBackUtil.setRemark(salesBack.getRemark());
                salesBackUtil.setGoodsid(salesBack.getGoodsid());
                salesBackUtil.setSid(salesBack.getSid());
                salesBackUtil.setSsid(salesBack.getSsid());
                salesBackUtil.setTotalweight(salesBack.getTotalweight());
                salesBackUtil.setCname(customerService.findCustomerById(salesBack.getCustomerid()).getCustomernname());
                salesBackUtil.setGname(goodsService.findGoodsById(salesBack.getGoodsid()).getGname());
                salesBackUtil.setSname(storeHouseService.findStoreHouseById(salesBack.getSid()).getSname());
                salesBackUtils.add(salesBackUtil);
            }
            if (salesBackUtils!=null){
                return new ResponseEntity(1,salesBackUtils);
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"list为空！！！");
    }

    @PostMapping("/findSalesBackByGid")
    public ResponseEntity findSalesByGid(Integer gid){
        if (gid!=null){
            List<SalesBack> list = salesBackService.findSalesBackByGid(gid);
            if (list!=null){
                List<SalesBackUtil> salesBackUtils = new ArrayList<>();
                for (SalesBack salesBack : list) {
                    SalesBackUtil salesBackUtil = new SalesBackUtil();
                    salesBackUtil.setSbid(salesBack.getSbid());
                    salesBackUtil.setCustomerid(salesBack.getCustomerid());
                    salesBackUtil.setPaytype(salesBack.getPaytype());
                    salesBackUtil.setSalesbacktime(salesBack.getSalesbacktime());
                    salesBackUtil.setSalebackprice(salesBack.getSalebackprice());
                    salesBackUtil.setOperateperson(salesBack.getOperateperson());
                    salesBackUtil.setNumber(salesBack.getNumber());
                    salesBackUtil.setRemark(salesBack.getRemark());
                    salesBackUtil.setGoodsid(salesBack.getGoodsid());
                    salesBackUtil.setSid(salesBack.getSid());
                    salesBackUtil.setSsid(salesBack.getSsid());
                    salesBackUtil.setTotalweight(salesBack.getTotalweight());
                    salesBackUtil.setCname(customerService.findCustomerById(salesBack.getCustomerid()).getCustomernname());
                    salesBackUtil.setGname(goodsService.findGoodsById(salesBack.getGoodsid()).getGname());
                    salesBackUtil.setSname(storeHouseService.findStoreHouseById(salesBack.getSid()).getSname());
                    salesBackUtils.add(salesBackUtil);
                }
                if (salesBackUtils!=null){
                    return new ResponseEntity(1,salesBackUtils);
                }
                return new ResponseEntity(-1,"无任何信息！！！");
            }
            return new ResponseEntity(-1,"list为空！！！");
        }
        throw new DcrepException(0,"gid为空！！！");
    }

    @PostMapping("/findSalesBackByCid")
    public ResponseEntity findSalesBackByCid(Integer cid){
        if (cid!=null){
            List<SalesBack> list = salesBackService.findSalesBackByCid(cid);
            if (list!=null){
                List<SalesBackUtil> salesBackUtils = new ArrayList<>();
                for (SalesBack salesBack : list) {
                    SalesBackUtil salesBackUtil = new SalesBackUtil();
                    salesBackUtil.setSbid(salesBack.getSbid());
                    salesBackUtil.setCustomerid(salesBack.getCustomerid());
                    salesBackUtil.setPaytype(salesBack.getPaytype());
                    salesBackUtil.setSalesbacktime(salesBack.getSalesbacktime());
                    salesBackUtil.setSalebackprice(salesBack.getSalebackprice());
                    salesBackUtil.setOperateperson(salesBack.getOperateperson());
                    salesBackUtil.setNumber(salesBack.getNumber());
                    salesBackUtil.setRemark(salesBack.getRemark());
                    salesBackUtil.setGoodsid(salesBack.getGoodsid());
                    salesBackUtil.setSid(salesBack.getSid());
                    salesBackUtil.setSsid(salesBack.getSsid());
                    salesBackUtil.setTotalweight(salesBack.getTotalweight());
                    salesBackUtil.setCname(customerService.findCustomerById(salesBack.getCustomerid()).getCustomernname());
                    salesBackUtil.setGname(goodsService.findGoodsById(salesBack.getGoodsid()).getGname());
                    salesBackUtil.setSname(storeHouseService.findStoreHouseById(salesBack.getSid()).getSname());
                    salesBackUtils.add(salesBackUtil);
                }
                if (salesBackUtils!=null){
                    return new ResponseEntity(1,salesBackUtils);
                }
                return new ResponseEntity(-1,"无任何信息！！！");
            }
            return new ResponseEntity(-1,"list为空！！！");
        }
        throw new DcrepException(0,"list为空！！！");
    }

    @PostMapping("/findSalesBackBySid")
    public ResponseEntity findSalesBackBySid(Integer sid){
        if (sid!=null){
            List<SalesBack> list = salesBackService.findSalesBackBySid(sid);
            if (list!=null){
                List<SalesBackUtil> salesBackUtils = new ArrayList<>();
                for (SalesBack salesBack : list) {
                    SalesBackUtil salesBackUtil = new SalesBackUtil();
                    salesBackUtil.setSbid(salesBack.getSbid());
                    salesBackUtil.setCustomerid(salesBack.getCustomerid());
                    salesBackUtil.setPaytype(salesBack.getPaytype());
                    salesBackUtil.setSalesbacktime(salesBack.getSalesbacktime());
                    salesBackUtil.setSalebackprice(salesBack.getSalebackprice());
                    salesBackUtil.setOperateperson(salesBack.getOperateperson());
                    salesBackUtil.setNumber(salesBack.getNumber());
                    salesBackUtil.setRemark(salesBack.getRemark());
                    salesBackUtil.setGoodsid(salesBack.getGoodsid());
                    salesBackUtil.setSid(salesBack.getSid());
                    salesBackUtil.setSsid(salesBack.getSsid());
                    salesBackUtil.setTotalweight(salesBack.getTotalweight());
                    salesBackUtil.setCname(customerService.findCustomerById(salesBack.getCustomerid()).getCustomernname());
                    salesBackUtil.setGname(goodsService.findGoodsById(salesBack.getGoodsid()).getGname());
                    salesBackUtil.setSname(storeHouseService.findStoreHouseById(salesBack.getSid()).getSname());
                    salesBackUtils.add(salesBackUtil);
                }
                if (salesBackUtils!=null){
                    return new ResponseEntity(1,salesBackUtils);
                }
                return new ResponseEntity(-1,"无任何信息！！！");
            }
            return new ResponseEntity(-1,"list为空！！！");
        }
        throw new DcrepException(0,"list为空！！！");
    }

    @PostMapping("/findSalesBackByDate")
    public ResponseEntity findSalesBackByDate(Date salesbacktime){
        if (salesbacktime!=null){
            List<SalesBack> list = salesBackService.findSalesBackByDate(salesbacktime);
            if (list!=null){
                List<SalesBackUtil> salesBackUtils = new ArrayList<>();
                for (SalesBack salesBack : list) {
                    SalesBackUtil salesBackUtil = new SalesBackUtil();
                    salesBackUtil.setSbid(salesBack.getSbid());
                    salesBackUtil.setCustomerid(salesBack.getCustomerid());
                    salesBackUtil.setPaytype(salesBack.getPaytype());
                    salesBackUtil.setSalesbacktime(salesBack.getSalesbacktime());
                    salesBackUtil.setSalebackprice(salesBack.getSalebackprice());
                    salesBackUtil.setOperateperson(salesBack.getOperateperson());
                    salesBackUtil.setNumber(salesBack.getNumber());
                    salesBackUtil.setRemark(salesBack.getRemark());
                    salesBackUtil.setGoodsid(salesBack.getGoodsid());
                    salesBackUtil.setSid(salesBack.getSid());
                    salesBackUtil.setSsid(salesBack.getSsid());
                    salesBackUtil.setTotalweight(salesBack.getTotalweight());
                    salesBackUtil.setCname(customerService.findCustomerById(salesBack.getCustomerid()).getCustomernname());
                    salesBackUtil.setGname(goodsService.findGoodsById(salesBack.getGoodsid()).getGname());
                    salesBackUtil.setSname(storeHouseService.findStoreHouseById(salesBack.getSid()).getSname());
                    salesBackUtils.add(salesBackUtil);
                }
                if (salesBackUtils!=null){
                    return new ResponseEntity(1,salesBackUtils);
                }
                return new ResponseEntity(-1,"无任何信息！！！");
            }
            return new ResponseEntity(-1,"list为空！！！");
        }
        throw new DcrepException(0,"list为空！！！");
    }

    @GetMapping("/customerName")
    public ResponseEntity CustomerName(){
        List<Customer> list = customerService.findAllCustomer();
        if (list!=null){
            HashMap<Object, Object> map2 = customerService.findAllCustomerName(list);
            if (map2!=null){
                return new ResponseEntity(1,map2);
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"list为空！！！");
    }

    @GetMapping("/goodsName")
    public ResponseEntity GoodsName(){
        List<Goods> list = goodsService.findAllGoods();
        if (list!=null){
            HashMap<Object, Object> map = goodsService.findAllGoodsName(list);
            if (map!=null){
                return new ResponseEntity(1,map);
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"list为空！！！");
    }

    @GetMapping("/houseName")
    public ResponseEntity HouseName(){
        List<StoreHouse> list = storeHouseService.findAllHouse();
        if (list!=null){
            HashMap<Object, Object> map = storeHouseService.findAllHouseName(list);
            if (map!=null){
                return new ResponseEntity(1,map);
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"list为空！！！");
    }
}
