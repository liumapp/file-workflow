package com.liumapp.demo.workflow.controller;

import com.alibaba.fastjson.JSON;
import com.liumapp.demo.workflow.util.FileManager;
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

    private FileManager fileManager;

    @RequestMapping("/")
    public String upload (@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String type = fileName.substring(fileName.lastIndexOf("."));
        
        return JSON.toJSONString("success");
    }

}
