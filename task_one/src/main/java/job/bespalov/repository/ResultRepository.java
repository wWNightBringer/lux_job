package job.bespalov.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface ResultRepository {
    String getLongestWord(String line) throws IOException;
    String getShortestWord(String line) throws IOException;
    int getLengthWord(String line) throws IOException;
    int getAverageWord(String line) throws IOException;
}
