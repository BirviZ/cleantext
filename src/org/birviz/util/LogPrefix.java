package org.birviz.util;

public enum LogPrefix {
    INFO("INFO: "), ERR("ERROR: ");

    public final String prefix;

    LogPrefix(String prefix) {
        this.prefix = prefix;
    }
}
