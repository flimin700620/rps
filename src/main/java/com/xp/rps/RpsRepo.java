package com.xp.rps;

import org.springframework.stereotype.Repository;


public interface RpsRepo {
    int createGame(Game game);
    int addRound(int gameID, Round round);
    Game getGame(int gameID);
}
