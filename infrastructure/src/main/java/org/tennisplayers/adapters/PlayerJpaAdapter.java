package org.tennisplayers.adapters;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.tennisplayers.entity.Player;
import org.tennisplayers.mappers.PlayerMapper;
import org.tennisplayers.repository.PlayerRepository;
import org.tennisplayers.data.PlayerDto;
import org.tennisplayers.ports.spi.PlayerPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.math.Quantiles;

import java.util.*;


@Service
public class PlayerJpaAdapter implements PlayerPersistencePort {

    @Autowired
    @Qualifier("playerRepository")
    private PlayerRepository playerRepository;

  /*  @Override
    public PlayersDto addPlayers(PlayersDto playerDto) {

        Player player = PlayerMapper.INSTANCE.playerDtoToPlayers(playerDto);

        Player playerSaved = playerRepository.save(player);

        return PlayerMapper.INSTANCE.playerToPlayerDto(playerSaved);
    }

    @Override
    public void deletePlayerById(Long id) {
        PlayerRepository.deleteById(id);
    }

    @Override
    public PlayerDto updatePlayer(PlayerDto playerDto) {
        return addPlayer(playerDto);
    }*/

    @Override
    public List<PlayerDto> getPlayers() {

        List<Player> playerList = playerRepository.findAll(Sort.by(Sort.Direction.ASC, "datarank"));

        return PlayerMapper.INSTANCE.playerListToPlayerDtoList(playerList);
    }

    @Override
    public PlayerDto getPlayerById(Long playerId) {

        Optional<Player> player = playerRepository.findById(playerId);

        if (player.isPresent()) {
            return PlayerMapper.INSTANCE.playerToPlayerDto(player.get());
        }

        return null;
    }


}