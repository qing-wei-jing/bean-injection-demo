package com.example.beaninjectiondemo;

import com.example.beaninjectiondemo.controller.InjectionDemoController;
import com.example.beaninjectiondemo.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BeanInjectionDemoApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    
    @Autowired
    private InjectionDemoController controller;
    
    @Autowired
    @Qualifier("welcomeMessageServiceImpl")
    private MessageService welcomeMessageService;

    @Test
    void contextLoads() {
        // 测试Spring上下文是否加载成功
        assertThat(controller).isNotNull();
    }
    
    @Test
    void testWelcomeMessageService() {
        // 测试WelcomeMessageService
        assertThat(welcomeMessageService).isNotNull();
        assertThat(welcomeMessageService.getMessage()).contains("Welcome");
    }
    
    @Test
    void testWelcomeEndpoint() {
        // 测试/welcome端点
        String url = "http://localhost:" + port + "/welcome";
        String response = this.restTemplate.getForObject(url, String.class);
        assertThat(response).contains("Welcome");
    }
    
    @Test
    void testGreetingEndpoint() {
        // 测试/greeting端点
        String url = "http://localhost:" + port + "/greeting";
        String response = this.restTemplate.getForObject(url, String.class);
        assertThat(response).contains("Greeting");
    }
    
    @Test
    void testProcessedEndpoint() {
        // 测试/processed端点
        String url = "http://localhost:" + port + "/processed";
        String response = this.restTemplate.getForObject(url, String.class);
        assertThat(response).startsWith("Processed");
    }
    
    @Test
    void testNotificationEndpoint() {
        // 测试/notification端点
        String url = "http://localhost:" + port + "/notification";
        String response = this.restTemplate.getForObject(url, String.class);
        assertThat(response).startsWith("Notification sent");
    }
}
