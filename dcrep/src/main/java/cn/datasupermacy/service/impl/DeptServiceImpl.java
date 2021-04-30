package cn.datasupermacy.service.impl;

import cn.datasupermacy.Exceptions.DeptException;
import cn.datasupermacy.dao.DeptMapper;
import cn.datasupermacy.entity.Dept;
import cn.datasupermacy.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAllDept() {
        return deptMapper.findAllDept();
    }

    @Override
    public Dept findDeptById(Integer did) {
        try {
            return deptMapper.selectByPrimaryKey(did);
        } catch (DeptException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Dept findDeptByName(String dtitle) {
        try {
            return deptMapper.findDeptByName(dtitle);
        } catch (DeptException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Dept> findDeptByDpid(Integer dpid) {
        try {
            return deptMapper.findDeptByDpid(dpid);
        } catch (DeptException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Dept> findDeptByAddress(String daddress) {
        try {
            return deptMapper.findDeptByAddress(daddress);
        } catch (DeptException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    @Override
    public int addDept(Dept dept) {
        try {
            return deptMapper.insert(dept);
        } catch (DeptException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }
    @Transactional
    @Override
    public int addDeptSelective(Dept dept) {
        try {
            return deptMapper.insertSelective(dept);
        } catch (DeptException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delDept(Integer did) {
        try {
            return deptMapper.deleteByPrimaryKey(did);
        } catch (DeptException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }
    @Transactional
    @Override
    public int updateDeptSelective(Integer did, Dept dept) {
        try {
            return deptMapper.updateByPrimaryKeySelective(did,dept);
        } catch (DeptException e) {
            e.getMessage();
            e.printStackTrace();
        } catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
        return 0;
    }
}
