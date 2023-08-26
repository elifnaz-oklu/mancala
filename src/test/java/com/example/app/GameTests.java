package com.example.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GameTests {
    @Test
    void testCreateGame() {

        GameModel gModel = new GameModel("p1", "p2");

        GameController gController = new GameController();

        Game createdGame = gController.createGame(gModel);

        assertEquals("p1",createdGame.getPlayer1().getName());
        assertEquals("p2",createdGame.getPlayer2().getName());
    }
}
