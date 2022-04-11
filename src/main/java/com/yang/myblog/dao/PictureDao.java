package com.yang.myblog.dao;

import com.yang.myblog.pojo.Picture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：yangyin
 * @description：照片墙持久层接口
 * @date ：2021/3/16 12:47
 */
@Mapper
public interface PictureDao {

    List<Picture>  listPicture();

    int savePicture(Picture picture);

    Picture getPicture(Long id);

    int updatePicture(Picture picture);

    void deletePicture(Long id);
}
