package org.birviz.cleantext;

import org.birviz.util.LogPrefix;
import org.birviz.util.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class CleanText {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Bad arguments");
            System.out.println("Example: java -jar text.txt");
            System.out.println("Or --help for help");
            return;
        }

        ArrayList<FileItem> fileItems = new ArrayList<>();
        String[][] symbols = {
                {"\t", " "},
                {" +", " "},
                {"\r", "\n"},
                {" \n", "\n"},
                {"\n+", "\n"},
                {"\n ", "\n"},
                {"\n.\n", "\n"}
        };

        Logger.streams = new PrintStream[]{System.out};

        for (String a : args) {
            if (a.equals("-help")) {
                System.out.println("Help");
                return;
            }

            if (a.equals("-v")) {

                try {
                    String logFile = "cleantext.log";
                    Logger.streams = new PrintStream[]{System.out, new PrintStream(new FileOutputStream(new File(logFile), true))};
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            if (a.equals("-sokolenko")) {
                symbols = new String[][]{
                        {"\\\\", "\n"},
                        {"/", "\n"},
                        {"\t", " "},
                        {" +", " "},
                        {"\r", "\n"},
                        {" \n", "\n"},
                        {"\n+", "\n"},
                        {"\n ", "\n"},
                        {"\n.\n", "\n"},
                        {"- ", "-"},
                        {" -", "-"}
                };
            }
        }

        for (String a : args) {

            if (a.charAt(0) != '-') {
                try {
                    fileItems.add(new FileItem(a, symbols));
                    Logger.write("File ".concat(a).concat(" read success."), LogPrefix.INFO);
                } catch (FileNotFoundException e) {
                    Logger.write("File ".concat(a).concat(" not found."), LogPrefix.ERR);
                }
            }
        }

        for (FileItem fileItem : fileItems) {
            String file = fileItem.getPath().concat("correct_".concat(fileItem.getName()));
            try {
                PrintStream ps = new PrintStream(new FileOutputStream(file));
                ps.println(fileItem.getCorrect());
                Logger.write("File ".concat(file).concat(" write success."), LogPrefix.INFO);
                ps.close();
            } catch (FileNotFoundException e) {
                Logger.write("File ".concat(fileItem.getName()).concat(" not found."), LogPrefix.ERR);
            }
        }
    }
}