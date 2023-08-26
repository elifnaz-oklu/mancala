package com.example.app;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PlayerController {
    
    //Api for playing turn
    @PutMapping("/updatePosition")
    public Move setPosition(@RequestBody PlayerModel playerModel) {
        for (Player player : GameController.createdGame.getPlayers()) {
            if(player.getName().contentEquals(playerModel.getName())){
                Move move = player.playTurn(playerModel.getPitIndex(), GameController.createdGame.getPits());
                return move;
            }  
        } 
        return null;
    }
}