package com.example.beaninjectiondemo.service.impl;

import com.example.beaninjectiondemo.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class Hello4ServiceImpl implements MessageService {
    
    @Override
    public String getMessage() {
        System.out.println("Hello4");
        return "Hello4";
    }
}
