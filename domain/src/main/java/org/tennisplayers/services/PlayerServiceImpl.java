package org.tennisplayers.services;

import com.google.common.math.Quantiles;
import org.springframework.stereotype.Service;
import org.tennisplayers.data.PlayerDto;
import org.tennisplayers.ports.api.PlayerServicePortt;
import org.tennisplayers.ports.spi.PlayerPersistencePort;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Service("playerServicePortt")
public class PlayerServiceImpl implements PlayerServicePortt {

    private PlayerPersistencePort PlayerPersistencePort;

    public PlayerServiceImpl(PlayerPersistencePort PlayerPersistencePort) {
        this.PlayerPersistencePort = PlayerPersistencePort;
    }

  /*  @Override
    public PlayerDto addPlayer(PlayerDto PlayerDto) {
        return PlayerPersistencePort.addPlayer(PlayerDto);
    }

    @Override
    public void deletePlayerById(Long id) {
        PlayerPersistencePort.deletePlayerById(id);
    }

    @Override
    public PlayerDto updatePlayer(PlayerDto PlayerDto) {
        return PlayerPersistencePort.updatePlayer(PlayerDto);
    }*/

    @Override
    public List<PlayerDto> getPlayers() {
        return PlayerPersistencePort.getPlayers();
    }

    @Override
    public PlayerDto getPlayerById(Long PlayerId) {
        return PlayerPersistencePort.getPlayerById(PlayerId);
    }


    @Override
    public String getBigRatio(){

        List<PlayerDto> players = PlayerPersistencePort.getPlayers();


        ConcurrentMap<String, List<PlayerDto>> lastByCountry = players.parallelStream()
                .collect(Collectors.groupingByConcurrent(PlayerDto::getCountrycode));


        Map<String, Long> ratioPerCountry = new HashMap<>();

        lastByCountry.forEach((k, v) -> ratioPerCountry.put(k, v.stream().mapToInt
                (p->p.getDatalast0()+p.getDatalast1()+p.getDatalast2()+p.getDatalast3()+p.getDatalast4()).sum() / v.stream().count()));

        return  Collections.max(ratioPerCountry.entrySet(), Map.Entry.comparingByValue()).getKey().toString();
    }



    @Override
    public Double getIMCMoyen(){

        List<PlayerDto> players = PlayerPersistencePort.getPlayers();
        return  players.stream().mapToInt(p->p.getDataweight()/(p.getDataheight()*p.getDataheight())).average().orElse(0);
    }

    @Override
    public Double getTailleMediane(){

        List<PlayerDto> players = PlayerPersistencePort.getPlayers();
        List<Integer> tailles = players.stream().map(PlayerDto::getDataheight).collect(Collectors.toList());
        return Quantiles.median().compute(tailles);
    }
}