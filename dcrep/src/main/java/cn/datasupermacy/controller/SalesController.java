package cn.datasupermacy.controller;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.entity.Customer;
import cn.datasupermacy.entity.Goods;
import cn.datasupermacy.entity.Sales;
import cn.datasupermacy.entity.StoreHouse;
import cn.datasupermacy.service.CustomerService;
import cn.datasupermacy.service.GoodsService;
import cn.datasupermacy.service.SalesService;
import cn.datasupermacy.service.StoreHouseService;
import cn.datasupermacy.util.ResponseEntity;
import cn.datasupermacy.util.SalesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
//@CrossOrigin(origins = "http://81.70.152.49:8081")
@RestController
@RequestMapping("/Sales")
public class SalesController {
    @Autowired
    private SalesService salesService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private StoreHouseService storeHouseService;

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/delSales")
    public ResponseEntity delSales(Integer ssid){
        if (ssid!=null){
            if (salesService.delSales(ssid)>0){
                return new ResponseEntity(1,"删除成功！！！");
            }
            return new ResponseEntity(-1,"删除失败！！！");
        }
        throw new DcrepException(0,"ssid为空！！！");
    }

    @PostMapping("/addSales")
    public ResponseEntity addSales(@RequestBody Sales sales){
        if (sales!=null){
            Goods goods = goodsService.findGoodsById(sales.getGoodsid());
            StoreHouse storeHouse = storeHouseService.findStoreHouseById(sales.getSid());
            Integer number = sales.getNumber();
            Double totalweight = sales.getTotalweight();
            if (goods!=null){
                if (goods.getNumber()>=number && goods.getTotalweight()>=totalweight){
                    if (salesService.addSales(sales)>0){
                        storeHouse.setMargin(storeHouse.getMargin()+sales.getTotalweight());
                        storeHouseService.updateStoreHouse(sales.getSid(),storeHouse);

                        goods.setNumber(goods.getNumber()-number);
                        goods.setTotalweight(goods.getTotalweight()-totalweight);
                        goodsService.updatGoods(sales.getGoodsid(),goods);
                        return new ResponseEntity(1,"添加销售订单成功！！！");
                    }
                    return new ResponseEntity(-1,"添加失败！！！");
                }
                return new ResponseEntity(-2,"商品余量不足！！！");
            }
            return new ResponseEntity(-3,"商品不存在！！！");
        }
        throw new DcrepException(0,"sales为空！！！");
    }

    @PutMapping("/updateSales")
    public ResponseEntity updateSales(Integer ssid,@RequestBody Sales sales){
        if (ssid!=null && sales!=null){
            if (salesService.updateSales(ssid, sales)>0){
                return new ResponseEntity(1,"修改成功！！！");
            }
            return new ResponseEntity(-1,"修改失败！！！");
        }
        throw new DcrepException(0,"ssid/sales！！！");
    }

