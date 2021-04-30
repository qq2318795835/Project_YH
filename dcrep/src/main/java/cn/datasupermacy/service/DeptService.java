package cn.datasupermacy.service;

import cn.datasupermacy.Exceptions.DeptException;
import cn.datasupermacy.entity.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> findAllDept();

    Dept findDeptById(Integer did)throws DeptException;

    Dept findDeptByName(String dtitle)throws DeptException;

    List<Dept> findDeptByDpid(Integer dpid)throws DeptException;

    //抛地名异常
    List<Dept> findDeptByAddress(String daddress)throws DeptException;

    //抛父级部门id越界异常
    int addDept(Dept dept)throws DeptException;

    //抛父级部门id越界异常
    int addDeptSelective(Dept dept)throws DeptException;

    //抛删除父级部门前删除子部门
    int delDept(Integer did)throws DeptException;

    //抛父级部门id越界异常
    int updateDeptSelective(Integer did,Dept dept)throws DeptException;

}
