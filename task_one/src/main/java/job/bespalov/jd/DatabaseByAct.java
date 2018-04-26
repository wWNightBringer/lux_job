package job.bespalov.jd;

import job.bespalov.repository.DataRepository;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseByAct implements DataRepository {
    private Connection connecting;
    private Statement statement;

    public DatabaseByAct() throws SQLException {
        connecting = new Connection();
        statement = connecting.connectToDatabase().createStatement();
    }

    @Override
    public void addToTableValues(int idTitle,int numberLine,String line,String longestWord,String shortestWord,int lineLegth,int averageLengthWord) {
        try {
            statement.execute("ALTER TABLE job_lux.values_table PACK_KEYS =0 CHECKSUM =0 DELAY_KEY_WRITE =0 AUTO_INCREMENT =1");
            statement.execute("INSERT INTO job_lux.values_table (title_id,number_line,line,longest_word,shortest_word,length_line,average_word) VALUES (" +
                    idTitle+","+ numberLine +",'"+line+"','"+longestWord+"','"+shortestWord+"',"+lineLegth+","+averageLengthWord+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addToTableNamespace(String title) {
        try {

            statement.execute("ALTER TABLE job_lux.tablenamespace PACK_KEYS =0 CHECKSUM =0 DELAY_KEY_WRITE =0 AUTO_INCREMENT =1");
            statement.execute("INSERT INTO job_lux.tablenamespace (TitleFile) VALUES ('" +
                    title  + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
