package cn.datasupermacy.dao;

import cn.datasupermacy.entity.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Integer cid,@Param("customer") Customer customer);

    int updateByPrimaryKey(Customer customer);

    List<Customer> findAllCustomer();

    Customer findCustomerByName(String customernname);

    List<Customer> findCustomerByKey(String key);
}