package org.birviz.cleantext;

import org.birviz.io.IO;

public class Main {

    public static void main(String[] args) {
	    IO test = new IO(false, "console");

        Text text = new Text(test.get());

        test.send(text.toString());

        File files[] = new File[args.length];

        for (int i = 0; i < args.length; i++) {
            files[i] = new File(new IO(true, args[i]), new Text(new IO(true, args[i]).get()));
        }
    }

    private static class File {
        private IO file;
        private Text text;

        public File(IO file, Text text) {
            this.file = file;
            this.text = text;
        }

        public IO getFile() {
            return file;
        }

        public Text getText() {
            return text;
        }
    }
}