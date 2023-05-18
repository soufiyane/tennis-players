package com.tennisplayers.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.tennisplayers.adapters.PlayerJpaAdapter;
import org.tennisplayers.ports.api.PlayerServicePortt;
import org.tennisplayers.ports.spi.PlayerPersistencePort;
import org.tennisplayers.repository.PlayerRepository;
import org.tennisplayers.services.PlayerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class PlayerConfig {


   @Bean
    public PlayerPersistencePort playerPersistence(){
        return new PlayerJpaAdapter();
    }

    @Bean
    public PlayerServicePortt playerService(){
        return new PlayerServiceImpl(playerPersistence());
    }
}
