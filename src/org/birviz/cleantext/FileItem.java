package org.birviz.cleantext;

import org.birviz.util.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FileItem {
    private final String name;
    private String path;
    private String text = "";
    private File file;
    private Text correct;

    FileItem(String name, String[][] symbols) throws FileNotFoundException {
        this.file = new File(name);
        this.name = file.getName();
        this.path = file.getAbsolutePath();
        readText();
        correct = new Text(text, symbols);
    }

    String getName() {
        return name;
    }

    String getPath() {
        return path;
    }

    String getCorrect() {
        return correct.toString();
    }

    private void readText() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) text = text.concat(scanner.nextLine()).concat("\n");
    }
}
