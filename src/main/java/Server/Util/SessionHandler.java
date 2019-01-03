package Server.Util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.Connection;


public class SessionHandler {

    private static Connection  dbCon;
    private static String      gameId;
    private static String      gameDate;
    private static int         colNo;
    private static JSONObject  message;
    private static JSONArray   list;


    public static int getColNo() {
        return colNo;
    }

    public static void setColNo(int colNo) {
        SessionHandler.colNo = colNo;
    }

    public static JSONArray getList() {
        return list;
    }

    public static void setList(JSONArray list) {
        SessionHandler.list = list;
    }

    public static JSONObject getMessage() {
        return message;
    }

    public static void setMessage(JSONObject message) {
        SessionHandler.message = message;
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


