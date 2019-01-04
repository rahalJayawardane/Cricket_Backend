package Server.Util;

import java.io.Serializable;

public class Request implements Serializable {

    private String   gameId;
    private int      colNo;


    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public int getColNo() {
        return colNo;
    }

    public void setColNo(int colNo) {
        this.colNo = colNo;
    }
}
