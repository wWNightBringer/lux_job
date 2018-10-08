package job.bespalov.calc;

import job.bespalov.statistic.FileReading;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class CalcFirstFileTest {
    private InformationAboutLine calcFirstFile;
    private FileReading reading;

    public CalcFirstFileTest() {
        reading = new FileReading();
        calcFirstFile = new InformationAboutLine();
    }

    @Before
    void init() {

    }

    @After
    void clear() {
        calcFirstFile = null;
    }

    @Test
    void longestLine() throws IOException {
        Path path = Paths.get("C:\\Users\\Nightbringer\\IdeaProjects\\lux_job\\task_one\\src\\main\\resources\\File_1");
        BufferedReader reader = Files.newBufferedReader(path);
        String line;
        String expect = "hello";
        while (reader.ready()) {
            line = reader.readLine();
            assertEquals(expect, calcFirstFile.getLongestWord(line).toLowerCase());
        }

    }

    @Test
    void shortestLine() throws IOException {
        Path path = Paths.get("C:\\Users\\Nightbringer\\IdeaProjects\\lux_job\\task_one\\src\\main\\resources\\File_2");
        BufferedReader reader = Files.newBufferedReader(path);
        String line;
        String expect = "a";
        while (reader.ready()) {
            line = reader.readLine();
            assertEquals(expect, calcFirstFile.getShortestWord(line).toLowerCase());
        }
    }

    @Test
    void lineLength() throws IOException {
        int expect = 10;
        Path path = Paths.get("C:\\Users\\Nightbringer\\IdeaProjects\\lux_job\\task_one\\src\\main\\resources\\File_3");
        BufferedReader reader = Files.newBufferedReader(path);
        String line;
        while (reader.ready()) {
            line = reader.readLine();
            assertEquals(expect, calcFirstFile.getLengthWord(line));
        }
    }

    @Test
    void averageWord() throws IOException {
        int expect = 8;
        Path path = Paths.get("C:\\Users\\Nightbringer\\IdeaProjects\\lux_job\\task_one\\src\\main\\resources\\File_4");
        BufferedReader reader = Files.newBufferedReader(path);
        String line;
        while (reader.ready()) {
            line = reader.readLine();
            assertEquals(expect, calcFirstFile.getAverageWord(line));
        }
    }


}