package com.example.thriftservice.service;

import com.example.thriftapi.HelloService;
import org.springframework.stereotype.Service;

@Service("helloService")
public class HelloServiceImpl implements HelloService.Iface{

    @Override
    public String greet(String name) {
        return String.format("Hello %s!", name);
    }
}
