package org.tennisplayers.presentation;



import org.springframework.beans.factory.annotation.Qualifier;
import org.tennisplayers.data.PlayerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tennisplayers.ports.api.PlayerServicePortt;
import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private PlayerServicePortt playerService;


    @Autowired
    public PlayerController(@Qualifier("playerServicePortt") PlayerServicePortt playerService){
        this.playerService = playerService;
        System.out.println("constructor based dependency injection");
    }

    @GetMapping("/get/{id}")
    public PlayerDto getPlayerByID(@PathVariable long id) {
        return playerService.getPlayerById(id);
    }

    @GetMapping("/get")
    public List<PlayerDto> getAllPlayers() {
        return playerService.getPlayers();
    }

    @GetMapping("/get/stats")
    public StatsPlayers getStats() {

        StatsPlayers s = new StatsPlayers();
        s.setBigRatio(playerService.getBigRatio());
        s.setIMCMoyen(playerService.getIMCMoyen());
        s.setTailleMediane(playerService.getTailleMediane());

        return s;
    }

}