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
    private String      colNo;
    private int         colId;
    private JSONObject  message;
    private JSONArray   list;
    private String      colDetails;
    private String      teamOne;
    private String      teamTwo;
    private String      gameUniqueId;


    public SessionHandler() throws Exception {

        this.dbCon = SysConfig.dataSource.getConnection();
        DatabaseConfig.printDbStatus();

    }

    // --------------------------------------------


    public String getGameUniqueId() {
        return gameUniqueId;
    }

    public void setGameUniqueId(String gameUniqueId) {
        this.gameUniqueId = gameUniqueId;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(String teamOne) {
        this.teamOne = teamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
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

    public String getColDetails() {
        return colDetails;
    }

    public void setColDetails(String colDetails) {
        this.colDetails = colDetails;
    }

    public String getColNo() {
        return colNo;
    }

    public void setColNo(String colNo) {
        this.colNo = colNo;
    }

    public int getColId() {
        return colId;
    }

    public void setColId(int colId) {
        this.colId = colId;
    }
}


