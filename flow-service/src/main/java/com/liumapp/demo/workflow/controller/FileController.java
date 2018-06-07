package com.liumapp.demo.workflow.controller;

import com.alibaba.fastjson.JSON;
import com.liumapp.demo.workflow.util.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    @Autowired
    private FileManager fileManager;

    @Autowired
    private ResourceLoader resourceLoader;

    @RequestMapping("/")
    public String upload (@RequestParam("file") MultipartFile file) throws IOException {
        fileManager.save(file);
        return JSON.toJSONString("success");
    }

    @RequestMapping(value = "/get", produces="image/*")
    @ResponseBody
    public ResponseEntity<?> getImg (@RequestParam String filename) {
        return ResponseEntity.ok(resourceLoader.getResource("file:" + fileManager.getSavepath() + filename));
    }

}
