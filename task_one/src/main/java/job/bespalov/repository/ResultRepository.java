package job.bespalov.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface ResultRepository {
    String longestLine(String line) throws IOException;
    String shortestLine(String line) throws IOException;
    int lineLength(String line) throws IOException;
    int averageWord(String line) throws IOException;
}
