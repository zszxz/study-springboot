package com.youku1327.download.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @Author lsc
 * @Description <p> 文件下载</p>
 * @Date 2019/11/20 11:54
 */
@RestController
@RequestMapping("file")
public class DownloadController {

    private String downloadPath = "C:\\mydata\\generator";

    @GetMapping("download")
    public ResponseEntity<byte[]> downlaodFile(HttpServletRequest request, @RequestParam("path") String path
            , @RequestHeader("user-agent") String userAgent, @RequestParam("filename") String filename
            ,@RequestParam(required = false,defaultValue = "false") boolean inline ) {

        String realPath = downloadPath + path;
        File file = new File(realPath);
        // 构建响应
        ResponseEntity.BodyBuilder bodyBuilder = ResponseEntity.ok();
        bodyBuilder.contentLength(file.length());
        // 二进制数据流
        bodyBuilder.contentType(MediaType.APPLICATION_OCTET_STREAM);
        // 文件名解码
        try {
            String encodeFileName = URLEncoder.encode(filename, "UTF-8");
            // IE
            if (userAgent.indexOf("MSIE")>0){
                bodyBuilder.header("Content-Disposition","attachment;filename="+encodeFileName);
            }else {
                // 其他浏览器
                if (inline){
                    // 在浏览器中打开
                    URL url = new URL("file:///" + file);
                    bodyBuilder.header("Content-Type",url.openConnection().getContentType());
                    bodyBuilder.header("Content-Disposition","inline;filename*=UTF-8''"+encodeFileName);
                }else {
                    // 直接下载
                    bodyBuilder.header("Content-Disposition","attachment;filename*=UTF-8''"+encodeFileName);
                }

            }
             return bodyBuilder.body(FileUtils.readFileToByteArray(file));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return (ResponseEntity<byte[]>) ResponseEntity.badRequest();

    }

}
