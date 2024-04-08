package com.saeed.springlogbackappender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HelloService {

    public String sayHello() {
        log.info("Call Hello service!");
        return "Hello";
    }

}
