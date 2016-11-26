package org.birviz.util;

public class Text {
    private String text;
    private String[][] splitter;

    public Text(String data, String[][] splitter) {
        this.text = data;
        this.splitter = splitter;
    }

    private String clean(String data) {

        for (String s[] : splitter) {
            data = data.replaceAll(s[0], s[1]);
        }

        data = data.trim();

        return data;
    }

    @Override
    public String toString() {

        return clean(this.text);
    }
}
