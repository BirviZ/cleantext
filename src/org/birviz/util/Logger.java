package org.birviz.util;

import java.io.PrintStream;

public class Logger {

    public static PrintStream[] streams;

    public static void write(String message) {
        send(message);
    }

    private static void send(String message) {
        for(PrintStream s: streams) s.println(message);
    }
}
