package com.yang.myblog.queryvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ：yangyin
 * @description：推荐博客数据实体类
 * @date ：2021/3/11 22:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecommendBlog {

    private Long id;
    private String title;
    private String firstPicture;
    private boolean recommend;

}
