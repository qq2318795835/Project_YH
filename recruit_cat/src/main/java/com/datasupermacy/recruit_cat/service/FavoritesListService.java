package com.datasupermacy.recruit_cat.service;

import com.datasupermacy.recruit_cat.entity.FavoritesList;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FavoritesListService {

    int addList(FavoritesList favoritesList);

    int deleteList(Integer Fid);

    int updateList(FavoritesList favoritesList);

    FavoritesList getListById(Integer Fid);

    List<FavoritesList> getListByUid(Integer Uid,int pageNum,int pageSize);

    int addToList(Integer Jid,Integer Uid) throws Exception;

    int delListItem(Integer Jid,Integer Uid);
}
