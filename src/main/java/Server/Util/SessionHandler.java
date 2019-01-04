package Server.Util;

import Server.Configurations.SysConfig;
import Server.Database.DatabaseConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.Connection;


public class SessionHandler {

    private Connection  dbCon;
    private String      gameId;
    private String      gameDate;
    private String      requestId;
    private int         colNo;
    private JSONObject  message;
    private JSONArray   list;


    public SessionHandler() throws Exception {

        if(SysConfig.dataSource != null){
            System.out.println("no null");
            DatabaseConfig.printDbStatus();
            System.out.println(SysConfig.dataSource);
        }else {
            System.out.println("null");
        }

        this.dbCon = SysConfig.dataSource.getConnection();
        DatabaseConfig.printDbStatus();

    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getColNo() {
        return colNo;
    }

    public void setColNo(int colNo) {
        this.colNo = colNo;
    }

    public JSONArray getList() {
        return list;
    }

    public void setList(JSONArray list) {
        this.list = list;
    }

    public JSONObject getMessage() {
        return message;
    }

    public void setMessage(JSONObject message) {
        this.message = message;
    }

    public Connection getDbCon() {
        return dbCon;
    }

    public void setDbCon(Connection dbCon) {
        this.dbCon = dbCon;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }
}


