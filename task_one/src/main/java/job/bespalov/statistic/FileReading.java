package job.bespalov.statistic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReading {
    private List<Path> paths;

    public FileReading() {
        paths = new ArrayList<>();
    }

    public void moveWithFile(String title) {
        String name = String.format("task_one/src/main/resources/%s", title);
        Path path = Paths.get(name);
        paths.add(path);
    }

    public List<Path> getPaths() {
        return paths;
    }
}
