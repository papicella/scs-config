package com.example.scsconfig;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ScsConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScsConfigApplication.class, args);
    }

    private static final Logger logger = LoggerFactory.getLogger(ScsConfigApplication.class);
    @Value("${spring.cloud.config.server.git.uri}")
    private String repo;

    @PostConstruct
    public void onRun() {
        logger.info("Config Git Repository: {}", repo);
    }
}
