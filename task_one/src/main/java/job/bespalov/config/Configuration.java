package job.bespalov.config;

import job.bespalov.statistic.ListResults;

import java.io.IOException;
import java.sql.SQLException;

public class Configuration {
    private ListResults listResults;

    public Configuration() throws IOException, SQLException {
        listResults = new ListResults();
    }

    public void enableConfig() throws IOException, SQLException {
        if (!listResults.showResult()) {
            System.out.println("Incorrect name file!");
        }
    }


}
