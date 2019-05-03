package arvauspeli.logics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import static java.util.stream.Collectors.toMap;

/**
 *
 * Pistetaulukkoa hoitava luokka.
 */
public class Score {

    /**
     * Metodi antaa valitun määrän tuloksia tulostaulusta parhausjärjestyksessä.
     *
     * @param file
     * @param t tulosten määrä
     *
     * @return tulokset yhtenä String juttuna.
     * @throws java.io.FileNotFoundException
     */
    public static String getScores(String file, int t) throws FileNotFoundException {

        Map<String, Integer> scores = new HashMap<>();
        int counter = 0;
        String nameScore = "";
        try (Scanner reader = new Scanner(new File(file))) {
            StringBuilder sb = new StringBuilder("");
            while (reader.hasNextLine()) {
                String row = reader.nextLine();

                if (row.trim().length() == 0) {
                    continue;
                }

                String[] parts = row.split(",");

                String name = parts[0];
                int score2 = Integer.valueOf(parts[1]);
                scores.put(name, score2);

            }
            Map<String, Integer> sorted = scores
                    .entrySet()
                    .stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(
                            toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                                    LinkedHashMap::new));

            for (Entry<String, Integer> entry : sorted.entrySet()) {
                if (counter < t) {
                    sb.append(entry.getKey()).append(": ").append(entry.getValue());
                    sb.append("\n");
                    nameScore = sb.toString();
                    counter++;
                }
            }

        }

        return nameScore;
    }

    /**
     * Metodi kirjoittaa käyttäjän pisteet listoille.
     *
     * @param filet
     * @param n nimi
     * @param s pisteet
     * @throws java.io.IOException
     * @throws java.lang.Exception
     */
    public static void writeScore(String filet, String n, int s) throws IOException, Exception {
        File file = new File(filet);
        FileWriter fw = new FileWriter(file, true);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(n + "," + s + "\n");
        }

    }

}
