package job.bespalov.statistic;

import job.bespalov.calc.CalcFile;
import job.bespalov.jd.DatabaseByAct;
import job.bespalov.repository.ResultRepository;


import java.io.BufferedReader;
import java.io.IOException;

import java.nio.file.Files;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListResults {
    private FileReading reading;
    private List<ResultRepository> list;
    private DatabaseByAct actionByDatabase;
    private int idTitle;
    private int count;
    private List<String> title;

    public ListResults() throws IOException, SQLException {
        reading = new FileReading();
        list = new ArrayList<>();
        actionByDatabase = new DatabaseByAct();
        title = new ArrayList<>();
        list.clear();
        list.add(new CalcFile());
    }

    public void showResult() throws IOException {
        int x=1;
        for (int i = 0; i < 3; i++) {
            System.out.println("File " + x + "\n");
            BufferedReader bufferedReader = Files.newBufferedReader(reading.getPaths().get(i));
            for (ResultRepository resultRepository : list) {
                while (bufferedReader.ready()) {
                    String line = bufferedReader.readLine();

                    System.out.println("Longest word - " + resultRepository.longestLine(line));

                    System.out.println("Shortest word - " + resultRepository.shortestLine(line));

                    System.out.println("Line length - " + resultRepository.lineLength(line));

                    System.out.println("Average word - " + resultRepository.averageWord(line)+"\n");

                }
            }
            x++;
        }
    }

    public void insert() throws IOException {

        title.add("fileOne");
        title.add("fileTwo");
        title.add("fileThree");
        for(String insert:title){
            actionByDatabase.addToTableNamespace(insert);
        }
        int idTitle=1;
        int countLine;
        for (int i = 0; i < reading.getPaths().size(); i++) {
            countLine=1;
            BufferedReader bufferedReader = Files.newBufferedReader(reading.getPaths().get(i));
            for (ResultRepository resultRepository : list) {
                while (bufferedReader.ready()) {
                    String line = bufferedReader.readLine();
                    actionByDatabase.addToTableValues(idTitle,countLine,line,resultRepository.longestLine(line),
                            resultRepository.shortestLine(line),resultRepository.lineLength(line),resultRepository.averageWord(line));
                    countLine++;
                }
            }
            idTitle++;
        }



    }
}
