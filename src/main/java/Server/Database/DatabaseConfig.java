package Server.Database;


import Server.Util.SessionHandler;

import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConfig {

    private static String userName   = "root";
    private static String url        = "jdbc:mysql://localhost:3306/cricket";// with database
    private static String password   = "root";


    public static void makeJDBCConnection(SessionHandler s) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        try {
            s.setDbCon(DriverManager.getConnection(url,userName,password));

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

    }

}
