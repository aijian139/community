package com.yj.mapper;

import com.yj.po.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit);

    //@Param 注解用于给参数取别名
    //如果只有y一个参数，并且在<if>里使用，则必须取别名
    int selectDiscussPostRows(@Param("userId")int userId);
}
