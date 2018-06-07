package com.liumapp.demo.workflow.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liumapp
 * @file FileController.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 6/7/18
 */
@RestController
@RequestMapping("file")
public class FileController {

    @RequestMapping("/")
    public String upload (@RequestParam("file") MultipartFile file) {

        return JSON.toJSONString("success");
    }

}
