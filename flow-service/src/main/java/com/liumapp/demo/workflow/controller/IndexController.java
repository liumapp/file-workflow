package com.liumapp.demo.workflow.controller;

import com.alibaba.fastjson.JSON;
import com.liumapp.demo.workflow.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liumapp
 * @file IndexController.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 6/6/18
 */
@RestController
@RequestMapping("")
public class IndexController {

    @RequestMapping("/info")
    public String handleForm (@RequestBody User user) {
        return JSON.toJSONString("success");
    }

}
