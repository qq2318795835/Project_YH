package cn.datasupermacy.dao;

import cn.datasupermacy.entity.Goods;
import cn.datasupermacy.util.DangerNumGoods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer gid);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer gid);

    int updateByPrimaryKeySelective(Integer gid,@Param("goods")Goods goods);

    List<Goods> findAllGoods();

    Goods findGoodsByName(String gname);

    List<Goods> findGoodsByKey(String key);

    List<Goods> findGoodsByPid(Integer pid);

    List<DangerNumGoods> findDangerNumGoods();
}