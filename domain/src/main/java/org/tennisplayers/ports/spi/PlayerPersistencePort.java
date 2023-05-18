package org.tennisplayers.ports.spi;

import org.springframework.stereotype.Component;
import org.tennisplayers.data.PlayerDto;

import java.util.List;

@Component
public interface PlayerPersistencePort {


    List<PlayerDto> getPlayers();

    PlayerDto getPlayerById(Long playerId);

}