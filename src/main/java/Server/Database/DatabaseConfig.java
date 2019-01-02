package Server.Database;


import Server.Util.LogHandler;
import Server.Util.SessionHandler;

import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConfig {

    private static String userName   = "root";
    private static String dbName     = "cricket";
    private static String url        = "jdbc:mysql://localhost:3306/"+dbName;
    private static String password   = "mysql";


    public static void makeJDBCConnection(SessionHandler s) throws Exception {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        try {

            LogHandler.writeInfoFile("00000000000000000000000000000000","Starting Database Connection");
            LogHandler.writeInfoFile("00000000000000000000000000000000","Database: "+dbName);
            LogHandler.writeInfoFile("00000000000000000000000000000000","User    : "+userName);
            LogHandler.writeInfoFile("00000000000000000000000000000000","URL     : "+url);
            s.setDbCon(DriverManager.getConnection(url,userName,password));

            LogHandler.writeInfoFile("00000000000000000000000000000000","Database connected successfully");

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

    }

}
