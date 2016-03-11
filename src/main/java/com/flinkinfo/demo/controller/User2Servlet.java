package com.flinkinfo.demo.controller;

import com.flinkinfo.demo.config.ConfigurationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */

@Controller
@RequestMapping("/user1")
public class User2Servlet
{
    @Autowired
    private ConfigurationManager configurationManager;

    @RequestMapping("/hello2")
    public ModelAndView hello2()
    {
        ModelAndView mv = new ModelAndView("test2");
        mv.addObject("message","呵呵");
        return mv;
    }

    @RequestMapping("/hello1")
    public ModelAndView hello(String userName,String pwd)
    {

        System.out.println(userName + " "+ pwd);
        String message = userName + pwd+"abc";

        ModelAndView modelAndView = new ModelAndView("hello.jsp");


//        Configuration cfg = configurationManager.getConfiguration();

        Map root = new HashMap();
        root.put("user", "Big Joe");

        Map latest = new HashMap();
        root.put("latestProduct", latest);

        latest.put("url", "products/greenmouse.html");
        latest.put("name", "green mouse");

        modelAndView.addObject("root",root);
//        Template temp = null;
//        try
//        {
//            temp = cfg.getTemplate("test.ftl");
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//        /* Merge data-model with template */
//        Writer out = new OutputStreamWriter(System.out);
//        try
//        {
//            temp.process(root, out);
//        }
//        catch (TemplateException e)
//        {
//            e.printStackTrace();
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//
//        //需要跳转的页面

        return modelAndView;
    }

}
