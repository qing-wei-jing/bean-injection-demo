package com.example.beaninjectiondemo.controller;

import com.example.beaninjectiondemo.service.MessageService;
import com.example.beaninjectiondemo.service.impl.*;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  Resource 注入
 */

@RestController
@RequestMapping(value = "/resource")
public class ResourceInjectionDemoController {

    @Resource
    private MessageService hello1ServiceImpl;

    @Resource
    private MessageService hello2ServiceImpl;

    @Resource
    private MessageService hello3ServiceImpl;

    @Resource
    private MessageService hello4ServiceImpl;

    @Resource
    private MessageService hello5ServiceImpl;

    @Resource
    private MessageService hello6ServiceImpl;


    @GetMapping("/hello")
    public String getGreetingMessage() {
        hello1ServiceImpl.getMessage();
        hello2ServiceImpl.getMessage();
        hello3ServiceImpl.getMessage();
        hello4ServiceImpl.getMessage();
        hello5ServiceImpl.getMessage();
        hello6ServiceImpl.getMessage();
        return "yes!";
    }

}
