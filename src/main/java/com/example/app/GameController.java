package com.example.app;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GameController {

    static Game createdGame;
    
    //Api for game creation
    @PostMapping("/createGame")
    public Game createGame(@RequestBody GameModel gameModel) {
        createdGame = new Game(gameModel.getP1Name(),gameModel.getP2Name());
        return createdGame;
    }

}