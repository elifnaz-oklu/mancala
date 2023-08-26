package com.example.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PitTests {

    Pit p1;
    Pit p2;
    
    @BeforeEach
    void setUp() {
        p1 = new Pit(3, false, null);
        p2 = new Pit(5, false, null);
        
    }

    @Test
    void testDecreaseAll() {
        p1.decreaseAll(p2);
        assertEquals(8,p2.getSize());

    }

    @Test
    void testDecreasePit() {
        p1.decreasePit();
        assertEquals(2,p1.getSize());

    }

    @Test
    void testIncreasePit() {
        p1.increasePit();
        assertEquals(4,p1.getSize());
    }
}
