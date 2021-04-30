package cn.datasupermacy.dao;

import cn.datasupermacy.entity.StoreHouse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreHouseMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(StoreHouse storeHouse);

    int insertSelective(StoreHouse storeHouse);

    StoreHouse selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Integer sid,@Param("storeHouse")StoreHouse storeHouse);

    int updateByPrimaryKey(StoreHouse storeHouse);

    List<StoreHouse> findAllHouse();
}