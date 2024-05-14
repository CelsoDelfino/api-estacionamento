package com.github.parkapi.demoparkapi.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

@Configuration
public class SpringTimeZoneConfig {

    // PostConstruct após a classe ser inicializada pelo spring o método construtor é executado
    @PostConstruct
    public void timezoneConfig(){
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
    }

}
