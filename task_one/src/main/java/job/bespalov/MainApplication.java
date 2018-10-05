package job.bespalov;

import java.io.IOException;

import job.bespalov.config.Configuration;
import job.bespalov.statistic.ListResults;

import java.sql.SQLException;

public class MainApplication {
    private static Configuration configuration;

    public static void main(String[] args) throws IOException, SQLException {
        configuration = new Configuration();
        configuration.enableConfig();
    }
}
