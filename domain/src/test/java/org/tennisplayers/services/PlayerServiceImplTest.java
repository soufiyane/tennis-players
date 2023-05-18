package org.tennisplayers.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.tennisplayers.data.PlayerDto;
import org.tennisplayers.ports.spi.PlayerPersistencePort;

import java.util.ArrayList;
import java.util.List;


public class PlayerServiceImplTest {

    private PlayerServiceImpl playerServiceImpl;


    PlayerPersistencePort playerPersistencePortMock = mock(PlayerPersistencePort.class);
    private PlayerDto player;
    private Long playerId = 52L;

    @BeforeEach
    void setUp() {
        playerServiceImpl = new PlayerServiceImpl(playerPersistencePortMock);
        player = new PlayerDto();

        player.setId(playerId);
        player.setFirstname("Novak");
        player.setLastname("Djokovic");
        player.setShortname("N.DJO");
        player.setSex('M');
        player.setCountrypicture("http...");
        player.setCountrycode("SRB");
        player.setPicture("http...");
        player.setDatarank(2);
        player.setDatapoints(2542);
        player.setDataweight(80000);
        player.setDataheight(180);
        player.setDataage(30);
        player.setDatalast0(1);
        player.setDatalast1(1);
        player.setDatalast2(1);
        player.setDatalast3(1);
        player.setDatalast4(1);

    }

    @Test
    void playerExists_returned() {
        when(playerPersistencePortMock.getPlayerById(playerId)).thenReturn(player);

        assertThat(playerServiceImpl.getPlayerById(playerId)).isEqualTo(player);
    }

    @Test
    void unknownPlayer_returnsNone() {
        when(playerPersistencePortMock.getPlayerById(playerId)).thenReturn(null);

        assertThat(playerServiceImpl.getPlayerById(playerId)).isEqualTo(null);
    }

    @Test
    void getAllTest() {

        List<PlayerDto> l = new ArrayList<>();
        l.add(player);
        when(playerPersistencePortMock.getPlayers()).thenReturn(l);

        assertThat(playerServiceImpl.getPlayers()).isEqualTo(l);
    }

    // il reste les testes pour les 3 autres méthodes; il faut juste ajouter des players et appeler ces fonctions ...

    //et pour les couches infras et appli on fait la meme chose
    // pour infra: PlayerJpaAdapter.java on mock le repository et on fait nos testes ....
    // pour le controlleur on mock le service et on fait nos testes ....
    // et y en a un tas de testes qu'on peut ajouter pour couvrir tous les cas possibles .....

}
