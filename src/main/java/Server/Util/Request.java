package Server.Util;

import java.io.Serializable;

public class Request implements Serializable {

    private String   gameId;
    private String   colNo;
    private String   colDetails;
    private int      colId;
    private String   teamOne;
    private String   teamTwo;
    private String   gameDate;


    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
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

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
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

    public String getColNo() {
        return colNo;
    }

    public void setColNo(String colNo) {
        this.colNo = colNo;
    }
}
