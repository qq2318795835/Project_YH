package cn.datasupermacy.controller;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.entity.Provider;
import cn.datasupermacy.service.ProviderService;
import cn.datasupermacy.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:8081")
//@CrossOrigin(origins = "http://81.70.152.49:8081")
@RestController
@RequestMapping("/Provider")
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @GetMapping("/providerList")
    public ResponseEntity findAllProvider(){
        List<Provider> list = providerService.findAllProvider();
        if (list!=null){
            return new ResponseEntity(1,list);
        }
        return new ResponseEntity(-1,"无任何信息！");
    }

    @GetMapping("/oneProvider")
    public ResponseEntity findProviderById(Integer pid){
        if (pid!=null){
            Provider provider = providerService.findProviderById(pid);
            if (provider!=null){
                return new ResponseEntity(1,provider);
            }
            return new ResponseEntity(-1,"无任何信息！");
        }
        throw new DcrepException(0,"pdi为空!");
    }

    @GetMapping("/oneProvider2")
    public ResponseEntity findProviderByName(String providername){
        if (providername!=null && !providername.isEmpty()){
            Provider provider = providerService.findProviderByName(providername);
            if (provider!=null){
                return new ResponseEntity(1,provider);
            }
            return new ResponseEntity(-1,"无任何信息！");
        }
        throw new DcrepException(0,"providername为空");
    }

    @PostMapping("/delProvider")
    public ResponseEntity delProvider(Integer pid){
        if (pid!=null){
            if (providerService.delProvider(pid)>0){
                return new ResponseEntity(1,"删除成功！");
            }
            return new ResponseEntity(-1,"删除失败！");
        }
        throw new DcrepException(0,"pid为空！");
    }

    @PostMapping("/delProviders")
    public ResponseEntity delProviders(@RequestBody List<Provider> list){
        if (list.size()>0){
            List<Integer> numberList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                numberList.add(list.get(i).getPid());
            }
            if (numberList!=null){
                for (int i = 0; i < numberList.size(); i++) {
                    providerService.delProvider(numberList.get(i));
                }
                return new ResponseEntity(1,"批量删除成功！！！");
            }
        }
        throw new DcrepException(0,"list入参为空！！！");
    }

    @PostMapping("/addProvider")
    public ResponseEntity addProvider(@RequestBody Provider provider){
        if (provider!=null){
            if (providerService.addProvider(provider)>0){
                return new ResponseEntity(1,"添加成功！");
            }
            return new ResponseEntity(-1,"添加失败！");
        }
        throw new DcrepException(0,"pid为空！");
    }

    @PutMapping("/updateProvider")
    public ResponseEntity updateProvider(Integer pid,@RequestBody Provider provider){
        if (pid!=null && provider!=null){
            if (providerService.updateProvider(pid,provider)>0){
                return new ResponseEntity(1,"更新成功！");
            }
            return new ResponseEntity(-1,"更新失败！");
        }
        throw new DcrepException(0,"pid/provider为空！");
    }

    @PostMapping("/providerListByKey")
    public ResponseEntity findProviderByKey(String key){
        if (key!=null && !key.isEmpty()){
            List<Provider> list = providerService.findProviderByKey(key);
            if (list!=null){
                return new ResponseEntity(1,list);
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new DcrepException(0,"key为空！！！");
    }
}
