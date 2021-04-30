package cn.datasupermacy.service.impl;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.dao.GoodsMapper;
import cn.datasupermacy.entity.Goods;
import cn.datasupermacy.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
