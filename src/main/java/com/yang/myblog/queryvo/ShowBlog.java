package com.yang.myblog.queryvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author ：yangyin
 * @description：编辑修改文章实体类
 * @date ：2021/3/11 22:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShowBlog {

    private Long id;
    private String flag;
    private String title;
    private String content;
    private Long typeId;
    private String firstPicture;
    private String description;
    private boolean recommend;
    private boolean published;
    private boolean shareStatement;
    private boolean appreciation;
    private boolean commentabled;
    private Date createTime;
    private Date updateTime;

}
