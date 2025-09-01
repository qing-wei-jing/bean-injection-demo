package com.example.beaninjectiondemo.service.impl;

import com.example.beaninjectiondemo.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class Hello5ServiceImpl implements MessageService {
    
    @Override
    public String getMessage() {
        System.out.println("Hello5");
        return "Hello5";
    }
}
