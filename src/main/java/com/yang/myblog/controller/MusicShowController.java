package com.yang.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ：yangyin
 * @description：音乐盒页面显示控制器
 * @date ：2021/3/18 16:11
 */
@Controller
public class MusicShowController {

    @GetMapping("/music")
    public String about() {
        return "music";
    }
}
