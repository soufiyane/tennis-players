package com.tennisplayers;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.tennisplayers.data.PlayerDto;
import org.tennisplayers.entity.Player;
import org.tennisplayers.presentation.PlayerController;
import org.tennisplayers.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories("org.tennisplayers.repository")
@ComponentScan(
basePackages = {"org.tennisplayers.adapters", "org.tennisplayers.ports", "org.tennisplayers.services", "org.tennisplayers.presentation"},
basePackageClasses  = {PlayerController.class})
@EntityScan("org.tennisplayers.entity")
public class LauncherApplication {

    private final PlayerRepository playerRepository;

    public LauncherApplication(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(LauncherApplication.class, args);


    }
    @Bean
    public ApplicationRunner init() {
        return args -> {

            System.out.println("Find a player:");


            boolean foundPlayer52 = playerRepository.existsById(52L);
            System.out.println("Found (existsBook1): " + foundPlayer52 + "\n");

            Optional<Player> foundPlayer = playerRepository.findById(52L);
            System.out.println("Found (existsBook1): " + foundPlayer.get().getCountrycode() + "\n");

            List<Player> playerList = playerRepository.findAll(Sort.by(Sort.Direction.ASC, "datarank"));

            System.out.println(playerList.toString());

        };
    }

}
