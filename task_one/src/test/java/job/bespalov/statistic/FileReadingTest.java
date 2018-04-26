package job.bespalov.statistic;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FileReadingTest {
    private FileReading fileReading;

    public FileReadingTest() throws IOException {
        fileReading=new FileReading();
    }

    @Test
    void getPaths() {
        Path expect= Paths.get("task_one/src/main/resources/fileOne.txt");
        assertTrue(fileReading.getPaths().contains(expect));
        assertEquals(expect,fileReading.getPaths().get(0));
    }

}