package cn.datasupermacy.service;

import cn.datasupermacy.Exceptions.CustomerException;
import cn.datasupermacy.entity.Customer;

import java.util.HashMap;
import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomer()throws CustomerException;

    Customer findCustomerById(Integer cid)throws CustomerException;

    Customer findCustomerByName(String customernname)throws CustomerException;

    int addCustomer(Customer customer)throws CustomerException;

    int delCustomer(Integer cid)throws CustomerException;

    int updateCustomer(Integer cid ,Customer customer)throws CustomerException;

    List<Customer> findCustomerByKey (String key);

    HashMap<Object, Object> findAllCustomerName(List<Customer> list);
}
