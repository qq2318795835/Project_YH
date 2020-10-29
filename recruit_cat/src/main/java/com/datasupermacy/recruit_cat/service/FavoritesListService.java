package com.datasupermacy.recruit_cat.service;

import com.datasupermacy.recruit_cat.entity.FavoritesList;

import java.util.List;

public interface FavoritesListService {

    int addList(FavoritesList favoritesList);

    int deleteList(Integer Fid);

    int updateList(FavoritesList favoritesList);

    FavoritesList getListById(Integer Fid);

    List<FavoritesList> getListByUid(Integer Uid);

    int addToList(Integer Jid,Integer Uid);
}
