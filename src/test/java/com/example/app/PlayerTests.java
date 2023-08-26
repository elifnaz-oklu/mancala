package com.example.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class PlayerTests {

    Player p1;
    Player p2;
    ArrayList<Pit> pits;
    Pit pit1;
    Pit pit2;
    Pit pit3;

    @BeforeEach
    void setUp() {
        p1 = new Player("p1");
        p2 = new Player("p2");
        pits = new ArrayList<Pit>();
        pit1 = new Pit(1, false, p1);
        pit2 = new Pit(2, false, p1);
        pit3 = new Pit(2, false, p2);
        pits.add(pit1);
        pits.add(pit2);
        pits.add(pit3);

        
    }
    @Test
    void testIsFinished() {
        
        Boolean result = p1.isFinished(pits);
        Boolean expBoolean = false;

        assertEquals(expBoolean,result);


    }

    @Test
    void testPlayTurn() {
        Move m = p1.playTurn(0, pits);
        assertEquals(3,m.getPits().get(1).getSize());
        assertEquals(0,m.getPits().get(0).getSize());

    }

    @Test
    void testSumofOpponentsPits() {

        int result = p2.sumofOpponentsPits(pits);
        assertEquals(3,result);

    }
}
