package com.flinkinfo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 */

@Controller
@RequestMapping("/user")
public class UserServlet
{
    @RequestMapping("/hello")
    public ModelAndView hello(String userName,String pwd)
    {
        System.out.println(userName + " "+ pwd);
        String message = userName + pwd;

        ModelAndView modelAndView = new ModelAndView("user1/hello2");
        modelAndView.addObject("message",message);

        //需要跳转的页面

        return modelAndView;
    }

}