    @GetMapping("/getSales")
    public ResponseEntity getSales(Integer ssid){
        if (ssid!=null){
            Sales sales = salesService.findSalesById(ssid);
            if (sales!=null){
                return new ResponseEntity(1,sales);
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"ssid为空！！！");
    }


    @GetMapping("/getSales2")
    public ResponseEntity getSales2(Integer ssid){
        if (ssid!=null){
            Sales sales = salesService.findSalesById(ssid);
            if (sales!=null){
                SalesUtil salesUtil = new SalesUtil(sales.getSsid(), sales.getCustomerid(),
                        sales.getPaytype(), sales.getSalestime(),sales.getOperateperson(),
                        sales.getNumber(), sales.getRemark(),sales.getSaleprice(),
                        sales.getGoodsid(),sales.getSid(),sales.getSalebackinfo(),
                        sales.getTotalweight(),sales.getOperateperson(),
                        goodsService.findGoodsById(sales.getGoodsid()).getGname(),
                        storeHouseService.findStoreHouseById(sales.getSid()).getSname());
                return new ResponseEntity(1,salesUtil);
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"ssid为空！！！");
    }

    @GetMapping("/findAllSales")
    public ResponseEntity findAllSales(){
        List<Sales> list = salesService.findAllSales();
        if (list!=null){
            return new ResponseEntity(1,list);
        }
        return new ResponseEntity(-1,"无任何信息！！！");
    }

    @GetMapping("/findAllSales2")
    public ResponseEntity findAllSales2(){
        List<Sales> list = salesService.findAllSales();
        if (list!=null){
            List<SalesUtil> salesUtils = new ArrayList<>();
            for (Sales sales : list) {
                SalesUtil salesUtil = new SalesUtil();
                salesUtil.setSsid(sales.getSsid());
                salesUtil.setCustomerid(sales.getCustomerid());
                salesUtil.setGoodsid(sales.getGoodsid());
                salesUtil.setSid(sales.getSid());
                salesUtil.setPaytype(sales.getPaytype());
                salesUtil.setSalestime(sales.getSalestime());
                salesUtil.setOperateperson(sales.getOperateperson());
                salesUtil.setNumber(sales.getNumber());
                salesUtil.setRemark(sales.getRemark());
                salesUtil.setSaleprice(sales.getSaleprice());
                salesUtil.setSalebackinfo(sales.getSalebackinfo());
                salesUtil.setTotalweight(sales.getTotalweight());
                salesUtil.setCname(customerService.findCustomerById(sales.getCustomerid()).getCustomernname());
                salesUtil.setGname(goodsService.findGoodsById(sales.getGoodsid()).getGname());
                salesUtil.setSname(storeHouseService.findStoreHouseById(sales.getSid()).getSname());
                salesUtils.add(salesUtil);
            }
            if (salesUtils!=null){
                return new ResponseEntity(1,salesUtils);
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"list为空！！！");
    }

    @GetMapping("/findSalesByOname")
    public ResponseEntity findSalesByOname(String operateperson){
        if (operateperson!=null){
            List<Sales> list = salesService.findSalesByOname(operateperson);
            if (list!=null){
                return new ResponseEntity(1,list);
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"operatepersonwe");
    }

    @GetMapping("/findSalesByGid")
    public ResponseEntity findSalesByGid(Integer gid){
        if (gid!=null) {
            List<Sales> list = salesService.findSalesByGid(gid);
            if (list!=null){
                List<SalesUtil> salesUtils = new ArrayList<>();
                for (Sales sales : list) {
                    SalesUtil salesUtil = new SalesUtil();
                    salesUtil.setSsid(sales.getSsid());
                    salesUtil.setCustomerid(sales.getCustomerid());
                    salesUtil.setGoodsid(sales.getGoodsid());
                    salesUtil.setSid(sales.getSid());
                    salesUtil.setPaytype(sales.getPaytype());
                    salesUtil.setSalestime(sales.getSalestime());
                    salesUtil.setOperateperson(sales.getOperateperson());
                    salesUtil.setNumber(sales.getNumber());
                    salesUtil.setRemark(sales.getRemark());
                    salesUtil.setSaleprice(sales.getSaleprice());
                    salesUtil.setSalebackinfo(sales.getSalebackinfo());
                    salesUtil.setTotalweight(sales.getTotalweight());
                    salesUtil.setCname(customerService.findCustomerById(sales.getCustomerid()).getCustomernname());
                    salesUtil.setGname(goodsService.findGoodsById(sales.getGoodsid()).getGname());
                    salesUtil.setSname(storeHouseService.findStoreHouseById(sales.getSid()).getSname());
                    salesUtils.add(salesUtil);
                }
                if (salesUtils!=null){
                    return new ResponseEntity(1,salesUtils);
                }
                return new ResponseEntity(-1,"无任何信息！！！");
            }
            return new ResponseEntity(-1,"list为空");
        }
        throw new DcrepException(0,"gid为空！！！");
    }

    @GetMapping("/findSalesByCid")
    public ResponseEntity findSalesByCid(Integer cid){
        if (cid!=null){
            List<Sales> list = salesService.findSalesByCid(cid);
            if (list!=null){
                List<SalesUtil> salesUtils = new ArrayList<>();
                for (Sales sales : list) {
                    SalesUtil salesUtil = new SalesUtil();
                    salesUtil.setSsid(sales.getSsid());
                    salesUtil.setCustomerid(sales.getCustomerid());
                    salesUtil.setGoodsid(sales.getGoodsid());
                    salesUtil.setSid(sales.getSid());
                    salesUtil.setPaytype(sales.getPaytype());
                    salesUtil.setSalestime(sales.getSalestime());
                    salesUtil.setOperateperson(sales.getOperateperson());
                    salesUtil.setNumber(sales.getNumber());
                    salesUtil.setRemark(sales.getRemark());
                    salesUtil.setSaleprice(sales.getSaleprice());
                    salesUtil.setSalebackinfo(sales.getSalebackinfo());
                    salesUtil.setTotalweight(sales.getTotalweight());
                    salesUtil.setCname(customerService.findCustomerById(sales.getCustomerid()).getCustomernname());
                    salesUtil.setGname(goodsService.findGoodsById(sales.getGoodsid()).getGname());
                    salesUtil.setSname(storeHouseService.findStoreHouseById(sales.getSid()).getSname());
                    salesUtils.add(salesUtil);
                }
                if (salesUtils!=null){
                    return new ResponseEntity(1,salesUtils);
                }
                return new ResponseEntity(-1,"无任何信息！！！");
            }
            return new ResponseEntity(-1,"list为空！！！");
        }
        throw new DcrepException(0,"cid为空！！！");
    }

    @GetMapping("/findSalesBySid")
    public ResponseEntity findSalesBySid(Integer sid){
        if (sid!=null){
            List<Sales> list = salesService.findSalesBySid(sid);
            if (list!=null){
                List<SalesUtil> salesUtils = new ArrayList<>();
                for (Sales sales : list) {
                    SalesUtil salesUtil = new SalesUtil();
                    salesUtil.setSsid(sales.getSsid());
                    salesUtil.setCustomerid(sales.getCustomerid());
                    salesUtil.setGoodsid(sales.getGoodsid());
                    salesUtil.setSid(sales.getSid());
                    salesUtil.setPaytype(sales.getPaytype());
                    salesUtil.setSalestime(sales.getSalestime());
                    salesUtil.setOperateperson(sales.getOperateperson());
                    salesUtil.setNumber(sales.getNumber());
                    salesUtil.setRemark(sales.getRemark());
                    salesUtil.setSaleprice(sales.getSaleprice());
                    salesUtil.setSalebackinfo(sales.getSalebackinfo());
                    salesUtil.setTotalweight(sales.getTotalweight());
                    salesUtil.setCname(customerService.findCustomerById(sales.getCustomerid()).getCustomernname());
                    salesUtil.setGname(goodsService.findGoodsById(sales.getGoodsid()).getGname());
                    salesUtil.setSname(storeHouseService.findStoreHouseById(sales.getSid()).getSname());
                    salesUtils.add(salesUtil);
                }
                if (salesUtils!=null){
                    return new ResponseEntity(1,salesUtils);
                }
                return new ResponseEntity(-1,"无任何信息！！！");
            }
            return new ResponseEntity(-1,"list为空！！！");
        }
        throw new DcrepException(0,"sid为空！！！");
    }

    @GetMapping("/findSalesByDate")
    public ResponseEntity findSalesByDate(Date salestime){
        if (salestime!=null){
            List<Sales> list = salesService.findSalesByDate(salestime);
            if (list!=null) {
                List<SalesUtil> salesUtils = new ArrayList<>();
                for (Sales sales : list) {
                    SalesUtil salesUtil = new SalesUtil();
                    salesUtil.setSsid(sales.getSsid());
                    salesUtil.setCustomerid(sales.getCustomerid());
                    salesUtil.setGoodsid(sales.getGoodsid());
                    salesUtil.setSid(sales.getSid());
                    salesUtil.setPaytype(sales.getPaytype());
                    salesUtil.setSalestime(sales.getSalestime());
                    salesUtil.setOperateperson(sales.getOperateperson());
                    salesUtil.setNumber(sales.getNumber());
                    salesUtil.setRemark(sales.getRemark());
                    salesUtil.setSaleprice(sales.getSaleprice());
                    salesUtil.setSalebackinfo(sales.getSalebackinfo());
                    salesUtil.setTotalweight(sales.getTotalweight());
                    salesUtil.setCname(customerService.findCustomerById(sales.getCustomerid()).getCustomernname());
                    salesUtil.setGname(goodsService.findGoodsById(sales.getGoodsid()).getGname());
                    salesUtil.setSname(storeHouseService.findStoreHouseById(sales.getSid()).getSname());
                    salesUtils.add(salesUtil);
                }
                if (salesUtils != null) {
                    return new ResponseEntity(1, salesUtils);
                }
                return new ResponseEntity(-1, "无任何信息！！！");
            }
            return new ResponseEntity(-1,"list为空");
        }
        throw new DcrepException(0,"date为空！！！");
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
