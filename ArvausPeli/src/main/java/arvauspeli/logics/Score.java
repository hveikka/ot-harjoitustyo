package arvauspeli.logics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class Score {

    public static String getScores(int t) throws FileNotFoundException {
        int counter = 0;
        String nameScore = "";
        try (Scanner reader = new Scanner(new File("users.txt"))) {
            StringBuilder sb = new StringBuilder("");
            while (reader.hasNextLine() && counter < t) {
                String row = reader.nextLine();

                if (row.trim().length() == 0) {
                    continue;
                }

                String[] parts = row.split(",");

                String name = parts[0];
                int score2 = Integer.valueOf(parts[1]);

                sb.append(name).append(": ").append(score2);
                sb.append("\n");

                nameScore = sb.toString();
                counter++;

            }

        }

        return nameScore;
    }

    public static void writeScore(String n, int s) throws IOException, Exception {
        File file = new File("users.txt");
        FileWriter fw = new FileWriter(file, true);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(n + "," + s + "\n");
        }

    }

}
