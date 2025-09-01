package com.example.beaninjectiondemo.service.impl;

import com.example.beaninjectiondemo.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class Hello3ServiceImpl implements MessageService {
    
    @Override
    public String getMessage() {
        System.out.println("Hello3");
        return "Hello3";
    }
}
