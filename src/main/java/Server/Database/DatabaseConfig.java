package Server.Database;


import Server.Configurations.SysConfig;
import Server.LogHandler.LogWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;


public class DatabaseConfig {

    private static GenericObjectPool gPool = null;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    public static DataSource makeDBConnection() throws Exception {

        try {



            LogWriter.writeInfoFile("00000000000000000000000000000000", "Starting Database Connection");
            LogWriter.writeInfoFile("00000000000000000000000000000000", "Database: " + SysConfig.dbName);
            LogWriter.writeInfoFile("00000000000000000000000000000000", "User    : " + SysConfig.userName);
            LogWriter.writeInfoFile("00000000000000000000000000000000", "URL     : " + SysConfig.url);


            Class.forName(JDBC_DRIVER);
            gPool = new GenericObjectPool();
            gPool.setMaxActive(5);

            ConnectionFactory cf = new DriverManagerConnectionFactory(SysConfig.dbName, SysConfig.userName, SysConfig.url);
            PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, gPool, null, null, false, true);


            DataSource ds = new PoolingDataSource(gPool);
            Connection connObj = ds.getConnection();


            return new PoolingDataSource(gPool);

        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static GenericObjectPool getConnectionPool() {
        return gPool;
    }

    public static void printDbStatus() {
        System.out.println("Max.: " + getConnectionPool().getMaxActive() + "; Active: " + getConnectionPool().getNumActive() + "; Idle: " + getConnectionPool().getNumIdle());
    }


}
