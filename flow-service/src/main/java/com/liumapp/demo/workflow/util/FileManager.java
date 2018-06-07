package com.liumapp.demo.workflow.util;

import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * @author liumapp
 * @file FileManager.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 6/7/18
 */
@Component
public class FileManager {

    private String savepath;

    public void save (InputStream inputStream , String path) {

    }

    public String getSavepath() {
        return savepath;
    }

    public void setSavepath(String savepath) {
        this.savepath = savepath;
    }
}
