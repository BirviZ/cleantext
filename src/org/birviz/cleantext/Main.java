package org.birviz.cleantext;

import org.birviz.io.IO;

public class Main {

    public static void main(String[] args) {
	    IO test = new IO(false, "console");

        Text text = new Text(test.get());

        test.send(text.toString());
    }
}