package Server.Util;

import java.sql.Connection;


public class SessionHandler {

    private static Connection  dbCon;
    private static String      gameId;
    private static String      gameDate;



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


