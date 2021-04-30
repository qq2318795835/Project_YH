package cn.datasupermacy.service.impl;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.dao.StoreHouseMapper;
import cn.datasupermacy.entity.StoreHouse;
import cn.datasupermacy.service.StoreHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class StoreHouseServiceImpl implements StoreHouseService {
    @Autowired
    StoreHouseMapper storeHouseMapper;

    @Override
    public int delStoreHouse(Integer sid) throws DcrepException {
        try {
            return storeHouseMapper.deleteByPrimaryKey(sid);
        } catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    @Transactional
    @Override
    public int addStoreHouse(StoreHouse storeHouse) throws DcrepException {
        try {
            return storeHouseMapper.insertSelective(storeHouse);
        } catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public StoreHouse findStoreHouseById(Integer sid) throws DcrepException {
        try {
            return storeHouseMapper.selectByPrimaryKey(sid);
        } catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    @Override
    public int updateStoreHouse(Integer sid,StoreHouse storeHouse) throws DcrepException {
        try {
            return storeHouseMapper.updateByPrimaryKeySelective(sid,storeHouse);
        }catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<StoreHouse> findAllHouse() {
        return storeHouseMapper.findAllHouse();
    }

    @Override
    public HashMap<Object, Object> findAllHouseName(List<StoreHouse> list) {
        try {
            HashMap<Integer, String> map3 = new HashMap<>();
            HashMap<Object, Object> map4 = new HashMap<>();
            for (StoreHouse storeHouse : list) {
                map3.put(storeHouse.getSid(), storeHouse.getSname());
            }
            for (Iterator iterator = map3.entrySet().iterator(); iterator.hasNext(); ) {
                Map.Entry entry = (Map.Entry) iterator.next();
                if (map4.containsValue(entry.getValue())) {
                    continue;
                } else {
                    map4.put(entry.getKey(), entry.getValue());
                }
            }
            return map4;
        } catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
