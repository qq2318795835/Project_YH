package cn.datasupermacy.service.impl;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.dao.GoodsMapper;
import cn.datasupermacy.entity.Goods;
import cn.datasupermacy.service.GoodsService;
import cn.datasupermacy.util.DangerNumGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<Goods> findAllGoods() {
        return goodsMapper.findAllGoods();
    }

    @Override
    public Goods findGoodsById(Integer gid) throws DcrepException {
        try {
            return goodsMapper.selectByPrimaryKey(gid);
        } catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Goods findGoodsByName(String gname) throws DcrepException {
        try {
            return goodsMapper.findGoodsByName(gname);
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
    public int addGoods(Goods goods) throws DcrepException {
        try {
            return goodsMapper.insertSelective(goods);
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
    public int updatGoods(Integer gid, Goods goods) throws DcrepException {
        try {
            return goodsMapper.updateByPrimaryKeySelective(gid,goods);
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
    public int delGoods(Integer gid) throws DcrepException {
        try {
            return goodsMapper.deleteByPrimaryKey(gid);
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
    public List<Goods> findGoodsByKey(String key) throws DcrepException{
        try {
            return goodsMapper.findGoodsByKey(key);
        } catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Goods> findGoodsByPid(Integer pid) {
        try {
            return goodsMapper.findGoodsByPid(pid);
        } catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HashMap<Object, Object> findAllGoodsName(List<Goods> list) {
        try {
            HashMap<Integer, String> map = new HashMap<>();
            HashMap<Object, Object> map2 = new HashMap<>();
            for (Goods goods : list) {
                map.put(goods.getGid(), goods.getGname());
            }
            for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
                Map.Entry entry = (Map.Entry) iterator.next();
                if (map2.containsValue(entry.getValue())) {
                    continue;
                } else {
                    map2.put(entry.getKey(), entry.getValue());
                }
            }
            return map2;
        } catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DangerNumGoods> findDangerNumGoods() {
        return goodsMapper.findDangerNumGoods();
    }
}
