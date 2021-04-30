package cn.datasupermacy.dao;

import cn.datasupermacy.entity.Provider;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Provider record);

    int insertSelective(Provider record);

    Provider selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Integer pid,@Param("provider")Provider provider);

    int updateByPrimaryKey(Provider provider);

    List<Provider> findAllProvider();

    Provider findProviderByName(String providername);

    List<Provider> findProviderByKey(String key);
}