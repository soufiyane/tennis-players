package org.tennisplayers.ports.api;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.tennisplayers.data.PlayerDto;

import java.util.List;

@Component("playerServicePortt")
public interface PlayerServicePortt {


    List<PlayerDto> getPlayers();

    PlayerDto getPlayerById(Long playerId);

    String getBigRatio();

    Double getIMCMoyen();

    Double getTailleMediane();
}