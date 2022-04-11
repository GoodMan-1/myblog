package com.yang.myblog.queryvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author ：yangyin
 * @description：TODO
 * @date ：2021/3/9 17:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetailedBlog {

    private Long id;
    private String firstPicture;
    private String flag;
    private String title;
    private String content;

    private Integer views;
    private Integer commentCount;
    private Date createTime;
    private Date updateTime;
    private boolean commentabled;
    private boolean shareStatement;
    private boolean appreciation;
    private String nickname;
    private String avatar;

    //Type
    private String typeName;
}
