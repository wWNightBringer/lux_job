package job.bespalov.calc;

import job.bespalov.repository.ResultRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InformationAboutLine implements ResultRepository {
    private Map<Integer, String> wordsOfLine;

    @Override
    public String getLongestWord(String line) throws IOException {
        wordsOfLine = new HashMap<>();
        for (String words : line.split(" ")) {
            wordsOfLine.put(words.length(), words);
        }
        int[] x = new int[wordsOfLine.size()];
        int a = 0;
        int max = x[a];
        for (Integer num : wordsOfLine.keySet()) {
            x[a] = num;
            if (max < x[a]) {
                max = num;
            }
        }
        return wordsOfLine.get(max);
    }

    @Override
    public String getShortestWord(String line) throws IOException {
        wordsOfLine = new HashMap<>();
        for (String words : line.split(" ")) {
            wordsOfLine.put(words.length(), words);
        }
        int[] x = new int[wordsOfLine.size()];
        int a = 0;
        int min = 100;
        for (Integer num : wordsOfLine.keySet()) {
            x[a] = num;
            if (min > x[a]) {
                min = num;
            }
        }
        return wordsOfLine.get(min);
    }

    @Override
    public int getLengthWord(String line) throws IOException {
        return line.length();
    }

    @Override
    public int getAverageWord(String line) throws IOException {
        int averageLength = 0;
        int num = 0;
        for (String words : line.split(" ")) {
            averageLength += words.length();
            num++;
        }

        return averageLength / num;
    }



}
