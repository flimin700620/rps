package com.xp.rps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class RpsController {


    @Autowired
    RpsRepo repo;

    @PostMapping("/play")
    Round simplePlay(@RequestBody Round round) {
        Result playResult = RPS.play(round.getP1(), round.getP2());
        round.setResult(playResult);
        return round;
    }

    @PostMapping("/game")
    int createGame(@RequestBody Game game) {
        int gameID = repo.createGame(game);
        return gameID;
    }

    @GetMapping("/game/{id}")
    Game getGame(@PathVariable int id) {
        return repo.getGame(id);
    }

    @PostMapping("/game/{id}/play")
    int playGame(@PathVariable int id, @RequestBody Round round) {
        Result playResult = RPS.play(round.getP1(), round.getP2());
        round.setResult(playResult);
        int roundID = repo.addRound(id, round);
        return roundID;
    }

}
