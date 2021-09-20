package com.jetbrains.teamcity.calculatorservice;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AFlakyTest {

    @Test
    public void aFlakyMethod() {
        assertEquals(0, LocalDateTime.now().getMinute() % 2 );
    }


}
