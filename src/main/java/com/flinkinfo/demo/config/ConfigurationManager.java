package com.flinkinfo.demo.config;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.io.IOException;

/**
 * Configuration实例是存储Freemarker应用级设置的核心部分,同时,它也创建和缓存预解析模板的工作
 * 应用级别的单例
 *
 * @author nico huangwenzeng1@163.com
 */
@Component
public class ConfigurationManager
{
    private Configuration configuration;

    public ConfigurationManager()
    {
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        configuration = new Configuration(Configuration.VERSION_2_3_22);

        System.out.println("nice:" + webApplicationContext);
//        ServletContext servletContext = webApplicationContext.getServletContext();
//        configuration.setServletContextForTemplateLoading(servletContext,"/");
        try
        {
            configuration.setDirectoryForTemplateLoading(new File("/Users/nico/springmvcdemo/src/main/webapp"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        System.out.println("create:manager");
    }

    public Configuration getConfiguration()
    {
        return configuration;
    }
}
