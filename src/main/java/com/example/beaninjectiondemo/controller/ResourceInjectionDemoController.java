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
    private Hello1ServiceImpl hello1Service;

    @Resource
    private Hello2ServiceImpl hello2Service;

    @Resource
    private Hello3ServiceImpl hello3Service;

    @Resource
    private Hello4ServiceImpl hello4Service;

    @Resource
    private Hello5ServiceImpl hello5Service;

    @Resource
    private Hello6ServiceImpl hello6Service;


    @GetMapping("/hello")
    public String getGreetingMessage() {
        hello1Service.getMessage();
        hello2Service.getMessage();
        hello3Service.getMessage();
        hello4Service.getMessage();
        hello5Service.getMessage();
        hello6Service.getMessage();
        return "yes!";
    }

}
