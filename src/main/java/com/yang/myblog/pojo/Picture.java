package com.yang.myblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ：yangyin
 * @description：照片墙实体类
 * @date ：2021/3/16 12:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Picture {

    private Long id;
    private String picturename;
    private String picturetime;
    private String pictureaddress;
    private String picturedescription;

}
