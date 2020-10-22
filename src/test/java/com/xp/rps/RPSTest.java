package com.xp.rps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import static org.junit.jupiter.api.AssertEquals.assertEquals;

public class RPSTest {

    @Test
    void RockVsPaper() {
        Result result = RPS.play(Throw.ROCK, Throw.PAPER);
        assertEquals(Result.P2_WINS, result);
    }
}
