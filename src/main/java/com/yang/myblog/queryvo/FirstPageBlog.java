package com.yang.myblog.queryvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author ：yangyin
 * @description：博客首页数据实体类
 * @date ：2021/3/11 22:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FirstPageBlog {

    private Long id;
    private String title;
    private String firstPicture;
    private Integer views;
    private Integer commentCount;
    private Date createTime;
    private Date updateTime;
    private String description;

    private String typeName;

    private String nickname;
    private String avatar;
}
