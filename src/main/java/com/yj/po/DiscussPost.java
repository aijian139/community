package com.yj.po;

import lombok.Data;

import java.util.Date;

@Data
public class DiscussPost {
    private Integer id;
    private Integer userId;
    private String title;
    private String context;
    private Integer type;//0：普通，1：置顶
    private Integer status;//0:正常，1：精华，2：拉黑
    private Date createTime;
    private Integer comment_count;
    private Double score;
}
