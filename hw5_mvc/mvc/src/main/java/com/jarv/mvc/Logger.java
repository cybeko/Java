package com.jarv.mvc;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static final String file = "log.txt";

    public static void log(String message) {
        try (FileWriter writer = new FileWriter(file, true)) {
            String time = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write("[" + time + "] " + message + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("Logging failed: " + e.getMessage());
        }
    }
}
