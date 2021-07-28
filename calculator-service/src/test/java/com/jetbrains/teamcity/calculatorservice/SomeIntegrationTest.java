package com.jetbrains.teamcity.calculatorservice;


import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeIntegrationTest {

    @Test
    public void anIntegrationTest() throws InterruptedException, IOException {
        Path path = Paths.get("./artifacts");
        Files.createDirectories(path);

        try (InputStream is = SomeIntegrationTest.class.getResourceAsStream("/sample-mp4-file.mp4")) {
            Files.copy(is, path.resolve("sample.mp4"));
        }
        Files.write(path.resolve("a_log.txt"), "This is my log".getBytes());
        Thread.sleep(1000);
        assertEquals(1,1);
    }
}
