package Server.Configurations;

import javax.sql.DataSource;

public class SysConfig {

    public static  int      Active          =   1;

    //Database
    public static String   userName         = "root";
    public static String   dbName           = "cricket";
    public static String   url              = "jdbc:mysql://localhost:3306/"+dbName;
    public static String   password         = "mysql";
    public static DataSource dataSource     = null;
    public static int max_connection        = 20;


    //server
    public static String    portProperty    = "server.port";
    public static String    port            = "2000";
    public static String    version         = "V_1.00.0";
    public static String    releaseDate     = "2019-01-01";


}
