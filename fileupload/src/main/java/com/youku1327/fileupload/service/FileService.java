package com.youku1327.fileupload.service;

import com.youku1327.fileupload.config.FileConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * @Author lsc
 * @Description <p> </p>
 * @Date 2019/11/20 16:02
 */
@Service
@Slf4j
public class FileService {

    @Autowired
    private  FileConfig fileConfig;
    public ResponseEntity<String> fileUpload(MultipartFile[] files) {

        String filePath = "";
        ArrayList<String> failList = new ArrayList<>();
        ArrayList<String> sucessList = new ArrayList<>();
        // 多文件上传
        for (MultipartFile file : files){
            try {
                // 上传简单文件名
                String originalFilename = file.getOriginalFilename();
                // 文件大小
                long size = file.getSize();
                // 获取后缀
                String suffix = StringUtils.substringAfterLast(originalFilename, ".");
                boolean fileMatch = fileConfig.getFilesuffix().stream().anyMatch(s -> s.equals(suffix));
                if (!fileMatch){
                    // 失败文件
                    failList.add(originalFilename);
                    log.error("上传的文件格式不合法:[{}]",originalFilename);
                    throw new IOException();
                }
                // 存储路径
                filePath = new StringBuilder(File.separator)
                        .append(LocalDate.now().getYear())
                        .append(File.separator)
                        .append(LocalDate.now().getMonthValue())
                        .append(File.separator)
                        .append(UUID.randomUUID())
                        .append(".")
                        .append(suffix)
                        .toString();

                // 创建文件
                File saveFile = new File(fileConfig.getSavePath(),filePath);
                if (!saveFile.getParentFile().exists()){
                    saveFile.getParentFile().mkdirs();
                }
                // 保存文件
                file.transferTo(saveFile);
                HashMap<String, Object> map = new HashMap<>();
                // 保存记录
                map.put("size",size);
                map.put("fileName",originalFilename);
                map.put("path",filePath);
                // 调用数据库存储............略
                // 成功文件
                sucessList.add(originalFilename);
            } catch (IOException e) {
                log.error("文件上传失败：",e.getMessage());
            }
        }
        if (!CollectionUtils.isEmpty(failList)){
            String fail = "有非法文件上传失败，非法文件是：" + StringUtils.join(failList, " ");
            return ResponseEntity.badRequest().body(fail);
        }else {
            String success = "文件上传成功，文件是：" + StringUtils.join(sucessList, " ");
            return ResponseEntity.ok(success);
        }
    }
}
