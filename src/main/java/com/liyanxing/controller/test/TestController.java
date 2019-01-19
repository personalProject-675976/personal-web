package com.liyanxing.controller.test;

import com.liyanxing.project.commonuser.pojo.CommonUser;
import com.liyanxing.project.commonuser.service.CommonUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试控制器
 */
@Controller
public class TestController
{
    @Autowired
    @Qualifier("commonUserServiceImpl")
    private CommonUserService service;

    @GetMapping("/test")
    public String test(Model model)
    {
//        model.addAttribute("msg","此用户名已被注册!");

        return "register";
    }

    @GetMapping("/getRe")
    @ResponseBody
    public CommonUser getRe()
    {
        return service.selectAbyName("李艳兴");
    }

    /**
     * 已被注册返回trure
     * 未被注册返回false
     * @param name
     * @return
     */
    @GetMapping("/ajaxTest")
    @ResponseBody
    public Map<String,Boolean> ajaxTest(String name)
    {
        Map<String,Boolean> map = new HashMap<>(1);
        if (service.selectAbyName(name) != null)
        {
            map.put("msg", true);
        }
        else
        {
            map.put("msg", false);
        }

        System.out.println(map.get("msg"));

        return map;
    }
}