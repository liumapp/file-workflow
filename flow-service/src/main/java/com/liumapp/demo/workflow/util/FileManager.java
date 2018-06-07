package com.liumapp.demo.workflow.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    public void save (MultipartFile file) throws IOException {
        File destFile = new File(savepath + file.getOriginalFilename());
        file.transferTo(destFile);
    }

    public String getSavepath() {
        return savepath;
    }

    public void setSavepath(String savepath) {
        this.savepath = savepath;
    }
}
