package com.example.beaninjectiondemo.controller;

import com.example.beaninjectiondemo.service.MessageService;
import com.example.beaninjectiondemo.service.impl.*;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 构造器 + @RequiredArgsConstructor 批量注入
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/constructor")
public class ConstructorInjectionDemoController {

    private final Hello1ServiceImpl hello1Service;

    private final Hello2ServiceImpl hello2Service;

    private final Hello3ServiceImpl hello3Service;

    private final Hello4ServiceImpl hello4Service;

    private final Hello5ServiceImpl hello5Service;

    private final Hello6ServiceImpl hello6Service;

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
