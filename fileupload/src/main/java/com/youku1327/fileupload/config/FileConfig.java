package com.youku1327.fileupload.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @Author lsc
 * @Description <p> 文件参数配置 </p>
 * @Date 2019/11/20 9:47
 */
@Configuration
@ConfigurationProperties(prefix = "file")
@Setter
@Getter
public class FileConfig {
    // 文件保存路径
    private String savePath;
    // 文件下载路径
    private String downloadpath;
    // 允许的后缀名
    List<String> filesuffix;
}
