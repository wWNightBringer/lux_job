package job.bespalov.statistic;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReading {
    private Path pathOne;
    private Path pathTwo;
    private Path pathThree;
    private List<String> list;
    private List<Path> paths;

    public FileReading() throws IOException {
        pathOne = Paths.get("task_one/src/main/resources/fileOne.txt");
        pathTwo=Paths.get("task_one/src/main/resources/fileTwo");
        pathThree=Paths.get("task_one/src/main/resources/fileThree");
        list = new ArrayList<>();
        paths=new ArrayList<>();
        paths.add(pathOne);
        paths.add(pathTwo);
        paths.add(pathThree);
    }

    public List<Path> getPaths() {
        return paths;
    }
}
