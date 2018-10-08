package job.bespalov.statistic;

import job.bespalov.calc.InformationAboutLine;
import job.bespalov.jd.DatabaseByAct;
import job.bespalov.repository.ResultRepository;


import java.io.BufferedReader;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListResults {
    private FileReading reading;
    private List<ResultRepository> list;
    private List<String> titles;
    private DatabaseByAct actionByDatabase;


    public ListResults() throws IOException, SQLException {
        reading = new FileReading();
        list = new ArrayList<>();
        titles = new ArrayList<>();
        actionByDatabase = new DatabaseByAct();
        list.clear();
        list.add(new InformationAboutLine());
    }

    public boolean showResult() throws IOException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you wish see result `1` or add new file to database `2`: ");
        String number = scanner.nextLine();
        if (number.equalsIgnoreCase("1")) {
            System.out.print("Enter the file name: ");
            String title = scanner.nextLine();
            reading.moveWithFile(title);
            for (Path path : reading.getPaths()) {
                BufferedReader bufferedReader = Files.newBufferedReader(path);
                for (ResultRepository resultRepository : list) {
                    while (bufferedReader.ready()) {
                        String line = bufferedReader.readLine();

                        System.out.println("Longest word - " + resultRepository.getLongestWord(line));

                        System.out.println("Shortest word - " + resultRepository.getShortestWord(line));

                        System.out.println("Line length - " + resultRepository.getLengthWord(line));

                        System.out.println("Average word - " + resultRepository.getAverageWord(line) + "\n");

                    }
                }
            }
            return true;
        }
        if (number.equalsIgnoreCase("2")) {
            System.out.print("Enter the new file name: ");
            String title = scanner.nextLine();
            actionByDatabase.addToTableNamespace(title);
            insert(title);
            return true;
        }

        return false;
    }

    public void insert(String title) throws IOException, SQLException {
        int countLine;
        reading.moveWithFile(title);
        for (Path path : reading.getPaths()) {
            countLine = 1;
            BufferedReader bufferedReader = Files.newBufferedReader(path);
            for (ResultRepository resultRepository : list) {
                while (bufferedReader.ready()) {
                    String line = bufferedReader.readLine();
                    actionByDatabase.addToTableValues(actionByDatabase.getIdByTitle(title), countLine, line, resultRepository.getLongestWord(line),
                            resultRepository.getShortestWord(line), resultRepository.getLengthWord(line), resultRepository.getAverageWord(line));
                    countLine++;
                }
            }
        }


    }

}
