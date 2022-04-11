package com.yang.myblog.queryvo;

import com.yang.myblog.pojo.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author ：yangyin
 * @description：显示数据实体类
 * @date ：2021/3/11 22:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BlogQuery {

    private Long id;
    private String title;
    private Date createTime;
    private Date updateTime;
    private Boolean recommend;
    private Boolean published;
    private Long typeId;
    private Type type;

}
