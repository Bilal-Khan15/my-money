package com.example.geektrust.io;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

@Slf4j
public class InputReader {
    public static List<String> readInputFile(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            log.error("Error reading input file: {}", e.getMessage());
            return Collections.emptyList();
        }
    }
}




