package com.yang.myblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author ：yangyin
 * @description：友链实体类
 * @date ：2021/3/11 22:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FriendLink {

    private Long id;
    private String blogname;
    private String blogaddress;
    private String pictureaddress;
    private Date createTime;
}
