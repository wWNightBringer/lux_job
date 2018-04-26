package job.bespalov.jd;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private final String CONNECT = "jdbc:mysql://localhost:3306/job_lux";
    private final String LOGIN = "root";
    private final String PASSWORD = "root";

    public java.sql.Connection connectToDatabase() {
        java.sql.Connection connection = null;
        try {
            connection = DriverManager.getConnection(CONNECT, LOGIN, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
