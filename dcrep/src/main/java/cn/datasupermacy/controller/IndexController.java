package cn.datasupermacy.controller;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.entity.Sales;
import cn.datasupermacy.entity.SalesBack;
import cn.datasupermacy.entity.StoreHouse;
import cn.datasupermacy.service.GoodsService;
import cn.datasupermacy.service.SalesBackService;
import cn.datasupermacy.service.SalesService;
import cn.datasupermacy.service.StoreHouseService;
import cn.datasupermacy.util.DangerNumGoods;
import cn.datasupermacy.util.ResponseEntity;
import cn.datasupermacy.util.SalesAnalysisBackUtil;
import cn.datasupermacy.util.SalesAnalysisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/Index")
public class IndexController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private SalesService salesService;

    @Autowired
    private SalesBackService salesBackService;

    @Autowired
    private StoreHouseService storeHouseService;

    @GetMapping("/findDangerNumGoods")
    public ResponseEntity findDangerNumGoods(){
        List<DangerNumGoods> list = goodsService.findDangerNumGoods();
        if (list!=null){
            return new ResponseEntity(1,list);
        }
        return new ResponseEntity(-1,"无库存紧急商品！！！");
    }

    @GetMapping("/findAllHouse")
    public ResponseEntity findAllHouse(){
        List<StoreHouse> list = storeHouseService.findAllHouse();
        if (list!=null){
            return new ResponseEntity(1,list);
        }
        return new ResponseEntity(-1,"无任何信息！！！");
    }

    @GetMapping("/findAllSales")
    public ResponseEntity findAllSales(){
        List<Sales> list = salesService.findAllSales();
        if (list!=null){
            return new ResponseEntity(1,list);
        }
        return new ResponseEntity(-1,"无任何信息！！！");
    }

    @GetMapping("/findAllSalesBack")
    public ResponseEntity findAllSalesBack(){
        List<SalesBack> list = salesBackService.findAllSalesBack();
        if (list!=null){
            return new ResponseEntity(1,list);
        }
        return new ResponseEntity(-1,"无任何信息！！！");
    }

    @PostMapping("/AnalysisSales")
    public ResponseEntity AnalysisSales(String salestime){
        if (salestime!=null) {
            List<SalesAnalysisUtil> list = salesService.AnalysisSales(salestime);
            if (list!=null){
                List<Object> AnalysisResult= new ArrayList<>();
                for (SalesAnalysisUtil analysisUtil : list) {
                    List<Object> list1 = new ArrayList<>();
                    List<Integer> list2 = new ArrayList<>();
                    list1.add(analysisUtil.getGid());
                    list1.add(analysisUtil.getGname());
                    list2.add(analysisUtil.getJan());
                    list2.add(analysisUtil.getFeb());
                    list2.add(analysisUtil.getMar());
                    list2.add(analysisUtil.getApr());
                    list2.add(analysisUtil.getMay());
                    list2.add(analysisUtil.getJune());
                    list2.add(analysisUtil.getJuly());
                    list2.add(analysisUtil.getAug());
                    list2.add(analysisUtil.getSept());
                    list2.add(analysisUtil.getOct());
                    list2.add(analysisUtil.getNov());
                    list2.add(analysisUtil.getDece());
                    list1.add(list2);
                    list1.add(analysisUtil.getNumberTotal());
                    AnalysisResult.add(list1);
                }
                return new ResponseEntity(1,AnalysisResult);
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"salestime为空！！！");
    }

    @PostMapping("/AnalysisSalesBack")
    public ResponseEntity AnalysisSalesBack(String salesbacktime){
        if (salesbacktime!=null){
            List<SalesAnalysisBackUtil> list = salesBackService.AnalysisSalesBack(salesbacktime);
            if (list!=null){
                List<Object> AnalysisResult= new ArrayList<>();
                for (SalesAnalysisBackUtil salesAnalysisBackUtil : list) {
                    List<Object> list1 = new ArrayList<>();
                    List<Integer> list2 = new ArrayList<>();
                    list1.add(salesAnalysisBackUtil.getGid());
                    list1.add(salesAnalysisBackUtil.getGname());
                    list2.add(salesAnalysisBackUtil.getJan());
                    list2.add(salesAnalysisBackUtil.getFeb());
                    list2.add(salesAnalysisBackUtil.getMar());
                    list2.add(salesAnalysisBackUtil.getApr());
                    list2.add(salesAnalysisBackUtil.getMay());
                    list2.add(salesAnalysisBackUtil.getJune());
                    list2.add(salesAnalysisBackUtil.getJuly());
                    list2.add(salesAnalysisBackUtil.getAug());
                    list2.add(salesAnalysisBackUtil.getSept());
                    list2.add(salesAnalysisBackUtil.getOct());
                    list2.add(salesAnalysisBackUtil.getNov());
                    list2.add(salesAnalysisBackUtil.getDece());
                    list1.add(list2);
                    list1.add(salesAnalysisBackUtil.getNumberTotal());
                    AnalysisResult.add(list1);
                }
                return new ResponseEntity(1,AnalysisResult);
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"salestime为空！！！");
    }
}
