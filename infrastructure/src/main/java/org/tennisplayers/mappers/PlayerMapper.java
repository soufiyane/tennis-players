package org.tennisplayers.mappers;

import org.tennisplayers.entity.Player;
import org.tennisplayers.data.PlayerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PlayerMapper {

    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    PlayerDto playerToPlayerDto(Player player);

    Player playerDtoToPlayer(PlayerDto playerDto);

    List<PlayerDto> playerListToPlayerDtoList(List<Player> playerList);

    List<Player> PlayerDtoListToplayerList(List<PlayerDto> PlayerDtoList);
}