package cn.datasupermacy.controller;

import cn.datasupermacy.Exceptions.CustomerException;
import cn.datasupermacy.entity.Customer;
import cn.datasupermacy.service.CustomerService;
import cn.datasupermacy.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
//@CrossOrigin(origins = "http://81.70.152.49:8081")
@RestController
@RequestMapping("/Customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customerList")
    public ResponseEntity findAllCustomer(){
        List<Customer> list = customerService.findAllCustomer();
        if (list!=null){
            return new ResponseEntity(1,list);
        }
        return new ResponseEntity(-1,"无任何信息!");
    }

    @GetMapping("/oneCustomer")
    public ResponseEntity findCustomerById(Integer cid){
        if (cid!=null){
            Customer customer = customerService.findCustomerById(cid);
            if (customer!=null){
                return new ResponseEntity(1,customer);
            }
            return new ResponseEntity(-1,"无任何信息!");
        }
        throw new CustomerException(0,"cid为空!");
    }

    @GetMapping("/oneCustomer2")
    public ResponseEntity findCustomerByName(String customernname){
        if (customernname!=null&&!customernname.isEmpty()){
            Customer customer = customerService.findCustomerByName(customernname);
            if (customer!=null){
                return new ResponseEntity(1,customer);
            }
            return new ResponseEntity(-1,"无任何信息!");
        }
        throw new CustomerException(0,"customernname为空!");
    }

    @PostMapping("/delCustomer")
    public ResponseEntity delCustomerById(Integer cid){
        if (cid!=null){
            if (customerService.delCustomer(cid)>0){
                return new ResponseEntity(1,"删除成功!");
            }
            return new ResponseEntity(-1,"删除失败!");
        }
        throw new CustomerException(0,"cid为空!");
    }

    @PostMapping("/delCustomers")
    public ResponseEntity deCustomersById(@RequestBody List<Customer> list){
        if (list.size()>0){
            List<Integer> numberList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                numberList.add(list.get(i).getCid());
            }
            if (numberList!=null){
                for (int i = 0; i < numberList.size(); i++) {
                    customerService.delCustomer(numberList.get(i));
//                    System.out.println("已删除一条Customer");
                }
                return new ResponseEntity(1,"批量删除成功！！！");
            }
        }
        throw new CustomerException(0,"入参list为空！！！");
    }

    @PostMapping("/addCustomer")
    public ResponseEntity addCustomer(@RequestBody Customer customer){
        if (customer!=null){
            if (customerService.addCustomer(customer)>0){
                return new ResponseEntity(1,"添加成功!");
            }
            return new ResponseEntity(-1,"添加失败!");
        }
        throw new CustomerException(0,"customer为空!");
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity updateCustomer(Integer cid, @RequestBody Customer customer){
        if (cid != null && customer != null){
            if (customerService.updateCustomer(cid,customer)>0){
                return new ResponseEntity(1,"更新成功!");
            }
            return new ResponseEntity(-1,"更新失败!");
        }
        throw new CustomerException(0,"cid/customer为空!");
    }

    @PostMapping("/customerListByKey")
    public ResponseEntity findCustomerByKey(String key){
        if (key!=null && !key.isEmpty()){
            List<Customer> list = customerService.findCustomerByKey(key);
            if (list!=null){
                return new ResponseEntity(1,list);
            }
            return new ResponseEntity(-1,"无任何信息！！！");
        }
        throw new CustomerException(0,"key为空！！！");
    }
}
