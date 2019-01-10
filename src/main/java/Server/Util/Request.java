package Server.Util;

import java.io.Serializable;

public class Request implements Serializable {

    private String   gameId;
    private int      colNo;
    private String   colDetails;
    private int      colId;


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

    public String getColDetails() {
        return colDetails;
    }

    public void setColDetails(String colDetails) {
        this.colDetails = colDetails;
    }

    public int getColId() {
        return colId;
    }

    public void setColId(int colId) {
        this.colId = colId;
    }
}
