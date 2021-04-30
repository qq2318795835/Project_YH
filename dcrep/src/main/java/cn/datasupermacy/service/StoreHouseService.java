package cn.datasupermacy.service;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.entity.StoreHouse;

import java.util.HashMap;
import java.util.List;

public interface StoreHouseService {
    int delStoreHouse(Integer sid)throws DcrepException;

    int addStoreHouse(StoreHouse storeHouse)throws DcrepException;

    StoreHouse findStoreHouseById(Integer sid)throws DcrepException;

    int updateStoreHouse(Integer sid,StoreHouse storeHouse)throws DcrepException;

    List<StoreHouse> findAllHouse();

    HashMap<Object, Object> findAllHouseName(List<StoreHouse> list)throws DcrepException;
}
