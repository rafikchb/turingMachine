package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TapeTest {
    @Test
    @DisplayName("tasting tape")
    public void testTape(){
        Tape tape = new Tape("RAFIK");
        System.out.println("readed "+ tape.read() + " from "+tape.getIndex());
        tape.write("R", "R");
        System.out.println("readed "+ tape.read() + " from "+tape.getIndex());
    }
}