package com.yang.myblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：yangyin
 * @description：分类实体类
 * @date ：2021/3/9 17:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Type {

    private Long id;
    private String name;

    private List<Blog> blogs = new ArrayList<>();
}
