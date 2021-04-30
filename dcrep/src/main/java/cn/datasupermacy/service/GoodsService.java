package cn.datasupermacy.service;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.entity.Goods;
import cn.datasupermacy.util.DangerNumGoods;

import java.util.HashMap;
import java.util.List;

public interface GoodsService {

    List<Goods> findAllGoods();

    Goods findGoodsById(Integer gid)throws DcrepException;

    Goods findGoodsByName(String gname)throws DcrepException;

    int addGoods(Goods goods)throws DcrepException;

    int updatGoods(Integer gid,Goods goods)throws DcrepException;

    int delGoods(Integer gid)throws DcrepException;

    List<Goods> findGoodsByKey(String key);

    List<Goods> findGoodsByPid(Integer pid);

    HashMap<Object, Object> findAllGoodsName(List<Goods> list)throws DcrepException;

    List<DangerNumGoods> findDangerNumGoods();
}
