package com.zszxz;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import io.github.yedaxia.apidocs.plugin.markdown.MarkdownDocPlugin;

/**
 * @Author lsc
 * <p> </p>
 */
public class JApiRunApp {

    public static void main(String[] args) {
        // 1. 创建生成文档的配置
        DocsConfig config = new DocsConfig();
        // 项目所在目录
        config.setProjectPath("C:/java/zszxz/studys-pringboot/springboot-JApiDocs");
        // 生成 HTML 接口文档的目标目录
        config.setDocsPath("C:/mydata/generator/japi");
        // 自动生成
        config.setAutoGenerate(Boolean.TRUE);
        // 项目名
        config.setProjectName("japi测试项目");
        // API 版本号
        config.setApiVersion("V1.0");
        // 使用 MD 插件，额外生成 MD 格式的接口文档
        config.addPlugin(new MarkdownDocPlugin());
        // 2. 执行生成 HTML 接口文档
        Docs.buildHtmlDocs(config);

    }

}
