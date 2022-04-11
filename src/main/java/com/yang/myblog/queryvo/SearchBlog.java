package com.yang.myblog.queryvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ：yangyin
 * @description：搜索博客管理列表
 * @date ：2021/3/11 22:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchBlog {

    private String title;
    private Long typeId;
}
