package com.example.beaninjectiondemo.controller;

import com.example.beaninjectiondemo.service.MessageService;
import com.example.beaninjectiondemo.service.impl.*;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/normal")
public class InjectionDemoController {

    // 1.1普通 Autowired, 默认按类型注入byType
    // 这样也行 private Hello1ServiceImpl hello1ServiceAASDASD;
    @Autowired
    private Hello1ServiceImpl hello1Service;

    // 1.2普通 Autowired + @Qualifier 实现byName注入
    // 同样可行的两种方法
    // 类不用接口 private Hello2ServiceImpl hello2Service;
    // 名字随便取，因为已经有@Qualifier了 private MessageService hello2ServiceASDSAD;
    @Autowired
    @Qualifier("hello2ServiceImpl")
    private MessageService hello2Service;

    // 推荐！！
    // 2.1普通 Resource, 默认按名称注入byName
    // 这样也行 private Hello3ServiceImpl hello3ServiceImpl;
    @Resource
    private MessageService hello3ServiceImpl;

    // 2.2普通 Resource + type/name 实现注入
    @Resource(type = Hello4ServiceImpl.class, name = "hello4ServiceImpl")
    private MessageService hello4Service;

    // 3.set注入 本质上还是byType
    private MessageService hello5Service;

    @Autowired
    public void setHello5Service(Hello5ServiceImpl hello5Service){
        this.hello5Service = hello5Service;
    }

    // 4.2构造器注入 本质上是byType
    private final Hello6ServiceImpl hello6Service;

    public InjectionDemoController(Hello6ServiceImpl hello6Service){
        this.hello6Service = hello6Service;
    }

    // 推荐！！
    // 4.2 构造器 + @RequiredArgsConstructor 批量注入
    // 代码在另一个controller里面，因为构造器注入不能用@Autowired

    @GetMapping("/hello")
    public String getGreetingMessage() {
        hello1Service.getMessage();
        hello2Service.getMessage();
        hello3ServiceImpl.getMessage();
        hello4Service.getMessage();
        hello5Service.getMessage();
        hello6Service.getMessage();
        return "yes!";
    }

}
