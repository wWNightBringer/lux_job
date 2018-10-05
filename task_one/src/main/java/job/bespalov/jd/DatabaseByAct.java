package job.bespalov.jd;

import job.bespalov.repository.DataRepository;

import java.sql.ResultSet;
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
    public void addToTableValues(int idTitle, int numberLine, String line, String longestWord, String shortestWord, int lineLegth, int averageLengthWord) {
        try {
            statement.execute("CREATE TABLE IF NOT EXISTS job_lux.values_table " +
                    "(title_id INT(11) , number_line INT(11) ,line VARCHAR(45),longest_word VARCHAR(45),shortest_word VARCHAR(45)," +
                    "length_line INT (11),average_line INT (11), FOREIGN KEY (title_id) REFERENCES tablenamespace(ID_tile)) ");
            statement.execute("ALTER TABLE job_lux.values_table PACK_KEYS =0 CHECKSUM =0 DELAY_KEY_WRITE =0 AUTO_INCREMENT =1");
            statement.execute("INSERT INTO job_lux.values_table (title_id,number_line,line,longest_word,shortest_word,length_line,average_word) VALUES (" +
                    idTitle + "," + numberLine + ",'" + line + "','" + longestWord + "','" + shortestWord + "'," + lineLegth + "," + averageLengthWord + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addToTableNamespace(String title) {
        try {
            statement.execute("CREATE TABLE IF NOT EXISTS job_lux.tablenamespace (ID_title INT PRIMARY KEY AUTO_INCREMENT, " +
                    "title_file VARCHAR(45) UNIQUE)");
            statement.execute("ALTER TABLE job_lux.tablenamespace PACK_KEYS =0 CHECKSUM =0 DELAY_KEY_WRITE =0 AUTO_INCREMENT =1");
            statement.execute("INSERT INTO job_lux.tablenamespace (title_file) VALUES ('" +
                    title + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int getIdByTitle(String title) throws SQLException {
        String execute = String.format("SELECT ID_tile FROM tablenamespace WHERE title_file='%s'", title);
        ResultSet resultSet=statement.executeQuery(execute);
        resultSet.last();
        int id=resultSet.getInt("ID_tile");
        return id;
    }
}
