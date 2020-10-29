package com.datasupermacy.recruit_cat.service;

import com.datasupermacy.recruit_cat.entity.PostList;

import java.util.List;

public interface PostListService {
    int addList(PostList postList);

    int deleteList(Integer Pid);

    int updateList(PostList postList);

    PostList getListById(Integer Pid);

    List<PostList> getListByCid(Integer Cid);

    int addToList(Integer Jid,Integer Cid);
}
