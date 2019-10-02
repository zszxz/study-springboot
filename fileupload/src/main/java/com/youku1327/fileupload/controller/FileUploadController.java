package com.youku1327.fileupload.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author lsc
 * @Description <p> </p>
 * @Date 2019/10/2 20:58
 * @Version 1.0
 */
@RestController
public class FileUploadController {

    @Value("${youku1327.file.root.path}")
    private String fileRootPath;

    @PostMapping("/file/upload")
    public String fileUpload(@RequestParam("files")MultipartFile[] files){
        String filePath = "";
        // 多文件上传
        for (MultipartFile file : files){
            // 上传简单文件名
            String originalFilename = file.getOriginalFilename();
            // 存储路径
             filePath = new StringBuilder(fileRootPath)
                    .append(System.currentTimeMillis())
                    .append(originalFilename)
                    .toString();
            try {
                // 保存文件
                file.transferTo(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return filePath;
    }
}
