package org.birviz.util;

import java.io.PrintStream;

public class Logger {

    public static PrintStream[] streams;

    public static void write(String mess, LogPrefix prefix) {

        int len = prefix.prefix.length() + mess.length();
        String format = "%s%s" + System.lineSeparator() + "%" + len + "s" + System.lineSeparator();
        String message = String.format(format, prefix.prefix, new java.util.Date().toString(), mess);
        for (int i = 0; i < len; i++) message = message.concat("-");

        send(message);
    }

    private static void send(String message) {
        for (PrintStream s : streams) s.println(message);
    }
}
