package cn.datasupermacy.service;

import cn.datasupermacy.Exceptions.DcrepException;
import cn.datasupermacy.entity.Provider;

import java.util.HashMap;
import java.util.List;

public interface ProviderService {
    List<Provider> findAllProvider()throws DcrepException;

    Provider findProviderById(Integer pid)throws DcrepException;

    Provider findProviderByName(String providername)throws DcrepException;

    int addProvider(Provider provider)throws DcrepException;

    int delProvider(Integer pid);

    int updateProvider(Integer pid,Provider provider)throws DcrepException;

    List<Provider> findProviderByKey(String key)throws DcrepException;

    HashMap<Object, Object>findAllProviderName(List<Provider> list)throws DcrepException;
}
