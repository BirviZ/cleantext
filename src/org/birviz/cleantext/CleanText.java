package org.birviz.cleantext;

import org.birviz.util.Logger;

import java.io.*;
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

        for(String a: args) {
            if (a.equals("-help")) {
                System.out.println("Help");
                return;
            }

//            if (a.equals("-v")) {
//
//
//
//                try {
//                    Logger.streams = new PrintStream[]{System.out, new PrintStream(new FileOutputStream(new File("log.log"), true))};
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
//            }

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

            if (a.charAt(0) != '-') {
                try {
                    fileItems.add(new FileItem(a, symbols));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        for (FileItem fileItem : fileItems) {
            String file = fileItem.getPath().concat("correct_").concat(fileItem.getName());
            try {
                PrintStream ps = new PrintStream(new FileOutputStream(file));
                ps.println(fileItem.getCorrect());
                ps.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        Logger.write("Complete");
    }
}