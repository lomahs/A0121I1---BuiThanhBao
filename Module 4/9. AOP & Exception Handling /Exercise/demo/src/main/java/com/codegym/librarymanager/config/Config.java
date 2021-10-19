package com.codegym.librarymanager.config;

import com.codegym.librarymanager.log.LoggerAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public LoggerAction loggerAction(){
        return new LoggerAction();
    }
}