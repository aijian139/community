package com.yj.service;

import com.yj.mapper.DiscussPostMapper;
import com.yj.po.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {


    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPost(int userId,int offset,int limit){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(userId, offset, limit);
        return list;
    }

    public int findDiscussPostRows(int userId){
        return discussPostMapper.selectDiscussPostRows(userId);
    }


}
