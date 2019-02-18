package com.example.bootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BootdemoApplication extends SpringBootServletInitializer {

    private static Logger log = LoggerFactory.getLogger(BootdemoApplication.class);



    public static void main(String[] args) {
        SpringApplication.run(BootdemoApplication.class, args);
        log.info("BootdemoApplication is success!");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BootdemoApplication.class);
    }
}
