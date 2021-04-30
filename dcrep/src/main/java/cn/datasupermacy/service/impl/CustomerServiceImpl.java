package cn.datasupermacy.service.impl;

import cn.datasupermacy.Exceptions.CustomerException;
import cn.datasupermacy.dao.CustomerMapper;
import cn.datasupermacy.entity.Customer;
import cn.datasupermacy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public List<Customer> findAllCustomer() throws CustomerException {
        return customerMapper.findAllCustomer();
    }

    @Override
    public Customer findCustomerById(Integer cid) throws CustomerException {
        try {
            return customerMapper.selectByPrimaryKey(cid);
        }catch (CustomerException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer findCustomerByName(String customernname) throws CustomerException {
        try {
            return customerMapper.findCustomerByName(customernname);
        } catch (CustomerException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    @Override
    public int addCustomer(Customer customer) throws CustomerException {
        try {
            return customerMapper.insertSelective(customer);
        } catch (CustomerException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delCustomer(Integer cid) throws CustomerException {
        try {
            return customerMapper.deleteByPrimaryKey(cid);
        } catch (CustomerException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    @Transactional
    @Override
    public int updateCustomer(Integer cid, Customer customer) throws CustomerException {
        try {
            return customerMapper.updateByPrimaryKeySelective(cid,customer);
        } catch (CustomerException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }
}
