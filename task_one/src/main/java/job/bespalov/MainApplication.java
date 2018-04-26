package job.bespalov;

import java.io.IOException;
import job.bespalov.statistic.ListResults;
import java.sql.SQLException;

public class MainApplication {
    private static ListResults listResults;

    public static void main(String[] args) throws IOException, SQLException {
        listResults = new ListResults();
      /*  listResults.insert();*/
        listResults.showResult();



    }
}
