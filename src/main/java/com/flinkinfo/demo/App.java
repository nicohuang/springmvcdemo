package com.flinkinfo.demo;

import com.flinkinfo.demo.config.ConfigurationManager;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nico on 16/3/11.
 */
public class App
{
   public static void main(String[] args)
    {
        ApplicationContext ac = new GenericXmlApplicationContext("app.xml");
        ConfigurationManager manager = ac.getBean(ConfigurationManager.class);

        Configuration cfg = manager.getConfiguration();

        Map root = new HashMap();
        root.put("user", "Big Joe");

        Map latest = new HashMap();
        root.put("latestProduct", latest);

        latest.put("url", "products/greenmouse.html");
        latest.put("name", "green mouse");

        Template temp = null;
        try
        {
            temp = cfg.getTemplate("test.test");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        /* Merge data-model with template */
        Writer out = new OutputStreamWriter(System.out);
        try
        {
            temp.process(root, out);
        }
        catch (TemplateException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
