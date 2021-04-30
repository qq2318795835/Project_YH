package cn.datasupermacy.service.impl;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.dao.ProviderMapper;
import cn.datasupermacy.entity.Provider;
import cn.datasupermacy.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private ProviderMapper providerMapper;

    @Override
    public List<Provider> findAllProvider() throws DcrepException {
        return providerMapper.findAllProvider();
    }

    @Override
    public Provider findProviderById(Integer pid) throws DcrepException {
        try {
            return providerMapper.selectByPrimaryKey(pid);
        } catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Provider findProviderByName(String providername) throws DcrepException {
        try {
            return providerMapper.findProviderByName(providername);
        } catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    @Override
    public int addProvider(Provider provider) throws DcrepException {
        try {
            return providerMapper.insertSelective(provider);
        } catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delProvider(Integer pid) {
        try {
            return providerMapper.deleteByPrimaryKey(pid);
        } catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    @Transactional
    @Override
    public int updateProvider(Integer pid, Provider provider) throws DcrepException {
        try {
            return providerMapper.updateByPrimaryKeySelective(pid,provider);
        } catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Provider> findProviderByKey(String key) throws DcrepException {
        try {
            return providerMapper.findProviderByKey(key);
        } catch (DcrepException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HashMap<Object, Object> findAllProviderName(List<Provider> list) {
        try {
            HashMap<Integer,String> map = new HashMap<>();
            HashMap<Object, Object> map2 = new HashMap<>();
            for (Provider provider : list) {
                map.put(provider.getPid(),provider.getProvidername());
            }
            for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();){
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
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
